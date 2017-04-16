package com.shavika.foodies.common.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.shavika.foodies.api.dao.BaseDaoImpl;
import com.shavika.foodies.api.dto.Orders;
import com.shavika.foodies.api.exception.ShavikaAppException;

@Repository("ordersDao")
public class OrdersDaoImpl extends BaseDaoImpl<Orders> implements OrdersDao {

	@Override
	public List<Orders> getOrderByStatus() throws ShavikaAppException {
		return (List<Orders>) getSession().getNamedQuery(GET_ORDERS_WITHOUT_RECEIVED).list();
	}

	@Override
	public List<Orders> getOrderByItemId(long orderItemId) throws ShavikaAppException {
		return getSession().getNamedQuery(GET_ORDERS_BY_ITEMID).setLong(0, orderItemId).list();
	}

	@Override
	public List<Orders> getOrderByItemIds(List<Long> orderItemIdlist) throws ShavikaAppException {
		return getSession().getNamedQuery(GET_ORDERS_BY_ITEMIDS).setParameter(0, orderItemIdlist).list();
	}

	@Override
	public List<Orders> getOrderByCustomer(long customerId) throws ShavikaAppException {
		return (List<Orders>) getSession().getNamedQuery(GET_ORDERS_BY_CUSTOMER).setLong(0, customerId).list();
	}

	@Override
	public List<Orders> getCountofOrderStatus(String status) throws ShavikaAppException {
		return (List<Orders>) getSession().getNamedQuery(GET_ORDERS_SYNC_ORDERS).setString(0, status).list();
	}
}
