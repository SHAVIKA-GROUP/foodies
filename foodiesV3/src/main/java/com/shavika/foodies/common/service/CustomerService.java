package com.shavika.foodies.common.service;

import java.util.List;

import com.shavika.foodies.api.dto.Customer;
import com.shavika.foodies.api.dto.SyncDashBoard;
import com.shavika.foodies.api.exception.ShavikaAppException;


public abstract interface CustomerService {
	
	public abstract Customer saveOrUpdate(Customer customer) throws ShavikaAppException;
	
	public abstract List<Customer> getAllCustomer() throws ShavikaAppException;

	public abstract Customer getCustomer() throws ShavikaAppException;

	public SyncDashBoard getSyncDashboard() throws ShavikaAppException ;
	
}
