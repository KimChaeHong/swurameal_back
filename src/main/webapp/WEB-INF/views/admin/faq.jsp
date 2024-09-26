<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice.css">

<main class="container d-flex admin">
<div class="admin-category">
		<div class="category-box d-flex flex-column">
			<h3>관리자 메뉴</h3>
			<p onclick="location.href='${pageContext.request.contextPath}/mgmt/gMgmt'" style="color: rgb(117, 117, 117); font-weight: normal;">상품 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/answer'" style="color: rgb(117, 117, 117); font-weight: normal;">1:1 문의 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/notice'" style="color: rgb(117, 117, 117); font-weight: normal;">공지사항 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/faq'" style="color: rgb(107, 6, 9); font-weight: bold;">FAQ 관리</p>
		</div>
	</div>

	<div class="admin-box flex-grow-1">
		<div class="title-box">
			<div class="addButton">
				<p>FAQ 관리</p>
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
			<c:forEach items="${list}" var="faq">
				<div class="notice-list">
					<div class="notice-info d-flex align-items-center">
						<div>[${faq.faqTitle}]</div>
						<div>${faq.userId}</div>
						<div>${faq.faqRegisterDate}</div>
					</div>
				</div>
			</c:forEach>	
			
			<div class="pagination">
				<button class="page-num active">1</button>
			</div>
			
			</div>
		</div>
	</div>
</main>


<%@ include file="/WEB-INF/views/common/footer.jsp"%>