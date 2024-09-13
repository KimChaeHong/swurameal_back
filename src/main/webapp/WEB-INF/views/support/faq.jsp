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
		<h5 class="active h5"
			onclick="location.href='${pageContext.request.contextPath}/support/faq'">자주묻는질문</h5>
		<h5 class="h5"
			onclick="location.href='${pageContext.request.contextPath}/support/qna'">문의</h5>
	</div>
</section>

<section id="mainContent">
	<h3 class="h3" id="title">자주묻는질문</h3>
	<div id="board-container">
		<div class="board-top d-flex align-items-center">
			<p class="flex-grow-1">번호</p>
			<p id="just-title">제목</p>
			<p class="flex-grow-1">작성자</p>
		</div>

		<div class="board-list">
			<c:forEach var="faq" items="${list}">
				<div class="accordion-item">
					<h2 class="accordion-header">
						<button
							class="board d-flex align-item-center accordion-button collapsed"
							type="button" data-bs-toggle="collapse"
							data-bs-target="#collapse${faq.faqId}" aria-expanded="false"
							aria-controls="collapse${faq.faqId}">
							<p class="post-num text-center me-3" id="post-num${faq.faqId}">${faq.faqId}</p>
							<p class="post-title">${faq.faqTitle}</p>
							<p id="post-status${faq.userId}" class="flex-grow-1 text-center">${faq.userId}</p>
						</button>
					</h2>

					<div id="collapse${faq.faqId}" class="accordion-collapse collapse">
						<div id="content${faq.faqContent}" class="accordion-body">
							<p class="faq-content">${faq.faqContent}</p>
							<p class="faq-date">
								<fmt:formatDate value="${faq.faqRegisterDate}"
									pattern="yyyy-MM-dd" />
							</p>

						</div>
					</div>
			</c:forEach>
		</div>
		<!-- <div class="d-flex justify-content-center">
			</div>
				<div class="pagination"></div>
			</div>
		</div> -->
	</div>
</section>
</main>


<%@ include file="/WEB-INF/views/common/footer.jsp"%>