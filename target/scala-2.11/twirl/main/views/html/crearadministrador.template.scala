
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object crearadministrador_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class crearadministrador extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[views.formdata.CreateAdminFormData],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(crearAdministradorForm: Form[views.formdata.CreateAdminFormData]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._

Seq[Any](format.raw/*1.68*/(""" 
"""),format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("")/*4.10*/ {_display_(Seq[Any](format.raw/*4.12*/("""

""")))}),format.raw/*6.2*/("""

    """),format.raw/*8.5*/("""<div class="panel panel-primary">
      <div class="panel-heading"></div>
      <div class="panel-body"></div>


	"""),_display_(/*13.3*/if(crearAdministradorForm.hasErrors)/*13.39*/ {_display_(Seq[Any](format.raw/*13.41*/("""
	"""),format.raw/*14.2*/("""<ul>
	
		"""),_display_(/*16.4*/for(error <- crearAdministradorForm("username").errors) yield /*16.59*/ {_display_(Seq[Any](format.raw/*16.61*/("""
		  """),format.raw/*17.5*/("""<div class="alert alert-danger alert-dismissable">
		  <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
		  """),_display_(/*19.6*/error/*19.11*/.key),format.raw/*19.15*/(""" """),format.raw/*19.16*/(""": """),_display_(/*19.19*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*20.7*/("""</div>
		""")))}),format.raw/*21.4*/("""	
	"""),format.raw/*22.2*/("""<p class="bg-danger">
		 """),_display_(/*23.5*/for(error <- crearAdministradorForm("first_name").errors) yield /*23.62*/ {_display_(Seq[Any](format.raw/*23.64*/("""
			"""),format.raw/*24.4*/("""<div class="alert alert-danger alert-dismissable">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
				"""),_display_(/*26.6*/error/*26.11*/.key),format.raw/*26.15*/(""" """),format.raw/*26.16*/(""": """),_display_(/*26.19*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*27.7*/("""</div>
		""")))}),format.raw/*28.4*/(""" """),_display_(/*28.6*/for(error <- crearAdministradorForm("last_name").errors) yield /*28.62*/ {_display_(Seq[Any](format.raw/*28.64*/("""
			"""),format.raw/*29.4*/("""<div class="alert alert-danger alert-dismissable">
	    	<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>		
				"""),_display_(/*31.6*/error/*31.11*/.key),format.raw/*31.15*/(""" """),format.raw/*31.16*/(""": """),_display_(/*31.19*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*32.7*/("""</div>
		""")))}),format.raw/*33.4*/(""" """),_display_(/*33.6*/for(error <- crearAdministradorForm("email").errors) yield /*33.58*/ {_display_(Seq[Any](format.raw/*33.60*/("""
			"""),format.raw/*34.4*/("""<div class="alert alert-danger alert-dismissable">
		    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>	
				"""),_display_(/*36.6*/error/*36.11*/.key),format.raw/*36.15*/(""" """),format.raw/*36.16*/(""": """),_display_(/*36.19*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*37.7*/("""</div>
		""")))}),format.raw/*38.4*/(""" """),_display_(/*38.6*/for(error <- crearAdministradorForm("password").errors) yield /*38.61*/ {_display_(Seq[Any](format.raw/*38.63*/("""
			"""),format.raw/*39.4*/("""<div class="alert alert-danger alert-dismissable">
		    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>	
				"""),_display_(/*41.6*/error/*41.11*/.key),format.raw/*41.15*/(""" """),format.raw/*41.16*/(""": """),_display_(/*41.19*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*42.7*/("""</div>
		""")))}),format.raw/*43.4*/("""
		
	"""),format.raw/*45.2*/("""</ul>
	""")))}),format.raw/*46.3*/(""" 

	"""),format.raw/*48.2*/("""<div class="container">
    	<h3 class="text-center"></h3>
    	<h3 class="text-center">Registrate</h3>
    	<p class="text-center"><em>Haz parte de nuestra comunidad!</em></p>

      	<div class="col-md-12">
        	<div class="col-sm-12 form-group">
	
				"""),_display_(/*56.6*/form(routes.Application.crearAdministrador)/*56.49*/ {_display_(Seq[Any](format.raw/*56.51*/("""
				  """),format.raw/*57.7*/("""<div class="input-group">
				    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						<input type="text" name="username" placeholder="Username" class="form-control"
							value=""""),_display_(/*60.16*/crearAdministradorForm("username")/*60.50*/.value),format.raw/*60.56*/("""">
  				  </div>
				  <div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>				  
						<input type="text" name="first_name" placeholder="Nombres" class="form-control"
							value=""""),_display_(/*65.16*/crearAdministradorForm("first_name")/*65.52*/.value),format.raw/*65.58*/("""">
  				  </div>
				  <div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>				  
						<input type="text" name="last_name" placeholder="Apellidos" class="form-control"
							value=""""),_display_(/*70.16*/crearAdministradorForm("last_name")/*70.51*/.value),format.raw/*70.57*/("""">
  				  </div>
				  <div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>				  
						<input type="text" name="email" placeholder="Email" class="form-control"
							value=""""),_display_(/*75.16*/crearAdministradorForm("email")/*75.47*/.value),format.raw/*75.53*/("""">
  				  </div>			
				  <div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>				  
						<input type="password" name="password" placeholder="Password" class="form-control">
 				  </div>
 				  <div class="input-group">
				    <button type="submit" class="btn btn-primary" >
				    	Registrarse
				    </button>
				  </div>  
				""")))}),format.raw/*86.6*/("""
	
        """),format.raw/*88.9*/("""</div>
      </div>
    </div>	
    </div>"""))
      }
    }
  }

  def render(crearAdministradorForm:Form[views.formdata.CreateAdminFormData]): play.twirl.api.HtmlFormat.Appendable = apply(crearAdministradorForm)

  def f:((Form[views.formdata.CreateAdminFormData]) => play.twirl.api.HtmlFormat.Appendable) = (crearAdministradorForm) => apply(crearAdministradorForm)

  def ref: this.type = this

}


}

