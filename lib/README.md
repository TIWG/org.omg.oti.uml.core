
1) In the proj a shell window to execute the following:

```
sbt graphLibs/pack
sbt resolverLibs/pack
```
This will download dependencies from the Scala Graph library in the folder: graphLibs/target/pack

2) Copy the following to the lib/ folder:

graphLibs/target/pack/lib/

graph-constrained_*.jar
graph-core_*.jar
graph-dot_*.jar
graph-json_*.jar
lift-json_*.jar
paranamer-*.jar
scala-parser-combinators_*.jar
scala-xml_*.jar
scalap-*.jar

resolverLibs/target/pack/lib/

xml-resolver-*.jar
