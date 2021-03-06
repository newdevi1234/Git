package com.comtab.model;
// Generated Oct 17, 2013 7:06:35 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Khachhang generated by hbm2java
 */

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
     private String username;
     private String password;
     private String fullName;
     private String email;
     private String address;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
     private Set<Cart> cart = new HashSet(0);

    public Customer() {
    }

	
    public Customer(String username, String password, String fullName,
			String email, String address, Set<Cart> cart) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.cart = cart;
	}


	public Customer(String username) {
        this.username = username;
    }



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullName() {
		return fullName;
	}


	public void setName(String fullname) {
		this.fullName = fullname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Set<Cart> getCart() {
		return cart;
	}


	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}
    

}


