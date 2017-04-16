package com.shavika.foodies.api.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.shavika.foodies.common.dao.UserDao;

@Entity
@Table(name = "USER_LOGIN")
@NamedQueries({
		@NamedQuery(name = UserDao.GET_USER_BY_NAME, query = "from UserLogin as userLogin where (userLogin.username=? and userLogin.status =1)"),
		@NamedQuery(name = UserDao.GET_USER_BY_EMAIL, query = "from UserLogin as userLogin where (userLogin.email=? and userLogin.status =1)"),
		@NamedQuery(name = UserDao.GET_ANY_USER_BY_NAME, query = "from UserLogin as userLogin where (userLogin.username=?)") })
public class UserLogin implements Serializable {

	private static final long serialVersionUID = 7837303325516366834L;

	@Id
	//@GeneratedValue
	@Column(name = "USER_LOGIN_ID")
	private long id;

	@Column(name = "EMAIL", length = 80, nullable = false)
	private String email;

	@Column(name = "USERNAME", length = 55, nullable = false)
	private String username;

	@Column(name = "PASSWORD", length = 80, nullable = false)
	private String password;

	@Column(name = "STATUS", columnDefinition = "boolean default true", nullable = false)
	private boolean status;

	@Column(name = "LOGIN_ATTEMPTS", nullable = false)
	private int loginAttempts;

	@Column(name = "USER_INDENTIFICATION_NO", length = 60)
	private String userIdentificationNo;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ROLE_ID")
	private Roles roles;

	@Column(name = "CREATED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long created_on;

	@Column(name = "MODIFIED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long modified_on;

	@Column(name = "IS_DELETED", columnDefinition = "int default 0", nullable = false)
	private int is_deleted;

	public UserLogin() {
		super();
	}

	public UserLogin(long id, String email, String username, String password, boolean status, int loginAttempts,
			String userIdentificationNo, Roles roles, long created_on, long modified_on, int is_deleted) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.status = status;
		this.loginAttempts = loginAttempts;
		this.userIdentificationNo = userIdentificationNo;
		this.roles = roles;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	public String getUserIdentificationNo() {
		return userIdentificationNo;
	}

	public void setUserIdentificationNo(String userIdentificationNo) {
		this.userIdentificationNo = userIdentificationNo;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
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
	public String toString() {
		return "UserLogin [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", status=" + status + ", loginAttempts=" + loginAttempts + ", userIdentificationNo="
				+ userIdentificationNo + ", roles=" + roles + ", created_on=" + created_on + ", modified_on="
				+ modified_on + ", is_deleted=" + is_deleted + "]";
	}

}
