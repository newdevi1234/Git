<%-- 
Document   : Top
Created on : Oct 24, 2013, 3:35:44 PM
Author     : PC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>
<c:if test="${listProduct != null}">
<div class="center_content">
	
	   <div class="center_title_bar">
		   <c:choose>
		   	<c:when test="${message == '' || message == null}"> Latest Products</c:when>
		   	<c:otherwise><div style="color:red">${message }</div></c:otherwise>
		   </c:choose>
	   </div>
	   <c:forEach var="pr" items="${listProduct}">
	   	 <div class="prod_box">
		    <div class="top_prod_box"></div>
		    <div class="center_prod_box">
		        <div class="product_title"><a href="details.html">${pr.name}</a></div>
		        <div class="product_img"><a href="details.html"><img src="<c:url value="/resources/images/products/${pr.picture}"/>" alt="" border="0" /></a></div>
		        <c:forEach var="saleoff" items="${listSaleOff}">
		        	<c:if test="${pr.id == saleoff.product.id}">
		        		<div class="prod_price">
			        		<c:if test="${saleoff.discount > 0 }">
			        			<span class="reduce">${pr.price}</span> 
			        		</c:if>
		        			<span class="price">${pr.price*(1-saleoff.discount/100)}$</span>
	        			</div>	
		        	</c:if>
		        </c:forEach>
		         
		      </div>  
		       
		      
		    <div class="bottom_prod_box"></div>
		      
	      	<div class="prod_details_tab"> 
		      	<form:form action="addremovecart.do" method="get" modelAttribute="addremovecartmodel">
		      		<div style="float: left;padding: 3px;"><form:input style="text-align: center;" type="text" size="3" path="amount" value="1" /></div>
			      	<div class="left_bt">
				      	<a href="#" title="header=[Add to cart] body=[&nbsp;] fade=[on]">
				      		<input name="addCartBtn" type="image" src="<c:url value="/resources/images/cart.gif"/>"/>
			      		</a> 
		      		</div>
			      	<a href="#" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/favs.gif"/>" alt="" border="0" class="left_bt" /></a> 
			      	<a href="#" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/favorites.gif"/>" alt="" border="0" class="left_bt" /></a> 
			      	<a href="details.html" class="prod_details">details</a> 
			      	<form:hidden path="view" value="home" />
			      	<form:hidden path="pageNumber" value="${pageNumber}"/>
			      	<form:hidden path="productId" value="${pr.id}"/>
			      	<form:hidden path="method" value="addCart"/>
	      		</form:form>
	      	</div>
		      
		      
		 </div>
	   </c:forEach>
   
   <p style="clear:both"></p>
   <div class="paging">
   	<c:if test="${pageNumber > 1 }">
   		<a href="paging.do?view=home&pagenumber=${pageNumber - 1}">
	 		<input class="search_input" type="button" value="<|" />
		</a>
   	</c:if>	
	 <c:forEach var="i" begin="1" end="${totalPage}">
	 	<c:choose>
	 		<c:when test="${i == pageNumber }">	 		
	 			<input class="paging_input" type="button" value="${i}" />
	 		</c:when>
	 		<c:otherwise>
	 			<a href="paging.do?view=home&pagenumber=${i}">
	 				<input class="search_input" type="button" value="${i}" />
				</a>
	 		</c:otherwise>
	 	</c:choose>
	 	
	 </c:forEach>   
	 <c:if test="${pageNumber < totalPage }">
   		<a href="paging.do?view=home&pagenumber=${pageNumber + 1}">
	 		<input class="search_input" type="button" value="|>" />
		</a>
   	</c:if>	
    </div>
 </div>
</c:if>