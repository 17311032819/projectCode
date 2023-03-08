package com.cdvtc.ecommerce.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
public class Order {

	/**
	 * 订单编号
	 */
	private String o_no;

	/**
	 * 会员
	 */
	private String m_no;

	/**
	 * 商品编号
	 */
	private String g_no;


	/**
	 * 商品名称
	 */
	private String g_name;

	/**
	 * 商品数量
	 */
	private int number;

	/**
	 * 星级
	 */
	private String star;

	/**
	 * 地址
	 */
	private String adress;



	/**
	 * 订单创建时间
	 */
	private Date date;

	/**
	 * 单价
	 */
	private float price;

	/**
	 * 订单状态
	 */
	private String o_state;

	/**
	 * 订单评论
	 */

	private String comment;

	public String getO_no() {
		return o_no;
	}

	public void setO_no(String o_no) {
		this.o_no = o_no;
	}

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
		this.m_no = m_no;
	}

	public String getG_no() {
		return g_no;
	}

	public void setG_no(String g_no) {
		this.g_no = g_no;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float total) {
		this.price = total;
	}

	public String getO_state() {
		return o_state;
	}

	@Override
	public String toString() {
		return "Order{" +
				"o_no='" + o_no + '\'' +
				", m_no='" + m_no + '\'' +
				", g_no='" + g_no + '\'' +
				", g_name='" + g_name + '\'' +
				", number=" + number +
				", star='" + star + '\'' +
				", adress='" + adress + '\'' +
				", date=" + date +
				", price=" + price +
				", o_state='" + o_state + '\'' +
				", comment='" + comment + '\'' +
				'}';
	}

	public void setO_state(String o_state) {
		this.o_state = o_state;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
