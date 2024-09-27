$(document).ready(function() {
    const userId = '${user != null ? user.userName : ""}'; // 사용자 ID를 JSP에서 가져옴

    if (!userId) {
        $('#cartCnt').text(0); // 비로그인 시 0으로 설정
    } else {
        updateCartItemCount(); // 로그인된 경우 수량 업데이트
    }

    $(document).on('submit', '#loginForm', function(event) {
        event.preventDefault();
        const formData = $(this).serialize();

        $.ajax({
            url: '${pageContext.request.contextPath}/login',
            type: 'POST',
            data: formData,
            success: function() {
                updateCartItemCount();
                window.location.reload(); // 페이지 새로 고침
            },
            error: function(xhr, status, error) {
                console.error('로그인 실패:', error);
            }
        });
    });
});

function updateCartItemCount() {
    $.ajax({
        url: '${pageContext.request.contextPath}/cart/itemCount',
        type: 'GET',
        success: function(count) {
            $('#cartCnt').text(count); // 장바구니 아이콘 수량 업데이트
        },
        error: function(xhr, status, error) {
            console.error('Error fetching cart item count:', error);
            // 비로그인 상태에서는 count를 0으로 설정할 수 있음
            if (xhr.status === 403) {
                $('#cartCnt').text(0); // 비로그인 상태로 간주
            }
        }
    });
}
