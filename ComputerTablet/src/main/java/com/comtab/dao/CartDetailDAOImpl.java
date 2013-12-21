/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtab.dao;


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
import com.comtab.model.CartDetail;
import com.comtab.model.Product;

/**
 *
 * @author PC
 */
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class CartDetailDAOImpl implements CartDetailDAO{
	
	@Autowired private SessionFactory sessionFactory;
	@Autowired private ProductDAO productDAOImpl;
	
	@Transactional
     public CartDetail AddCartDetail(Cart cart, Product pr){
		Session session = sessionFactory.getCurrentSession();
		CartDetail cartDetail = new CartDetail();
        try {         	
            List<CartDetail> listCartDetail = GetAll();
            int size = 0;
            if (listCartDetail != null)
                size = listCartDetail.size();
            cartDetail.setId(size);
            cartDetail.setCart(cart);
            cartDetail.setProduct(pr);
            cartDetail.setOrderAmount(pr.getAmount());
            
            session.saveOrUpdate(cartDetail);
            productDAOImpl.Update(pr);

            
        } catch (HibernateException ex) { 
            //Log the exception 
            System.err.println(ex);   
            cartDetail = null;
        } finally { 
            //session.close(); 
        } 
        return cartDetail; 
    }

	@Transactional
    public List<CartDetail> GetAll() {
		Session session = sessionFactory.getCurrentSession();
        List<CartDetail> listCartDetail = null;
        try { 
            String hql = "select cartdetail from CartDetail cartdetail";
            Query query = session.createQuery(hql);
            listCartDetail = query.list();
        } catch (HibernateException ex) { 
            //Log the exception 
            System.err.println(ex);
        } finally { 
            //session.close(); 
        } 
        return listCartDetail; 
    }
    
	@Transactional
    public List<CartDetail> GetCartDetails(int cartid) {
		Session session = sessionFactory.getCurrentSession(); 
        List<CartDetail> listCartDetail = null;
        try { 
            String hql = "select cartdetail from CartDetail cartdetail where cartdetail.cart.id = :cartid";
            Query query = session.createQuery(hql);
            query.setString("cartid", ""+cartid);
            listCartDetail = query.list();
        } catch (HibernateException ex) { 
            //Log the exception 
            System.err.println(ex);
        } finally { 
            //session.close(); 
        } 
        return listCartDetail; 
    }
}
