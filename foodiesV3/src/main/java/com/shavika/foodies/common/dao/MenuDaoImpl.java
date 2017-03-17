package com.shavika.foodies.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shavika.foodies.api.dao.BaseDaoImpl;
import com.shavika.foodies.api.dto.Menus;
import com.shavika.foodies.api.exception.ShavikaAppException;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<Menus> implements MenuDao {

	@Override
	public List<Menus> isRecordExist(Menus menus) throws ShavikaAppException {
		return (List<Menus>) getSession().getNamedQuery(IS_MENU_EXIST).setInteger(0, menus.getMenutypeid())
				.setLong(1, menus.getUnique_id()).list();
	}

	@Override
	public List<Menus> findMenuByUniqueId(long uniqueId) throws ShavikaAppException {
		return (List<Menus>) getSession().getNamedQuery(GET_MENU_BY_UNIQUEID).setLong(0, uniqueId).list();
	}

	@Override
	public long getLatestMenu() throws ShavikaAppException {
		List<Menus> menusList =  (List<Menus>) getSession().getNamedQuery(GET_LATEST_MENU).setMaxResults(1).list();
		return (menusList.size() > 0) ? menusList.get(0).getUnique_id() : 0;
	}
}
