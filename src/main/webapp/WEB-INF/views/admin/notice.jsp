<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice.css">

<main class="container d-flex admin">
	<div class="admin-category">
		<div class="category-box d-flex flex-column">
			<h3>관리자 메뉴</h3>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/goodsManagement'" style="color: rgb(117, 117, 117); font-weight: normal;">상품 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/answer'" style="color: rgb(117, 117, 117); font-weight: normal;">1:1 문의 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/notice'" style="color: rgb(107, 6, 9); font-weight: bold;">공지사항 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/faq'" style="color: rgb(117, 117, 117); font-weight: normal;">FAQ 관리</p>
		</div>
	</div>
	<div class="admin-box flex-grow-1">
		<div class="title-box">
			<div class="addButton">
				<p>공지사항 관리</p>
				<a href="${pageContext.request.contextPath}/admin/noticeWrite">
					<button data-flag="notice">
						작성하기
					</button>
				</a>
			</div>
			<div class="horizontal-line"></div>
		</div>
		<div class="page-upload">
			<div class="notice-box d-flex flex-column">
				<div class="notice-header d-flex">
					<div>제목</div>
					<div>작성자</div>
					<div>등록일</div>
				</div>
				<div class="notice-list">
					<c:forEach items="${list}" var="notice">
						<div class="notice-info d-flex align-items-center">
							<div>${notice.noticeTitle}</div>
							<div>${notice.userId}</div>
							<div><fmt:formatDate value="${notice.noticeRegisterDate}" pattern="yyyy-MM-dd" /></div>
						</div>
					</c:forEach>
				</div>
				<div class="pagination">
					<button class="page-num active">1</button>
				</div>
			</div>
		</div>
	</div>
</main>

<button onclick="backToTop()" id="btn-back-to-top">Top</button>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
