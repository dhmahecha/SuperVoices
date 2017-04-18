
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object detalleconcurso_Scope0 {
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

class detalleconcurso extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Form[views.formdata.DetalleConcursoFormData],Concurso,List[Voz],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(detalleConcursoFormData:Form[views.formdata.DetalleConcursoFormData],concurso:Concurso,voces:List[Voz]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._

Seq[Any](format.raw/*1.106*/("""
"""),format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("")/*4.10*/ {_display_(Seq[Any](format.raw/*4.12*/("""

""")))}),format.raw/*6.2*/("""

"""),format.raw/*8.1*/("""<script type="text/javascript" src=""""),_display_(/*8.38*/routes/*8.44*/.Assets.versioned("javascripts/lib/simple-uuid/uuid.js")),format.raw/*8.100*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*9.15*/routes/*9.21*/.Assets.versioned("javascripts/locutor.js")),format.raw/*9.64*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*10.15*/routes/*10.21*/.Assets.versioned("javascripts/voz.js")),format.raw/*10.60*/("""" type="text/javascript"></script>
<link href=""""),_display_(/*11.14*/routes/*11.20*/.Assets.versioned("stylesheets/concursos.css")),format.raw/*11.66*/("""" rel="stylesheet" media="screen">

<div class="bg-1">
  <div class="container">

    <h3 class="text-center">"""),_display_(/*16.30*/concurso/*16.38*/.getNom_concurso()),format.raw/*16.56*/("""</h3>
    <p class="text-center">"""),_display_(/*17.29*/concurso/*17.37*/.getTxt_recomendaciones()),format.raw/*17.62*/("""<br></p>
    <div class="row text-center">
      <div class="col-sm-12">
        <div class="thumbnail">
          <img src=""""),_display_(/*21.22*/concurso/*21.30*/.getImg_banner()),format.raw/*21.46*/(""""
               alt="Bogotá" width="1000" height="800">
          <p><strong>Bogotá</strong></p>
          <p>desde el """),_display_(/*24.24*/concurso/*24.32*/.getFec_inicio()),format.raw/*24.48*/(""" """),format.raw/*24.49*/("""hasta el """),_display_(/*24.59*/concurso/*24.67*/.getFec_fin()),format.raw/*24.80*/("""</p>
            <button type="button" id="vozButton" data-target="#vozModal" class="btn btn-default" data-toggle="modal" data-hover="tooltip" 
            data-placement="bottom" data-trigger="hover" title="Subir voz">Sube tu voz</button>

        </div>
      </div>
    </div>

    <ul class="list-group">
      <li class="list-group-item"><span class="label label-default">Guión</span> """),_display_(/*33.83*/concurso/*33.91*/.getTxt_guion()),format.raw/*33.106*/("""</li>
    </ul>



    <div class="panel panel-default">
      <div class="panel-heading">Voces participantes</div>
          <div class="panel-body">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th>Locutor</th>
                    <th>voz</th>
                    <th>audio</th>
                  </tr>
                </thead>
                <tbody>
                """),_display_(/*50.18*/for(voz <- voces) yield /*50.35*/{_display_(Seq[Any](format.raw/*50.36*/("""
                  """),format.raw/*51.19*/("""<tr>
                    <td>"""),_display_(/*52.26*/voz/*52.29*/.getLocutor().getNombres()),format.raw/*52.55*/(""" """),_display_(/*52.57*/voz/*52.60*/.getLocutor().getApellidos()),format.raw/*52.88*/("""</td>
                    <td> voz del concurso """),_display_(/*53.44*/concurso/*53.52*/.getNom_concurso()),format.raw/*53.70*/(""" """),format.raw/*53.71*/("""de """),_display_(/*53.75*/voz/*53.78*/.getLocutor().getNombres()),format.raw/*53.104*/("""
                    """),format.raw/*54.21*/("""</td>
                    <td>
                         <div class="row">
                            <div class="col-sm-12">
                                <audio controls>
                                  <source src=""""),_display_(/*59.49*/voz/*59.52*/.getVal_voz_convertida()),format.raw/*59.76*/("""" type="audio/mpeg">
                                  Your browser does not support the audio element.
                                </audio>
                            </div>
                        </div>
                    </td>
                  </tr>
                """)))}),format.raw/*66.18*/("""
                """),format.raw/*67.17*/("""</tbody>
              </table>

                <ul class="pagination">
                """),format.raw/*71.17*/("""{"""),format.raw/*71.18*/("""% if voces.has_previous %"""),format.raw/*71.43*/("""}"""),format.raw/*71.44*/("""
                    """),format.raw/*72.21*/("""<li>
                        <span><a href="?page="""),format.raw/*73.46*/("""{"""),format.raw/*73.47*/("""{"""),format.raw/*73.48*/(""" """),format.raw/*73.49*/("""voces.previous_page_number """),format.raw/*73.76*/("""}"""),format.raw/*73.77*/("""}"""),format.raw/*73.78*/("""">Previous</a></span>
                    </li>
                """),format.raw/*75.17*/("""{"""),format.raw/*75.18*/("""% endif %"""),format.raw/*75.27*/("""}"""),format.raw/*75.28*/("""
                    """),format.raw/*76.21*/("""<li class="">
                        <span>Page """),format.raw/*77.36*/("""{"""),format.raw/*77.37*/("""{"""),format.raw/*77.38*/(""" """),format.raw/*77.39*/("""voces.number """),format.raw/*77.52*/("""}"""),format.raw/*77.53*/("""}"""),format.raw/*77.54*/(""" """),format.raw/*77.55*/("""of """),format.raw/*77.58*/("""{"""),format.raw/*77.59*/("""{"""),format.raw/*77.60*/(""" """),format.raw/*77.61*/("""voces.paginator.num_pages """),format.raw/*77.87*/("""}"""),format.raw/*77.88*/("""}"""),format.raw/*77.89*/(""".</span>
                    </li>
                """),format.raw/*79.17*/("""{"""),format.raw/*79.18*/("""% if voces.has_next %"""),format.raw/*79.39*/("""}"""),format.raw/*79.40*/("""
                    """),format.raw/*80.21*/("""<li>
                        <span><a href="?page="""),format.raw/*81.46*/("""{"""),format.raw/*81.47*/("""{"""),format.raw/*81.48*/(""" """),format.raw/*81.49*/("""voces.next_page_number """),format.raw/*81.72*/("""}"""),format.raw/*81.73*/("""}"""),format.raw/*81.74*/("""">Next</a></span>
                    </li>
                """),format.raw/*83.17*/("""{"""),format.raw/*83.18*/("""% endif %"""),format.raw/*83.27*/("""}"""),format.raw/*83.28*/("""
                """),format.raw/*84.17*/("""</ul>
            </div>
        </div>

      </div>
    </div>


<div class="modal fade" id="vozModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-sm" role="document">
    	<input type="hidden" id="idConcurso"  name="idConcurso" value=""""),_display_(/*94.70*/concurso/*94.78*/.getId()),format.raw/*94.86*/("""">
        <div class="modal-content">
            <div class="modal-header bg-3">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Subir voz de un locutor</h4>
            </div>
            <div class="modal-body">
                <form id="registroVoz" name="registroVoz" enctype="multipart/form-data" method="post" >
                    <div class="alert fade in alert alert-success" id="voz-success" style="display:none;">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                    </div>

                    <div class="alert fade in alert alert-warning" id="voz-warning" style="display:none;">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                    </div>

                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-group input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                                <input type="text" class="form-control" placeholder="Correo Electrónico" id="email"  name="email">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-group input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input type="text" class="form-control" placeholder="Nombres del locutor" id="nombres"  name="nombres">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-group input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input type="text" class="form-control" placeholder="Apellidos del locutor" id="apellidos"  name="apellidos">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-group input-group">
                                <span class="input-group-addon"><span class="glyphicon">&#xe002;</span></span>
                                <input type="file" class="form-control" id="val_voz_original" placeholder="Voz" name="val_voz_original"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-group input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-pencil"></span></span>
                                <textarea id="txt_observaciones" class="form-control" placeholder="Observaciones" name="txt_observaciones"></textarea>
                            </div>
                        </div>
                    </div>


                </form>

            </div>
            <div class="modal-footer bg-3">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                <button type="button" name="guardar" id="guardar" class="btn btn-default" onclick="guardarCambios();" >Enviar Voz</button>
            </div>
        </div>
    </div>
</div>
</div>   
"""))
      }
    }
  }

  def render(detalleConcursoFormData:Form[views.formdata.DetalleConcursoFormData],concurso:Concurso,voces:List[Voz]): play.twirl.api.HtmlFormat.Appendable = apply(detalleConcursoFormData,concurso,voces)

  def f:((Form[views.formdata.DetalleConcursoFormData],Concurso,List[Voz]) => play.twirl.api.HtmlFormat.Appendable) = (detalleConcursoFormData,concurso,voces) => apply(detalleConcursoFormData,concurso,voces)

  def ref: this.type = this

}


}

