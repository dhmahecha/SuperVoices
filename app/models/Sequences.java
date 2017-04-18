package models;

import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

import com.fasterxml.jackson.annotation.JsonProperty;

import play.Play;
import uk.co.panaxiom.playjongo.PlayJongo;

public class Sequences {
	public static PlayJongo jongo = Play.application().injector().instanceOf(PlayJongo.class);
	public static MongoCollection seqUser(){
		return jongo.getCollection("seq_user");
	}
	
    @JsonProperty("_id")
    private ObjectId _id;
    private Long sequence_value;
    private String sequence_name;
	
    public static Long getNextSequenceValue(String seqName) {
    	seqUser().update("{sequence_name:'" + seqName +"'}").with("{$inc: {sequence_value: 1}}");
    	Long secuencia = seqUser().findOne("{sequence_name:'" + seqName +"'}").as(Sequences.class).getSequence_value();
        return secuencia;
    }

	public Long getSequence_value() {
		return sequence_value;
	}

	public void setSequence_value(Long sequence_value) {
		this.sequence_value = sequence_value;
	}

	public String getSequence_name() {
		return sequence_name;
	}

	public void setSequence_name(String sequence_name) {
		this.sequence_name = sequence_name;
	}
}
