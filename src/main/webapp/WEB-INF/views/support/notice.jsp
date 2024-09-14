<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>    
	<%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/support.css">

    <main class="d-flex container support-container">

        <section id="leftSide">
            <div id="side-category">
                <h3 class="h3">고객센터</h3>
                <h5 class="active h5" data-js="../js/notice.js">공지사항</h5>
                <h5 class="h5" data-js="../js/faq.js">자주묻는질문</h5>
                <h5 class="h5" data-js="../js/myqna.js">문의</h5>
            </div>
        </section>

        <section id="mainContent">
            <h3 class="h3" id="title">공지사항</h3>
            <div id="board-container" >
                
            </div>
        </section>

    </main>

    <button onclick="backToTop()" id="btn-back-to-top">Top</button>
    
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		