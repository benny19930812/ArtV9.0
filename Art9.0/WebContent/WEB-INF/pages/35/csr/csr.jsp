<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
   <HEAD>
      <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8"/>
      <TITLE>CSR</TITLE>
      <style>
      h1, form {
      	text-align:center
      }
      </style>
   </HEAD>
<BODY BGCOLOR="#FFFFFF">
<c:set var="funcName" value="CSR" scope="session"/>
	<br>
	<H1>贊助偏鄉孩童參加藝文活動</H1>
	<br>
 	<form action="<c:url value='/35/founding.ctrl'/> " method="get">
		<div class="searchBox">
			<input type="text" class="" name="kidsLocation" value="">
		</div>
    	<br>
		<div class="submitButton">
			<input type="submit" class="" name="submit" value="以地點搜尋有媒合需求的偏鄉孩童"> 
		</div>
	</form>
</BODY>
</HTML>