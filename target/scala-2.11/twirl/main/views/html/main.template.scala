
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
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

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.32*/("""



"""),format.raw/*11.1*/("""<!DOCTYPE html>
<html lang="en">
	<head>
  		<title>SUPERVOICES</title>
		<script type="text/javascript" src=""""),_display_(/*15.40*/routes/*15.46*/.Assets.versioned("javascripts/lib/simple-uuid/uuid.js")),format.raw/*15.102*/("""" type="text/javascript"></script>  		
  		<link rel="stylesheet" href=""""),_display_(/*16.35*/routes/*16.41*/.Assets.versioned("javascripts/lib/bootstrap/dist/css/bootstrap.min.css")),format.raw/*16.114*/("""">
  		<script type="text/javascript" src=""""),_display_(/*17.42*/routes/*17.48*/.Assets.versioned("javascripts/lib/jquery/dist/jquery.min.js")),format.raw/*17.110*/(""""></script>
  		<script type="text/javascript" src=""""),_display_(/*18.42*/routes/*18.48*/.Assets.versioned("javascripts/lib/bootstrap/dist/js/bootstrap.min.js")),format.raw/*18.119*/(""""></script>  		
    </head>
    <body>
	  <nav class="navbar navbar-default navbar-fixed-top">
	    <div class="container-fluid">
	      <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	        </button>
	        <a class="navbar-brand" href="/#">SUPERVOICES</a>
	      </div>
	      """),_display_(/*31.9*/if(session.get("username") != "" && session.get("username") != null)/*31.77*/{_display_(Seq[Any](format.raw/*31.78*/("""
	      """),format.raw/*32.8*/("""<div class="collapse navbar-collapse" id="myNavbar">
	        <ul class="nav navbar-nav navbar-right">
	          <li><a >BIENVENIDO """),_display_(/*34.32*/session/*34.39*/.get("username")),format.raw/*34.55*/(""" """),format.raw/*34.56*/("""</a></li>
	          <li><a href=""""),_display_(/*35.26*/routes/*35.32*/.Application.adminConcursos),format.raw/*35.59*/("""">VOLVER AL HOME </a></li>
	          <li><a ></a></li>
	          <li><a href=""""),_display_(/*37.26*/routes/*37.32*/.Application.logout()),format.raw/*37.53*/("""">SALIR</a></li>
	        </ul>
	      </div>
		 """)))}/*40.5*/else/*40.9*/{_display_(Seq[Any](format.raw/*40.10*/("""
	      """),format.raw/*41.8*/("""<div class="collapse navbar-collapse" id="myNavbar">
	        <ul class="nav navbar-nav navbar-right">
	          <li><a href=""""),_display_(/*43.26*/routes/*43.32*/.HomeController.index),format.raw/*43.53*/("""#quienes">QUIENES SOMOS</a></li>
	          <li><a href=""""),_display_(/*44.26*/routes/*44.32*/.HomeController.index),format.raw/*44.53*/("""#valor">NUESTRA APLICACION</a></li>
	          <li><a href=""""),_display_(/*45.26*/routes/*45.32*/.Application.login),format.raw/*45.50*/("""">ENTRAR</a></li>
	          <li><a href=""""),_display_(/*46.26*/routes/*46.32*/.Application.formadmin),format.raw/*46.54*/("""">CREAR UNA CUENTA</a></li>
	        </ul>
	      </div>	 
		 """)))}),format.raw/*49.5*/("""	
	    """),format.raw/*50.6*/("""</div>
	  </nav>   
	</div>


     <div class="body >

         """),format.raw/*57.10*/("""{"""),format.raw/*57.11*/("""% block content %"""),format.raw/*57.28*/("""}"""),format.raw/*57.29*/("""{"""),format.raw/*57.30*/("""% endblock %"""),format.raw/*57.42*/("""}"""),format.raw/*57.43*/("""

     """),format.raw/*59.6*/("""</div>

        
 	</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


}

/*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Fri Apr 14 23:20:01 COT 2017
                  SOURCE: /Users/Diego/ProyectosplayJava/supervoices/app/views/main.scala.html
                  HASH: 11e42bbeb90839a29f5eb962d241a77a90949949
                  MATRIX: 1002->260|1127->290|1158->294|1296->405|1311->411|1389->467|1489->540|1504->546|1599->619|1670->663|1685->669|1769->731|1849->784|1864->790|1957->861|2475->1353|2552->1421|2591->1422|2626->1430|2787->1564|2803->1571|2840->1587|2869->1588|2931->1623|2946->1629|2994->1656|3102->1737|3117->1743|3159->1764|3227->1814|3239->1818|3278->1819|3313->1827|3468->1955|3483->1961|3525->1982|3610->2040|3625->2046|3667->2067|3755->2128|3770->2134|3809->2152|3879->2195|3894->2201|3937->2223|4030->2286|4064->2293|4156->2357|4185->2358|4230->2375|4259->2376|4288->2377|4328->2389|4357->2390|4391->2397
                  LINES: 32->7|37->7|41->11|45->15|45->15|45->15|46->16|46->16|46->16|47->17|47->17|47->17|48->18|48->18|48->18|61->31|61->31|61->31|62->32|64->34|64->34|64->34|64->34|65->35|65->35|65->35|67->37|67->37|67->37|70->40|70->40|70->40|71->41|73->43|73->43|73->43|74->44|74->44|74->44|75->45|75->45|75->45|76->46|76->46|76->46|79->49|80->50|87->57|87->57|87->57|87->57|87->57|87->57|87->57|89->59
                  -- GENERATED --
              */
          