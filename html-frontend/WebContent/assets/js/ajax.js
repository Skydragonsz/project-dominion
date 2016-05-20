/**
 * Created by Gianni on 5/19/2016.
 */
$(document).ready(function () {

	initializeGame();
	callBoard();
	callHand();
	callPlayerInfo();
 

});

function initializeGame() {
    
       $.ajax({ cache: false,
           dataType: "text",
           url: "/html-frontend/DominionServlet",
            type: "get",
           data: {
               operation: 'initialize',
               playerAmount: '2',
               name1: 'Quint',
               name2: 'Coene'
           }

        }).done(function (data) {
           var obj = JSON.parse(data);

          console.log("Operation: " + obj.operation + " playerAmount: " + obj.playerAmount + " name1 " + obj.name1 + " name2 " + obj.name2);
       });
}


function callHand() {

$.get("DominionServlet?operation=getHand", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON... // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
    $.each(responseJson, function(index, item) { // Iterate over the JSON array.
        $("#hand").append('<div id="'+ item + '" class="hand card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/'+ item.toLowerCase() +'.jpg)"></div>');
    })
});

}

function callBoard() {
	$.get("DominionServlet?operation=getBoard", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON... // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
	    $.each(responseJson, function(index, item) { // Iterate over the JSON array.
	    	var card = item.toString().split(";");
	    	var type;
	    	
	    	if (index <= 2 && index >= 0) {
	    		type = "treasure";
	    	} else if (index >= 3 && index <= 6) {
	    		type ="victory"
	    	} else {
	    		type = "kingdomset"
	    	}
	    	//var amount = item.toString().split(';')[1];
	    	$("#" + type).append('<div id="'+ item + '" class="kingdom card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/'+ card[0].toLowerCase() +'.jpg)""><div class="circle">10</div></div>');
	    })
	});
}


function callPlayerInfo() {

	$.get("DominionServlet?operation=getPlayerInfo", function(responseJson) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON... // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
//		$.each(responseJson, function(index, item) { // Iterate over the JSON array.
//			var info = item.toString();
			$("#player").html('<b>Player: </b>' + responseJson.player);
			$("#turn").html('<b>Turn: </b>' + responseJson.turn);
			$("#coins").html('<b>coins: </b>' + responseJson.coins);
			$("#actions").html('<b>actions: </b>' + responseJson.actions);
			$("#buys").html('<b>buys: </b>' + responseJson.buys);
			
			
		})
}

function callAllCards() {
	$.get("DominionServlet?operation=getAllCards", function(responseJson) {
		$.each(responseJson, function(index, item) {
			 $("#all").append('<div id="'+ item + '" class="card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/'+ item.toLowerCase().replace(/\s+/g, '') +'.jpg)""></div>');
		})
	});
}

$(document).on('click', '.hand', function() {
	var id = $(this).attr('id').toString();
	 $.ajax({ cache: false,
         dataType: "text",
         url: "/html-frontend/DominionServlet",
          type: "get",
         data: {
             operation: 'playCard',
             card: id
         }

      }).done(function (data) {
         var obj = JSON.stringify(data);
         callPlayerInfo();
     });
})

$(document).on('click', '.kingdom', function() {
	var id = $(this).attr('id').toString();
	 $.ajax({ cache: false,
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
     });
})


