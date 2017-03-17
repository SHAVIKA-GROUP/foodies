package com.shavika.foodies.api.dto;

import java.io.Serializable;
import java.util.List;

public class PraserObject implements Serializable {

	private static final long serialVersionUID = 8084943471179998825L;

	private Customer customer;
	private Orders orders;
	private List<OrderItem> orderitems;
	private List<Menus> menus;

	public PraserObject() {
		super();
	}

	public PraserObject(Customer customer, Orders orders, List<OrderItem> orderitems, List<Menus> menus) {
		super();
		this.customer = customer;
		this.orders = orders;
		this.orderitems = orderitems;
		this.menus = menus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public List<OrderItem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}

	public List<Menus> getMenus() {
		return menus;
	}

	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "PraserObject [customer=" + customer + ", orders=" + orders + ", orderitems=" + orderitems + ", menus="
				+ menus + "]";
	}
}
