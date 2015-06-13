import java.io.File

import com.banno.license.Plugin.LicenseKeys._
import com.typesafe.sbt.GitVersioning
import net.virtualvoid.sbt.graph.Plugin.graphSettings
import sbt.Keys._
import sbt._

object OTICore extends Build {

  // ======================

  lazy val otiSettings = Seq(
    scalaVersion := Versions.scala,
    organization := "gov.nasa.jpl.mbee.omg.oti",
    organizationName := "JPL, Caltech & Object Management Group",
    organizationHomepage := Some(url("http://solitaire.omg.org/browse/TIWG")),

    // include repositories used in module configurations into the POM repositories section
    pomAllRepositories := true,

    // publish Maven POM metadata (instead of Ivy); this is important for the UpdatesPlugin's ability to find available updates.
    publishMavenStyle := true) ++
    ((Option.apply(System.getProperty("OTI_LOCAL_REPOSITORY")), Option.apply(System.getProperty("OTI_REMOTE_REPOSITORY"))) match {
      case (Some(dir), _) =>
        if (new File(dir) / "settings.xml" exists) {
          val cache = new MavenCache("JPL-OMG", new File(dir))
          Seq(
            publishTo := Some(cache),
            resolvers += cache)
        }
        else
          sys.error(s"The OTI_LOCAL_REPOSITORY folder, '$dir', does not have a 'settings.xml' file.")
      case (None, Some(url)) => {
        val repo = new MavenRepository("JPL-OMG", url)
        Seq(
          publishTo := Some(repo),
          resolvers += repo)
      }
      case _ => sys.error("Set either -DOTI_LOCAL_REPOSITORY=<dir> or -DOTI_REMOTE_REPOSITORY=<url> where <dir> is a local Maven repository directory or <url> is a remote Maven repository URL")
    })

  lazy val commonSettings =
    Defaults.coreDefaultSettings ++
      Defaults.runnerSettings ++
      Defaults.baseTasks ++
      graphSettings ++
      com.banno.license.Plugin.licenseSettings ++
      aether.AetherPlugin.autoImport.overridePublishSettings ++
      Seq(
        sourceDirectories in Compile ~= { _.filter(_.exists) },
        sourceDirectories in Test ~= { _.filter(_.exists) },
        unmanagedSourceDirectories in Compile ~= { _.filter(_.exists) },
        unmanagedSourceDirectories in Test ~= { _.filter(_.exists) },
        unmanagedResourceDirectories in Compile ~= { _.filter(_.exists) },
        unmanagedResourceDirectories in Test ~= { _.filter(_.exists) }
      )

  lazy val core = Project(
    "oti-core",
    file(".")).
    enablePlugins(aether.AetherPlugin).
    settings(otiSettings: _*).
    settings(commonSettings: _*).
    settings(
      version := Versions.version,
      removeExistingHeaderBlock := true,
      libraryDependencies ++= Seq(
        "org.scala-lang" % "scala-reflect" % Versions.scala % "provided" withSources() withJavadoc(),
        "org.scala-lang" % "scala-library" % Versions.scala % "provided" withSources() withJavadoc(),
        "org.scala-lang" % "scala-compiler" % Versions.scala % "provided" withSources() withJavadoc(),
        "org.scalaz" %% "scalaz-core" % Versions.scalaz % "compile" withSources() withJavadoc(),
        "xml-resolver" % "xml-resolver" % Versions.xmlResolver % "compile" withSources(),
        "com.assembla.scala-incubator" %% "graph-core" % Versions.graph_core % "compile" withSources() withJavadoc(),
        "com.assembla.scala-incubator" %% "graph-constrained" % Versions.graph_constrained % "compile" withSources() withJavadoc(),
        "com.assembla.scala-incubator" %% "graph-json" % Versions.graph_json % "compile" withSources() withJavadoc(),
        "com.assembla.scala-incubator" %% "graph-dot" % Versions.graph_dot % "compile" withSources() withJavadoc()
      ),
      scalaSource in Compile := baseDirectory.value / "src",
      unmanagedSourceDirectories in Compile += baseDirectory.value / "src-gen",
      classDirectory in Compile := baseDirectory.value / "bin",
      resourceDirectory in Compile := baseDirectory.value / "resources",
      shellPrompt := { state => Project.extract(state).currentRef.project + " @ " + Versions.version_suffix + "> " }
    )

}