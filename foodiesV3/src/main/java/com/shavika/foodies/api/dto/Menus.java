package com.shavika.foodies.api.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shavika.foodies.common.dao.MenuDao;

@Entity
@Table(name = "MENUS")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NamedQueries({ @NamedQuery(name = MenuDao.IS_MENU_EXIST , query = " from Menus menu where menu.menutypeid = ? and  menu.unique_id = ?  "),
	@NamedQuery(name = MenuDao.GET_MENU_BY_UNIQUEID , query = " from Menus menu where menu.unique_id = ?  "),
	@NamedQuery(name = MenuDao.GET_LATEST_MENU , query = " from Menus menu order by menu.unique_id desc  ")})
public class Menus implements Serializable {

	private static final long serialVersionUID = -1459780916953838892L;

	@Id
	//@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "MENU_TYPE_ID", columnDefinition = "int default 0", nullable = false)
	private int menutypeid;

	@Column(name = "UNIQUE_ID", nullable = false)
	private long unique_id;

	@Column(name = "DATE", nullable = false)
	private long date;

	@Column(name = "TITLE", length = 100, nullable = false)
	private String title;

	@Column(name = "SUBTITLE", length = 200, nullable = false)
	private String subtitle;

	@Column(name = "DESCRIPTION", length = 500, nullable = false)
	private String description;

	@Column(name = "PRICE", columnDefinition = "int default 0", nullable = false)
	private int price;

	@Column(name = "IMAGE", columnDefinition = "varchar default null", nullable = false)
	private String image;

	@Column(name = "CREATED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long created_on;

	@Column(name = "MODIFIED_ON", columnDefinition = "bigint(20) default 0", nullable = false)
	private long modified_on;

	@Column(name = "IS_DELETED", columnDefinition = "int default 0", nullable = false)
	private int is_deleted;

	public Menus() {
		super();
	}

	public Menus(long id, int menutypeid, long unique_id, long date, String title, String subtitle, String description,
			int price, String image, long created_on, long modified_on, int is_deleted) {
		super();
		this.id = id;
		this.menutypeid = menutypeid;
		this.unique_id = unique_id;
		this.date = date;
		this.title = title;
		this.subtitle = subtitle;
		this.description = description;
		this.price = price;
		this.image = image;
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

	public int getMenutypeid() {
		return menutypeid;
	}

	public void setMenutypeid(int menutypeid) {
		this.menutypeid = menutypeid;
	}

	public long getUnique_id() {
		return unique_id;
	}

	public void setUnique_id(long unique_id) {
		this.unique_id = unique_id;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", menutypeid=" + menutypeid + ", unique_id=" + unique_id + ", date=" + date
				+ ", title=" + title + ", subtitle=" + subtitle + ", description=" + description + ", price=" + price
				+ ", image=" + image + ", created_on=" + created_on + ", modified_on=" + modified_on + ", is_deleted="
				+ is_deleted + "]";
	}

}
