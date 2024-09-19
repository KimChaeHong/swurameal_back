<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/find.css">

<main class="container find">
	<h2 id="find-title">아이디 찾기</h2>
	
	<div id="find-btn-div">
		<button id="find-phone-btn" onclick="certPhoneMail('phone')">휴대폰 인증</button>
		<button id="find-email-btn" onclick="certPhoneMail('email')">이메일 인증</button>
	</div>
	
	<form id="find-form" action="#">
		<div id="find-name-id">
			<label for="userName">이름</label>
			<input type="text" id="userName" placeholder="이름을 입력해 주세요.">
		</div>
		
		<div id="find-phone-email">
			<label for="userPhone">휴대폰 번호</label>
			<input type="tel" id="userPhone" placeholder="휴대폰 번호를 입력해 주세요.">
		</div>
		
		<button id="certify-btn" onclick="return false">인증번호 받기</button>
	</form>
</main>	

<%@ include file="/WEB-INF/views/common/footer.jsp"%>