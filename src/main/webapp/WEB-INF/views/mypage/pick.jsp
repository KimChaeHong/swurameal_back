<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/pick.css">


<main class="container d-flex mypage">
<div class="mypage-category">
	<div class="profile d-flex">
		<i class="bi bi-person-fill"></i>
		<div class="profile-detail">
			<p>환영합니다.</p>
			<p class="member-name">${user.userName}님</p>
		</div>
	</div>
	<div class="category-box d-flex flex-column">
		<h3>나의 수라밀</h3>
		<p style="color: rgb(107, 6, 9); font-weight: bold;"
			onclick="location.href='${pageContext.request.contextPath}/mypage/pick'">찜한
			상품</p>
		<p
			onclick="location.href='${pageContext.request.contextPath}/mypage/order'">주문
			내역</p>
		<p
			onclick="location.href='${pageContext.request.contextPath}/mypage/review'">상품
			후기</p>
		<p
			onclick="location.href='${pageContext.request.contextPath}/mypage/modify'">개인정보
			수정</p>
	</div>
</div>
<div class="mypage-box flex-grow-1">
	<div class="title-box">
		<p>찜한 상품</p>
		<div class="horizontal-line"></div>
	</div>
	<div class="page-upload">
		<div class="pick-container d-flex flex-column">
			<div class="choice-box">
				<div class='choice-all d-flex'>
					<i class="bi bi-check-circle" data-flag="1"></i>
					<p class="all-select">전체선택</p>
				</div>
				<div class='choice-deselect'>
					<p>
						<span class="all-del">전체 삭제</span> | <span class="choice-del">선택 삭제</span>
					</p>
				</div>
			</div>
			<div class="pick-products d-flex flex-column">
				<c:forEach var="goods" items="${pickGoods}">
				<div class="pick-product d-flex">
					<i class="bi bi-check-circle" data-select="1"></i>
					<div class="img-product d-flex">
						<img src="${pageContext.request.contextPath}/goods/downloadImage?goodsId=${goods.goodsId}" class="goods-img" alt="${goods.goodsName}">
						<div class="product-info">
							<p>
								<strong>카테고리</strong> ${goods.category}
							</p>
							<p>
								<strong>상품명</strong> ${goods.goodsName}
							</p>
							<p>
								<strong>가격</strong> <fmt:formatNumber value="${goods.price}" type="number" groupingUsed="true"/>
							</p>
						</div>
					</div>
					<div class="button-list">
						<i class="bi bi-cart"></i> 
						<a href="${pageContext.request.contextPath}/pick/deletePick?goodsId=${goods.goodsId}"><i class="bi bi-x-lg"></i></a>
						
					</div>
				</div>
				</c:forEach>

			</div>
			<div class="pagination"></div>
		</div>
	</div>
</div>
</main>


<%@ include file="/WEB-INF/views/common/footer.jsp"%>