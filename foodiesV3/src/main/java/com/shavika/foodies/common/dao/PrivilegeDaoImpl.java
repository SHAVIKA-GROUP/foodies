package com.shavika.foodies.common.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.shavika.foodies.api.dao.BaseDaoImpl;
import com.shavika.foodies.api.dto.Privilege;
import com.shavika.foodies.api.dto.Roles;
import com.shavika.foodies.api.exception.ShavikaAppException;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege>implements PrivilegeDao {

	private static final String GET_PRIVILEGES_BY_USER_ROLE = "getPrivilegesByUserRole";
	private static final Logger LOG = Logger.getLogger(PrivilegeDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<Privilege> getPrivilegesByUserRole(Roles userRole) throws ShavikaAppException {
		try {
			// return getHibernateTemplate().findByNamedQuery(GET_PRIVILEGES_BY_USER_ROLE, userRole);
			// return getSession().createQuery(GET_PRIVILEGES_BY_USER_ROLE).setProperties(userRole.getId()).list();
			return null;
		} catch (DataAccessException e) {
			LOG.error("error occured while searching the object-->" + e.toString());
			throw new ShavikaAppException("GEN.DB.CONN.ERROR", e);
		}
	}
}