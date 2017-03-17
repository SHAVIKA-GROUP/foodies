package com.shavika.foodies.common.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.shavika.foodies.api.dao.BaseDaoImpl;
import com.shavika.foodies.api.dto.Roles;
import com.shavika.foodies.api.exception.ShavikaAppException;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Roles>implements RoleDao {

	@SuppressWarnings("unchecked")
	public Roles getUserRoleByRoleName(String role) throws ShavikaAppException {
		Roles roles = null;
		try {
			List<Roles> userRoleList = getSession().getNamedQuery(GET_USER_ROLE_BY_ROLE_NAME).setString(0, role).list();
			if (!userRoleList.isEmpty())
				roles = userRoleList.get(0);
		} catch (DataAccessException e) {
			throw new ShavikaAppException("GEN.DB.INVALID.OPERATION.ADD", e);
		}
		return roles;
	}

	@SuppressWarnings("unchecked")
	public Roles getUserRoleByRoleId(int roleId) throws ShavikaAppException {
		Roles roles = null;
		try {
			List<Roles> roleList = getSession().getNamedQuery(GET_USER_ROLE_BY_ROLE_ID).setInteger(0, roleId).list();
			if (!roleList.isEmpty())
				roles = roleList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
	}

}
