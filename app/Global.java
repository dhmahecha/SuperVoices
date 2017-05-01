import java.util.concurrent.TimeUnit;
import akka.actor.Cancellable;
import constantes.IConstantesSuperVoices;
import play.Application;
import play.Configuration;
import play.GlobalSettings;
import play.Logger;
import play.Play;
import play.libs.Akka;
import scala.concurrent.duration.Duration;
import utils.ProcesarAudio;



@SuppressWarnings("deprecation")
public class Global extends GlobalSettings {

	private Cancellable scheduler;

	public void onStart(Application application) {
		Logger.info("Se esta corriendo sobre un servidor: " + System.getProperty("processtype"));
		//if(Configuration.root().getString(IConstantesSuperVoices.ES_WORKER).equals("true")){
		if(System.getProperty("processtype").equals("worker")){
			int timeDelayFromAppStartToLogFirstLogInMs = 0;
			int timeGapBetweenMemoryLogsInMinutes = 30;
			scheduler = Akka.system().scheduler().schedule(Duration.create(timeDelayFromAppStartToLogFirstLogInMs, TimeUnit.MILLISECONDS),
					Duration.create(timeGapBetweenMemoryLogsInMinutes, TimeUnit.SECONDS),
					new Runnable() {
				@Override
				public void run() {
					Logger.warn("Tarea programada en ejecución");
					ProcesarAudio procesar = new ProcesarAudio();
					procesar.iniciarProceso();
				}
			},
					Akka.system().dispatcher());
			super.onStart(application);
		}
	}



	public void onStop(Application app) {
		if(Configuration.root().getString(IConstantesSuperVoices.ES_WORKER).equals("true")){
			scheduler.cancel();
			super.onStop(app);
		}
	}

}