package com.comtab.home;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.comtab.model.AddRemoveCartModel;
import com.comtab.model.Brand;
import com.comtab.model.Cart;
import com.comtab.model.Product;
import com.comtab.model.SaleOff;
import com.comtab.model.SearchModel;
import com.comtab.service.BrandService;
import com.comtab.service.BrandServiceImpl;
import com.comtab.service.ProductService;
import com.comtab.service.ProductServiceImpl;
import com.comtab.service.SaleOffService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private int pageSizeHome = 6;
	private int pageSizeCart = 3;
	@Autowired private BrandService brandServiceImpl; 
	@Autowired private ProductService productServiceImpl;
	@Autowired private SaleOffService saleOffServiceImpl;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	private List<Product> GetProductPaging(List<Product> oldlistproduct, int pagenumber, int pagesize){
		if (oldlistproduct == null)
			return null;
		
		List<Product> listProduct = new ArrayList<Product>();		
		int start = (pagenumber-1)*pagesize;
		int end = (start+pagesize) < oldlistproduct.size() ? (start+pagesize) : oldlistproduct.size();
		for(int i = start; i < end ; i++){
			listProduct.add(oldlistproduct.get(i));
		}
		return listProduct;
	}
	
	private int CalTotalPage(List<Product> oldlistproduct,int pagesize){
		int offer = oldlistproduct.size() % pagesize;
		return oldlistproduct.size()/pagesize + ((offer > 0) ? 1:0);
	}
	
	private int CalTotalItems(List<Product> listProduct){
		int total = 0;
		for (Product pr : listProduct) {
			total += pr.getAmount();
		}		
		return total;
	}
	
	private double CalTotalPrice(List<Product> listProduct){
		double total = 0;
		for (Product pr : listProduct) {
			total += pr.getPrice() * pr.getAmount();
		}		
		return total;
	}
	 private Product GetBigSaleProduct(List<Product> allproduct, List<SaleOff> listSaleOff){
		 int index = 0;
		 for(int i = 0; i < listSaleOff.size(); i++){
			 if(listSaleOff.get(index).getDiscount() < listSaleOff.get(i).getDiscount()){
				 index = i;
			 }
		 }		 
		 return allproduct.get(index);
	 }
	 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("cart", new ArrayList<Cart>());
		return home("",model,request);
	}
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home( @RequestParam(required=false) String advancedsearch, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Brand> listBrand = brandServiceImpl.GetAll();		
		List<Product> oldListProduct = productServiceImpl.GetAll();
		session.setAttribute("oldListProduct", oldListProduct);		
		List<Product> listProduct = GetProductPaging(oldListProduct,1,pageSizeHome);
						
		
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("listSize", productServiceImpl.GetAllSize());
		model.addAttribute("listColor", productServiceImpl.GetAllColor());
		model.addAttribute("searchmodel", new SearchModel());
		model.addAttribute("advancedsearch", advancedsearch);		
		model.addAttribute("listBrand",listBrand);
		model.addAttribute("totalPage", CalTotalPage(oldListProduct,pageSizeHome));
		model.addAttribute("pageNumber", 1);
		model.addAttribute("addremovecartmodel", new AddRemoveCartModel());
		
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		model.addAttribute("totalItems", CalTotalItems(cart));
		model.addAttribute("totalPrice", CalTotalPrice(cart));
		
		model.addAttribute("listSaleOff", saleOffServiceImpl.GetAll());		
		List<Product> allProduct = productServiceImpl.GetAll();
		model.addAttribute("bigSaleProduct", GetBigSaleProduct(allProduct, saleOffServiceImpl.GetAll()));		
		model.addAttribute("newProduct", allProduct.get(allProduct.size()-1));
		return "home";
	}
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String search(@ModelAttribute("searchmodel") SearchModel searchmodel, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Brand> listBrand = brandServiceImpl.GetAll();
		List<Product> oldListProduct = productServiceImpl.GetProduct(searchmodel.getBrandId(), searchmodel.getPrice(), searchmodel.getSize(), searchmodel.getColor(), searchmodel.getType());
		session.setAttribute("oldListProduct", oldListProduct);
		List<Product> listProduct = GetProductPaging(oldListProduct,1,pageSizeHome);
		
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("listBrand",listBrand);
		model.addAttribute("totalPage", CalTotalPage(oldListProduct,pageSizeHome));
		model.addAttribute("pageNumber", 1);
		model.addAttribute("addremovecartmodel", new AddRemoveCartModel());
		
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		model.addAttribute("totalItems", CalTotalItems(cart));
		model.addAttribute("totalPrice", CalTotalPrice(cart));
		
		model.addAttribute("listSaleOff", saleOffServiceImpl.GetAll());
		List<Product> allProduct = productServiceImpl.GetAll();
		model.addAttribute("bigSaleProduct", GetBigSaleProduct(allProduct, saleOffServiceImpl.GetAll()));		
		model.addAttribute("newProduct", allProduct.get(allProduct.size()-1));
		return "home";
	}
	
	@RequestMapping(value = "/paging.do", method = RequestMethod.GET)
	public String paging(@RequestParam("view") String view, @RequestParam("pagenumber") String pagenumber, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Brand> listBrand = brandServiceImpl.GetAll();
		int pagesize = (view.equals("home"))?pageSizeHome:pageSizeCart;
		List<Product> oldListProduct = (List<Product>)session.getAttribute("oldListProduct");
		List<Product> listProduct = GetProductPaging(oldListProduct, Integer.parseInt(pagenumber),pagesize);

		
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("listBrand",listBrand);
		model.addAttribute("totalPage", CalTotalPage(oldListProduct,pagesize));
		model.addAttribute("pageNumber", pagenumber);
		model.addAttribute("addremovecartmodel", new AddRemoveCartModel());
		
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		model.addAttribute("totalItems", CalTotalItems(cart));
		model.addAttribute("totalPrice", CalTotalPrice(cart));
		
		model.addAttribute("listSaleOff", saleOffServiceImpl.GetAll());
		List<Product> allProduct = productServiceImpl.GetAll();
		model.addAttribute("bigSaleProduct", GetBigSaleProduct(allProduct, saleOffServiceImpl.GetAll()));		
		model.addAttribute("newProduct", allProduct.get(allProduct.size()-1));
		return view;
	}
		
	@RequestMapping(value = "/cart.do", method = RequestMethod.GET)
	public String cart(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Brand> listBrand = brandServiceImpl.GetAll();
		
		List<Product> oldListProduct = (List<Product>)session.getAttribute("cart");
		session.setAttribute("oldListProduct", oldListProduct);
		List<Product> listProduct = GetProductPaging(oldListProduct,1,pageSizeCart);
		List<Product> allProduct = productServiceImpl.GetAll();
		
		model.addAttribute("allProduct", allProduct);	
		model.addAttribute("listProduct", listProduct);				
		model.addAttribute("listBrand",listBrand);
		model.addAttribute("totalPage", CalTotalPage(oldListProduct,pageSizeCart));
		model.addAttribute("pageNumber", 1);
		model.addAttribute("addremovecartmodel", new AddRemoveCartModel());
		
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		model.addAttribute("totalItems", CalTotalItems(cart));
		model.addAttribute("totalPrice", CalTotalPrice(cart));
		
		model.addAttribute("listSaleOff", saleOffServiceImpl.GetAll());
		model.addAttribute("bigSaleProduct", GetBigSaleProduct(allProduct, saleOffServiceImpl.GetAll()));		
		model.addAttribute("newProduct", allProduct.get(allProduct.size()-1));
		return "cart";
	}
	
	@RequestMapping(value = "/addremovecart.do", method = RequestMethod.GET)
	public String addremovecart(@ModelAttribute("addremovecartmodel") AddRemoveCartModel addremovecartmodel, Model model, HttpServletRequest request) {
				
		HttpSession session = request.getSession();
		List<Brand> listBrand = brandServiceImpl.GetAll();
		int pagesize = (addremovecartmodel.getView().equals("home"))?pageSizeHome:pageSizeCart;
		
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		
		String message = "";
		if (addremovecartmodel.getMethod().equals("addCart")){
			try{      
				Product pr = productServiceImpl.GetProduct(addremovecartmodel.getProductId());
                int orderAmount = (int)Integer.parseInt(addremovecartmodel.getAmount());
                if (orderAmount > 0 && orderAmount <= pr.getAmount()){
                    
                    pr.setAmount(orderAmount);
                    int i =0;
                    for (i =0; i < cart.size();i++){
                        if ((cart.get(i).getId()).equals(pr.getId())){
                            cart.get(i).setAmount(cart.get(i).getAmount() + orderAmount);
                            break;
                        }
                    }
                    if (i >= cart.size()){
                        cart.add(pr);
                    }
                    session.setAttribute("cart", cart);
                    message = "You have added this item to your cart";
                }
                else{
                    message = "OrderAmount must be greater than 0 and less than this item's amount";
                } 
            }catch (Exception e){
                message = "OrderAmount must be a number";
            }
			
		}
		
		if (addremovecartmodel.getMethod().equals("removeCart")){
			int i = 0;
			for (i = 0; i < cart.size(); i++) {
				if (cart.get(i).getId().equals(addremovecartmodel.getProductId()))
					break;
			}
			if (i < cart.size()){
				
				try{      
					int removeAmount = (int)Integer.parseInt(addremovecartmodel.getAmount());
					int remainAmount = cart.get(i).getAmount() - removeAmount;
	                if (removeAmount > 0 ){
	                    if (remainAmount <= 0){
	                    	addremovecartmodel.setMethod("removeAllThisProduct");
	                    }
	                    else{
	                    	cart.get(i).setAmount(remainAmount);
		                    session.setAttribute("cart", cart);
		                    session.setAttribute("oldListProduct", cart);
		                    message = "You have removed this item's amount from your cart";
	                    }	                    
	                }
	                else{
	                    message = "RemovedAmount must be greater than 0";
	                } 
	            }catch (Exception e){
	                message = "RemovedAmount must be a number";
	            }
			}
		}
		
		if (addremovecartmodel.getMethod().equals("removeAllThisProduct") ){            
            List<Product> newlistproduct = new ArrayList<Product>();
            for (Product pr : cart){
                if (!pr.getId().equals(addremovecartmodel.getProductId()))
                	newlistproduct.add(pr);
            }
            message = "You have removed this item from your cart";
            session.setAttribute("cart", newlistproduct);   
            session.setAttribute("oldListProduct", newlistproduct);
        }		
		
		List<Product> oldListProduct = (List<Product>)session.getAttribute("oldListProduct");		
		List<Product> listProduct = GetProductPaging(oldListProduct, addremovecartmodel.getPageNumber(),pagesize);
		if(listProduct.size() == 0){
			int number = (addremovecartmodel.getPageNumber()-1 == 0)? 1 : addremovecartmodel.getPageNumber()-1 ;
			addremovecartmodel.setPageNumber(number);
			listProduct = GetProductPaging(oldListProduct, addremovecartmodel.getPageNumber(),pagesize);
		}
		
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("listBrand",listBrand);
		model.addAttribute("message",message);
		model.addAttribute("totalPage", CalTotalPage(oldListProduct,pagesize));
		model.addAttribute("pageNumber", addremovecartmodel.getPageNumber());
		model.addAttribute("addremovecartmodel", new AddRemoveCartModel());
		
		cart = (List<Product>)session.getAttribute("cart");
		model.addAttribute("totalItems", CalTotalItems(cart));
		model.addAttribute("totalPrice", CalTotalPrice(cart));
		
		model.addAttribute("listSaleOff", saleOffServiceImpl.GetAll());
		List<Product> allProduct = productServiceImpl.GetAll();
		model.addAttribute("bigSaleProduct", GetBigSaleProduct(allProduct, saleOffServiceImpl.GetAll()));		
		model.addAttribute("newProduct", allProduct.get(allProduct.size()-1));
		return addremovecartmodel.getView();
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(@RequestParam(required=false) String view,Locale locale, Model model, HttpServletRequest request)
	{
		PrepareView(model, request);
		if ( view.equals("btnOK")== true)
		{
			return "home";
		}
	
		
		return "login";
	}
	
	
	private void PrepareView(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		List<Brand> listBrand = brandServiceImpl.GetAll(); 
		model.addAttribute("listBrand",listBrand);
		model.addAttribute("listSaleOff", saleOffServiceImpl.GetAll()); 
		List<Product> allProduct = productServiceImpl.GetAll();
		model.addAttribute("bigSaleProduct", GetBigSaleProduct(allProduct, saleOffServiceImpl.GetAll())); 
		model.addAttribute("newProduct", allProduct.get(allProduct.size()-1));
		
		model.addAttribute("listSize", productServiceImpl.GetAllSize());
		model.addAttribute("listColor", productServiceImpl.GetAllColor());
		model.addAttribute("searchmodel", new SearchModel());
		model.addAttribute("addremovecartmodel", new AddRemoveCartModel());
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		model.addAttribute("totalItems", CalTotalItems(cart));
		model.addAttribute("totalPrice", CalTotalPrice(cart));
		}
	
}
