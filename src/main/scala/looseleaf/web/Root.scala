package looseleaf
package web

import org.scalatra.Ok

trait Root {
  self: Servlet =>

  get("/") {
    Ok("Hello")
  }
}
