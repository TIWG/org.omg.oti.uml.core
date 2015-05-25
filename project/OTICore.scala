import java.io.File

import com.banno.license.Plugin.LicenseKeys._
import com.typesafe.sbt.SbtGit._
import net.virtualvoid.sbt.graph.Plugin.graphSettings
import sbt.Keys._
import sbt._
import xerial.sbt.Pack._

object OTICore extends Build {


  lazy val scalazLibs = Project(
    "scalazLibs",
    file("scalazLibs")).settings(
      Defaults.coreDefaultSettings ++ Defaults.runnerSettings ++ Defaults.baseTasks ++ packSettings ++ Seq(
        scalaVersion := Versions.scala,
        packExpandedClasspath := true,
        libraryDependencies ++= Seq(
          "org.scalaz" %% "scalaz-core" % Versions.scalaz % "compile" withSources() withJavadoc()
        ),
        packExcludeJars := Seq("scala-.*\\.jar"),
        packExcludeArtifactTypes := Seq("src", "doc"),
        (mappings in pack) := {
          extraPackFun.value
        })
    )

  lazy val resolverLibs = Project(
    "resolverLibs",
    file("resolverLibs")).settings(
      Defaults.coreDefaultSettings ++ Defaults.runnerSettings ++ Defaults.baseTasks ++ packSettings ++ Seq(
        scalaVersion := Versions.scala,
        packExpandedClasspath := true,
        libraryDependencies ++= Seq(
          "xml-resolver" % "xml-resolver" % Versions.xmlResolver % "compile" withSources()
        ),
        packExcludeJars := Seq("scala-.*\\.jar"),
        packExcludeArtifactTypes := Seq("src", "doc"),
        (mappings in pack) := {
          extraPackFun.value
        }))

  lazy val emfLibs = Project(
    "emfLibs",
    file("emfLibs"),
    settings = Defaults.coreDefaultSettings ++ Defaults.runnerSettings ++ Defaults.baseTasks ++ Seq(
      scalaVersion := Versions.scala,
      libraryDependencies ++= Seq(
        "org.eclipse.emf" % "org.eclipse.emf.ecore" % Versions.emf_ecore % "provided" withSources() withJavadoc(),
        "org.eclipse.emf" % "org.eclipse.emf.ecore.xmi" % Versions.emf_ecore % "provided" withSources() withJavadoc(),
        "org.eclipse.emf" % "org.eclipse.emf.common" % Versions.emf_ecore % "provided" withSources() withJavadoc(),
        "org.scala-lang" % "scala-library" % Versions.scala % "provided" withSources() withJavadoc()
      ))
  )

  lazy val graphLibs = Project(
    "graphLibs",
    file("graphLibs")).settings(
      Defaults.coreDefaultSettings ++ Defaults.runnerSettings ++ Defaults.baseTasks ++ packSettings ++ Seq(
        scalaVersion := Versions.scala,
        packExpandedClasspath := true,
        libraryDependencies ++= Seq(
          "com.assembla.scala-incubator" %% "graph-core" % Versions.graph_core % "compile" withSources() withJavadoc(),
          "com.assembla.scala-incubator" %% "graph-constrained" % Versions.graph_constrained % "compile" withSources() withJavadoc(),
          "com.assembla.scala-incubator" %% "graph-json" % Versions.graph_json % "compile" withSources() withJavadoc(),
          "com.assembla.scala-incubator" %% "graph-dot" % Versions.graph_dot % "compile" withSources() withJavadoc()
        ),
        packExcludeJars := Seq("scala-.*\\.jar"),
        packExcludeArtifactTypes := Seq("src", "doc"),
        (mappings in pack) := {
          extraPackFun.value
        })
    )

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

  lazy val sourcePublishSettings = Seq(
    // include all test artifacts
    publishArtifact in Test := true
  )

