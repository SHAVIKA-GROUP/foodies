package com.shavika.foodies.api.dto;

public class SyncDashBoard {

	private String service;
	private int size;
	private int all;
	private double percentage;

	public SyncDashBoard() {
		super();
	}

	public SyncDashBoard(String service, int size, int all, double percentage) {
		super();
		this.service = service;
		this.size = size;
		this.all = all;
		this.percentage = percentage;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getAll() {
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "SyncDashBoard [service=" + service + ", size=" + size + ", all=" + all + ", percentage=" + percentage
				+ "]";
	}
}
