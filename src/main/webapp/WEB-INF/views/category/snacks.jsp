<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ include file="/WEB-INF/views/common/carousel.jsp" %>
 <div class="goods">
    <img id="goods-img" src="${goods.mainImg}" class="goods-img" alt="${goods.goodsName}">
    <div class="button-wrapper">
        <button class="to-cart"><i class="bi bi-cart icon-margin"></i>담기</button>
    </div>
    <div class="goods-info">
        <span class="goods-category">[${goods.category}]</span>
        <span class="goods-name">${goods.goodsName}</span>
        <p class="goods-comment">${goods.goodsComment}</p>
        <span class="dimmed-price">
            <span class="price-number">${goods.price.toLocaleString()}</span>
            <span class="won">원</span>
        </span>
    </div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>