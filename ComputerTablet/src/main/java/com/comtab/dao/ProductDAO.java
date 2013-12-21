package com.comtab.dao;

import java.util.List;

import com.comtab.model.Product;



public interface ProductDAO {
	public List<Product> GetAll();
	public Product GetProduct(String id);
	public List<Product> GetProduct(String brandId, String price, String size, String color, String type);
	public void Update(Product product);
	public List<String> GetAllSize();
	public List<String> GetAllColor();
}
