<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/support.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/goodsMgmt.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/goods.css">

<main class="container d-flex admin">
	<div class="admin-category">
		<div class="category-box d-flex flex-column">
			<h3>관리자 메뉴</h3>
			<p onclick="location.href='${pageContext.request.contextPath}/mgmt/registedList'">상품 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/qna/qnaList'"
				 style="color: rgb(107, 6, 9); font-weight: bold;">QnA 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/notice/noticeList'">공지사항 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/faq/faqList'">FAQ 관리</p>
		</div>
	</div>
	<div class="admin-box flex-grow-1">
		<div class="title-box">
			<div class="addButton">
				<p>QnA 관리</p>
				<button data-flag="goods" onclick="location.href='${pageContext.request.contextPath}/mgmt/gReg'">작성하기</button>
			</div>
			<div class="horizontal-line"></div>
        </div>
		<div class="page-upload">
			<div class="board-top d-flex align-items-center">
	          <p id="just-title">제목</p>
	          <p class="flex-grow-1">작성일</p>
	          <p class="flex-grow-1">답변상태</p>
	      	</div>
	      	<div class="accordion-item">
              <h2 class="accordion-header">
                  <button class="board d-flex align-item-center accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${i}" aria-expanded="false" aria-controls="collapse${i}">
                      <p class="post-title">${qnaData[i].title}</p>
                      <p class="flex-grow-1 text-center">${qnaData[i].date}</p>
                      <p id="post-status${i}" class="flex-grow-1 text-center">${qnaData[i].status}</p>
                  </button>
              </h2>
              <div id="collapse${i}" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                  <div id="content${i}" class="accordion-body">
                      ${qnaData[i].content}
                      <div class="form-button-container"><span class="btn btn-md form-button" data-num="${i}">답변하기</span></div>
                  </div>
              </div>
          </div>
          </div>
	</div>
</main>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>