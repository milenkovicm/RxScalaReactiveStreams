import sbt._

object Version {
  final val Scala      = "2.11.8"
  final val RxScala    = "0.26.2"
  final val RxStreams  = "1.1.0"
  final val ScalaTest  = "2.2.6"
}

object Library {
  val rxScala    = "io.reactivex"   %% "rxscala"                  % Version.RxScala
  val rxStreams  = "io.reactivex"   %  "rxjava-reactive-streams"  % Version.RxStreams
  val scalaTest  = "org.scalatest"  %% "scalatest"                % Version.ScalaTest
}