  lazy val core = Project(
    "oti-core",
    file(".")).
    settings(otiSettings: _*).
    settings(commonSettings: _*).
    settings(packSettings: _*).
    settings(
        removeExistingHeaderBlock := true,
        clean <<= clean.dependsOn( clean in graphLibs, clean in resolverLibs, clean in scalazLibs, clean in emfLibs ),
        pack <<= pack.dependsOn( pack in graphLibs, pack in resolverLibs, pack in scalazLibs ),
        packExpandedClasspath := false,
        packLibJars := Seq.empty,
        packUpdateReports := Seq.empty,
        libraryDependencies ++= Seq(
          "org.scala-lang" % "scala-reflect" % Versions.scala % "provided" withSources() withJavadoc(),
          "org.scala-lang" % "scala-library" % Versions.scala % "provided" withSources() withJavadoc(),
          "org.scala-lang" % "scala-compiler" % Versions.scala % "provided" withSources() withJavadoc()
        ),
        scalaSource in Compile := baseDirectory.value / "src",
        unmanagedSourceDirectories in Compile += baseDirectory.value / "src-gen",
        classDirectory in Compile := baseDirectory.value / "bin",
        classDirectory in Test := baseDirectory.value / "bin",
        shellPrompt := { state => Project.extract(state).currentRef.project + " @ " + Project.extract(state).get(GitKeys.gitCurrentBranch) + "> " }
    ).dependsOn(
      scalazLibs,
      resolverLibs,
      emfLibs % "compile->provided",
      graphLibs)

  val extraPackFun: Def.Initialize[Task[Seq[(File, String)]]] = Def.task[Seq[(File, String)]] {
    def getFileIfExists(f: File, where: String): Option[(File, String)] = if (f.exists()) Some((f, s"$where/${f.getName}")) else None

    val ivyHome: File = Classpaths.bootIvyHome(appConfiguration.value) getOrElse sys.error("Launcher did not provide the Ivy home directory.")

    // this is a workaround; how should it be done properly in sbt?

    // goal: process the list of library dependencies of the project.
    // that is, we should be able to tell the classification of each library dependency module as shown in sbt:
    //
    // > show libraryDependencies
    // [info] List(
    //    org.scala-lang:scala-library:2.11.2, 
    //    org.scala-lang:scala-library:2.11.2:provided, 
    //    org.scala-lang:scala-compiler:2.11.2:provided, 
    //    org.scala-lang:scala-reflect:2.11.2:provided, 
    //    com.typesafe:config:1.2.1:compile, 
    //    org.scalacheck:scalacheck:1.11.5:compile, 
    //    org.scalatest:scalatest:2.2.1:compile, 
    //    org.specs2:specs2:2.4:compile, 
    //    org.parboiled:parboiled:2.0.0:compile)

    // but... libraryDependencies is a SettingKey (see ld below)
    // I haven't figured out how to get the sequence of modules from it.
    //val ld: SettingKey[Seq[ModuleID]] = libraryDependencies

    // workaround... I found this API that I managed to call...
    // this overrides the classification of all jars -- i.e., it is as if all library dependencies had been classified as "compile".

    // for now... it's a reasonable approaximation of the goal...
    val managed: Classpath = Classpaths.managedJars(Compile, classpathTypes.value, update.value)
    val result: Seq[(File, String)] = managed flatMap { af: Attributed[File] =>
      if (packExcludeJars.value.exists(af.data.name.matches)) Seq()
      else af.metadata.entries.toList flatMap { e: AttributeEntry[_] =>
        e.value match {
          case null => Seq()
          case m: ModuleID => Seq() ++
            getFileIfExists(new File(ivyHome, s"cache/${m.organization}/${m.name}/srcs/${m.name}-${m.revision}-sources.jar"), "lib.srcs") ++
            getFileIfExists(new File(ivyHome, s"cache/${m.organization}/${m.name}/docs/${m.name}-${m.revision}-javadoc.jar"), "lib.javadoc")
          case _ => Seq()
        }
      }
    }
    result
  }
}