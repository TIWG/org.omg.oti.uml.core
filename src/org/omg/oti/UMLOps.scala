/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti

import org.eclipse.emf.ecore.EStructuralFeature
import scala.reflect.runtime.universe._
import scala.language.implicitConversions
import scala.language.higherKinds
import scala.util.Try

// [protected('initialize reflection')]

class EarlyInit[T: TypeTag] {
  val mirror = runtimeMirror(this.getClass.getClassLoader)
  val reflection  = mirror.reflect(this)

  System.out.println("EarlyInit (start)")
  
  typeTag[T]
    .tpe
    .members   
    .filter(_.isModule)
    .foreach(m => {
      System.out.println("EarlyInit: " + m.name)
      reflection.reflectModule(m.asModule).instance
    })

  System.out.println("EarlyInit (done)")
    
}

// [/protected]

trait UMLOps[Uml <: UML] { self =>

  // [protected('filters')]
 
  type Element2IDHashMap = scala.collection.mutable.HashMap[UMLElement[Uml], Try[String]]

  type Element2IDRule = PartialFunction[UMLElement[Uml], Try[String]]
  type ContainedElement2IDRule = PartialFunction[( UMLElement[Uml], String, EStructuralFeature, UMLElement[Uml] ), Try[String]]

  class FilterableUMLOption[U]( o: Option[U] ) {
    
    def selectByKindOf[V <: UMLElement[Uml]]( pf: PartialFunction[U, V] ): Option[V] = 
      o.flatMap { u => if (pf.isDefinedAt(u)) Some(pf(u)) else None }
   
  }

  implicit def filterable[U]( o: Option[U] ) = new FilterableUMLOption( o )
    
  class FilterableUMLIterator[U]( it: Iterator[U] ) {
    
    def selectByKindOf[V <: UMLElement[Uml]]( pf: PartialFunction[U, V] ): Iterable[V] = 
      (it.flatMap { u => if (pf.isDefinedAt(u)) Some(pf(u)) else None }).toIterable
   
  }

  implicit def filterable[U]( it: Iterator[U] ) = new FilterableUMLIterator( it )
    
  class FilterableUMLIterable[U]( it: Iterable[U] ) {
    
    def selectByKindOf[V <: UMLElement[Uml]]( pf: PartialFunction[U, V] ): Iterable[V] = 
      it.flatMap { u => if (pf.isDefinedAt(u)) Some(pf(u)) else None }
   
  }

  implicit def filterable[U]( it: Iterable[U] ) = new FilterableUMLIterable( it )
    
  class FilterableUMLSeq[U]( s: Seq[U] ) {
    
    def selectByKindOf[V <: UMLElement[Uml]]( pf: PartialFunction[U, V] ): Seq[V] = 
      s.flatMap { u => if (pf.isDefinedAt(u)) Some(pf(u)) else None }
   
  }

  implicit def filterable[U]( s: Seq[U] ) = new FilterableUMLSeq( s )

  class FilterableUMLSet[U]( s: Set[U] ) {
    
    def selectByKindOf[V <: UMLElement[Uml]]( pf: PartialFunction[U, V] ): Set[V] = 
      s.flatMap { u => if (pf.isDefinedAt(u)) Some(pf(u)) else None }
   
  }

  implicit def filterable[U]( s: Set[U] ) = new FilterableUMLSet( s )
  
  class FilterableUMLStream[U]( s: Stream[U] ) {
    
    def selectByKindOf[V <: UMLElement[Uml]]( pf: PartialFunction[U, V] ): Stream[V] = 
      s.flatMap { u => if (pf.isDefinedAt(u)) Some(pf(u)) else None }
   
  }

  implicit def filterable[U]( s: Stream[U] ) = new FilterableUMLStream( s )
  
