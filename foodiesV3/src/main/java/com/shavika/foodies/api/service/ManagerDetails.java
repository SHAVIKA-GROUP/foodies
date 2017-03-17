package com.shavika.foodies.api.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class ManagerDetails extends UserInfo {
	private static final long serialVersionUID = 1L;

	private String managerNo;

	public ManagerDetails(String userName, String password, String userRole, int userRoleIdval, String admissionNoVal, boolean isActive, boolean accountNonLocked,
			List<GrantedAuthority> grantedAuthority) {
		super(userName, password, userRole, userRoleIdval, isActive, accountNonLocked, grantedAuthority);

		this.managerNo = admissionNoVal;
	}

	public String getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
	}

	@Override
	public void clear() {
		this.managerNo = "0";

	}

	@Override
	public String getUserLevelIdentifier() {
		return this.managerNo;
	}

	@Override
	public String toString() {
		return "ManagerDetails [managerNo=" + managerNo + "]";
	}

}
