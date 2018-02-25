package it.reply.data.devops.controller

import org.scalatra.{FlashMapSupport, ScalatraServlet}
import org.scalatra.scalate.ScalateSupport

class TestController extends ScalatraServlet with FlashMapSupport with ScalateSupport {

  var CONF_DIR = "conf"
  var CONFIG_FILE = "RealTimeML_staging.conf"
  var controller : Controller = null

  def initController() = {
    controller = new Controller
    controller.initEngine()
  }


  get("/isOnline"){

    if(controller == null)
      initController()

    "Status OK"
  }

  get("/status"){

    if(controller == null)
      initController()

    var status = "Status:\n"
    status += s"foo init:${controller.foo != null}\n"

    status
  }

  get("/answer"){

    if(controller == null)
      initController()

    s"${controller.foo.answer()}"
  }

  get("/advice"){

    if(controller == null)
      initController()

    s"${controller.foo.advice()}"
  }


  get("/test1"){
    "test1"
  }

  get("/"){
    "hello"
  }
}
