package controllers;



import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.libs.Json;

public class UserController extends Controller {
	public Result user(Long id){
    	User usuario = new User();
    	return ok(Json.toJson(usuario.findUserById(id)));
	}
	
	
	
}