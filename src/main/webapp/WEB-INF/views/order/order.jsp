<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<script src="https://code.jquery.com/jquery-3.7.1.js"
   integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
   crossorigin="anonymous"></script>

<script src="${pageContext.request.contextPath}/resources/js/pay.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pay.css">

<!-- 주문결제 페이지 메인 -->
    <main class="container pay">
      <h2>주문 / 결제</h2>
      <div class="d-flex justify-content-between">
        <div class="left-section">
          <!-- 주문상품 -->
          <div id="pay-items">
			<div class="title">주문상품</div>
			<c:forEach items="${goods}" var="goods">
				<div class="item d-flex justify-content-between">
					<img src="${pageContext.request.contextPath}/goods/downloadImageByRole?goodsId=${goods.goodsId}&imgRole=G_MAIN" alt="상품이미지">
					<div id="item-detail">
						<p>[${goods.category}] ${goods.goodsName}</p>
						<p>${goods.goodsComment}</p>
					</div>
					<div class="item-cnt"
						data-goods-id="${goods.goodsId}" 
						data-quantity="${goods.quantity}"
						data-price="${goods.price}"
					>${goods.quantity}개</div>
					<div class="item-price">
						<span>
							<fmt:formatNumber value="${goods.price}" pattern="#,###"/>
                        </span>원
					</div>
				</div>			
			</c:forEach>
		</div>

		<!-- 주문자 정보 -->
          <div id="user-info">
            <div class="title">주문자 정보</div>
            <span class="label">주문자명</span>
            <span>${user.userName}</span><br />
            <span class="label">휴대폰 번호</span>
            <span>${user.userPhone}</span><br />
            <span class="label">이메일</span>
            <span>${user.userEmail}</span><br />
            <span class="label">배송지</span>
            <input id="user-address" value="${user.userAddress}"></input>
            <button onclick="searchAddress()">배송지 변경</button>
          </div>

          <!-- 개인정보 및 결제 동의 -->
          <div id="pay-agree">
            <div class="title d-flex justify-content-between">
                <p>개인정보 및 결제 동의</p>
                <i class="bi bi-square" id="allBtn"></i>
            </div>
            <div class="d-flex justify-content-between">
                <span>개인정보 수집 이용 및 처리 동의</span>
                <i class="bi bi-square"></i>
            </div>
            <div class="d-flex justify-content-between">
                <span>전자지급 결제대행 서비스 이용약관 동의</span>
                <i class="bi bi-square"></i>
            </div>
            <div class="d-flex justify-content-between agree">
                <p>위 내용을 확인 하였으며 결제에 동의합니다.</p>
                <i class="bi bi-square"></i>
            </div>
          </div>
        </div>

        <!-- 주문내역서 -->
        <div id="pay-pay">
          <div id="how-much">
            <p>주문/결제 내역</p>
            <div class="d-flex justify-content-between">
              <span>상품금액</span>
              	<span id="total-goods-price">
              		<fmt:formatNumber value="${goodsSameCategory.price}" type="number" groupingUsed="true"/>
           		</span>
            </div>
            <div class="d-flex justify-content-between">
              <span>배송비</span>
              <span>3,000원</span>
            </div>
            <div class="d-flex justify-content-between total">
              <span>최종결제금액</span>
              <span id="total-sum-price">원</span>
            </div>
          </div>
          <button id="payBtn">결제하기</button>
        </div>
      </div>
    </main>
    <button onclick="backToTop()" id="btn-back-to-top">Top</button>
    
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
<script>
let totalSum = 0;
$(document).ready(function() {
	$('.item-cnt').each(function() {
		const quantity = $(this).data('quantity');
        const price = $(this).data('price');
        
        const itemTotal = quantity * price;
        totalSum += itemTotal;
    });
	const formattedSum = new Intl.NumberFormat().format(totalSum);
	const formattedTotalSum = new Intl.NumberFormat().format(totalSum+3000);
	$('#total-goods-price').text(formattedSum);
    $('#total-sum-price').text(formattedTotalSum);
})

$(document).on('click', '#payBtn', function() {
    const goodsData = [];
    
    $('.item-cnt').each(function() {
        const goodsId = $(this).data('goods-id');
        const quantity = $(this).data('quantity');
        const price = $(this).data('price');
        const itemTotal = quantity * price;
        totalSum += itemTotal;
        
        goodsData.push({ 
        	goodsId: goodsId, 
        	quantity: quantity, 
        	price: price 
        	});
    });
    
    $.ajax({
        type: 'POST',
        url: 'orderComplete',
        contentType: 'application/json',
        data: JSON.stringify(goodsData),
        success: function(response) {
        	window.location.href = '${pageContext.request.contextPath}'
        },
        error: function(xhr, status, error) {
            alert("Error: " + error);
        }
    });
});
</script>