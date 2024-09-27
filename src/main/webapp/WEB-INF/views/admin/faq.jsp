<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/support.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/goods.css">

<main class="container d-flex admin">
<div class="admin-category">
		<div class="category-box d-flex flex-column">
			<h3>관리자 메뉴</h3>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/goodsManagement'" style="color: rgb(117, 117, 117); font-weight: normal;">상품 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/answer'" style="color: rgb(117, 117, 117); font-weight: normal;">1:1 문의 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/notice'" style="color: rgb(117, 117, 117); font-weight: normal;">공지사항 관리</p>
			<p onclick="location.href='${pageContext.request.contextPath}/admin/faq'" style="color: rgb(107, 6, 9); font-weight: bold;">FAQ 관리</p>
		</div>
	</div>

	<div class="admin-box flex-grow-1">
	<div class="title-box">
        <div class="addButton">
            <p>FAQ 관리</p>
            	<button data-flag="faq" onclick="location.href='${pageContext.request.contextPath}/admin/faqWrite'">
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
                  <button class="board d-flex align-item-center accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse0" aria-expanded="true" aria-controls="collapse0">
                      <p class="post-title">${faq.faqId}</p>
                      <p class="flex-grow-1 text-center">${faq.faqTitle}</p>
                      <p id="post-status0" class="flex-grow-1 text-center">${faq.userId}</p>
                  </button>
              </h2>
              <div id="collapse0" class="accordion-collapse collapse" data-bs-parent="#accordionExample" style="">
                  <div id="content0" class="accordion-body">
                      ${faq.faqContent}
                      <div class="form-button-container"><span class="btn btn-md form-button" data-num="0">${faq.userId}</span></div>
                  </div>
              </div>
          </div>
        </c:forEach>  
          
             <div class="pagination"><button class="page-num active">1</button><button class="page-num">2</button></div></div></div>
</main>


<%@ include file="/WEB-INF/views/common/footer.jsp"%>