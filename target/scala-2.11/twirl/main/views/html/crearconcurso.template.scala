
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object crearconcurso_Scope0 {
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

class crearconcurso extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[views.formdata.ConcursoFormData],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(concursoFormData:Form[views.formdata.ConcursoFormData]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._

Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.1*/("""

"""),_display_(/*5.2*/main("")/*5.10*/ {_display_(Seq[Any](format.raw/*5.12*/("""

""")))}),format.raw/*7.2*/("""
    """),format.raw/*8.5*/("""<div class="panel panel-primary">
      <div class="panel-heading"></div>
      <div class="panel-body"></div>


	"""),_display_(/*13.3*/if(concursoFormData.hasErrors)/*13.33*/ {_display_(Seq[Any](format.raw/*13.35*/("""
	"""),format.raw/*14.2*/("""<ul>
	
		"""),_display_(/*16.4*/for(error <- concursoFormData("nom_concurso").errors) yield /*16.57*/ {_display_(Seq[Any](format.raw/*16.59*/("""
		  """),format.raw/*17.5*/("""<div class="alert alert-danger alert-dismissable">
		  <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
		  """),_display_(/*19.6*/error/*19.11*/.key),format.raw/*19.15*/(""" """),format.raw/*19.16*/(""": """),_display_(/*19.19*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*20.7*/("""</div>
		""")))}),format.raw/*21.4*/("""	
	"""),format.raw/*22.2*/("""<p class="bg-danger">
		 """),_display_(/*23.5*/for(error <- concursoFormData("img_banner").errors) yield /*23.56*/ {_display_(Seq[Any](format.raw/*23.58*/("""
			"""),format.raw/*24.4*/("""<div class="alert alert-danger alert-dismissable">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
				"""),_display_(/*26.6*/error/*26.11*/.key),format.raw/*26.15*/(""" """),format.raw/*26.16*/(""": """),_display_(/*26.19*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*27.7*/("""</div>
		""")))}),format.raw/*28.4*/(""" """),_display_(/*28.6*/for(error <- concursoFormData("val_url").errors) yield /*28.54*/ {_display_(Seq[Any](format.raw/*28.56*/("""
			"""),format.raw/*29.4*/("""<div class="alert alert-danger alert-dismissable">
	    	<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>		
				"""),_display_(/*31.6*/error/*31.11*/.key),format.raw/*31.15*/(""" """),format.raw/*31.16*/(""": """),_display_(/*31.19*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*32.7*/("""</div>
		""")))}),format.raw/*33.4*/(""" """),_display_(/*33.6*/for(error <- concursoFormData("fec_inicio").errors) yield /*33.57*/ {_display_(Seq[Any](format.raw/*33.59*/("""
			"""),format.raw/*34.4*/("""<div class="alert alert-danger alert-dismissable">
		    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>	
				"""),_display_(/*36.6*/error/*36.11*/.key),format.raw/*36.15*/(""" """),format.raw/*36.16*/(""": """),_display_(/*36.19*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*37.7*/("""</div>
		""")))}),format.raw/*38.4*/(""" """),_display_(/*38.6*/for(error <- concursoFormData("fec_fin").errors) yield /*38.54*/ {_display_(Seq[Any](format.raw/*38.56*/("""
			"""),format.raw/*39.4*/("""<div class="alert alert-danger alert-dismissable">
		    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>	
				"""),_display_(/*41.6*/error/*41.11*/.key),format.raw/*41.15*/(""" """),format.raw/*41.16*/(""": """),_display_(/*41.19*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*42.7*/("""</div>
		""")))}),format.raw/*43.4*/(""" """),_display_(/*43.6*/for(error <- concursoFormData("val_pagar_voz").errors) yield /*43.60*/ {_display_(Seq[Any](format.raw/*43.62*/("""
			"""),format.raw/*44.4*/("""<div class="alert alert-danger alert-dismissable">
		    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>	
				"""),_display_(/*46.6*/error/*46.11*/.key),format.raw/*46.15*/(""" """),format.raw/*46.16*/(""": """),_display_(/*46.19*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*47.7*/("""</div>
		""")))}),format.raw/*48.4*/(""" """),_display_(/*48.6*/for(error <- concursoFormData("txt_guion").errors) yield /*48.56*/ {_display_(Seq[Any](format.raw/*48.58*/("""
			"""),format.raw/*49.4*/("""<div class="alert alert-danger alert-dismissable">
		    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>	
				"""),_display_(/*51.6*/error/*51.11*/.key),format.raw/*51.15*/(""" """),format.raw/*51.16*/(""": """),_display_(/*51.19*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*52.7*/("""</div>
		""")))}),format.raw/*53.4*/(""" """),_display_(/*53.6*/for(error <- concursoFormData("txt_recomendaciones").errors) yield /*53.66*/ {_display_(Seq[Any](format.raw/*53.68*/("""
			"""),format.raw/*54.4*/("""<div class="alert alert-danger alert-dismissable">
		    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>	
				"""),_display_(/*56.6*/error/*56.11*/.key),format.raw/*56.15*/(""" """),format.raw/*56.16*/(""": """),_display_(/*56.19*/Messages(error.messages, error.arguments.toArray:
			_*)),format.raw/*57.7*/("""</div>
		""")))}),format.raw/*58.4*/("""
		
	"""),format.raw/*60.2*/("""</ul>
	""")))}),format.raw/*61.3*/(""" 

	"""),format.raw/*63.2*/("""<div class="container">
    	<h3 class="text-center"></h3>
    	<h3 class="text-center">Ingresa los datos</h3>
    	<p class="text-center"><em>de tu Concurso!!!</em></p>

      	<div class="col-md-12">
        	<div class="col-sm-12 form-group">
	
				"""),_display_(/*71.6*/form(routes.Application.crearConcurso, 'enctype -> "multipart/form-data")/*71.79*/ {_display_(Seq[Any](format.raw/*71.81*/("""
				  """),format.raw/*72.7*/("""<div class="input-group">
				    <span class="input-group-addon"><i class="glyphicon glyphicon-headphones"></i></span>
						<input type="text" name="nom_concurso" placeholder="Nombre del Concurso" class="form-control"
							value=""""),_display_(/*75.16*/concursoFormData("nom_concurso")/*75.48*/.value),format.raw/*75.54*/("""">
  				  </div>
				  <div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-camera"></i></span>				  
						<input type="file" name="img_banner" placeholder="Imagen Banner" class="form-control"
							value=""""),_display_(/*80.16*/concursoFormData("img_banner")/*80.46*/.value),format.raw/*80.52*/("""">
  				  </div>
				  <div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-file"></i></span>				  
						<input type="text" name="val_url" placeholder="Valor URL" class="form-control"
							value=""""),_display_(/*85.16*/concursoFormData("val_url")/*85.43*/.value),format.raw/*85.49*/("""">
  				  </div>
				  <div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>				  
						<input type="text" name="fec_inicio" placeholder="Fecha Inicio" class="form-control"
							value=""""),_display_(/*90.16*/concursoFormData("fec_inicio")/*90.46*/.value),format.raw/*90.52*/("""">
  				  </div>			
				  <div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>				  
						<input type="text" name="fec_fin" placeholder="Fecha Fin" class="form-control"
						value=""""),_display_(/*95.15*/concursoFormData("fec_fin")/*95.42*/.value),format.raw/*95.48*/("""">
 				  </div>
 				  <div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>				  
						<input type="text" name="val_pagar_voz" placeholder="Valor a pagar" class="form-control"
						value=""""),_display_(/*100.15*/concursoFormData("val_pagar_voz")/*100.48*/.value),format.raw/*100.54*/("""">
 				  </div> 
  				  <div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>				  
						<input type="text" name="txt_guion" placeholder="texto del Guón" class="form-control"
						value=""""),_display_(/*105.15*/concursoFormData("txt_guion")/*105.44*/.value),format.raw/*105.50*/("""">
 				  </div> 
   				  <div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>				  
						<input type="text" name="txt_recomendaciones" placeholder="Recomendaciones" class="form-control"
						value=""""),_display_(/*110.15*/concursoFormData("txt_recomendaciones")/*110.54*/.value),format.raw/*110.60*/("""">
 				  </div> 				  					  				  
 				  <div class="input-group">
				    <button type="submit" class="btn btn-primary" >
				    	Registrarse
				    </button>
				  </div>  
				""")))}),format.raw/*117.6*/("""
	
        """),format.raw/*119.9*/("""</div>
      </div>
    </div>	
    </div>"""))
      }
    }
  }

  def render(concursoFormData:Form[views.formdata.ConcursoFormData]): play.twirl.api.HtmlFormat.Appendable = apply(concursoFormData)

  def f:((Form[views.formdata.ConcursoFormData]) => play.twirl.api.HtmlFormat.Appendable) = (concursoFormData) => apply(concursoFormData)

  def ref: this.type = this

}


}

/**/
object crearconcurso extends crearconcurso_Scope0.crearconcurso
              /*
                  -- GENERATED --
                  DATE: Sun Apr 16 22:40:46 COT 2017
                  SOURCE: /Users/Diego/ProyectosplayJava/supervoices/app/views/crearconcurso.scala.html
                  HASH: 137a71f5e1163bdf855d61b1d4844228be5437b7
                  MATRIX: 792->1|958->57|985->75|1013->78|1029->86|1068->88|1100->91|1131->96|1272->211|1311->241|1351->243|1380->245|1416->255|1485->308|1525->310|1557->315|1715->447|1729->452|1754->456|1783->457|1813->460|1889->516|1929->526|1959->529|2011->555|2078->606|2118->608|2149->612|2306->743|2320->748|2345->752|2374->753|2404->756|2480->812|2520->822|2548->824|2612->872|2652->874|2683->878|2845->1014|2859->1019|2884->1023|2913->1024|2943->1027|3019->1083|3059->1093|3087->1095|3154->1146|3194->1148|3225->1152|3386->1287|3400->1292|3425->1296|3454->1297|3484->1300|3560->1356|3600->1366|3628->1368|3692->1416|3732->1418|3763->1422|3924->1557|3938->1562|3963->1566|3992->1567|4022->1570|4098->1626|4138->1636|4166->1638|4236->1692|4276->1694|4307->1698|4468->1833|4482->1838|4507->1842|4536->1843|4566->1846|4642->1902|4682->1912|4710->1914|4776->1964|4816->1966|4847->1970|5008->2105|5022->2110|5047->2114|5076->2115|5106->2118|5182->2174|5222->2184|5250->2186|5326->2246|5366->2248|5397->2252|5558->2387|5572->2392|5597->2396|5626->2397|5656->2400|5732->2456|5772->2466|5804->2471|5842->2479|5873->2483|6152->2736|6234->2809|6274->2811|6308->2818|6570->3053|6611->3085|6638->3091|6916->3342|6955->3372|6982->3378|7251->3620|7287->3647|7314->3653|7593->3905|7632->3935|7659->3941|7934->4189|7970->4216|7997->4222|8280->4477|8323->4510|8351->4516|8633->4770|8672->4799|8700->4805|8994->5071|9043->5110|9071->5116|9287->5301|9326->5312
                  LINES: 27->1|32->1|33->3|35->5|35->5|35->5|37->7|38->8|43->13|43->13|43->13|44->14|46->16|46->16|46->16|47->17|49->19|49->19|49->19|49->19|49->19|50->20|51->21|52->22|53->23|53->23|53->23|54->24|56->26|56->26|56->26|56->26|56->26|57->27|58->28|58->28|58->28|58->28|59->29|61->31|61->31|61->31|61->31|61->31|62->32|63->33|63->33|63->33|63->33|64->34|66->36|66->36|66->36|66->36|66->36|67->37|68->38|68->38|68->38|68->38|69->39|71->41|71->41|71->41|71->41|71->41|72->42|73->43|73->43|73->43|73->43|74->44|76->46|76->46|76->46|76->46|76->46|77->47|78->48|78->48|78->48|78->48|79->49|81->51|81->51|81->51|81->51|81->51|82->52|83->53|83->53|83->53|83->53|84->54|86->56|86->56|86->56|86->56|86->56|87->57|88->58|90->60|91->61|93->63|101->71|101->71|101->71|102->72|105->75|105->75|105->75|110->80|110->80|110->80|115->85|115->85|115->85|120->90|120->90|120->90|125->95|125->95|125->95|130->100|130->100|130->100|135->105|135->105|135->105|140->110|140->110|140->110|147->117|149->119
                  -- GENERATED --
              */
          