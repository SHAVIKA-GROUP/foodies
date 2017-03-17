package com.shavika.foodies.api.enums;

public enum UserRole {

	ROLE_ADMIN(1), ROLE_MANAGER(2), ROLE_USER(3);

	private int userRoleId;

	private UserRole(int intUserRoleId) {
		this.userRoleId = intUserRoleId;
	}

	public int getUserRoleId() {
		return this.userRoleId;
	}

}
