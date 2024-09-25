$(document).ready(function() {
	// 상품 가격 설정
	var priceElement = $("#product-price");

	var price = Number(priceElement.text().replace(/,/g, ''));

	// 수량을 숫자로 변환
	var count = Number($("#count").text());

	// 총 가격 계산
	var totalPrice = count * price;

	// 상품 개수 감소 버튼 클릭 이벤트 처리
	$("#minus-button").on("click", function() {
		if (Number($("#count").text()) <= 1) { // 개수가 1개 이하일 경우 아무 작업도 하지 않음
		} else {
			var num = Number($("#count").text()) - 1; // 상품 개수 감소
			$("#count").text(num);
			totalPrice = Number($("#count").text()) * price; // 총 가격 게산
			$(".total-price").text(totalPrice.toLocaleString() + "원"); // 총 가격
																		// 표시
		}
	});

	// 상품 개수 증가 버튼 클릭 이벤트 처리
	$("#plus-button").on("click", function() {
		var num = Number($("#count").text()) + 1; // 상품 개수 증가
		$("#count").text(num);
		totalPrice = Number($("#count").text()) * price; // 총 가격 계산
		$(".total-price").text(totalPrice.toLocaleString() + "원"); // 총 가격 표시
	});

	// 총 가격 표시
	$(".total-price").text(totalPrice.toLocaleString() + "원");

	// "구매" 버튼 클릭 시 장바구니에 담고 결제 화면으로 이동 확인
	$("#buy").on("click", function() {
		if (confirm("선택한 상품을 장바구니에 담고 결제화면으로 이동하시겠습니까?")) {
			window.location.href = "../html/cart.html"; // 결제 페이지로 이동
		}
	});

});


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