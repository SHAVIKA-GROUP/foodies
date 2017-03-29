package com.shavika.foodies.common.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shavika.foodies.api.dto.Menus;
import com.shavika.foodies.api.dto.PojoMenuDetail;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.common.dao.MenuDao;
import com.shavika.foodies.common.utilities.Constants;
import com.shavika.foodies.common.utilities.DateTimeUtil;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Transactional(readOnly = true)
	@Override
	public List<Menus> getAllMenus() throws ShavikaAppException {
		return menuDao.findAll(Menus.class);
	}

	@Transactional(readOnly = true)
	@Override
	public Menus insertMenu(Menus menu) throws ShavikaAppException {
		menu.setUnique_id(DateTimeUtil.getFormatedDateByFoodies(menu.getDate()));
		menu.setCreated_on(DateTimeUtil.getMillis());
		menu.setModified_on(DateTimeUtil.getMillis());
		return menuDao.save(menu);
	}

	@Transactional(readOnly = true)
	@Override
	public void updateMenu(Menus menu) throws ShavikaAppException {
		menu.setModified_on(DateTimeUtil.getMillis());
		menuDao.update(menu);
	}

	@Transactional(readOnly = true)
	@Override
	public void delete(Menus menu) throws ShavikaAppException {
		menuDao.delete(menu);
	}

	@Transactional(readOnly = true)
	@Override
	public Menus getMenuById(long id) throws ShavikaAppException {
		return (Menus) menuDao.find(Menus.class, id);
	}

	@Override
	public Menus parseMenuByPojo(PojoMenuDetail pojoMenuDetail, String rootDirectory) throws ShavikaAppException {
		Menus menus = new Menus();
		menus.setMenutypeid(pojoMenuDetail.getMenutypeid());
		menus.setUnique_id(pojoMenuDetail.getUnique_id());
		menus.setDate(pojoMenuDetail.getDate());
		if (pojoMenuDetail.getMenutypeid() == 1) {
			menus.setTitle(pojoMenuDetail.getBfst_title());
			menus.setSubtitle(pojoMenuDetail.getBfst_subtitle());
			menus.setDescription(pojoMenuDetail.getBfst_description());
			menus.setPrice(pojoMenuDetail.getBfst_price());
			menus.setImage(Constants.getImageFileByUniqueid(pojoMenuDetail.getUnique_id() + Constants.IMG_FILE_SUFFIX_BREAKFAST,rootDirectory));
		} else if (pojoMenuDetail.getMenutypeid() == 2) {
			menus.setTitle(pojoMenuDetail.getLuch_title());
			menus.setSubtitle(pojoMenuDetail.getLuch_subtitle());
			menus.setDescription(pojoMenuDetail.getLuch_description());
			menus.setPrice(pojoMenuDetail.getLuch_price());
			menus.setImage(Constants.getImageFileByUniqueid(pojoMenuDetail.getUnique_id() + Constants.IMG_FILE_SUFFIX_LUNCH,rootDirectory));
		} else if (pojoMenuDetail.getMenutypeid() == 3) {
			menus.setTitle(pojoMenuDetail.getDinr_title());
			menus.setSubtitle(pojoMenuDetail.getDinr_subtitle());
			menus.setDescription(pojoMenuDetail.getDinr_description());
			menus.setPrice(pojoMenuDetail.getDinr_price());
			menus.setImage(Constants.getImageFileByUniqueid(pojoMenuDetail.getUnique_id() + Constants.IMG_FILE_SUFFIX_DINNER,rootDirectory));
		}
		menus.setCreated_on(DateTimeUtil.getMillis());
		menus.setModified_on(menus.getCreated_on());
		menus.setIs_deleted(0);
		return menus;
	}

	@Override
	public List<Menus> insertRUpdateMenu(Menus menu) throws ShavikaAppException {
		List<Menus> menuList = menuDao.isRecordExist(menu);
		if (menuList.isEmpty() || menuList.size() == 0) {
			menuDao.save(menu);
		} else {
			Menus _menu = (Menus) menuList.get(0);
			menu.setId(_menu.getId());
			menu.setModified_on(DateTimeUtil.getMillis());
			menuDao.update(menu);
		}
		return menuDao.findMenuByUniqueId(menu.getUnique_id());
	}

	@Override
	public PojoMenuDetail parseMenuByPojo(List<Menus> menuList) throws ShavikaAppException {
		PojoMenuDetail pojoMenuDetail = new PojoMenuDetail();
		for (Menus menu : menuList) {
			pojoMenuDetail.setMenutypeid(menu.getMenutypeid());
			pojoMenuDetail.setUnique_id(menu.getUnique_id());
			pojoMenuDetail.setDate(menu.getDate());
			if (menu.getMenutypeid() == 1) {
				pojoMenuDetail.setBfst_id(menu.getId());
				pojoMenuDetail.setBfst_title(menu.getTitle());
				pojoMenuDetail.setBfst_subtitle(menu.getSubtitle());
				pojoMenuDetail.setBfst_description(menu.getDescription());
				pojoMenuDetail.setBfst_price(menu.getPrice());
				pojoMenuDetail
						.setBfst_image((null != menu.getImage() || !menu.getImage().equals(Constants.NOT_APPLICABLE))
								? menu.getImage() : Constants.NOT_APPLICABLE);
			} else if (menu.getMenutypeid() == 2) {
				pojoMenuDetail.setLuch_id(menu.getId());
				pojoMenuDetail.setLuch_title(menu.getTitle());
				pojoMenuDetail.setLuch_subtitle(menu.getSubtitle());
				pojoMenuDetail.setLuch_description(menu.getDescription());
				pojoMenuDetail.setLuch_price(menu.getPrice());
				pojoMenuDetail
						.setLuch_image((null != menu.getImage() || !menu.getImage().equals(Constants.NOT_APPLICABLE))
								? menu.getImage() : Constants.NOT_APPLICABLE);
			} else if (menu.getMenutypeid() == 3) {
				pojoMenuDetail.setDinr_id(menu.getId());
				pojoMenuDetail.setDinr_title(menu.getTitle());
				pojoMenuDetail.setDinr_subtitle(menu.getSubtitle());
				pojoMenuDetail.setDinr_description(menu.getDescription());
				pojoMenuDetail.setDinr_price(menu.getPrice());
				pojoMenuDetail
						.setDinr_image((null != menu.getImage() || !menu.getImage().equals(Constants.NOT_APPLICABLE))
								? menu.getImage() : Constants.NOT_APPLICABLE);
			}
		}
		return pojoMenuDetail;
	}

	@Override
	public List<Menus> getMenuByUniqueId(long uniqueId) throws ShavikaAppException {
		return menuDao.findMenuByUniqueId(uniqueId);
	}

	@Override
	public List<PojoMenuDetail> getAllPojoMenus() throws ShavikaAppException {
		List<PojoMenuDetail> returnList = new ArrayList<PojoMenuDetail>();
		List<Menus> menuList = menuDao.findAll(Menus.class);
		Map<Long, List<Menus>> menuMap = new HashMap<Long, List<Menus>>();
		for (Menus fd : menuList) {
			long Key = fd.getUnique_id();
			List<Menus> fds = (menuMap.containsKey(Key)) ? menuMap.get(Key) : new ArrayList<Menus>();
			fds.add(fd);
			menuMap.put(Key, fds);
		}

		for (Map.Entry<Long, List<Menus>> map_1 : menuMap.entrySet()) {
			returnList.add(this.parseMenuByPojo(map_1.getValue()));
		}
		return returnList;
	}

	@Override
	public PojoMenuDetail getSyncDashboard() throws ShavikaAppException {
		List<Menus> menuList = menuDao.findMenuByUniqueId(menuDao.getLatestMenu());
		return parseMenuByPojo(menuList);
	}

	@Override
	public List<Map<String, byte[]>> getmenuImages(String uniqueIds) throws ShavikaAppException {
		List<Map<String, byte[]>> menuimageList = new ArrayList<Map<String, byte[]>>();
		String _syncMenus = uniqueIds;
		if (null != _syncMenus || _syncMenus.length() > 0) {
			String[] syncMneusArry = _syncMenus.split("@");
			for (String uniqueid : syncMneusArry) {
				//menusList.addAll(menuService.getMenuByUniqueId(Long.valueOf(uniqueid)));
				
			}
		}
		return menuimageList;
	}
}
