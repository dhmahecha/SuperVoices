package views.formdata;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import models.Administrador;
import models.User;
import play.data.validation.Constraints;
import play.data.validation.ValidationError;

public class CreateAdminFormData {

	/** The submitted username. */
	@Constraints.Required	
	private String username = "";
	/** The submitted password. */
	@Constraints.Required	  
	private String password = "";
	@Constraints.Required	
	private String first_name;
	@Constraints.Required	
	private String last_name;
	@Constraints.Email
	@Constraints.Required
	private String email;
	

	/** Required for form instantiation. */
	public CreateAdminFormData() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public List<ValidationError> validate(){
		List<ValidationError> errors = new ArrayList<ValidationError>();
		
		if(User.findByUserName(username) != null){
			errors.add(new ValidationError("username", "El username ya existe"));
			return errors;
		}
		if(User.findByEmail(email) != null){
			errors.add(new ValidationError("email", "El email ya existe"));
			return errors;
		}
		
		String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt()); 
		Administrador administrador = new Administrador();
		administrador.crearAdministrador(username, pw_hash, first_name, last_name, email);
		if (administrador == null) {
			errors.add(new ValidationError("Error al crear el Administrador", "Se Presento un error al crear el Administrador"));
			return errors;
		}
		return null;
	}

}
