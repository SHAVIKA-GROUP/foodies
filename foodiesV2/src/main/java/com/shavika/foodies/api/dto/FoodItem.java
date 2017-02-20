package com.shavika.foodies.api.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shavika.foodies.util.DateTimeUtil;

@Entity
@Table(name = "FOODITEM")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FoodItem implements Serializable {

	private static final long serialVersionUID = 4502162095352066239L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "SRC_ELEMENT_ID", length = 20, nullable = false)
	private String src_element_id;
	@Column(name = "FOOD_NAME", length = 50, nullable = false)
	private String food_name;
	@Column(name = "VALUE", length = 20, nullable = false)
	private String value;

	@Column(name = "CREATED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long created_on;

	@Column(name = "MODIFIED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long modified_on;

	@Column(name = "IS_DELETED", columnDefinition = "int default 0", nullable = false)
	private int is_deleted;

	public FoodItem() {
	}

	public FoodItem(long id, String src_element_id, String food_name, String value, long created_on, long modified_on,
			int is_deleted) {
		super();
		this.id = id;
		this.src_element_id = src_element_id;
		this.food_name = food_name;
		this.value = value;
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

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
		if (!(o instanceof FoodItem))
			return false;

		FoodItem foodItem = (FoodItem) o;

		if (!getFood_name().equals(foodItem.getFood_name()))
			return false;
		return getValue().equals(foodItem.getValue());

	}

	@Override
	public int hashCode() {
		int result = getFood_name().hashCode();
		result = 31 * result + getValue().hashCode();
		return result;
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
		return "FoodItem [id=" + id + ", src_element_id=" + src_element_id + ", food_name=" + food_name + ", value="
				+ value + ", created_on=" + created_on + ", modified_on=" + modified_on + ", is_deleted=" + is_deleted
				+ "]";
	}

}
