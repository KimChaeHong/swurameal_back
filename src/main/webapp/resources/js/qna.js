document.addEventListener('DOMContentLoaded', function() {
    // 모든 data-status 속성을 가진 요소들을 가져옵니다.
    const statusElements = document.querySelectorAll('p[data-status]');

    // 각 요소에 대해 반복문을 실행합니다.
    statusElements.forEach(function(element) {
        // data-status 속성 값을 가져옵니다.
        const status = element.getAttribute('data-status');

        // data-status 값에 따라 텍스트를 변경합니다.
        if (status === "0") {
            element.textContent = "답변 대기";
        } else if (status === "1") {
            element.textContent = "답변 완료";
        } else {
            element.textContent = "상태 확인 불가"; // 필요 시 예외 처리
        }
    });
});
