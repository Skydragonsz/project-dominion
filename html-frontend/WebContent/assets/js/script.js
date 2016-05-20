/**
 * Created by Quinten on 26/04/2016.
 */

$(document).ready(function () {
	console.log("werkt dit?");
    calculateDegreesCardsInHand();
});


$(document).on('click', '.hand', function(){
    $(this).detach().appendTo("#playingfield");
    $(this).removeClass("hand");
    //$(this).removeAttr('style');
    calculateDegreesCardsInHand();
    console.log("clicked");
});

$(document).on('mouseenter', '.hand', function(){
    $(this).addClass("active");
    console.log("test");
});
$(document).on('mouseleave', '.hand', function(){
    $(this).removeClass("active");
    console.log("test");
});


function calculateDegreesCardsInHand() {
    var index = Math.floor($(".hand").length / 2);
    var switchedIndex = -index;
    console.log(index);
    $(".hand").each(function () {
        $(this).css("transform", "rotate(" + (switchedIndex * 10) + "deg)");
        $(this).css("top", (Math.abs(switchedIndex) * ((Math.abs(switchedIndex) * 7))));

        $(this).css("left", index * 75);
        index--;
        switchedIndex++;
})
}
    
    /*


function generateHand() {
    var amount = prompt("amount of cards");
    for (var i = 0; i < amount; i++) {
        $("#hand").append('<div class="hand card" style="position: relative"></div>');
    }
}

function generateSet() {
    var amount = 10;
    for (var i = 0; i < amount; i++) {
        $("#kingdomset").append('<div class="kingdom card" style="position: relative"><div class="circle">10</div></div>');
    }
}

function generateTreasure() {
    var amount = 3;
    for (var i = 0; i < amount; i++) {
        $("#treasure").append('<div class="kingdom treasure card" style="position: relative"></div>');
    }
}

function generateVictory() {
    var amount = 4;
    for (var i = 0; i < amount; i++) {
        $("#victory").append('<div class="kingdom victory card" style="position: relative"></div>');
    }
}

function cardGlow() {
    $(".active").addClass("glowBig");
    timer = setInterval(blink, 200);
}

function blinkGlow() {
    $(".card").toggleClass("glowBig").toggleClass("glowSmall");
}

function sendSpecialAction() {

}


function specialAction(cardName) {
    switch (cardName) {
        case "Cellar":
            //fill DIV with cards from hand.
            //Select any number of cards.
            //EFFECT:Discard.

            showCards();
            break;
        case "Chapel":
            //fill DIV with cards from hand.
            //Select up to 4 cards.
            //EFFECT:Trash
            showCards();
            break;
        case "Chancellor":
            break;
        case "Workshop":
            //fill DIV with board piles.
            //Buy a card that cost up to 4 coins.
            showBoard();
            break;
        case "Bureaucrat":
            //fill DIV with section that equal the amount of all other players. One section = one player.
            //Each section will display a victory card of said player if he has one, if a player doesn't hava a victory card
            //in his hand, show text "no victory card"
            //  -------------------------------
            //  | Player2 | Player3 | Player4 |
            //  | estate  | no vict |province |
            //  -------------------------------
            showOneCardFromPlayer();
            break;
        case "Feast":
            break;
        case "Militia":
            //fill DIV with section that equal the amount of all other players. One section = one player.
            //Each section will display the hand of said player.
            //Said player can discard down to 3 cards.

            break;
        case "Moneylender":
            //fill DIV with cards from hand.
            //Select 1 copper card.
            //EFFECT:Trash
            showCards();
            break;
        case "Remodel":
            //fill DIV with cards from hand.
            //Select 1 card.
            //EFFECT:Trash
            showCards();
            break;
        case "Spy":
            //fill DIV with section that equal the amount of all players. One section = one player.
            //Each section will display the top card of said player his deck.
            //You choice to put it back or discard it.

            showOneCardFromPlayer();
            break;
        case "Thief":
            //fill DIV with section that equal the amount of all other players. One section = one player.
            //Each section will display the top 2 cards of said player his deck.
            //Said player picks a treasure card he wants to trash (if he gets the option to).
            //You choice to take or not take these trashed cards.
            showOneCardFromPlayer(); //MET 2
            break;
        case "Throne Room":
            //fill DIV with cards from hand.
            //Select 1 action card.
            //EFFECT: Play it twice
            break;
        case "Council Room":
            break;
        case "Library":
            //later
            break;
        case "Mine":
            //fill DIV with cards from hand.
            //Select 1 treasure card.
            //EFFECT: Trash
            break;
        case "Witch":
            break;
        case "Adventurer":
            //later
            break;

        default:
            console.log("Sorry, we are out of " + expr + ".")
    }

}
}



/*

 function showCards(){
 $.get("handCardServlet", function(responseJson) {
 $.each(responseJson, function(name) {
 $("#SelectCards").append('<div class="card" id="" style="position: relative; background-image: url(../media/' + name + '.jpg)"></div>');
 });
 });
 }

 function showOneCardFromPlayer(){
 /        $.get("handCardServlet", function(responseJson) {
 $.each(responseJson, function(player, name) {
 $("#SelectCards").append('<div><h3>player</h3><div class="card" id="" style="position: relative; background-image: url(../media/' + name + '.jpg)"></div></div>');
 });
 });
 }



 function showBoard(){
 $("#kingdom").appendTo("#SelectCards");
 $("#wrapper").appendTo("#SelectCards");
 }

 */






