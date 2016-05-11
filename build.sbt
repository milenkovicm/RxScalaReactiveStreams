lazy val noIdea = project
  .copy(id = "RxScalaReactiveStreams")
  .in(file("."))
  .enablePlugins(AutomateHeaderPlugin, GitVersioning)

name := "RxScalaReactiveStreams"

libraryDependencies ++= Vector(
  Library.scalaTest % "test", Library.rxScala, Library.rxStreams
)

scalafmtConfig := Some(file(".scalafmt"))

initialCommands := """|import com.github.milenkovicm.rxscala.reactivestreams._
                      |""".stripMargin
