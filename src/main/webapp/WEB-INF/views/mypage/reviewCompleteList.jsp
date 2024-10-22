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
			onclick="location.href='${pageContext.request.contextPath}/user/modifyForm'">개인정보
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
					<div class="review-box d-flex flex-column">
						<div class="review-top">
							<div>
								<p class="title">${review.goodsName}</p>
								<p class="sub-title">수라밀 |<fmt:formatDate value="${review.reviewDate}" pattern="yyyy-MM-dd" /></p>
							</div>
							<button class="update-button" data-bs-toggle="modal"
								data-bs-target="#staticBackdrop"
								data-review-id="${review.reviewId}"
								data-review-content="${review.reviewContent}"
								data-goods-name="${review.goodsName}"
								data-review-date="${review.reviewDate}"
								data-goods-img="${pageContext.request.contextPath}/goods/downloadImageByRole?goodsId=${review.goodsId}&imgRole=G_MAIN"
								>수정하기</button>
						</div>
						<div class="review-description">
							<p class="description">
								${review.reviewContent}
							</p>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="pagination">
					<a href="reviewCompleteList?pageNo=1&month=${month}" class="btn btn-outline-dark btn-sm">처음</a>
		
					<c:if test="${pager.groupNo > 1}">
						<a href="reviewCompleteList?pageNo=${pager.startPageNo-1}&month=${month}"
							class="btn btn-outline-dark btn-sm">이전</a>
					</c:if>
		
					<c:forEach begin="${pager.startPageNo}" end="${pager.endPageNo}" step="1" var="i">
						<c:if test="${pager.pageNo==i}">
								<button class="page-num active" onclick="location.href='${pageContext.request.contextPath}/mypage/reviewCompleteList?pageNo=${i}&month=${month}'">
									${i}
								</button>						
						</c:if>
						<c:if test="${pager.pageNo!=i}">
								<button class="page-num" onclick="location.href='${pageContext.request.contextPath}/mypage/reviewCompleteList?pageNo=${i}&month=${month}'">
									${i}
								</button>
						</c:if>
					</c:forEach>
		
					<c:if test="${pager.groupNo < pager.totalGroupNo}">
						<a href="reviewCompleteList?pageNo=${pager.endPageNo + 1}&month=${month}"
							class="btn btn-outline-dark btn-sm">다음</a>
					</c:if>
		
					<a href="reviewCompleteList?pageNo=${pager.totalPageNo}&month=${month}"
						class="btn btn-outline-dark btn-sm">마지막</a>
				</div>
		</div>

	</div>

</div>

<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <p class="modal-title text-center w-100" >상품후기 수정</p>
            </div>
            <div class="modal-body">
                <div class="d-flex">
                    <div class="modal-product-img d-flex" >
                        <p>구매<br/>상품</p>
                        <img id="modal-goods-img" src=""/>
                    </div>
                    <div class="modal-product-detail d-flex flex-column flex-grow-1">
                        <p><strong>상품명</strong> <span id="modal-goods-name"></span></p>
                        <!-- <p><strong>작성일</strong> <span id="modal-review-date"></span></p> -->
                    </div>
                </div>
                <div class="modal-review d-flex" >
                    <p>내용</p>
                    <textarea id="modal-review-content"></textarea>
                </div>
            </div>
            <div class="modal-footer d-flex justify-content-center">
                <button class="review-close" data-bs-dismiss="modal">취소</button>
                <button id="review-update" class="review-update">수정하기</button>
            </div>
        </div>
    </div>
</div>

</main>

<script>
$(document).on('click', '.update-button', function() {
	const goodsName = $(this).data('goods-name');
	const imgSrc = $(this).data('goods-img');
	const reviewId = $(this).data('review-id');
	const reviewContent = $(this).data('review-content');
	const reviewDate = $(this).data('review-date');
	
	$('#modal-goods-name').text(goodsName);
	$('#modal-goods-img').attr('src', imgSrc);	
	$('#modal-review-content').text(reviewContent);
 	$('#modal-review-date').text(reviewDate);
	
	$('#review-update').data('review-id', reviewId);
	
	style="color: rgb(107, 6, 9); font-weight: bold;"
});

$(document).on('click', '.review-update', function() {
	const reviewId = $(this).data('review-id');
	const reviewContent = $('#modal-review-content').val();
	
	$.ajax({
		type: 'POST',
		url: 'editReview',
		data: {
			reviewId: reviewId,
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
<script src="${pageContext.request.contextPath}/resources/js/mypage.js"></script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>