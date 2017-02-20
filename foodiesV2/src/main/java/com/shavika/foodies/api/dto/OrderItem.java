package com.shavika.foodies.api.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shavika.foodies.dao.LoginDao;
import com.shavika.foodies.dao.OrderItemsDao;
import com.shavika.foodies.util.DateTimeUtil;

@NamedQueries({ @NamedQuery(name = OrderItemsDao.GET_ORDERITEM_BY_ORDERID, query = " from OrderItem l where l.order_item_id = ? "),
	@NamedQuery(name = OrderItemsDao.GET_ORDERITEM_BY_SRC_ORDERID, query = " from OrderItem l where l.order_item_id = ? and l.src_element_id = ? ")})
@Entity
@Table(name = "ORDERITEM")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 8799959226787042123L;

	@Id
	//@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "SRC_ELEMENT_ID", length = 20, nullable = false)
	private String src_element_id;
	
	@Column(name = "ORDER_ITEM_ID", length = 20, nullable = false)
	private long order_item_id;
	
	@Column(name = "FOOD_ID", length = 20, nullable = false)
	private long food_id;
	
	@Column(name = "PRICE", length = 20, nullable = false)
	private String price;
	
	@Column(name = "QUANTITY", length = 20, nullable = false)
	private String quantity;
	
	@Column(name = "VALUE", length = 20, nullable = false)
	private String value;
	
	@Column(name = "STATUS", length = 20, nullable = false)
	private String status;

	@Column(name = "CREATED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long created_on;

	@Column(name = "MODIFIED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long modified_on;

	@Column(name = "IS_DELETED", columnDefinition = "int default 0", nullable = false)
	private int is_deleted;

	public OrderItem() {
	}

	public OrderItem(long id, String src_element_id, long order_item_id, long food_id, String price, String quantity,
			String value, String status, int is_deleted, long created_on, long modified_on) {
		this.id = id;
		this.src_element_id = src_element_id;
		this.order_item_id = order_item_id;
		this.food_id = food_id;
		this.price = price;
		this.quantity = quantity;
		this.value = value;
		this.status = status;
		this.is_deleted = is_deleted;
		this.created_on = created_on;
		this.modified_on = modified_on;
	}

	public OrderItem(String src_element_id, long order_item_id, long food_id, String price, String quantity,
			String value, String status, int is_deleted, long created_on, long modified_on) {
		this.src_element_id = src_element_id;
		this.order_item_id = order_item_id;
		this.food_id = food_id;
		this.price = price;
		this.quantity = quantity;
		this.value = value;
		this.status = status;
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

	public String getSrc_element_id() {
		return src_element_id;
	}

	public void setSrc_element_id(String src_element_id) {
		this.src_element_id = src_element_id;
	}

	public long getOrder_item_id() {
		return order_item_id;
	}

	public void setOrder_item_id(long order_item_id) {
		this.order_item_id = order_item_id;
	}

	public long getFood_id() {
		return food_id;
	}

	public void setFood_id(long food_id) {
		this.food_id = food_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		if (!(o instanceof OrderItem))
			return false;

		OrderItem orderItem = (OrderItem) o;

		if (getOrder_item_id() != orderItem.getOrder_item_id())
			return false;
		if (getFood_id() != orderItem.getFood_id())
			return false;
		if (!getPrice().equals(orderItem.getPrice()))
			return false;
		if (!getQuantity().equals(orderItem.getQuantity()))
			return false;
		return getValue().equals(orderItem.getValue());

	}

	@Override
	public int hashCode() {
		int result = (int) (getOrder_item_id() ^ (getOrder_item_id() >>> 32));
		result = 31 * result + (int) (getFood_id() ^ (getFood_id() >>> 32));
		result = 31 * result + getPrice().hashCode();
		result = 31 * result + getQuantity().hashCode();
		result = 31 * result + getValue().hashCode();
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
		return "OrderItem [id=" + id + ", src_element_id=" + src_element_id + ", order_item_id=" + order_item_id
				+ ", food_id=" + food_id + ", price=" + price + ", quantity=" + quantity + ", value=" + value
				+ ", status=" + status +  ", created_on=" + created_on + ", modified_on="
				+ modified_on + ", is_deleted=" + is_deleted + "]";
	}

}
