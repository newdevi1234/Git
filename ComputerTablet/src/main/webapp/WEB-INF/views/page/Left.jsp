<%-- 
Document   : Top
Created on : Oct 24, 2013, 3:35:44 PM
Author     : PC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>

<div class="left_content">
      <div class="title_box">Brands</div>
      <ul class="left_menu">
      <c:forEach var="i" begin="0" end="${listBrand.size()-1}" step="2">
      		<li class="odd">
      			<a href="search.do?brandId=${listBrand[i].id}">
      				<div class="brand">${listBrand[i].name}</div>
      			</a></li>
      		<c:if test="${i < listBrand.size()}">
      			<li class="even">
      				<a href="search.do?brandId=${listBrand[i+1].id}">
	      				<div class="brand">${listBrand[i+1].name}</div>
	      			</a></li>
      		</c:if>        	
      </c:forEach>
        
      </ul>
      <div class="title_box">Special Products</div>
      <div class="border_box">
        <div class="product_title"><a href="details.html">${bigSaleProduct.name }</a></div>
        <div class="product_img"><a href="details.html"><img src="<c:url value="/resources/images/products/${bigSaleProduct.picture }"/>" alt="" border="0" /></a></div>
        <c:forEach var="saleoff" items="${listSaleOff}">
        	<c:if test="${bigSaleProduct.id == saleoff.product.id}">
        		<div class="prod_price">
	        		<c:if test="${saleoff.discount > 0 }">
	        			<span class="reduce">${bigSaleProduct.price}</span> 
	        		</c:if>
        			<span class="price">${bigSaleProduct.price*(1-saleoff.discount/100)}$</span>
       			</div>	
        	</c:if>
        </c:forEach>
      </div>
      
      <div class="banner_adds"> <a href="#"><img src="<c:url value="/resources/images/bann2.jpg"/>" alt="" border="0" /></a> </div>
    </div>