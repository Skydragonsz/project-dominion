/**
 * Created by Quinten on 12/05/2016.
 */
$(document).ready (function(){
    generateAllCards();
    console.log("test");
});

function generateAllCards(){
    var amount = prompt("amount of cards");
    for (var i = 0; i < amount; i++){
        $("#all").append('<div class="card" style="position: relative"></div>');
    }
}