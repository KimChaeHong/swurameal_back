/* 상품 갯수 증감에 따른 각 아이템의 가격변동 */
$(document).ready(function() {
   countItem();
   checkItem();
   totalPriceOper();
   itemAdd();
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


document.addEventListener("DOMContentLoaded", function() {
    window.itemAdd = function(goodsId) {
        $.ajax({
            url: contextPath + '/cart/itemAdd',
            type: 'GET',
            data: { goodsId: goodsId, quantity: 1 },
            success: function(response) {
                alert('아이템이 장바구니에 추가되었습니다.');
            },
            error: function(xhr, status, error) {
                console.error('장바구니에 아이템 추가 중 오류 발생:', error);
            }
        });
    };
});

//주문버튼 클릭시 체크된 아이템 수량 가져오기
$(document).ready(function() {
    $(document).on('click', '.order-button', function() {
        const items = []; // 아이템 정보를 담을 배열 생성

        $('.bi-check-circle-fill').each(function() { //체크된 아이템 선택
            const goodsId = $(this).data('goods-id');
            const quantity = $(this).closest('.item').find('.item-cnt').text();
            
            
            if (goodsId && quantity) {
            	items.push({goodsId: goodsId, quantity: quantity}); //배열에 객체 추가
            }                                    
        });

        sessionStorage.setItem('goodsData', JSON.stringify(items)); //세션에 저장
        
        if (items.length > 0) {
        	$.ajax({
        		url: `${contextPath}/order`,
        		type: 'POST',
        		contentType: 'application/json',
        		data: JSON.stringify(items),
        		success: function(response) {
        			window.location.href = response.redirectUrl;
        		},
        		error: function(err) {
        			console.error('Error:', err);
        		}
        	});
        } else {
        	alert('체크된 상품이 없습니다.');
        }
    });
});