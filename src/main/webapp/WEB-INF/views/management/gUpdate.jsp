<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/goods.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/goodsMgmt.css">
	
<script src="${pageContext.request.contextPath}/resources/js/gReg.js"></script>
<main class="container d-flex admin">
<div class="admin-category">
	<div class="category-box d-flex flex-column">
		<h3>관리자 메뉴</h3>
		<p onclick="location.href='${pageContext.request.contextPath}/mgmt/registedList'"
			 style="color: rgb(107, 6, 9); font-weight: bold;">상품 관리</p>
		<p onclick="location.href='${pageContext.request.contextPath}/qna/qnaList'">QnA 관리</p>
		<p onclick="location.href='${pageContext.request.contextPath}/notice/noticeList'">공지사항 관리</p>
		<p onclick="location.href='${pageContext.request.contextPath}/faq/faqList'">FAQ 관리</p>
	</div>
</div>
<div class="admin-box flex-grow-1">
	<div class="title-box">
		<div class="addButton">
			<p>상품 관리</p>
		</div>	
		<div class="horizontal-line"></div>
	</div>
	<div class="page-upload">
		<div class="form-container">
            <form method="post" action="updateGoods" enctype="multipart/form-data">
				<input type="hidden" name="goodsId" class="form-control" readonly value="${goods.goodsId}"/> 
                <div class="form-group">
				    <label for="goods-name">상품명<span class="rq">*</span></label>
				    <input type="text" id="goods-name" name="goodsName" value="${goods.goodsName}" required>
				</div>
				<div class="form-group">
				    <label>대표 이미지<span class="rq">*</span></label>
				    <input type="file" id="rep-img" name="mainAttach" style="display: none;" onchange="showFileName(this, 'rep-img-input')">
				    <div id="rep-img-input">선택된 파일이 없습니다.</div>
				    <button type="button" class="file-select" data-btn="rep-img" onclick="document.getElementById('rep-img').click()">파일 선택</button>
				</div>
				<div class="form-group">
				    <label>설명 이미지<span class="rq">*</span></label>
				    <input type="file" id="description-img" name="descAttach" style="display: none;" onchange="showFileName(this, 'description-img-input')">
				    <div id="description-img-input">선택된 파일이 없습니다.</div>
				    <button type="button" class="file-select" data-btn="description-img" onclick="document.getElementById('description-img').click()">파일 선택</button>
				</div>
				<div class="form-group">
				    <label>상세 이미지<span class="rq">*</span></label>
				    <input type="file" id="detail-img" name="detailAttach" style="display: none;" onchange="showFileName(this, 'detail-img-input')">
				    <div id="detail-img-input">선택된 파일이 없습니다.</div>
				    <button type="button" class="file-select" data-btn="detail-img" onclick="document.getElementById('detail-img').click()">파일 선택</button>
				</div>  
                <div class="form-group">
				    <label for="goods-category">카테고리<span class="rq">*</span></label>
				    <select id="goods-category" name="category" required>
				        <option value="${goods.category}"  selected>${goods.category}</option>
				        <option value="분식">분식</option>
				        <option value="양식">양식</option>
				        <option value="한식">한식</option>
				        <option value="전통주">전통주</option>
				    </select>
				</div>
				<div class="form-group">
				    <label for="goods-subcategory">서브 카테고리<span class="rq">*</span></label>
				    <select id="goods-subcategory" name="subcategory" required>
				        <option value="${goods.category}" selected>${goods.subcategory}</option>
				    </select>
				</div>
                <div class="form-group">
                    <label for="goods-price">가격<span class="rq">*</span></label>
                    <input type="number" id="goods-price" name="price" value="${goods.price}"required>
                </div>
                <div class="form-group">
                    <label for="goods-comment">제품 코멘트<span class="rq">*</span></label>
                    <input type="text" id="goods-comment" name="goodsComment" value="${goods.goodsComment}"required placeholder="제품 코멘트 한 줄">
                </div>
                <div class="form-group">
                    <label for="goods-origin">원산지<span class="rq">*</span></label>
                    <input type="text" id="goods-origin" value="${goods.goodsOrigin}" name="goodsOrigin"required >
                </div>
                <div class="form-group">
                    <label for="order-info">배송정보<span class="rq">*</span></label>
                    <input type="text" id="order-info" name="deliveryInfo" value="${goods.deliveryInfo}" required >
                </div>
                <div class="form-group">
                    <label for="seller">판매자<span class="rq">*</span></label>
                    <input type="text" id="seller" name="seller" value="${goods.seller}" required >
                </div>
                <div class="form-group">
                    <label for="sales-unit">판매단위<span class="rq">*</span></label>
                    <input type="text" id="sales-unit" name="saleUnit" value="${goods.saleUnit}" required >
                </div>
                <div class="form-group">
                    <label for="goods-weight">중량/용량<span class="rq">*</span></label>
                    <input type="text" id="goods-weight" name="weight" value="${goods.weight}" required >
                </div>
                <div class="form-group">
                    <label for="goods-stockStatus">재고 수량<span class="rq">*</span></label>
                    <input type="number" id="goods-stockStatus" name="stock" value="${goods.stock}" required >
                </div>
                <div class="form-group">
			        <label for="goods-status">상태(판매/품절)<span class="rq">*</span></label>
			        <!-- 숨겨진 input 필드 추가 -->
			        <input type="hidden" id="goods-status" name="status" value="${goods.status}">
			        <!-- 버튼 클릭 시 상태를 설정 -->
			        <button type="button" class="sale" id="onGoing">판매</button>
			        <button type="button" class="sold-out" id="soldOut">품절</button>
			    </div>

			   <div class="buttons">
                    <button type="submit" class="goods-update">수정</button>
               </div>   
              
            </form>
        </div>
	</div>
</div>
</main>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>