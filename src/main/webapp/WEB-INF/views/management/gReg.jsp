<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/goods.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/goodsMgmt.css">

<main class="container d-flex admin">
<div class="admin-category">
	<div class="category-box d-flex flex-column">
		<h3>관리자 메뉴</h3>
		<p
			onclick="location.href='${pageContext.request.contextPath}/mgmt/gMgmt'"
			style="color: rgb(117, 117, 117); font-weight: bold;">상품 관리</p>
		<p
			onclick="location.href='${pageContext.request.contextPath}/admin/answer'">1:1
			문의 관리</p>
		<p
			onclick="location.href='${pageContext.request.contextPath}/admin/notice'">공지사항
			관리</p>
		<p
			onclick="location.href='${pageContext.request.contextPath}/admin/faq'">FAQ
			관리</p>
	</div>
</div>
<div class="admin-box flex-grow-1">
	<div class="title-box">
		<div class="addButton">
			<p>상품 관리</p>
		</div>
		<div class="horizontal-line"></div>
	</div>
	<div class="page-upload"></div>
</div>
</main>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>