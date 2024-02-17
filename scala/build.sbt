ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "scala",
    idePackagePrefix := Some("org.whsv26.leetcode")
  )

libraryDependencies ++= List(
  "org.typelevel" %% "cats-core" % "2.9.0",
  "org.typelevel" %% "cats-effect" % "3.4.5",
  "co.fs2" %% "fs2-core" % "3.5.0",
)
