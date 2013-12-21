/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtab.dao;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comtab.model.Brand;



/**
 *
 * @author PC
 */
@Repository 
@SuppressWarnings({"unchecked", "rawtypes"})
public class BrandDAOImpl implements BrandDAO{

	@Autowired private SessionFactory sessionFactory;
	 
	@Transactional
    public List<Brand> GetAll() { 
        List<Brand> listBrand = null; 
        Session session = sessionFactory.getCurrentSession();
        try { 
            String hql = "select br from Brand br";
            Query query = session.createQuery(hql);
            listBrand = query.list();
        } catch (HibernateException ex) { 
            //Log the exception 
            System.err.println(ex); 
        } finally { 
            //session.close(); 
        } 
        return listBrand; 
    }
}
