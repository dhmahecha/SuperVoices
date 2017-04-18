package controllers;

import models.Administrador;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class AdministradorController extends Controller {
	public Result administrador(Long id){
    	Administrador administrador = new Administrador();
    	return ok(Json.toJson(administrador.findAdministradorById(id)));
	}
}
