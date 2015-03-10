import sbt._
import Keys._

object CommonPlayTemplatesBuild extends Build {

  val appReleaseSettings = Seq(
    // Publishing options:
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { x => false },
    publishTo <<= version { (v: String) =>
      val nexus = "https://defranexus.kainos.com/"
      if (v.trim.endsWith("SNAPSHOT"))
        Some("sonatype-snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("sonatype-releases"  at nexus + "content/repositories/releases")
    },
    credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
  )

  def defaultResolvers = Seq(
    "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
    "DEFRA Nexus Release repo" at "https://defranexus.kainos.com/content/repositories/releases/",
    "DEFRA Nexus Snapshot repo" at "https://defranexus.kainos.com/content/repositories/snapshots/"
  )

  val standardSettings = appReleaseSettings ++ Seq(
    organization := "uk.gov.defra",
    scalaVersion := "2.10.2",
    autoScalaLibrary := false
  )

  lazy val capdExternalUserAuthApi = Project("capd-common-play-templates", file("."),
    settings = standardSettings).settings(
    crossPaths := false,
    resolvers ++= defaultResolvers
  ).enablePlugins(play.twirl.sbt.SbtTwirl)

}