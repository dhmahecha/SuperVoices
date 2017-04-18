
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object adminconcursos_Scope0 {
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

class adminconcursos extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main("")/*1.10*/ {_display_(Seq[Any](format.raw/*1.12*/("""

""")))}),format.raw/*3.2*/("""

    """),format.raw/*5.5*/("""<div class="panel panel-primary">
      <div class="panel-heading"></div>
      <div class="panel-body"></div>


<div class="container text-center">
    <p class="titulos">Tus Concursos </p>
    <h2>Estas opciones te permitiran gestionar tus concursos!!</h2>
    <p>&nbsp</p>
    <br>
       <div class="row">
         <div class="col-sm-3">
           <h4>Consultar concursos</h4><br>
           <a href=""""),_display_(/*18.22*/routes/*18.28*/.Application.listarConcursos),format.raw/*18.56*/("""">
             <img src=""""),_display_(/*19.25*/routes/*19.31*/.Assets.versioned("images/consultar.jpg")),format.raw/*19.72*/("""" class="img-circle person" alt="Random Name" width="304" height="236">
           </a>
         </div>

             <div class="col-sm-3">
               <h4>Crear concursos</h4><br>
               <a href=""""),_display_(/*25.26*/routes/*25.32*/.Application.formConcurso),format.raw/*25.57*/("""">
                 <img src=""""),_display_(/*26.29*/routes/*26.35*/.Assets.versioned("images/crear.jpeg")),format.raw/*26.73*/("""" class="img-circle person" alt="Random Name" width="304" height="236">
               </a>
             </div>

         <div class="col-sm-3">
           <h4>Modificar concurso</h4><br>
           <a href=""""),_display_(/*32.22*/routes/*32.28*/.Application.listarConcursos),format.raw/*32.56*/("""">
             <img src=""""),_display_(/*33.25*/routes/*33.31*/.Assets.versioned("images/modificar.jpg")),format.raw/*33.72*/("""" class="img-circle person" alt="Random Name" width="304" height="236">
           </a>
         </div>
           <div class="col-sm-3">
             <h4>Eliminar concursos</h4><br>
             <a href=""""),_display_(/*38.24*/routes/*38.30*/.Application.listarConcursos),format.raw/*38.58*/("""">
               <img src=""""),_display_(/*39.27*/routes/*39.33*/.Assets.versioned("images/eliminar.jpg")),format.raw/*39.73*/("""" class="img-circle person" alt="Random Name" width="304" height="236">
             </a>
           </div>


       </div>
 </div>

       </div>
    </div>	
    </div> """))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object adminconcursos extends adminconcursos_Scope0.adminconcursos
              /*
                  -- GENERATED --
                  DATE: Thu Apr 13 13:42:45 COT 2017
                  SOURCE: /Users/Diego/ProyectosplayJava/supervoices/app/views/adminconcursos.scala.html
                  HASH: db76ec8a0938b2b6ccd1a35e90864107f5f5e0a9
                  MATRIX: 845->1|861->9|900->11|932->14|964->20|1398->427|1413->433|1462->461|1516->488|1531->494|1593->535|1830->745|1845->751|1891->776|1949->807|1964->813|2023->851|2259->1060|2274->1066|2323->1094|2377->1121|2392->1127|2454->1168|2687->1374|2702->1380|2751->1408|2807->1437|2822->1443|2883->1483
                  LINES: 32->1|32->1|32->1|34->3|36->5|49->18|49->18|49->18|50->19|50->19|50->19|56->25|56->25|56->25|57->26|57->26|57->26|63->32|63->32|63->32|64->33|64->33|64->33|69->38|69->38|69->38|70->39|70->39|70->39
                  -- GENERATED --
              */
          