<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">

<style>
.head, tfoot {
	text-align: center;
}
</style>

<!-- 此處 JS 為 sweet alert 使用範例 -->
<script type="text/javascript">

function reconfirmOrder(pid,page){
	swal("提示","確認刪除？", "warning",{
	    buttons: {
	      danger: {
	          text: "是"
// 	          ,visible: true
	        },
	      "不是": true,
//	      "是": true
	      
	    },
	  })
	  .then((value) => {
	    switch (value) {
	      case "danger":
	    	swal("提示","商品已刪除", "success")
	    	setTimeout(function(){window.location="<c:url value='/14/deleteProduct.ctrl?productId="+pid+"'/>" ; },2000);
	        break;
	      case "不是":
	        swal("提示","商品未刪除", "info");
	        break;
	      default:
	    	  swal("提示","商品未刪除", "info");
	        break;
	    }
	  });
};




</script>

</head>
<body>
	<div class="container">
		<h1 style="margin-top: 50px; text-align: center;">洋行後台</h1>

		<!-- 		<button type="button" class="btn btn-info btn-sm" value="新增商品" -->
		<%-- 			onclick="location.href='<c:url value='/14/createProduct.ctrl' />'">新增</button> --%>


		<!-- 		<button type="button" class="btn btn-info btn-sm" value="全部商品" -->
		<%-- 			onclick="location.href='<c:url value='/CRUD.controller' />'">前往新天地</button> --%>


		<div style='text-align: center;'>

			<c:if test='${not empty OrderErrorMessage}'>
				<h3>
					<font color='red'>${OrderErrorMessage}</font>
				</h3>
				<c:remove var="OrderErrorMessage" />
				<c:remove var="SuccessMessage" />
			</c:if>

		</div>

		<div style='text-align: center;'>
			<c:if test='${not empty SuccessMessage}'>
				<h3>
					<font color='#1b9aaa'>${SuccessMessage}</font>
				</h3>
				<c:remove var="SuccessMessage" />
				<c:remove var="OrderErrorMessage" />
			</c:if>
		</div>

		<!-- Begin Page Content -->
		<div class="container-fluid">

			Page Heading
			<h1 class="h3 mb-2 text-gray-800">商品編輯頁面</h1>
			<p class="mb-4">
				本處預計使用 DataTables 生成下表，等到學完 AJAX 之後應可以自動使用此插件進行排序與頁碼和每頁顯示筆數等功能。<br>
				若想先學習如何使用，請訪問 <a target="_blank" href="https://datatables.net">official
					DataTables documentation</a>.
			</p>

			DataTales
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">得意洋行商品一覽</h6>
				</div>
				<div class="card-body">
					<div class="table-responsive">

						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr class="head">
									<th scope="col">貨號</th>
									<th scope="col">商品名稱</th>
									<th scope="col">售價</th>
									<th scope="col">庫存</th>
									<th scope="col">功能</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th scope="col">貨號</th>
									<th scope="col">商品名稱</th>
									<th scope="col">售價</th>
									<th scope="col">庫存</th>
									<th scope="col">功能</th>
								</tr>
							</tfoot>

							<tbody>
								<c:forEach var="searchAP" varStatus="stat" items="${pList}">
									<!--<FORM> -->
									<tr>

										<td class="align-middle" scope="row"
											style="text-align: center;">${searchAP.productId}</td>
										<td class="align-middle">${searchAP.productTitle}</td>
										<td class="align-middle" style="text-align: center;">${searchAP.productPrice}</td>
										<td class="align-middle" style="text-align: center;">${searchAP.productNum}</td>
										<td class="align-middle"><button type="button"
												class="btn btn-info btn-sm" value="全部商品"
												onclick="location.href='<c:url value='/14/updateProduct.ctrl?productid=${searchAP.productId}' />'">修改</button>
											<Input class="btn btn-info btn-sm" type="button"
											name="delete" value="刪除"
											onclick="reconfirmOrder(${searchAP.productId},${pageNo})">
											<button type="button" class="btn btn-info btn-sm" value="詳情"
												onclick="location.href='<c:url value='/14/showOneProductCMS.ctrl?productid=${searchAP.productId}' />'">詳情</button>
										</td>

									</tr>
									<!--</FORM> -->
								</c:forEach>
							</tbody>

						</table>
					</div>

					<%-- 					<div style="text-align: center;">第 ${pageNo} 頁 // --%>
					<%-- 						共${totalPages} 頁</div> --%>
					<!-- 					<div class="container"> -->
					<!-- 						<div class="row justify-content-md-center"> -->



					<!-- 							<nav aria-label="Page navigation example" style="margin: auto;"> -->
					<!-- 								<ul class="pagination" style="margin: auto;"> -->
					<%-- 									<li class="page-item" style="margin: auto;"><c:if --%>
					<%-- 											test="${pageNo > 1}"> --%>
					<!-- 											<a class="page-link" -->
					<%-- 												href="<c:url value='/14/CRUD.ctrl?pageNo=${pageNo-1}' />" --%>
					<!-- 												aria-label="Previous"> <span aria-hidden="true">&laquo;</span> -->
					<!-- 											</a> -->
					<%-- 										</c:if></li> --%>
					<%-- 									<c:forEach var='page' items='${pages}'> --%>
					<!-- 										<li class="page-item"><a class="page-link" -->
					<%-- 											href="<c:url value='/14/CRUD.ctrl?pageNo=${page}' />">${page}</a></li> --%>
					<%-- 									</c:forEach> --%>
					<%-- 									<c:if test="${pageNo != totalPages}"> --%>
					<!-- 										<li class="page-item"><a class="page-link" -->
					<%-- 											href="<c:url value='/14/CRUD.ctrl?pageNo=${pageNo+1}' />" --%>
					<!-- 											aria-label="Next"> <span aria-hidden="true">&raquo;</span> -->
					<!-- 										</a></li> -->
					<%-- 									</c:if> --%>
					<!-- 								</ul> -->
					<!-- 							</nav> -->
					<!-- 						</div> -->
					<!-- 					</div> -->


					<script>
$(document).ready( function () {
    $('#dataTable').DataTable({

    	
    } );
} );
</script>
</body>
</html>