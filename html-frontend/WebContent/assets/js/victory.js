$(document).ready(function () {  
	
	
	loadVictory();
});	

function loadVictory(){
	loadGame();
    $.get('DominionServlet?operation=calcVictory', function (responseJson) {    
    	var $select = $('#players');                           


        $.each(responseJson, function (key, value) {               
        	$('<p>').text(key + ": " +value).appendTo($select); 
        	console.log(key + ": " +value);
        })
    });
}
	
                        
function loadGame() {
    $.ajax({
        cache: false,
        dataType: "text",
        url: "/html-frontend/DominionServlet",
        type: "get",
        data: {
            operation: 'calcVictory'
            
        }

    }).done(function (data) {
        var obj = JSON.parse(data);
    });
}