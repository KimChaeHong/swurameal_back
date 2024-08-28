<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link
	href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.bundle.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>




</head>
<body>
	<form method="get" action="search">
		<div class="mb-3">
			<label for="bno" class="form-label">검색 할 상품</label> 
			<input type="text" class="form-control" id="sword" name="검색어" >
		</div>
		<input type="submit" value="검색" class="btn-info btn-sm">
	
	</form>

</body>
</html>