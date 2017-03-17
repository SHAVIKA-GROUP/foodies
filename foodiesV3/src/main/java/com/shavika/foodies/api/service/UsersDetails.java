package com.shavika.foodies.api.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class UsersDetails extends UserInfo {

	private static final long serialVersionUID = 1L;

	private String userNo;

	public UsersDetails(String userName, String password, String userRole, int userRoleIdval, String admissionNoVal, boolean isActive, boolean accountNonLocked,
			List<GrantedAuthority> grantedAuthority) {
		super(userName, password, userRole, userRoleIdval, isActive, accountNonLocked, grantedAuthority);

		this.userNo = admissionNoVal;
	}

	public String getManagerNo() {
		return userNo;
	}

	public void setManagerNo(String managerNo) {
		this.userNo = managerNo;
	}

	@Override
	public void clear() {
		this.userNo = "0";

	}

	@Override
	public String getUserLevelIdentifier() {
		return this.userNo;
	}

	@Override
	public String toString() {
		return "UsersDetails [userNo=" + userNo + "]";
	}

}
