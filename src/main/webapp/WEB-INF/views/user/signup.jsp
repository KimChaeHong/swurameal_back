<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/signup.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<script src="${pageContext.request.contextPath}/resources/js/signup2.js"></script>


<main class="container signup">
	<h2>회원가입</h2>
	<p>
	<span class="rq">*</span>
	필수입력사항
	</p>
	
	<form id="signup-form" method="post" action="join">
		<div>
		    <label for="user-id">아이디 <span class="rq">*</span></label>
		    <input type="text" 
		        id="userId" 	
		        name="userId" 
		        value="${userDto.userId}" 
		        placeholder="아이디를 입력해 주세요."
		        required>

		    <div class="text-danger" style="font-size: 0.7rem" id="errorMessage">${errorMessage}</div>
		</div>


 <div>
			<label for="user-pw">
			비밀번호
				<span class="rq">*</span>
			</label>
			<input type="password" 
				id="user-pw"
				name="userPw"
				placeholder="비밀번호를 입력해 주세요."
				required>
		</div>

		<div>
			<label for="user-pw2">
			비밀번호확인
				<span class="rq">*</span>
			</label>	
			<input type="password" 
				id="user-pw2"
				name="userPw2"
				placeholder="비밀번호를 한번 더 입력해 주세요."
				required>
		</div>

		<div>
			<label for="user-name">
			이름
				<span class="rq">*</span>
			</label>
			<input type="text" 
				id="user-name"
				name="userName"
				value="${userDto.userName}"
				placeholder="이름을 입력해 주세요."
				required>
		</div>

		<div>
			<label for="user-email">
			이메일
				<span class="rq">*</span>
			</label>
			<input type="email" 
				id="user-email"
				name="userEmail"
				value="${userDto.userEmail}"
				placeholder="예: swura@meal.com"
				required>
		
		</div>

		<div>
			<label for="user-phone">
			휴대폰
				<span class="rq">*</span>
			</label>
			<input type="tel" 
				id="user-phone"
				name="userPhone"
				value="${userDto.userPhone}"
				placeholder="숫자만 입력해 주세요."
				required>
			<!-- <button class="check-btn">인증번호 받기</button> -->	
		</div>

		<div>
			<label>
			주소
				<span class="rq">*</span>
			</label>
			<input type="text" 
				id="user-address"
				name="userAddress"
				value="${userDto.userAddress}"
				placeholder="주소"
				required>
			<button onclick="searchAddress()">주소 검색</button>
			<p class="desc">배송지에 따라 상품 정보가 달라질 수 있습니다.</p>	
		</div>

		<div>
		    <label for="birth">
		        생년월일
		        <span class="rq">*</span>
		    </label>
		    <div id="birth">
	            <input id="year" type="text" placeholder="YYYY" maxlength="4" required>
	            <span>/</span>
	            <input id="month" type="text" placeholder="MM" maxlength="2" required>
	            <span>/</span>
	            <input id="day" type="text" placeholder="DD" maxlength="2" required>
        	</div>
		</div>
		
		<input type="hidden" id="userBirth" name="userBirth"> <!-- 최종 값 저장 -->
		
		<button type="submit" id="signup-btn">가입하기</button>	
	</form>

</main>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>