

function pageUpload(clicked, themeColor, darkgrayColor) {
    const text = clicked.text();
    const url = clicked.attr("data-js");

    // ajax로 페이지를 불러올 때마다 title-boxd안의 p를 바꿔줍니다.
    // 바꾸는 text는 클릭한 <p>태그
    $(".title-box p").html(`${clicked.text()}`);

    // .category의 자손인 모든 p태그의 색과 폰트를 바꾼다.
    $(".category-box p").css({
        color: darkgrayColor,
        "font-weight": "normal",
    });

    // 클릭된 <p>태그의 색과 폰트를 바꾼다.
    clicked.css({
        color: themeColor,
        "font-weight": "bold",
    });

    
}
