package com.shavika.foodies.api.dto;

public class SyncOrder {

	private long order_item_id;
	private String status;

	public SyncOrder() {
		super();
	}

	public SyncOrder(long order_item_id, String status) {
		super();
		this.order_item_id = order_item_id;
		this.status = status;
	}

	public long getOrder_item_id() {
		return order_item_id;
	}

	public void setOrder_item_id(long order_item_id) {
		this.order_item_id = order_item_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SyncOrder [order_item_id=" + order_item_id + ", status=" + status + "]";
	}

}
