package com.shavika.foodies.api.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PROPS")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Props implements Serializable {

	private static final long serialVersionUID = 6404959969156876771L;

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "PROPS_KEY", columnDefinition = "varchar(30)", nullable = false)
	private String prop_key;

	@Column(name = "PROPS_VALUE", columnDefinition = "varchar(30)", nullable = false)
	private String props_value;

	public Props() {
		super();
	}

	public Props(long id, String prop_key, String props_value) {
		super();
		this.id = id;
		this.prop_key = prop_key;
		this.props_value = props_value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProp_key() {
		return prop_key;
	}

	public void setProp_key(String prop_key) {
		this.prop_key = prop_key;
	}

	public String getProps_value() {
		return props_value;
	}

	public void setProps_value(String props_value) {
		this.props_value = props_value;
	}

	@Override
	public String toString() {
		return "Props [id=" + id + ", prop_key=" + prop_key + ", props_value=" + props_value + "]";
	}

}
