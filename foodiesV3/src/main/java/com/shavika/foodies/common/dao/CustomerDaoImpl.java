package com.shavika.foodies.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shavika.foodies.api.dao.BaseDaoImpl;
import com.shavika.foodies.api.dto.Customer;
import com.shavika.foodies.api.exception.ShavikaAppException;

@Repository("customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	@Override
	public List<Customer> getCustomerByCustid(Customer customer) throws ShavikaAppException {
		return getSession().getNamedQuery(GET_CUSTOMER_BY_CUSTID).setLong(0, customer.getCustomer_item_id()).list();
	}

	@Override
	public List<Customer> getCustomerByPhone(Customer customer) throws ShavikaAppException {
		return getSession().getNamedQuery(GET_CUSTOMER_BY_PHONE).setString(0, customer.getPhone().trim()).list();
	}

}