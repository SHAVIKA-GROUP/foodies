package com.shavika.foodies.api.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRIVILEGE")
// @NamedQueries({ @NamedQuery(name = Privilege.GET_PRIVILEGES_BY_USER_ROLE,
// query = "SELECT DISTINCT P.* FROM PRIVILEGE P INNER JOIN ROLE_PRIVILEGE RP ON
// RP.PRIVILEGE_ID = P.PRIVILEGE_ID INNER JOIN ROLE R ON R.ROLE_ID =
// RP.ROLE_ID WHERE R.ROLE_ID = ?") })
public class Privilege implements Serializable {

	private static final long serialVersionUID = 8249904600217805950L;

	protected static final String GET_PRIVILEGES_BY_USER_ROLE = "getPrivilegesByUserRole";

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "PRIVILEGE_ID")
	private long id;

	@Column(name = "NAME", length = 80, nullable = false)
	private String name;

	@ManyToMany(mappedBy = "privileges")
	private Set<Roles> roles = new HashSet<Roles>();

	@Column(name = "CREATED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long created_on;

	@Column(name = "MODIFIED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long modified_on;

	@Column(name = "IS_DELETED", columnDefinition = "int default 0", nullable = false)
	private int is_deleted;

	public Privilege() {
		super();
	}

	public Privilege(long id, String name, Set<Roles> roles, long created_on, long modified_on, int is_deleted) {
		super();
		this.id = id;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
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
		return "Privilege [id=" + id + ", name=" + name + ", roles=" + roles + ", created_on=" + created_on
				+ ", modified_on=" + modified_on + ", is_deleted=" + is_deleted + "]";
	}

}