/**/
object crearadministrador extends crearadministrador_Scope0.crearadministrador
              /*
                  -- GENERATED --
                  DATE: Sun Apr 16 19:26:49 COT 2017
                  SOURCE: /Users/Diego/ProyectosplayJava/supervoices/app/views/crearadministrador.scala.html
                  HASH: 03ed0c900a7148c9133011a1ae8eea75ba837ec5
                  MATRIX: 805->1|981->67|1009->86|1036->88|1052->96|1091->98|1123->101|1155->107|1296->222|1341->258|1381->260|1410->262|1446->272|1517->327|1557->329|1589->334|1747->466|1761->471|1786->475|1815->476|1845->479|1921->535|1961->545|1991->548|2043->574|2116->631|2156->633|2187->637|2344->768|2358->773|2383->777|2412->778|2442->781|2518->837|2558->847|2586->849|2658->905|2698->907|2729->911|2891->1047|2905->1052|2930->1056|2959->1057|2989->1060|3065->1116|3105->1126|3133->1128|3201->1180|3241->1182|3272->1186|3433->1321|3447->1326|3472->1330|3501->1331|3531->1334|3607->1390|3647->1400|3675->1402|3746->1457|3786->1459|3817->1463|3978->1598|3992->1603|4017->1607|4046->1608|4076->1611|4152->1667|4192->1677|4224->1682|4262->1690|4293->1694|4579->1954|4631->1997|4671->1999|4705->2006|4946->2220|4989->2254|5016->2260|5286->2503|5331->2539|5358->2545|5629->2789|5673->2824|5700->2830|5967->3070|6007->3101|6034->3107|6461->3504|6499->3515
                  LINES: 27->1|32->1|33->3|34->4|34->4|34->4|36->6|38->8|43->13|43->13|43->13|44->14|46->16|46->16|46->16|47->17|49->19|49->19|49->19|49->19|49->19|50->20|51->21|52->22|53->23|53->23|53->23|54->24|56->26|56->26|56->26|56->26|56->26|57->27|58->28|58->28|58->28|58->28|59->29|61->31|61->31|61->31|61->31|61->31|62->32|63->33|63->33|63->33|63->33|64->34|66->36|66->36|66->36|66->36|66->36|67->37|68->38|68->38|68->38|68->38|69->39|71->41|71->41|71->41|71->41|71->41|72->42|73->43|75->45|76->46|78->48|86->56|86->56|86->56|87->57|90->60|90->60|90->60|95->65|95->65|95->65|100->70|100->70|100->70|105->75|105->75|105->75|116->86|118->88
                  -- GENERATED --
              */
          