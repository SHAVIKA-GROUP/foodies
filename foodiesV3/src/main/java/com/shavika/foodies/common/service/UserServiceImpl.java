package com.shavika.foodies.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shavika.foodies.api.dto.Privilege;
import com.shavika.foodies.api.dto.Roles;
import com.shavika.foodies.api.dto.UserLogin;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.common.dao.PrivilegeDao;
import com.shavika.foodies.common.dao.RoleDao;
import com.shavika.foodies.common.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PrivilegeDao privilegeDao;

	@Transactional(readOnly = true)
	@Override
	public UserLogin getUserLoginByName(String userName) throws ShavikaAppException {
		return this.userDao.getAnyUserLoginByName(userName);
	}

	@Transactional(readOnly = true)
	@Override
	public UserLogin getUserLoginByEmail(String userEmail) throws ShavikaAppException {
		return this.userDao.getUserLoginByEmail(userEmail);
	}

	@Transactional(readOnly = true)
	@Override
	public Roles findUserRole(int userRoleId) throws ShavikaAppException {
		return (Roles) this.roleDao.getUserRoleByRoleId(userRoleId);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Privilege> getPrivilegesByUserRole(Roles userRole) throws ShavikaAppException {
		return privilegeDao.getPrivilegesByUserRole(userRole);
	}

	@Transactional(readOnly = true)
	@Override
	public UserLogin getUserLoginById(long id) throws ShavikaAppException {
		return (UserLogin) userDao.find(UserLogin.class, id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<UserLogin> getAllUserLogin() throws ShavikaAppException {
		return userDao.findAll(UserLogin.class);
	}

	@Override
	public UserLogin insertUser(UserLogin userLogin) throws ShavikaAppException {
		return userDao.save(userLogin);
	}

	@Override
	public void updateUser(UserLogin userLogin) throws ShavikaAppException {
		userDao.update(userLogin);
	}

	@Override
	public void delete(UserLogin userLogin) throws ShavikaAppException {
		userDao.delete(userLogin);
	}
}
