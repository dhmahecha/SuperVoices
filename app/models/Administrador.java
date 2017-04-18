package models;

import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

import com.fasterxml.jackson.annotation.JsonProperty;

import constantes.IConstantesSuperVoices;
import play.Play;
import uk.co.panaxiom.playjongo.PlayJongo;

public class Administrador {
	public static PlayJongo jongo = Play.application().injector().instanceOf(PlayJongo.class);
	
	public static MongoCollection administradores(){
		return jongo.getCollection("web_administrador");
	}
	
    @JsonProperty("_id")
    private ObjectId _id;
    private Long id;
    private Long user_id;
    private User user;
    
    public Administrador(){
    	
    }

    public Administrador(Long user_id, User user){
    	this.user_id = user_id;
    	this.user = user;
    }
    
	public Administrador findAdministradorById(Long id){
		return administradores().findOne("{id: #}", id).as(Administrador.class);
	}
	
	public static Administrador findAdministradorByUser_id(Long user_id){
		return administradores().findOne("{user_id: #}", user_id).as(Administrador.class);
	}
	
	public Administrador insert() {
		this.id = Sequences.getNextSequenceValue(IConstantesSuperVoices.SECUENCIA_ADMINISTRADOR);
		administradores().save(this);
        return this;
    }

	public User getUser() {
		user = new User().findUserById(user_id);
		return user;
	}
	
    public  User authenticate(String username, String password) {
        return new User().findByUserName(username);
    }
    
    public  Administrador crearAdministrador(String username, String password, String first_name, 
    		String last_name, String email) {
    	
    	User user = new User(username,first_name,last_name,email,password,false);
    	user.insert();
    	
    	Administrador administrador = new Administrador(user.getId(),user);
    	administrador.insert();
    	
        return administrador;
    }
    
	public Long getId() {
		return id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
