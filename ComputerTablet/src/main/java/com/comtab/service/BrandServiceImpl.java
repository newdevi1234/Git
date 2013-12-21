package com.comtab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comtab.dao.BrandDAO;
import com.comtab.dao.BrandDAOImpl;
import com.comtab.model.Brand;

@Repository 
@SuppressWarnings({"unchecked", "rawtypes"})
public class BrandServiceImpl implements BrandService {

	@Autowired private BrandDAO brandDAOImpl;
	
	public List<Brand> GetAll() {		
		return brandDAOImpl.GetAll();
	}

}
