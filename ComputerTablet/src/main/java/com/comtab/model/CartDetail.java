package com.comtab.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// Generated Oct 17, 2013 7:06:35 PM by Hibernate Tools 3.2.1.GA
import javax.persistence.Table;



/**
 * Chitietgiohang generated by hbm2java
 */

@Entity
@Table(name = "cartdetail")
public class CartDetail{

	@Id
     private int id;
    @ManyToOne
 	@JoinColumn(name = "cartid", referencedColumnName = "id")
     private Cart cart;
    @ManyToOne
 	@JoinColumn(name = "productid", referencedColumnName = "id")
     private Product product;
     private int orderAmount;

    public CartDetail() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}


	
    



}


