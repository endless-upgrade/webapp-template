package it.reply.data.devops.controller

import java.io.File

import com.typesafe.config.ConfigFactory
import it.reply.data.devops.engine.Foo
import it.reply.data.devops.view._
import org.scalatra.scalate.ScalateSupport
import org.scalatra.{FlashMapSupport, ScalatraServlet}

import scala.xml.Node
import scala.xml.Elem


class Controller extends ScalatraServlet with FlashMapSupport with ScalateSupport{

  var CONF_DIR = "conf"
  var CONFIG_FILE = "application.conf"

  var foo : Foo = null

  private def displayPage(title:String, content:Seq[Node]) =
    Template.page(title, content, url(_))

  private def displayError() = TemplateNotFound.page(url(_))

  def initEngine() : Unit = {

    val config = ConfigFactory.load()
    foo = Foo()
  }

  get("/") {

    if(foo == null)
    {
      initEngine()
    }

    val toggles = ConfigFactory.parseFile(new File("conf/application.conf"))

    var hello = "Ehi! Benvenuto in questa bellissima web app :D\n"
    hello += "Usa la barra di navigazione ...\n"
    hello += "... Feel The User Experience\n"
    hello += "Features:\n"

    if(toggles.getBoolean("toggle.engine.answer"))
      hello += "/answer\n"

    if(toggles.getBoolean("toggle.engine.advice"))
      hello += "/advice\n"

    hello
  }

  get("/answer") {

    val enable = ConfigFactory
      .parseFile(new File("conf/application.conf"))
      .getBoolean("toggle.engine.answer")

    if(enable){
      if(foo == null)
        initEngine()

      foo.answer()
    }
    else
      displayError()
  }

  get("/advice") {

    val enable = ConfigFactory
      .parseFile(new File("conf/application.conf"))
      .getBoolean("toggle.engine.advice")

    if(enable){

      if(foo == null)
        initEngine()

      foo.advice()

    }
    else
      displayError()
  }

  get("/isOnline") {
    "is Online"
  }
}

