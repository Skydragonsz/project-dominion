/**
 * Created by Gianni on 3/22/2016.
 */

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