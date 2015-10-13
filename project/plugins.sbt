// https://github.com/lrytz/experimental-backend-2.11/blob/master/build.sbt
resolvers ++= List(
  "2.11.7 core"    at "https://oss.sonatype.org/content/repositories/orgscala-lang-1229/",
  "2.11.7 plugins" at "https://oss.sonatype.org/content/repositories/orgscala-lang-1230/org/"
)

// https://github.com/typesafehub/sbteclipse`
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "4.0.0")
    
resolvers += Resolver.url("sbt-license-plugin-releases", url("http://dl.bintray.com/banno/oss"))(Resolver.ivyStylePatterns)

// https://github.com/Banno/sbt-license-plugin
addSbtPlugin("com.banno" % "sbt-license-plugin" % "0.1.4")

resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"

// https://github.com/sbt/sbt-git
addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.8.4")

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += Classpaths.sbtPluginReleases

// https://github.com/scoverage/sbt-scoverage
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.1.0")

// https://github.com/jrudolph/sbt-dependency-graph
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.5")

// https://github.com/xerial/sbt-pack
addSbtPlugin("org.xerial.sbt" % "sbt-pack" % "0.6.12")

// https://github.com/arktekk/sbt-aether-deploy
addSbtPlugin("no.arktekk.sbt" % "aether-deploy" % "0.14")

// https://github.com/rtimush/sbt-updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.8")

// https://github.com/sbt/sbt-native-packager
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.2")

// https://github.com/puffnfresh/wartremover
addSbtPlugin("org.brianmckenna" % "sbt-wartremover" % "0.14")

// https://github.com/sksamuel/sbt-scapegoat
addSbtPlugin("com.sksamuel.scapegoat" %% "sbt-scapegoat" % "1.0.0")
