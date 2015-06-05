
import sbt.Process

// see JPLMBEECOmmonScalaLibraries.Version
object Versions {

  val version_prefix = "0.14.0"
  val version_suffix = {
    val svnProc = Process(command = "svn", arguments = Seq("info"))
    val sedCommand = "s/^.*Last Changed Rev: \\([[:digit:]]\\{1,\\}\\).*$/\\1/p"
    val sedProc = Process(command = "sed", arguments = Seq("-n", sedCommand))
    val svnRevision = svnProc.#|(sedProc).!!.trim
    svnRevision
  }

  // OTI Core version

  val version = version_prefix + "-" + version_suffix

  // scalaLibs

  val scala = "2.11.6"
  val scala_suffix = "2.11"

  // otherLibs

  val config = "1.2.1"
  val scalaCheck = "1.12.2"
  val scalaTest = "2.2.4"
  val specs2 = "3.6"
  val parboiled = "2.1.0"
  val akka = "2.3.11"
  val spray = "1.3.3"
  val shapeless = "2.1.0"
  val scalaz = "7.1.1"
  val scalaz_stream = "0.7a"
  val play = "2.4.0"

  // owlapiLibs

  /** @see http://mvnrepository.com/artifact/net.sourceforge.owlapi/owlapi-distribution */
  val owlapi = "4.0.1"

  /** @see http://mvnrepository.com/artifact/xml-resolver/xml-resolver/ */
  val xmlResolver = "1.2"

  // graphLibs
  val graph_core = "1.9.2"
  val graph_constrained = "1.9.0"
  val graph_dot = "1.10.0"
  val graph_json = "1.9.2"
}
