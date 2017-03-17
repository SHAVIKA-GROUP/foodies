package com.shavika.foodies.api.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public abstract class UserInfo extends User {

	private static final long serialVersionUID = 1L;
	private int userId;
	private int userRoleId;
	private String userRole;
	private String defaultUserHomeUrl;

	public UserInfo(String userName, String password, String userRoleVal, int userRoleIdval, boolean isActive, boolean accountNotLocked,
			List<GrantedAuthority> grantedAuthority) {
		super(userName, password, isActive, isActive, isActive, accountNotLocked, grantedAuthority);
		this.userRole = userRoleVal;
		this.userRoleId = userRoleIdval;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getDefaultUserHomeUrl() {
		return defaultUserHomeUrl;
	}

	public void setDefaultUserHomeUrl(String defaultUserHomeUrl) {
		this.defaultUserHomeUrl = defaultUserHomeUrl;
	}

	public abstract void clear();

	public abstract String getUserLevelIdentifier();

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userRoleId=" + userRoleId + ", userRole=" + userRole + ", defaultUserHomeUrl=" + defaultUserHomeUrl + "]";
	}

}
