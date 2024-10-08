<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

<body>
	<main class="container login">
		<h2>로그인</h2>
		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != NULL}">
			<%-- <c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message ==  'Bad username'}">
    			아이디가 틀립니다.
    		</c:if> --%>
    		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message == 'Bad credentials'}">
    			<div class="alert alert-danger mb-2" role=alert>
    				아이디 또는 비밀번호가 틀립니다.
    			</div>
    		</c:if>
	    </c:if>
		<form method="post" action="${pageContext.request.contextPath}/login">
			<input id="id" name="user_id" type="text" placeholder="아이디를 입력해 주세요." >
			<br>
			<input id="pw" name="user_pw" type="password" placeholder="비밀번호를 입력해 주세요.">
			<br>
			<button type="submit" class="login-btn">로그인</button>
		</form>
		<form action="${pageContext.request.contextPath}/user/signup" method="GET">
    		<button class="signup-btn" type="submit">회원가입</button>
		</form>
	</main>
</body>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
