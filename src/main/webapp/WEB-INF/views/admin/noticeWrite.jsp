<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice-form.css">

<main class="container d-flex admin">

	<div class="admin-category">
		<div class="category-box d-flex flex-column">
			<h3>관리자 메뉴</h3>
			<p data-js="../js/goods.js"
				style="color: rgb(117, 117, 117); font-weight: normal;">상품 관리</p>
			<p data-js="../js/qna.js"
				style="color: rgb(117, 117, 117); font-weight: normal;">1:1 문의 관리</p>
			<p data-js="../js/notice.js"
				style="color: rgb(107, 6, 9); font-weight: bold;">공지사항 관리</p>
			<p data-js="../js/faq.js"
				style="color: rgb(117, 117, 117); font-weight: normal;">FAQ 관리</p>
		</div>
	</div>
	
	<div class="admin-box flex-grow-1">
		<div class="title-box">
			<div class="addButton">
				<p>공지사항 관리</p>
			</div>
			<div class="horizontal-line"></div>
		</div>
		<div class="page-upload">
			<div class="notice-form d-flex flex-column">
				<form action="${pageContext.request.contextPath}/admin/notice" method="post">
					<div class="notice-title-box">
						<p>
							제목<span>*</span>
						</p>
						<input type="text" value="" class="notice-form-title"
							placeholder="제목을 입력해주세요.">
					</div>
					<div class="notice-content-box">
						<p>
							내용<span>*</span>
						</p>
						<textarea class="notice-form-content" placeholder="내용을 입력해주세요."></textarea>
					</div>
					<div class="notice-form-buttons">
						<button type="submit" name="action" value="delete">삭제</button>
						<button type="submit" name="action" value="insert">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</main>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
