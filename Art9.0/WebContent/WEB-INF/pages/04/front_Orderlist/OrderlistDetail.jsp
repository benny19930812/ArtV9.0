<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<meta charset="UTF-8">
<title>訂單</title>
</head>
<body>
	<%-- <form name="order" action="<c:url value='/_04_Orderlist/OrIdSearchServlet'/>" method="get" > --%>
<%-- 		<c:set var="getorlist" value="${requestScope.getorlist}" /> --%>
		
		<%--使用JSTL 執行for loop ${show.no}取map內value --%>


 <H1>確認訂單資訊</H1>
    <table class= "table table-bordered">
        <tr>
            <td>訂購人姓名
            </td>
            <td>${requestScope.orderlist.NAME}</td>
        </tr>
        <tr>
            <td>電子郵件
            </td>
            <td>
             ${requestScope.orderlist.EMAIL}
             </td>
        </tr>
        <tr>
            <td>電話
            </td>
            <td>
            
             ${requestScope.orderlist.TEL}
            </td>
        </tr>
        <tr>
            <td>地址
            </td>
            <td>
             ${requestScope.orderlist.ADDRESS}
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
			<p class="ticketcategry"  style="display:none">${requestScope.orderlist.TICKETCATEGORY}</p>
			<c:forEach items="${requestScope.orderlist.seats}" var="seat">
			<tr> 
				<td class="title">${requestScope.orderlist.TITLE}</td>
				<td >${requestScope.orderlist.TICKETCATEGORY}</td>
				<td >${seat}</td>
				<td class="price"></td>
				
			</tr>
			</c:forEach>
			<tr> 
				<td >總計:</td>
				<td ></td>
				<td ></td>
				<td >NT$${requestScope.orderlist.TOTALPRICE}</td>
			
			</tr>
			
		</table>	






<!-- <br><h1>訂單資訊</h1> -->
<!-- 		<table class="table table-bordered"> -->
<!-- 			<br><br><tr> -->
<!-- 				<th>訂單編號</th> -->
<!-- 				<th>訂購人姓名</th> -->
<!-- 				<th>E-mail</th> -->
<!-- 				<th>連絡電話</th> -->
<!-- 				<th>通訊地址</th> -->
<!-- 				<th>總金額</th> -->

<!-- 			</tr> -->
<!-- 						<tr> -->
<%-- 					<td>${param.orderlist.MEMBERID}</td> --%>
<%-- 					<td>${param.orderlist.NAME}</td> --%>
<%-- 					<td>${param.orderlist.EMAIL}</td> --%>
<%-- 					<td>${param.orderlist.TEL}</td> --%>
<%-- 					<td>${param.orderlist.ADDRESS}</td> --%>

<!-- 				</tr> -->

<!-- 			</table><br><br> -->
<!-- 		<table class="table table-bordered"> -->
<!-- 			<tr> -->
<!--             <td>節目名稱</td> -->
<!--             <td>票種</td> -->
<!--             <td>數量</td> -->
<!--             <td>單價</td> -->
         
<%-- <c:forEach items="${getorlist2}" var="show2" varStatus="idx"> --%>
<!--         </tr> -->
<!-- 			<tr> -->
<%--             <td>${show2.title}</td> --%>
<!--             <td>全票</td> -->
<%--             <td>${show2.adultnum}</td>   --%>
<!--           	<td name="price" class="price" id="price" >1000</td> -->

<!--             <tr> -->
<!--             <tr> -->
<%--             <td>${show2.title}</td> --%>
<!--             <td>半票</td> -->
<%--             <td>${show2.halfnum}</td>   --%>
<!--           	<td name="price" class="price" id="price" >500</td> -->

 			
<!--          <tr> -->
<%-- 	</c:forEach>		 --%>
			

<!-- 		</table> -->
	</form>	
	 <input type="submit" value="修改訂單" name="submit" class="btn btn-outline-info" id="update"  >
	 
	  <input type="submit" value="刪除訂單" name="submit" class="btn btn-outline-info" id="delete"  >
<%-- 	 <form name="order" action="<c:url value='/_04_Orderlist/OrIdDeleteServlet'/> " method="get"> --%>
<!-- 	  </form> -->
 <script src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</script>    
    
    
    <script>
    $("#update").click(function () {
    	
    		window.location ="<c:url value='/_04_Orderlist/OrderlistUpdate.jsp'/>" 
    	
    })
    
    

    $("#delete").click(function () {
    	if (confirm("確認刪除? ")) {
    		window.location ="<c:url value='/_04_Orderlist/OrIdDeleteServlet'/>" 
    	} else {
    		return false;
    	}
    	
    })
    
    

    </script>	  
	  
	  
</body>

</html>