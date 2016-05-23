// ON LOAD
$(document).ready(function () {
    callBoard();
    callHand();
    calculateDegreesCardsInHand();
    callPlayingField();
    callPlayerInfo();
});

// GAME CONFIG
$("#init").on("click", function () {
    initializeGame()
});

function initializeGame() {

    $.ajax({
        cache: false,
        dataType: "text",
        url: "/html-frontend/DominionServlet",
        type: "get",
        data: {
            operation: 'initialize',
            playerAmount: $("#players").val(),
            name1: $("#name1").val(),
            name2: $("#name2").val(),
            name3: $("#name3").val()
        }

    }).done(function (data) {
        var obj = JSON.parse(data);

        console.log("Operation: " + obj.operation + " playerAmount: " + obj.playerAmount + " name1 " + obj.name1 + " name2 " + obj.name2);
    });
}


// CALL FROM SERVLET
/* Board */
function callBoard() {
    $.get("DominionServlet?operation=getBoard", function (responseJson) {
        $.each(responseJson, function (index, item) {
            var card = item.toString().split(";");
            var type;

            if (index <= 2 && index >= 0) {
                type = "treasure";
            } else if (index >= 3 && index <= 6) {
                type = "victory"
            } else {
                type = "kingdomset"
            }
            $("#" + type).append('<div id="' + card[0] + '" class="kingdom card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/' + card[0].toLowerCase() + '.jpg)""><div class="circle">' + card[1] + '</div></div>');
        })
    });
}

/* Hand */
function callHand() {
    $.get("DominionServlet?operation=getHand", function (responseJson) {
        $.each(responseJson, function (index, item) {
            $("#hand").append('<div id="' + item + '" class="hand card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/' + item.toLowerCase() + '.jpg)"></div>');
        })
    });

}

/* PlayingField */
//When accidentally F5 / refresh gets triggered.
function callPlayingField() {

    $.get("DominionServlet?operation=getPlayingField", function (responseJson) {
        console.log(responseJson);
        $.each(responseJson, function (index, item) {
            $("#playingfield").append('<div id="' + item + '" class="card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/' + item.toLowerCase() + '.jpg)"></div>');
        })
    });

}

/* PlayerInfo */
function callPlayerInfo() {

    $.get("DominionServlet?operation=getPlayerInfo", function (responseJson) {

        $("#player").html('<b>Player: </b>' + responseJson.player);
        $("#turn").html('<b>Turn: </b>' + responseJson.turn);
        $("#coins").html('<b>coins: </b>' + responseJson.coins);
        $("#actions").html('<b>actions: </b>' + responseJson.actions);
        $("#buys").html('<b>buys: </b>' + responseJson.buys);


    })
}

/* All cards */
//When creating a custom set
function callAllCards() {
    $.get("DominionServlet?operation=getAllCards", function (responseJson) {
        $.each(responseJson, function (index, item) {
            $("#all").append('<div id="' + item + '" class="card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/' + item.toLowerCase().replace(/\s+/g, '') + '.jpg)""></div>');
        })
    });
}


//CLEAN HTML LAYOUT
function cleanLayoutBoard() {
    $("#kingdomset").children().remove();
    $("#treasure").children().remove();
    $("#victory").children().remove();
    $("#hand").children().remove();
    $("#playingfield").children().remove();
}


//JAVASCRIPT TRIGGER EVENTS
/*When clicked in hand*/
$(document).on('click', '.hand', function () {
    var id = $(this).attr('id').toString();
    var effect = specialAction(id);
    console.log(effect);
    $.ajax({
        cache: false,
        dataType: "text",
        url: "/html-frontend/DominionServlet",
        type: "get",
        data: {
            operation: 'playCard',
            card: id,
            effect: effect
        }

    }).done(function (data) {
        var obj = JSON.stringify(data);
        callPlayerInfo();
    });
})

/*When clicked on the button nextSegment*/
$(document).on('click', '#nextSegment', function () {
    $.ajax({
        cache: false,
        dataType: "text",
        url: "/html-frontend/DominionServlet",
        type: "get",
        data: {
            operation: 'nextSegment',
        }

    }).done(function (data) {
        var obj = JSON.stringify(data);
        cleanLayoutBoard();
        callBoard();
        callHand();
        callPlayingField();
        callPlayerInfo();
    });
})

/*When clicked in kingdomset*/
$(document).on('click', '.kingdom', function () {
    buyPhase = true;
    if (buyPhase) {
        var id = $(this).attr('id').toString();
        $.ajax({
            cache: false,
            dataType: "text",
            url: "/html-frontend/DominionServlet",
            type: "get",
            data: {
                operation: 'buyCard',
                card: id
            }

        }).done(function (data) {
            var obj = JSON.stringify(data);
            callPlayerInfo();
            //TEMP -- amount get changed in HTML, doesn't ask for servlet request.
            //When a new turn is asked they will get the correct values from the server.
            amount = $("#" + id).find(".circle").text() - 1;
            $("#" + id).find(".circle").html(amount);

        });
    }
})

