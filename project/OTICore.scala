import java.io.File

import com.banno.license.Plugin.LicenseKeys._
import com.typesafe.sbt.SbtGit._
import net.virtualvoid.sbt.graph.Plugin.graphSettings
import sbt.Keys._
import sbt._
import xerial.sbt.Pack._

object OTICore extends Build {

  // ======================

  lazy val otiSettings = Seq(
    scalaVersion := Versions.scala,
    organization := "gov.nasa.jpl.mbee.omg.oti",
    organizationName := "JPL, Caltech",
    organizationHomepage := Some(url("https://mbse.jpl.nasa.gov")),
    publishMavenStyle := false,
    publishTo := {
      Option.apply(System.getProperty("OTI_LOCAL_REPOSITORY")) match {
        case Some(dir) => Some(Resolver.file("file", new File(dir))(Resolver.ivyStylePatterns))
        case None => sys.error("Set -DOTI_LOCAL_REPOSITORY=<dir> where <dir> is a local Ivy repository directory")
      }
    },
    resolvers += {
      Option.apply(System.getProperty("OTI_LOCAL_REPOSITORY")) match {
        case Some(dir) => Resolver.file("file", new File(dir))(Resolver.ivyStylePatterns)
        case None => sys.error("Set -DOTI_LOCAL_REPOSITORY=<dir> where <dir> is a local Ivy repository directory")
      }
    }
  )

  lazy val commonSettings =
    Defaults.coreDefaultSettings ++
      Defaults.runnerSettings ++
      Defaults.baseTasks ++
      graphSettings ++
      com.banno.license.Plugin.licenseSettings

  lazy val core = Project(
    "oti-core",
    file(".")).
    settings(otiSettings: _*).
    settings(commonSettings: _*).
    settings(packSettings: _*).
    settings(        
        version := "0.12.0-" + {
          val svnProc = Process(command="svn", arguments=Seq("info"))
          val sedCommand="s/^.*Revision:[[:space:]]\\{1,\\}\\([[:digit:]]\\{1,\\}\\).*$/\\1/p"
          val sedProc = Process(command="sed", arguments=Seq("-n", sedCommand))
          val svnRevision = svnProc.#|(sedProc).!!
          svnRevision
        },
        removeExistingHeaderBlock := true,
        packExpandedClasspath := false,
        packLibJars := Seq.empty,
        packUpdateReports := Seq.empty,
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
        shellPrompt := { state => Project.extract(state).currentRef.project + " @ " + Project.extract(state).get(GitKeys.gitCurrentBranch) + "> " }
    )

}