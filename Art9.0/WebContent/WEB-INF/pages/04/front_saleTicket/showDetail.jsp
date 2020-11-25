<%@page import="tw.group4._04_.front.shopcart.model.Shoppingcart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>節目內容</title>
<style>
td {
	width: 100px;
}

.halfnum {
	width: 30px;
}

.adultnum {
	width: 30px;
}

.title {
	width: 200px;
}

.total1 {
	width: 120px;
}

.total2 {
	width: 120px;
}

.totalprice {
	width: 120px;
}

.price2 {
	width: 200px;
}
</style>

<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"> -->

<!-- <!-- jQuery and JS bundle w/ Popper.js --> -->
<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script> -->


</head>

<body>

<!-- start banner Area -->
			<section class="banner-area relative" id="home">	
				<div class="overlay overlay-bg"></div>
				<div class="container">
					<div class="row d-flex align-items-center justify-content-center">
						<div class="about-content col-lg-12">
							<h1 class="text-white">
								AAART Shop
							</h1>	
							<p class="text-white link-nav"><a href="index.html">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="<c:url value='/14/shopListController.ctrl' />"> Shop</a></p>
						</div>											
					</div>
				</div>
			</section>
	<!-- End banner Area -->

<div class="container">

		<form name="order" action="<c:url value='/04/booking.ctrl'/>" method="get">

		<!-- 用param.取，相當於request.getParameter-->
		<c:set var="actid" value="${actid}" scope="session"/>
		<c:set var="title" value="${title}" scope="session" />
		<c:set var="site" value="${site}" scope="session" />
		<c:set var="description" value="${description}" scope="session" />
<%-- 		<jsp:useBean id="shoppingCart" class="tw.group4._04_.front.shopcart.model.Shoppingcart" scope="session"/>  --%>
<%-- 		<jsp:setProperty name="shoppingCart" property="*"/> --%>
		
<%-- 		<c:set var="title" value="${param.title}" scope="session" /> --%>
<%-- 		<c:set var="description" value="${param.description}" /> --%>


		<H1>節目詳細 </H1>
		<H2>節目名稱: ${title}</H2>	
		<H2>地點: ${site}</H2>		
<!-- 		<H2>主辦單位:</H2>		 -->
<%-- 		<H2>${}</H2> --%>
<!-- 		<H2>演出單位:</H2>		 -->
<%-- 		<H2>${}</H2> --%>
		<H2>活動日期: ${startdate} ~ ${enddate}</H2>		

		
		
		節目簡介:
		<P>${description}</P><br><br>
		
		圖片:
		<img style='display:block;width:800px;' src="data:image/jpg;base64,${photo}" >
		
		<br><br><iframe width="100%" height="250" frameborder="0" src="https://www.google.com/maps?q=${site}&output=embed"></iframe>
	
		
		
		

		
				<br><br>                                                                                          j                                   <H2>票券資訊</H2>
		<table class="table table-bordered">
		<tr> 
				<td>節目名稱</td>
				<td>票種</td>
				<td>座位</td>
				<td>票價</td>
				

			</tr>
			<tr> 
				<td class="title">${title}</td>
				<td>半票</td>
				<td>自行劃位</td>
				<td>NT$1000</td>
				
			</tr>
						<tr> 
				<td class="title">${title}</td>
				<td>全票</td>
				<td>自行劃位</td>
				<td>NT$2000</td>
				
			</tr>
		</table>
		
				<br><br><input type="submit" class="btn btn-outline-info" value="購買">

		</form>
		
		
</body>

</html>