$(document).ready(function() {
	// 생년월일 입력 필드가 변경될 때마다 hidden 필드 업데이트
	document.addEventListener('input', function() {
		var year = document.getElementById('year').value.trim();
		var month = document.getElementById('month').value.trim();
		var day = document.getElementById('day').value.trim();
		var userBirth = document.getElementById('userBirth');

		// 유효한 값인지 체크 (year는 4자리, month와 day는 2자리)
		if (year.length === 4 && month.length === 2 && day.length === 2) {
			// 날짜를 YYYY-MM-DD 형식으로 합쳐서 hidden 필드에 설정
			userBirth.value = year + '-' + month + '-' + day;
		} else {
			// 값이 올바르지 않으면 빈 값으로 설정
			userBirth.value = '';
		}
	});

	
	

});