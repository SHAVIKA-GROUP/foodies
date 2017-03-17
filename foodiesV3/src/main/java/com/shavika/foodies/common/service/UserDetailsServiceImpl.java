package com.shavika.foodies.common.service;

import static com.shavika.foodies.api.enums.UserRole.ROLE_ADMIN;
import static com.shavika.foodies.api.enums.UserRole.ROLE_MANAGER;
import static com.shavika.foodies.api.enums.UserRole.ROLE_USER;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shavika.foodies.api.dto.Privilege;
import com.shavika.foodies.api.dto.Roles;
import com.shavika.foodies.api.dto.UserLogin;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.api.service.AdminDetails;
import com.shavika.foodies.api.service.ManagerDetails;
import com.shavika.foodies.api.service.UserUnknownRoleDetails;
import com.shavika.foodies.api.service.UsersDetails;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final int MAX_LOGIN_COUNT = 3;
	private static final String USER_NOT_FOUND = "user not found";

	@Autowired
	private UserService userService;

	static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String usermail) throws UsernameNotFoundException {
		try {
			UserLogin userLogin = this.userService.getUserLoginByName(usermail);
			if (userLogin == null) {
				throw new UsernameNotFoundException(USER_NOT_FOUND);
			}
			return buildUserFromUserEntity(userLogin);
		} catch (ShavikaAppException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional(readOnly = true)
	User buildUserFromUserEntity(UserLogin userLogin) throws ShavikaAppException {
		User systemUser = null;

		String username = userLogin.getUsername();
		String useremail = userLogin.getEmail();
		int userRoleId = (int) userLogin.getRoles().getId();
		String password = userLogin.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		boolean enabled = userLogin.isStatus();
		boolean accountNotLocked = true;
		String userRole = "";

		accountNotLocked = (userLogin.getLoginAttempts() >= MAX_LOGIN_COUNT) ? false : true;

		Roles userRoles = null;
		List authorities = new ArrayList();
		try {
			userRoles = this.userService.findUserRole(userRoleId);

			for (Privilege privilegeObj : userRoles.getPrivileges())
				authorities.add(new SimpleGrantedAuthority(privilegeObj.getName()));
		} catch (ShavikaAppException e) {
			e.printStackTrace();
		}

		if (userLogin.getRoles().getId() == ROLE_ADMIN.getUserRoleId()) {
			userRole = ROLE_ADMIN.toString();
			systemUser = new AdminDetails(username, encodedPassword, userRole, userRoleId, userLogin.getUserIdentificationNo(), enabled, accountNotLocked, authorities);
		} else if (userLogin.getRoles().getId() == ROLE_MANAGER.getUserRoleId()) {
			userRole = ROLE_MANAGER.toString();
			systemUser = new ManagerDetails(username, encodedPassword, userRole, userRoleId, userLogin.getUserIdentificationNo(), enabled, accountNotLocked,
					authorities);
		} else if (userLogin.getRoles().getId() == ROLE_USER.getUserRoleId()) {
			userRole = ROLE_USER.toString();
			systemUser = new UsersDetails(username, encodedPassword, userRole, userRoleId, userLogin.getUserIdentificationNo(), enabled, accountNotLocked, authorities);
		} else {
			userRole = userRoles.getRole();
			systemUser = new UserUnknownRoleDetails(username, encodedPassword, userRole, userRoleId, enabled, accountNotLocked, authorities);
		}
		return systemUser;
	}
}
