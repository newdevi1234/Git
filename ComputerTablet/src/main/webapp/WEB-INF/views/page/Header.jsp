<%-- 
Document   : Top
Created on : Oct 24, 2013, 3:35:44 PM
Author     : PC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>

<div class="top_bar">
<!--     <div class="top_search"> -->
<!--       <div class="search_text"><a href="#">Advanced Search</a></div> -->
<!--       <input type="text" class="search_input" name="search" /> -->
<%--       <input type="image" src="<c:url value="/resources/images/search.gif"/>" class="search_bt"/> --%>
<!--     </div> -->
    
  </div>
  <div id="header">
    <div id="logo"> <a href="home.do"><img src="<c:url value="/resources/images/logo.png"/>" alt="" border="0" width="237" height="140" /></a> </div>
    <div class="oferte_content">
      <div class="top_divider"><img src="<c:url value="/resources/images/header_divider.png"/>" alt="" width="1" height="164" /></div>
      <div class="oferta">
        <div class="oferta_content"> <img src="<c:url value="/resources/images/laptop.png"/>" width="94" height="92" alt="" border="0" class="oferta_img" />
          <div class="oferta_details">
            <div class="oferta_title">Computer and Tablet</div>
            <div class="oferta_text"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco </div>           
          </div>
		</div>
      </div>
      <div class="top_divider"><img src="<c:url value="/resources/images/header_divider.png"/>" alt="" width="1" height="164" /></div>
    </div>
    <!-- end of oferte_content-->
  </div>