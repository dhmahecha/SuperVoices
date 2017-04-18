package controllers;

import models.Concurso;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class ConcursoController extends Controller {
	public Result concurso(Integer id){
    	Concurso concurso = new Concurso();
    	return ok(Json.toJson(concurso.findConcursoById(id)));
	}
}
