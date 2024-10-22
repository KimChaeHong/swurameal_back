<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
				onclick="location.href='${pageContext.request.contextPath}/user/modify'">개인정보
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
	            	<div class="col-3 three-month" style="color: rgb(107, 6, 9); font-weight: bold; border-color: black;">
	            		<button style="all: unset;" onclick="location.href='${pageContext.request.contextPath}/mypage/order?month=3'">3개월</button>
	            	</div>
	                <div class="col-3 six-month">
	                	<button style="all: unset;" onclick="location.href='${pageContext.request.contextPath}/mypage/order?month=6'">6개월</button>
	                </div>
	                <div class="col-3 one-year">
	                	<button style="all: unset;" onclick="location.href='${pageContext.request.contextPath}/mypage/order?month=12'">1년</button>
	                </div>
	                <div class="col-3 three-year">
	                	<button style="all: unset;" onclick="location.href='${pageContext.request.contextPath}/mypage/order?month=36'">3년</button>                
	                </div>
	            </div>
	            
	            <div class="d-flex flex-column order-list">
		            <c:forEach items="${order}" var="order">
				            <div class="order-product d-flex">
			                <img src="${pageContext.request.contextPath}/goods/downloadImageByRole?goodsId=${order.goodsId}&imgRole=G_MAIN" alt="${order.goodsId}">
			                <div class="order-info">
			                    <p><strong>상품명</strong>${order.goodsName}</p>
			                    <p><strong>주문 날짜</strong><fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd"/></p>
			                    <p><strong>결제 금액</strong><fmt:formatNumber value="${order.goodsPrice}" type="number" groupingUsed="true"/></p>
			                    <c:if test="${order.orderStatus == 'COMPLETE'}">
			                    	<p><strong>주문 상태</strong>주문완료</p>			                    
			                    </c:if>
			                </div>
			            	</div>	
		            </c:forEach>
	            </div>	            
	            <div class="pagination">
					<a href="order?pageNo=1&month=${month}" class="btn btn-outline-dark btn-sm">처음</a>
		
					<c:if test="${pager.groupNo>1}">
						<a href="order?pageNo=${pager.startPageNo-1}&month=${month}"
							class="btn btn-outline-dark btn-sm">이전</a>
					</c:if>
		
					<c:forEach begin="${pager.startPageNo}" end="${pager.endPageNo}" step="1" var="i">
						<c:if test="${pager.pageNo==i}">
								<button class="page-num active" onclick="location.href='${pageContext.request.contextPath}/mypage/order?pageNo=${i}&month=${month}'">
									${i}
								</button>						
						</c:if>
						<c:if test="${pager.pageNo!=i}">
								<button class="page-num" onclick="location.href='${pageContext.request.contextPath}/mypage/order?pageNo=${i}&month=${month}'">
									${i}
								</button>
						</c:if>
					</c:forEach>
		
					<c:if test="${pager.groupNo<pager.totalGroupNo}">
						<a href="order?pageNo=${pager.endPageNo+1}&month=${month}"
							class="btn btn-outline-dark btn-sm">다음
						</a>
					</c:if>
		
					<a href="order?pageNo=${pager.totalPageNo}&month=${month}"
						class="btn btn-outline-dark btn-sm">마지막</a>
				</div>
	        </div>
        </div>
	</div>
</main>


<%@ include file="/WEB-INF/views/common/footer.jsp"%>

