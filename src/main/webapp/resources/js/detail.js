// 찜 버튼 클릭 시 아이콘 변경 및 알림
$(document).on('click', '#pick', function() {
    var className = $('#pick-icon').attr('class'); // 찜 아이콘의 현재 클래스 가져오기
    console.log(className); // 현재 클래스 콘솔에 출력

    if (className.includes("bi-heart")) { // 하트 아이콘이 비어있을 때
        if (className.includes("bi-heart-fill")) { // 하트가 채워져 있을 때
            $('#pick-icon').removeClass('bi-heart-fill');
            $('#pick-icon').addClass('bi-heart');
        } else { // 하트가 비어있을 때
            $('#pick-icon').removeClass('bi-heart');
            $('#pick-icon').addClass('bi-heart-fill');
        }
    }
});

