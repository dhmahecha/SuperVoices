
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import akka.actor.Cancellable;
import play.*;
import play.libs.Akka;
import scala.concurrent.duration.Duration;



public class Global extends GlobalSettings {

	private Cancellable scheduler;
	
	public void onStart(Application application) {
	    int timeDelayFromAppStartToLogFirstLogInMs = 0;
	    int timeGapBetweenMemoryLogsInMinutes = 30;
	    scheduler = Akka.system().scheduler().schedule(Duration.create(timeDelayFromAppStartToLogFirstLogInMs, TimeUnit.MILLISECONDS),
	            Duration.create(timeGapBetweenMemoryLogsInMinutes, TimeUnit.SECONDS),
	            new Runnable() {
	                @Override
	                public void run() {
	                	try {
	                        Runtime rt = Runtime.getRuntime();
	                        Process proc = rt.exec("ffmpeg");
	                        InputStream stderr = proc.getErrorStream();
	                        InputStreamReader isr = new InputStreamReader(stderr);
	                        BufferedReader br = new BufferedReader(isr);
	                        String line = null;
	                        System.out.println("<ERROR>");
	                        while ( (line = br.readLine()) != null)
	                            System.out.println(line);
	                        System.out.println("</ERROR>");
	                        int exitVal = proc.waitFor();
	                        System.out.println("Process exitValue: " + exitVal);
						} catch (IOException | InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                	System.out.println("Corriendo tarea programada");
	                }
	            },
	            Akka.system().dispatcher());
	    super.onStart(application);
	}
  	    
 

    public void onStop(Application app) {
        scheduler.cancel();
        super.onStop(app);
    }
	
}