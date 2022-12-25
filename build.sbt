import java.lang.management.ManagementFactory

val scala3Version = "3.2.1"

// https://stackoverflow.com/a/25762258
lazy val debugMode = settingKey[Boolean]("Is -Xdebug set?")
debugMode := ManagementFactory.getRuntimeMXBean.getInputArguments.contains("-Xdebug")

lazy val root = project
  .in(file("."))
  .settings(
    name := "demofx",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    scalacOptions += "-indent",
    run / fork := !debugMode.value,
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "org.scalafx" %% "scalafx" % "19.0.0-R30",
      "com.lihaoyi" %% "ujson" % "2.0.0",
      "com.lihaoyi" %% "requests" % "0.7.1"
    )
  )
