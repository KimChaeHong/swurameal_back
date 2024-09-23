<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                    <li class="dropdown-item" onclick="location.href='${pageContext.request.contextPath}/category/all'">
                    	전체보기
                    </li>
                    <li class="dropdown-item" onclick="location.href='${pageContext.request.contextPath}/category/snacks'">분식</li>
                    <li class="dropdown-item" onclick="location.href='${pageContext.request.contextPath}/category/korean'">한식</li>
                    <li class="dropdown-item" onclick="location.href='${pageContext.request.contextPath}/category/western'">양식</li>
                    <li class="dropdown-item" onclick="location.href='${pageContext.request.contextPath}/category/tradDrink'">전통주</li>
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
            <a class="nav-link" href="${pageContext.request.contextPath}/mypage/pick"><i class="bi bi-heart"></i></a>
            <a class="nav-link" href="#" onclick="location.href='${pageContext.request.contextPath}/cart'"><i class="bi bi-cart"></i></a>
        </div>
    </div>
</div>
</nav>