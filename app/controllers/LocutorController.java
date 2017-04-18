package controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import models.Locutor;
import play.data.Form;
import play.data.FormFactory;
import play.data.validation.ValidationError;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import utils.Validaciones;
import views.formdata.DetalleConcursoFormData;

public class LocutorController extends Controller {
	@Inject FormFactory formFactory;
	
	public Result locutor(Long id){
		Locutor locutor = new Locutor();
		return ok(Json.toJson(locutor.findLocutorById(id)));
	}

	public Result locutorByEmail(String email){
		if(Locutor.findLocutorByEmail(email) == null){
			return ok("");
		}
		return ok(Json.toJson(Locutor.findLocutorByEmail(email)));
	}

	public Result guardarLocutor(){
		Form<DetalleConcursoFormData> detalleConcursoForm = formFactory.form(DetalleConcursoFormData.class);
		Map<String, String> formData = new HashMap<String, String>();
		Http.MultipartFormData body = request().body().asMultipartFormData();
		Iterator it = body.asFormUrlEncoded().entrySet().iterator();

		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			String[] arregloValor = (String[])entry.getValue();
			String campo = entry.getKey().toString();
			String valor = arregloValor[0];
			formData.put(entry.getKey().toString(), valor);
		}
		
		if(formData.get("email")== null || formData.get("email").trim().equals("")){
			detalleConcursoForm.reject(new ValidationError("email", "el campo email no puede ser vacio"));
			return badRequest(detalleConcursoForm.errorsAsJson().toString());
		}
		
		if(formData.get("nombres")== null || formData.get("nombres").trim().equals("")){
			detalleConcursoForm.reject(new ValidationError("nombres", "el campo nombres no puede ser vacio"));
			return badRequest(detalleConcursoForm.errorsAsJson().toString());
		}

		if(formData.get("apellidos")== null || formData.get("apellidos").trim().equals("")){
			detalleConcursoForm.reject(new ValidationError("apellidos", "el campo apellidos no puede ser vacio"));
			return badRequest(detalleConcursoForm.errorsAsJson().toString());
		}
		
		if(!Validaciones.isValidEmailAddress(formData.get("email"))){
			System.out.println("email incorrecto");
			detalleConcursoForm.reject(new ValidationError("email", "formato incorrecto"));
			return badRequest(detalleConcursoForm.errorsAsJson().toString());
		}
				
		if(Locutor.findLocutorByEmail(formData.get("email")) != null){
			detalleConcursoForm.reject(new ValidationError("email", "Ya existe el email"));
			return badRequest(detalleConcursoForm.errorsAsJson().toString());
		}
		
		Locutor locutor = new Locutor(formData.get("nombres"),formData.get("apellidos"),formData.get("email"));
		locutor = locutor.insert();
		return ok(Json.toJson(locutor));
	}

	public Result actualizarLocutor(Long id){
		String json = "";
		Map<String, String> formData = new HashMap<String, String>();
		Http.MultipartFormData body = request().body().asMultipartFormData();
		Iterator it = body.asFormUrlEncoded().entrySet().iterator();

		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			String[] arregloValor = (String[])entry.getValue();
			String campo = entry.getKey().toString();
			String valor = arregloValor[0];
			formData.put(entry.getKey().toString(), valor);
		}
		Locutor locutor = new Locutor(formData.get("nombres"),formData.get("apellidos"),formData.get("email"), id);
		locutor = locutor.actualizarLocutor();
		return ok(Json.toJson(locutor));
		
		
	}
}