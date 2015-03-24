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
package org.omg.oti.operations

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
import org.eclipse.emf.ecore.EStructuralFeature
import scala.language.existentials
import scala.reflect.runtime.universe._
import scala.reflect._
import scala.util.Try
import scala.util.Success
import scala.util.Failure
// End of user code

/**
 * <!-- begin-model-doc -->
 * An Element is a constituent of a model. As such, it has the capability of owning other Elements.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLElementOps[Uml <: UML] { self: UMLElement[Uml] =>	

	implicit val ops: UMLOps[Uml]
	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Comments owned by this Element.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComment.ownedComment_owningElement
	 */
	def ownedComment: Set[UMLComment[Uml]] = ownedElement.selectByKindOf { case x: UMLComment[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The query allOwnedElements() gives all of the direct and indirect ownedElements of an Element.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (ownedElement->union(ownedElement->collect(e | e.allOwnedElements()))->asSet())
	 */
	def allOwnedElements: Set[UMLElement[Uml]]  = {
		// Start of user code for "allOwnedElements"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query mustBeOwned() indicates whether Elements of this type must have an owner. Subclasses of Element that do not require an owner must override this operation.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (true)
	 */
	def mustBeOwned: Boolean  = {
		// Start of user code for "mustBeOwned"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * Elements that must be owned must have an owner.
	 * <!-- end-model-doc -->
	 *
	 * @body mustBeOwned() implies owner->notEmpty()
	 */
	def validate_has_owner: Boolean  = {
		// Start of user code for "has_owner"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * An element may not directly or indirectly own itself.
	 * <!-- end-model-doc -->
	 *
	 * @body not allOwnedElements()->includes(self)
	 */
	def validate_not_own_self: Boolean  = {
		// Start of user code for "not_own_self"
    	???
    	// End of user code
	}

	// Start of user code for additional features

  /**
   * The element or the first owner of the element that is a package with a URI; none if no such owner package exists.
   */
  @annotation.tailrec final def getPackageOwnerWithURI: Option[UMLPackage[Uml]] =
    self match {
      case p: UMLPackage[Uml] if ( p.URI.isDefined ) => Some( p )
      case _ => owner match {
        case Some( o ) => o.getPackageOwnerWithURI
        case None      => None
      }
    }

  /**
   * directed, non-derived, composite association end properties
   */
  def compositeMetaProperties: MetaPropertyFunctions

  /**
   * directed, non-derived, reference association end properties
   */
  def referenceMetaProperties: MetaPropertyFunctions

  /**
   * The set of Elements referenced from this Element due to link instances of
   * directed, non-composite, non-derived associations defined in the UML metamodel
   *
   * This method is defined for every metaclass according to the figures from the UML spec in two idioms:
   * - concrete metaclasses:
   *
   * The override method includes up to 3 contributions:
   * - those of the metaclass itself
   *
   * - the concrete direct generalization parent metaclass (zero or one)
   * => super.forwardReferencesFromMetamodelAssociations
   *
   * - each abstract direct generalization parent metaclass (zero or more)
   * => [metaclass name]_forwardReferencesFromMetamodelAssociations
   */
  def forwardReferencesFromMetamodelAssociations: Set[UMLElement[Uml]]

  /**
   * The element itself (if it is a kind of namespace)
   * or the first owner of the element that is a kind of namespace.
   */
  @annotation.tailrec final def owningNamespace: Option[UMLNamespace[Uml]] = self match {
    case ns: UMLNamespace[Uml] => Some( ns )
    case e: UMLElement[Uml] => e.owner match {
      case None      => None
      case Some( o ) => o.owningNamespace
    }
  }

  /**
   * To enable verifying whether all forward references from elements contained within
   * the scope of a package refer to elements that are directly or indirectly imported
   * from that package or included in directly or indirectly applied profiles, it is necessary
   * to aggregate a forward reference to an element up to the first,
   * importable outer packageable element. This aggregation is metaclass-specific.
   *
   * By default, this method delegates to asForwardReferencesToOwningElementImportableOuterPackageableElements
   *
   * @see asForwardReferencesToOwningElementImportableOuterPackageableElements
   */
  def asForwardReferencesToImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] =
    asForwardReferencesToOwningElementImportableOuterPackageableElements

  def mofXMI_metaAtttributes: MetaAttributeFunctions =
    Seq(
      MetaAttributeStringFunction[Uml, UMLElement[Uml]]( Some( "xmi" ), "id", _.xmiID ),
      MetaAttributeStringFunction[Uml, UMLElement[Uml]]( Some( "xmi" ), "uuid", _.xmiUUID ),
      MetaAttributeStringFunction[Uml, UMLElement[Uml]]( Some( "xmi" ), "type", _.xmiType ) )

  def booleanToIterable( value: Boolean, default: Boolean ): Iterable[Boolean] =
    if ( value != default ) Iterable( value )
    else Iterable()

  def integerToIterable( value: Integer, default: Integer ): Iterable[Integer] =
    if ( value != default ) Iterable( value )
    else Iterable()

  /**
   * @toto Fix the template instead of generating calls to this method.
   * There shouldn't be a Real default value in UML
   */
  def realToIterable( value: Double, default: Double ): Iterable[Double] =
    Iterable( value )

  def stringToIterable( value: Option[String], default: String ): Iterable[String] =
    value.toIterable

  def stringToIterable( value: String, default: String ): Iterable[String] =
    if ( value != default ) Iterable( value )
    else Iterable()

  type MetaAttributeFunction = MetaAttributeAbstractFunction[Uml, _ <: UMLElement[Uml], _]

  type MetaAttributeFunctions = Seq[MetaAttributeFunction]

  /**
   * Non-derived property attributes typed by a PrimitiveType
   */
  def metaAttributes: MetaAttributeFunctions

  // -----------------------

  type Elements = Set[UMLElement[Uml]]

  type MetaPropertyEvaluator = MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]
  type MetaReferenceEvaluator = MetaPropertyReference[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]
  type MetaCollectionEvaluator = MetaPropertyCollection[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]

  type MetaPropertyFunctions = Seq[MetaPropertyEvaluator]

  
  def forwardRelationTriples: Try[Set[RelationTriple[Uml]]] = {

    def addEvaluatedTriples(
      acc: Try[Set[RelationTriple[Uml]]],
      f: MetaPropertyEvaluator ): Try[Set[RelationTriple[Uml]]] = acc match {
      case Failure( t ) => Failure( t )
      case Success( triples ) => f match {
        case rf: MetaReferenceEvaluator =>
          rf.evaluate( self ) match {
            case Failure( t )           => Failure( t )
            case Success( None )        => Success( triples )
            case Success( Some( ref ) ) => 
              if (self.owner.get == ref ) Success( triples )
              else Success( triples + AssociationTriple( sub = self, relf = rf, obj = ref ) )
          }
        case cf: MetaCollectionEvaluator =>
          cf.evaluate( self ) match {
            case Failure( t )    => Failure( t )
            case Success( Nil )  => Success( triples )
            case Success( refs ) => Success( triples ++ (refs.toSet - self.owner.get).map( AssociationTriple( sub = self, relf = cf, _ ) ) )
          }
      }
    }

    val triples: Set[RelationTriple[Uml]] = tagValues.flatMap { case ( p, vs ) =>
      p.owningStereotype match {
        case None =>
          Set[RelationTriple[Uml]]()
        case Some( s ) =>
          val refs = (vs flatMap (_.forwardReferencesFromStereotypeTagValue))
          (refs map (StereotypePropertyTriple(sub=self, rels=s, relp=p, _))).toSet[RelationTriple[Uml]]
      }
    } toSet;

    val acc0: Try[Set[RelationTriple[Uml]]] = Success( triples )
    val accN = ( acc0 /: self.referenceMetaProperties )( addEvaluatedTriples _ )
    accN
  }
  
  def appendUnique[F]( s1: Seq[F], s2: Seq[F] )( implicit f: ClassTag[F] ): Seq[F] =
    s1 ++ ( s2 filter ( !s1.contains( _ ) ) )

  def appendUnique[F]( ss: Seq[F]* )( implicit f: ClassTag[F] ): Seq[F] =
    ss.toList match {
      case Nil                 => Seq()
      case ( s :: Nil )        => s
      case ( s1 :: s2 :: Nil ) => appendUnique( s1, s2 )
      case ( s :: sx )         => appendUnique( s, appendUnique( sx: _* ) )
    }

  def stereotypeTagValues: Map[UMLStereotype[Uml], Map[UMLProperty[Uml], Seq[UMLValueSpecification[Uml]]]] =
    tagValues.groupBy( _._1.owningStereotype.get )

  def xmiID: Iterable[String] = Iterable( id )
  def xmiUUID: Iterable[String] = uuid.toIterable
  def xmiElementLabel: String = mofMetaclassName // ( 0 ).toLower + mofMetaclassName.drop( 1 )

  def xmiOrderingKey: String = element_xmiOrderingKey
  def element_xmiOrderingKey: String = xmiElementLabel + xmiUUID.headOption.getOrElse( xmiID.headOption.getOrElse( "" ) )

  def xmiType: Iterable[String] = Iterable( "uml:" + mofMetaclassName )

  /**
   * All the non-package elements directly or indirectly owned by a package scope.
   */
  def allOwnedElementsWithinPackageScope: Set[UMLElement[Uml]] = {

    def directlyOwnedElementFilter( owned: UMLElement[Uml] ): Boolean =
      owned match {
        case _: UMLPackage[Uml]       => false
        case _: UMLElementImport[Uml] => false
        case _: UMLPackageImport[Uml] => false
        case _: UMLPackageMerge[Uml]  => false
        case _                        => true
      }

    @annotation.tailrec def allOwnedElementsWithinPackageScopeAggregator(
      acc: Set[UMLElement[Uml]],
      es: List[UMLElement[Uml]] ): Set[UMLElement[Uml]] = es match {
      case Nil => acc
      case x :: xs =>
        x match {
          case p: UMLPackage[Uml] =>
            val pOwned = p.ownedElement.filter( directlyOwnedElementFilter( _ ) ).toList
            allOwnedElementsWithinPackageScopeAggregator( acc, pOwned ::: xs )
          case e if ( directlyOwnedElementFilter( e ) ) =>
            val eOwned = e.ownedElement.filter( directlyOwnedElementFilter( _ ) ).toList
            allOwnedElementsWithinPackageScopeAggregator( acc + e, eOwned ::: xs )
          case _ =>
            allOwnedElementsWithinPackageScopeAggregator( acc, xs )
        }
    }

    allOwnedElementsWithinPackageScopeAggregator( Set(), List( this ) ) - this
  }
  
  /**
   * The set of Elements referenced from this Element due to values of applied stereotype tag properties
   */
  def allForwardReferencesFromStereotypeTagProperties: Set[UMLElement[Uml]] = {

    def forwardReferencesFromStereotypeTagProperties1( x: UMLElement[Uml] ): Set[UMLElement[Uml]] =
      x.getAppliedStereotypes.keys.toSet[UMLElement[Uml]] ++
        ( x.tagValues flatMap { case ( p, vs ) => vs flatMap ( _.forwardReferencesFromStereotypeTagValue ) } )

    closure( this, forwardReferencesFromStereotypeTagProperties1 )
  }

  /**
   * Serializing an element E to a document includes serializing E's composite references from E's stereotype tag property values
   */
  def compositeReferencesFromStereotypeTagPropertyValues: Set[UMLElement[Uml]] =
    tagValues flatMap { case ( p, vs ) => vs flatMap ( _.compositeReferencesFromStereotypeTagValue ) } toSet

  /**
   * Calculate the references from this element to other elements due to any of the following:
   * - non-composite, non-derived properties defined for the element's metaclass (`forwardReferencesFromMetamodelAssociations`)
   * - stereotype tag property values due to stereotypes applied to the element (`allForwardReferencesFromStereotypeTagProperties`)
   *
   * For serializing an OTI model into an OMG Canonical XMI document,
   * the references among elements do matter; particularly, references
   * due to non-composite, non-derived properties matter because their serialization
   * depends on whether the two elements are serialized within the same document or not.
   *
   * The OMG MOF/XMI spec is incomplete in the sense that it does not mention
   * references due to values of applied stereotype tag properties.
   */
  def allForwardReferencesToElements: Set[UMLElement[Uml]] =
    Set( this ) ++ forwardReferencesFromMetamodelAssociations ++ allForwardReferencesFromStereotypeTagProperties

  /**
   * Aggregates all forward references to the level of importable outer packageable elements
   */
  def allForwardReferencesToImportablePackageableElements: Set[UMLPackageableElement[Uml]] =
    allForwardReferencesToElements flatMap ( _.asForwardReferencesToImportableOuterPackageableElements )

  def asForwardReferencesToOwningElementImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] =
    owner.fold( Set[UMLPackageableElement[Uml]]() )( _.asForwardReferencesToImportableOuterPackageableElements )

  // API to be implemented

  def mofMetaclassName: String

  def tagValues: Map[UMLProperty[Uml], Seq[UMLValueSpecification[Uml]]]

  def getContainedElement_eContainingFeature: EStructuralFeature

  def getElementContainer_eFeatureValue( f: EStructuralFeature ): Iterable[UMLElement[Uml]]

  def id: String

  def uuid: Option[String]

  def hasStereotype( s: UMLStereotype[Uml] ): Boolean

  /**
   * @return A map for each applied stereotype (key) and the corresponding "base_<metaclass>" property
   */
  def getAppliedStereotypes: Map[UMLStereotype[Uml], UMLProperty[Uml]]
      
  /**
   * Stereotypes applied; however, there is no applicable 'base_...' property for the element's metaclass.
   */
  def getAppliedStereotypesWithoutMetaclassProperties: Set[UMLStereotype[Uml]]
    
  def isAncestorOf( other: UMLElement[Uml] ): Boolean
  
  // End of user code

} //UMLElement
