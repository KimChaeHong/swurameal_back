<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice-form.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice-detail.css">

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
            <div class="admin-box flex-grow-1"><div class="title-box">
        <div class="addButton">
            <p>공지사항 관리</p>
        </div>
        <div class="horizontal-line"></div>
        </div>
        <div class="page-upload">
        <div class="detail-box d-flex flex-column">
            <div class="detail-title d-flex align-items-center">
                <div>제목</div>
                <div class="flex-grow-1 ">${notice.noticeTitle}</div>
            </div>
            <div class="detail-author d-flex">
                <div>작성자</div>
                <div class="flex-grow-1">${notice.userId}</div>
            </div>
            <div class="detail-date d-flex">
                <div>등록일</div>
                <div class="flex-grow-1"><fmt:formatDate value="${notice.noticeRegisterDate}" pattern="yyyy-MM-dd" /></div>
            </div>
            <div class="detail-description">
            	${notice.noticeContent}
   			</div>
        
        <div class="update-button d-flex flex-grow-1 justify-content-end">
            <a href="notice/noticeUpdateForm?noticeId=${notice.noticeId}">
            	<button>수정</button> 
            </a>
            <span>|</span>
            <a href="notice/noticeDelete?noticeId=${notice.noticeId}">
            	<button>삭제</button>            
            </a>
        </div>
        </div>
        </div></div>
        </main>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
