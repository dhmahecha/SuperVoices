package models;

import java.util.Date;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import constantes.IConstantesSuperVoices;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import play.Play;
import play.api.libs.json.Json;
import uk.co.panaxiom.playjongo.PlayJongo;

public class User{

	public static PlayJongo jongo = Play.application().injector().instanceOf(PlayJongo.class);
	
	
	public static MongoCollection users(){
		//MongoClientURI uri = new 
		//MongoClientURI("mongodb://admin:admin1234@cluster0-shard-00-02-bihvf.mongodb.net:27017,cluster0-shard-00-01-bihvf.mongodb.net:27017,cluster0-shard-00-02-bihvf.mongodb.net:27017/SuperVoices?authSource=admin");
		
		//MongoClient mongoClient = new MongoClient(uri);
		//DB database = mongoClient.getDB("SuperVoices");
		
		//Jongo jongo = new Jongo(database);
		return jongo.getCollection("auth_user");
	}

	
    @JsonProperty("_id")
    private ObjectId _id;
    private Long id;
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private Date date_joined;
    private String password;
    private boolean is_active;
    private boolean is_superuser;
    private boolean is_staff;
    private Date last_login;

	public User(String username, String first_name, String last_name, String email, String password, 
			boolean is_superuser) {
		super();
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.is_superuser = is_superuser;
	}
	
	public User(){
		
	}

	public User insert() {
		this.id = Sequences.getNextSequenceValue(IConstantesSuperVoices.SECUENCIA_USER);
		this.date_joined = new Date();
		this.is_active = true;
		this.is_staff = true;
		this.last_login = new Date();
        users().save(this);
        return this;
    }

    public void remove() {
         users().remove(_id);
    }

    
    public static User findByUserName(String username) {
        return  users().findOne("{username: #}", username).as(User.class);
    }
    
    public static User findByEmail(String email) {
        return  users().findOne("{email: #}", email).as(User.class);
    }    
	
	public User findUserById(Long id){
		return users().findOne("{id: #}", id).as(User.class);
	}
	
	public User findUserBy_Id(ObjectId _id){
		return users().findOne("{_id: #}", _id).as(User.class);
	}

	public String getUsername() {
		return username;
	}

	public Long getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getEmail() {
		return email;
	}

	public Date getDate_joined() {
		return date_joined;
	}

	public String getPassword() {
		return password;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public boolean isIs_superuser() {
		return is_superuser;
	}

	public void setIs_superuser(boolean is_superuser) {
		this.is_superuser = is_superuser;
	}

	public boolean isIs_staff() {
		return is_staff;
	}

	public void setIs_staff(boolean is_staff) {
		this.is_staff = is_staff;
	}

	public Date isLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDate_joined(Date date_joined) {
		this.date_joined = date_joined;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
