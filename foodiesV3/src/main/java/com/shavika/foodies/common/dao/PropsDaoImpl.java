package com.shavika.foodies.common.dao;

import org.springframework.stereotype.Repository;

import com.shavika.foodies.api.dao.BaseDaoImpl;
import com.shavika.foodies.api.dto.Props;
import com.shavika.foodies.api.dto.SyncDashBoard;
import com.shavika.foodies.api.exception.ShavikaAppException;

@Repository("PropsDao")
public class PropsDaoImpl extends BaseDaoImpl<Props> implements PropsDao {

}