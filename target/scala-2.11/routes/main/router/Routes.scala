
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Diego/ProyectosplayJava/supervoices/conf/routes
// @DATE:Sat Apr 15 20:35:58 COT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:7
  Application_7: controllers.Application,
  // @LINE:19
  Assets_5: controllers.Assets,
  // @LINE:21
  UserController_2: controllers.UserController,
  // @LINE:22
  AdministradorController_4: controllers.AdministradorController,
  // @LINE:23
  ConcursoController_3: controllers.ConcursoController,
  // @LINE:25
  LocutorController_6: controllers.LocutorController,
  // @LINE:29
  VozController_1: controllers.VozController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:7
    Application_7: controllers.Application,
    // @LINE:19
    Assets_5: controllers.Assets,
    // @LINE:21
    UserController_2: controllers.UserController,
    // @LINE:22
    AdministradorController_4: controllers.AdministradorController,
    // @LINE:23
    ConcursoController_3: controllers.ConcursoController,
    // @LINE:25
    LocutorController_6: controllers.LocutorController,
    // @LINE:29
    VozController_1: controllers.VozController
  ) = this(errorHandler, HomeController_0, Application_7, Assets_5, UserController_2, AdministradorController_4, ConcursoController_3, LocutorController_6, VozController_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Application_7, Assets_5, UserController_2, AdministradorController_4, ConcursoController_3, LocutorController_6, VozController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Application.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Application.authenticate()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """formadmin""", """controllers.Application.formadmin()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """crearadmin""", """controllers.Application.crearAdministrador()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.Application.logout()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """listarconcursos""", """controllers.Application.listarConcursos()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """formconcurso""", """controllers.Application.formConcurso()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """crearconcurso""", """controllers.Application.crearConcurso()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminconcursos""", """controllers.Application.adminConcursos()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """detalleconcurso/""" + "$" + """val_url<[^/]+>""", """controllers.Application.detalleConcurso(val_url:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """id<[^/]+>""", """controllers.UserController.user(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """administrador/""" + "$" + """id<[^/]+>""", """controllers.AdministradorController.administrador(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """concurso/""" + "$" + """id<[^/]+>""", """controllers.ConcursoController.concurso(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """locutorByEmail/""" + "$" + """email<[^/]+>""", """controllers.LocutorController.locutorByEmail(email:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """guardarlocutor""", """controllers.LocutorController.guardarLocutor()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """actualizarLocutor/""" + "$" + """id<[^/]+>""", """controllers.LocutorController.actualizarLocutor(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """guardarvoz""", """controllers.VozController.guardarVoz()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_login1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Application_login1_invoker = createInvoker(
    Application_7.login(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "login",
      Nil,
      "GET",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Application_authenticate2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Application_authenticate2_invoker = createInvoker(
    Application_7.authenticate(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "authenticate",
      Nil,
      "POST",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_formadmin3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("formadmin")))
  )
  private[this] lazy val controllers_Application_formadmin3_invoker = createInvoker(
    Application_7.formadmin(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "formadmin",
      Nil,
      "GET",
      """""",
      this.prefix + """formadmin"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_crearAdministrador4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("crearadmin")))
  )
  private[this] lazy val controllers_Application_crearAdministrador4_invoker = createInvoker(
    Application_7.crearAdministrador(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "crearAdministrador",
      Nil,
      "POST",
      """""",
      this.prefix + """crearadmin"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_logout5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_Application_logout5_invoker = createInvoker(
    Application_7.logout(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "logout",
      Nil,
      "GET",
      """""",
      this.prefix + """logout"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Application_listarConcursos6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("listarconcursos")))
  )
  private[this] lazy val controllers_Application_listarConcursos6_invoker = createInvoker(
    Application_7.listarConcursos(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "listarConcursos",
      Nil,
      "GET",
      """""",
      this.prefix + """listarconcursos"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Application_formConcurso7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("formconcurso")))
  )
  private[this] lazy val controllers_Application_formConcurso7_invoker = createInvoker(
    Application_7.formConcurso(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "formConcurso",
      Nil,
      "GET",
      """""",
      this.prefix + """formconcurso"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Application_crearConcurso8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("crearconcurso")))
  )
  private[this] lazy val controllers_Application_crearConcurso8_invoker = createInvoker(
    Application_7.crearConcurso(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "crearConcurso",
      Nil,
      "POST",
      """""",
      this.prefix + """crearconcurso"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Application_adminConcursos9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminconcursos")))
  )
  private[this] lazy val controllers_Application_adminConcursos9_invoker = createInvoker(
    Application_7.adminConcursos(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "adminConcursos",
      Nil,
      "GET",
      """""",
      this.prefix + """adminconcursos"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_Application_detalleConcurso10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("detalleconcurso/"), DynamicPart("val_url", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_detalleConcurso10_invoker = createInvoker(
    Application_7.detalleConcurso(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "detalleConcurso",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """detalleconcurso/""" + "$" + """val_url<[^/]+>"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_Assets_versioned11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned11_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_UserController_user12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_user12_invoker = createInvoker(
    UserController_2.user(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "user",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """user/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_AdministradorController_administrador13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("administrador/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdministradorController_administrador13_invoker = createInvoker(
    AdministradorController_4.administrador(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdministradorController",
      "administrador",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """administrador/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_ConcursoController_concurso14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("concurso/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ConcursoController_concurso14_invoker = createInvoker(
    ConcursoController_3.concurso(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ConcursoController",
      "concurso",
      Seq(classOf[Integer]),
      "GET",
      """""",
      this.prefix + """concurso/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_LocutorController_locutorByEmail15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("locutorByEmail/"), DynamicPart("email", """[^/]+""",true)))
  )
  private[this] lazy val controllers_LocutorController_locutorByEmail15_invoker = createInvoker(
    LocutorController_6.locutorByEmail(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LocutorController",
      "locutorByEmail",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """locutorByEmail/""" + "$" + """email<[^/]+>"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_LocutorController_guardarLocutor16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("guardarlocutor")))
  )
  private[this] lazy val controllers_LocutorController_guardarLocutor16_invoker = createInvoker(
    LocutorController_6.guardarLocutor(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LocutorController",
      "guardarLocutor",
      Nil,
      "POST",
      """""",
      this.prefix + """guardarlocutor"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_LocutorController_actualizarLocutor17_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("actualizarLocutor/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_LocutorController_actualizarLocutor17_invoker = createInvoker(
    LocutorController_6.actualizarLocutor(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LocutorController",
      "actualizarLocutor",
      Seq(classOf[Long]),
      "PUT",
      """""",
      this.prefix + """actualizarLocutor/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:29
  private[this] lazy val controllers_VozController_guardarVoz18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("guardarvoz")))
  )
  private[this] lazy val controllers_VozController_guardarVoz18_invoker = createInvoker(
    VozController_1.guardarVoz(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VozController",
      "guardarVoz",
      Nil,
      "POST",
      """""",
      this.prefix + """guardarvoz"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:7
    case controllers_Application_login1_route(params) =>
      call { 
        controllers_Application_login1_invoker.call(Application_7.login())
      }
  
    // @LINE:8
    case controllers_Application_authenticate2_route(params) =>
      call { 
        controllers_Application_authenticate2_invoker.call(Application_7.authenticate())
      }
  
    // @LINE:9
    case controllers_Application_formadmin3_route(params) =>
      call { 
        controllers_Application_formadmin3_invoker.call(Application_7.formadmin())
      }
  
    // @LINE:10
    case controllers_Application_crearAdministrador4_route(params) =>
      call { 
        controllers_Application_crearAdministrador4_invoker.call(Application_7.crearAdministrador())
      }
  
    // @LINE:11
    case controllers_Application_logout5_route(params) =>
      call { 
        controllers_Application_logout5_invoker.call(Application_7.logout())
      }
  
    // @LINE:12
    case controllers_Application_listarConcursos6_route(params) =>
      call { 
        controllers_Application_listarConcursos6_invoker.call(Application_7.listarConcursos())
      }
  
    // @LINE:13
    case controllers_Application_formConcurso7_route(params) =>
      call { 
        controllers_Application_formConcurso7_invoker.call(Application_7.formConcurso())
      }
  
    // @LINE:14
    case controllers_Application_crearConcurso8_route(params) =>
      call { 
        controllers_Application_crearConcurso8_invoker.call(Application_7.crearConcurso())
      }
  
    // @LINE:15
    case controllers_Application_adminConcursos9_route(params) =>
      call { 
        controllers_Application_adminConcursos9_invoker.call(Application_7.adminConcursos())
      }
  
    // @LINE:16
    case controllers_Application_detalleConcurso10_route(params) =>
      call(params.fromPath[String]("val_url", None)) { (val_url) =>
        controllers_Application_detalleConcurso10_invoker.call(Application_7.detalleConcurso(val_url))
      }
  
    // @LINE:19
    case controllers_Assets_versioned11_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned11_invoker.call(Assets_5.versioned(path, file))
      }
  
    // @LINE:21
    case controllers_UserController_user12_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_user12_invoker.call(UserController_2.user(id))
      }
  
    // @LINE:22
    case controllers_AdministradorController_administrador13_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_AdministradorController_administrador13_invoker.call(AdministradorController_4.administrador(id))
      }
  
    // @LINE:23
    case controllers_ConcursoController_concurso14_route(params) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_ConcursoController_concurso14_invoker.call(ConcursoController_3.concurso(id))
      }
  
    // @LINE:25
    case controllers_LocutorController_locutorByEmail15_route(params) =>
      call(params.fromPath[String]("email", None)) { (email) =>
        controllers_LocutorController_locutorByEmail15_invoker.call(LocutorController_6.locutorByEmail(email))
      }
  
    // @LINE:27
    case controllers_LocutorController_guardarLocutor16_route(params) =>
      call { 
        controllers_LocutorController_guardarLocutor16_invoker.call(LocutorController_6.guardarLocutor())
      }
  
    // @LINE:28
    case controllers_LocutorController_actualizarLocutor17_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_LocutorController_actualizarLocutor17_invoker.call(LocutorController_6.actualizarLocutor(id))
      }
  
    // @LINE:29
    case controllers_VozController_guardarVoz18_route(params) =>
      call { 
        controllers_VozController_guardarVoz18_invoker.call(VozController_1.guardarVoz())
      }
  }
}
