name := "Week 5 part 2 Calculator"

version := "0.1"

scalaVersion := "2.13.5"

val AkkaVersion = "2.6.13"
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.2.3",

)