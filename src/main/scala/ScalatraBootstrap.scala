import javax.servlet.ServletContext

import com.typesafe.config.ConfigFactory
import it.reply.data.devops.controller.Controller
import org.scalatra.LifeCycle

class ScalatraBootstrap extends LifeCycle{

  override def init(context: ServletContext) {
    context.mount(new Controller, "/*")
  }

}
