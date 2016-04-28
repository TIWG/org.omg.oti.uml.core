# OTI Generic Types, Tool-specific OTI types and Tool-specific implementation types

Yes, there are 3 sets of types to be concerned about.

1) There are 2 ways to refer to a tool-specific type.

Suppose we have an OTI parameterized for a UML tool, say, U.
So we have:

U#Element -- this refers to the tool-specific `Element` metaclass in the tool U.

For example, if U == PapyrusUML, then U#Element == org.eclipse.uml2.uml.Element
If U == MagicDrawUML, then U#Element == com.nomagic.uml2.classes.mdkernel.Element

2) OTI tool-neutral types & OTI tool-specific types.

UMLElement[U] -- this type is an OTI abstraction for the OMG UML 2.5 metaclass `Element` for a specific tool `U`.

Why is this abstract?

UMLElement[U] is an abstraction that is specialized for a particular tool to enable referring to a tool-specific representation of an instance of that metaclass.

The tool-specific representation is left open.  
For both MagicDraw UML and Eclipse/Papyrus UML, the tool-specific representation is a simple wrapper object for the tool-specific object.

Why is this parameterized for the tool-specific implementation?

Suppose that we want to do a model-to-model transformation, not between different metamodels (e.g., UML => BPMN) but rather
between different tool-specific implementations of the same metamodel (e.g., UML).
For example, consider transforming a MagicDraw/UML model to Eclipse/Papyrus/UML.

If we go with the traditional route -- i.e., via XMI interchange -- well, go see the OMG Model Interchange Working Group (MIWG).
If we go with the tool-neutral route, then it becomes a simple mapping from UML$X[U1] to UML$X[U2] for every concrete metaclass / datatype $X defined in OMG UML 2.5

