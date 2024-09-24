$(document).ready(function () {
	/* 상품 갯수 증감에 따른 각 아이템의 가격변동 */
	$(".updown-btn").click(function () {
	    const item = $(this).closest(".item");
	    const itemCnt = item.find(".item-cnt");
	    const itemPrice = item.find(".price");

	    let cnt = parseInt(itemCnt.text(), 10);
	    let price = parseFloat(itemPrice.text().replace(/,/g, ""));
	    const originPrice = parseInt(itemPrice.data("price")); // 원래 가격

	    // '+' 버튼이면 1개 증가 || 아니면 1개 감소
	    $(this).text() == "+" ? (cnt += 1) : cnt > 1 && (cnt -= 1);

	    price = originPrice * cnt;
	    itemCnt.text(cnt);
	    itemPrice.text(price.toLocaleString());
	    totalPriceOper();
	  });
	
	let checkBtn = $(".bi:not(#xBtn):not(#allBtn):not(#bnav):not(.bi-search)");
	  /* 선택 || 전체선택 버튼 */
	  // 전체선택 버튼
	  $("#allBtn").click(function () {
		event.preventDefault();
	    $(this).toggleClass("bi-check-circle");
	    $(this).toggleClass("bi-check-circle-fill");

	    for (let el of checkBtn) {
	      if ($("#allBtn").hasClass("bi-check-circle-fill")) {
	        el.classList.add("bi-check-circle-fill");
	        el.classList.remove("bi-check-circle");
	      } else {
	        el.classList.remove("bi-check-circle-fill");
	        el.classList.add("bi-check-circle");
	      }
	      totalPriceOper();
	    }
	  });

	  // 개별선택 버튼
	  $(document).on("click", "#oneBtn", function () {
	    $(this).toggleClass("bi-check-circle");
	    $(this).toggleClass("bi-check-circle-fill");

	    // 체크된 아이템의 갯수에 따른 전체선택 버튼 toggle
	    let checkedBtn = $(".bi-check-circle-fill:not(#allBtn)");
	    if(checkedBtn.length == $(".item").length) {
	      $("#allBtn").removeClass("bi-check-circle");
	      $("#allBtn").addClass("bi-check-circle-fill");
	    } else {
	      $("#allBtn").addClass("bi-check-circle");
	      $("#allBtn").removeClass("bi-check-circle-fill");
	    }
	    totalPriceOper();
	  });

});

/* 전체 가격을 계산 */
function totalPriceOper() {
	  const itemList = $(".bi-check-circle-fill:not(#allBtn)").closest(".item");
	  const priceList = itemList.find(".price");

	  let totalPrice = 0;
	  for (let el of priceList) {
	    totalPrice += parseInt(el.textContent.replace(/,/g, ""));
	  }

	  let payPrice = totalPrice == 0 ? 0 : totalPrice + 3000;
	  $("#total-price").text(totalPrice.toLocaleString());
	  $("#pay-price").text(payPrice.toLocaleString()); 
}