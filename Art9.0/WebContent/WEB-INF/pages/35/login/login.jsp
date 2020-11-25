<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
</head>
<style>
tr {
	text-align: left;
}

.authError, .errors {
	color: red;
	padding: 10px;
}

fieldset {
	text-align: center;
	width: 400px;
	margin: 0 auto;
}

#sendData, .pass {
	display: none;
}
.pass {
	color: red;
}
/* .grecaptcha-badge { 
    display: none;
} */
</style>
<body>
	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">Login</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="elements.html"> Login</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<br>
	<br>
	<fieldset>
		<legend>請輸入帳號密碼</legend>
		<c:url var="url" value='/35/loginCheck.ctrl' />
		<form:form action="${url}" method="POST" modelAttribute="member">
			<table class="loginForm">
				<tr>
					<td colspan=2 class="authError">${authError}</td>
				</tr>
				<tr>
					<td><form:label path="name">會員名稱:</form:label></td>
					<td><form:input path="name" value="${name}" /></td>
					<td class="errors">${errors.user}</td>
				</tr>
				<tr>
					<td><form:label path="password">密碼:</form:label></td>
					<td><form:input type="password" path="password"
							value="${password}" /></td>
					<td class="errors">${errors.pwd}</td>
				</tr>
				<tr>
					<td><label>記住密碼:</label></td>
					<td><input type="checkbox" name="rememberMe"
						<c:if test='${requestScope.rememberMe==true}'>
					    checked='checked'
              			</c:if>
						value="yes" /></td>
				</tr>
				<!-- 				<tr> -->
				<!-- 					<td colspan="2"> -->
				<!-- 						<button class='captcha'>點我進行驗證</button> -->
				<!-- 					</td> -->
				<!-- 				</tr> -->
				<tr>
					<td style="padding-top: 20px;"><form:button value="Send"
							id='sendData'>真的登入按鈕</form:button></td>
				</tr>
				<tr>
					<td colspan=2 style="padding-top: 20px;"><p class="pass">驗證通過，您不是機器人<br>3秒後自動登入</p></td>
				</tr>
			</table>
		</form:form>
		<button class='captcha'>登入</button>
	</fieldset>
	<div class="newImg"></div>

	<script
		src="https://www.google.com/recaptcha/api.js?render=6Lc_wOQZAAAAALKDlGGuMLE_iV-rjKJIYMHI9Fj6"></script>
	<script type="text/javascript">
		const CAPTCHA_CLIENT_SECRET = "6Lc_wOQZAAAAALKDlGGuMLE_iV-rjKJIYMHI9Fj6";
		window.onload = () => {

			// unsplash 上的圖片
			let url = 'https://images.unsplash.com/photo-1513313778780-9ae4807465f0?auto=format&fit=crop&w=634&q=80'
			fetch(url)
			  .then((response) => {
			    return response.blob();
			  })
			  .then((imageBlob) => {
				console.log(imageBlob);
			    let img = document.createElement('IMG')
			    document.querySelector('.newImg').appendChild(img);
			    // 將 blog 物件轉為 url
			    img.src = URL.createObjectURL(imageBlob);
			  })
			
			document.querySelector('.captcha').addEventListener('click', () => {
						
				grecaptcha.execute(CAPTCHA_CLIENT_SECRET, {action: 'login'}).then(function(token) {
					console.log('客戶端token:' + token);
					fetch("<c:url value='/35/validate?token=' />" + token, {
						method: 'GET'
					}).then(response => {
						if (response.ok){
							response.json().then(message => {
								console.log('伺服器端驗證');
								console.log(message);
								console.log(message.score);
// 								返回的message是JSONObject型態
// 								取Key對應value用message.score或message["score"]
//                              JSONObject.key，可以抓出key的value
								if (message.score >= 0.8){
									console.log("產出登入按鈕");
									let pass = document.querySelector('.pass');
									pass.style.display = "block";

									let delayInMilliseconds = 1000; //3 second
									setTimeout(() => {
										 // code to be executed after 1 second
										pass.innerHTML="驗證通過，您不是機器人<br>2秒後自動登入";
										}, delayInMilliseconds);
									setTimeout(() => {
										 // code to be executed after 2 second
										pass.innerHTML="驗證通過，您不是機器人<br>1秒後自動登入";
										}, delayInMilliseconds+1000);
									setTimeout(() => {
									 // code to be executed after 3 second
									document.querySelector('#sendData').click();
									}, delayInMilliseconds+2000);
								}
							});
						}
					});			
				});
			});

//			測試程序化登入google評分
// 			for(i=0;i<10;i++){
// 				document.querySelector('.captcha').click();
// 			}

		};
	</script>
</body>
</html>