/**/
object detalleconcurso extends detalleconcurso_Scope0.detalleconcurso
              /*
                  -- GENERATED --
                  DATE: Sat Apr 15 22:14:41 COT 2017
                  SOURCE: /Users/Diego/ProyectosplayJava/supervoices/app/views/detalleconcurso.scala.html
                  HASH: f632e6ef004158d9586d59e2d70e0e7550f057e7
                  MATRIX: 822->1|1037->105|1064->123|1091->125|1107->133|1146->135|1178->138|1206->140|1269->177|1283->183|1360->239|1435->288|1449->294|1512->337|1588->386|1603->392|1663->431|1738->479|1753->485|1820->531|1958->642|1975->650|2014->668|2075->702|2092->710|2138->735|2291->861|2308->869|2345->885|2493->1006|2510->1014|2547->1030|2576->1031|2613->1041|2630->1049|2664->1062|3082->1453|3099->1461|3136->1476|3606->1919|3639->1936|3678->1937|3725->1956|3782->1986|3794->1989|3841->2015|3870->2017|3882->2020|3931->2048|4007->2097|4024->2105|4063->2123|4092->2124|4123->2128|4135->2131|4183->2157|4232->2178|4482->2401|4494->2404|4539->2428|4848->2706|4893->2723|5010->2812|5039->2813|5092->2838|5121->2839|5170->2860|5248->2910|5277->2911|5306->2912|5335->2913|5390->2940|5419->2941|5448->2942|5540->3006|5569->3007|5606->3016|5635->3017|5684->3038|5761->3087|5790->3088|5819->3089|5848->3090|5889->3103|5918->3104|5947->3105|5976->3106|6007->3109|6036->3110|6065->3111|6094->3112|6148->3138|6177->3139|6206->3140|6285->3191|6314->3192|6363->3213|6392->3214|6441->3235|6519->3285|6548->3286|6577->3287|6606->3288|6657->3311|6686->3312|6715->3313|6803->3373|6832->3374|6869->3383|6898->3384|6943->3401|7260->3691|7277->3699|7306->3707
                  LINES: 27->1|32->1|33->3|34->4|34->4|34->4|36->6|38->8|38->8|38->8|38->8|39->9|39->9|39->9|40->10|40->10|40->10|41->11|41->11|41->11|46->16|46->16|46->16|47->17|47->17|47->17|51->21|51->21|51->21|54->24|54->24|54->24|54->24|54->24|54->24|54->24|63->33|63->33|63->33|80->50|80->50|80->50|81->51|82->52|82->52|82->52|82->52|82->52|82->52|83->53|83->53|83->53|83->53|83->53|83->53|83->53|84->54|89->59|89->59|89->59|96->66|97->67|101->71|101->71|101->71|101->71|102->72|103->73|103->73|103->73|103->73|103->73|103->73|103->73|105->75|105->75|105->75|105->75|106->76|107->77|107->77|107->77|107->77|107->77|107->77|107->77|107->77|107->77|107->77|107->77|107->77|107->77|107->77|107->77|109->79|109->79|109->79|109->79|110->80|111->81|111->81|111->81|111->81|111->81|111->81|111->81|113->83|113->83|113->83|113->83|114->84|124->94|124->94|124->94
                  -- GENERATED --
              */
          