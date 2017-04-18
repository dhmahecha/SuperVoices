package views.formdata;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import play.data.validation.Constraints;

import models.Administrador;
import models.User;

/**
 * Backing class for the login form.
 */
public class LoginFormData {

	/** The submitted username. */
	@Constraints.Required	
	public String username = "";
	/** The submitted password. */
	@Constraints.Required	  
	public String password = "";

	/** Required for form instantiation. */
	public LoginFormData() {
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


	public List<ValidationError> validate(){
        List<ValidationError> errors = new ArrayList<ValidationError>();
		Administrador administrador = new Administrador();
		
		User user = administrador.authenticate(username, password);
		if (user == null) {
			errors.add(new ValidationError("username", "Usario incorrecto"));
			return errors;
		}
		else{
			if(!BCrypt.checkpw(password, user.getPassword())){
				errors.add(new ValidationError("password", "Password incorrecto"));
				return errors;
			}
		}
		return null;
	}

}
