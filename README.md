# OMG Tool Interchange (OTI) API for OMG UML 2.5-compliant Modeling Tools

OTI is a parameterized functional API for OMG's UML 2.5 for querying & transforming OMG UML 2.5 models.
This functional API is parameterized by the implementation of OMG UML 2.5, including but not limited to:
- MagicDraw 18.0 SP2 (see org.omg.oti.magicdraw)
- Papyrus (see org.omg.oti.papyrus

## Capabilities

- Lazy, on-demand mapping of a tool-specific, in-memory representation of an OMG UML 2.5 model 
  to a corresponding OTI representation
 
- Generic OMG Canonical XMI Identification algorithm customizable for particular tools

  Customizations currently done for MagicDraw 18.0 SP2 and Papyrus; see their respective bindings. 

- Tool-neutral serialization of an OTI model representation to OMG Cannonical XMI

## Assumptions & Dependencies

### [Scala](http://www.scala-lang.org)

Scala provides a powerful blend of functional and object-oriented programming with a powerful type system.
In particular, Scala's type system is what enables the specification of a parameterized functional API for OMG UML 2.5.
In contrast to a conventional polymorphic object-oriented API, a parameterized functional API ensures that different parameterizations of the API are strongly separated. 

### [Scala Graph](http://www.scala-graph.org)

This functional graph library for Scala simplifies specifying parameterized functional algorithms that operate on the parameterized functional representation of an OMG UML model in such a way that the tool-specific parameter binding is done automatically by the Scala compiler, again, with strong separation guarantees across tool-specific parameter bindings.

### [Simple Build Tool, SBT](http://www.scala-sbt.org/documentation.html)

This project is built with SBT 0.13.7

To install SBT, use a package manager for your system (Linux, MacOSX, Windows,...), see: [http://en.wikipedia.org/wiki/List_of_software_package_management_systems](http://en.wikipedia.org/wiki/List_of_software_package_management_systems)

### [Scala IDE](http://scala-ide.org), Version 4.0 on Eclipse Luna

See the building instructions below to use the Scala Lithium IDE to work on this project.

### EMF

Currently, OTI assumes that a tool-specific binding uses an EMF-based representation of OMG UML 2.5

This assumption could be eventually lifted; for now, it simplifies the generic API.
See in particular UMLElement:

```
  def getContainedElement_eContainingFeature: EStructuralFeature
  def getElementContainer_eFeatureValue( f: EStructuralFeature ): Iterator[UMLElement[Uml]]
```
and UMLOps:

```
  type ContainedElement2IDRule = PartialFunction[( UMLElement[Uml], String, EStructuralFeature, UMLElement[Uml] ), Try[String]]
```
 
## Building

### With SBT

```
sbt compile
```

### With Eclipse

1) Open a shell window to execute the following:

```
sbt graphLibs/pack
```
This will download dependencies from the Scala Graph library in the folder: graphLibs/target/pack

2) Copy the following to the lib/ folder:

target/pack/lib/graph-constrained_*.jar
graph-core_*.jar
graph-dot_*.jar
graph-json_*.jar
lift-json_*.jar
paranamer-*.jar
scala-parser-combinators_*.jar
scala-xml_*.jar
scalap-*.jar
