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
            <div id="logo" class="navbar-brand mx-auto" onclick="location.href='/index.html'">
                swuraMeal
            </div>

            <!-- 로그인 정보 -->
            <div class="row align-items-start">
                <!-- 로그인 전 -->
                <div id="logged-out-links" class="col">
                    <a class="nav-link" href="/html/signup.html" id="signup-link">회원가입</a>
                    &nbsp;|&nbsp;
                    <a class="nav-link" href="/html/login.html" id="login-link">로그인</a>
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

<nav id="nav-container" class="navbar">
<div id="nav">
    <div id="bnav" class="row justify-content-center align-items-center">
        <!-- 드롭다운 메뉴가 포함된 버튼 및 카테고리 링크 -->
        <div id="ham" class="col-auto d-flex align-items-center">
            <div class="dropdown">
                <button class="navbar-toggler" type="button" id="dropdownToggleButton" data-bs-toggle="dropdown"
                    aria-expanded="false">
                    <span class="navbar-toggler-icon"></span>
                    <span id="category">카테고리</span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownToggleButton">
                    <li class="dropdown-item" onclick="loadAllGoods()">전체보기</li>
                    <li class="dropdown-item" onclick="loadGoodsByCategory('분식')">분식</li>
                    <li class="dropdown-item" onclick="loadGoodsByCategory('한식')">한식</li>
                    <li class="dropdown-item" onclick="loadGoodsByCategory('양식')">양식</li>
                    <li class="dropdown-item" onclick="loadGoodsByCategory('전통주')">전통주</li>
                </ul>
            </div>
        </div>

        <!-- 검색바 -->
        <div id="search" class="col-auto">
            <div class="search-container d-flex align-items-center">
                <input id="search-bar" type="search" placeholder="검색어를 입력해주세요" aria-label="Search">
                <button class="search-button" type="submit"><i class="bi bi-search"></i></button>
            </div>
        </div>

        <!-- 오른쪽 아이콘들 -->
        <div id="icon" class="col-auto d-flex justify-content-end">
            <a class="nav-link" href="/html/myPage.html"><i class="bi bi-heart"></i></a>
            <a class="nav-link" href="/html/cart.html"><i class="bi bi-cart"></i></a>
        </div>
    </div>
</div>
</nav>

<div id="carousel-container">
<div id="carousel" class="carousel slide">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="${pageContext.request.contextPath}/resources/images/slide1.jpg" class="d-block w-100" alt="Slide 1">
            <div class="carousel-caption d-none d-md-block">
            </div>
        </div>
        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/resources/images/slide2.jpg" class="d-block w-100" alt="Slide 2">
            <div class="carousel-caption d-none d-md-block">
            </div>
        </div>
        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/resources/images/slide3.jpg" class="d-block w-100" alt="Slide 3">
            <div class="carousel-caption d-none d-md-block">
            </div>
        </div>
    </div>
    <button class="carousel-control-prev cp" type="button" data-bs-target="#carousel" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next cn" type="button" data-bs-target="#carousel" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
</div>


<div>
	<p>상품들</p>
</div>

<div class="footer-container">
<footer class="infomation">
    <div class="cs-info">
        <div class="cs-call-info">
            <p class="customer-happy">고객행복센터</p>
            <strong id="call-number">1644-4578
                <span id="cs-time">월~토요일 오전7시 - 오후6시</span>
            </strong>
            <div class="cs-detetail-info" id="cs">
                <div class="cs-section" id="kakao-cs">
                    <button class="cs-section-button">카카오톡 문의</button>
                    <div>
                        월~토요일 | 오전 7시 - 오후 6시
                        <br>
                        일/공휴일 | 오전 7시 - 오후 1시
                    </div>
                </div>
                <div class="cs-section" id="support-cs">
                    <button class="cs-section-button">1:1 문의</button>
                    <div>
                        365일
                        <br>
                        고객센터 운영시간에 순차적으로 답변 드리겠습니다.
                    </div>
                </div>
                <div class="cs-section" id="bulk-cs">
                    <button class="cs-section-button">대량주문 문의</button>
                    <div>
                        월~금요일 | 오전 9시 - 오후 6시
                        <br>
                        점심시간 | 낮 12시 - 오후 1시
                    </div>
                </div>
            </div>
        </div>
        <div class="cs-detetail-info">
            <ul class="corp-intro">
                <li class="info"><a href="user-terms/intoduce.html" class="info-link">수라소개</a></li>
                <li class="info"><a href="/html/ir-swura.html" class="info-link">투자정보</a></li>
                <li class="info"><a href="/html/career.html" class="info-link">인재채용</a></li>
                <li class="info"><a href="user-terms/agreement.html" class="info-link">이용약관</a></li>
                <li class="info"><a href="user-terms/privacy-policy.html" class="info-link">개인정보처리방침</a></li>
                <li class="info"><a href="user-terms/user-guide.html" class="info-link">이용안내</a></li>
            </ul>
            <div class="corp-location" id="location">
                <div>
                    법인명 (상호) : 주식회사 컬리 | 사업자등록번호 : 261-81-23567 <a href="#" class="swura-info">사업자정보 확인</a>
                    <br>
                    통신판매업 : 제 2018-서울강남-01646 호
                    <br>
                    주소 : 서울 구로구 디지털로26길 123, 1605 ~1606호 | 대표이사 : 나길주
                    <br>
                    채용문의 : <a href="mailto:recruit@swuracorp.com" class="swura-info">recruit@swuracorp.com</a>
                    <br>
                    팩스: 070 - 7500 - 4578
                </div>
            </div>
            <ul class="sns-link" id="sns-link">
                <a href="#" class="sns"><img src="${pageContext.request.contextPath}/resources/images/ico_instagram.png" alt="수라밀 인스타그램 바로가기"></a>
                <a href="#" class="sns"><img src="${pageContext.request.contextPath}/resources/images/ico_fb.png" alt="수라밀 페이스북 바로가기"></a>
                <a href="#" class="sns"><img src="${pageContext.request.contextPath}/resources/images/ico_blog.png" alt="수라밀 네이버블로그 바로가기"></a>
                <a href="#" class="sns"><img src="${pageContext.request.contextPath}/resources/images/ico_naverpost.png" alt="수라밀 네이버포스트 바로가기"></a>
                <a href="#" class="sns"><img src="${pageContext.request.contextPath}/resources/images/ico_youtube.png" alt="수라밀 유튜브 바로가기"></a>
            </ul>
        </div>
    </div>
</footer>

<div id="sura-corp">
    수라밀에서 판매되는 상품 중에는 수라밀에 입점한 개별 판매자가 판매하는 마켓플레이스(오픈마켓) 상품이 포함되어 있습니다.
    <br>
    마켓플레이스(오픈마켓) 상품의 경우 수라밀은 통신판매중개자로서 통신판매의 당사자가 아닙니다. 수라밀은 해당 상품의 주문, 품질, 교환/환불 등 의무와 책임을 부담하지 않습니다.
    <em id="corp">© SWURA CORP . ALL RIGHTS RESERVED</em>
</div>
</div>
</body>
</html>
