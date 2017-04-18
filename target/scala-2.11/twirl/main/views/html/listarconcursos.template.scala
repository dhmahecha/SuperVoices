
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object listarconcursos_Scope0 {
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

class listarconcursos extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Form[views.formdata.ConcursoFormData],List[Concurso],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(concursoFormData:Form[views.formdata.ConcursoFormData],concursos:List[Concurso]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._

Seq[Any](format.raw/*1.83*/("""
"""),format.raw/*3.1*/("""

"""),_display_(/*5.2*/main("")/*5.10*/ {_display_(Seq[Any](format.raw/*5.12*/("""

""")))}),format.raw/*7.2*/("""
"""),format.raw/*8.1*/("""<div class="panel panel-primary">
	<div class="panel-heading"></div>
		<div class="panel-body"></div>


			<div class="container text-center">
			  <p class="titulos">Tus Concursos</p>
			  <h2>Aquí podras gestionar tus concursos!!</h2>
			  <p>concurso(s): """),_display_(/*16.23*/concursos/*16.32*/.size()),format.raw/*16.39*/("""</p>
			    <br>
			    
	   			<div>

 					<div class="row">
						<div class="col-sm-12">
          					<div class="table-responsive">
					           <table class="table table-bordered table-hover">
					                 <thead>
					                    <tr>
					                        <th><strong>NOMBRE</strong></th>
					                        <th><strong>FECHA INICIO</strong></th>
					                        <th><strong>FECHA FIN</strong></th>
					                        <th><strong>VALOR A PAGRA</strong></th>
					                        <th><strong>URL</strong></th>
					                        <th><strong>DETALLES DEL CONCURSO</strong></th>
					                        <th><strong>VOCES INSCRITAS</strong></th>
					                        <th><strong>OTRAS OPCIONES</strong></th>
					                    </tr>
					                  </thead>  
						              <tbody>
						             	"""),_display_(/*38.22*/for(concurso <- concursos) yield /*38.48*/ {_display_(Seq[Any](format.raw/*38.50*/("""
							             	"""),format.raw/*39.22*/("""<tr>
						                        <th>"""),_display_(/*40.36*/concurso/*40.44*/.getNom_concurso()),format.raw/*40.62*/("""</th>
						                        <th>"""),_display_(/*41.36*/concurso/*41.44*/.getFec_inicio()),format.raw/*41.60*/("""</th>
						                        <th>"""),_display_(/*42.36*/concurso/*42.44*/.getFec_fin()),format.raw/*42.57*/("""</th>
						                        <th>"""),_display_(/*43.36*/concurso/*43.44*/.getVal_pagar_voz()),format.raw/*43.63*/("""</th>
						                        <th>"""),_display_(/*44.36*/concurso/*44.44*/.getVal_url()),format.raw/*44.57*/("""</th>
						                        <th>
						                          <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target=""""),_display_(/*46.117*/concurso/*46.125*/.getVal_url()),format.raw/*46.138*/("""">
						                            <span class="glyphicon glyphicon-plus"></span> Detalles </button>
						                          </button>
						                        </th>
						                        <th>
						                          <a href="" style="font-size:14px;">
						                              <span class="glyphicon glyphicon-music"></span>Listar voces
						                            </a>
						                        </th>
						                        <th style="font-size:25px;">
						                            <a href="" >
						                              <span class="glyphicon glyphicon-pencil" ></span>
						                            </a>
						                           <a href="" >
						                              <span class="glyphicon glyphicon-trash"></span>
						                            </a>
						                        </th>				                        			                        					             	
							             	</tr>
						             	""")))}),format.raw/*64.22*/("""
						             """),format.raw/*65.20*/("""</tbody> 
					             </table>            					
          					</div>
          				</div>	 					
 					</div> 			
    			</div>

			</div>

		</div>
	</div>	
</div> """))
      }
    }
  }

  def render(concursoFormData:Form[views.formdata.ConcursoFormData],concursos:List[Concurso]): play.twirl.api.HtmlFormat.Appendable = apply(concursoFormData,concursos)

  def f:((Form[views.formdata.ConcursoFormData],List[Concurso]) => play.twirl.api.HtmlFormat.Appendable) = (concursoFormData,concursos) => apply(concursoFormData,concursos)

  def ref: this.type = this

}


}

/**/
object listarconcursos extends listarconcursos_Scope0.listarconcursos
              /*
                  -- GENERATED --
                  DATE: Thu Apr 13 13:42:46 COT 2017
                  SOURCE: /Users/Diego/ProyectosplayJava/supervoices/app/views/listarconcursos.scala.html
                  HASH: a42924fb7e33a075dd4db05fa7eff4f94e3125eb
                  MATRIX: 811->1|1002->82|1029->100|1057->103|1073->111|1112->113|1144->116|1171->117|1457->376|1475->385|1503->392|2449->1311|2491->1337|2531->1339|2581->1361|2648->1401|2665->1409|2704->1427|2772->1468|2789->1476|2826->1492|2894->1533|2911->1541|2945->1554|3013->1595|3030->1603|3070->1622|3138->1663|3155->1671|3189->1684|3374->1841|3392->1849|3427->1862|4471->2875|4519->2895
                  LINES: 27->1|32->1|33->3|35->5|35->5|35->5|37->7|38->8|46->16|46->16|46->16|68->38|68->38|68->38|69->39|70->40|70->40|70->40|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|74->44|74->44|74->44|76->46|76->46|76->46|94->64|95->65
                  -- GENERATED --
              */
          