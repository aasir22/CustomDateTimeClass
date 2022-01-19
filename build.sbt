val common = Seq(
  version := "0.1",
  scalaVersion := "2.13.8"

)

lazy val internProject = (project in file("."))
  .settings(common)
  .settings(
    name := "InternProject",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test

  )
  .dependsOn(dateTimeWithNScala)

lazy val dateTimeWithNScala = (project in file("DateTimeWithNscala"))
  .settings(common)
  .settings(
    name := "DateTimeWithNscala",
    libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.30.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
  )

//assemblyJarName in assembly := "first-fatjar-1.0.jar"

enablePlugins(ClassDiagramPlugin)

