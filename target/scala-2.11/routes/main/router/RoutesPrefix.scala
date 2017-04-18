
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Diego/ProyectosplayJava/supervoices/conf/routes
// @DATE:Sat Apr 15 20:35:58 COT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
