
function clickModalButton(reviewData, buttonText, container) {
    let reviewInfo = "";
    let title = "";
    if (buttonText == "수정하기") {
        title = container.closest(".review-top").find("div > p").eq(0).text();
        reviewInfo = reviewData.filter((data) => title == data.title);
        $(".modal-review textarea").val(reviewInfo[0].description);
        $(".modal-product-detail :nth-of-type(2) > span").text(reviewInfo[0].wirttenDay);
    } else {
        title = container.closest(".product-box").find("div > div > :nth-of-type(3) > span").text();
        reviewInfo = reviewData.filter((data) => title == data.title);
        $(".modal-review textarea").val("");
        const today = new Date();
        const todayFormat = today.getFullYear() + "/" + (today.getMonth() + 1) + "/" + today.getDate();
        $(".modal-product-detail :nth-of-type(2) > span").text(todayFormat);
    }
    $(".modal-product-img img").attr("src", reviewInfo[0].img);
    $(".review-update").text(buttonText);
    $(".modal-product-detail :nth-of-type(1) > span").text(title);
}

$(document).on("click", ".insert-button", function () {
	clickModalButton(productdata, "작성하기", $(this));
});