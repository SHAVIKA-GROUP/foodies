package com.shavika.foodies.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shavika.foodies.api.dto.Props;
import com.shavika.foodies.api.dto.SyncDashBoard;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.common.dao.PropsDao;

@Service("propsService")
public class PropsServiceImpl implements PropsService {

	@Autowired
	private PropsDao propsDao;

	@Transactional(readOnly = true)
	@Override
	public SyncDashBoard getSyncDashboard() throws ShavikaAppException {
		SyncDashBoard syncDashBoard = new SyncDashBoard();
		List<Props> propsList = propsDao.findAll(Props.class);
		for (Props _props : propsList) {
			if (_props.getProp_key().equals("MENU_BLOCK")) {
				syncDashBoard.setService(_props.getProp_key());
				syncDashBoard.setSize(Integer.valueOf(_props.getProps_value()));
			}
		}
		return syncDashBoard;
	}

	@Override
	public Props updateSyncDashboard() throws ShavikaAppException {
		List<Props> propsList = propsDao.findAll(Props.class);
		for (Props _props : propsList) {
			if (_props.getProp_key().equals("MENU_BLOCK")) {
				String status = _props.getProps_value().equals("1") ? "2" : "1";
				_props.setProps_value(status);
				propsDao.update(_props);
				return _props;
			}
		}
		return null;
	}

	@Override
	public List<Props> getAllProperties() throws ShavikaAppException {
		return propsDao.findAll(Props.class);
	}

}
