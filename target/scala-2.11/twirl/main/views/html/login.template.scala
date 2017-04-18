
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object login_Scope0 {
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

class login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[views.formdata.LoginFormData],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginForm: Form[views.formdata.LoginFormData]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._

Seq[Any](format.raw/*1.49*/(""" """),format.raw/*2.1*/("""

"""),_display_(/*4.2*/main("")/*4.10*/ {_display_(Seq[Any](format.raw/*4.12*/("""

""")))}),format.raw/*6.2*/("""

    """),format.raw/*8.5*/("""<div class="panel panel-primary">
      <div class="panel-heading"></div>
      <div class="panel-body"></div>
      
      	"""),_display_(/*12.9*/if(loginForm.hasErrors)/*12.32*/ {_display_(Seq[Any](format.raw/*12.34*/("""
	"""),format.raw/*13.2*/("""<ul>
		"""),_display_(/*14.4*/for(error <- loginForm("username").errors) yield /*14.46*/ {_display_(Seq[Any](format.raw/*14.48*/("""
		  """),format.raw/*15.5*/("""<div class="alert alert-danger alert-dismissable">
		  <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>		
			"""),_display_(/*17.5*/error/*17.10*/.key),format.raw/*17.14*/(""" """),format.raw/*17.15*/(""": """),_display_(/*17.18*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*18.7*/("""</div>
		""")))}),format.raw/*19.4*/(""" """),_display_(/*19.6*/for(error <- loginForm("password").errors) yield /*19.48*/ {_display_(Seq[Any](format.raw/*19.50*/("""
		  """),format.raw/*20.5*/("""<div class="alert alert-danger alert-dismissable">
		  <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>	
		  	"""),_display_(/*22.7*/error/*22.12*/.key),format.raw/*22.16*/(""" """),format.raw/*22.17*/(""": """),_display_(/*22.20*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*23.7*/("""</div>
		""")))}),format.raw/*24.4*/("""
	"""),format.raw/*25.2*/("""</ul>
	""")))}),format.raw/*26.3*/("""
      
  """),format.raw/*28.3*/("""<div class="container">
    <h3 class="text-center">Registrate</h3>
    <p class="text-center"><em>Haz parte de nuestra comunidad!</em></p>
    
          <div class="col-md-12">
        <div class="col-sm-12 form-group">

	 """),_display_(/*35.4*/form(routes.Application.authenticate)/*35.41*/ {_display_(Seq[Any](format.raw/*35.43*/("""

		"""),format.raw/*37.3*/("""<div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
					<input type="text" name="username" placeholder="Username" class="form-control"
					value=""""),_display_(/*40.14*/loginForm("username")/*40.35*/.value),format.raw/*40.41*/("""">
				</div>
				  <div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				<input type="password" name="password" placeholder="Password" class="form-control">
				</div>
	 				  <div class="input-group">
              <button type="submit" class="form-group btn btn-primary"  action="signup" >
              Ingresar
              </button>
              </div>

	""")))}),format.raw/*52.3*/("""
	
	
        """),format.raw/*55.9*/("""</div>
      </div>
	
    </div>


      </div>
    </div>	
    </div>

"""))
      }
    }
  }

  def render(loginForm:Form[views.formdata.LoginFormData]): play.twirl.api.HtmlFormat.Appendable = apply(loginForm)

  def f:((Form[views.formdata.LoginFormData]) => play.twirl.api.HtmlFormat.Appendable) = (loginForm) => apply(loginForm)

  def ref: this.type = this

}


}

/**/
object login extends login_Scope0.login
              /*
                  -- GENERATED --
                  DATE: Sun Apr 16 14:48:17 COT 2017
                  SOURCE: /Users/Diego/ProyectosplayJava/supervoices/app/views/login.scala.html
                  HASH: 9e88599d8162f9ec6c244943456613441da2c366
                  MATRIX: 773->1|930->48|957->66|985->69|1001->77|1040->79|1072->82|1104->88|1256->214|1288->237|1328->239|1357->241|1391->249|1449->291|1489->293|1521->298|1680->431|1694->436|1719->440|1748->441|1778->444|1854->500|1894->510|1922->512|1980->554|2020->556|2052->561|2212->695|2226->700|2251->704|2280->705|2310->708|2386->764|2426->774|2455->776|2493->784|2530->794|2782->1020|2828->1057|2868->1059|2899->1063|3135->1272|3165->1293|3192->1299|3648->1725|3688->1738
                  LINES: 27->1|32->1|32->2|34->4|34->4|34->4|36->6|38->8|42->12|42->12|42->12|43->13|44->14|44->14|44->14|45->15|47->17|47->17|47->17|47->17|47->17|48->18|49->19|49->19|49->19|49->19|50->20|52->22|52->22|52->22|52->22|52->22|53->23|54->24|55->25|56->26|58->28|65->35|65->35|65->35|67->37|70->40|70->40|70->40|82->52|85->55
                  -- GENERATED --
              */
          