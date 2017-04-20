package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.fasterxml.jackson.annotation.JsonProperty;

import constantes.IConstantesSuperVoices;
import enums.Estado;
import play.Play;
import uk.co.panaxiom.playjongo.PlayJongo;

public class Concurso {
	public static PlayJongo jongo = Play.application().injector().instanceOf(PlayJongo.class);

	public static MongoCollection concursos(){
		return jongo.getCollection("web_concurso");
	}

	@JsonProperty("_id")
	private ObjectId _id;
	private Long id;
	private String nom_concurso;
	private String img_banner;
	private String val_url;
	private Date fec_inicio;
	private Date fec_fin; 
	private Long val_pagar_voz;
	private String txt_guion;
	private String txt_recomendaciones;
	private Long administrador_id;
	private ArrayList<Integer> voz_id;
	private String ind_estado;

	
	public Concurso(){
		
	}

	public Concurso(String nom_concurso, String img_banner, String val_url, Date fec_inicio, Date fec_fin,
			Long val_pagar_voz, String txt_guion, String txt_recomendaciones) {
		super();
		this.nom_concurso = nom_concurso;
		this.img_banner = img_banner;
		this.val_url = val_url;
		this.fec_inicio = fec_inicio;
		this.fec_fin = fec_fin;
		this.val_pagar_voz = val_pagar_voz;
		this.txt_guion = txt_guion;
		this.txt_recomendaciones = txt_recomendaciones;
	}

	public Concurso findConcursoById(Integer id){
		return concursos().findOne("{id: #}", id).as(Concurso.class);
	}

	public static Concurso findConcursoByNom_concurso(String nom_concurso){
		return concursos().findOne("{nom_concurso: #}", nom_concurso).as(Concurso.class);
	}
	
	public static Concurso findConcursoByVal_url(String val_url){
		return concursos().findOne("{val_url: #}", val_url).as(Concurso.class);
	}	

	public MongoCursor<Concurso> findAllConcursos(){
		return concursos().find().as(Concurso.class);
	}
	
	public static MongoCursor<Concurso> findConcursoByAdmin_id(Long administrador_id){
		return concursos().find("{administrador_id:#, ind_estado:#}",  administrador_id, "A" ).as(Concurso.class);
	}
	
	
    public  Concurso crearConcurso(String nom_concurso, String img_banner, String val_url, 
    		Date fec_inicio, Date fec_fin, Long val_pagar_voz, String txt_guion, String txt_recomendaciones) {
    	
    	Concurso concurso = new  Concurso(nom_concurso,img_banner,val_url,fec_inicio,fec_fin,val_pagar_voz, 
    			txt_guion, txt_recomendaciones);
    	concurso.insert();
        return concurso;
    }
    
	public Concurso insert() {
		this.id = Sequences.getNextSequenceValue(IConstantesSuperVoices.SECUENCIA_CONCURSO);
		this.administrador_id = new Long(play.mvc.Http.Context.current().session().get("admin_id").toString());
		this.ind_estado = "A";
		concursos().save(this);
        return this;
    }
	
	public static void eliminarConcurso(Long id) {
    	concursos().update("{id:"+ id +"}").with("{$set: {ind_estado: #}}", "I");
	}

	public Long getId() {
		return id;
	}



	public String getNom_concurso() {
		return nom_concurso;
	}



	public String getImg_banner() {
		return img_banner;
	}



	public String getVal_url() {
		return val_url;
	}



	public Date getFec_inicio() {
		return fec_inicio;
	}



	public Date getFec_fin() {
		return fec_fin;
	}



	public Long getVal_pagar_voz() {
		return val_pagar_voz;
	}



	public String getTxt_recomendaciones() {
		return txt_recomendaciones;
	}


	public String getTxt_guion() {
		return txt_guion;
	}
	
	
	

	public Long getAdministrador_id() {
		return administrador_id;
	}


	public void setAdministrador_id(Long administrador_id) {
		this.administrador_id = administrador_id;
	}


	public ArrayList<Integer> getVoz_id() {
		return voz_id;
	}


	public void setVoz_id(ArrayList<Integer> voz_id) {
		this.voz_id = voz_id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setNom_concurso(String nom_concurso) {
		this.nom_concurso = nom_concurso;
	}


	public void setImg_banner(String img_banner) {
		this.img_banner = img_banner;
	}


	public void setVal_url(String val_url) {
		this.val_url = val_url;
	}


	public void setFec_inicio(Date fec_inicio) {
		this.fec_inicio = fec_inicio;
	}


	public void setFec_fin(Date fec_fin) {
		this.fec_fin = fec_fin;
	}


	public void setVal_pagar_voz(Long val_pagar_voz) {
		this.val_pagar_voz = val_pagar_voz;
	}


	public void setTxt_guion(String txt_guion) {
		this.txt_guion = txt_guion;
	}


	public void setTxt_recomendaciones(String txt_recomendaciones) {
		this.txt_recomendaciones = txt_recomendaciones;
	}

	public String getInd_estado() {
		return ind_estado;
	}

	public void setInd_estado(String ind_estado) {
		this.ind_estado = ind_estado;
	}

	public Collection<Voz> getVoz() {
		Collection<Voz> voz = new ArrayList<Voz>(); 
		for(Integer id:voz_id){
			voz.add(new Voz().findVozById(id));
		}

		return voz; 
	}	

}
