<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
<header id="header" id="home"
		style="font-family: cwTeXFangSong, serif;">

		<div class="container header-top">
			<div class="row">
				<div class="col-6 top-head-left">
					<ul>
						<li><a href="<c:url value='/userEnterMemberArea'/>">
							<img style='display:block; width:64px;height:36px;' src="data:image/jpg;base64, ${sessionScope.memberPic}" >${sessionScope.member.getName()}</a></li>
						<li><a href="<c:url value='/userEnterMemberArea'/>">會員專區</a></li>
						<li><a href="<c:url value='/35/logoutProcess'/>">登出</a></li>
					</ul>
				</div>
				<div class="col-6 top-head-right">
					<ul>
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
						<li><a href="#"><i class="fa fa-behance"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
		<hr>
		<div class="container">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a href="index.html"><img
						src="<c:url value='/frontstyle/img/aaart.png'/>" alt="" title="" /></a>
					<!-- 				        <a href="index.html"><p>得藝的一天</p></a> -->
				</div>
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li class="#"><a href="index.html">首頁</a></li>
						<li><a href="<c:url value='/14/shopListController.ctrl' />">得意洋行</a></li>
						<li><a href="#">找商店</a></li>
						<li><a href="#">找藝人</a></li>
						<li><a href="#">找課程</a></li>
						<li><a href="#">企業贊助</a></li>
						<li><a href="#">場地租借</a></li>
						<li><a href="#">離我最近的活動</a></li>
<!-- 						<li class="menu-has-children"><a href="">Pages</a> -->
<!-- 							<ul> -->
<!-- 								<li><a href="#">Blog Single</a></li> -->
<!-- 								<li><a href="#">Category</a></li> -->
<!-- 								<li><a href="#">Elements</a></li> -->
<!-- 							</ul></li> -->
					</ul>
				</nav>
				<!-- #nav-menu-container -->
			</div>
		</div>
	</header>
	
</body>