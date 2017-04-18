
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
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

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/main("")/*3.10*/ {_display_(Seq[Any](format.raw/*3.12*/("""

""")))}),format.raw/*5.2*/("""

    """),format.raw/*7.5*/("""<div class="panel panel-primary">
      <div class="panel-heading"></div>
      <div class="panel-body"></div>

  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1" ></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src=""""),_display_(/*21.20*/routes/*21.26*/.Assets.versioned("images/Microfono-vintage.jpg")),format.raw/*21.75*/("""">
        <div class="carousel-caption">
          <div>Bienvenido</div>
          <h3>a Supervoices</h3>
        </div>
      </div>

      <div class="item">
        <img src=""""),_display_(/*29.20*/routes/*29.26*/.Assets.versioned("images/Microfono-vintage2.jpg")),format.raw/*29.76*/("""" >
        <div class="carousel-caption ">
          <h3>visita nuestro sitio y</h3>
          <div >Conócenos</div>

        </div>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <div class="bg-1">
    <div id="quienes" class="container">
      <h3 class="text-center titulos">NOSOTROS</h3>
    <p class="textnosotros text-center">Somos una plataforma dedicada a ofrerte el sevicio de<br>
      publicación de convocatorias, para que encuentres la voz<br> que estás necesitando</p>
      </div>
    </div>
  <div id="valor" class="container text-center">
    <h2><strong>QUE TE OFRECEMOS</strong></h2>
    <p></p>
  <br>
   <div class="row">
     <div class="col-sm-4">
       <p class="text-center"><strong>Crea y publica tus convocatorias</strong></p><br>
       <a href="#demo" data-toggle="collapse">
         <img src=""""),_display_(/*63.21*/routes/*63.27*/.Assets.versioned("images/Locutor.jpg")),format.raw/*63.66*/("""" class="img-circle person" alt="Random Name" width="304" height="236">
       </a>
       <div id="demo" class="collapse">
         <p>Puedes crear tus convocatorias y</p>
         <p>publicarlas en nuestra aplicación.</p>
         <p>Personas al rededor del mundo la </p>
         <p>podrán consultar</p>
       </div>
     </div>
     <div class="col-sm-4">
       <p class="text-center"><strong>Conversión de los archivos de audio</strong></p><br>
       <a href="#demo2" data-toggle="collapse">
         <img src=""""),_display_(/*75.21*/routes/*75.27*/.Assets.versioned("images/FormatosArchivo.jpg")),format.raw/*75.74*/("""" class="img-circle person" alt="Random Name" width="304" height="236">
       </a>
       <div id="demo2" class="collapse">
         <p>No importa el formato de audio del </p>
         <p>archivo nosotros lo convertimos a MP3 </p>
         <p>y lo dejamos listo para que tu lo</p>
         <p>escuches</p>
       </div>
     </div>
     <div class="col-sm-4">
       <p class="text-center"><strong>Escucha las voces inscritas en tu concurso</strong></p><br>
       <a href="#demo3" data-toggle="collapse">
         <img src=""""),_display_(/*87.21*/routes/*87.27*/.Assets.versioned("images/Locutor.jpg")),format.raw/*87.66*/("""" class="img-circle person" alt="Random Name" width="304" height="236">
       </a>
       <div id="demo3" class="collapse">
         <p>Te damos la opcion de escuchar cada una</p>
         <p>de las voces de tu concurso, sin tener  </p>
         <p>que bajarlas.</p>
       </div>
     </div>
   </div>
   </div>
   
      </div>
    </div>	
    </div> 
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
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Thu Apr 13 13:42:46 COT 2017
                  SOURCE: /Users/Diego/ProyectosplayJava/supervoices/app/views/index.scala.html
                  HASH: 4391ac62444560b6f310304ef660fbb613749d71
                  MATRIX: 738->1|834->3|862->6|878->14|917->16|949->19|981->25|1527->544|1542->550|1612->599|1819->779|1834->785|1905->835|3227->2130|3242->2136|3302->2175|3849->2695|3864->2701|3932->2748|4486->3275|4501->3281|4561->3320
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|38->7|52->21|52->21|52->21|60->29|60->29|60->29|94->63|94->63|94->63|106->75|106->75|106->75|118->87|118->87|118->87
                  -- GENERATED --
              */
          