<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ include file="/WEB-INF/views/common/carousel.jsp" %>
<main class="goods-list">
    <c:forEach var="goods" items="${goodsList}" varStatus="status">
    
    <div class="goods">
   	 <img id="goods-img" src="attachShow?goodsId=${goods.goodsId}" class="goods-img" alt="${goods.goodsName}">
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
</main>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>