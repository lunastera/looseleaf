val ScalaVersion = "2.12.10"
val ScalatraVersion = "2.7.0-RC1"

lazy val commonSettings = Seq(
  scalaVersion := ScalaVersion
)

lazy val directories = Seq(
  scalaSource in Test := (baseDirectory in Test).value / "test" / "scala"
)

lazy val looseleaf = (project in file(".")).
  enablePlugins(ScalatraPlugin).
  settings(commonSettings: _*).
  settings(directories: _*).
  settings(
    name := "looseleaf",
    version := "0.0.1",
    libraryDependencies ++= Seq(
      "org.scalatra" %% "scalatra" % ScalatraVersion,
      "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
      "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
      "org.eclipse.jetty" % "jetty-webapp" % "9.4.19.v20190610" % "container",
      "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
    )
  )