package com.shavika.foodies.common.dao;

import java.util.List;

import com.shavika.foodies.api.dao.BaseDao;
import com.shavika.foodies.api.dto.Customer;
import com.shavika.foodies.api.exception.ShavikaAppException;

public abstract interface CustomerDao extends BaseDao<Customer> {
	
	public static final String GET_CUSTOMER_BY_CUSTID = "getCustomerByCustID";
	
	public static final String GET_CUSTOMER_BY_PHONE = "getCustomerByPhoneno";

	public abstract List<Customer> getCustomerByCustid(Customer customer) throws ShavikaAppException;
	
	public abstract List<Customer> getCustomerByPhone(Customer customer) throws ShavikaAppException;
	
}
