
import sbt.Keys._
import sbt._

import gov.nasa.jpl.imce.sbt._

useGpg := true

developers := List(
  Developer(
    id="rouquett",
    name="Nicolas F. Rouquette",
    email="nicolas.f.rouquette@jpl.nasa.gov",
    url=url("https://gateway.jpl.nasa.gov/personal/rouquett/default.aspx")),
  Developer(
    id="melaasar",
    name="Maged Elaasar",
    email="maged.elaasar@jpl.nasa.gov",
    url=url("https://gateway.jpl.nasa.gov/personal/melaasar/default.aspx")),
  Developer(
    id="ybernard",
    name="Yves Bernard",
    email="yves.bernard@airbus.com",
    url=url("http://airbus.com")))

lazy val buildUTCDate = SettingKey[String]("build-utc-date", "The UDC Date of the build")

buildUTCDate in Global := {
  import java.util.{ Date, TimeZone }
  val formatter = new java.text.SimpleDateFormat("yyyy-MM-dd-HH:mm")
  formatter.setTimeZone(TimeZone.getTimeZone("UTC"))
  formatter.format(new Date)
}

lazy val core = Project("oti-core", file("."))
  .enablePlugins(IMCEGitPlugin)
  .enablePlugins(IMCEReleasePlugin)
  .settings(IMCEPlugin.dynamicScriptsProjectResourceSettings(Some("gov.nasa.jpl.omf.scala.binding.owlapiorg.omg.oti")))
  .settings(IMCEPlugin.strictScalacFatalWarningsSettings)
  .settings(IMCEPlugin.scalaDocSettings(diagrams=false))
  .settings(
    IMCEKeys.licenseYearOrRange := "2014-2016",
    IMCEKeys.organizationInfo := IMCEPlugin.Organizations.oti,
    IMCEKeys.targetJDK := IMCEKeys.jdk17.value,

    buildInfoPackage := "org.omg.oti",
    buildInfoKeys ++= Seq[BuildInfoKey](BuildInfoKey.action("buildDateUTC") { buildUTCDate.value }),

    mappings in (Compile, packageSrc) ++= {
      import Path.{flat, relativeTo}
      val base = (sourceManaged in Compile).value
      val srcs = (managedSources in Compile).value
      srcs x (relativeTo(base) | flat)
    },

    projectID := {
      val previous = projectID.value
      previous.extra("build.date.utc" -> buildUTCDate.value)
    },

    git.baseVersion := Versions.version,
    organizationName := "JPL, Caltech, Airbus & Object Management Group",
    organizationHomepage := Some(url("http://solitaire.omg.org/browse/TIWG")),

    scalaSource in Compile := baseDirectory.value / "svn" / "org.omg.oti" / "src",
    unmanagedSourceDirectories in Compile +=  baseDirectory.value / "svn" / "org.omg.oti" / "src-gen",

    classDirectory in Compile := baseDirectory.value / "svn" / "org.omg.oti" / "bin",
    cleanFiles += (classDirectory in Compile).value,

    resourceDirectory in Compile := baseDirectory.value / "svn" / "org.omg.oti" / "resources",

    libraryDependencies ++= Seq (
      "gov.nasa.jpl.imce.thirdParty" %% "all-scala-libraries" % Versions.jpl_mbee_common_scala_libraries artifacts 
      Artifact("all-scala-libraries", "zip", "zip"),
      "gov.nasa.jpl.imce.thirdParty" %% "other-scala-libraries" % Versions.jpl_mbee_common_scala_libraries artifacts 
      Artifact("other-scala-libraries", "zip", "zip")
    ),

    IMCEKeys.nexusJavadocRepositoryRestAPIURL2RepositoryName := Map(
       "https://oss.sonatype.org/service/local" -> "releases",
       "https://cae-nexuspro.jpl.nasa.gov/nexus/service/local" -> "JPL"),
    IMCEKeys.pomRepositoryPathRegex := """\<repositoryPath\>\s*([^\"]*)\s*\<\/repositoryPath\>""".r

  )
  .settings(IMCEReleasePlugin.packageReleaseProcessSettings)
