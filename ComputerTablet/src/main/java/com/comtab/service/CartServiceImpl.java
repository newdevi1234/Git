package com.comtab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comtab.dao.CartDAO;
import com.comtab.model.Cart;
import com.comtab.model.Customer;

@Repository 
@SuppressWarnings({"unchecked", "rawtypes"})
public class CartServiceImpl implements CartService {
	@Autowired private CartDAO cartDAOImpl;
	public  Cart AddCart(Customer cus){
		return cartDAOImpl.AddCart(cus);
	}
	public List<Cart> GetAll(){
		return cartDAOImpl.GetAll();
	}
	public List<Cart> GetCarts(String username){
		return cartDAOImpl.GetCarts(username);
	}
}