  val cache = scala.collection.mutable.WeakHashMap[Uml#Element, UMLElement[Uml]]()
  
  def cacheLookupOrUpdate( md: Uml#Element ): UMLElement[Uml] 
  
  def illegalElementException[E <: UMLElement[Uml]]( message: String, e: E) = IllegalElementException[Uml, E]( message, Iterable(e) )
  def illegalElementException[E <: UMLElement[Uml]]( message: String, e: Iterable[E]) = IllegalElementException[Uml, E]( message, e )
  
  /**
   * OTI::SpecificationRoot stereotype
   */
  val OTI_SPECIFICATION_ROOT_S: Option[Uml#Stereotype]
  
  /**
   * OTI::SpecificationRoot::packageURI property
   */
  val OTI_SPECIFICATION_ROOT_packageURI: Option[Uml#Property]
  
  /**
   * OTI::ID stereotype
   */
  val OTI_ID_S: Option[Uml#Stereotype]
  
  /**
   * OTI::ID stereotype
   */
   val OTI_ID_uuid: Option[Uml#Property]
  
  val SLOT_VALUE: EStructuralFeature
  
  def closure[U, V <: U]( x: U, relation: U => Iterable[V] ): Set[V] = {
    
    case class RelationClosureVisitor(
        result: scala.collection.mutable.Set[V],
        visit: scala.collection.mutable.Buffer[V],
        visited: scala.collection.mutable.Set[V])
        
        
    val visitor = RelationClosureVisitor( scala.collection.mutable.Set[V](), relation(x).toBuffer, scala.collection.mutable.Set[V]() )
    while ( visitor.visit.nonEmpty ) {
      val y = visitor.visit.remove( 0 )
      visitor.visited += y
      visitor.result += y
      relation( y ) foreach ( yi => { 
        visitor.result += yi
        if ( ! visitor.visited.contains( yi ) ) { visitor.visit += yi }
      } )
    }
    visitor.result.toSet
    
  }
  
  // [/protected]
  
  implicit val ELEMENT: TypeTag[Uml#Element] 
  implicit val COMMENT: TypeTag[Uml#Comment]
  implicit val RELATIONSHIP: TypeTag[Uml#Relationship]
  implicit val DIRECTED_RELATIONSHIP: TypeTag[Uml#DirectedRelationship]

  implicit val NAMED_ELEMENT: TypeTag[Uml#NamedElement]
  implicit val NAMESPACE: TypeTag[Uml#Namespace]
  implicit val ELEMENT_IMPORT: TypeTag[Uml#ElementImport]
  implicit val PACKAGE_IMPORT: TypeTag[Uml#PackageImport]
  implicit val PACKAGEABLE_ELEMENT: TypeTag[Uml#PackageableElement]

  implicit val TYPE: TypeTag[Uml#Type]
  implicit val TYPED_ELEMENT: TypeTag[Uml#TypedElement]
  implicit val MULTIPLICITY_ELEMENT: TypeTag[Uml#MultiplicityElement]

  implicit val CONSTRAINT: TypeTag[Uml#Constraint]
  
  implicit val DEPENDENCY: TypeTag[Uml#Dependency]
  
  implicit val VALUE_SPECIFICATION: TypeTag[Uml#ValueSpecification]
  implicit val LITERAL_SPECIFICATION: TypeTag[Uml#LiteralSpecification] 
  implicit val LITERAL_NULL: TypeTag[Uml#LiteralNull]   
  implicit val LITERAL_BOOLEAN: TypeTag[Uml#LiteralBoolean] 
  implicit val LITERAL_INTEGER: TypeTag[Uml#LiteralInteger] 
  implicit val LITERAL_REAL: TypeTag[Uml#LiteralReal] 
  implicit val LITERAL_STRING: TypeTag[Uml#LiteralString] 
  implicit val LITERAL_UNLIMITED_NATURAL: TypeTag[Uml#LiteralUnlimitedNatural]
  
  implicit val EXPRESSION: TypeTag[Uml#Expression] 
  implicit val STRING_EXPRESSION: TypeTag[Uml#StringExpression] 
  implicit val OPAQUE_EXPRESSION: TypeTag[Uml#OpaqueExpression] 
  
  implicit val INTERVAL: TypeTag[Uml#Interval] 
  
  implicit val CLASSIFIER: TypeTag[Uml#Classifier]
  implicit val GENERALIZATION: TypeTag[Uml#Generalization]
  implicit val REDEFINABLE_ELEMENT: TypeTag[Uml#RedefinableElement]

  implicit val FEATURE: TypeTag[Uml#Feature]
  implicit val STRUCTURAL_FEATURE: TypeTag[Uml#StructuralFeature]
  implicit val BEHAVIORAL_FEATURE: TypeTag[Uml#BehavioralFeature]
  implicit val CONNECTABLE_ELEMENT: TypeTag[Uml#ConnectableElement]
  implicit val PARAMETER: TypeTag[Uml#Parameter]

  implicit val PROPERTY: TypeTag[Uml#Property]
  
  implicit val OPERATION: TypeTag[Uml#Operation]

  implicit val INSTANCE_SPECIFICATION: TypeTag[Uml#InstanceSpecification]
  implicit val SLOT: TypeTag[Uml#Slot]
  implicit val INSTANCE_VALUE: TypeTag[Uml#InstanceValue]

  implicit val DATA_TYPE: TypeTag[Uml#DataType]
  implicit val PRIMITIVE_TYPE: TypeTag[Uml#PrimitiveType]
  implicit val ENUMERATION: TypeTag[Uml#Enumeration]
  implicit val ENUMERATION_LITERAL: TypeTag[Uml#EnumerationLiteral]
  
  implicit val BEHAVIORED_CLASSIFIER: TypeTag[Uml#BehavioredClassifier]

  implicit val STRUCTURED_CLASSIFIER: TypeTag[Uml#StructuredClassifier]
  implicit val CONNECTOR: TypeTag[Uml#Connector]
  implicit val CONNECTOR_END: TypeTag[Uml#ConnectorEnd]

  implicit val ENCAPSULATED_CLASSIFIER: TypeTag[Uml#EncapsulatedClassifier]
  implicit val PORT: TypeTag[Uml#Port]

  implicit val CLASS: TypeTag[Uml#Class]

  implicit val ASSOCIATION: TypeTag[Uml#Association]
  implicit val ASSOCIATION_CLASS: TypeTag[Uml#AssociationClass]

  implicit val PACKAGE: TypeTag[Uml#Package]
  implicit val PACKAGE_MERGE: TypeTag[Uml#PackageMerge]
  implicit val MODEL: TypeTag[Uml#Model]

  implicit val PROFILE: TypeTag[Uml#Profile]
  implicit val PROFILE_APPLICATION: TypeTag[Uml#ProfileApplication]
  implicit val STEREOTYPE: TypeTag[Uml#Stereotype]
  implicit val EXTENSION: TypeTag[Uml#Extension]
  implicit val EXTENSION_END: TypeTag[Uml#ExtensionEnd]
  implicit val IMAGE: TypeTag[Uml#Image]
    
  implicit val ACTOR: TypeTag[Uml#Actor]
  implicit val USECASE: TypeTag[Uml#UseCase]
  

  /**
   * For the MTL template, generate the 4-following methods for every UML metaclass (abstract & concrete)
   */
  implicit def umlElement( e: Uml#Element): UMLElement[Uml]  
  implicit def umlElement( c: Iterable[Uml#Element] ): Iterable[UMLElement[Uml]] = for { e <- c } yield umlElement( e )
  implicit def umlElement( c: Seq[Uml#Element] ): Seq[UMLElement[Uml]] = for { e <- c } yield umlElement( e )
  implicit def umlElement( c: Set[Uml#Element] ): Set[UMLElement[Uml]] = for { e <- c } yield umlElement( e )
  
  
  implicit def umlComment( e: Uml#Comment ): UMLComment[Uml]
  implicit def umlRelationship( e: Uml#Relationship ): UMLRelationship[Uml]
  implicit def umlDirectedRelationship( e: Uml#DirectedRelationship ): UMLDirectedRelationship[Uml]
  
  implicit def umlNamedElement( e: Uml#NamedElement ): UMLNamedElement[Uml] 
  implicit def umlNamespace( e: Uml#Namespace ): UMLNamespace[Uml]
  
  implicit def umlElementImport( e: Uml#ElementImport ): UMLElementImport[Uml]
  implicit def umlPackageImport( e: Uml#PackageImport ): UMLPackageImport[Uml]  
  implicit def umlPackageableElement( e: Uml#PackageableElement ): UMLPackageableElement[Uml]
    
  implicit def umlType( e: Uml#Type ): UMLType[Uml]
  implicit def umlTypedElement( e: Uml#TypedElement ): UMLTypedElement[Uml]
  implicit def umlMultiplicityElement( e: Uml#MultiplicityElement ): UMLMultiplicityElement[Uml]
  
  implicit def umlConstraint( e: Uml#Constraint): UMLConstraint[Uml]
  implicit def umlConstraint( c: Iterable[Uml#Constraint]): Iterable[UMLConstraint[Uml]] = for { e <- c } yield umlConstraint( e )
  
  implicit def umlDependency( e: Uml#Dependency): UMLDependency[Uml]
  
  implicit def umlValueSpecification( e: Uml#ValueSpecification ): UMLValueSpecification[Uml]
  implicit def umlValueSpecification( c: Iterable[Uml#ValueSpecification] ): Iterable[UMLValueSpecification[Uml]] = for { e <- c } yield umlValueSpecification( e )  
  implicit def umlValueSpecification( c: Seq[Uml#ValueSpecification] ): Seq[UMLValueSpecification[Uml]] = for { e <- c } yield umlValueSpecification( e )
  
  implicit def umlLiteralSpecification( e: Uml#LiteralSpecification ): UMLLiteralSpecification[Uml]
  implicit def umlLiteralNull( e: Uml#LiteralNull): UMLLiteralNull[Uml]
  implicit def umlLiteralBoolean( e: Uml#LiteralBoolean): UMLLiteralBoolean[Uml]
  implicit def umlLiteralInteger( e: Uml#LiteralInteger): UMLLiteralInteger[Uml]
  implicit def umlLiteralReal( e: Uml#LiteralReal): UMLLiteralReal[Uml]
  implicit def umlLiteralString( e: Uml#LiteralString): UMLLiteralString[Uml]
  implicit def umlLiteralUnlimitedNatural( e: Uml#LiteralUnlimitedNatural): UMLLiteralUnlimitedNatural[Uml]
  
  implicit def umlExpression( e: Uml#Expression): UMLExpression[Uml]
  implicit def umlStringExpression( e: Uml#StringExpression): UMLStringExpression[Uml]
  implicit def umlStringExpression( c: Seq[Uml#StringExpression] ): Seq[UMLStringExpression[Uml]] = for { e <- c } yield umlStringExpression( e )
  
  implicit def umlOpaqueExpression( e: Uml#OpaqueExpression): UMLOpaqueExpression[Uml]
  
  implicit def umlInterval( e: Uml#Interval): UMLInterval[Uml]
    
  implicit def umlClassifier( e: Uml#Classifier ): UMLClassifier[Uml]
  
  implicit def umlClassifier( c: Iterable[Uml#Classifier] ): Iterable[UMLClassifier[Uml]] = for { e <- c } yield umlClassifier( e )
  implicit def umlClassifier( c: Seq[Uml#Classifier] ): Seq[UMLClassifier[Uml]] = for { e <- c } yield umlClassifier( e )
  implicit def umlClassifier( c: Set[Uml#Classifier] ): Set[UMLClassifier[Uml]] = for { e <- c } yield umlClassifier( e )
  
  
  implicit def umlGeneralization( e: Uml#Generalization ): UMLGeneralization[Uml]  
  implicit def umlRedefinableElement( e: Uml#RedefinableElement ): UMLRedefinableElement[Uml]
   
  implicit def umlFeature( e: Uml#Feature ): UMLFeature[Uml]
  implicit def umlStructuralFeature( e: Uml#StructuralFeature ): UMLStructuralFeature[Uml]
  implicit def umlBehavioralFeature( e: Uml#BehavioralFeature ): UMLBehavioralFeature[Uml]  
  
  implicit def umlConnectableElement( e: Uml#ConnectableElement ): UMLConnectableElement[Uml]
  implicit def umlParameter( e: Uml#Parameter ): UMLParameter[Uml]
  
  implicit def umlProperty( e: Uml#Property ): UMLProperty[Uml]
  
  implicit def umlOperation( e: Uml#Operation ): UMLOperation[Uml]
  implicit def umlOperation( c: Seq[Uml#Operation] ): Seq[UMLOperation[Uml]] = for { e <- c } yield umlOperation( e )
  
  implicit def umlInstanceSpecification( e: Uml#InstanceSpecification ): UMLInstanceSpecification[Uml]
  implicit def umlSlot( e: Uml#Slot ): UMLSlot[Uml]
  implicit def umlInstanceValue( e: Uml#InstanceValue ): UMLInstanceValue[Uml]
  
  implicit def umlEnumeration( e: Uml#Enumeration ): UMLEnumeration[Uml]
  implicit def umlEnumerationLiteral( e: Uml#EnumerationLiteral ): UMLEnumerationLiteral[Uml]
  implicit def umlEnumerationLiteral( c: Seq[Uml#EnumerationLiteral] ): Seq[UMLEnumerationLiteral[Uml]] = for { e <- c } yield umlEnumerationLiteral( e )
  
  implicit def umlBehavioredClassifier( e: Uml#BehavioredClassifier ): UMLBehavioredClassifier[Uml]
  
  implicit def umlStructuredClassifier( e: Uml#StructuredClassifier ): UMLStructuredClassifier[Uml]
  implicit def umlConnector( e: Uml#Connector ): UMLConnector[Uml]
  implicit def umlConnectorEnd( e: Uml#ConnectorEnd ): UMLConnectorEnd[Uml]
  implicit def umlConnectorEnd( c: Seq[Uml#ConnectorEnd] ): Seq[UMLConnectorEnd[Uml]] = for { e <- c } yield umlConnectorEnd( e )
  
  implicit def umlEncapsulatedClassifier( e: Uml#EncapsulatedClassifier ): UMLEncapsulatedClassifier[Uml]
  implicit def umlPort( e: Uml#Port ): UMLPort[Uml]
  
  implicit def umlClass( e: Uml#Class ): UMLClass[Uml]
  
  implicit def umlAssociation( e: Uml#Association ): UMLAssociation[Uml]
  implicit def umlAssociationClass( e: Uml#AssociationClass ): UMLAssociationClass[Uml]
  
  implicit def umlPackage( e: Uml#Package): UMLPackage[Uml]
  implicit def umlPackageMerge( e: Uml#PackageMerge ): UMLPackageMerge[Uml]
  implicit def umlModel( e: Uml#Model): UMLModel[Uml]
  
  implicit def umlProfile( e: Uml#Profile ): UMLProfile[Uml]
  implicit def umlProfileApplication( e: Uml#ProfileApplication ): UMLProfileApplication[Uml]
  implicit def umlStereotype( e: Uml#Stereotype ): UMLStereotype[Uml]
  implicit def umlStereotype( c: Set[Uml#Stereotype]  ): Set[UMLStereotype[Uml]] = for { e <- c } yield umlStereotype( e )
  implicit def umlExtension( e: Uml#Extension ): UMLExtension[Uml]
  implicit def umlExtensionEnd( e: Uml#ExtensionEnd ): UMLExtensionEnd[Uml]
  implicit def umlImage( e: Uml#Image ): UMLImage[Uml]
  
  implicit def umlActor( e: Uml#Actor): UMLActor[Uml]
  implicit def umlUseCase( e: Uml#UseCase): UMLUseCase[Uml]
  
  
  implicit def umlRelationship( c: Seq[Uml#Relationship] ): Seq[UMLRelationship[Uml]] = for { e <- c } yield umlRelationship( e )
  implicit def umlRelationship( c: Set[Uml#Relationship] ): Set[UMLRelationship[Uml]] = for { e <- c } yield umlRelationship( e )
  
  implicit def umlDirectedRelationship( c: Seq[Uml#DirectedRelationship] ): Seq[UMLDirectedRelationship[Uml]] = for { e <- c } yield umlDirectedRelationship( e )
  implicit def umlDirectedRelationship( c: Set[Uml#DirectedRelationship] ): Set[UMLDirectedRelationship[Uml]] = for { e <- c } yield umlDirectedRelationship( e )

  implicit def umlRedefinableElement( c: Iterable[Uml#RedefinableElement] ): Iterable[UMLRedefinableElement[Uml]] = for { e <- c } yield umlRedefinableElement( e )

  implicit def umlProperty( c: Iterable[Uml#Property] ): Iterable[UMLProperty[Uml]] = for { e <- c } yield umlProperty( e )
  implicit def umlProperty( c: Seq[Uml#Property] ): Seq[UMLProperty[Uml]] = for { e <- c } yield umlProperty( e )
  implicit def umlProperty( c: Set[Uml#Property] ): Set[UMLProperty[Uml]] = for { e <- c } yield umlProperty( e )
  
  implicit def umlComment( c: Iterable[Uml#Comment] ): Iterable[UMLComment[Uml]] = for { e <- c } yield umlComment( e )
  implicit def umlComment( c: Seq[Uml#Comment] ): Seq[UMLComment[Uml]] = for { e <- c } yield umlComment( e )
  
  implicit def umlType( c: Iterable[Uml#Type] ): Iterable[UMLType[Uml]] = for { e <- c } yield umlType( e )
  
  implicit def umlTypedElement( c: Iterable[Uml#TypedElement] ): Iterable[UMLTypedElement[Uml]] = for { e <- c } yield umlTypedElement( e )
  
  implicit def umlDependency( c: Iterable[Uml#Dependency] ): Iterable[UMLDependency[Uml]] = for { e <- c } yield umlDependency( e )
  
  implicit def umlInstanceSpecification( c: Iterable[Uml#InstanceSpecification] ): Iterable[UMLInstanceSpecification[Uml]] = for { e <- c } yield umlInstanceSpecification( e )
  implicit def umlInstanceSpecification( c: Set[Uml#InstanceSpecification] ): Set[UMLInstanceSpecification[Uml]] = for { e <- c } yield umlInstanceSpecification( e )
  
  implicit def umlInstanceValue( c: Iterable[Uml#InstanceValue] ): Iterable[UMLInstanceValue[Uml]] = for { e <- c } yield umlInstanceValue( e )
  
  implicit def umlSlot( c: Iterable[Uml#Slot] ): Iterable[UMLSlot[Uml]] = for { e <- c } yield umlSlot( e )
  
  implicit def umlNamedElement( c: Iterable[Uml#NamedElement] ): Iterable[UMLNamedElement[Uml]] = for { e <- c } yield umlNamedElement( e )
  implicit def umlNamedElement( c: Set[Uml#NamedElement] ): Set[UMLNamedElement[Uml]] = for { e <- c } yield umlNamedElement( e )
  
  implicit def umlNamespace( c: Iterable[Uml#Namespace] ): Iterable[UMLNamespace[Uml]] = for { e <- c } yield umlNamespace( e )
  
  implicit def umlAssociation( c: Iterable[Uml#Association] ): Iterable[UMLAssociation[Uml]] = for { e <- c } yield umlAssociation( e )
  
  implicit def umlParameter( c: Iterable[Uml#Parameter] ): Iterable[UMLParameter[Uml]] = for { e <- c } yield umlParameter( e )
  
  implicit def umlElementImport( s: Set[Uml#ElementImport] ): Set[UMLElementImport[Uml]] = for { e <- s } yield umlElementImport( e )
  implicit def umlPackageImport( s: Set[Uml#PackageImport] ): Set[UMLPackageImport[Uml]] = for { e <- s } yield umlPackageImport( e )
  
}