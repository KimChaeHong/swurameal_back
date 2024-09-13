<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/signup.css">

<main class="container signup">
	<h2>회원가입</h2>
	<p>
	<span class="rq">*</span>
	필수입력사항
	</p>
	
	<div id="signup-form">
		<div>
			<label for="user-id">
			아이디
				<span class="rq">*</span>
			</label>
			<input type="text" id="user-id"
				placeholder="아이디를 입력해 주세요."
				required>
			<button>중복확인</button>	
		</div>

		<div>
			<label for="user-pw">
			비밀번호
				<span class="rq">*</span>
			</label>
			<input type="password" id="user-pw"
				placeholder="비밀번호를 입력해 주세요."
				required>
		</div>

		<div>
			<label for="user-pw2">
			비밀번호확인
				<span class="rq">*</span>
			</label>	
			<input type="password" id="user-pw2"
				placeholder="비밀번호를 한번 더 입력해 주세요."
				required>
		</div>

		<div>
			<label for="user-name">
			이름
				<span class="rq">*</span>
			</label>
			<input type="text" id="user-name"
				placeholder="이름을 입력해 주세요."
				required>
		</div>

		<div>
			<label for="user-email">
			이메일
				<span class="rq">*</span>
			</label>
			<input type="email" id="user-email"
				placeholder="예: swura@meal.com"
				required>
			<button>중복확인</button>	
		</div>

		<div>
			<label for="user-phone">
			휴대폰
				<span class="rq">*</span>
			</label>
			<input type="tel" id="user-phone"
				placeholder="숫자만 입력해 주세요."
				required>
			<button class="check-btn">인증번호 받기</button>	
		</div>

		<div>
			<label>
			주소
				<span class="rq">*</span>
			</label>
			<input type="text" id="user-address"
				placeholder="주소">
			<button onclick="searchAddress()">주소 검색</button>
			<p class="desc">배송지에 따라 상품 정보가 달라질 수 있습니다.</p>	
		</div>

		<div>
			<label>생년월일</label>
			<div id="birth">
			<input id="year" type="text" placeholder="YYYY">
			<span>/</span>
			<input id="mm" type="text" placeholder="MM">
			<span>/</span>
			<input id="dd" type="text" placeholder="DD">
			</div>	
		</div>
		
		<button id="signup-btn">가입하기</button>	
	</div>

</main>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>