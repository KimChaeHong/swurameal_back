<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



	<main class="goods-list">
		<div class="category-branding">
			<span class="category-comment">🍜 학교 앞에서 먹던 추억의 분식</span>
				<a type="button" class="category-move" href="../html/category.html">
				    <i class="bi bi-chevron-right icon-move"></i>
				</a>
		</div>
		
		<div class="goods-list">
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
	    </div>
	</main>
