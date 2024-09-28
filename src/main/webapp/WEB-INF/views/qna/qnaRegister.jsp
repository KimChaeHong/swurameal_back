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
		 	<div class="board-list">
				<div class="d-flex mt-3 ps-4 q-title-box">
		            <p style="width: 80px">제목<span>*</span></p>
		        	<input type="text" name="questionTitle" class="q-form-title" placeholder="제목을 입력하세요">
		        </div>
		        <div class="d-flex mt-3 ps-4 q-content-box">
		            <p style="width: 80px">내용<span>*</span></p>
		            <textarea name="questionContent" class="q-form-content" placeholder="내용을 입력하세요"></textarea>
		        </div>
		 	</div>
			<div class="d-flex justify-content-center">
			    <div class="pagination">
				
			    </div>
		    </div>
		    <div id="cmp-container" class="d-flex justify-content-center">
		    	<button type="submit" class="btn cmp-button ajax-btn" >등록</button>
		    </div>
	</div>
	
</section>
</main>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>