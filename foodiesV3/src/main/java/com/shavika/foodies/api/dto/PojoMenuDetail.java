package com.shavika.foodies.api.dto;

public class PojoMenuDetail {

	private int menutypeid;
	private long unique_id;
	private long date;

	private long bfst_id;
	private String bfst_title;
	private String bfst_subtitle;
	private String bfst_description;
	private int bfst_price;
	private String bfst_image;

	private long luch_id;
	private String luch_title;
	private String luch_subtitle;
	private String luch_description;
	private int luch_price;
	private String luch_image;

	private long dinr_id;
	private String dinr_title;
	private String dinr_subtitle;
	private String dinr_description;
	private int dinr_price;
	private String dinr_image;

	public PojoMenuDetail() {
		super();
	}

	public PojoMenuDetail(int menutypeid, long unique_id, long date, long bfst_id, String bfst_title,
			String bfst_subtitle, String bfst_description, int bfst_price, String bfst_image, long luch_id,
			String luch_title, String luch_subtitle, String luch_description, int luch_price, String luch_image,
			long dinr_id, String dinr_title, String dinr_subtitle, String dinr_description, int dinr_price,
			String dinr_image) {
		super();
		this.menutypeid = menutypeid;
		this.unique_id = unique_id;
		this.date = date;
		this.bfst_id = bfst_id;
		this.bfst_title = bfst_title;
		this.bfst_subtitle = bfst_subtitle;
		this.bfst_description = bfst_description;
		this.bfst_price = bfst_price;
		this.bfst_image = bfst_image;
		this.luch_id = luch_id;
		this.luch_title = luch_title;
		this.luch_subtitle = luch_subtitle;
		this.luch_description = luch_description;
		this.luch_price = luch_price;
		this.luch_image = luch_image;
		this.dinr_id = dinr_id;
		this.dinr_title = dinr_title;
		this.dinr_subtitle = dinr_subtitle;
		this.dinr_description = dinr_description;
		this.dinr_price = dinr_price;
		this.dinr_image = dinr_image;
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

	public long getBfst_id() {
		return bfst_id;
	}

	public void setBfst_id(long bfst_id) {
		this.bfst_id = bfst_id;
	}

	public String getBfst_title() {
		return bfst_title;
	}

	public void setBfst_title(String bfst_title) {
		this.bfst_title = bfst_title;
	}

	public String getBfst_subtitle() {
		return bfst_subtitle;
	}

	public void setBfst_subtitle(String bfst_subtitle) {
		this.bfst_subtitle = bfst_subtitle;
	}

	public String getBfst_description() {
		return bfst_description;
	}

	public void setBfst_description(String bfst_description) {
		this.bfst_description = bfst_description;
	}

	public int getBfst_price() {
		return bfst_price;
	}

	public void setBfst_price(int bfst_price) {
		this.bfst_price = bfst_price;
	}

	public String getBfst_image() {
		return bfst_image;
	}

	public void setBfst_image(String bfst_image) {
		this.bfst_image = bfst_image;
	}

	public long getLuch_id() {
		return luch_id;
	}

	public void setLuch_id(long luch_id) {
		this.luch_id = luch_id;
	}

	public String getLuch_title() {
		return luch_title;
	}

	public void setLuch_title(String luch_title) {
		this.luch_title = luch_title;
	}

	public String getLuch_subtitle() {
		return luch_subtitle;
	}

	public void setLuch_subtitle(String luch_subtitle) {
		this.luch_subtitle = luch_subtitle;
	}

	public String getLuch_description() {
		return luch_description;
	}

	public void setLuch_description(String luch_description) {
		this.luch_description = luch_description;
	}

	public int getLuch_price() {
		return luch_price;
	}

	public void setLuch_price(int luch_price) {
		this.luch_price = luch_price;
	}

	public String getLuch_image() {
		return luch_image;
	}

	public void setLuch_image(String luch_image) {
		this.luch_image = luch_image;
	}

	public long getDinr_id() {
		return dinr_id;
	}

	public void setDinr_id(long dinr_id) {
		this.dinr_id = dinr_id;
	}

	public String getDinr_title() {
		return dinr_title;
	}

	public void setDinr_title(String dinr_title) {
		this.dinr_title = dinr_title;
	}

	public String getDinr_subtitle() {
		return dinr_subtitle;
	}

	public void setDinr_subtitle(String dinr_subtitle) {
		this.dinr_subtitle = dinr_subtitle;
	}

	public String getDinr_description() {
		return dinr_description;
	}

	public void setDinr_description(String dinr_description) {
		this.dinr_description = dinr_description;
	}

	public int getDinr_price() {
		return dinr_price;
	}

	public void setDinr_price(int dinr_price) {
		this.dinr_price = dinr_price;
	}

	public String getDinr_image() {
		return dinr_image;
	}

	public void setDinr_image(String dinr_image) {
		this.dinr_image = dinr_image;
	}

	@Override
	public String toString() {
		return "PojoMenuDetail [menutypeid=" + menutypeid + ", unique_id=" + unique_id + ", date=" + date + ", bfst_id="
				+ bfst_id + ", bfst_title=" + bfst_title + ", bfst_subtitle=" + bfst_subtitle + ", bfst_description="
				+ bfst_description + ", bfst_price=" + bfst_price + ", bfst_image=" + bfst_image + ", luch_id="
				+ luch_id + ", luch_title=" + luch_title + ", luch_subtitle=" + luch_subtitle + ", luch_description="
				+ luch_description + ", luch_price=" + luch_price + ", luch_image=" + luch_image + ", dinr_id="
				+ dinr_id + ", dinr_title=" + dinr_title + ", dinr_subtitle=" + dinr_subtitle + ", dinr_description="
				+ dinr_description + ", dinr_price=" + dinr_price + ", dinr_image=" + dinr_image + "]";
	}
}
