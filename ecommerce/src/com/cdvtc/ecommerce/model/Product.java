package com.cdvtc.ecommerce.model;

import java.math.BigDecimal;

/**
 * 商品
 */
public class Product {
	/**
	 * 商品编号
	 */
	private String  g_no;

	/**
	 * 商品名称
	 */
	private String g_name;

	/**
	 * 商品分类
	 */
	private Category category;


	/**
	 * 商品价格(售价)
	 */
	private float g_price;

	/**
	 * 商品图片
	 */
	private String main_image;

	/**
	 * 量
	 */
	private String g_quantity;

	/**
	 * 是否未今日推荐
	 */
	private String todaycommend;

	/**
	 * 详情1
	 */
	private String details01;

	/**
	 * 详情2
	 */
	private String details02;

	/**
	 * 详情3
	 */
	private String details03;

	/**
	 * 详情4
	 */
	private String details04;


	/**
	 * 详情5
	 */
	private String details05;

	/**
	 * 起源
	 */
	private String origin;

	/**
	 * 成分
	 */
	private String indredient;

	/**
	 * 展示1
	 */
	private String show01;

	/**
	 * 展示2
	 */
	private String show02;


	/**
	 * 展示3
	 */
	private String show03;


	public String  getG_no() {
		return g_no;
	}

	public void setG_no(String  g_no) {
		this.g_no = g_no;
	}

	@Override
	public String toString() {
		return "Product{" +
				"g_no=" + g_no +
				", g_name='" + g_name + '\'' +
				", category=" + category +
				", g_price=" + g_price +
				", main_image='" + main_image + '\'' +
				", g_quantity=" + g_quantity +
				", todaycommend='" + todaycommend + '\'' +
				", details01='" + details01 + '\'' +
				", details02='" + details02 + '\'' +
				", details03='" + details03 + '\'' +
				", details04='" + details04 + '\'' +
				", details05='" + details05 + '\'' +
				", origin='" + origin + '\'' +
				", indredient='" + indredient + '\'' +
				", show01='" + show01 + '\'' +
				", show02='" + show02 + '\'' +
				", show03='" + show03 + '\'' +
				'}';
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public float getG_price() {
		return g_price;
	}

	public void setG_price(float g_price) {
		this.g_price = g_price;
	}

	public String getMain_image() {
		return main_image;
	}

	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}

	public String getG_quantity() {
		return g_quantity;
	}

	public void setG_quantity(String g_quantity) {
		this.g_quantity = g_quantity;
	}

	public String getTodaycommend() {
		return todaycommend;
	}

	public void setTodaycommend(String todaycommend) {
		this.todaycommend = todaycommend;
	}

	public String getDetails01() {
		return details01;
	}

	public void setDetails01(String details01) {
		this.details01 = details01;
	}

	public String getDetails02() {
		return details02;
	}

	public void setDetails02(String details02) {
		this.details02 = details02;
	}

	public String getDetails03() {
		return details03;
	}

	public void setDetails03(String details03) {
		this.details03 = details03;
	}

	public String getDetails04() {
		return details04;
	}

	public void setDetails04(String details04) {
		this.details04 = details04;
	}

	public String getDetails05() {
		return details05;
	}

	public void setDetails05(String details05) {
		this.details05 = details05;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getIndredient() {
		return indredient;
	}

	public void setIndredient(String indredient) {
		this.indredient = indredient;
	}

	public String getShow01() {
		return show01;
	}

	public void setShow01(String show01) {
		this.show01 = show01;
	}

	public String getShow02() {
		return show02;
	}

	public void setShow02(String show02) {
		this.show02 = show02;
	}

	public String getShow03() {
		return show03;
	}

	public void setShow03(String show03) {
		this.show03 = show03;
	}
}
