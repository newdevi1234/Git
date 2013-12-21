/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtab.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comtab.model.Product;



/**
 *
 * @author PC
 */
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired private SessionFactory sessionFactory;
	

	@Transactional
    public List<Product> GetAll() { 
        List<Product> listProduct = null; 
        Session session = sessionFactory.getCurrentSession(); 
        try { 
            String hql = "select pr from Product pr";
            Query query = session.createQuery(hql);
            listProduct = query.list();
        } catch (HibernateException ex) { 
            //Log the exception 
            System.err.println(ex);
        } finally { 
            //session.close(); 
        } 
        return listProduct; 
    }
    
	@Transactional
    public Product GetProduct(String id) { 
		Product product = null;
        Session session = sessionFactory.getCurrentSession(); 
        try { 
        	product =(Product) session.get(Product.class,id);
        } catch (HibernateException ex) { 
            //Log the exception 
            System.err.println(ex);  
        } finally { 
            //session.close(); 
        } 
        return product; 
    }
    
	@Transactional
    public List<Product> GetProduct(String brandid, String price, String size, String color,String type) { 
        List<Product> listProduct = null; 
        Session session = sessionFactory.getCurrentSession(); 
        double Price = 0;
        try{
            Price = Double.parseDouble(price);
        }catch(Exception e){
            
        }
        double Size = 0;
        try{
            Size = Double.parseDouble(size);
        }catch(Exception e){
            
        }
        try { 
            
            String hql = "select pr from Product pr  where pr.amount <= 1000";
            if (brandid != null && brandid.equals("B00") == false)        
                hql = hql + " and pr.brand.id =:brandid";
            if (Price != 0)
                hql = hql + " and pr.price > :Price";
            if (Size != 0)
                hql = hql + " and pr.size =:Size";
            if (color != null && color.equals("") == false)
                hql = hql + " and pr.color = :color";
            if (type != null && type.equals("") == false)
                hql = hql + " and pr.type = :type";
            
            Query query = session.createQuery(hql);
            
            if (brandid != null && brandid.equals("B00") == false)    
                query.setString("brandid", brandid);
            if (Price!=0)
                query.setString("Price", ""+Price);
            if (Size != 0)
                query.setString("Size", ""+Size);
            if (color != null && color.equals("") == false)
                query.setString("color", color);
            if (type != null && type.equals("") == false)
            	query.setString("type", type);
            listProduct = query.list();
        } catch (HibernateException ex) { 
            //Log the exception 
            System.err.println(ex);
        } finally { 
            //session.close(); 
        } 
        return listProduct; 
    }

	@Transactional
    public void Update(Product pr) {
		Session session = sessionFactory.getCurrentSession(); 
        try { 
//            sp.setSoluong(GetSP(sp.getMasp()).getSoluong() - sp.getSoluong()); 
//            session.update(sp);  
        	String amount =(GetProduct(pr.getId()).getAmount() - pr.getAmount()) + "";
        	String hql = "update Product pr set pr.amount = :amount where pr.id = :id";
            Query query = session.createQuery(hql);
            query.setString("amount", amount);
            query.setString("id", pr.getId());
            query.executeUpdate();
        } catch (HibernateException ex) { 
            //Log the exception 
            System.err.println(ex);             
        }catch (Exception ex){
            System.err.println(ex); 
        } finally {  
            //session.close(); 
        } 
    }
	
	@Transactional
	public List<String> GetAllSize(){
		List<String> listSize = new ArrayList<String>();
		List<Product> listProduct = GetAll();
		for (Product product : listProduct) {
			int i=0;
			for (i = 0; i < listSize.size(); i++) {
				if (listSize.get(i).equals(product.getSize().toString()) )
					break;
			}
			if (i == listSize.size())
				listSize.add(product.getSize().toString());				
		}
		
		return listSize;
	}
	@Transactional
	public List<String> GetAllColor(){
		List<String> listColor = new ArrayList<String>();
		List<Product> listProduct = GetAll();
		for (Product product : listProduct) {
			int i=0;
			for (i = 0; i < listColor.size(); i++) {
				if (listColor.get(i).equals(product.getColor()))
					break;
			}
			if (i == listColor.size())
				listColor.add(product.getColor());				
		}
		
		return listColor;
	}
}
