package models;

import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

import com.fasterxml.jackson.annotation.JsonProperty;

import constantes.IConstantesSuperVoices;
import play.Play;
import uk.co.panaxiom.playjongo.PlayJongo;

public class Locutor {
	
	public static PlayJongo jongo = Play.application().injector().instanceOf(PlayJongo.class);
	
	public static MongoCollection locutores(){
		return jongo.getCollection("web_locutor");
	}
	
    @JsonProperty("_id")
    private ObjectId _id;
    private Long id;
    private String nombres;
    private String apellidos;
    private String email;
    
	public static Locutor findLocutorById(Long id){
		return locutores().findOne("{id: #}", id).as(Locutor.class);
	}
	
	public static Locutor findLocutorByEmail(String email){
		return locutores().findOne("{email: #}", email).as(Locutor.class);
	}
	
	public Locutor(String nombres, String apellidos, String email){
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
	}

	public Locutor(String nombres, String apellidos, String email, Long id){
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.id = id;
	}
	
	public Locutor(){
	}
	
	public Locutor insert() {
		this.id = Sequences.getNextSequenceValue(IConstantesSuperVoices.SECUENCIA_LOCUTOR);
		locutores().save(this);
        return this;
    }	
	
	
    public  Locutor crearLocutor(String nombres, String apellidos, String email) {
    	this.insert();
        return this;
    }
		
    public Locutor actualizarLocutor(){
    	locutores().update("{id: #}", id).with(this);
    	return this;
    }
    

	public Long getId() {
		return id;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return email;
	}

}
