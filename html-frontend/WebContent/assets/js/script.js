/**
 * Created by Quinten on 26/04/2016.
 */

$(document).ready(function () {
	console.log("werkt dit?");
//    calculateDegreesCardsInHand();
});


$(document).on('click', '.hand', function(){
	if (($(this).attr("id") != "Estate") && ($(this).attr("id") != "Duchy") && ($(this).attr("id") != "Province")) {
    $(this).detach().appendTo("#playingfield");
    $(this).removeClass("hand active");
//    $(this).removeAttr('style');
    calculateDegreesCardsInHand();
//    console.log("clicked");
    
	}
});

$(document).on('mouseenter', '.hand', function(){
    $(this).addClass("active");
//    console.log("test");
});
$(document).on('mouseleave', '.hand', function(){
    $(this).removeClass("active");
//    console.log("test");
});


//function calculateDegreesCardsInHand() {
//    var index = Math.floor($(document).find(".hand").length / 2);
//    var switchedIndex = -index;
//    console.log(index);
//    $(document).find(".hand").each(function () {
//        $(this).css("transform", "rotate(" + (switchedIndex * 10) + "deg)");
//        $(this).css("top", (Math.abs(switchedIndex) * ((Math.abs(switchedIndex) * 7))));
//
//        $(this).css("left", index * 75);
//        index--;
//        switchedIndex++;
//})
//}


 
