package controllers;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.mindrot.jbcrypt.BCrypt;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

import constantes.IConstantesSuperVoices;
import models.Administrador;
import models.Concurso;
import models.User;
import net.spy.memcached.MemcachedClient;
import play.data.validation.ValidationError;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Security;
import utils.GestionAWS;
import utils.ClienteMemCache;
import views.formdata.ConcursoFormData;
import views.formdata.CreateAdminFormData;
import views.formdata.DetalleConcursoFormData;
import views.formdata.LoginFormData;
import views.html.login;
import views.html.crearadministrador;
import views.html.listarconcursos;
import views.html.crearconcurso;
import views.html.adminconcursos;
import views.html.detalleconcurso;
import views.html.helper.form;
import play.data.FormFactory;
import play.filters.csrf.RequireCSRFCheck; 
import play.Configuration;
import play.Play;
import play.Logger;


public class Application extends Controller{
	@Inject FormFactory formFactory;

	/**
	 * Provee el formulario de autenticación
	 * @return
	 */

	
	public Result login() {
		Form<LoginFormData> userForm = formFactory.form(LoginFormData.class);
		return ok(login.render(userForm));
	}


	public Result formadmin() {
		Form<CreateAdminFormData> userForm = formFactory.form(CreateAdminFormData.class);
		return ok(crearadministrador.render(userForm));
	}

	@Security.Authenticated(Secured.class)
	public Result formConcurso() {
		Form<ConcursoFormData> userForm = formFactory.form(ConcursoFormData.class);
		return ok(crearconcurso.render(userForm));
	}

	/**
	 * Valida la autenticación
	 * @return
	 */
	public  Result authenticate() {
		Form<LoginFormData> userForm = formFactory.form(LoginFormData.class).bindFromRequest();

		if (userForm.hasErrors()) {
			return badRequest(login.render(userForm));
		} else {
			//GestionAWS gestionAWS = new GestionAWS();
			//gestionAWS.sesionElastiCache();
			Long user_id = User.findByUserName(userForm.get().getUsername()).getId();
			Long admin_id = Administrador.findAdministradorByUser_id(user_id).getId();
			session().clear();
			session("username", userForm.get().getUsername());
			session("user_id", user_id.toString());
			session("admin_id",admin_id.toString());
						
			try
            {
				Logger.info("ElastiCache ");
				
				MemcachedClient client = new MemcachedClient(new InetSocketAddress(Play.application().configuration().getString("memcache.host"), 
										Play.application().configuration().getInt("clusterPort")));
				client.set("Autenticado", 3600, user_id).get();
				
				Logger.info("Listo el Cache");
				Object cache = client.get("Autenticado");
				Logger.info("Valor Cache" + cache.toString());
				
            }catch(Exception e)
            {
                e.printStackTrace();
            }
			return redirect(routes.HomeController.index());
		}
	}


	@Security.Authenticated(Secured.class)
	public Result adminConcursos(){
		
		return ok(adminconcursos.render());
	}

	public Result crearAdministrador(){
		Form<CreateAdminFormData> createAdminForm = formFactory.form(CreateAdminFormData.class).bindFromRequest();

		if(createAdminForm.hasErrors()){
			return badRequest(crearadministrador.render(createAdminForm));
		}
		else {
			Long user_id = User.findByUserName(createAdminForm.get().getUsername()).getId();
			Long admin_id = Administrador.findAdministradorByUser_id(user_id).getId();
			session().clear();
			session("username", createAdminForm.get().getUsername());
			session("user_id", user_id.toString());
			session("admin_id",admin_id.toString());
			
			try
            {
				Logger.info("ElastiCache ");
				
				MemcachedClient client = new MemcachedClient(new InetSocketAddress(Play.application().configuration().getString("memcache.host"), 
						Play.application().configuration().getInt("clusterPort")));
				client.set("Autenticado", 3600, user_id).get();
				
				Logger.info("Listo el Cache");
				Object cache = client.get("Autenticado");
				Logger.info("Valor Cache" + cache.toString());
				
            }catch(Exception e)
            {
                e.printStackTrace();
            }
			return redirect(routes.HomeController.index());
		}

	}

