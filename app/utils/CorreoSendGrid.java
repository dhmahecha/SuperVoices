package utils;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

import constantes.IConstantesSuperVoices;
import play.Configuration;
import play.Logger;

public class CorreoSendGrid{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2984872824900129989L;
	
	static final String FROM = "notificaciones SV<info@voicessuper.com>"; 
	static final String SUBJECT = "[SuperVoices] Notificación de contenido";

    /**
     * Send an email
     * @param to
     * @param nombres
     * @throws SendGridException
     * @throws MessagingException
     */

    public void sendEmail(String to, String nombres) {
    	
		String body = "Hola " + nombres + "! tu voz  ha sido publicada en la página publica del concurso.";
        SendGrid sendgrid = new SendGrid(Configuration.root().getString(IConstantesSuperVoices.SENDGRID_API_KEY));
        SendGrid.Email email = new SendGrid.Email();
        email.addTo(to);
        email.setFrom(FROM);
        email.setSubject(SUBJECT);
        email.setHtml(body);
        SendGrid.Response response = null;
        try {
            response = sendgrid.send(email);
        } catch (SendGridException e) {
            e.printStackTrace();
        }
        Logger.info("Correo enviado a " + to);

    }
	
}
