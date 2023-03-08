package com.cdvtc.ecommerce.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
@Entity
@Table(name = "`order`") //表名与关键字冲突，需要``
public class Order {

	/**
	 * 订单编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * 会员
	 */
	@ManyToOne
	private User user;

	/**
	 * 订单创建时间
	 */
	private Date date;

	/**
	 * 总价
	 */
	private BigDecimal total;

	/**
	 * 订单状态
	 */
	private short status;

	/**
	 * 订单详情列表
	 */
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
