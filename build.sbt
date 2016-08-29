
import sbt.Keys._
import sbt._

import de.heikoseeberger.sbtheader.HeaderPlugin
import de.heikoseeberger.sbtheader.HeaderPattern
import de.heikoseeberger.sbtheader.license.CommentBlock

import gov.nasa.jpl.imce.sbt._
import gov.nasa.jpl.imce.sbt.ProjectHelper._
import scala.util.matching.Regex

useGpg := true

updateOptions := updateOptions.value.withCachedResolution(true)

developers := List(
  Developer(
    id="NicolasRouquette",
    name="Nicolas F. Rouquette",
    email="nicolas.f.rouquette@jpl.nasa.gov",
    url=url("https://github.com/NicolasRouquette")),
  Developer(
    id="melaasar",
    name="Maged Elaasar",
    email="maged.elaasar@jpl.nasa.gov",
    url=url("https://gateway.jpl.nasa.gov/personal/melaasar/default.aspx")),
  Developer(
    id="ybernard",
    name="Yves Bernard",
    email="yves.bernard@airbus.com",
    url=url("http://airbus.com")),
  Developer(
    id="CodyLanier",
    name="Cody Lanier",
    email="cody.lanier@jpl.nasa.gov",
    url=url("http://airbus.com")),
  Developer(
    id="SebastianHerzig",
    name="Sebastian Herzig",
    email="sebastian.j.herzig@jpl.nasa.gov",
    url=url("https://gateway.jpl.nasa.gov/personal/sherzig/default.aspx")))

lazy val core = Project("oti-uml-core", file("."))
  .enablePlugins(IMCEGitPlugin)
  .enablePlugins(IMCEReleasePlugin)
  .settings(IMCEReleasePlugin.packageReleaseProcessSettings)
  .settings(dynamicScriptsResourceSettings(Some("org.omg.oti.uml.core")))
  .settings(OTICoreLicenseSettings)
  .settings(IMCEPlugin.strictScalacFatalWarningsSettings)
  //.settings(IMCEPlugin.scalaDocSettings(diagrams=false))
  .settings(
    IMCEKeys.licenseYearOrRange := "2014-2016",
    IMCEKeys.organizationInfo := IMCEPlugin.Organizations.oti,
    IMCEKeys.targetJDK := IMCEKeys.jdk18.value,

    // @todo add this to the imce.sbt.plugin
    scalacOptions in (Compile,doc) += "-no-link-warnings",

    organization := "org.omg.tiwg",
    organizationHomepage :=
      Some(url("http://www.omg.org/members/sysml-rtf-wiki/doku.php?id=rtf5:groups:tools_infrastructure:index")),

    buildInfoPackage := "org.omg.oti.uml.core",
    buildInfoKeys ++= Seq[BuildInfoKey](BuildInfoKey.action("buildDateUTC") { buildUTCDate.value }),

    mappings in (Compile, packageSrc) ++= {
      import Path.{flat, relativeTo}
      val base = (sourceManaged in Compile).value
      val srcs = (managedSources in Compile).value
      srcs x (relativeTo(base) | flat)
    },

    projectID := {
      val previous = projectID.value
      previous.extra(
        "build.date.utc" -> buildUTCDate.value,
        "artifact.kind" -> "generic.library")
    },

    git.baseVersion := Versions.version,
    organizationName := "JPL, Caltech, Airbus & Object Management Group",
    organizationHomepage := Some(url("http://solitaire.omg.org/browse/TIWG")),

    scalaSource in Compile := baseDirectory.value / "svn" / "src",
    unmanagedSourceDirectories in Compile += baseDirectory.value / "svn" / "src-gen",

    scalacOptions in(Compile, doc) ++= Seq(
      "-diagrams",
      "-doc-title", name.value,
      "-doc-root-content", baseDirectory.value + "/rootdoc.txt"
    ),

    resourceDirectory in Compile := baseDirectory.value / "svn" / "resources",

    extractArchives := {},

    libraryDependencies ++= Seq (
      "gov.nasa.jpl.imce.thirdParty" %% "other-scala-libraries" % Versions_other_scala_libraries.version artifacts
      Artifact("other-scala-libraries", "zip", "zip", Some("resource"), Seq(), None, Map())
    ),

    IMCEKeys.nexusJavadocRepositoryRestAPIURL2RepositoryName := Map(
       "https://oss.sonatype.org/service/local" -> "releases",
       "https://cae-nexuspro.jpl.nasa.gov/nexus/service/local" -> "JPL"),
    IMCEKeys.pomRepositoryPathRegex := """\<repositoryPath\>\s*([^\"]*)\s*\<\/repositoryPath\>""".r

  )
  .dependsOnSourceProjectOrLibraryArtifacts(
    "org-omg-oti-uml-json",
    "org.omg.oti.uml.json",
    Seq(
      "org.omg.tiwg" %% "org-omg-oti-uml-json"
        % Versions_oti_uml_json.version % "compile" withSources() withJavadoc() artifacts
        Artifact("org-omg-oti-uml-json", "zip", "zip", Some("resource"), Seq(), None, Map())
    )
  )

