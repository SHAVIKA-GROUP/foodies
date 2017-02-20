package com.shavika.foodies.dao;

import java.util.List;

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
	public List<Orders> getOrderByCustomer(long customerId) throws ShavikaAppException {
		return (List<Orders>) getSession().getNamedQuery(GET_ORDERS_BY_CUSTOMER).setLong(0, customerId).list();
	}
}
