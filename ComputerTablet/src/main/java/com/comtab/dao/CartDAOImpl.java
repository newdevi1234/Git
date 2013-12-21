/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtab.dao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comtab.model.Cart;
import com.comtab.model.Customer;
/**
 *
 * @author PC
 */
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class CartDAOImpl implements CartDAO{
	
	@Autowired private SessionFactory sessionFactory;
	
	@Transactional
    public  Cart AddCart(Customer cus){
		Session session = sessionFactory.getCurrentSession(); 
        
        Cart cart = new Cart();
        try {         	
            List<Cart> listbasket = GetAll();
            int size = 0;
            if (listbasket != null)
                size = listbasket.size();
            cart.setId(size);
            cart.setCustomer(cus);
            //Lay gio he thong
            Date todayD=new Date(System.currentTimeMillis()); 
            //Khai bao dinh dang ngay thang
            SimpleDateFormat dayFormat= new SimpleDateFormat("dd/MM/yyyy"); 
            //parse ngay thang sang dinh dang va chuyen thanh string.
            String todayS=dayFormat.format(todayD.getTime());
            cart.setCreatedDay(todayS);
            
            session.saveOrUpdate(cart);
            
        } catch (HibernateException ex) { 
            //Log the exception 
            System.err.println(ex);  
            cart = null;
        } finally { 
            //session.close(); 
        } 
        return cart; 
    }

	@Transactional
    public List<Cart> GetAll() {
		Session session = sessionFactory.getCurrentSession();
        List<Cart> listCart = null;
        try { 
            String hql = "select carts from Cart carts";
            Query query = session.createQuery(hql);
            listCart = query.list();
        } catch (HibernateException ex) { 
            //Log the exception 
            System.err.println(ex);  
        } finally { 
            //session.close(); 
        } 
        return listCart; 
    }
    
	@Transactional
    public List<Cart> GetCarts(String username) {
		Session session = sessionFactory.getCurrentSession(); 
        List<Cart> listCart = null;
        try { 
            String hql = "select cart from Cart cart where cart.customer.username = :username";
            Query query = session.createQuery(hql);
            query.setString("username", username);
            listCart = query.list();
        } catch (HibernateException ex) { 
            //Log the exception 
            System.err.println(ex); 
        } finally { 
            //session.close(); 
        } 
        return listCart; 
    }
            
}
