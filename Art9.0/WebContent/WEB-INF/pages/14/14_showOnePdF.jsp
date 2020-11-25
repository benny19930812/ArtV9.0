<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- start banner Area -->
			<section class="banner-area relative" id="home">	
				<div class="overlay overlay-bg"></div>
				<div class="container">
					<div class="row d-flex align-items-center justify-content-center">
						<div class="about-content col-lg-12">
							<h1 class="text-white">
								AAART Shop
							</h1>	
							<p class="text-white link-nav"><a href="index.html">Home </a>
							<span class="lnr lnr-arrow-right"></span>  <a href="<c:url value='/14/shopListController.ctrl' />"> Shop</a>
							<span class="lnr lnr-arrow-right"></span> <span>${oneProsuct.productTitle}</span> </p>
						</div>											
					</div>
				</div>
			</section>
	<!-- End banner Area -->	


<body>

<div class="container" style="margin-top:100px">
            <div class="row justify-content-md-center">
            <div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
                <div class="btn-group btn-group-sm" role="group" aria-label="Button group with nested dropdown">
                    <button type="button" class="genric-btn primary-border small" value="全部商品" onclick="location.href='<c:url value='/14/shopListController.ctrl' />'">全部商品</button>
                    <div class="btn-group" role="group">
                        <button id="btnGroupDrop1" type="button" class=" genric-btn primary-border small dropdown-toggle"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            書寫用品
                        </button>
                        <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                            <a class="dropdown-item" href="<c:url value='/14/shopListController.ctrl?query=pen' />">鋼筆</a>
                            <a class="dropdown-item" href="<c:url value='/14/shopListController.ctrl?query=ink' />">墨水</a>
                        </div>
                    </div>

                    <div class="btn-group  btn-group-sm" role="group">
                        <button id="btnGroupDrop1" type="button" class="genric-btn primary-border small dropdown-toggle"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            生活用品
                        </button>
                        <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                            <a class="dropdown-item" href="<c:url value='/14/shopListController.ctrl?query=home' />">家飾布置</a>
                            <a class="dropdown-item" href="<c:url value='/14/shopListController.ctrl?query=cook' />">精選器皿</a>
                            <a class="dropdown-item" href="<c:url value='/14/shopListController.ctrl?query=deco' />">飾品小物</a>
                        </div>
                    </div>
                </div>
                <c:if test="${ funcName != 'ORD' }">
       			 <button type="button" style="margin-left: 10px;" class="genric-btn primary-border small" value="全部商品" onclick="location.href='<c:url value='/14/shopListController.ctrl' />'"> 訂單查詢 </button>
				</c:if>
                <FORM ACTION="./ProductArray">
                <input type="hidden" name="method" value="order"/>
                <input type="submit" style="margin-left: 10px;" class="genric-btn primary-border small" name="check" value="前往結帳頁面">
                </FORM>
           </div>     
            </div>
        </div>
        <br>





    <div class="container">
        <div class="card mb-3 " style="max-width: 800px; margin: auto; margin-top: 10px;">
            <div class="row no-gutters">
                <div class="col-md-4">
                    <img src="${pageContext.servletContext.contextPath}/14/getBlobImage/${oneProsuct.productId}.ctrl" class="card-img" alt="...">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <FORM ACTION="SubmitProcess.ctrl">
                            <h4 class="card-title">${oneProsuct.productTitle}</h4>
<%--                             <p class="card-text">${oneProsuct.productId}</p> --%>
                            
                            <p class="card-text">
                                <fmt:formatNumber value="${oneProsuct.productPrice}" type="number" />元</p>

                            <span>請輸入數量：
                                <input type="number" min="1" max="${oneProsuct.productNum}" name="orderNum" value="1">
                            </span>

                            <hr>
                            <p class="card-text" style="font-size: x-large"><small class="text-muted">${oneProsuct.productDes}</small></p>
                            <input type="hidden" name="method" value="selectItem" />
                            <input type="hidden" name="productID" value="${oneProsuct.productId}" />
                            <input type="hidden" name="orderPrice" value="${oneProsuct.productPrice}" />
                            <input type="hidden" name="orderImg" value="${oneProsuct.productImg}" />
                            <%--<input type="hidden" name="orderNum" value="${num}" />--%>
                            <input type="hidden" name="orderDes" value="${oneProsuct.productDes}" />
                            <input type="hidden" name="orderDes" value="${oneProsuct.productDes}" />
                            <div><button type="submit" name="orderTitle" value="${oneProsuct.productTitle}"
                                class="btn btn-info btn-lg btn-block btn-sm">加入購物車</button></div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>

</html>