/*calculate degrees for cards*/
function calculateDegreesCardsInHand() {
    var index = Math.floor($(document).find(".hand").length / 2);
    var switchedIndex = -index;
    console.log(index);
    $(document).find(".hand").each(function () {
        $(this).css("transform", "rotate(" + (switchedIndex * 10) + "deg)");
        $(this).css("top", (Math.abs(switchedIndex) * ((Math.abs(switchedIndex) * 7))));

        $(this).css("left", index * 75);
        index--;
        switchedIndex++;
    })
}


//---- SPECIAL ACTION ----//
function specialAction(cardName) {
    switch (cardName) {
        case "Cellar":
            $("#SelectCards").removeClass("invisible");
            //fill DIV with cards from hand.
            //Select any number of cards.
            //EFFECT:Discard.
            $.get("DominionServlet?operation=getHand", function (responseJson) {
                $.each(responseJson, function (index, item) {
                    $("#SelectCards").append('<div id="' + item + '" class="selectable card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/' + item.toLowerCase() + '.jpg)"></div>');
                })
            });
            
            $(document).on('click', '.selectedCardButton', function () {
            	selectedCards = getSelectedCards();
            	console.log("Cellar case" + selectedCards)
            	return selectedCards
            })
            break;
        case "Chapel":
        	$("#SelectCards").removeClass("invisible");
            //fill DIV with cards from hand.
            //Select up to 4 cards.
            //EFFECT:Trash
//            showCards();
        	
            $.get("DominionServlet?operation=getHand", function (responseJson) {
                $.each(responseJson, function (index, item) {
                    $("#SelectCards").append('<div id="' + item + '" class="selectable card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/' + item.toLowerCase() + '.jpg)"></div>');
                })
            });
            
            $(document).on('click', '.selectedCardButton', function () {
            	selectedCards = getSelectedCards(4);
            	console.log("Chapel case" + selectedCards)
            	return selectedCards
            })
            break;
        case "Chancellor":
            break;
        case "Workshop":
        	$("#SelectCards").removeClass("invisible");
            //fill DIV with board piles.
            //Buy a card that cost up to 4 coins.
//            showBoard();
        	
            $.get("DominionServlet?operation=getBoard", function (responseJson) {
                $.each(responseJson, function (index, item) {
               	 var card = item.toString().split(";");
                    $("#SelectCards").append('<div id="' + card[0] + '" class="selectable card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/' + card[0].toLowerCase() + '.jpg)"></div>');
                })
            });
            break;
        case "Bureaucrat":
            //fill DIV with section that equal the amount of all other players. One section = one player.
            //Each section will display a victory card of said player if he has one, if a player doesn't hava a victory card
            //in his hand, show text "no victory card"
            //  -------------------------------
            //  | Player2 | Player3 | Player4 |
            //  | estate  | no vict |province |
            //  -------------------------------
//            showOneCardFromPlayer();
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
//            showCards();
            break;
        case "Remodel":
            //fill DIV with cards from hand.
            //Select 1 card.
            //EFFECT:Trash
//            showCards();
            break;
        case "Spy":
            //fill DIV with section that equal the amount of all players. One section = one player.
            //Each section will display the top card of said player his deck.
            //You choice to put it back or discard it.

//            showOneCardFromPlayer();
            break;
        case "Thief":
            //fill DIV with section that equal the amount of all other players. One section = one player.
            //Each section will display the top 2 cards of said player his deck.
            //Said player picks a treasure card he wants to trash (if he gets the option to).
            //You choice to take or not take these trashed cards.
//            showOneCardFromPlayer(); //MET 2
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
            console.log("N/A")


    }
    cleanLayoutBoard();
    callBoard();
    callHand();
    callPlayingField();
    callPlayerInfo();

}

$(document).on('click', '.selectable', function () {
    $(this).removeClass("selectable");
    $(this).addClass("selected");
})

function getSelectedCards(){
	var selectedCards;
	$(".selected").each(function() {
		selectedCards = $(this).attr("id");
	});
	console.log("selectedCards");
	console.log(selectedCards);
	return selectedCards;
}

function getSelectedCards(amount){
	var selectedCards;
	for (i = 0; i <= amount; i++){
		$(".selected").each(function() {
			selectedCards = $(this).attr("id");
		});
	}
	console.log("selectedCards");
	console.log(selectedCards);
	return selectedCards;
}


