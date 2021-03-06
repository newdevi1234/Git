package com.comtab.dao;

import java.util.List;

import com.comtab.model.Cart;
import com.comtab.model.CartDetail;
import com.comtab.model.Product;

public interface CartDetailDAO {

	 public CartDetail AddCartDetail(Cart cart, Product pr);
	 public List<CartDetail> GetAll();
	 public List<CartDetail> GetCartDetails(int cartid);
}
