<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/login.css">

<main class="container login">
	<h2>로그인</h2>
	<form action="#">
		<input id="id" type="text" placeholder="아이디를 입력해 주세요.">
		<br>
		<input id="pw" type="password" placeholder="비밀번호를 입력해 주세요.">
		<br>
		
		<div id="id-pw">
			<a href onclick="findIdPw('id'); return false;">아이디 찾기</a>
			<span> | </span>
			<a href onclick="findIdPw('pw'); return false;">비밀번호 찾기</a>
		</div>
		
		<ul class>
			<a href="#">
				<li id="kakao">
				<span>카카오계정으로 로그인</span>
				</li>
			</a>	
			<a href="#">
				<li id="naver">
					<i>N</i>
					<span>네이버계정으로 로그인</span>
				</li>	
			</a>
		</ul>
		
		<button class="login-btn" onclick="loginCheck(); return false;">로그인
		</button>
		<br>
		<button class="sign-btn" onclick="toSignup(); return false;">회원가입
		</button>
	</form>
</main>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
