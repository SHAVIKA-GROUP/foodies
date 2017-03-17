package com.shavika.foodies.common.dao;

import java.util.List;

import com.shavika.foodies.api.dao.BaseDao;
import com.shavika.foodies.api.dto.Privilege;
import com.shavika.foodies.api.dto.Roles;
import com.shavika.foodies.api.exception.ShavikaAppException;

public abstract interface PrivilegeDao extends BaseDao<Privilege> {

	public abstract List<Privilege> getPrivilegesByUserRole(Roles paramUserRole) throws ShavikaAppException;

}
