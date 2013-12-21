package com.comtab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comtab.dao.CartDetailDAO;
import com.comtab.model.Cart;
import com.comtab.model.CartDetail;
import com.comtab.model.Product;


@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class CartDetailServiceImpl implements CartDetailService{
	@Autowired private CartDetailDAO cartDetailDAOImpl;
	
	public CartDetail AddCartDetail(Cart cart, Product pr){
		return cartDetailDAOImpl.AddCartDetail(cart, pr);
	}
	 public List<CartDetail> GetAll(){
		 return cartDetailDAOImpl.GetAll();
	 }
	 public List<CartDetail> GetCartDetails(int cartid){
		 return cartDetailDAOImpl.GetCartDetails(cartid);
	 }
}
