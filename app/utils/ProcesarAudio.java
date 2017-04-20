package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.mail.MessagingException;

import com.amazonaws.services.sqs.model.Message;

import constantes.IConstantesSuperVoices;
import models.Voz;
import play.Logger;
import utils.GestionAWS.SQS;

public class ProcesarAudio {
	private GestionAWS gestiosAWS;
	
	private void crearCarpetasLocales(){
		new File(IConstantesSuperVoices.PATH_ORIGINAL).mkdirs();
		new File(IConstantesSuperVoices.PATH_CONVERTIDA).mkdirs();
	}
	
	/**
	 * 
	 * @param voz
	 */
	private void procesarAudio(Voz voz){
		gestiosAWS = new GestionAWS();
		String rutaVozOriginal = voz.getVal_voz_original();
		String[] arrayRutaAudio = rutaVozOriginal.split("\\/");
		int tamanioArray = arrayRutaAudio.length;
		String nomArchivo = arrayRutaAudio[tamanioArray - 1];
		String extension = nomArchivo.split("\\.")[1];
		String nomArchivoConvertido = "";
		
		Logger.info("Se procesará audio" + voz.getIdVoz() +" con con extensión " + extension);
		if(extension.equals(IConstantesSuperVoices.EXTENSION_MP3)){
			gestiosAWS.copiarAudioARutaConvertidas(voz.getIdVoz() + "." + extension);
			nomArchivoConvertido = nomArchivo;
		}else{
            Runtime rt = Runtime.getRuntime();
            try {
        		Logger.info("Inicia a procesar voz " + voz.getIdVoz());
        		gestiosAWS.descargarAudio(nomArchivo);
        		nomArchivoConvertido = voz.getIdVoz() + "." + "mp3";
          	
        		Logger.info("Convirtiendo el sonido....");
				Process proc = rt.exec("ffmpeg -i " + IConstantesSuperVoices.PATH_ORIGINAL + nomArchivo + " " + 
						IConstantesSuperVoices.PATH_CONVERTIDA + voz.getIdVoz() + "." + "mp3");
                InputStream stderr = proc.getErrorStream();
                InputStreamReader isr = new InputStreamReader(stderr);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                while ( (line = br.readLine()) != null)
                    System.out.println(line);
                int exitVal = proc.waitFor();
                //Logger.warn("Process exitValue: " + exitVal);
                Logger.info("Sonido Convertido");
                File file = new File(IConstantesSuperVoices.PATH_CONVERTIDA + nomArchivoConvertido);
                gestiosAWS.subirArchivoConvertido(file, nomArchivoConvertido, "audio/mp3");
                
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Voz.actualizarVoz(voz.getId(), IConstantesSuperVoices.RUTA_CLOUDFRONT_AUDIOS_CONVERTIDOS + nomArchivoConvertido);
		Correo correo = new Correo();
		try {
			correo.enviarCorreo(voz.getLocutor().getEmail(), voz.getLocutor().getNombres());
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 */
	private void obtenerMensaje(){
		GestionAWS.SQS sqs = new SQS();
		
		while(sqs.requestMessages(1).size()>0){
			for(Message message : sqs.getMessages()){
				String idVoz = message.getBody();
				Voz voz = Voz.findVozByIdVoz(idVoz);
				
				if(voz != null){
					procesarAudio(voz);
					sqs.deleteMessage(message);
				}
				else{
                    Logger.info("La voz con el identificador único " + idVoz + " no fue encontrada ");
                }
				
				
				
			}
		}
		
		if(sqs.requestMessages(1).size()==0){
			Logger.info("No hay voces pendientes por procesar");
		}
	}

	public void iniciarProceso(){
		crearCarpetasLocales();
		obtenerMensaje();
		
	}
	
}
