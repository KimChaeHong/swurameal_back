<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/support.css">
<script src="${pageContext.request.contextPath}/resources/js/qna.js"></script>
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
		<c:forEach items="${list}" var="question">
	 	<div class="board-list">
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button
						class="board d-flex align-item-center accordion-button collapsed"
						type="button" data-bs-toggle="collapse"
						data-bs-target="#collapse${question.questionId}" aria-expanded="false"
						aria-controls="collapse${question.questionId}">
						<p class="post-title">${question.questionTitle}</p>
						<p class="flex-grow-1 text-center">
						    <fmt:formatDate value="${question.questionDate}" pattern="yyyy.MM.dd" />
						</p>
						<p id="post-status${question.userId}" class="flex-grow-1 text-center" data-status="${question.questionStatus}">
        					${question.questionStatus}
    					</p>
					</button>
				</h2>
				<div id="collapse${question.questionId}" class="accordion-collapse collapse"
					data-bs-parent="#accordionExample">
					<div id="content${question.questionId}" class="accordion-body">
						${question.questionContent}
						
					</div>
				</div>
			</div>
	 	</div>
	 	</c:forEach>
		<div class="d-flex justify-content-center">
		    <div class="pagination">
				<button class="page-num"></button>
		    </div>
	    </div>
	 	<div id="inq-btn-container" class="d-flex justify-content-end mb-3">
	        <p class="btn inquiry-button ajax-btn" onclick="location.href='${pageContext.request.contextPath}/qna/questionWriteForm'">문의하기</p>
	    </div>
    </div>
</section>
</main>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>