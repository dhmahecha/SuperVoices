package views.formdata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.jongo.MongoCursor;
import org.mindrot.jbcrypt.BCrypt;

import models.Administrador;
import models.Concurso;
import models.User;
import play.data.validation.Constraints;
import play.data.validation.ValidationError;

public class ConcursoFormData {
	
	/** The submitted nom_concurso. */
	@Constraints.Required	
	private String nom_concurso = "";
	/** The submitted img_banner. */
	private String img_banner = "";
	@Constraints.Required	  
	private String val_url = "";
	@Constraints.Required	
	private Date fec_inicio;
	@Constraints.Required	
	private Date fec_fin;
	@Constraints.Required
	private Long val_pagar_voz;
	@Constraints.Required
	private String txt_guion;
	@Constraints.Required
	private String txt_recomendaciones;	
	

	public static List<Concurso> getConcursos(Long administrador_id){
		
		MongoCursor<Concurso> cursor = Concurso.findConcursoByAdmin_id(administrador_id);

		try{
			List<Concurso> listaConcursos = new ArrayList<Concurso>();
			while(cursor.hasNext()){
				Concurso concurso = cursor.next();
				listaConcursos.add(concurso);
			}
			return listaConcursos;
		}
		finally {
			try {
				cursor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	public List<ValidationError> validate(){
	
		
		List<ValidationError> errors = new ArrayList<ValidationError>();
		
		if(Concurso.findConcursoByNom_concurso(nom_concurso) != null){
			errors.add(new ValidationError("Nombre del concurso", "El Nombre del concurso ya existe"));
			return errors;
		}
		if(Concurso.findConcursoByNom_concurso(val_url) != null){
			errors.add(new ValidationError("URL del concurso", "Esta URL ya esta siendo usada"));
			return errors;
		}
		Concurso concurso = new Concurso();
		
		concurso.crearConcurso(nom_concurso, img_banner, val_url, fec_inicio, fec_fin, val_pagar_voz, txt_guion, txt_recomendaciones);
		if (concurso == null) {
			errors.add(new ValidationError("Error al crear el Concurso", "Se Presento un error al crear el Concurso"));
			return errors;
		}
		return null;
	}

	public String getImg_banner() {
		return img_banner;
	}


	public void setImg_banner(String img_banner) {
		this.img_banner = img_banner;
	}


	public String getVal_url() {
		return val_url;
	}


	public void setVal_url(String val_url) {
		this.val_url = val_url;
	}


	public Date getFec_inicio() {
		return fec_inicio;
	}


	public void setFec_inicio(Date fec_inicio) {
		this.fec_inicio = fec_inicio;
	}


	public Date getFec_fin() {
		return fec_fin;
	}


	public void setFec_fin(Date fec_fin) {
		this.fec_fin = fec_fin;
	}


	public Long getVal_pagar_voz() {
		return val_pagar_voz;
	}


	public void setVal_pagar_voz(Long val_pagar_voz) {
		this.val_pagar_voz = val_pagar_voz;
	}


	public String getTxt_guion() {
		return txt_guion;
	}


	public void setTxt_guion(String txt_guion) {
		this.txt_guion = txt_guion;
	}


	public String getTxt_recomendaciones() {
		return txt_recomendaciones;
	}


	public void setTxt_recomendaciones(String txt_recomendaciones) {
		this.txt_recomendaciones = txt_recomendaciones;
	}


	public String getNom_concurso() {
		return nom_concurso;
	}


	public void setNom_concurso(String nom_concurso) {
		this.nom_concurso = nom_concurso;
	}
	
	
	
}
