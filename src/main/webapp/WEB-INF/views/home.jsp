<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ include file="/WEB-INF/views/common/carousel.jsp" %>

<div class="goods-list">
	<div class="category-branding">
		<span class="category-comment">🍜 학교 앞에서 먹던 추억의 분식</span> 
		<a type="button" class="category-move" href="${pageContext.request.contextPath}/category/snacks">
			<i class="bi bi-chevron-right icon-move"></i>
		</a>
	</div>
	<div class="goods-list">
	    <c:forEach var="goods" items="${goodsList}" varStatus="status">
	        <c:if test="${goods.goodsId == 115 || goods.goodsId == 116 || goods.goodsId == 121 || goods.goodsId == 124}">
	            <div class="goods">
	            	<a href="goods/detail?goodsId=${goods.goodsId}">
		                <img id="goods-img" src="${pageContext.request.contextPath}/goods/downloadImage?goodsId=${goods.goodsId}" class="goods-img" alt="${goods.goodsName}">	            	
	            	</a>
	                <div class="button-wrapper">
	                    <button class="to-cart">
	                        <i class="bi bi-cart icon-margin">
	                        </i>담기
	                    </button>
	                </div>
	                <div class="goods-info">
	                    <span class="goods-category">[${goods.category}]</span>
	                    <span class="goods-name">${goods.goodsName}</span>
	                    <p class="goods-comment">${goods.goodsComment}</p>
	                    <span class="dimmed-price">
	                         <fmt:formatNumber value="${goods.price}" type="number" groupingUsed="true"/>
	                        <span class="won">원</span>
	                    </span>
	                </div>
	            </div>
	        </c:if>
	   </c:forEach>
	</div>
</div>

<div class="goods-list">
	<div class="category-branding">
		<span class="category-comment">🍝 이번 주말 홈 파티 어때요?</span> 
		<a type="button" class="category-move" href="${pageContext.request.contextPath}/category/western">
			<i class="bi bi-chevron-right icon-move"></i>
		</a>
	</div>
	<div class="goods-list">
	    <c:forEach var="goods" items="${goodsList}" varStatus="status">
	        <c:if test="${goods.goodsId == 214 || goods.goodsId == 221 || goods.goodsId == 211 || goods.goodsId == 223}">
	            <div class="goods">
	            	<a href="goods/detail?goodsId=${goods.goodsId}">
	                	<img id="goods-img" src="${pageContext.request.contextPath}/goods/downloadImage?goodsId=${goods.goodsId}" class="goods-img" alt="${goods.goodsName}">
	                </a>
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
	                         <fmt:formatNumber value="${goods.price}" type="number" groupingUsed="true"/>
	                        <span class="won">원</span>
	                    </span>
	                </div>
	            </div>
	        </c:if>
	   </c:forEach>
	</div>
</div> 


<div class="goods-list">
	<div class="category-branding">
		<span class="category-comment">🍲 엄마의 손맛을 자취방에서 느끼기</span> 
		<a type="button" class="category-move" href="${pageContext.request.contextPath}/category/korean">
			<i class="bi bi-chevron-right icon-move"></i>
		</a>
	</div>	
	<div class="goods-list">
	    <c:forEach var="goods" items="${goodsList}" varStatus="status">
	        <c:if test="${goods.goodsId == 311 || goods.goodsId == 314 || goods.goodsId == 324 || goods.goodsId == 333}">
	            <div class="goods">
	            	<a href="goods/detail?goodsId=${goods.goodsId}">
	                	<img id="goods-img" src="${pageContext.request.contextPath}/goods/downloadImage?goodsId=${goods.goodsId}" class="goods-img" alt="${goods.goodsName}">
	                </a>
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
	                         <fmt:formatNumber value="${goods.price}" type="number" groupingUsed="true"/>
	                        <span class="won">원</span>
	                    </span>
	                </div>
	            </div>
	        </c:if>
	   </c:forEach>
	</div>
</div> 

<div class="goods-list">
	<div class="category-branding">
		<span class="category-comment">🍶 05년생 미만 아가들은 가라</span> 
		<a type="button" class="category-move" href="${pageContext.request.contextPath}/category/tradDrink">
			<i class="bi bi-chevron-right icon-move"></i>
		</a>
	</div>	
	<div class="goods-list">
	    <c:forEach var="goods" items="${goodsList}" varStatus="status">
	        <c:if test="${goods.goodsId == 411 || goods.goodsId == 431 || goods.goodsId == 423 || goods.goodsId == 413}">
	            <div class="goods">
	            	<a href="goods/detail?goodsId=${goods.goodsId}">
	                	<img id="goods-img" src="${pageContext.request.contextPath}/goods/downloadImage?goodsId=${goods.goodsId}" class="goods-img" alt="${goods.goodsName}">
	                </a>
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
	                         <fmt:formatNumber value="${goods.price}" type="number" groupingUsed="true"/>
	                        <span class="won">원</span>
	                    </span>
	                </div>
	            </div>
	        </c:if>
	   </c:forEach>
	</div>
</div>

<!-- JavaScript 코드 추가 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('.to-cart').click(function() {
                var goodsId = $(this).closest('.goods').find('a').attr('href').split('goodsId=')[1];
                var userId = '로그인된 사용자 ID'; // 실제 로그인된 사용자 ID로 수정해야 합니다.

                $.ajax({
                    url: '${pageContext.request.contextPath}/cart/add',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify({
                        userId: userId,
                        goodsId: parseInt(goodsId),
                        quantity: 1 // 기본 수량 1로 설정
                    }),
                    success: function(response) {
                        alert('상품이 장바구니에 추가되었습니다.');
                    },
                    error: function(error) {
                        alert('상품 추가에 실패했습니다.');
                    }
                });
            });
        });
    </script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>