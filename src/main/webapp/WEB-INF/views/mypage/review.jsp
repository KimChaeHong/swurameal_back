<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			onclick="location.href='${pageContext.request.contextPath}/mypage/modify'">개인정보
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
					<p class="review-writeable">작성 가능한 리뷰</p>
				</div>
				<div class="review-written-box">
					<p class="review-written">작성한 리뷰</p>
				</div>
			</div>
			<div class="review-writeable-page">
				<div class="product-box">
					<div class="product-details d-flex">
						<img src="${item.img}" class="product-image" />
						<div class="d-flex flex-column product-info">
							<p>
								<strong>주문 번호</strong> ${item.orderNumber}
							</p>
							<p>
								<strong>주문 날짜</strong> ${item.orderDay}
							</p>
							<p>
								<strong>상품명</strong> <span>${item.title}</span>
							</p>
							<p>
								<strong>가격</strong> ${item.price}
							</p>
						</div>
					</div>
					<button class="insert-button" data-bs-toggle="modal"
						data-bs-target="#staticBackdrop">작성하기</button>
				</div>
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
			<div class="pagination"></div>
		</div>

	</div>

</div>
</main>


<%@ include file="/WEB-INF/views/common/footer.jsp"%>