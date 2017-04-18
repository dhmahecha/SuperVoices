
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Diego/ProyectosplayJava/supervoices/conf/routes
// @DATE:Sat Apr 15 20:35:58 COT 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseLocutorController LocutorController = new controllers.ReverseLocutorController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseVozController VozController = new controllers.ReverseVozController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAdministradorController AdministradorController = new controllers.ReverseAdministradorController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseConcursoController ConcursoController = new controllers.ReverseConcursoController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseLocutorController LocutorController = new controllers.javascript.ReverseLocutorController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseVozController VozController = new controllers.javascript.ReverseVozController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAdministradorController AdministradorController = new controllers.javascript.ReverseAdministradorController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseConcursoController ConcursoController = new controllers.javascript.ReverseConcursoController(RoutesPrefix.byNamePrefix());
  }

}
