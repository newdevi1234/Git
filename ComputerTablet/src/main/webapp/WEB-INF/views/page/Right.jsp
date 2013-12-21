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
      <div class="shopping_cart">
        <div class="cart_title">Shopping cart</div>
        <div class="cart_details"> 3 items <br />
          <span class="border_cart"></span> Total: <span class="price">350$</span> </div>
        <div class="cart_icon"><a href="http://all-free-download.com/free-website-templates/" title="header=[Checkout] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/shoppingcart.png"/>" alt="" width="48" height="48" border="0" /></a></div>
      </div>
      <div class="title_box">Whats new</div>
      <div class="border_box">
        <div class="product_title"><a href="details.html">Motorola 156 MX-VL</a></div>
        <div class="product_img"><a href="details.html"><img src="<c:url value="/resources/images/p2.gif"/>" alt="" border="0" /></a></div>
        <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
      </div>
      <div class="title_box">Manufacturers</div>
      <ul class="left_menu">
        <li class="odd"><a href="http://all-free-download.com/free-website-templates/">Sony</a></li>
        <li class="even"><a href="http://all-free-download.com/free-website-templates/">Samsung</a></li>
        <li class="odd"><a href="http://all-free-download.com/free-website-templates/">Daewoo</a></li>
        <li class="even"><a href="http://all-free-download.com/free-website-templates/">LG</a></li>
        <li class="odd"><a href="http://all-free-download.com/free-website-templates/">Fujitsu Siemens</a></li>
        <li class="even"><a href="http://all-free-download.com/free-website-templates/">Motorola</a></li>
        <li class="odd"><a href="http://all-free-download.com/free-website-templates/">Phillips</a></li>
        <li class="even"><a href="http://all-free-download.com/free-website-templates/">Beko</a></li>
      </ul>
      <div class="banner_adds"> <a href="http://all-free-download.com/free-website-templates/"><img src="<c:url value="/resources/images/bann1.jpg"/>" alt="" border="0" /></a> </div>
    </div>