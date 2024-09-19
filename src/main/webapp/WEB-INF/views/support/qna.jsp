<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/support.css">

<main class="d-flex container support-container">
<section id="leftSide">
	<div id="side-category">
		<h3 class="h3">고객센터</h3>
		<h5 class="h5"
			onclick="location.href='${pageContext.request.contextPath}/support/notice'">공지사항</h5>
		<h5 class="h5"
			onclick="location.href='${pageContext.request.contextPath}/support/faq'">자주묻는질문</h5>
		<h5 class="active h5"
			onclick="location.href='${pageContext.request.contextPath}/support/qna'">문의</h5>
	</div>
</section>


<section id="mainContent">
	<h3 class="h3" id="title">문의</h3>
	<div id="board-container">
		<div class="board-top d-flex align-items-center">
			<p id="just-title">제목</p>
			<p class="flex-grow-1">작성일</p>
			<p class="flex-grow-1">답변상태</p>
		</div>
	</div>

	<div class="accordion-item">
		<h2 class="accordion-header">
			<button
				class="board d-flex align-item-center accordion-button collapsed"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#collapse${i}" aria-expanded="false"
				aria-controls="collapse${i}">
				<p class="post-title">${qnaData[i].title}</p>
				<p class="flex-grow-1 text-center">${qnaData[i].date}</p>
				<p id="post-status${i}" class="flex-grow-1 text-center">${qnaData[i].status}</p>
			</button>
		</h2>
		<div id="collapse${i}" class="accordion-collapse collapse"
			data-bs-parent="#accordionExample">
			<div id="content${i}" class="accordion-body">
				${qnaData[i].content}
				<div class="form-button-container">
					<span class="btn btn-md form-button" data-num="${i}">답변하기</span>
				</div>
			</div>
		</div>
	</div>
	
</section>
</main>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>