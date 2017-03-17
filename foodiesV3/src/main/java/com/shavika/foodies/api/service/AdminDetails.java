package com.shavika.foodies.api.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class AdminDetails extends UserInfo {

	private static final long serialVersionUID = 1L;

	private String administratorNo;

	public AdminDetails(String userName, String password, String userRole, int userRoleIdval, String registrationNoVal, boolean isActive, boolean accountNotLocked,
			List<GrantedAuthority> grantedAuthority) {
		super(userName, password, userRole, userRoleIdval, isActive, accountNotLocked, grantedAuthority);
		this.administratorNo = registrationNoVal;
	}

	@Override
	public void clear() {
		this.administratorNo = "0";
	}

	@Override
	public String getUserLevelIdentifier() {
		return this.administratorNo;
	}
}
