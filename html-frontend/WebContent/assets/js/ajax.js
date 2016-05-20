/**
 * Created by Gianni on 5/19/2016.
 */
$(document).ready(function () {
    $("#test").click(function () {

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
    });


});


function callHand() {

$.get("DominionServlet?operation=getHand", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON... // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
    $.each(responseJson, function(index, item) { // Iterate over the JSON array.
        $("#hand").append('<div class="hand card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/'+ item.toLowerCase() +'.jpg)"></div>');
        //$("#hand").append('<img src="../html-frontend/assets/media/Base%20Deck/'+ item.toLowerCase() +'.jpg">');
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
	    	$("#" + type).append('<div class="kingdom card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/'+ card[0].toLowerCase() +'.jpg)""><div class="circle">10</div></div>');
	    })
	});
}


function callPlayerInfo() {

	$.get("DominionServlet?operation=getPlayerInfo", function(responseJson) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON... // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
//		$.each(responseJson, function(index, item) { // Iterate over the JSON array.
//			var info = item.toString();
			console.log(responseJson.turn);
			$("#player").append('<b>Player: </b>' + responseJson.player);
			$("#turn").append('<b>Turn: </b>' + responseJson.turn);
			$("#coins").append('<b>coins: </b>' + responseJson.coins);
			$("#actions").append('<b>actions: </b>' + responseJson.actions);
			$("#buys").append('<b>buys: </b>' + responseJson.buys);
			
			
		})
}

function callAllCards() {
	$.get("DominionServlet?operation=getAllCards", function(responseJson) {
		$.each(responseJson, function(index, item) {
			 $("#all").append('<div class="card" style="position: relative; background-image: url(../html-frontend/assets/media/Base%20Deck/'+ item.toLowerCase() +'.jpg)""></div>');
		})
	});
}


