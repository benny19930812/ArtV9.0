<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理網站會員</title>
<style>
.post {
	display: none;
}
</style>
</head>
<body>
	<br>
	<div class="title">
		<h1 align="center">會員資料列表</h1>
	</div>
	<div class="back" align="right">
		<form action="<c:url value='/index.html'/> " method="get">
			<div class="submitButton">
				<input type="submit" class="" name="submit" value="返回後台管理系統首頁">
			</div>
		</form>
	</div>
	<br>
	<div class="add" align="right">
		<input type="button" value="新增會員資料" onclick="add()">
		<div class="post">
			<table class="display table">
				<thead>
					<tr>
						<th class="table-secondary">名稱</th>
						<th class="table-warning">地址</th>
						<th class="table-light">E-mail</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class=""><input type="text" id="name"></td>
						<td class=""><input type="text" id="address"></td>
						<td class=""><input type="text" id="email"></td>
					</tr>
				</tbody>
			</table>
			<table class="display table">
				<thead>
					<tr>
						<th class="table-secondary">電話</th>
						<th class="table-success">會員類型</th>
						<th class="table-primary">偏好</th>
						<th class="table-danger">購買上限</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class=""><input type="text" id="tel"></td>
						<td class=""><input type="text" id="memberType"></td>
						<td class=""><input type="text" id="preference"></td>
						<td class=""><input type="text" id="purchaseLimit"></td>
					</tr>
					<tr>
						<td><input type="button" value="確認新增" onclick="post()"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="deleteResult" align="center">
		<h2>${deleteResult}</h2>
		<br>
	</div>
	<!-- 	<div class="select" align="center"> -->
	<%-- 		<form action="<c:url value='/35/select.ctrl'/> " method="get"> --%>
	<!-- 			<div class="submitButton"> -->
	<!-- 				<label>輸入會員名稱查詢</label> <input type="text" name="select" value=""> -->
	<!-- 				<input type="submit" name="submit" value="送出"> <input -->
	<!-- 					type="reset" name="reset" value="清除"> -->
	<!-- 			</div> -->
	<!-- 		</form> -->
	<!-- 	</div> -->
	<br>
	<div class="content">
		<table id="35"
			class="display table table-bordered table-hover table-blue">
			<thead>
				<tr class="">
					<th class="table-secondary">名稱</th>
					<th class="table-warning">地址</th>
					<th class="table-light">E-mail</th>
					<th class="table-secondary">電話</th>
					<th class="table-success">會員類型</th>
					<th class="table-danger">個人照片</th>
					<th class="table-primary">偏好</th>
					<th class="table-info">註冊日期</th>
					<th class="table-danger">購買上限</th>
					<th class="table-info">修改會員資訊</th>
					<th class="table-success">刪除此會員</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="counter" value="0" />
				<c:forEach var="list" items="${membersList}">
					<c:set var="counter" value="${counter+1}" />
					<tr>
						<td class="">${list.name}</td>
						<td class="">${list.address}</td>
						<td class="">${list.email}</td>
						<td class="">${list.tel}</td>
						<td class="">${list.memberType}</td>
						<td class="">${list.memberPic}</td>
						<td class="">${list.preference}</td>
						<td class="">${list.registerTime}</td>
						<td class="">${list.purchaseLimit}</td>
						<td class="update">
							<form action="<c:url value='/35/editEventSpace'/> " method="get">
								<div class="submitButton">
									<%-- 									<input type="hidden" name="id" value="${list.id}"> <input --%>
									<%-- 										type="hidden" name="name" value="${list.name}"> <input --%>
									<%-- 										type="hidden" name="owner" value="${list.owner}"> <input --%>
									<%-- 										type="hidden" name="address" value="${list.address}"> --%>
									<%-- 									<input type="hidden" name="type" value="${list.type}"> --%>
									<!-- 									<input type="hidden" name="shoppingArea" -->
									<%-- 										value="${list.shoppingArea}"> <input type="hidden" --%>
									<%-- 										name="transportation" value="${list.transportation}"> --%>
									<%-- 									<input type="hidden" name="capacity" value="${list.capacity}"> --%>
									<%-- 									<input type="hidden" name="unitPrice" value="${list.unitPrice}"> --%>
									<%-- 									<input type="hidden" name="area" value="${list.area}"> --%>
									<!-- 									<input type="hidden" name="rentalTime" -->
									<%-- 										value="${list.rentalTime}"> <input type="hidden" --%>
									<%-- 										name="activityInfo" value="${list.activityInfo}"> <input --%>
									<%-- 										type="hidden" name="contactInfo" value="${list.contactInfo}"> --%>
									<input type="submit" name="submit" value="修改">
								</div>
							</form>
						</td>
						<td class="delete">
							<form action="<c:url value='/35/delete.ctrl'/> " method="GET">
								<div class="submitButton">
									<input type="hidden" name="name" value="${list.name}">
									<input type="submit" name="submit" value="刪除">
								</div>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
$(document).ready( function () {
    $('#35').DataTable( {
        scrollY: 400
    } );
});

let postDiv = document.querySelector(".post");
	
let add = () =>{
	postDiv.style.display= "block";
} 

let post = () => {
	let name = document.getElementById("name").value;
	let address = document.getElementById("address").value;
	let email = document.getElementById("email").value;
	let tel = document.getElementById("tel").value;
	let memberType = document.getElementById("memberType").value;
	let preference = document.getElementById("preference").value;
	let purchaseLimit = document.getElementById("purchaseLimit").value;
	let jsonMember = {
			"name": name, 					
			"address": address, 	
			"email": email,
			"tel": tel,
			"memberType": memberType,
			"preference": preference,
			"purchaseLimit": purchaseLimit
   		}
	postDiv.style.display= "none";
	fetch("<c:url value='/35/members/' />"+name, {
		method:"post",
		headers : {
		        'Content-Type' : 'application/json; charset=UTF-8'
		    },
		body: JSON.stringify(jsonMember)
		}
	).then(
		response => {
			if (response.ok){
				response.json().then(
					object => {
						console.log(object.name);
					}
				);
			}
		}
	).catch();
}
</script>
</body>
</html>