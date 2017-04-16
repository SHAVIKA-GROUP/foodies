package com.shavika.foodies.common.service;

import java.util.List;

import com.shavika.foodies.api.dto.Props;
import com.shavika.foodies.api.dto.SyncDashBoard;
import com.shavika.foodies.api.exception.ShavikaAppException;

public abstract interface PropsService {

	public abstract SyncDashBoard getSyncDashboard() throws ShavikaAppException;
	
	public abstract Props updateSyncDashboard() throws ShavikaAppException;
	
	public abstract List<Props> getAllProperties() throws ShavikaAppException;
}
