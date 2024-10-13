<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/review.css">


<main class="container d-flex mypage">
<div class="mypage-category">
	<div class="profile d-flex">
		<i class="bi bi-person-fill"></i>
		<div class="profile-detail">
			<p>환영합니다.</p>
			<p class="member-name">${user.userName}님</p>
		</div>
	</div>
	<div class="category-box d-flex flex-column">
		<h3>나의 수라밀</h3>
		<p
			onclick="location.href='${pageContext.request.contextPath}/mypage/pick'">찜한
			상품</p>
		<p
			onclick="location.href='${pageContext.request.contextPath}/mypage/order'">주문
			내역</p>
		<p style="color: rgb(107, 6, 9); font-weight: bold;"
			onclick="location.href='${pageContext.request.contextPath}/mypage/review'">상품
			후기</p>
		<p
			onclick="location.href='${pageContext.request.contextPath}/mypage/modifyForm'">개인정보
			수정</p>
	</div>
</div>
<div class="mypage-box flex-grow-1">
	<div class="title-box">
		<p>상품 후기</p>
		<div class="horizontal-line"></div>
	</div>
	<div class="page-upload">
		<div class="review-container">
			<div class="review-choice-box">
				<div class="review-writeable-box">
					<p class="review-writeable">
						<button style="all: unset;" onclick="location.href='${pageContext.request.contextPath}/mypage/review'">작성 가능한 리뷰</button>
					</p>
				</div>
				<div class="review-written-box">
					<p class="review-written">
						<button style="all: unset;" onclick="location.href='${pageContext.request.contextPath}/mypage/reviewCompleteList'">작성한 리뷰</button>
					</p>
				</div>
			</div>
			<div class="review-writeable-page">
				<c:forEach items="${review}" var="review">
					<div class="product-box">
							<div class="product-details d-flex">
								<img src="${pageContext.request.contextPath}/goods/downloadImageByRole?goodsId=${review.goodsId}&imgRole=G_MAIN" alt="${review.goodsName}" class="product-image" />
								<div class="d-flex flex-column product-info">
									<p>
										<strong>주문 번호</strong> ${review.orderId}
									</p>
									<p>
										<strong>주문 날짜</strong> <fmt:formatDate value="${review.orderDate}" pattern="yyyy-MM-dd"/>
									</p>
									<p>
										<strong>상품명</strong> <span>${review.goodsName}</span>
									</p>
									<p>
										<strong>가격</strong> <fmt:formatNumber value="${review.goodsPrice}" type="number" groupingUsed="true"/>
									</p>
								</div>
								
							</div>					
						<button class="insert-button" data-bs-toggle="modal"
							data-bs-target="#staticBackdrop"
							data-order-id="${review.orderId}"
							data-goods-id="${review.goodsId}"
							data-goods-name="${review.goodsName}"
							data-goods-img="${pageContext.request.contextPath}/goods/downloadImageByRole?goodsId=${review.goodsId}&imgRole=G_MAIN"
							>작성하기</button>
					</div>
				</c:forEach>
			</div>
			<div class="review-written-page">
				<div class="review-box d-flex flex-column">
					<div class="review-top">
						<div>
							<p class="title">${r.title}</p>
							<p class="sub-title">${r.auther}| ${r.wirttenDay}</p>
						</div>
						<button class="update-button" data-bs-toggle="modal"
							data-bs-target="#staticBackdrop">수정하기</button>
					</div>
					<div class="review-description">
						<p class="description">${r.description}</p>
					</div>
				</div>


			</div>
			<div class="pagination">
					<a href="review?pageNo=1&month=${month}" class="btn btn-outline-dark btn-sm">처음</a>
		
					<c:if test="${pager.groupNo>1}">
						<a href="review?pageNo=${pager.startPageNo-1}&month=${month}"
							class="btn btn-outline-dark btn-sm">이전</a>
					</c:if>
		
					<c:forEach begin="${pager.startPageNo}" end="${pager.endPageNo}" step="1" var="i">
						<c:if test="${pager.pageNo==i}">
								<button class="page-num active" onclick="location.href='${pageContext.request.contextPath}/mypage/review?pageNo=${i}&month=${month}'">
									${i}
								</button>						
						</c:if>
						<c:if test="${pager.pageNo!=i}">
								<button class="page-num" onclick="location.href='${pageContext.request.contextPath}/mypage/review?pageNo=${i}&month=${month}'">
									${i}
								</button>
						</c:if>
					</c:forEach>
		
					<c:if test="${pager.groupNo<pager.totalGroupNo}">
						<a href="review?pageNo=${pager.endPageNo+1}&month=${month}"
							class="btn btn-outline-dark btn-sm">다음</a>
					</c:if>
		
					<a href="review?pageNo=${pager.totalPageNo}&month=${month}"
						class="btn btn-outline-dark btn-sm">마지막</a>
				</div>
		</div>

	</div>

</div>

<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <p class="modal-title text-center w-100" >상품후기 작성</p>
            </div>
            <div class="modal-body">
                <div class="d-flex">
                    <div class="modal-product-img d-flex" >
                        <p>구매<br/>상품</p>
                        <img id="modal-goods-img" src=""/>
                    </div>
                    <div class="modal-product-detail d-flex flex-column flex-grow-1">
                        <p><strong>상품명</strong> <span id="modal-goods-name"></span></p>
                        <p><strong>작성일</strong> <span>${currentDate}</span></p>
                    </div>
                </div>
                <div class="modal-review d-flex" >
                    <p>내용</p>
                    <textarea id="modal-review-content"></textarea>
                </div>
            </div>
            <div class="modal-footer d-flex justify-content-center">
                <button class="review-close" data-bs-dismiss="modal">취소</button>
                <button id="review-update" class="review-update">작성하기</button>
            </div>
        </div>
    </div>
</div>

</main>

<script>
$(document).on('click', '.insert-button', function() {
	const orderId = $(this).data('order-id');
	const goodsId = $(this).data('goods-id');
	const goodsName = $(this).data('goods-name');
	const imgSrc = $(this).data('goods-img');
	
	$('#modal-goods-name').text(goodsName);
	$('#modal-goods-img').attr('src', imgSrc);	
	
	$('#review-update').data('order-id', orderId);
	$('#review-update').data('goods-id', goodsId);
	$('#review-update').data('goods-name', goodsName);
});

$(document).on('click', '.review-update', function() {
	const orderId = $(this).data('order-id');
	const goodsId = $(this).data('goods-id');
	const goodsName = $(this).data('goods-name');
	const reviewContent = $('#modal-review-content').val();
	
	$.ajax({
		type: 'POST',
		url: 'writeReview',
		data: {
			orderId: orderId,
			goodsId: goodsId,
			goodsName: goodsName,
			reviewContent: reviewContent
		},
		success: function(data) {
			 $('#staticBackdrop').modal('hide');
			 location.reload();
		},
		error: function(xhr, status, error) {
			console.log('오류' + xhr.responseText);
		}
	})
});
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>