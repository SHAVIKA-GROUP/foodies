package com.shavika.foodies.api.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shavika.foodies.dao.LoginDao;
import com.shavika.foodies.util.DateTimeUtil;

@NamedQueries({ @NamedQuery(name = LoginDao.GET_USER_BY_NAME, query = " from Login l where l.email = ? "),
		@NamedQuery(name = LoginDao.GET_USER_BY_EMAIL, query = " from Login l where l.email = ? "),
		@NamedQuery(name = LoginDao.GET_ANY_USER_BY_NAME_PWD, query = " from Login l where l.email = ? and l.password = ? ") })
@Entity
@Table(name = "LOGIN")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Login implements Serializable {

	private static final long serialVersionUID = -6452166306412012515L;

	@Id
	@GeneratedValue
	@Column(name = "LOGIN_ID")
	private long id;
	@Column(name = "SRC_ELEMENT_ID", length = 20, nullable = false)
	private String src_element_id;
	@Column(name = "USER_NAME", length = 50, nullable = false)
	private String user_name;
	@Column(name = "PASSWORD", length = 30, nullable = false)
	private String password;
	@Column(name = "EMAIL", length = 50, nullable = true)
	private String email;
	@Column(name = "PHONE", length = 15, nullable = true)
	private String phone;

	@Column(name = "CREATED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long created_on;

	@Column(name = "MODIFIED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long modified_on;

	@Column(name = "IS_DELETED", columnDefinition = "int default 0", nullable = false)
	private int is_deleted;

	public Login() {
		super();
	}

	public Login(long id, String src_element_id, String user_name, String password, String email, String phone,
			long created_on, long modified_on, int is_deleted) {
		super();
		this.id = id;
		this.src_element_id = src_element_id;
		this.user_name = user_name;
		this.password = password;
		this.email = email;
		this.phone = phone;
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

	public String getSrc_element_id() {
		return src_element_id;
	}

	public void setSrc_element_id(String src_element_id) {
		this.src_element_id = src_element_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
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
		return "Login [id=" + id + ", src_element_id=" + src_element_id + ", user_name=" + user_name + ", password="
				+ password + ", email=" + email + ", phone=" + phone + ", created_on=" + created_on + ", modified_on="
				+ modified_on + ", is_deleted=" + is_deleted + "]";
	}

}
