package utils;
import javax.mail.*;
import javax.mail.internet.*;

import constantes.IConstantesSuperVoices;
import play.Configuration;
import play.Logger;

import java.util.Properties;

public class Correo {

	static final int PORT = 25;

	static final String FROM = "notificaciones SV<voicessuper@gmail.com>"; 

	static final String SUBJECT = "[SuperVoices] Notificación de contenido";

	// Supply your SMTP credentials below. Note that your SMTP credentials are different from your AWS credentials.
	static final String SMTP_USERNAME = Configuration.root().getString(IConstantesSuperVoices.EMAIL_HOST_USER); 
	static final String SMTP_PASSWORD = Configuration.root().getString(IConstantesSuperVoices.EMAIL_HOST_PASSWORD); 

	static final String HOST = Configuration.root().getString(IConstantesSuperVoices.EMAIL_HOST_NAME);   

	public void enviarCorreo(String to, String nombres) throws MessagingException{
		
		String body = "Hola " + nombres + "! tu voz  ha sido publicada en la página publica del concurso.";
		
		Transport transport = null;
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtp.port", PORT); 

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");

		// Create a Session object to represent a mail session with the specified properties. 
		Session session = Session.getDefaultInstance(props);

		try {

			 transport = session.getTransport();
			MimeMessage msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(FROM));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(SUBJECT);
			msg.setContent(body,"text/plain");

			// Create a transport.        

			Logger.info("Attempting to send an email through the Amazon SES SMTP interface...");

			// Connect to Amazon SES using the SMTP username and password you specified above.
			transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

			// Send the email.
			transport.sendMessage(msg, msg.getAllRecipients());
			System.out.println("Email sent!");



		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally
        {
            // Close and terminate the connection.
            transport.close();        	
        }

	}

}
