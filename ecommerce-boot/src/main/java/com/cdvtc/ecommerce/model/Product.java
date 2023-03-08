package com.cdvtc.ecommerce.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 商品
 */
@Entity
public class Product {
	/**
	 * 商品编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * 商品名称
	 */
	private String name;

	/**
	 * 商品分类
	 */
	@ManyToOne
	private Category category;

	/**
	 * 市场价格
	 */
	private BigDecimal marketPrice;

	/**
	 * 商品价格(售价)
	 */
	private BigDecimal price;

	/**
	 * 商品图片
	 */
	private String image;

	/**
	 * 库存
	 */
	private int stock;

	/**
	 * 销量（不直接存储，根据订单明细生成的统计值）
	 */
	@Transient
	private int sales;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", category=" + category +
				", price=" + price +
				", image='" + image + '\'' +
				", stock='" + stock + '\'' +
				", sales='" + sales + '\'' +
				'}';
	}
}
