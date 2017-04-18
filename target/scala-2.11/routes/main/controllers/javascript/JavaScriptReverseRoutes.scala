
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Diego/ProyectosplayJava/supervoices/conf/routes
// @DATE:Sat Apr 15 20:35:58 COT 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:19
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:25
  class ReverseLocutorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def actualizarLocutor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LocutorController.actualizarLocutor",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "actualizarLocutor/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:25
    def locutorByEmail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LocutorController.locutorByEmail",
      """
        function(email0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "locutorByEmail/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("email", encodeURIComponent(email0))})
        }
      """
    )
  
    // @LINE:27
    def guardarLocutor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LocutorController.guardarLocutor",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "guardarlocutor"})
        }
      """
    )
  
  }

  // @LINE:29
  class ReverseVozController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def guardarVoz: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VozController.guardarVoz",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "guardarvoz"})
        }
      """
    )
  
  }

  // @LINE:21
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def user: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.user",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:22
  class ReverseAdministradorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def administrador: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdministradorController.administrador",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administrador/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def listarConcursos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.listarConcursos",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "listarconcursos"})
        }
      """
    )
  
    // @LINE:9
    def formadmin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.formadmin",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "formadmin"})
        }
      """
    )
  
    // @LINE:10
    def crearAdministrador: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.crearAdministrador",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "crearadmin"})
        }
      """
    )
  
    // @LINE:13
    def formConcurso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.formConcurso",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "formconcurso"})
        }
      """
    )
  
    // @LINE:11
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.logout",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
        }
      """
    )
  
    // @LINE:14
    def crearConcurso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.crearConcurso",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "crearconcurso"})
        }
      """
    )
  
    // @LINE:15
    def adminConcursos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.adminConcursos",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminconcursos"})
        }
      """
    )
  
    // @LINE:16
    def detalleConcurso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.detalleConcurso",
      """
        function(val_url0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "detalleconcurso/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("val_url", encodeURIComponent(val_url0))})
        }
      """
    )
  
    // @LINE:8
    def authenticate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.authenticate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:7
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.login",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }

  // @LINE:23
  class ReverseConcursoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def concurso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ConcursoController.concurso",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "concurso/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
  }


}
