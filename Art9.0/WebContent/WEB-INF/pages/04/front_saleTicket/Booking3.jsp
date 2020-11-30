<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%request.setCharacterEncoding("UTF-8");%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>確認訂單資訊</title>
    <style>
        td {
            width: 100px;
        }

        .orderNum {
            width: 30px;
        }
        .title{
         width:200px;
        }
        .total1{
        width: 120px;
        }
        .total2{
        width: 120px;
        }
        .totalprice{
        width: 120px;
        }
        
        .price2{
        width:200px;
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
<div class="d-flex justify-content-center">
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
  		<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 78%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
	</td>

	</tr>
	<tr>
		<td>區域/張數</td>
		<td>劃位</td>
		<td>購票確認</td>
		<td>完成訂購</td>
	</tr>
	</table><br><br>
</div>

<form name="order2" action="<c:url value='/04/SaveCart.ctrl'/> " method="get">
    
    <form name="order" action="" method="get">
    <H1>確認訂單資訊</H1>
    <table class= "table table-bordered">
        <tr>
            <td>訂購人姓名
            </td>
            <td>${sessionScope.shoppingcart.NAME}</td>
        </tr>
        <tr>
            <td>電子郵件
            </td>
            <td>
             ${sessionScope.shoppingcart.EMAIL}
             </td>
        </tr>
        <tr>
            <td>電話
            </td>
            <td>
            
             ${sessionScope.shoppingcart.TEL}
            </td>
        </tr>
        <tr>
            <td>地址
            </td>
            <td>
             ${sessionScope.shoppingcart.ADDRESS}
            </td>
        </tr>
     </table><br><br> <br>  
     
	<H2>訂購票券</H2>
		<table class="table table-bordered">
		<tr> 
				<td>節目名稱</td>
				<td>票種</td>
				<td>座位</td>
				<td>票價</td>

			</tr>
			<p class="ticketcategry"  style="display:none">${sessionScope.shoppingcart.TICKETCATEGORY}</p>
			<c:forEach items="${sessionScope.shoppingcart.seats}" var="seat">
			<tr> 
				<td class="title">${sessionScope.shoppingcart.TITLE}</td>
				<td >${sessionScope.shoppingcart.TICKETCATEGORY}</td>
				<td >${seat}</td>
				<td class="price"></td>
				
			</tr>
			</c:forEach>
			<tr> 
				<td >總計:</td>
				<td ></td>
				<td ></td>
				<td >NT$${sessionScope.shoppingcart.TOTALPRICE}</td>
			
			</tr>
			
		</table>	
     
    </form>
          <input type="button" value="修改訂單" name="" class="genric-btn primary-border radius" id="" onclick="history.back()">  
          <input type="submit" value="送出訂單" name="1" class="genric-btn primary-border radius" id="1">  
</div>
    
<script src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous">
</script>

<script>
$(document).ready(		
			function() {
					console.log($(".ticketcategry").text());
					if($(".ticketcategry").text()== "全票"){
					$(".price").text("NT$2000")
					}else{
					$(".price").text("NT$1000")
					}					 
				});

</script>

    <script>

    $("#1").click(function () {
    	if (confirm("是否送出訂單? ")) {
    		window.location ="<c:url value='/04/SaveCart.ctrl'/>" 
    	} else {
    		return false;
    	}
    	
    })

    </script>

</body>

</html>