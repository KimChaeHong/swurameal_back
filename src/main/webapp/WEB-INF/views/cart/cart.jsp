<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/cart.css">

<main class="container cart">
<h2>장바구니</h2>
<div id="select-btns">
	<i class="bi bi-check-circle hover" id="allBtn"></i> <span
		class="hover" id="allBtnTxt">전체선택</span> <span> | </span> <span
		class="hover">전체삭제</span>
</div>

<div class="d-flex justify-content-between">
	<div id="cart-items">
		<c:forEach var="goods" items="${goodsList}">
			<div class="item d-flex justify-content-between">
				<form action="${pageContext.request.contextPath}/cart/cartAdd"
					method="post">
					<input type="hidden" name="goodsId" value="${goods.goodsId}">
					<div class="button-wrapper">
						<button type="submit" class="to-cart">
							<i class="bi bi-cart icon-margin"></i>담기
						</button>
					</div>
				</form>
					<i class="bi bi-check-circle hover"></i> <img
						src="${pageContext.request.contextPath}/cart/downloadImage?goodsId=${goods.goodsId}"
						class="goods-img" alt="${goods.goodsName}">

					<div id="item-detail">
						<p>${goods.category}${goods.goodsName}</p>
						<%-- <p>${goods.goodsName}</p> --%>
						<p>${goods.goodsComment}</p>
						<div class="cnt-btn">
							<button class="updown-btn">-</button>
							<span class="item-cnt">1</span>
							<button class="updown-btn">+</button>
						</div>
					</div>
				

				<div id="item-price">
					<span class="price-number"><fmt:formatNumber
							value="${goods.price}" pattern="#,###" /></span> <span class="won">원</span>
				</div>
				<i class="bi bi-x-lg hover" id="xBtn"></i>
			</div>
		</c:forEach>
	</div>

	<div id="cart-pay">
		<div id="how-much">
			<p>주문내역</p>
			<div class="d-flex justify-content-between">
				<span>상품금액</span> <span> <span id="total-price">0</span> 원
				</span>
			</div>
			<div class="d-flex justify-content-between">
				<span>배송비</span> <span>3,000원</span>
			</div>
			<div class="d-flex justify-content-between total">
				<span>결제예정금액</span> <span> <span id="pay-price">0</span> 원
				</span>
			</div>
		</div>
		<button
			onclick="location.href='${pageContext.request.contextPath}/order'">주문하기</button>
	</div>
</div>
</main>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>