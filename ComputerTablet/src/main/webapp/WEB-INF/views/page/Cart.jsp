<%-- 
Document   : Top
Created on : Oct 24, 2013, 3:35:44 PM
Author     : PC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>

<div class="center_content">
   <div class="center_title_bar">
		   <c:choose>
		   	<c:when test="${message == '' || message == null}"> Cart</c:when>
		   	<c:otherwise><div style="color:red">${message }</div></c:otherwise>
		   </c:choose>
	   </div>
   
	<c:forEach var="pr" items="${listProduct}">
		 <div class="prod_box_big">
   			<div class="top_prod_box_big"></div>
			<div class="center_prod_box_big">
			
 					<div class="product_img_big"><img src="<c:url value="/resources/images/products/${pr.picture}" />" alt="" border="0" />

 					</div>
 					
 					<div class="details_big_box">
   					<div class="product_title_big">${pr.name}</div>
   					<div class="specifications"> 
    					Color: <span class="blue">${pr.color}</span><br />
      					Size: <span class="blue">${pr.size}</span><br />
      					<c:forEach var="tempPr" items="${allProduct}">
      						<c:if test="${pr.id == tempPr.id }">
      							Curent Amount: <span class="blue">${tempPr.amount}</span><br />
      						</c:if>
      					</c:forEach>
      					
      					Order Amount: <span class="blue">${pr.amount}</span><br />
      				</div>            					
  					    <c:forEach var="saleoff" items="${listSaleOff}">
		        	<c:if test="${pr.id == saleoff.product.id}">
		        		<div class="prod_price_big">
			        		<c:if test="${saleoff.discount > 0 }">
			        			<span class="reduce">${pr.price}</span> 
			        		</c:if>
		        			<span class="price">${pr.price*(1-saleoff.discount/100)}$</span>
	        			</div>	
		        	</c:if>
		        </c:forEach>
   					
   					<form:form action="addremovecart.do" method="get" modelAttribute="addremovecartmodel">
   		<div style="float: left;padding: 3px;font-weight: bold;">Removed Amount<form:input style="text-align: center;" type="text" size="3" path="amount" value="1" /></div>
    	<div class="left_bt">
     	<a href="#" title="header=[remove from cart] body=[&nbsp;] fade=[on]">
     		<input name="addCartBtn" type="image" src="<c:url value="/resources/images/removecart.gif"/>" value="Remove"/>
    		</a> 
   		</div>
    	
    	<form:hidden path="view" value="cart" />
    	<form:hidden path="pageNumber" value="${pageNumber}"/>
    	<form:hidden path="productId" value="${pr.id}"/>
    	<form:hidden path="method" value="removeCart"/>
  		</form:form>
  		<form:form action="addremovecart.do" method="get" modelAttribute="addremovecartmodel">						      		
    	
    	<div class="left_bt">
     	<a href="#" title="header=[remove all this product from cart] body=[&nbsp;] fade=[on]">
     		<input name="addCartBtn" type="image" src="<c:url value="/resources/images/removeitem.gif"/>" value="Remove"/>
    		</a> 
   		</div>
    	
    	<form:hidden path="view" value="cart" />
    	<form:hidden path="pageNumber" value="${pageNumber}"/>
    	<form:hidden path="productId" value="${pr.id}"/>
    	<form:hidden path="method" value="removeAllThisProduct"/>
  		</form:form>
  		 <a href="#" class="compare">compare</a> </div>
			</div>
			
			<div class="bottom_prod_box_big"></div>
		</div>
	   			
	</c:forEach>
			
	<p style="clear:both"></p>
   <div class="paging">
   	<c:if test="${pageNumber > 1 }">
   		<a href="paging.do?view=cart&pagenumber=${pageNumber - 1}">
	 		<input class="search_input" type="button" value="<|" />
		</a>
   	</c:if>	
	 <c:forEach var="i" begin="1" end="${totalPage}">
	 	<c:choose>
	 		<c:when test="${i == pageNumber }">	 		
	 			<input class="paging_input" type="button" value="${i}" />
	 		</c:when>
	 		<c:otherwise>
	 			<a href="paging.do?view=cart&pagenumber=${i}">
	 				<input class="search_input" type="button" value="${i}" />
				</a>
	 		</c:otherwise>
	 	</c:choose>
	 	
	 </c:forEach>   
	 <c:if test="${pageNumber < totalPage }">
   		<a href="paging.do?view=cart&pagenumber=${pageNumber + 1}">
	 		<input class="search_input" type="button" value="|>" />
		</a>
   	</c:if>	
    </div>
 </div>
