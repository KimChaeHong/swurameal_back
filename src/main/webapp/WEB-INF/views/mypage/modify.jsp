<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<%@ include file="/WEB-INF/views/common/carousel.jsp"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/info.css">


<main class="container d-flex mypage">
	<div class="mypage-category">
		<div class="profile d-flex">
			<i class="bi bi-person-fill"></i>
			<div class="profile-detail">
				<p>환영합니다.</p>
				<p class="member-name">수라밀 님</p>
			</div>
		</div>
	
		<div class="category-box d-flex flex-column">
			<h3>나의 수라밀</h3>
			<p
				onclick="location.href='${pageContext.request.contextPath}/mypage/pick'"
				style="color: rgb(117, 117, 117); font-weight: normal;">찜한 상품</p>
			<p
				onclick="location.href='${pageContext.request.contextPath}/mypage/order'"
				style="color: rgb(117, 117, 117); font-weight: normal;">주문 내역</p>
			<p
				onclick="location.href='${pageContext.request.contextPath}/mypage/review'"
				style="color: rgb(117, 117, 117); font-weight: normal;">상품 후기</p>
			<p
				onclick="location.href='${pageContext.request.contextPath}/mypage/info'"
				style="color: rgb(117, 117, 117); font-weight: normal;">개인정보 수정</p>
		</div>
	</div>
	
	<div class="mypage-box flex-grow-1">
		<div class="title-box">
			<p>개인정보 수정</p>
			<div class="horizontal-line"></div>
		</div>
	
		<div class="page-upload">
			<div class="form-container">
				<form action="your-server-endpoint" method="POST">
					<div class="form-group">
						<label for="userid">아이디</label> <input type="text" id="userid"
							name="userid" value="swura4789" readonly>
					</div>
	
					<div class="form-group">
						<label for="current-password">비밀번호</label> <input type="password"
							id="current-password" placeholder="비밀번호를 입력하세요">
					</div>
	
					<div class="form-group">
						<label for="new-password">새 비밀번호</label> <input type="password"
							id="new-password" placeholder="새 비밀번호를 입력하세요.">
					</div>
	
					<div class="form-group">
						<label for="confirm-password">새 비밀번호 확인</label> <input
							type="password" id="confirm-password"
							placeholder="새 비밀번호를 다시 입력하세요.">
					</div>
	
					<div class="form-group">
						<label for="name">이름</label> <input type="text" id="name"
							value="수라밀">
					</div>
	
					<div class="form-group">
						<label for="email">이메일</label> <input type="email" id="email"
							value="test@text.com">
					</div>
	
					<div class="form-group">
						<label for="phone">전화번호</label>
						<div class="phone-group">
							<input type="tel" id="phone" value="010-0000-0000">
							<button class="phone-button">인증번호</button>
						</div>
					</div>
	
					<div class="form-group">
						<label for="address">주소</label>
						<div class="address-group">
							<input type="tel" id="address" name="address" value="서울특별시 테스트동">
							<button class="address-button">주소 검색</button>
						</div>
					</div>
	
					<div class="form-group">
						<label for="birthday">생년월일</label> <input type="date" id="birthday"
							name="birthday" value="2024-08-11" min="1900-01-01"
							max="2024-12-31">
					</div>
	
					<div class="buttons">
						<button class="delete-button">탈퇴하기</button>
						<button class="save-button">회원 정보 수정</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</main>







<!-- <script>
			function modifyAjax(){
				var param1 = $("#param1").val();
				var param2 = $("#param2").val();
				var param3 = $("#param3").val();
				var param4 = $("#param4").val();
				var param5 = $("#param5").val();
				var param6 = $("#param6").val();
				var param7 = $("#param7").val();
			
				const params = {param1, param2, param3, param4, param5,  param6,  param7};
				console.log(params);
				
				$.ajax({
					url:"modifyAjax",
					type:"post",
					data : params,
					success:function(data){
						console.log(data);
					}
				});

			}
		</script> -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
