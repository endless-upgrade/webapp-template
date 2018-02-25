name := "WebAppTemplate"

version := "0.1"

scalaVersion := "2.11.8"

val ScalatraVersion = "2.6.+"


libraryDependencies ++= Seq(
  "org.scalatra"            %% "scalatra"                     % ScalatraVersion,
  "org.scalatra"            %% "scalatra-scalate"             % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2"              % ScalatraVersion     % "test",
  "ch.qos.logback"          % "logback-classic"               % "1.2.3"             % "runtime; compile",
  "org.eclipse.jetty"       % "jetty-webapp"                  % "9.2.15.v20160210"  % "container;compile",
  "javax.servlet"           %  "javax.servlet-api"            % "3.1.0"             % "container;compile",
  "org.scalatra"            %% "scalatra-scalatest"           % "2.6.2"             % "test"
)

libraryDependencies ++= Seq(
  "com.typesafe"            %  "config"                       % "1.3.2",
)

enablePlugins(JettyPlugin)


assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

test in assembly := {}