	@Security.Authenticated(Secured.class)
	public Result crearConcurso(){
		Map<String, String> formData = new HashMap<String, String>();
		Http.MultipartFormData body = request().body().asMultipartFormData();
		Http.MultipartFormData.FilePart uploadFilePart = body.getFile("img_banner");
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		
		Iterator it = body.asFormUrlEncoded().entrySet().iterator();
		
		String[] tipoArchivo = uploadFilePart.getContentType().split("\\/");

		Form<ConcursoFormData> createConcursoForm = formFactory.form(ConcursoFormData.class);//.bindFromRequest();
		createConcursoForm.bind(formData);
		
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			String[] arregloValor = (String[])entry.getValue();
			String campo = entry.getKey().toString();
			String valor = arregloValor[0];
			if(valor == null || valor.equals("")){
				createConcursoForm.reject(new ValidationError(campo, "El campo es requerido"));
			}
			else{
				if(campo.equals("val_pagar_voz")) {
					try{
						Long.parseLong(valor);
					}catch(NumberFormatException e){
						createConcursoForm.reject(new ValidationError(campo, "El campo debe ser un entero"));
					}
				}

				if(campo.equals("fec_inicio")) {
					try {
						formatoDelTexto.parse(valor);
					} catch (ParseException ex) {
						createConcursoForm.reject(new ValidationError(campo, "Formato de fecha incorrecto"));
					}
				}

				if(campo.equals("fec_fin")) {
					try {
						formatoDelTexto.parse(valor);
					} catch (ParseException ex) {
						createConcursoForm.reject(new ValidationError(campo, "Formato de fecha incorrecto"));
					}
				}

				if(campo.equals("nom_concurso")){
					if(Concurso.findConcursoByNom_concurso(valor) != null){
						createConcursoForm.reject(new ValidationError(campo, "El Nombre del concurso ya existe"));
					}
				}
				if(campo.equals("val_url")){
					if(Concurso.findConcursoByVal_url(valor) != null){
						createConcursoForm.reject(new ValidationError(campo, "Esta URL ya esta siendo usada"));
					}
				}	
			}
			formData.put(entry.getKey().toString(), valor);
		}

		if (uploadFilePart.getFilename().equals("")) {
			createConcursoForm.reject(new ValidationError("img_banner", "La imagen no puede ser vacia"));
		}
		if(!tipoArchivo[0].equals(IConstantesSuperVoices.TIPO_ARCHIVO_IMAGEN)){
			createConcursoForm.reject(new ValidationError("img_banner", "El tipo de archivo es incorrecto"));
		}

		if(createConcursoForm.hasErrors()){
			return badRequest(crearconcurso.render(createConcursoForm));
		}
		else {

			GestionAWS gestionS3 = new GestionAWS();
			String rutPublica = gestionS3.subirArchivoAS3((File) uploadFilePart.getFile(), uploadFilePart.getFilename(), 
					formData.get("val_url"), uploadFilePart.getContentType(),false);


			Concurso concurso = new Concurso();
			try {

				concurso.crearConcurso(formData.get("nom_concurso"), rutPublica, formData.get("val_url"), formatoDelTexto.parse(formData.get("fec_inicio")), 
						formatoDelTexto.parse(formData.get("fec_fin")), new Long(formData.get("val_pagar_voz")), formData.get("txt_guion"), formData.get("txt_recomendaciones"));
			} catch (ParseException ex) {

			}
			return redirect(routes.Application.listarConcursos());
		}

	}	

	@Security.Authenticated(Secured.class)
	public Result logout() {
		session().clear();
		flash("success", "You've been logged out");
		return redirect(routes.Application.login());
	}


	@Security.Authenticated(Secured.class)
	public Result listarConcursos(){
		Form<ConcursoFormData> concursoForm = formFactory.form(ConcursoFormData.class);
		Long admin_id = new Long(session().get("admin_id"));
		return ok(listarconcursos.render(concursoForm,ConcursoFormData.getConcursos(admin_id)));
	}
	
	
	public Result detalleConcurso(String val_url){
		Form<DetalleConcursoFormData> detalleConcursoForm = formFactory.form(DetalleConcursoFormData.class);
		DetalleConcursoFormData detalleConcurso = new DetalleConcursoFormData(val_url);
		return ok(detalleconcurso.render(detalleConcursoForm,detalleConcurso.getConcurso(), detalleConcurso.getListaVoces()));
	}

	@Security.Authenticated(Secured.class)	
	public Result eliminarConcurso(Long id){
		Concurso.eliminarConcurso(id);
		return redirect(routes.Application.listarConcursos());
	}
}
