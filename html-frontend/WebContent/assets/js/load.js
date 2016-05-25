$(document).ready(function () {  
	loadSaves();
	$("#load").on("click", loadGame());
});	
	
                        
function loadSaves(){
        $.get('Load', function (responseJson) {    
        	var $select = $('#saves');                           
            $select.find('option').remove();
            $('<option>').val("0").text("Select save").appendTo($select);
            $.each(responseJson, function (key, value) {               
            	$('<option>').val(key).text(value).appendTo($select); 
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
            operation: 'load',
            gameID: $("#saves :selected").val()
        }

    }).done(function (data) {
    	console.log("test" + data);
        var obj = JSON.parse(data);
    });
}