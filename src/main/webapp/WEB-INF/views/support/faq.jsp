<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/support.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice.css">


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
				</div>
			</c:forEach>
		</div>
		<div class="pagination">
				<a href="faq?pageNo=1" class="btn btn-outline-dark btn-sm">처음</a>
	
				<c:if test="${pager.groupNo>1}">
					<a href="faq?pageNo=${pager.startPageNo-1}"
						class="btn btn-outline-dark btn-sm">이전</a>
				</c:if>
	
				<c:forEach begin="${pager.startPageNo}" end="${pager.endPageNo}"
					step="1" var="i">
					<c:if test="${pager.pageNo==i}">
							<button class="page-num active" onclick="location.href='${pageContext.request.contextPath}/support/faq?pageNo=${i}'">
								${i}
							</button>						
					</c:if>
					<c:if test="${pager.pageNo!=i}">
							<button class="page-num" onclick="location.href='${pageContext.request.contextPath}/support/faq?pageNo=${i}'">
								${i}
							</button>
					</c:if>
				</c:forEach>
	
				<c:if test="${pager.groupNo<pager.totalGroupNo}">
					<a href="faq?pageNo=${pager.endPageNo+1}"
						class="btn btn-outline-dark btn-sm">다음</a>
				</c:if>
	
				<a href="faq?pageNo=${pager.totalPageNo}"
					class="btn btn-outline-dark btn-sm">마지막</a>
			</div>
		</div>
	
</section>
</main>
<button onclick="backToTop()" id="btn-back-to-top">Top</button>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>