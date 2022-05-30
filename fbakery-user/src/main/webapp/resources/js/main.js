// call func
window.onscroll = function() {
    showMenuFixedTop();
    showArrawUpFixedBottom();
}

// Handle change imgs
let img = document.querySelector('.content_img');

function changeImgs(anything) {
    img.src = anything;
}

// Handle change text
let txtTitle = document.getElementById('title_product-home');
let txtDescription = document.getElementById('discription_product-home');

function changesTxtTitleProdGato() {
	txtTitle.innerHTML = 'Bánh Anh Đào';
    txtDescription.innerHTML = 'Bánh ngon không sử dụng chất bảo quản, đảm bảo vệ sinh an toàn thực phẩm.';
}

function changesTxtTitleProdNgot() {
    txtTitle.innerHTML = 'Bánh Cupcake Muffin';
    txtDescription.innerHTML = 'Bánh ngon không sử dụng chất bảo quản, đảm bảo vệ sinh an toàn thực phẩm.';
}

function changesTxtTitleProdMan() {
    txtTitle.innerHTML = 'Bánh Kem Dâu Tây';
    txtDescription.innerHTML = 'Bánh ngon không sử dụng chất bảo quản, đảm bảo vệ sinh an toàn thực phẩm.';
}

function changesTxtTitleProdTiramisu() {
    txtTitle.innerHTML = 'Bánh Cupcake Muffin';
    txtDescription.innerHTML = 'Bánh ngon không sử dụng chất bảo quản, đảm bảo vệ sinh an toàn thực phẩm.';
}

function changesTxtTitleProdPancake() {
    txtTitle.innerHTML = 'Bánh Pancake';
    txtDescription.innerHTML = 'Bánh ngon không sử dụng chất bảo quản, đảm bảo vệ sinh an toàn thực phẩm.';
}

// Handle fixed scroll menu
let scrollMenu = document.querySelector('.navbar');

function showMenuFixedTop() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        scrollMenu.style.top = '0px';
    } else {
        scrollMenu.style.top = '-140px';
    }
}

// Handle show arrow up
let arrowUp = document.querySelector('.show_arrow-up');

function showArrawUpFixedBottom() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        arrowUp.style.bottom = '0px';
    } else {
        arrowUp.style.bottom = '-60px';
    }
}

// Handle menu reponsive
let menuToogle = document.querySelector('.toggle');
let menu = document.querySelector('.menu');

menuToogle.onclick = function() {
    menuToogle.classList.toggle('active');
    menu.classList.toggle('active');
}

// Handle tooltips
let myTooltip = document.querySelector('.myTooltip');

$(myTooltip).ready(function() {
    $('[data-toggle="tooltip"]').tooltip();
})