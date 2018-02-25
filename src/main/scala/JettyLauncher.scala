import it.reply.data.devops.controller.Controller
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener


object JettyLauncher { // this is my entry object as specified in sbt project definition
  def main(args: Array[String]) {
    val port = if(System.getenv("PORT") != null) System.getenv("PORT").toInt else 10000

    val resBase = "src/main/webapp"
    //val resBase = "/opt/devops/realtime_ml/webapp"

    val server = new Server(port)
    val context = new WebAppContext()
    context.setContextPath("/")
    context.setResourceBase(resBase)
    context.addEventListener(new ScalatraListener)
    context.addServlet(classOf[Controller], "/")

    server.setHandler(context)

    server.start
    scala.io.Source.fromURL(s"http://localhost:$port/").mkString
  }
}