<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>

<script src="${pageContext.request.contextPath}/resources/js/detail.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/detail.css">

	<main class="container">
	    <section class="d-flex main-content">
	        <div id="image-container">
	            <img src="${pageContext.request.contextPath}/goods/downloadImageByRole?goodsId=${goods.goodsId}&imgRole=G_MAIN" />
	        </div>
	        <div id="product-info">
	            <p id="product-name">${goods.goodsName}</p>
	            <p id="product-coment">${goods.goodsComment}</p>
	            <p id="product-price">
		            <fmt:formatNumber value="${goods.price}" type="number" groupingUsed="true"/>	            
	            </p>
	            <hr />
	            <div class="d-flex">
	                <span id="delivery">배송</span>
	                <span>${goods.deliveryInfo}</span>
	            </div>
	            <hr />
	            <div class="d-flex">
	                <span id="seller">판매자</span>
	                <span>${goods.seller}</span>
	            </div>
	            <hr />
	            <div class="d-flex">
	                <span id="unit">판매단위</span>
	                <span>${goods.saleUnit}</span>
	            </div>
	            <hr />
	            <div class="d-flex">
	                <span id="product-weight">중량/용량</span>
	                <span>${goods.weight}</span>
	            </div>
	            <hr />
	            <div class="d-flex">
	                <span id="product-quantity">상품선택</span>
	                <div id="count-box">
	                    <p id="mini-name">[${goods.category}] ${goods.goodsName}</p>
	
	                        <div class="cnt-btn d-flex justify-content-between align-items-center">
	                            <button id="minus-button">-</button>
	                            <p class="m-0" id="count"> 1 </p>
	                            <button id="plus-button">+</button>
	                        </div>
	                        <span class="total-price">가격*수량</span>
	
	                </div>
	            </div>
	            <p class="total-price" id="total-price">총 가격</p>
	            <div id="button-box" class="d-flex justify-content-between">
	                <button type="button" id="pick" class="btn" >
					    <!--찜 버튼 아이콘 -->
					    <i id="pick-icon" class="bi bi-heart"></i>
					</button>
	                <button type="button" id="cart" class="btn" >
	                 	<!--장바구니 아이콘-->
	                	<i class="bi bi-cart"></i>
	                </button>
	                <span id="buy" class="btn">구매하기</span>
	            </div>
	        </div>
	    </section>
	
	    <!--추천상품-->
	    <p><h4 class="ms-3">고객님을 위한 추천 상품</h4></p>
	    <section class="product-recommend">
	    	<c:forEach var="goodsSameCategory" items="${goodsSameCategory}" varStatus="status">
		        <c:if test="${status.index < 2}">
			        <div class="goods">
			        	<a href="detail?goodsId=${goodsSameCategory.goodsId}">
				            <img id="goods-img" src="${pageContext.request.contextPath}/goods/downloadImageByRole?goodsId=${goodsSameCategory.goodsId}&imgRole=G_MAIN" class="goods-img flex-grow-1" alt="${goodsSameCtgy.goodsName}">			        	
			        	</a>
			            <div class="button-wrapper">
			                <button class="to-cart"><i class="bi bi-cart icon-margin"></i>담기</button>
			            </div>
			            <div class="goods-info">
			                <span class="goods-category">[${goodsSameCategory.category}]</span>
			                <span class="goods-name">${goodsSameCategory.goodsName}</span>
			                <p class="goods-comment">${goodsSameCategory.goodsComment}</p>
			                <span class="dimmed-price">
			                    <span class="price-number">
				                    <fmt:formatNumber value="${goodsSameCategory.price}" type="number" groupingUsed="true"/>		                    
			                    </span>
			                    <span class="won">원</span>
			                </span>
			            </div>
			        </div>	    			        
		        </c:if>
	        </c:forEach>
	    	
	    	<c:forEach var="goodsAlcohol" items="${goodsAlcohol}" varStatus="status">
	    		<c:if test="${status.index < 2}">
	    			<div class="goods">
	    				<a href="detail?goodsId=${goodsAlcohol.goodsId}">
				            <img id="goods-img" src="${pageContext.request.contextPath}/goods/downloadImageByRole?goodsId=${goodsAlcohol.goodsId}&imgRole=G_MAIN" class="goods-img flex-grow-1" alt="${goodsAlcohol.goodsName}">	    				
	    				</a>
			            <div class="button-wrapper">
			                <button class="to-cart"><i class="bi bi-cart icon-margin"></i>담기</button>
			            </div>
			            <div class="goods-info">
			                <span class="goods-category">[${goodsAlcohol.category}]</span>
			                <span class="goods-name">${goodsAlcohol.goodsName}</span>
			                <p class="goods-comment">${goodsAlcohol.goodsComment}</p>
			                <span class="dimmed-price">
			                    <span class="price-number">
				                    <fmt:formatNumber value="${goodsAlcohol.price}" type="number" groupingUsed="true"/>			                    
			                    </span>
			                    <span class="won">원</span>
			                </span>
			            </div>
			        </div>	    
	    		</c:if>
	    	</c:forEach>
	
	    </section>
	
	    <section class="product-detail">
	        <div class="d-flex">
	            <span id="move-info" class="btn flex-grow-1 detail-button">상품설명</span>
	            <span id="move-detail" class="btn flex-grow-1 detail-button">상세정보</span>
	            <span id="move-review" class="btn flex-grow-1 detail-button">리뷰</span>
	        </div>
	        <div id="detail-img-container" class="">
		            <img
		                id="detail-img1"
		                src="${pageContext.request.contextPath}/goods/downloadImageByRole?goodsId=${goods.goodsId}&imgRole=G_DESCRIPTION" 
		                alt="${goods.goodsName}"
		                class="detail-img"
		            />	        	
	            <br />
	            <img
	                id="detail-img2"
	                src="${pageContext.request.contextPath}/goods/downloadImageByRole?goodsId=${goods.goodsId}&imgRole=G_DETAIL" 
	                alt="${goods.goodsName}"
	                class="detail-img"
	            />
	        </div>
	    </section>
	    <br /><br />
	    <section style="height: 610px">
	        <p>
	            <span id="review-title">상품리뷰</span>
	            <span id="count-review">nn건</span>
	        </p>
	        <div id="review-container">
	            <div class="review-box">
	                <p>
	                    <span class="cus-name">고객이름</span>
	                    <span class="date">날짜</span>
	                </p>
	                <p class="review-content">리뷰들어갈 자리</p>
	            </div>
	        </div>
	        <div class="pagination"></div>
	    </section>
	</main>
	
	<button onclick="backToTop()" id="btn-back-to-top">Top</button>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>

