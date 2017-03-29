package com.shavika.foodies.api.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shavika.foodies.common.dao.OrdersDao;
import com.shavika.foodies.common.utilities.Constants;
import com.shavika.foodies.common.utilities.DateTimeUtil;


@NamedQueries({ @NamedQuery(name = OrdersDao.GET_ORDERS_WITHOUT_RECEIVED , query = " from Orders O where O.order_status not in ( '"+Constants.ORDER_RECEIVED+"' ) order by O.created_on desc"),
	@NamedQuery(name = OrdersDao.GET_ORDERS_BY_ITEMID, query = " from Orders O where O.order_item_id = ? "),
	@NamedQuery(name = OrdersDao.GET_ORDERS_BY_CUSTOMER, query = " from Orders O where O.customer_item_id = ? "),
@NamedQuery(name = OrdersDao.GET_ORDERS_SYNC_ORDERS, query = " from Orders O where O.order_status = ? ")})
@Entity
@Table(name = "ORDERS")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Orders implements Serializable {

	private static final long serialVersionUID = 8354380977888100599L;

	@Id
	//@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	@Column(name = "ORDER_ITEM_ID", length = 20, nullable = false)
	private long order_item_id;
	
	@Column(name = "CUSTOMER_ITEM_ID", length = 20, nullable = false)
	private long customer_item_id;
	
	@Column(name = "TOTAL_VALUE", length = 20, nullable = false)
	private String total_value;
	
	@Column(name = "ORDER_STATUS", length = 20, nullable = false)
	private String order_status;
	
	@Column(name = "DELIVERY_ON", length = 20, nullable = false)
	private long delivery_on;

	@Column(name = "CREATED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long created_on;

	@Column(name = "MODIFIED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long modified_on;

	@Column(name = "IS_DELETED", columnDefinition = "int default 0", nullable = false)
	private int is_deleted;

	public Orders() {
	}

	public Orders(String total_value, long order_item_id) {
		this.total_value = total_value;
		this.order_item_id = order_item_id;
	}

	public Orders(long id, long order_item_id, long customer_item_id, String total_value, String order_status,
			long delivery_on, int is_deleted, long created_on, long modified_on) {
		this.id = id;
		this.order_item_id = order_item_id;
		this.customer_item_id = customer_item_id;
		this.total_value = total_value;
		this.order_status = order_status;
		this.delivery_on = delivery_on;
		this.is_deleted = is_deleted;
		this.created_on = created_on;
		this.modified_on = modified_on;
	}

	public Orders(long order_item_id, long customer_item_id, String total_value, String order_status, long delivery_on,
			int is_deleted, long created_on, long modified_on) {
		this.order_item_id = order_item_id;
		this.customer_item_id = customer_item_id;
		this.total_value = total_value;
		this.order_status = order_status;
		this.delivery_on = delivery_on;
		this.is_deleted = is_deleted;
		this.created_on = created_on;
		this.modified_on = modified_on;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrder_item_id() {
		return order_item_id;
	}

	public void setOrder_item_id(long order_item_id) {
		this.order_item_id = order_item_id;
	}

	public long getCustomer_item_id() {
		return customer_item_id;
	}

	public void setCustomer_item_id(long customer_item_id) {
		this.customer_item_id = customer_item_id;
	}

	public String getTotal_value() {
		return total_value;
	}

	public void setTotal_value(String total_value) {
		this.total_value = total_value;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public long getDelivery_on() {
		return delivery_on;
	}

	public void setDelivery_on(long delivery_on) {
		this.delivery_on = delivery_on;
	}

	public long getCreated_on() {
		return created_on;
	}

	public void setCreated_on(long created_on) {
		this.created_on = created_on;
	}

	public long getModified_on() {
		return modified_on;
	}

	public void setModified_on(long modified_on) {
		this.modified_on = modified_on;
	}

	public int getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Orders))
			return false;

		Orders orders = (Orders) o;

		if (getCustomer_item_id() != orders.getCustomer_item_id())
			return false;
		return getTotal_value().equals(orders.getTotal_value());

	}

	@Override
	public int hashCode() {
		int result = (int) (getCustomer_item_id() ^ (getCustomer_item_id() >>> 32));
		result = 31 * result + getTotal_value().hashCode();
		return result;
	}

	@PreUpdate
	@PrePersist
	public void updateTimeStamps() {
		if (created_on == 0) {
			created_on = DateTimeUtil.getMillis();// new Date();
			modified_on = created_on;
			is_deleted = 0;
		} else {
			modified_on = DateTimeUtil.getMillis();// new Date();
		}
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", order_item_id=" + order_item_id + ", customer_item_id=" + customer_item_id
				+ ", total_value=" + total_value + ", order_status=" + order_status + ", delivery_on=" + delivery_on
				+ ", created_on=" + created_on + ", modified_on=" + modified_on
				+ ", is_deleted=" + is_deleted + "]";
	}

}
