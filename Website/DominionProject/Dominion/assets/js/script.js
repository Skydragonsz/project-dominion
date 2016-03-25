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
});