/**
 * Created by Gianni on 3/22/2016.
 */

/*
var changeImage = function() {
    $("img")
        .mouseover(function() {
            var src = $(this).attr("src").replace("_small", "");
            $(this).attr("src", src);
        })
        .mouseout(function() {
            var src = $(this).attr("src").replace(".jpg", "_small.jpg");
            $(this).attr("src", src);
        });
};



$(document).ready(function(){
    $('img').on('mouseover', changeImage());
});
*/


var timer;

function changeBanner(){
    $("#banner").toggleClass("banner1").toggleClass("banner2");;
};

function startSwitch(){
    $("#banner").addClass("banner1");
    timer = setInterval(changeBanner, 10000)
};

$(document).ready(function(){
    $('a[href^="#"]').on('click',function (e) {
        e.preventDefault();

        var target = this.hash;
        var $target = $(target);

        $('html, body').stop().animate({
            'scrollTop': $target.offset().top
        }, 900, 'swing', function () {
            window.location.hash = target;
        });
    });

    $(window).scroll(function () {
        console.log($(window).scrollTop())
        if ($(window).scrollTop() > 892) {
            $('header').addClass('header-fixed');
            $('section').addClass('section-scroll');
        }
        if ($(window).scrollTop() < 893) {
            $('header').removeClass('header-fixed');
            $('section').removeClass('section-scroll');
        }
    });

    startSwitch();

});