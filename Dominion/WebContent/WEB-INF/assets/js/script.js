/**
 * Created by Gianni on 3/22/2016.
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
    
    $('button').on('click', function (e){
       e.preventDefault();
       console.log("redirect")
       window.location.href = "login.html";
    });

});