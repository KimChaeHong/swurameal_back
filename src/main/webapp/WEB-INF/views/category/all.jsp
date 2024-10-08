<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ include file="/WEB-INF/views/common/carousel.jsp" %>
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