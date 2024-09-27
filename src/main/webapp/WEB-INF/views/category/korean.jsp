<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ include file="/WEB-INF/views/common/carousel.jsp" %>
<%@ include file="/WEB-INF/views/category/category.jsp" %>

<ul class="category-container">
		<li class="category-item">
			<a class="item-title active" onclick="location.href='${pageContext.request.contextPath}/category/korean'">전체보기</a>
		</li>
		<li class="category-item">
			<a class="item-title" onclick="location.href='${pageContext.request.contextPath}/category/korean/stew'">전골/찌개</a>
		</li>
		<li class="category-item">
			<a class="item-title" onclick="location.href='${pageContext.request.contextPath}/category/korean/poaching'">찜/조림</a>
		</li>
		<li class="category-item">
			<a class="item-title" onclick="location.href='${pageContext.request.contextPath}/category/korean/roast'">볶음/구이</a>
		</li>
	</ul>

<div class="goods-list">
    <c:forEach var="goods" items="${goodsList}" varStatus="status">
		<div class="goods">
		   <a href="${pageContext.request.contextPath}/goods/detail?goodsId=${goods.goodsId}">
			   <img id="goods-img" src="${pageContext.request.contextPath}/goods/downloadImageByRole?goodsId=${goods.goodsId}&imgRole=G_MAIN" class="goods-img" alt="${goods.goodsName}">		   
		   </a>
		   <div class="button-wrapper">
		       <a href="${pageContext.request.contextPath}/cart/itemAdd?goodsId=${goods.goodsId}">
                 <button class="to-cart">
                     <i class="bi bi-cart icon-margin"></i>담기
                 </button>
   				</a>
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