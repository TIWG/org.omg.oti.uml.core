import java.io.File

import com.banno.license.Plugin.LicenseKeys._
import net.virtualvoid.sbt.graph.Plugin.graphSettings
import sbt.Keys._
import sbt._
import com.typesafe.sbt.packager.universal.UniversalPlugin.autoImport._

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

  def addIfExists(f: File, name: String): Seq[(File, String)] =
    if (!f.exists) Seq()
    else Seq((f, name))

  val QUALIFIED_NAME = "^[a-zA-Z][\\w_]*(\\.[a-zA-Z][\\w_]*)*$".r

  lazy val core = Project(
    "oti-core",
    file(".")).
    enablePlugins(aether.AetherPlugin).
    enablePlugins(com.typesafe.sbt.packager.universal.UniversalPlugin).
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

      // the '*-resource.zip' archive will start from: 'dynamicScripts/<dynamicScriptsProjectName>'
      com.typesafe.sbt.packager.Keys.topLevelDirectory in Universal := {
        val dynamicScriptsProjectName = baseDirectory.value.getName
        require(
          QUALIFIED_NAME.pattern.matcher(dynamicScriptsProjectName).matches,
          s"The project name, '$dynamicScriptsProjectName` is not a valid Java qualified name")
        Some("dynamicScripts/" + dynamicScriptsProjectName)
      },

      // name the '*-resource.zip' in the same way as other artifacts
      com.typesafe.sbt.packager.Keys.packageName in Universal :=
        normalizedName.value + "_" + scalaBinaryVersion.value + "-" + version.value + "-resource",

      // contents of the '*-resource.zip' to be produced by 'universal:packageBin'
      mappings in Universal <++= (baseDirectory,
        packageBin in Compile, packageSrc in Compile, packageDoc in Compile,
        packageBin in Test, packageSrc in Test, packageDoc in Test) map {
        (dir, bin, src, doc, binT, srcT, docT) =>
          (dir ** "*.dynamicScripts").pair(relativeTo(dir)) ++
            ((dir ** "*.md") --- (dir / "sbt.staging" ***)).pair(relativeTo(dir)) ++
            (dir / "models" ** "*.mdzip").pair(relativeTo(dir)) ++
            com.typesafe.sbt.packager.MappingsHelper.directory(dir / "resources") ++
            addIfExists(bin, "lib/" + bin.name) ++
            addIfExists(binT, "lib/" + binT.name) ++
            addIfExists(src, "lib.sources/" + src.name) ++
            addIfExists(srcT, "lib.sources/" + srcT.name) ++
            addIfExists(doc, "lib.javadoc/" + doc.name) ++
            addIfExists(docT, "lib.javadoc/" + docT.name)
      },

      // add the '*-resource.zip' to the list of artifacts to publish; note that '.zip' will change to '.jar'
      artifacts <+= (name in Universal) { n => Artifact(n, "jar", "jar", Some("resource"), Seq(), None, Map()) },
      packagedArtifacts <+= (packageBin in Universal, name in Universal) map { (p, n) =>
        Artifact(n, "jar", "jar", Some("resource"), Seq(), None, Map()) -> p
      },

      aether.AetherKeys.aetherArtifact <<=
        (aether.AetherKeys.aetherCoordinates,
          aether.AetherKeys.aetherPackageMain,
          makePom in Compile,
          packagedArtifacts in Compile) map {
          (coords: aether.MavenCoordinates, mainArtifact: File, pom: File, artifacts: Map[Artifact, File]) =>
            aether.AetherPlugin.createArtifact(artifacts, pom, coords, mainArtifact)
        },

      shellPrompt := { state => Project.extract(state).currentRef.project + " @ " + Versions.version_suffix + "> " }
    )

}