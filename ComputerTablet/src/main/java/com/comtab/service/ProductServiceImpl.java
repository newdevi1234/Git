package com.comtab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comtab.dao.BrandDAO;
import com.comtab.dao.ProductDAO;
import com.comtab.model.Product;

@Repository 
@SuppressWarnings({"unchecked", "rawtypes"})
public class ProductServiceImpl implements ProductService{
	@Autowired private ProductDAO productDAOImpl;
	
	public List<Product> GetAll(){
		return productDAOImpl.GetAll();
	}
	public Product GetProduct(String id){
		return productDAOImpl.GetProduct(id);
	}
	public List<Product> GetProduct(String brandId, String price, String size, String color, String type){
		return productDAOImpl.GetProduct(brandId, price, size, color, type);
	}
	public void Update(Product product){
		productDAOImpl.Update(product);
	}
	public List<String> GetAllSize(){
		return productDAOImpl.GetAllSize();
	}
	
	public List<String> GetAllColor(){
		return productDAOImpl.GetAllColor();
	}
}
