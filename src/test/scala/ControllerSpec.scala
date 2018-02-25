import java.io.File

import org.scalatest.BeforeAndAfterAll
import org.scalatra.test.scalatest.ScalatraFlatSpec
import com.typesafe.config._
import it.reply.data.devops.controller.TestController


class ControllerSpec extends ScalatraFlatSpec with BeforeAndAfterAll {

  var CONF_DIR = "conf"
  var CONF_FILE = s"$CONF_DIR/application.conf"

  var config : Config = null

  override def beforeAll(): Unit = {
    super.beforeAll()

    println(s"CONF FILE ->>>>>>> ${CONF_FILE}\n\n\n\n\n")

    config = ConfigFactory.parseFile(new File(CONF_FILE))
  }

  addServlet(classOf[TestController], "/test/*")

  "Test root api" should "be online and show hello" in {
    get("/test"){

      println(body)

      status should equal (200)
      body should include ("hello")
    }
  }

  "Test nested api" should "be online and show test1" in {
    get("/test/test1"){

      println(body)

      status should equal (200)
      body should include ("test1")
    }
  }

  "The Controller" must "be online" in {
    get("/test/isOnline"){
      status should equal (200)
      body should include ("Status OK")
    }
  }

  it must "be initialized" in {
    get("/test/status"){
      status should equal (200)
      body should include ("foo init:true")
    }
  }

  it must "return the answer" in {
    get("/test/answer"){
      assert(status equals 200)

      println("\n\n\n\n\n"+body+"\n\n\n\n\n\n\n")

      assert(body.contains("42"))
    }
  }

  it must "return the advice" in {
    get("/test/advice"){
      assert(status equals 200)

      println("\n\n\n\n\n"+body+"\n\n\n\n\n\n\n")

      assert(body.contains("Don't panic!!"))
    }
  }

}
