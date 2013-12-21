package com.comtab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comtab.dao.BrandDAO;
import com.comtab.dao.BrandDAOImpl;
import com.comtab.dao.SaleOffDAO;
import com.comtab.model.Brand;
import com.comtab.model.SaleOff;

@Repository 
@SuppressWarnings({"unchecked", "rawtypes"})
public class SaleOffServiceImpl implements SaleOffService {

	@Autowired private SaleOffDAO saleOffDAOImpl;
	
	public List<SaleOff> GetAll() {		
		return saleOffDAOImpl.GetAll();
	}

}
