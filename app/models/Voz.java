package models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.jongo.QueryModifier;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

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

	public static Voz findVozByIdVoz(String idVoz){
		return voces().findOne("{idVoz: #}", idVoz).as(Voz.class);
	}
	
	public static MongoCursor<Voz> findVocesByConcurso_id(Long concurso_id){
		return voces().find("{ concurso_id:"+ concurso_id+"}").as(Voz.class);
	}
	
	
	public static void queryModifier(){
		voces().find("{ind_estado:"+ Estado.EN_PROCESO.getCodEstado() +"}").with(new QueryModifier() {
			@Override
			public void modify(DBCursor cursor) {
			    if(cursor.hasNext()) {
			        DBObject obj = cursor.next();
			        voces().update("{id:"+obj.get("id")+"}").with("{$set: {ind_estado: #}}", new Integer(Estado.CONVERTIDA.getCodEstado()));
			     }
				
			}
		}).as(Voz.class);
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

	public Voz insert() {
		this.id = Sequences.getNextSequenceValue(IConstantesSuperVoices.SECUENCIA_VOZ);
		this.locutor = Locutor.findLocutorById(locutor_id);
		this.ind_estado = Estado.EN_PROCESO.getCodEstado();
		this.fec_subida = new Date();
		voces().save(this);
        return this;
    }	
	
    public static void actualizarVoz(Long id, String val_voz_convertida){
    	voces().update("{id:"+ id +"}").with("{$set: {ind_estado: #}}", new Integer(Estado.CONVERTIDA.getCodEstado() ));
    	voces().update("{id:"+ id +"}").with("{$set: {val_voz_convertida: #}}", val_voz_convertida);
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
