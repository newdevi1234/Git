<%-- 
Document   : Top
Created on : Oct 24, 2013, 3:35:44 PM
Author     : PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="tiles"  uri="http://tiles.apache.org/tags-tiles"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>
	<tiles:insertAttribute name="title"/>
</title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/iecss.css"/>" />
<![endif]-->
<script type="text/javascript" src="<c:url value="/resources/js/boxOver.js"/>"></script>
</head>
<body>
<div id="main_container">
  
  <tiles:insertAttribute name="header"/>
  
  <div id="main_content">
  
    <tiles:insertAttribute name="menu"/>
    <!-- end of menu tab -->
        
    <div class="crumb_navigation"> Navigation: <span class="current">Home</span> </div>
    
    <tiles:insertAttribute name="left"/>
    <!-- end of left content -->
    
    <tiles:insertAttribute name="center"/>
    <!-- end of center content -->
    
    <tiles:insertAttribute name="right"/>
    <!-- end of right content -->
    
  </div>
  <!-- end of main content -->
  
  <tiles:insertAttribute name="footer"/>
</div>
<!-- end of main_container -->

</html>
