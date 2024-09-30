<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="https://code.jquery.com/jquery-3.7.1.js"
   integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
   crossorigin="anonymous"></script>

<script src="${pageContext.request.contextPath}/resources/js/itemList.js"></script>

<link rel="stylesheet" type="text/css"
   href="${pageContext.request.contextPath}/resources/css/cart.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/style.css">

<main class="container cart"> <c:if test="${not empty message}">
   <div class="cartEmpty">${message}</div>
</c:if> <c:if test="${not empty goodsList}">
   <h2>${user.userName}님의 장바구니</h2>
   <div id="select-btns">
      <i class="bi bi-check-circle hover" id="allBtn"></i> <span
         class="hover" id="allBtnTxt">전체선택</span> <span> | </span> 
         <a class="hover" href="${pageContext.request.contextPath}/cart/itemAllDelete">전체삭제</a>
   </div>

   <div class="d-flex justify-content-between">
      <div id="cart-items">
         <c:forEach var="goods" items="${goodsList}">
            <div class="item d-flex justify-content-between" data-goods-id="${goods.goodsId}">
              
               <i class="bi bi-check-circle hover"
               	data-goods-id="${goods.goodsId}" 
         		data-quantity="1" ></i>
         		 
	          <img src="${pageContext.request.contextPath}/goods/downloadImage?goodsId=${goods.goodsId}"
                   class="goods-img" alt="${goods.goodsName}">

               <div id="item-detail">
                  <p>[${goods.category}] ${goods.goodsName}</p>
                  <p>${goods.goodsComment}</p>
                  <div class="cnt-btn">
                     <button class="updown-btn">-</button>
                     <span class="item-cnt">1</span>
                     <button class="updown-btn">+</button>
                  </div>
               </div>
               <div id="item-price">
                  <span class="price" data-price="${goods.price}"><fmt:formatNumber
                        value="${goods.price}" pattern="#,###"/></span> <span class="won">원</span>
               </div>

               <a
                  href="${pageContext.request.contextPath}/cart/itemDelete?goodsId=${goods.goodsId}">
                  <i class="bi bi-x-lg hover" id="xBtn"></i>
               </a>
            </div>
         </c:forEach>
      </div>

      <div id="cart-pay">
         <div id="how-much">
            <p>주문내역</p>
            <div class="d-flex justify-content-between">
               <span>상품금액</span> <span> <span id="total-price">${goods.price}</span>원
               </span>
            </div>
            <div class="d-flex justify-content-between">
               <span>배송비</span> <span>3,000원</span>
            </div>
            <div class="d-flex justify-content-between total">
               <span>결제예정금액</span> <span> <span id="pay-price">${goods.price}</span>원
               </span>
            </div>
         </div>
         <button class="order-button" >주문하기</button>
      </div>
   </div>
</c:if> 
</main>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
<script>
$(document).on('click', '.order-button', function() {
    const goodsData = [];

    $('.bi-check-circle-fill').each(function() {
        const goodsId = $(this).data('goods-id');
        const quantity = $(this).data('quantity');

        goodsData.push({ 
        	goodsId: goodsId
        	});
    });

    const form = $('<form>', {
        method: 'post',
        action: `${pageContext.request.contextPath}/order/order`,
    });

    $('<input>').attr({
        type: 'hidden',
        name: 'goodsData',
        value: JSON.stringify(goodsData),
    }).appendTo(form);

    form.appendTo('body').submit();
});
</script>