$(document).ready(function () {  
	
});                        

        $.get('Load', function (responseJson) {    
        	console.log("test");
            var $select = $('#saves');                           
            $select.find('option').remove();
            
            $('<option>').val("placeholder").text("Select save").appendTo($select);
            


            
            

        
        $.each(responseJson, function (key, value) {               // Iterate over the JSON object.
            $('<option>').val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
        })
        });
        
