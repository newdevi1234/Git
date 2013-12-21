package com.comtab.service;

import java.util.List;

import com.comtab.model.Cart;
import com.comtab.model.Customer;

public interface CartService {
	public  Cart AddCart(Customer cus);
	public List<Cart> GetAll();
	public List<Cart> GetCarts(String username);
}
