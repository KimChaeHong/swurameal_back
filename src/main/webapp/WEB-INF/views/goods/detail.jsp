<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
    <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/detail.css">

	<main class="container">
	    <section class="d-flex main-content">
	        <div id="image-container">
	            <img src="../src/images/322.png" />
	        </div>
	        <div id="product-info">
	            <p id="product-name">[한식]매운 돼지갈비찜</p>
	            <p id="product-coment">매콤한 제주도 신선 흑돼지</p>
	            <p id="product-price"></p>
	            <hr />
	            <div class="d-flex">
	                <span id="delivery">배송</span>
	                <span>1~2일</span>
	            </div>
	            <hr />
	            <div class="d-flex">
	                <span id="seller">판매자</span>
	                <span>수라밀</span>
	            </div>
	            <hr />
	            <div class="d-flex">
	                <span id="unit">판매단위</span>
	                <span>1팩</span>
	            </div>
	            <hr />
	            <div class="d-flex">
	                <span id="product-weight">중량/용량</span>
	                <span>840g</span>
	            </div>
	            <hr />
	            <div class="d-flex">
	                <span id="product-quantity">상품선택</span>
	                <div id="count-box">
	                    <p id="mini-name">[한식]매운 돼지갈비찜</p>
	
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
	                <span id="pick" class="btn"><i id="pick-icon" class="bi bi-heart"></i></span> <!--찜버튼 아이콘 -->
	                <span id="cart" class="btn"><i class="bi bi-cart"></i></span> <!--장바구니 아이콘-->
	                <span id="buy" class="btn">구매하기</span>
	            </div>
	        </div>
	    </section>
	
	    <!--추천상품-->
	    <p><h4 class="ms-3">고객님을 위한 추천 상품</h4></p>
	    <section class="product-recommend">
	        <div class="goods">
	            <img id="goods-img" src="../src/images/321.png" class="goods-img flex-grow-1" alt="${goods.goodsName}">
	            <div class="button-wrapper">
	                <button class="to-cart"><i class="bi bi-cart icon-margin"></i>담기</button>
	            </div>
	            <div class="goods-info">
	                <span class="goods-category">[한식]</span>
	                <span class="goods-name">간장 돼지갈비찜</span>
	                <p class="goods-comment">제주도 출신 신선</p>
	                <span class="dimmed-price">
	                    <span class="price-number">11,500</span>
	                    <span class="won">원</span>
	                </span>
	            </div>
	        </div>
	
	        <div class="goods">
	            <img id="goods-img" src="../src/images/312.png" class="goods-img flex-grow-1" alt="${goods.goodsName}">
	            <div class="button-wrapper">
	                <button class="to-cart"><i class="bi bi-cart icon-margin"></i>담기</button>
	            </div>
	            <div class="goods-info">
	                <span class="goods-category">[한식]</span>
	                <span class="goods-name">된장찌개</span>
	                <p class="goods-comment">김치찌개 먹고 싶은 날 딱!</p>
	                <span class="dimmed-price">
	                    <span class="price-number">6,900</span>
	                    <span class="won">원</span>
	                </span>
	            </div>
	        </div>
	
	        <div class="goods">
	            <img id="goods-img" src="../src/images/423.png" class="goods-img flex-grow-1" alt="${goods.goodsName}">
	            <div class="button-wrapper">
	                <button class="to-cart"><i class="bi bi-cart icon-margin"></i>담기</button>
	            </div>
	            <div class="goods-info">
	                <span class="goods-category">[전통주]</span>
	                <span class="goods-name">독도 소주</span>
	                <p class="goods-comment">한국 사람 1인 1명이 국법</p>
	                <span class="dimmed-price">
	                    <span class="price-number">11,500</span>
	                    <span class="won">원</span>
	                </span>
	            </div>
	        </div>
	
	        <div class="goods">
	            <img id="goods-img" src="../src/images/424.png" class="goods-img flex-grow-1" alt="${goods.goodsName}">
	            <div class="button-wrapper">
	                <button class="to-cart"><i class="bi bi-cart icon-margin"></i>담기</button>
	            </div>
	            <div class="goods-info">
	                <span class="goods-category">[전통주]</span>
	                <span class="goods-name">제주 탐라주</span>
	                <p class="goods-comment">한라산은 가라...</p>
	                <span class="dimmed-price">
	                    <span class="price-number">7,000</span>
	                    <span class="won">원</span>
	                </span>
	            </div>
	        </div>
	
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
	                src="../src/images/detail1.jpg"
	                class="detail-img"
	            />
	            <br />
	            <img
	                id="detail-img2"
	                src="../src/images/detail2.png"
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
