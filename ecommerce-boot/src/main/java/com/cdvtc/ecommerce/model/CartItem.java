package com.cdvtc.ecommerce.model;

import java.math.BigDecimal;

/**
 * 购物车明细项(不存库)
 */
public class CartItem {
	/**
	 * 商品
	 */
	private Product product;
	/**
	 * 商品数量
	 */
	private int quantity;

	/**
	 * 计算小记
	 */
	public BigDecimal getTotal() {
		return this.product.getPrice().multiply(BigDecimal.valueOf(quantity));
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem{" +
				"product=" + product +
				", quantity=" + quantity +
				'}';
	}
}
