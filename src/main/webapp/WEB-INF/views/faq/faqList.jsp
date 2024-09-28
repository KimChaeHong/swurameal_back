<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/goods.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/support.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice.css"> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminFaq.css">

<main class="container d-flex admin">
<div class="admin-category">
		<div class="category-box d-flex flex-column">
			<h3>관리자 메뉴</h3>
			<p onclick="location.href='${pageContext.request.contextPath}/mgmt/registedList'" style="color: rgb(117, 117, 117); font-weight: normal;">상품 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/qna/qnaList'" style="color: rgb(117, 117, 117); font-weight: normal;">QnA 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/notice/noticeList'" style="color: rgb(117, 117, 117); font-weight: normal;">공지사항 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/faq/faqList'" style="color: rgb(107, 6, 9); font-weight: bold;">FAQ 관리</p>
		</div>
	</div>

	<div class="admin-box flex-grow-1">
	<div class="title-box">
        <div class="addButton">
            <p>FAQ 관리</p>
            	<button data-flag="faq" onclick="location.href='${pageContext.request.contextPath}/faq/faqRegister'">
						작성하기
					</button>
        </div>
        <div class="horizontal-line"></div>
        </div>
        <div class="page-upload"><div class="board-top d-flex align-items-center">
          <p class="flex-grow-1">번호</p>
			<p id="just-title">제목</p>
			<p class="flex-grow-1">작성자</p>
      </div>
      
      <c:forEach var="faq" items="${list}">
      	<div class="accordion-item">
              <h2 class="accordion-header">
                  <button class="board d-flex align-item-center accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${faq.faqId}" aria-expanded="true" aria-controls="collapse${faq.faqId}">
                      <p class="post-title">${faq.faqId}</p>
                      <p class="content flex-grow-1">${faq.faqTitle}</p>
                      <p id="post-status${faq.faqId}" class="rigister flex-grow-1 text-center">${faq.userId}</p>
                  </button>
              </h2>
              <div id="collapse${faq.faqId}" class="accordion-collapse collapse" data-bs-parent="#accordionExample" style="">
                  <div id="content${faq.faqId}" class="accordion-body">
                      ${faq.faqContent}
                      
                     <div class="form-button-container"><span class="btn btn-md form-button" data-num="${faq.faqId}"></span></div>
                   
	                   <div class="update-button d-flex flex-grow-1 justify-content-end">
				            <a href="${pageContext.request.contextPath}/faq/faqUpdateForm?faqId=${faq.faqId}">
				            	<button>수정</button> 
				            </a>
				            <span>|</span>
				            <a href="${pageContext.request.contextPath}/faq/faqDelete?faqId=${faq.faqId}">
				            	<button>삭제</button>            
				            </a>
				        </div>   
                 
                  </div>
              </div>
          </div>
        </c:forEach>  
       </div> 
         <!--  <div class="d-flex justify-content-center"> -->
			
                     	
			<div class="pagination">
				<a href="faqList?pageNo=1" class="btn btn-outline-dark btn-sm">처음</a>
	
				<c:if test="${pager.groupNo>1}">
					<a href="faqList?pageNo=${pager.startPageNo-1}"
						class="btn btn-outline-dark btn-sm">이전</a>
				</c:if>
	
				<c:forEach begin="${pager.startPageNo}" end="${pager.endPageNo}"
					step="1" var="i">
					<c:if test="${pager.pageNo==i}">
							<button class="page-num active" onclick="location.href='${pageContext.request.contextPath}/faq/faqList?pageNo=${i}'">
								${i}
							</button>						
					</c:if>
					<c:if test="${pager.pageNo!=i}">
							<button class="page-num" onclick="location.href='${pageContext.request.contextPath}/faq/faqList?pageNo=${i}'">
								${i}
							</button>
					</c:if>
				</c:forEach>
	
				<c:if test="${pager.groupNo<pager.totalGroupNo}">
					<a href="faqList?pageNo=${pager.endPageNo+1}"
						class="btn btn-outline-dark btn-sm">다음</a>
				</c:if>
	
				<a href="faqList?pageNo=${pager.totalPageNo}"
					class="btn btn-outline-dark btn-sm">마지막</a>
			</div>
		</div>
	<!-- </div> -->	
</main>

<button onclick="backToTop()" id="btn-back-to-top">Top</button>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>