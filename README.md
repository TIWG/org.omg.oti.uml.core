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

## Dependencies

### [Scala](http://www.scala-lang.org)

Scala provides a powerful blend of functional and object-oriented programming with a powerful type system.
In particular, Scala's type system is what enables the specification of a parameterized functional API for OMG UML 2.5.
In contrast to a conventional polymorphic object-oriented API, a parameterized functional API ensures that different parameterizations of the API are strongly separated. 

### [Scala Graph](http://www.scala-graph.org)

This functional graph library for Scala simplifies specifying parameterized functional algorithms 
that operate on the parameterized functional representation of an OMG UML model in such a way 
that the tool-specific parameter binding is done automatically by the Scala compiler, again, 
with strong separation guarantees across tool-specific parameter bindings.

### [Simple Build Tool, SBT](http://www.scala-sbt.org/documentation.html)

This project is built with SBT 0.13.8

To install SBT, use a package manager for your system (Linux, MacOSX, Windows,...), see: [http://en.wikipedia.org/wiki/List_of_software_package_management_systems](http://en.wikipedia.org/wiki/List_of_software_package_management_systems)

### [Scala IDE](http://scala-ide.org), Version 4.1 on Eclipse Mars

See the building instructions below to use the Scala IDE to work on this project.

### Eclipse Modeling Framework (EMF)

OTI makes no assumptions about the use of Eclipse EMF for implementing OMG UML 2.5.
 
## Building 

This project builds with SBT.

```
sbt -DOTI_LOCAL_REPOSITORY=<dir> publish
```

where `<dir>` is a directory in the file system that will be used for publishing the OTI Core API libraries.

This will:

- fetch library dependencies (emfLibs, graphLibs, resolverLibs, scalazLibs, scala-java8-compat), 

- update the license header in the sources

- compile the sources into jar files

- generate the scaladoc for the sources

- publish the jar files, sources and javadoc to the `OTI_LOCAL_REPOSITORY`

## Working with SBT and IDEs

It is possible to use both SBT and an IDE (Eclipse or IntelliJ) to work on this project.

### IntelliJ IDEA Community Edition (with JetBrains Scala plugin)

1. File | New > Project from Existing Sources...
2. Select the location of the project
3. Use the SBT model for importing the project
4. In the SBT configuration dialog, expand 'Global SBT Settings'
5. Under 'JVM Options', edit 'VM Parameters' and add: `-DOTI_LOCAL_REPOSITORY=<dir>`

If you change the SBT build specification, IntelliJ should automatically refresh the project.
To manually refresh it, use View | Tool Windows > SBT, then click on the refresh icon.

### Eclipse (with Scala IDE plugin)

See https://github.com/typesafehub/sbteclipse

1. Use SBT to create the Eclipse metadata files (.project, .classpath)

    `sbt -DOTI_LOCAL_REPOSITORY=<dir> eclipse`

2. File | Import ...
3. Choose: "Existing Projects into Workspace"
4. Select the location of the project
5. In Options, make sure to *UNCHECK* "Copy projects into workspace"
6. Edit the .project file to replace the following line:

        </linkedResources>

    With the following: 

        <linkedResources>
	  	<link>
			<name>catalogs</name>
			<type>2</type>
			<locationURI>PROJECT_LOC/resources</locationURI>
		</link>
        </linkedResources>

7. Edit the .classpath file to add the following line:

	<classpathentry kind="src" path="catalogs"/>
	
If you change the SBT build specification, close the project in Eclipse.
Use SBT to re-generate the Eclipse metadata.
Re-open the project in Eclipse.


## Scala & Java interoperability

The OTI is written in Scala; experience from the MagicDraw & Papyrus adapters confirms that calling Java libraries from Scala code in OTI is not a problem.

However, writing Java applications that use the Scala OTI is more difficult with current Scala 2.11; however, []the planned improvements for Scala 2.12](http://www.scala-lang.org/news/2.12-roadmap) should improve the interoperability for the OTI as well.
