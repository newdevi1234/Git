<%-- 
Document   : Top
Created on : Oct 24, 2013, 3:35:44 PM
Author     : PC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>

<div class="right_content">
	<c:if test="${advancedsearch != 'advancedsearch' }">
	  <div class="top_search">
      	<a href="home.do?advancedsearch=advancedsearch">
      		<div class="search_text"><b>Advanced Search</b></div>
      		<img src="<c:url value="/resources/images/search.gif"/>" class="search_bt"/></a>
      </div>
    </c:if>
      <div class="shopping_cart">
		        <div class="cart_title">Shopping cart</div>
		        <div class="cart_details">${totalItems} items <br />
		          <span class="border_cart"></span> Total: <span class="price">${totalPrice }$</span> </div>
		        <div class="cart_icon"><a href="cart.do" title="header=[Checkout] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/shoppingcart.png"/>" alt="" width="48" height="48" border="0" /></a></div>
		     </div>
		      
      
      <c:choose>
      	<c:when test="${advancedsearch == 'advancedsearch' }">
      		<div class="title_box">Advanced Search</div>
      		<div class="searchform">
      		<div class="search">
      			<form:form action="search.do" method="get" modelAttribute="searchmodel">
      				<b>Brands </b>
      				<form:select path="brandId" >
      					<option value="B00" selected>All</option>
      					<c:forEach var="br" items="${listBrand}">
      						<option value="${br.id }">${br.name}</option>
      					</c:forEach>
      				</form:select>
      				<br/>
      				<b>Price</b><br/>
      				<form:radiobutton path="price" value="0" />All price<br/>
      				<form:radiobutton path="price" value="300"/>Greater than 300$<br/>
      				<form:radiobutton path="price" value="500"/>Greater than 500$<br/>
      				<form:radiobutton path="price" value="800"/>Greater than 800$
      				<br/>
      				<b>Size</b><br/>
      				<form:radiobutton path="size" value="" />All size<br/>
      				<c:forEach var="size" items="${listSize}">
      					<form:radiobutton path="size" value="${size}" />${size } inch<br/>
      				</c:forEach>
      				
      				<b>Color</b><br/>
      				<form:radiobutton path="color" value="" />All color<br/>
      				<c:forEach var="color" items="${listColor}">
      					<form:radiobutton path="color" value="${color}" />${color }<br/>
      				</c:forEach>
      				
      				<b>Type</b><br/>
      				<form:radiobutton path="type" value="" />All type<br/>
      				<form:radiobutton path="type" value="com" />Computer
      				<form:radiobutton path="type" value="tab"/>Tablet
      				<br/>
      				<div style="margin: auto; width: 40%">
      					<form:input class="search_input" type="submit" value="Search" path="searchbtn"/>
      				</div>
      				 
      			</form:form>
      		</div>			
      		</div>
      	</c:when>
      	<c:otherwise>
      		
		     <div class="title_box">Whats new</div>
		     <div class="border_box">
		        <div class="product_title"><a href="details.html">${newProduct.name}</a></div>
		        <div class="product_img"><a href="details.html"><img src="<c:url value="/resources/images/products/${newProduct.picture}"/>" alt="" border="0" /></a></div>
		        <c:forEach var="saleoff" items="${listSaleOff}">
		        	<c:if test="${newProduct.id == saleoff.product.id}">
		        		<div class="prod_price">
			        		<c:if test="${saleoff.discount > 0 }">
			        			<span class="reduce">${newProduct.price}</span> 
			        		</c:if>
		        			<span class="price">${newProduct.price*(1-saleoff.discount/100)}$</span>
		       			</div>	
		        	</c:if>
		        </c:forEach>
		     </div>
		     <div class="banner_adds"> <a href="#"><img src="<c:url value="/resources/images/bann1.jpg"/>" alt="" border="0" /></a> </div>
      	</c:otherwise>
      </c:choose>
      
      
      
      
      
      
   
   
   </div>
    
    
 