package views.formdata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jongo.MongoCursor;

import enums.Estado;
import models.Concurso;
import models.Voz;

public class DetalleConcursoFormData {
	
	private Concurso concurso;
	private List<Voz> listaVoces;
	private String val_url;
	
	public DetalleConcursoFormData(String val_url) {
		super();
		this.val_url = val_url;
		iniciar();
	}	

	public DetalleConcursoFormData() {
		super();
	}

	public void iniciar(){
		concurso = Concurso.findConcursoByVal_url(val_url);
		MongoCursor<Voz> cursor = Voz.findVocesByConcurso_id(concurso.getId());		 
		try{
			listaVoces = new ArrayList<Voz>();
			while(cursor.hasNext()){
				Voz voz = cursor.next();
				System.out.println(voz.getInd_estado());
				if(voz.getInd_estado().equals(Estado.CONVERTIDA.getCodEstado())){
					listaVoces.add(voz);
				}
			}
		}
		finally {
			try {
				cursor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public Concurso getConcurso() {
		return concurso;
	}

	public List<Voz> getListaVoces() {
		return listaVoces;
	}	
}