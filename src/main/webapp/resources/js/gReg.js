document.addEventListener("DOMContentLoaded", function() {
    // 카테고리와 서브 카테고리 매핑 정보
    const subcategoryMap = {
        "분식": ["떡볶이", "냉동", "튀김"],
        "양식": ["파스타", "스테이크"],
        "한식": ["전골/찌개", "찜/조림", "볶음/구이"],
        "전통주": ["탁주", "증류주","과실주"]
    };

    const categorySelect = document.getElementById("goods-category");
    const subcategorySelect = document.getElementById("goods-subcategory");

    categorySelect.addEventListener("change", function() {
        // 현재 선택된 카테고리를 가져옵니다.
        const selectedCategory = categorySelect.value;

        // 서브 카테고리 select를 비웁니다.
        subcategorySelect.innerHTML = '<option value="" disabled selected>서브 카테고리를 선택하세요</option>';

        // 선택된 카테고리에 해당하는 서브 카테고리들을 추가합니다.
        if (selectedCategory in subcategoryMap) {
            subcategoryMap[selectedCategory].forEach(function(subcategory) {
                const option = document.createElement("option");
                option.value = subcategory;
                option.textContent = subcategory;
                subcategorySelect.appendChild(option);
            });
        }
    });
    // 상태 값을 저장할 숨겨진 input 요소
    const statusInput = document.getElementById("goods-status");

    // 판매 버튼
    const saleButton = document.querySelector("#onGoing");
    saleButton.addEventListener("click", function() {
        statusInput.value = "1"; // 판매 중으로 설정
        saleButton.style.backgroundColor = "#6B0609"; // 선택된 버튼 표시
        saleButton.style.color = "white"; // 선택된 버튼 표시
        soldOutButton.style.backgroundColor = ""; // 다른 버튼 초기화
        soldOutButton.style.color = "";
    });

    // 품절 버튼
    const soldOutButton = document.querySelector("#soldOut");
    soldOutButton.addEventListener("click", function() {
        statusInput.value = "0"; // 품절로 설정
        soldOutButton.style.backgroundColor = "#6B0609"; // 선택된 버튼 표시
        soldOutButton.style.color = "white"; // 선택된 버튼 표시
        saleButton.style.backgroundColor = ""; // 다른 버튼 초기화
        saleButton.style.color = ""; // 다른 버튼 초기화
    });
    

});
