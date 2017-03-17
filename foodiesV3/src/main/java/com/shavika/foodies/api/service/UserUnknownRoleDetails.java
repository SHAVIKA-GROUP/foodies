package com.shavika.foodies.api.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class UserUnknownRoleDetails extends UserInfo {
	private static final long serialVersionUID = 1L;

	public UserUnknownRoleDetails(String userName, String password, String userRole, int userRoleIdval, boolean isActive, boolean accountNonLocked,
			List<GrantedAuthority> grantedAuthority) {
		super(userName, password, userRole, userRoleIdval, isActive, accountNonLocked, grantedAuthority);
	}

	public void clear() {
	}

	public String getUserLevelIdentifier() {
		return "";
	}

	public String toString() {
		return null;
	}
}
