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

	<br><br><table>
	<tr >
		<td class="progressbar">Step 1</td>
		<td class="progressbar">Step 2</td>
		<td class="progressbar">Step 3</td>
		<td class="progressbar">Step 4</td>
	</tr>
	<tr>
	<td  colspan="4" style="width: 50%">
		<div class="progress">
<!-- 		28  -->
		<a class="process-wizard-dot"></a>
  		<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 3%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
	</td>

	</tr>
	<tr>
		<td>區域/張數</td>
		<td>劃位</td>
		<td>購票確認</td>
		<td>完成訂購</td>
	</tr>
	</table><br>





	<form name="order" action="<c:url value='/04/seatSearch.ctrl'/>" method="get">

		<!-- 用param.取，相當於request.getParameter-->
<%-- 		<c:set var="title" value="${param.title}" /> --%>
<%-- 		<c:set var="description" value="${param.description}" /> --%>
<%-- 	<c:set var="actid" value="${param.actid}" scope="session"/> --%>
		
		<H1>節目詳細</H1>
		節目名稱:
		<P>${sessionScope.title}</P>
		節目簡介:
		<P>${sessionScope.description}</P><br><br>
		
		<H2>訂購票券</H2>
		<input type="button" class="btn btn-outline-info" value="電腦劃位">
		<input type="button" class="btn btn-outline-info" value="自行劃位">
		<table class="table table-bordered">
		<tr> 
				<td>節目名稱</td>
				<td>票種</td>
				<td>座位</td>
				<td>票價</td>
				<td>數量</td>

			</tr>
			<tr> 
				<td class="title">${sessionScope.title}</td>
				<td>
				<select id="ticketcategry" name="ticketcategry" class="form-control" >
					<option value="全票">全票</option>
					<option value="半票">半票</option>
				</select>
				</td>
				<td>自行劃位</td>
				<td id="price">NT$2000</td>
				<td><input type="button" value="-" name="minus" class="" id="minus"> 					
					<input type="text" name="ticketnum" id="halfnum" class="halfnum"value="" readonly="readonly"> 
					<input type="button" value="+" name="plus" class="" id="plus">
				</td>
			</tr>
<!-- 			<tr>  -->
<%-- 				<td class="title">${sessionScope.title}</td> --%>
<!-- 				<td>全票</td> -->
<!-- 				<td>自行劃位</td> -->
<!-- 				<td>NT$2000</td> -->
<!-- 				<td><input type="button" value="-" name="minus2" class="" id="minus2"> -->
<!-- 					<input type="text" name="adultnum"id="adultnum" class="adultnum" value="" readonly="readonly">  -->
<!-- 					<input type="button" value="+" name="plus2"class="" id="plus2" > -->
<!-- 				</td> -->
<!-- 			</tr> -->
		</table>
		
		
		
		
		
		
<!-- 		<table class="table table-bordered"> -->
<!-- 			<tr> -->
<!-- 				<td class="title">節目名稱</td> -->
<!-- 				<td>票種</td> -->
<!-- 				<td>數量</td> -->
<!-- 				<td>價格</td> -->
<!-- 				<td class="price2">總價</td> -->

<!-- 			</tr> -->
<!-- 			<tr> -->
<%-- 				<td class="title">${title}</td> --%>
<!-- 				<td>全票</td> -->
<!-- 				<td><input type="button" value="-" name="minus" class="" -->
<!-- 					id="minus">  -->
<!-- 					<input type="text" name="adultnum" -->
<!-- 					id="adultnum" class="adultnum" value="" readonly="readonly">  -->
<!-- 					<input type="button" value="+" name="plus" class="" id="plus"> -->
<!-- 				</td> -->

