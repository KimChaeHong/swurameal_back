<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/goods.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice.css">

<main class="container d-flex admin">
	<div class="admin-category">
		<div class="category-box d-flex flex-column">
			<h3>관리자 메뉴</h3>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/goodsManagement'" style="color: rgb(117, 117, 117); font-weight: normal;">상품 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/answer'" style="color: rgb(117, 117, 117); font-weight: normal;">1:1 문의 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/notice'" style="color: rgb(107, 6, 9); font-weight: bold;">공지사항 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/faq'" style="color: rgb(117, 117, 117); font-weight: normal;">FAQ 관리</p>
		</div>
	</div>
	
	<div class="admin-box flex-grow-1">
		<div class="title-box">
			<div class="addButton">
				<p>공지사항 관리</p>
					<button data-flag="notice">
						작성하기
					</button>
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
				<div class="notice-list">
					<c:forEach items="${list}" var="notice">
						<div class="notice-info d-flex align-items-center">
							<div>
								<a href="noticeDetail?noticeId=${notice.noticeId}">${notice.noticeTitle}</a>
							</div>
							<div>${notice.userId}</div>
							<div><fmt:formatDate value="${notice.noticeRegisterDate}" pattern="yyyy-MM-dd" /></div>
						</div>
					</c:forEach>
					</div>
				</div>
			</div>
		
				
			<div class="pagination">
				<a href="notice?pageNo=1" class="btn btn-outline-dark btn-sm">처음</a>
	
				<c:if test="${pager.groupNo>1}">
					<a href="notice?pageNo=${pager.startPageNo-1}"
						class="btn btn-outline-dark btn-sm">이전</a>
				</c:if>
	
				<c:forEach begin="${pager.startPageNo}" end="${pager.endPageNo}"
					step="1" var="i">
					<c:if test="${pager.pageNo==i}">
							<button class="page-num active" onclick="location.href='${pageContext.request.contextPath}/admin/notice?pageNo=${i}'">
								${i}
							</button>						
					</c:if>
					<c:if test="${pager.pageNo!=i}">
							<button class="page-num" onclick="location.href='${pageContext.request.contextPath}/admin/notice?pageNo=${i}'">
								${i}
							</button>
					</c:if>
				</c:forEach>
	
				<c:if test="${pager.groupNo<pager.totalGroupNo}">
					<a href="notice?pageNo=${pager.endPageNo+1}"
						class="btn btn-outline-dark btn-sm">다음</a>
				</c:if>
	
				<a href="notice?pageNo=${pager.totalPageNo}"
					class="btn btn-outline-dark btn-sm">마지막</a>
			</div>
		
			
	</div>
 
	
	
</main>

<button onclick="backToTop()" id="btn-back-to-top">Top</button>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
