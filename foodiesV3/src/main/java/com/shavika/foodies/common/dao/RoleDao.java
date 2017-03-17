package com.shavika.foodies.common.dao;

import com.shavika.foodies.api.dao.BaseDao;
import com.shavika.foodies.api.dto.Roles;
import com.shavika.foodies.api.exception.ShavikaAppException;

public abstract interface RoleDao extends BaseDao<Roles> {

	public static final String GET_USER_ROLE_BY_ROLE_NAME = "getUserRoleByRoleName";
	public static final String GET_USER_ROLE_BY_ROLE_ID = "getUserRoleById";

	public abstract Roles getUserRoleByRoleName(String paramString) throws ShavikaAppException;

	public abstract Roles getUserRoleByRoleId(int paramString) throws ShavikaAppException;
}
