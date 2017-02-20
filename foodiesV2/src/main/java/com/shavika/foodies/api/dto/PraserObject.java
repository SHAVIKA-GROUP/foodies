package com.shavika.foodies.api.dto;

import java.io.Serializable;
import java.util.List;

public class PraserObject implements Serializable {

	private Orders orders;

	private Customer customer;

	private List<OrderItem> orderitems;

	private List<FoodItem> foods;

	public PraserObject() {
		super();
	}

	public PraserObject(Orders orders, Customer customer, List<OrderItem> orderitems, List<FoodItem> foods) {
		super();
		this.orders = orders;
		this.customer = customer;
		this.orderitems = orderitems;
		this.foods = foods;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}

	public List<FoodItem> getFoods() {
		return foods;
	}

	public void setFoods(List<FoodItem> foods) {
		this.foods = foods;
	}

	@Override
	public String toString() {
		return "PraserObject [orders=" + orders + ", customer=" + customer + ", orderitems=" + orderitems + ", foods="
				+ foods + "]";
	}
}
