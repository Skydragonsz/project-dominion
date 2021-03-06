// ON LOAD
$(document).ready(function () {
    callBoard();
    callHand();
//    calculateDegreesCardsInHand();
    callPlayingField();
    callPlayerInfo();
    refreshCurrentPlayer()
});

// GAME CONFIG
$("#init").on("click", function () {
    initializeGame()
});





function initializeGame() {
    //TEMP 3
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
            name3: $("#name3").val(),
            set: $("input[type='radio']:checked").val()
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
            card[0] = card[0].replace(/\s+/g, '');
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
    //clean
    $("#kingdomset").children().remove();
    $("#treasure").children().remove();
    $("#victory").children().remove();
    $("#hand").children().remove();
    $("#playingfield").children().remove();
    //$("#SelectCards").children().remove();

    //GameOver check
    isGameOver();
//    }

}


//JAVASCRIPT TRIGGER EVENTS
/*When clicked in hand*/ /*PLAY CARD*/
$(document).on('click', '.hand', function () {
    var id = $(this).attr('id').toString();
    showSpecialActionLayout(id); /*changed hasSpecialAction*/
	var JSONobj = {};
	JSONobj["state"] = "None";
	var obj = JSON.stringify(JSONobj);
	
        $.ajax({
            cache: false,
            dataType: "text",
            url: "/html-frontend/DominionServlet",
            type: "get",
            data: {
                operation: 'playCard',
                card: id,
                effect: obj
            }

        }).done(function (data) {
            var obj = JSON.stringify(data);
            cleanLayoutBoard();
        });
});

/* When clicked on the button nextSegment */
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
        alert("Next player");
        cleanLayoutBoard();
    });
});

/* When clicked on the button spawn Card */
$(document).on('click', '#spawn', function () {
    var cardName = prompt("What card would you like to spawn <String>?")
    $.ajax({
        cache: false,
        dataType: "text",
        url: "/html-frontend/DominionServlet",
        type: "get",
        data: {
            operation: 'spawnCard',
            card: cardName
        }

    }).done(function (data) {
        var obj = JSON.stringify(data);
        cleanLayoutBoard();
    });
});

/* Save Game */
$(document).on('click', '#save', function () {
    var save = prompt("Save name")
    $.ajax({
        cache: false,
        dataType: "text",
        url: "/html-frontend/DominionServlet",
        type: "get",
        data: {
            operation: 'save',
            save: save
        }

    }).done(function (data) {
        var obj = JSON.stringify(data);
        
    });
});

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
            cleanLayoutBoard();
        });
    }
});

function isGameOver(){
    $.get("DominionServlet?operation=getGameState", function (responseJson) {
        console.log(responseJson.gameOver);
    }).done(function (data) {
    	console.log(data.gameOver);
    	if (data.gameOver){
//            showVictoryScreen();
            console.log(data.gameOver);
            alert("GAME IS OVER");
            window.location.href = "../html-frontend/victory.html";
        } else {
            $("#kingdomset").children().remove();
            $("#treasure").children().remove();
            $("#victory").children().remove();
            $("#hand").children().remove();
            $("#playingfield").children().remove();
            //$("#SelectCards").children().remove();
            //call
            callBoard();
            callHand();
            callPlayingField();
            callPlayerInfo();
        }
    	
    });
}

//---- SPECIAL ACTION ----//
//1. SHOW IT TO THE USER.
function showSpecialActionLayout(cardName) {
    $("#selectedCardButton").removeClass();
    switch (cardName) {
        case "Cellar":
            showSelectableCards("Discard any number of cards.",cardName);
            break;
        case "Chapel":
            showSelectableCards("Trash up to 4 cards."),cardName;
            break;
        case "Workshop":
            showSelectableBoard("Buy a card that cost up to 4 coins.",cardName);
            break;
        case "Bureaucrat":
            //fill DIV with section that equal the amount of all other players. One section = one player.
            //Each section will display a victory card of said player if he has one, if a player doesn't hava a victory card
            //in his hand, show text "no victory card"
            //  -------------------------------
            //  | Player2 | Player3 | Player4 |
            //  | estate  | no vict |province |
            //  -------------------------------
            showSpecialActionCard(CardName);
            break;
        case "Militia":
            //fill DIV with section that equal the amount of all other players. One section = one player.
            //Each section will display the hand of said player.
            //Said player can discard down to 3 cards.

            break;
        case "Moneylender":
            showSelectableCards("Trash 1 copper card.",cardName);
            break;
        case "Remodel":
            showSelectableCards("Trash 1 card.",cardName);
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
            showSelectableCards("Select 1 action card.",cardName);
            break;
        case "Library":
            //later
            break;
        case "Mine":
            showSelectableCards("Trash 1 treasure card.",cardName);
            break;
        case "Adventurer":
            //later
            break;
        default:
            hasSpecialAction = false;
    }

}

//1,5. SHOW IT -> CLICK IT -> GET IT
function showSelectableCards(text, cardName) {
    $("#SelectCards").removeClass("invisible");
    //$("#specialActionText").html(text);
    refreshCurrentPlayer();
    $("#SelectCards").append('<div id="' + cardName + '" class="'+ "player" + '"></div>');
    $.get("DominionServlet?operation=getHand", function (responseJson) {
        $.each(responseJson, function (index, item) {
            $(".player").append('<div id="' + item + '" class="selectable card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/' + item.toLowerCase() + '.jpg)"></div>');
        });
        $(".player").append('<a id="selectedCardButton" class="button special" href="#">Ok</a>');
    });
}

function showSelectableBoard(text) {
    //Getting the correct values from servlet
    $("#SelectCards").removeClass("invisible");
    $("#specialActionText").html(text);
    $("#kingdomset").appendTo("#SelectCards");
    $("#wrapper").appendTo("#SelectCards");
}

$(document).on('click', '.selectable', function () {
    $(this).toggleClass("selected");
});

function getSelectedCards() {
	var JSONobj = {};
	$(".player").each(function() {
		var selectedCards = [];
		player = $(this).attr("class");
		player = player.replace(/ /g,'');
		
		$(this).find(".selected").each(function() {
			selectedCards.push($(this).attr("id"));
		});

		JSONobj[player] = selectedCards;
		
		$(this).find(".special").each(function() {
			key = $(this).attr("id") + player;
			JSONobj[key] = true;
		});
		
	});
	
	var obj = JSON.stringify(JSONobj);
	console.log(obj);
	console.log(JSONobj);
	return obj;
}



// 2. SEND IT.
$(document).on('click', '#selectedCardButton', function () {
    var cardName = $('.player').attr("id");
    var selectedCards = getSelectedCards();
        $.ajax({
            cache: false,
            dataType: "json",
            url: "/html-frontend/DominionServlet",
            type: "get",
            contentType: "application/json",
            data: {
                operation: 'playCard',
                card: cardName,
                effect: selectedCards
            }

        }).done(function (data) {
            var obj = JSON.stringify(data);
            cleanLayoutBoard();
            $("#SelectCards").children().remove();
            //callBoard();
            callPlayingField();
            callPlayerInfo();
            callHand();
            $("#SelectCards").addClass("invisible");

        });
//    } else {
//        alert("You selected the wrong card(s), try again.")
//    }
        $("#SelectCards").addClass("invisible");
        $("#SelectCards").children().remove();
});


function refreshCurrentPlayer(){
    $.get("DominionServlet?operation=getCurrentPlayer", function (responseJson) {
        playerCounter = responseJson.currentPlayer;
        console.log(playerCounter);
    });

}