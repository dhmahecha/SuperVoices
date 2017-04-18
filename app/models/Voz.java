package models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.fasterxml.jackson.annotation.JsonProperty;

import constantes.IConstantesSuperVoices;
import enums.Estado;
import play.Play;
import uk.co.panaxiom.playjongo.PlayJongo;

public class Voz {
	
	public static PlayJongo jongo = Play.application().injector().instanceOf(PlayJongo.class);

	public static MongoCollection voces(){
		return jongo.getCollection("web_voz");
	}
	
    @JsonProperty("_id")
    private ObjectId _id;
    private Long id;
    private String idVoz;
    private String val_voz_original;
    private String val_voz_convertida;
    private Integer ind_estado;
    private Date fec_subida;
    private String txt_observaciones;
    private Locutor locutor;
    private Long locutor_id;
    private Long concurso_id;
    
    
	public static Voz findVozById(Integer id){
		return voces().findOne("{id: #}", id).as(Voz.class);
	}
	
	public static MongoCursor<Voz> findVocesByConcurso_id(Long concurso_id){
		return voces().find("{ concurso_id:"+ concurso_id+"}").as(Voz.class);
	}
	
	public Voz(){
		
	}
	
    public Voz(String val_voz_original, String txt_observaciones, Long locutor_id,
			Long concurso_id, String idVoz) {
		super();
		this.val_voz_original = val_voz_original;
		this.txt_observaciones = txt_observaciones;
		this.locutor_id = locutor_id;
		this.concurso_id = concurso_id;
		this.idVoz = idVoz;
	}

	/*public  Voz crearVoz(String nom_concurso, String img_banner, String val_url, 
    		Date fec_inicio, Date fec_fin, Long val_pagar_voz, String txt_guion, String txt_recomendaciones) {
    	
    	Concurso concurso = new  Concurso(nom_concurso,img_banner,val_url,fec_inicio,fec_fin,val_pagar_voz, 
    			txt_guion, txt_recomendaciones);
    	concurso.insert();
        return concurso;
    }*/
	

	public Voz insert() {
		this.id = Sequences.getNextSequenceValue(IConstantesSuperVoices.SECUENCIA_VOZ);
		this.locutor = Locutor.findLocutorById(locutor_id);
		this.ind_estado = Estado.EN_PROCESO.getCodEstado();
		this.fec_subida = new Date();
		voces().save(this);
        return this;
    }	
	
	
	public Long getId() {
		return id;
	}

	public String getIdVoz() {
		return idVoz;
	}



	public String getVal_voz_original() {
		return val_voz_original;
	}



	public String getVal_voz_convertida() {
		return val_voz_convertida;
	}



	public Integer getInd_estado() {
		return ind_estado;
	}



	public Date getFec_subida() {
		return fec_subida;
	}


	public String getTxt_observaciones() {
		return txt_observaciones;
	}

	public Locutor getLocutor() {
		return locutor;
	}

	public Long getConcurso_id() {
		return concurso_id;
	}

	
	
}
