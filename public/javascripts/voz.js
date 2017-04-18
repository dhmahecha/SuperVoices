/**
 * Created by Diego on 22/02/17.
 */

/**
 *
 * @param name
 * @returns {*}
 */
function getCookie(name) {
    var cookieValue = null;
    if (document.cookie && document.cookie !== "") {
        var cookies = document.cookie.split(";");
        for (var i = 0; i < cookies.length; i++) {
            var cookie = jQuery.trim(cookies[i]);
            // Does this cookie string begin with the name we want?
            if (cookie.substring(0, name.length + 1) === (name + "=")) {
                cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                break;
            }
        }
    }
    return cookieValue;
}

$.ajaxSetup({
    beforeSend: function(xhr, settings) {
        if (!(/^http:.*/.test(settings.url) || /^https:.*/.test(settings.url))) {
            // Only send the token to relative URLs i.e. locally.
            xhr.setRequestHeader("X-CSRFToken", getCookie("csrftoken"));
        }
    }
});


function comprueba_extension(archivo) {
   var extensiones_permitidas = new Array(".wav",".mp3",'.ogg');
   var mierror = "";
   if (!archivo) {
      //Si no tengo archivo, es que no se ha seleccionado un archivo en el formulario
      	mierror = "No has seleccionado ningún archivo";
   }
   else{
      //recupero la extensión de este nombre de archivo
      extension = (archivo.substring(archivo.lastIndexOf("."))).toLowerCase();
      //alert (extension);
      //compruebo si la extensión está entre las permitidas
      permitida = false;
      for (var i = 0; i < extensiones_permitidas.length; i++) {
         if (extensiones_permitidas[i] == extension) {
         permitida = true;
         break;
         }
      }
      if (!permitida) {
         mierror = "Compruebe la extensión de los archivos a subir. \nSólo se pueden subir archivos con extensiones: " + extensiones_permitidas.join();
      }
   }
   if(mierror != "") {
       $('#voz-warning').empty();
       $('#voz-warning').hide();
       $('#voz-warning').append(mierror);
       $('#voz-warning').show();
       return false;
   }
   return true;
}

function guardarVoz(idLocutor){
    var id;
    var vozOriginal = document.getElementById("val_voz_original");
    var idConcurso = $("#idConcurso").val();
    var file = vozOriginal.files[0];
    var data = new FormData();
    data.append("val_voz_original", file);
    var uuid = UUID.generate();
    data.append("idVoz",uuid);
    data.append("txt_observaciones", $("#txt_observaciones").val());
    data.append("locutor", idLocutor);
    data.append("concurso", idConcurso);

    $.ajax({
        type: "POST",
        url: "/guardarvoz",
        dataType: "json",
        data: data,
        processData: false,
        contentType:false,
        success: function (obj) {
          id = obj.id;
          $('#voz-warning').empty();
          $('#voz-warning').hide();
          $('#voz-success').hide();
          $('#voz-success').empty();
          $('#voz-success').hide();
          $('#voz-success').append("Hemos recibido tu voz y la estamos procesando para que sea publicada en la página del concurso y pueda ser posteriormente revisada por nuestro equipo de trabajo. Tan pronto la voz quede publicada en la página del concurso te notificaremos por email.");
          $('#voz-success').show();
          $("#nombres").val("");
          $("#apellidos").val("");
          $("#email").val("");
          $("#val_voz_original").val("");
          $("#txt_observaciones").val("");
        },
        error: function (err) {
          $('#voz-warning').empty();
          $('#voz-warning').hide();
          $.each(JSON.parse(err.responseText), function(i,item){
           $('#voz-warning').append(i + ": " + item + "<br>");
		  })
          $('#voz-warning').show();

        },
        async: false,
    });
    return id;
}

function guardarLocutor(){
    var data =	 new FormData();
    data.append("nombres", $("#nombres").val());
    data.append("apellidos", $("#apellidos").val());
    data.append("email", $("#email").val());
    var locutor;

    $.ajax({
        type: "POST",
        url: "/guardarlocutor",
        dataType: "json",
        data: data,
        processData: false,
        contentType:false,
        success: function (obj) {
            locutor = obj.id;
        },
        error: function (err) {
          $('#voz-warning').empty();
          $('#voz-warning').hide();
          $.each(JSON.parse(err.responseText), function(i,item){
           if(i == "email" && item[0].toString().includes("Ya existe")) {

           }
           else{
             $('#voz-warning').append(i + ": " + item + "<br>");
             $('#voz-warning').show();
           }
		  })
        },
        async : false,
    });
    return locutor;
}

function actualizarVozConcurso(id){
   var idConcurso = $("#idConcurso").val();
   var arrConcursos =  new Array (idConcurso);
   var data = new FormData();
   data.append("concursos", idConcurso);

    $.ajax({
        type: "PUT",
        url: "/api/vozConcursoUpdate/" + id,
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

function guardarCambios(){
  var idVoz
  var validacionArchivo = comprueba_extension($("#val_voz_original").val());
  if(validacionArchivo) {
      var idLocutor = guardarLocutor();
      if (idLocutor != undefined) {
          idVoz = guardarVoz(idLocutor);
          //actualizarVozConcurso(idVoz);
      }
      else {
          var nombres = $("#nombres").val();
          var apellidos = $("#apellidos").val();
          var email = $("#email").val();

          var locutor = getLocutorByEmail();
          if (locutor != undefined && locutor != "") {
              if (nombres.trim() != "" && apellidos.trim() != "" && email.trim() != "") {
                  actualizarLocutor(locutor.id);
                  idVoz = guardarVoz(locutor.id);
                  //actualizarVozConcurso(idVoz);
              }
          }
      }
  }
}