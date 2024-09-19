<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/category.css">

	<c:forEach var="goods" items="${goodsList}" begin="0" end="0">
		<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"
					onclick="location.href='${pageContext.request.contextPath}/'"><i
					class="bi bi-house-door-fill"></i></li>
				<li class="breadcrumb-item" 
					onclick="location.href='${pageContext.request.contextPath}/category/all'">카테고리</li>
				<li class="breadcrumb-item active" aria-current="page">${goods.category}</li>
			</ol>
		</nav>

		<h3 class="category-title">${goods.category}</h3>
	</c:forEach>
