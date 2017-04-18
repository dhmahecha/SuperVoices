package controllers;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import models.Locutor;
import models.Voz;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import utils.GestionAWS;

public class VozController extends Controller {
	public Result user(Integer id){
    	Voz voz = new Voz();
    	return ok(Json.toJson(voz.findVozById(id)));
	}
	
	public Result guardarVoz(){
		Map<String, String> formData = new HashMap<String, String>();
		Http.MultipartFormData body = request().body().asMultipartFormData();
		Http.MultipartFormData.FilePart uploadFilePart = body.getFile("val_voz_original");
		Iterator it = body.asFormUrlEncoded().entrySet().iterator();
		
		String[] tipoArchivo = uploadFilePart.getContentType().split("\\/");

		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			String[] arregloValor = (String[])entry.getValue();
			String campo = entry.getKey().toString();
			String valor = arregloValor[0];
			formData.put(entry.getKey().toString(), valor);
		}

		
		
		GestionAWS gestionS3 = new GestionAWS();
		String rutPublica = gestionS3.subirArchivoAS3((File) uploadFilePart.getFile(), uploadFilePart.getFilename(), 
				formData.get("idVoz"), uploadFilePart.getContentType(),true);
		
		Voz voz = new Voz(rutPublica,formData.get("txt_observaciones"),new Long(formData.get("locutor")),
				new Long(formData.get("concurso")),formData.get("idVoz"));
		voz = voz.insert();
		return ok(Json.toJson(voz));
 	}	
}
