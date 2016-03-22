/**
 * Created by Gianni on 12/3/2015.
 */
var characters = ["Cersei Lannister","Daenarys Targaryen","Maester Varys","Margarey Tyrell","Petyr Baelish","Samwell Tarly","Sansa Stark"];
var vote = [0,0,0,0,0,0,0];
var huidigeAfbeelding = 0;

var addImages = function () {
    for(var i= 0, len = characters.length; i < len; i++){

        var html = '<li>';
        // patroon afbeelding voornaam-naam-1920.jpg
        var imgsrc = 'images/' + characters[i].replace(' ','-').toLowerCase() + '-1920.jpg';

        html += '<figure><img alt="'+characters[i]+'" '+characters[i] + '"title="'+characters[i]+'"src="'+ imgsrc +'"/>';
        html += '<figcaption>'+characters[i] +'</figcaption></figure></li>';

        $('.carousel').append(html);
    }
    $('.carousel li:first').show();
};

var nextImage = function (e) {
    e.preventDefault();
    //vorige onzichtbaar !Examenvraag!
    if(huidigeAfbeelding>=0){
        $('.carousel li:nth-child('+ (huidigeAfbeelding + 1)+')').fadeOut();
    }

    huidigeAfbeelding += 1;

    //volgende zichtbaar
    if(huidigeAfbeelding<characters.length){
        $('.carousel li:nth-child('+ (huidigeAfbeelding + 1)+')').fadeIn();
    }

};

var previousImage = function(e) {
    e.preventDefault();
    //vorige onzichtbaar
    if(huidigeAfbeelding>=0){
        $('.carousel li:nth-child('+ (huidigeAfbeelding - 2)+')').fadeOut();
    }

    huidigeAfbeelding -= 1;

    //volgende zichtbaar
    if(huidigeAfbeelding<characters.length){
        $('.carousel li:nth-child('+ (huidigeAfbeelding + 1)+')').fadeIn();
    }

};


var Voting = function(e) {

    index = characters.indexOf(this.alt);

    vote[index] +=1;

    stem = vote[index];


    if (vote[index] === 1){
        var html = '<li>';

        html += this.alt + "  " + '<span id="'+ index +'" class="voting">' + '</span></li>';

        $('.vote').append(html);
    }

    document.getElementById(index).innerHTML =  vote[index];
    $("#" + index).css("min-width", (($("#" + index).text()) * 10) + "px");

};

var Finish = function(e) {
    //var maxVote = Math.max.apply(Math, vote);
    //var v = vote.indexOf(maxVote)
    e.preventDefault();

    arr = [];
    for(i = 0, l = characters.length; i < l; i++) {
        arr.push({
            vote: vote[i],
            name: characters[i]
        });
        arr.sort(function(a, b){return b.vote-a.vote});
    }
    alert("Congratulations! " + arr[0].name +" won by " + arr[0].vote + " votes");

};

$(document).ready(function(){
    //Afbeeldingen toevoegen aan pagina
    addImages();
    $('.next').on('click', nextImage);
    $('.previous').on('click', previousImage);
    $('img').on('click', Voting);
    $('.finish').on('click', Finish);
});