<!-- 				<td name="price" class="price" id="price">NT$1000</td> -->
<!-- 				<td>NT$ <input type="text" name="total1" id="total1" -->
<!-- 					class="total1" value="0" readonly="readonly" /> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<%-- 				<td>${title}</td> --%>
<!-- 				<td>半票</td> -->
<!-- 				<td><input type="button" value="-" name="minus2" class="" -->
<!-- 					id="minus2"> <P name="orderNum" id="orderNum" class="orderNum"></P> -->
<!-- 					<input type="text" name="halfnum" id="halfnum" class="halfnum" -->
<!-- 					value="" readonly="readonly">  -->
<!-- 					<input type="button" value="+" name="plus2" -->
<!-- 					class="" id="plus2" ></td> -->
<!-- 				<td name="price" class="price" id="price">NT$500</td> -->
<!-- 				<td>NT$ <input type="text" name="total2" id="total2" -->
<!-- 					class="total2" value="0" readonly="readonly" /> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>總計</td> -->
<!-- 				<td></td> -->
<!-- 				<td></td> -->
<!-- 				<td></td> -->
<!-- 				<td>NT$ <input type="text" name="total3" id="total3" -->
<!-- 					class="totalprice" value="0" readonly="readonly" /></td> -->
<!-- 			<tr> -->
<!-- 		</table> -->
		<div class="g-recaptcha" data-sitekey="6LcZNusZAAAAAGcGq6PDVePyNXf6f9GTtl-LGcMN"></div>
		<br> <input type="submit" value="確認數量" name="submit"
			class="btn btn-outline-info" id="submit">
	</form>
	</div>
	<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>

	<script>
	$(document).ready(		
			function() {
				//選取票別切換票價
				$("#ticketcategry").change(function() {
					if($("#ticketcategry").val()=== "全票"){
					$("#price").text("NT$2000")
					}else{
					$("#price").text("NT$1000")
					}					 
				});
				//半票
				var count = 0;
				$("#halfnum").val(count);
				$("#plus").click(
						function() {
							if (count < 4) {
								count++;
							} else if (count = 4) {
								count = 4;
								alert("最多訂購4張");
							}
							$("#halfnum").val(count);
						})
				$("#minus").click(
						function() {
							if (count > 0) {
								count--;
							} else if (count = 0) {
								count2 = 0;
							}
							$("#halfnum").val(count);
							
						})
						
				//全票
				var count2 = 0;
				$("#adultnum").val(count2);
				$("#plus2").click(
						function() {
							//設定數量上限為4
							if (count2 < 4) {
								count2++;
							} else if (count2 = 4 ) {
								count2 = 4;
								alert("最多訂購4張");
							}
							$("#adultnum").val(count2);

						})
				$("#minus2").click(
						function() {
							//設定數量下限0
							if (count2 > 0) {
								count2--;
							} else if (count2 = 0) {
								count2 = 0;
							}
							$("#adultnum").val(count2);
							return count2;
						})					

			})




	
// 		//全票
// 		$(document).ready(
// 				function() {
// 					var count = 0;
// 					$("#adultnum").val(count);
// 					$("#plus").click(
// 							function() {
// 								//設定數量上限為4
// 								if (count < 4) {
// 									count++;
// 								} else if (count = 4) {
// 									count = 4;
// 									alert("最多訂購6張");
// 								}
// 								$("#adultnum").val(count);
// 								$("#total1").val(count * parseInt(1000))
// 								$("#total3").val(
// 										count * parseInt(1000) + count2
// 												* parseInt(500))
// 							})
// 					$("#minus").click(
// 							function() {
// 								//設定數量下限0
// 								if (count > 0) {
// 									count--;
// 								} else if (count = 0) {
// 									count = 0;
// 								}
// 								$("#adultnum").val(count);
// 								$("#total1").val(count * parseInt(1000))
// 								$("#total3").val(
// 										count * parseInt(1000) + count2
// 												* parseInt(500))
// 								return count;
// 							})
// 					//半票
// 					var count2 = 0;
// 					$("#halfnum").val(count2);
// 					$("#plus2").click(
// 							function() {
// 								if (count2 < 4) {
// 									count2++;
// 								} else if (count2 = 4) {
// 									count2 = 4;
// 									alert("最多訂購6張");
// 								}
// 								$("#halfnum").val(count2);
// 								$("#total2").val(count2 * parseInt(500))
// 								$("#total3").val(
// 										count * parseInt(1000) + count2
// 												* parseInt(500))
// 							})
// 					$("#minus2").click(
// 							function() {
// 								if (count2 > 0) {
// 									count2--;
// 								} else if (count2 = 0) {
// 									count2 = 0;
// 								}
// 								$("#halfnum").val(count2);
// 								$("#total2").val(count2 * parseInt(500))
// 								$("#total3").val(
// 										count * parseInt(1000) + count2
// 												* parseInt(500))
// 							})

// 				})
		
	</script>

</body>

</html>