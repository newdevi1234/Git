package com.comtab.model;
// Generated Oct 17, 2013 7:06:35 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Danhmuc generated by hbm2java
 */

@Entity
@Table(name = "brand")
public class Brand {
	
	@Id
     private String id;
     private String name;
     @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
     private Set<Product> products = new HashSet(0);

    public Brand() {
    }
	
    public Brand(String id) {
        this.id = id;
    }
    
    public Brand(String id, String name, Set products) {
       this.id = id;
       this.name = name;
       this.products = products;
    }


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}
   
   


}


