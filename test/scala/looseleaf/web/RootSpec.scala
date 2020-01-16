package looseleaf

import org.scalatra.test.scalatest._

class RootSpec extends ScalatraFunSuite {

  addServlet(classOf[web.Router], "/*")

  test("GET / should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

}
