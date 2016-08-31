
sbtPlugin := false

name := "org.omg.oti.uml.core"

description := "Core OMG Tool-Interoperability API for OMG-compliant UML 2.5 & later."

moduleName := "org.omg.oti.uml.core"

organization := "org.omg.tiwg"

homepage := Some(url(s"https://github.com/TIWG/${moduleName.value}"))

organizationName := "OMG Tool-Infrastructure Working Group"

organizationHomepage := Some(url(s"https://github.com/TIWG"))

git.remoteRepo := s"git@github.com:TIWG/${moduleName.value}"

startYear := Some(2016)

scmInfo := Some(ScmInfo(
  browseUrl = url(s"https://github.com/TIWG/${moduleName.value}"),
  connection = "scm:"+git.remoteRepo.value))

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

