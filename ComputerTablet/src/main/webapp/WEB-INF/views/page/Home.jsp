<%-- 
Document   : Top
Created on : Oct 24, 2013, 3:35:44 PM
Author     : PC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<div class="center_content">
	<div class="center_title_bar">Order Detail</div>
	<!--     <div class="prod_box"> -->
	<!--     <div class="top_prod_box"></div> -->
	<!--       <div class="center_prod_box"> -->
	<!--         <div class="product_title"><a href="About.jsp">Motorola 156 MX-VL</a></div> -->
	<%--         <div class="product_img"><a href="details.html"><img src="<c:url value="/resources/images/laptop.gif"/>" alt="" border="0" /></a></div> --%>
	<!--         <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div> -->
	<!--       </div> -->
	<!--       <div class="bottom_prod_box"></div> -->
	<%--       <div class="prod_details_tab"> <a href="http://all-free-download.com/free-website-templates/" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/cart.gif"/>" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/favs.gif"/>" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/favorites.gif"/>" alt="" border="0" class="left_bt" /></a> <a href="details.html" class="prod_details">details</a> </div> --%>
	<!--     </div> -->
	<div class="centerpage">
		<div class="specifications2">
			<form action="">
				<table>
					<tr>
						<td style="width: 120px">ID:</td>
					</tr>
					<tr>
						<td>Order Name:</td>
					<tr>
					<tr>
						<td>Receive Name:</td>
						<td><input type="text" name="recivename"></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><input type="text" name="address"></td>
					</tr>
					<tr>
						<td>Phone:</td>
						<td><input type="text" name="phone"></td>
					</tr>
					<tr>
						<td>Product name:</td>
					</tr>
					<tr>
						<td>Total:</td>
					</tr>
				
				</table>
				<input type="submit" name="submit" value="Pay">
				<input type="submit" name="submit" value="Cancel">  
			</form>
		</div>
	</div>





</div>
