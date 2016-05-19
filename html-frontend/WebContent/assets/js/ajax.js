/**
 * Created by Gianni on 5/19/2016.
 */
$(document).ready(function () {
    $("#test").click(function () {

        var request = $.ajax({ cache: false,
            dataType: "text",
            url: "/html-frontend/DominionServlet",
            data: {
                operation: 'initialize',
                playerAmount: '2',
                name1: 'Quint',
                name2: 'Coene'
            }
        });
        request.done(function (data) {
            var obj = JSON.stringify(data);

            console.log("Operation: " + obj.operation + "playerAmount: " + obj.playerAmount + " name1 " + obj.name1 + " name2 " + obj.name2);
        });
    });
});