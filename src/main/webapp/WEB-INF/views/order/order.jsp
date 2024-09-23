<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pay.css">

<!-- 주문결제 페이지 메인 -->
    <main class="container pay">
      <h2>주문 / 결제</h2>
      <div class="d-flex justify-content-between">
        <div class="left-section">
          <!-- 주문상품 -->
          <div id="pay-items">
            <div class="title">주문상품</div>
          </div>

          <!-- 주문자 정보 -->
          <div id="user-info">
            <div class="title">주문자 정보</div>
            <span class="label">주문자명</span>
            <span>정원석</span><br />
            <span class="label">휴대폰 번호</span>
            <span>010-1234-5678</span><br />
            <span class="label">이메일</span>
            <span>swura@meal.com</span><br />
            <span class="label">배송지</span>
            <input id="user-address" value="서울 구로구 디지털로26길 123, 1605호"></input>
            <button onclick="searchAddress()">배송지 변경</button>
          </div>

          <!-- 개인정보 및 결제 동의 -->
          <div id="pay-agree">
            <div class="title d-flex justify-content-between">
                <p>개인정보 및 결제 동의</p>
                <i class="bi bi-square" id="allBtn"></i>
            </div>
            <div class="d-flex justify-content-between">
                <span>개인정보 수집 이용 및 처리 동의</span>
                <i class="bi bi-square"></i>
            </div>
            <div class="d-flex justify-content-between">
                <span>전자지급 결제대행 서비스 이용약관 동의</span>
                <i class="bi bi-square"></i>
            </div>
            <div class="d-flex justify-content-between agree">
                <p>위 내용을 확인 하였으며 결제에 동의합니다.</p>
                <i class="bi bi-square"></i>
            </div>
          </div>
        </div>

        <!-- 주문내역서 -->
        <div id="pay-pay">
          <div id="how-much">
            <p>주문/결제 내역</p>
            <div class="d-flex justify-content-between">
              <span>상품금액</span>
              <span>23,700원</span>
            </div>
            <div class="d-flex justify-content-between">
              <span>배송비</span>
              <span>3,000원</span>
            </div>
            <div class="d-flex justify-content-between total">
              <span>최종결제금액</span>
              <span>26,700원</span>
            </div>
          </div>
          <button id="payBtn">결제하기</button>
        </div>
      </div>
    </main>
    <button onclick="backToTop()" id="btn-back-to-top">Top</button>
    
<%@ include file="/WEB-INF/views/common/footer.jsp"%>