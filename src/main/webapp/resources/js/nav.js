$(document).ready(function() {
	
	const userIdFromUrl = getParameterByName('userId'); //URL에서 가져오기
    
    //사용자 ID가 있을 경우 카트 수량 업데이트
    if (userIdFromUrl) {
    	updateCartItemCount(userIdFromUrl); //매개변수로 userIdFromUrl 전달
    	window.location.replaceState({}, document.title, window.location.pathname); //URL 업데이트
    } else {
    	console.error('User ID not found in URL.');
    }
    
    //로그인 폼 제출 시
    $(document).on('submit', '#loginForm', function(event) {
        event.preventDefault();
        const formData = $(this).serialize();

        $.ajax({
            url: contextPath + '/login',
            type: 'POST',
            data: formData,
            success: function() {
            	const userId = data.userId; // 서버 응답에서 URL 가져오기
            	console.log("Fetched User ID:", userId);
            	
            if (userId) {	
            	updateCartItemCount(userId); //사용자 ID를 매개변수로 넘김
            	window.location.href='/'; //URL 업데이트
    		} else {
    			console.error('User ID not found in URL.');			
	            }
            },
            error: function(xhr, status, error) {
            	console.error('Login failed:', error);
            	}
            });
    });
	
	//URL 파라미터에서 값 가져오기
    function getParameterByName(name) {
    	const url = new URL(window.location.href);
    	return url.searchParams.get(name);
    }

	
	//카트 수량 업데이트
	function updateCartItemCount(userId) {
		if (!userId) {
			$('#cartCnt').text(0);
			return;
			}
		
    $.ajax({
        url: contextPath + '/cart/itemCount',
        type: 'GET',
        data: { userId: userId },
        success: function(data) {
        	let totalCount = 0;
        	
        	//data가 객체인지 확인 후 처리
        	if (typeof data === 'object') {
            $.each(data, function(goodsId, quantity) {   
            	quantities.push(quantity); //수량 배열에 추가
            	totalCount += quantity;
            });    
            $('#cartCnt').text(totalCount);  //총 수량 표시
        } else {
        	console.error('Unexpected response format:', data);
        }
    },	
        error: function(xhr, status, error) {
            console.error('Error fetching cart item count:', error);
                $('#cartCnt').text(0); // 비로그인 상태로 간주
            }
    	});
	}
});