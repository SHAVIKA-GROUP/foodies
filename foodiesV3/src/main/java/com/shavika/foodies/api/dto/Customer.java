package com.shavika.foodies.api.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shavika.foodies.common.dao.CustomerDao;
import com.shavika.foodies.common.utilities.DateTimeUtil;

@Entity
@Table(name = "CUSTOMER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NamedQueries({ @NamedQuery(name = CustomerDao.GET_CUSTOMER_BY_CUSTID, query = " from Customer c where c.customer_item_id = ?  and is_deleted = 0") ,
		 @NamedQuery(name = CustomerDao.GET_CUSTOMER_BY_PHONE, query = " from Customer c where c.phone = ?  and is_deleted = 0") })
public class Customer implements Serializable{

	private static final long serialVersionUID = -3599277885711171526L;

	@Id
	//@GeneratedValue
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "CUSTOMER_ITEM_ID", length = 20, nullable = false)
	private long customer_item_id;

	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String first_name;
	
	@Column(name = "last_NAME", length = 30, nullable = true)
	private String last_name;
	
	@Column(name = "EMAIL", length = 50, nullable = true)
	private String email;
	
	@Column(name = "PHONE", length = 15, nullable = true)
	private String phone;
	
	@Column(name = "ADDRESS_1", length = 70, nullable = true)
	private String address_1;
	
	@Column(name = "ADDRESS_2", length = 70, nullable = true)
	private String address_2;
	
	@Column(name = "STREET", length = 30, nullable = true)
	private String street;
	
	@Column(name = "LAND_MARK", length = 40, nullable = true)
	private String land_mark;
	
	@Column(name = "CITY", length = 30, nullable = true)
	private String city;
	
	@Column(name = "STATE", length = 30, nullable = true)
	private String state;
	
	@Column(name = "PINCODE", length = 10, nullable = true)
	private String pincode;

	@Column(name = "ERROR_STATUS", length = 30, nullable = true)
	private String error_status;
	
	@Column(name = "LAST_UPDATE", length = 20, nullable = true)
	private long last_update;

	@Column(name = "CREATED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long created_on;

	@Column(name = "MODIFIED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long modified_on;

	@Column(name = "IS_DELETED", columnDefinition = "int default 0", nullable = false)
	private int is_deleted;

	public Customer() {
	}

	public Customer(long id, long customer_item_id, String first_name, String last_name, String email, String phone,
			String address_1, String address_2, String street, String land_mark, String city, String state,
			String pincode, String error_status, long last_update, long created_on, long modified_on, int is_deleted) {
		super();
		this.id = id;
		this.customer_item_id = customer_item_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.street = street;
		this.land_mark = land_mark;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.error_status = error_status;
		this.last_update = last_update;
		this.created_on = created_on;
		this.modified_on = modified_on;
		this.is_deleted = is_deleted;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomer_item_id() {
		return customer_item_id;
	}

	public void setCustomer_item_id(long customer_item_id) {
		this.customer_item_id = customer_item_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress_1() {
		return address_1;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public String getAddress_2() {
		return address_2;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLand_mark() {
		return land_mark;
	}

	public void setLand_mark(String land_mark) {
		this.land_mark = land_mark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getError_status() {
		return error_status;
	}

	public void setError_status(String error_status) {
		this.error_status = error_status;
	}

	public long getLast_update() {
		return last_update;
	}

	public void setLast_update(long last_update) {
		this.last_update = last_update;
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
		if (!(o instanceof Customer))
			return false;

		Customer customer = (Customer) o;

		if (!getFirst_name().equals(customer.getFirst_name()))
			return false;
		if (!getLast_name().equals(customer.getLast_name()))
			return false;
		if (!getEmail().equals(customer.getEmail()))
			return false;
		if (!getPhone().equals(customer.getPhone()))
			return false;
		return getPincode().equals(customer.getPincode());

	}

	@Override
	public int hashCode() {
		int result = getFirst_name().hashCode();
		result = 31 * result + getLast_name().hashCode();
		result = 31 * result + getEmail().hashCode();
		result = 31 * result + getPhone().hashCode();
		result = 31 * result + getPincode().hashCode();
		return result;
	}

	@PreUpdate
	@PrePersist
	public void updateTimeStamps() {
		if (created_on == 0) {
			created_on = DateTimeUtil.getMillis();// new Date();
			modified_on = created_on; 
			is_deleted = 0;
		}else{
			modified_on = DateTimeUtil.getMillis();// new Date();
		}
	}

	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customer_item_id=" + customer_item_id + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email=" + email + ", phone=" + phone + ", address_1=" + address_1
				+ ", address_2=" + address_2 + ", street=" + street + ", land_mark=" + land_mark + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + ", error_status=" + error_status + ", last_update="
				+ last_update + ", created_on=" + created_on + ", modified_on=" + modified_on + ", is_deleted="
				+ is_deleted + "]";
	}
}
