<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
	
<script src="${pageContext.request.contextPath}/resources/js/info.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/info.css">

<script>
    const contextPath = "${pageContext.request.contextPath}";
</script>


<main class="container d-flex mypage">
<div class="mypage-category">
	<div class="profile d-flex">
		<i class="bi bi-person-fill"></i>
		<div class="profile-detail">
			<p>환영합니다.</p>
			<p class="member-name">${user.userName}님</p>
		</div>
	</div>
	<div class="category-box d-flex flex-column">
		<h3>나의 수라밀</h3>
		<p 
			onclick="location.href='${pageContext.request.contextPath}/mypage/pick'">찜한
			상품</p>
		<p
			onclick="location.href='${pageContext.request.contextPath}/mypage/order'">주문
			내역</p>
		<p
			onclick="location.href='${pageContext.request.contextPath}/mypage/review'">상품
			후기</p>
		<p  style="color: rgb(107, 6, 9); font-weight: bold;"
			onclick="location.href='${pageContext.request.contextPath}/mypage/modifyForm'">개인정보
			수정</p>
	</div>
</div>
<div class="mypage-box flex-grow-1">
	<div class="title-box">
		<p>개인정보 수정</p>
		<div class="horizontal-line"></div>
	</div>

<input type="hidden" name="userId" value="${user.userId}"/>
<input type="hidden" name="userRole" value="${user.userRole}"/>
<input type="hidden" name="userEnable" value="${user.userEnable}"/>

	<div class="page-upload">
		<div class="form-container">
			<form id="modifyForm" action="${pageContext.request.contextPath}/mypage/update" method="POST">
				<div class="form-group">
					<label for="userid">아이디</label> <input type="text" id="userid"
						name="userId" value="${user.userId}" readonly>
				</div>

				<div class="form-group">
					<label for="current-password">비밀번호</label> <input type="password"
						id="current-password" placeholder="비밀번호를 입력하세요">
				</div>

				<div class="form-group">
					<label for="new-password">새 비밀번호</label> <input type="password"
						id="new-password"  name="userPw" placeholder="새 비밀번호를 입력하세요.">
				</div>

				<div class="form-group">
					<label for="confirm-password">새 비밀번호 확인</label> <input
						type="password" id="confirm-password"
						placeholder="새 비밀번호를 다시 입력하세요.">
				</div>

				<div class="form-group">
					<label for="name">이름</label> <input type="text" id="name" name="userName"
						value="${user.userName}">
				</div>

				<div class="form-group">
					<label for="email">이메일</label> <input type="email" id="email" name="userEmail"
						value="${user.userEmail}">
				</div>

				<div class="form-group">
					<label for="phone">전화번호</label>
					<div class="phone-group">
						<input type="tel" id="phone" name="userPhone" value="${user.userPhone}">
						<button class="phone-button">인증번호</button>
					</div>
				</div>

				<div class="form-group">
					<label for="address">주소</label>
					<div class="address-group">
						<input type="tel" id="address" name="userAddress" value="${user.userAddress}">
						<button class="address-button">주소 검색</button>
					</div>
				</div>

				<div class="form-group">
					<label for="birthday">생년월일</label> <input type="date" id="birthday"
						name="userBirth" value="<fmt:formatDate value="${user.userBirth}" pattern="yyyy-MM-dd" />" min="1900-01-01"
						max="2024-12-31">
				</div>

				<div class="buttons">
						<button type="button" class="delete-button" onclick="deactivate()">탈퇴하기</button>
						<script type="text/javascript">
							function deactivate() {
								document.location.href = "deactivate";
							}
						</script>
						<button type="submit" class="save-button" name="update">회원 정보 수정</button>							
				</div>
			</form>

		</div>
	</div>
</div>
</main>


<%@ include file="/WEB-INF/views/common/footer.jsp"%>


