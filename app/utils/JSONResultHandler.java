package utils;

import com.mongodb.DBObject;
import com.mongodb.util.JSONSerializers;
import org.jongo.ResultHandler;

public class JSONResultHandler implements ResultHandler {
    
   public String map(DBObject result) {
         return JSONSerializers.getStrict().serialize(result);
     }
   
}