name := "XML-Processing"

version := "0.1"

crossScalaVersions := Seq("2.12.0", "2.11.8", "2.10.6")

scalaVersion := "2.12.5"

libraryDependencies := {
  libraryDependencies.value ++ Seq(
    "org.scala-lang.modules" %% "scala-xml" % "1.0.6",
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4")
}