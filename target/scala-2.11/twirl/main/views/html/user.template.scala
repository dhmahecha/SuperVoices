
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object user_Scope0 {
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

class user extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""

		
  """),format.raw/*6.3*/("""<h1>Prueba</h1>
""")))}),format.raw/*7.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object user extends user_Scope0.user
              /*
                  -- GENERATED --
                  DATE: Thu Apr 13 13:42:46 COT 2017
                  SOURCE: /Users/Diego/ProyectosplayJava/supervoices/app/views/user.scala.html
                  HASH: 5e329e2196a46a4fc6550b00640c8586497b1955
                  MATRIX: 736->1|832->3|860->6|891->29|930->31|963->38|1009->55
                  LINES: 27->1|32->1|34->3|34->3|34->3|37->6|38->7
                  -- GENERATED --
              */
          