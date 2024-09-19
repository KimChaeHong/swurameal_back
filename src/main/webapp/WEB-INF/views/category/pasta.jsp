<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ include file="/WEB-INF/views/common/carousel.jsp" %>
<%@ include file="/WEB-INF/views/category/category.jsp" %>

<ul class="category-container">
		<li class="category-item">
			<a class="item-title" onclick="location.href='${pageContext.request.contextPath}/category/western'">전체보기</a>
		</li>
		<li class="category-item">
			<a class="item-title active" onclick="location.href='${pageContext.request.contextPath}/category/western/pasta'">파스타</a>
		</li>
		<li class="category-item">
			<a class="item-title" onclick="location.href='${pageContext.request.contextPath}/category/western/steak'">스테이크</a>
		</li>	
	</ul>
	
<div class="goods-list">
    <c:forEach var="goods" items="${goodsList}" varStatus="status">
		<div class="goods">
		 <img id="goods-img" src="${pageContext.request.contextPath}/goods/downloadImage?goodsId=${goods.goodsId}" class="goods-img" alt="${goods.goodsName}">
		   <div class="button-wrapper">
		       <button class="to-cart">
		           <i class="bi bi-cart icon-margin"></i>담기
		       </button>
		   </div>
		   <div class="goods-info">
		       <span class="goods-category">[${goods.category}]</span>
		       <span class="goods-name">${goods.goodsName}</span>
		       <p class="goods-comment">${goods.goodsComment}</p>
		       <span class="dimmed-price">
		           <span class="price-number">
		               <fmt:formatNumber value="${goods.price}" type="number" groupingUsed="true"/>
		            </span> 원
		        </span>
		   </div>
		</div>
    </c:forEach>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>