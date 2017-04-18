/**
 * Created by Diego on 26/02/17.
 */

/**
 * Cambia el estado de un audio a False
 */
function actualizarLocutor(idLocutor){
    var data = new FormData();
    data.append("nombres", $("#nombres").val());
    data.append("apellidos", $("#apellidos").val());
    data.append("email", $("#email").val());

    $.ajax({
        type: "PUT",
        url: "/actualizarLocutor/" + idLocutor,
        dataType: "json",
        data:  data,
        processData: false,
        contentType:false,
        success: function (msg)
        {

        },
        error: function (err)
        {
          $('#voz-warning').empty();
          $('#voz-warning').hide();
          $.each(JSON.parse(err.responseText), function(i,item){
           $('#voz-warning').append(i + ": " + item + "<br>");
		  })
          $('#voz-warning').show();
        },
        async: false,
    });
}

function setInfoLocutor(){
    var locutor = getLocutorByEmail();
    if(locutor != undefined) {
        $("#nombres").val(locutor.nombres);
        $("#apellidos").val(locutor.apellidos);
    }
}

function getLocutorByEmail(){
    var email = $("#email").val();
    var locutor;
    $.ajax({
        type:"GET",
        contentType:"application/json; charset=utf8",
        url:"/locutorByEmail/"+email,
               success: function (response) {
                   locutor=response;
        },
        async: false,
    });
    return locutor;
}


$("#email").keyup(function() {
    if($("#email").val().length > 4){
        setInfoLocutor();
    }
});

$("#email").mouseup(function() {
    if($("#email").val().length > 4){
        setInfoLocutor();
    }
});