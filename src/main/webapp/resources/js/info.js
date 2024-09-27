$(document).ready(function() {
    $('#modifyForm').on('submit', function(event) {
        event.preventDefault();
        validateForm(); // 전체 유효성 검증 시작
    });

    validation(); // 초기화 시 유효성 검사 등록

    // 주소 검색 기능
    $('.address-button').on('click', function() {
        searchAddress();
    });
    
    //회원 정보 수정
    /*$('.save-button').on('click', function(event) {
    	event.preventDefault();
    	validateForm();
    });*/
    
    //회원 탈퇴 버튼
    $('.delete-button').on('click', function(event) {
    	event.preventDefault();
    	if (confirm("정말 탈퇴하시겠습니까?")) {
    		deleteAccount(); //탈퇴 처리 함수 호출
    	}
   	});
  });

	

// 유효성 검사
function validation() {
    $("#current-password").on("change", validateCurrentPassword);
    $("#new-password").on("change", validateNewPassword);
    $("#confirm-password").on("change", validateConfirmPassword);
    $("#email").on("change", validateEmail);
    $("#phone").on("change", validatePhone);
    $("#birthday").on("input", validateBirthday);
}

function validateForm() {
    let isValid = true;

    isValid = validateCurrentPassword() && isValid; // 비밀번호 검증
    isValid = validateNewPassword() && isValid;
    isValid = validateConfirmPassword() && isValid;
    isValid = validateEmail() && isValid;
    isValid = validatePhone() && isValid;
    isValid = validateBirthday() && isValid;

    if (isValid) {
        submitForm(); // 모든 검사를 통과한 경우 폼 제출
    }
}

function validateCurrentPassword() {
    const currentPassword = $("#current-password").val();
    
    if (currentPassword === "") {
        alert("현재 비밀번호를 입력하세요.");
        $("#current-password").focus();
        return false;
    }

    // AJAX 요청으로 현재 비밀번호 확인
    let isValid = false; // 초기값

    $.ajax({
        url: contextPath + '/mypage/validatePassword', // 서버의 비밀번호 검증 엔드포인트
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ password: currentPassword }),
        async: false, // 동기 요청으로 설정 (주의: 비추천)
        success: function(response) {
            if (response.isValid) {
                isValid = true; // 비밀번호가 맞는 경우
            } else {
                alert("비밀번호가 틀렸습니다.");
                $("#current-password").focus();
            }
        },
        error: function(xhr) {
            alert('Error: ' + xhr.responseText);
        }
    });

    return isValid; // 유효성 검사를 통과 여부 반환
}

function validateNewPassword() {
    const newPassword = $("#new-password").val();
    const pattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]*$/;

    if (newPassword.length < 8) {
        alert("비밀번호는 8글자 이상 작성해 주세요.");
        $("#new-password").focus();
        return false;
    } else if (!pattern.test(newPassword)) {
        alert("비밀번호는 영문, 숫자, 특수문자를 모두 사용하여 작성해 주세요.");
        $("#new-password").focus();
        return false;
    }
    return true;
}

function validateConfirmPassword() {
    const confirmPassword = $("#confirm-password").val();
    const newPassword = $("#new-password").val();
    if (confirmPassword !== newPassword) {
        alert("비밀번호와 일치하지 않습니다.");
        $("#confirm-password").focus();
        return false;
    }
    return true;
}

function validateEmail() {
    const email = $("#email").val();
    const pattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z\-]+/;
    if (!pattern.test(email)) {
        alert("이메일 형식에 맞게 작성해 주세요.");
        $("#email").focus();
        return false;
    }
    return true;
}

function validatePhone() {
    const phone = $("#phone").val();
    const pattern = /^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
    if (!pattern.test(phone)) {
        alert("휴대폰 번호 형식에 맞게 작성해 주세요.");
        $("#phone").focus();
        return false;
    }
    return true;
}

function validateBirthday() {
    const birthdayInput = $("#birthday").val();
    const birthday = new Date(birthdayInput);
    const minDate = new Date("1900-01-01");
    const maxDate = new Date("2024-12-31");

    if (isNaN(birthday.getTime()) || birthday < minDate || birthday > maxDate) {
        alert("날짜는 1900-01-01과 2024-12-31 사이여야 합니다.");
        $("#birthday").focus();
        return false;
    }
    return true;
}

function searchAddress() {
    new daum.Postcode({
        oncomplete: function(data) {
            let addr = data.userSelectedType === "R" ? data.roadAddress : data.jibunAddress;
            document.getElementById("address").value = addr;
            document.getElementById("address").focus();
        },
    }).open();
}

//유효성 검사 및 제출 함수
function submitForm() {
	 if (validateCurrentPassword() && validateNewPassword() && validateConfirmPassword() && validateEmail() && validatePhone() && validateBirthday()) {
    const userData = {
        userId: $('#userId').val(),
        userPw: $('#current-password').val(),
        userName: $('#name').val(),
        userEmail: $('#email').val(),
        userPhone: $('#phone').val(),
        userAddress: $('#address').val(),
        userBirth: $('#birthday').val(),
        userRole: $('#role').val(),
        userEnable: $('#enable').val()
    };
}

//탈퇴 처리 함수
function deleteAccount() {
	const userId = $('#userId').val();
	console.log("User ID: userId");
	
	if (!userId) {
		alert("User ID가 정의되지 않았습니다.");
		return;
	}
 }
}

// 회원 정보 수정 및 탈퇴 버튼 이벤트
/*$(document).ready(function() {
	$('.save-button').on("click", function(e) {
		e.preventDefault();
		alert("수정되었습니다.");
		submitForm();
	});*/


	$('.delete-button').on("click", function(e) {
	    e.preventDefault();
	    if (confirm("정말 탈퇴하시겠습니까?")) {
	    	deleteAccount();
	    }
	});
/*});*/
