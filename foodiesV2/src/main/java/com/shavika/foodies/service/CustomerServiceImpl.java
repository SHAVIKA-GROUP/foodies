package com.shavika.foodies.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shavika.foodies.api.dto.Customer;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.dao.CustomerDao;
import com.shavika.foodies.util.Constants;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer saveOrUpdate(Customer customer) throws ShavikaAppException {
		List<Customer> custList = customerDao.getCustomerByCustid(customer);
		if (custList.size() == 0) {
			customerDao.save(customer);
		} else if (custList.size() > 0 && custList.get(0).getError_status().equals(Constants.CUSTOMER_REGISTRED)) {
			customer.setError_status(Constants.CUSTOMER_CONFIRMED);
			customerDao.update(customer);
		}
		return this.getCustomer();
	}

	@Override
	public List<Customer> getAllCustomer() throws ShavikaAppException {
		return customerDao.findAll(Customer.class);
	}

	@Override
	public Customer getCustomer() throws ShavikaAppException {
		List<Customer> custList = customerDao.findAll(Customer.class);
		return (custList.size() > 0) ? custList.get(0) : null;
	}
}
