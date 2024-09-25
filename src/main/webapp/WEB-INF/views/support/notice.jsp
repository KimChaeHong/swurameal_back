<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>    
<%@ include file="/WEB-INF/views/common/nav.jsp" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/support.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice.css">

   <main class="d-flex container support-container">

       <section id="leftSide">
           <div id="side-category">
               <h3 class="h3">고객센터</h3>
               <h5 class="active h5" onclick="location.href='${pageContext.request.contextPath}/support/notice'">공지사항</h5>
               <h5 class="h5" onclick="location.href='${pageContext.request.contextPath}/support/faq'">자주묻는질문</h5>
               <h5 class="h5" onclick="location.href='${pageContext.request.contextPath}/support/qna'">문의</h5>
           </div>
       </section>

       <section id="mainContent">
            <h3 class="h3" id="title">공지사항</h3>
	        <div id="board-container">
		        <div class="notice-box d-flex flex-column">
		            <div class="notice-header d-flex">
		                <div>제목</div>
		                <div>작성자</div>
		                <div>등록일</div>
		            </div>
		            <c:forEach items="${list}" var="notice">
			            <div class="notice-list">
				            <div class="notice-info d-flex align-items-center">
				                <div>${notice.noticeTitle}</div>
				                <div>${notice.userId}</div>
				                <div><fmt:formatDate value="${notice.noticeRegisterDate}" pattern="yyyy-MM-dd"/></div>
				            </div>
						</div>	            
		            </c:forEach>
		        </div>
	        </div>
	        <div class="pagination">
					<a href="notice?pageNo=1" class="btn btn-outline-dark btn-sm d-flex justify-content-center align-items-center">처음</a>
		
					<c:if test="${pager.groupNo>1}">
						<a href="notice?pageNo=${pager.startPageNo-1}"
							class="btn btn-outline-dark btn-sm">이전</a>
					</c:if>
		
					<c:forEach begin="${pager.startPageNo}" end="${pager.endPageNo}"
						step="1" var="i">
						<c:if test="${pager.pageNo==i}">
								<button class="page-num active" onclick="location.href='${pageContext.request.contextPath}/support/notice?pageNo=${i}'">
									${i}
								</button>						
						</c:if>
						<c:if test="${pager.pageNo!=i}">
								<button class="page-num" onclick="location.href='${pageContext.request.contextPath}/support/notice?pageNo=${i}'">
									${i}
								</button>
						</c:if>
					</c:forEach>
		
					<c:if test="${pager.groupNo<pager.totalGroupNo}">
						<a href="notice?pageNo=${pager.endPageNo+1}"
							class="btn btn-outline-dark btn-sm">다음</a>
					</c:if>
		
					<a href="notice?pageNo=${pager.totalPageNo}"
						class="btn btn-outline-dark btn-sm text-nowrap d-flex justify-content-center align-items-center">마지막</a>
				</div>
        </section>

   </main>

   <button onclick="backToTop()" id="btn-back-to-top">Top</button>
   
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	