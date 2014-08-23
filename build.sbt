
name := "twilio-scala"

organization := "com.failfast"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.4"

resolvers ++= Seq(
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "Sonatype releases"  at "https://oss.sonatype.org/content/repositories/releases/",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "ch.qos.logback"      % "logback-classic"  % "1.0.13",
  "io.spray"            % "spray-can"        % "1.3.1",
  "io.spray"            % "spray-http"    % "1.3.1",
  "io.spray"            % "spray-client"    % "1.3.1",
  "com.typesafe.akka"  %% "akka-actor"       % "2.3.0",
  "com.typesafe.akka"  %% "akka-slf4j"       % "2.3.0",
  "io.spray"            % "spray-httpx"    % "1.3.1",
  "io.spray"            % "spray-util"    % "1.3.1",
  "io.spray" %%  "spray-json" % "1.2.6",
  "com.typesafe"         %   "config"            % "1.0.0",
  "com.typesafe"        %% "scalalogging-slf4j" % "1.0.1",
  "org.pegdown"         % "pegdown" % "1.4.2",
  "commons-io" % "commons-io" % "2.4",
  "commons-codec" % "commons-codec" % "1.9",
  "org.apache.commons"   % "commons-lang3"          % "3.1",
  "org.scalautils" % "scalautils_2.10" % "2.0",
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
)
