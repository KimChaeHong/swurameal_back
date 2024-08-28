<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>




</head>
<body>
	<div class="card">
		<div class="card-header">modify</div>
		<div class="card-body">
			<div class="card">
	<div class="card-header">개인정보수정</div>
	<div class="card-body">
		<form method="post" action = >
			<div class="input-group">
				<span class="input-group-text">아이디</span> <input type="text"
					id = "param1" name="param1" class="form-control" value="coghd28">
			</div>
			<div class="input-group">
				<span class="input-group-text">비밀번호</span> <input type="text"
					id = "param2" name="param2" class="form-control" value="rhrnak9087">
			</div>
			<div class="input-group">
				<span class="input-group-text">이름</span> <input type="text"
					id = "param3" name="param3" class="form-control" value="김채홍">
			</div>
			<div class="input-group">
				<span class="input-group-text">이메일</span> <input type="text"
					id = "param4" name="param4" class="form-control" value="coghd28@naver.com">
			</div>
			<div class="input-group">
				<span class="input-group-text">휴대폰</span> <input type="text"
					id = "param5" name="param5" class="form-control" value="010-9164-1423">
			</div>
				<div class="input-group">
				<span class="input-group-text">배송지</span> <input type="text"
					id = "param6" name="param6" class="form-control" value="광나루로 545">
			</div>
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">생년월일</span>
				</div>
				<input type="date" id="param7" name="param7" class="form-control" 
					value="1997-07-28">
			</div>
			<button type="button" onclick="modifyAjax()" class="mt-2 btn btn-info btn-sm">수정하기</button>
		</form>
		<script>
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
		</script>
	
		</div>
	</div>

</body>
</html>