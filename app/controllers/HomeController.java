package controllers;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.util.JSONSerializers;

import models.Sequences;
import models.User;
import play.mvc.*;
import utils.JSONResultHandler;

import com.mongodb.DBObject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
	//@Security.Authenticated(Secured.class)
    public Result index() {
        return ok(views.html.index.render());
    }

}
