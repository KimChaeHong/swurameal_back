<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/order.css">


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
		<p
			onclick="location.href='${pageContext.request.contextPath}/mypage/pick'">찜한
			상품</p>
		<p  style="color: rgb(107, 6, 9); font-weight: bold;"
			onclick="location.href='${pageContext.request.contextPath}/mypage/order'">주문
			내역</p>
		<p
			onclick="location.href='${pageContext.request.contextPath}/mypage/review'">상품
			후기</p>
		<p
			onclick="location.href='${pageContext.request.contextPath}/mypage/modifyForm'">개인정보
			수정</p>
	</div>
</div>
<div class="mypage-box flex-grow-1">
<div class="title-box">
        <p>주문 내역</p>
        <div class="horizontal-line"></div>
        </div>
        <div class="page-upload">
	        <div class="order-container d-flex flex-column">
	            <div class="row text-center period-choice" >
	                <div class="col-3 three-month">3개월</div>
	                <div class="col-3 six-month">6개월</div>
	                <div class="col-3 one-year">1년</div>
	                <div class="col-3 three-year">3년</div>
	            </div>
	            
	            <c:forEach items="${order}" var="order">
		            <div class="d-flex flex-column order-list">
			            <div class="order-product d-flex">
		                <img src="${pageContext.request.contextPath}/goods/downloadImageByRole?goodsId=${order.goodsId}&imgRole=G_MAIN" alt="${order.goodsId}">
		                <div class="order-info">
		                    <p><strong>상품명</strong> ${order.orderId}</p>
		                    <p><strong>주문 날짜</strong> ${order.orderDate}</p>
		                    <p><strong>결제 금액</strong> ${order.goodsPrice}</p>
		                    <p><strong>주문 상태</strong> ${order.orderStatus}</p>
		                </div>
		            	</div>	
		            </div>	            
	            </c:forEach>
	            <div class="pagination"></div> 
	        </div>
        </div>
	</div>
</main>


<%@ include file="/WEB-INF/views/common/footer.jsp"%>