def dynamicScriptsResourceSettings(dynamicScriptsProjectName: Option[String] = None): Seq[Setting[_]] = {

  import com.typesafe.sbt.packager.universal.UniversalPlugin.autoImport._

  def addIfExists(f: File, name: String): Seq[(File, String)] =
    if (!f.exists) Seq()
    else Seq((f, name))

  val QUALIFIED_NAME = "^[a-zA-Z][\\w_]*(\\.[a-zA-Z][\\w_]*)*$".r

  Seq(
    // the '*-resource.zip' archive will start from: 'dynamicScripts/<dynamicScriptsProjectName>'
    com.typesafe.sbt.packager.Keys.topLevelDirectory in Universal := {
      val projectName = dynamicScriptsProjectName.getOrElse(baseDirectory.value.getName)
      require(
        QUALIFIED_NAME.pattern.matcher(projectName).matches,
        s"The project name, '$projectName` is not a valid Java qualified name")
      Some(projectName)
    },

    // name the '*-resource.zip' in the same way as other artifacts
    com.typesafe.sbt.packager.Keys.packageName in Universal :=
      normalizedName.value + "_" + scalaBinaryVersion.value + "-" + version.value + "-resource",

    // contents of the '*-resource.zip' to be produced by 'universal:packageBin'
    mappings in Universal <++= (
      baseDirectory,
      packageBin in Compile,
      packageSrc in Compile,
      packageDoc in Compile,
      packageBin in Test,
      packageSrc in Test,
      packageDoc in Test) map {
      (base, bin, src, doc, binT, srcT, docT) =>
        val dir = base / "svn"
          (dir ** "*.md").pair(relativeTo(dir)) ++
          com.typesafe.sbt.packager.MappingsHelper.directory(dir / "resources") ++
          addIfExists(bin, "lib/" + bin.name) ++
          addIfExists(binT, "lib/" + binT.name) ++
          addIfExists(src, "lib.sources/" + src.name) ++
          addIfExists(srcT, "lib.sources/" + srcT.name) ++
          addIfExists(doc, "lib.javadoc/" + doc.name) ++
          addIfExists(docT, "lib.javadoc/" + docT.name)
    },

    artifacts <+= (name in Universal) { n => Artifact(n, "zip", "zip", Some("resource"), Seq(), None, Map()) },
    packagedArtifacts <+= (packageBin in Universal, name in Universal) map { (p, n) =>
      Artifact(n, "zip", "zip", Some("resource"), Seq(), None, Map()) -> p
    }
  )
}

val oti_uml_core_license =
  s"""|Copyright 2014 California Institute of Technology ("Caltech").
      |U.S. Government sponsorship acknowledged.
      |
      |Copyright 2015 Airbus.
      |
      |Licensed under the Apache License, Version 2.0 (the "License");
      |you may not use this file except in compliance with the License.
      |You may obtain a copy of the License at
      |
      |    http://www.apache.org/licenses/LICENSE-2.0
      |
      |Unless required by applicable law or agreed to in writing, software
      |distributed under the License is distributed on an "AS IS" BASIS,
      |WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
      |See the License for the specific language governing permissions and
      |limitations under the License.
      |License Terms
      |""".stripMargin

val OTICoreLicenseSettings : Seq[Setting[_]] =
  Seq(
    startYear := Some(2014),

    headers := Map("scala" -> (HeaderPattern.cStyleBlockComment, CommentBlock.cStyle(oti_uml_core_license)))
  )