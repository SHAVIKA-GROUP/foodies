package com.shavika.foodies.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shavika.foodies.api.dao.BaseDaoImpl;
import com.shavika.foodies.api.dto.OrderItem;
import com.shavika.foodies.api.exception.ShavikaAppException;

@Repository("orderItemsDao")
public class OrderItemsDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemsDao {

	@Override
	public List<OrderItem> getOrdeItemsByOrderId(long orderId) throws ShavikaAppException {
		return (List<OrderItem>) getSession().getNamedQuery(GET_ORDERITEM_BY_ORDERID).setLong(0, orderId).list();
	}

	@Override
	public List<OrderItem> getOrdeItemBySrcOrderId(long orderId, String srcid) throws ShavikaAppException {
		return getSession().getNamedQuery(GET_ORDERITEM_BY_SRC_ORDERID).setLong(0, orderId).setString(1, srcid).list();
	}
}
