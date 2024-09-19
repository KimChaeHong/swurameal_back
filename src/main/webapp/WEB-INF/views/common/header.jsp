<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>swuraMeal</title>

	<!-- 파비콘 설정 -->
    <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/resources/favicon/apple-touch-icon.png" />
    <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/favicon/favicon-32x32.png" />
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources//favicon/favicon-16x16.png" />
    <link rel="manifest" href="${pageContext.request.contextPath}/resources/favicon/site.webmanifest" />
    
    <!-- 공통 css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

    <!-- Bootstrap and Icons -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet" />

    <!-- Custom CSS Files -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/carousel.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/nav.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/search.css" />

    <!-- 로고 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Pinyon+Script&display=swap" rel="stylesheet" />

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" defer></script>
    <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js" defer></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.js" defer></script>

</head>

<body>

<div id="header-container" class="navbar">
		<div class="container justify-content-center">
            <!-- 로고 -->
            <div id="logo" class="navbar-brand mx-auto" onclick="location.href='${pageContext.request.contextPath}'">
                swuraMeal
            </div> 

            <!-- 로그인 정보 -->
            <div class="row align-items-start">
                <!-- 로그인 전 -->
                <div id="logged-out-links" class="col">
                    <a class="nav-link" href="${pageContext.request.contextPath}/user/signup" id="signup-link">회원가입</a>
                    &nbsp;|&nbsp;
                    <a class="nav-link" href="${pageContext.request.contextPath}/user/login" id="login-link">로그인</a>
                </div>

                <!-- 로그인 후 -->
                <div id="logged-in-links" class="col" style="display: none">
                    <a class="nav-link" href="#" id="logout-link">로그아웃</a>
                    &nbsp;|&nbsp;
                    <a class="nav-link admin-hide" href="/html/myPage.html" id="mypage-link">마이페이지</a>
                    <a class="nav-link" href="/html/admin.html" id="admin-link">관리자페이지</a>
                    &nbsp;<span class="admin-hide">|</span>&nbsp;
                    <a class="nav-link admin-hide" href="/html/support.html">고객센터</a>
                </div>
            </div>
        </div>
</div>