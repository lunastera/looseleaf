val ScalaVersion = "2.12.10"
val ScalatraVersion = "2.7.0-RC1"
val CirceVersion = "0.12.3"
val ScalacOptions = Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-Xlint",
  "-Ywarn-unused:-imports,-implicits",
  "-language:implicitConversions",
  "-language:higherKinds"
)

lazy val commonSettings = Seq(
  scalaVersion := ScalaVersion,
  scalacOptions ++= ScalacOptions
)

lazy val directories = Seq(
  scalaSource in Test := (baseDirectory in Test).value / "test" / "scala",
  sourceDirectory in webappPrepare := baseDirectory.value / "webapp"
)

val circeDependencies = Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % CirceVersion)

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
      "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
      "com.typesafe.slick" %% "slick" % "3.3.2",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2",
      "mysql" % "mysql-connector-java" % "5.1.47"
    ),
    libraryDependencies ++= circeDependencies,
    unmanagedResourceDirectories in Compile += (sourceDirectory in webappPrepare).value
  )
