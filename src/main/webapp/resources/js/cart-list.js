/* 상품 갯수 증감에 따른 각 아이템의 가격변동 */
$(document).ready(function() {
   countItem();
   checkItem();
   totalPriceOper();
});

function countItem() {
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
    
    // DB에 수량 업데이트
    updateQuantityInDB(item.data("goods-id"), cnt);
    
    totalPriceOper();
  });
}

/* 선택 || 전체선택 버튼 */
function checkItem() {
     const checkBtn = $(".bi:not(#xBtn, #allBtn, .bi-cart, .bi-search)");

     // 전체선택 버튼
     $("#allBtn, #allBtnTxt").click(function () {
        
        const isChecked = $("#allBtn").hasClass("bi-check-circle-fill");
        
        if (isChecked) {
           $("#allBtn").removeClass("bi-check-circle-fill").addClass("bi-check-circle");
           checkBtn.removeClass("bi-check-circle-fill").addClass("bi-check-circle");
        } else {
           $("#allBtn").removeClass("bi-check-circle").addClass("bi-check-circle-fill");
           checkBtn.addClass("bi-check-circle-fill").removeClass("bi-check-circle");
        
        }        
      
         totalPriceOper();

     });

     // 개별선택 버튼
     $(document).on("click", ".item .bi-check-circle, .item .bi-check-circle-fill", function() {
        $(this).toggleClass("bi-check-circle-fill bi-check-circle");
     

       // 체크된 아이템의 갯수에 따른 전체선택 버튼 toggle
        const checkedCount = $(".bi-check-circle-fill:not(#allBtn)").length;
        const totalCount = $(".item").length;
        
        $("#allBtn").toggleClass("bi-check-circle-fill", checkedCount === totalCount)
                 .toggleClass("bi-check-circle", checkedCount !== totalCount);   
      
       totalPriceOper();
     });
   }

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




//DB에 저장
function updateQuantityInDB(goodsId, quantity) {
   console.log("goodsId:", goodsId, "quantity:", quantity);
    $.ajax({
        url: contextPath + '/cart/update', // 서버의 URL (컨트롤러 경로)
        type: 'POST',
        contentType: 'application/x-www-form-urlencoded',
        data: {
            goodsId: goodsId,
            quantity: quantity
        },
        success: function(response) {
            if (response === "ok") {
                console.log('수량이 업데이트되었습니다.');
            } else {
                alert(response.message);
            }
        },
        error: function(xhr, status, error) {
            alert('수량 업데이트 중 오류 발생: ' + error);
        }
    });
}
