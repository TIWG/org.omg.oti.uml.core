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
package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml._
import org.omg.oti.uml.read._
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.xmi.IDGenerator
import scala.language.postfixOps
import scala.annotation
import scala.{Boolean,Int,Double,StringBuilder,StringContext}
import scala.{Option,None,Some}
import scala.Predef.{Set => _, Map => _,_}
import scala.collection.immutable._
import scala.collection.Iterable
import scala.util.Failure
import scala.util.Success
import scala.util.Try
import java.lang.IllegalArgumentException

import scalaz._, Validation.FlatMap._

// End of user code

/**
 * An Element is a constituent of a model. As such, it has the capability of owning other Elements.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLElementOps[Uml <: UML] { self: UMLElement[Uml] =>

	implicit val ops: UMLOps[Uml]
// Start of user code for class imports
	import self.ops._
  import scalaz._, Scalaz._
	//import Option._
	//import Iterable._
// End of user code


	/**
	 * The Comments owned by this Element.
	 *
	 * <!-- Start of user code doc for ownedComment -->
   * <!-- End of user code doc for ownedComment -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLComment.ownedComment_owningElement
	 */
	def ownedComment: Set[UMLComment[Uml]] =
    ownedElement.selectByKindOf { case x: UMLComment[Uml] => x }

	/**
	 * The query allOwnedElements() gives all of the direct and indirect ownedElements of an Element.
	 *
	 * <!-- Start of user code doc for allOwnedElements -->
   * <!-- End of user code doc for allOwnedElements -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (ownedElement->union(ownedElement->collect(e | e.allOwnedElements()))->asSet())
	 * }}}
	 */
	def allOwnedElements: Set[UMLElement[Uml]] = {
		// Start of user code for "allOwnedElements"
    closure[UMLElement[Uml], UMLElement[Uml]](self, _.ownedElement)
    // End of user code
	}

	/**
	 * The query mustBeOwned() indicates whether Elements of this type must have an owner. Subclasses of Element that do not require an owner must override this operation.
	 *
	 * <!-- Start of user code doc for mustBeOwned -->
   * <!-- End of user code doc for mustBeOwned -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (true)
	 * }}}
	 */
	def mustBeOwned: Boolean = {
		// Start of user code for "mustBeOwned"
    true
    // End of user code
	}

	/**
	 * Elements that must be owned must have an owner.
	 *
	 * <!-- Start of user code doc for validate_has_owner -->
   * <!-- End of user code doc for validate_has_owner -->
	 *
	 * {{{
	 * OCL Body mustBeOwned() implies owner->notEmpty()
	 * }}}
	 */
	def validate_has_owner: Boolean = {
		// Start of user code for "has_owner"
    if (mustBeOwned) {
      owner.isDefined
    } else true
    // End of user code
	}

	/**
	 * An element may not directly or indirectly own itself.
	 *
	 * <!-- Start of user code doc for validate_not_own_self -->
   * <!-- End of user code doc for validate_not_own_self -->
	 *
	 * {{{
	 * OCL Body not allOwnedElements()->includes(self)
	 * }}}
	 */
	def validate_not_own_self: Boolean = {
		// Start of user code for "not_own_self"
    !allOwnedElements.contains(self)
    // End of user code
	}

	// Start of user code for additional features

  /**
   * The element or the first owner of the element that is a package with an effective URI;
   * none if no such owner package exists.
   */
  @annotation.tailrec final def getPackageOwnerWithEffectiveURI
  ()
  (implicit otiCharacterizations: Option[Map[UMLPackage[Uml], UMLComment[Uml]]])
  : ValidationNel[UMLError.UException, Option[UMLPackage[Uml]]] =
    self match {
      case p: UMLPackage[Uml] if p.getEffectiveURI.isDefined =>
        Some(p).success
      case _ => owner match {
        case Some(o) =>
          o.getPackageOwnerWithEffectiveURI
        case None =>
          None.success
      }
    }

  /**
   * directed, non-derived, composite association end properties
   *
   * The order is according to Canonical XMI (ptc/2013-08-31), B5.2:
   * B5.2 Property Elements
   *
   * Issue 17261: clarify the ordering
   * Properties of an element are ordered by the class in which they are defined.
   * Properties defined by a superclass appear before those of its subclasses.
   * Where a class inherits from more than one direct superclass,
   * properties from the class with the alphabetically earlier class name appear
   * before those of an alphabetically later class name.
   *
   * Issue 17262: add note to clarify the ordering
   * Note that if a property is redefined in a subclass,
   * its position in the order remains the position of the original redefined property within the parent class.
   *
   * In OTI, B5.2 is interpreted as follows:
   *
   * For classes C1, C2 and for composite, non-derived properties P1, P2 such that:
   * - P1 is defined in C1
   * - P2 is defined in C2
   * - C2 is the specific classifier in a generalization relationship with C1 as general classifier
   * Then:
   * - compositeMetaProperties contains P1 and P2
   * - P1 is before P2, regardless of whether P2 directly or indirectly redefines P1
   *
   * @see http://solitaire.omg.org/browse/TIWG-29
   * @see http://solitaire.omg.org/browse/TIWG-25
   */
  def compositeMetaProperties: MetaPropertyFunctions

  /**
   * directed, non-derived, reference association end properties
   *
   * The order is according to Canonical XMI (ptc/2013-08-31), B5.2:
   * B5.2 Property Elements
   *
   * Issue 17261: clarify the ordering
   * Properties of an element are ordered by the class in which they are defined.
   * Properties defined by a superclass appear before those of its subclasses.
   * Where a class inherits from more than one direct superclass,
   * properties from the class with the alphabetically earlier class name appear
   * before those of an alphabetically later class name.
   *
   * Issue 17262: add note to clarify the ordering
   * Note that if a property is redefined in a subclass,
   * its position in the order remains the position of the original redefined property within the parent class.
   *
   * In OTI, B5.2 is interpreted as follows:
   *
   * For classes C1, C2 and for non-composite, non-derived properties P1, P2 such that:
   * - P1 is defined in C1
   * - P2 is defined in C2
   * - C2 is the specific classifier in a generalization relationship with C1 as general classifier
   * Then:
   * - referenceMetaProperties contains P1 and P2
   * - P1 is before P2, regardless of whether P2 directly or indirectly redefines P1
   *
   * @see http://solitaire.omg.org/browse/TIWG-29
   * @see http://solitaire.omg.org/browse/TIWG-25
   */
  def referenceMetaProperties: MetaPropertyFunctions

  /**
   * The set of Elements referenced from this Element due to link instances of
   * directed, non-composite, non-derived associations defined in the UML metamodel
   *
   * This method is defined for every metaclass according to the figures from the UML spec.
   *
   * The override method includes up to 3 contributions:
   * - those of the metaclass itself
   *
   * - the concrete direct generalization parent metaclass (zero or one)
   * {{{super.forwardReferencesFromMetamodelAssociations}}}
   *
   * - each abstract direct generalization parent metaclass (zero or more)
   * {{{[metaclass name]_forwardReferencesFromMetamodelAssociations}}}
   */
  def forwardReferencesFromMetamodelAssociations: Set[UMLElement[Uml]]

  /**
   * The element itself (if it is a kind of namespace)
   * or the first owner of the element that is a kind of namespace.
   */
  @annotation.tailrec final def owningNamespace: Option[UMLNamespace[Uml]] =
    self match {
    case ns: UMLNamespace[Uml] =>
      Some(ns)
    case e: UMLElement[Uml] => e.owner match {
      case None =>
        None
      case Some(o) =>
        o.owningNamespace
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
  def asForwardReferencesToImportableOuterPackageableElements
  : ValidationNel[UMLError.UException, Set[UMLPackageableElement[Uml]]] =
    asForwardReferencesToOwningElementImportableOuterPackageableElements

  def mofXMI_metaAtttributes: MetaAttributeFunctions =
    Seq(
      MetaDocumentAttributeStringFunction[Uml, UMLElement[Uml]](
        Some( "xmi" ), "id",
        (e,idg) => {
         val _id = e.xmiID()(idg)
         _id.map { id => Iterable(id) }
        }),
      MetaDocumentAttributeStringFunction[Uml, UMLElement[Uml]](
        Some( "xmi" ), "uuid",
        (e,idg) => {
          val _id = e.xmiUUID()(idg)
          _id.map { uuid => Iterable(uuid) }
        }),
      MetaAttributeStringFunction[Uml, UMLElement[Uml]](
        Some( "xmi" ), "type", _.xmiType.success ))

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

  /**
   * Triples representing forward references from this UML element to other UML elements.
   *
   * @return
   */
  def forwardRelationTriples
  ()
  (implicit idg: IDGenerator[Uml])
  : ValidationNel[UMLError.UException, Set[RelationTriple[Uml]]] = {

    def addEvaluatedTriples
    (acc: ValidationNel[UMLError.UException, Set[RelationTriple[Uml]]],
     f: MetaPropertyEvaluator)
    : ValidationNel[UMLError.UException, Set[RelationTriple[Uml]]] =
      acc.flatMap { ts =>
        f
        .evaluateTriples(self)
        .map( _ ++ ts )
      }

    val acc0: ValidationNel[UMLError.UException, Set[RelationTriple[Uml]]] =
      tagValues.map { tvs =>
        for {
          tagValue <- tvs.to[Set]
          tagPropertyValueElementReference <- tagValue.tagPropertyValueElementReferences
        } yield StereotypePropertyTriple[Uml](
        sub = self,
        rels = tagValue.appliedStereotype,
        relp = tagValue.stereotypeTagProperty,
        obj = tagPropertyValueElementReference)
      }

    val accN = ( acc0 /: self.referenceMetaProperties )( addEvaluatedTriples )
    accN
  }

  def appendUnique[F](s1: Seq[F], s2: Seq[F]): Seq[F] =
    s1 ++ (s2 filter (!s1.contains(_)))

  def appendUnique[F](ss: Seq[F]*): Seq[F] =
    ss.toList match {
      case Nil => Seq()
      case (s :: Nil) => s
      case (s1 :: s2 :: Nil) => appendUnique(s1, s2)
      case (s :: sx) => appendUnique(s, appendUnique(sx: _*))
    }

  /**
   * @param tagProperty
   * @return The String values, if any, of the tagProperty.
   */
  def getStereotypeTagPropertyBooleanValues(tagProperty: UMLProperty[Uml])
  : ValidationNel[UMLError.UException, Iterable[Boolean]] =
    lookupTagValueByProperty(tagProperty)
    .map {
      case None =>
        Iterable()
      case Some(v) =>
        v match {
          case vs: UMLStereotypeTagPropertyClassifierValue[Uml] =>
            for {
              tv <- vs.values
              v <- tv match {
                case s: TagPropertyBooleanValue[Uml] => Some(s.value)
                case _ => None
              }
            } yield v
          case _ =>
            None
        }
    }

  /**
   * @param tagProperty
   * @return The Integer values, if any, of the tagProperty.
   */
  def getStereotypeTagPropertyIntegerValues(tagProperty: UMLProperty[Uml])
  : ValidationNel[UMLError.UException, Iterable[Int]] =
    lookupTagValueByProperty(tagProperty)
    .map {
      case None =>
        None
      case Some(v) =>
        v match {
          case vs: UMLStereotypeTagPropertyClassifierValue[Uml] =>
            for {
              tv <- vs.values
              v <- tv match {
                case s: TagPropertyIntegerValue[Uml] => Some(s.value)
                case _ => None
              }
            } yield v
          case _ =>
            None
        }
    }

  /**
   * @param tagProperty
   * @return The Integer values, if any, of the tagProperty.
   */
  def getStereotypeTagPropertyUnlimitedNaturalValues(tagProperty: UMLProperty[Uml])
  : ValidationNel[UMLError.UException, Iterable[Int]] =
    lookupTagValueByProperty(tagProperty)
    .map {
      case None =>
        None
      case Some(v) =>
        v match {
          case vs: UMLStereotypeTagPropertyClassifierValue[Uml] =>
            for {
              tv <- vs.values
              v <- tv match {
                case s: TagPropertyUnlimitedNaturalValue[Uml] => Some(s.value)
                case _ => None
              }
            } yield v
          case _ =>
            None
        }
    }

  /**
   * @param tagProperty
   * @return The Integer values, if any, of the tagProperty.
   */
  def getStereotypeTagPropertyRealValues(tagProperty: UMLProperty[Uml])
  : ValidationNel[UMLError.UException, Iterable[Double]] =
    lookupTagValueByProperty(tagProperty)
    .map {
      case None =>
        None
      case Some(v) =>
        v match {
          case vs: UMLStereotypeTagPropertyClassifierValue[Uml] =>
            for {
              tv <- vs.values
              v <- tv match {
                case s: TagPropertyRealValue[Uml] => Some(s.value)
                case _ => None
              }
            } yield v
          case _ =>
            None
        }
    }

  /**
   * @param tagProperty
   * @return The String values, if any, of the tagProperty.
   */
  def getStereotypeTagPropertyStringValues(tagProperty: UMLProperty[Uml])
  : ValidationNel[UMLError.UException, Iterable[String]] =
    lookupTagValueByProperty(tagProperty)
    .map {
      case None =>
        None
      case Some(v) =>
        v match {
          case vs: UMLStereotypeTagPropertyClassifierValue[Uml] =>
            for {
              tv <- vs.values
              v <- tv match {
                case s: TagPropertyStringValue[Uml] => Some(s.value)
                case _ => None
              }
            } yield v
          case _ =>
            None
        }
    }

  /**
   * @param tagProperty
   * @return The EnumerationLiteral values, if any, of the tagProperty.
   */
  def getStereotypeTagPropertyEnumValues(tagProperty: UMLProperty[Uml])
  : ValidationNel[UMLError.UException, Iterable[UMLEnumerationLiteral[Uml]]] =
    lookupTagValueByProperty(tagProperty)
    .map {
      case None =>
        None
      case Some(v) =>
        v match {
          case vs: UMLStereotypeTagPropertyClassifierValue[Uml] =>
            for {
              tv <- vs.values
              v <- tv match {
                case s: TagPropertyEnumerationLiteralValue[Uml] => Some(s.value)
                case _ => None
              }
            } yield v
          case _ =>
            None
        }
    }

  /**
   * @param tagProperty
   * @return The InstanceSpecification values, if any, of the tagProperty.
   */
  def getStereotypeTagPropertyInstanceValues(tagProperty: UMLProperty[Uml])
  : ValidationNel[UMLError.UException, Iterable[UMLInstanceSpecification[Uml]]] =
    lookupTagValueByProperty(tagProperty)
    .map {
      case None =>
        None
      case Some(v) =>
        v match {
          case vs: UMLStereotypeTagPropertyClassifierValue[Uml] =>
            for {
              tv <- vs.values
              v <- tv match {
                case s: TagPropertyInstanceSpecificationValue[Uml] => Some(s.value)
                case _ => None
              }
            } yield v
          case _ =>
            None
        }
    }

  /**
   * Returns the value of the OTI::Identity::xmiID tag property on the element, if any. 
   *
   * Note: Normally, it should be unecessary to override this method in a tool-specific OTI adapter.
   */
  def oti_xmiID: ValidationNel[UMLError.UException, Option[String]] =
    OTI_IDENTITY_xmiID.disjunctioned{ p: \/[NonEmptyList[UMLError.UException], UMLProperty[Uml]] =>
      p.flatMap[NonEmptyList[UMLError.UException], Option[String]] { _p =>
        getStereotypeTagPropertyStringValues(_p).map(_.headOption).disjunction
      }
    }

  /**
   * Returns the value of the OTI::Identity::xmiUUID tag property on the element, if any. 
   *
   * Note: Normally, it should be unecessary to override this method in a tool-specific OTI adapter.
   */
  def oti_xmiUUID: ValidationNel[UMLError.UException, Option[String]] =
    OTI_IDENTITY_xmiUUID.disjunctioned{ p: \/[NonEmptyList[UMLError.UException], UMLProperty[Uml]] =>
      p.flatMap[NonEmptyList[UMLError.UException], Option[String]] { _p =>
        getStereotypeTagPropertyStringValues(_p).map(_.headOption).disjunction
      }
    }

  /**
   * @see OMG XMI 2.5, ptc/2014-09-21, Section 7.6.1, id
   *
   *      XML semantics require the values of this attribute to be unique within an XML document;
   *      however, the value is not required to be globally unique.
   *      This attribute may be used as the value of the idref attribute defined in the next sub clause.
   *      It may also be included as part of the value of the href attribute in XLinks.
   *      An example of the use of this attribute and the other attributes in this sub clause can be found in 7.10.3.
   *      If the metaclass has (or inherits) a Property with isId = ???true,??? then
   *      the value of that property may be used as the basis of the xmi:id and/or xmi:uuid attributes.
   *      This is not mandatory, and the exact algorithm to be used is not specified in this International Standard.
   *      However it is important, to be a valid XML document, that the value for xmi:id is unique
   *      across all elements within the file. The xmi:uuid is not so constrained,
   *      but if the same value is used in multiple XML elements, then
   *      they are all deemed to reference the same MOF element (e.g., they may represent different aspects).
   *
   * @param idg The OTI IDGenerator, used if it is necessary to compute the element's xmi:ID
   * @return The OTI xmi:id for the element, which is either:
   *         - the value of the OTI::Identity::xmiID tag property on the element, if specified, or
   *         - the generated OTI xmi:id
   *
   *         Note: Normally, it should be unecessary to override this method in a tool-specific OTI adapter.
   */
  def xmiID()(implicit idg: IDGenerator[Uml])
  : ValidationNel[UMLError.UException, String] =
    (oti_xmiID.disjunction flatMap { _id: Option[String] =>
      _id
      .fold[ValidationNel[UMLError.UException, String]]{
        generatedOTI_id()
      }{ oid =>
        oid.success
      }
        .disjunction}).validation

  /**
   * @see OMG XMI 2.5, ptc/2014-09-21, Section 7.6.1, uuid
   *
   *      The purpose of this attribute is to provide a globally unique identifier for an XML element.
   *      The values of this attribute should be globally unique strings prefixed by the type of identifier.
   *      If you have access to the UUID assigned in MOF, you may put the MOF UUID in the uuid XML attribute
   *      when encoding the MOF data in XMI. UUIDs should use URIs as the unique string.
   *      Refer to 6.4.1.1 of the MOF Facility and Object Lifecycle Specification for
   *      an example of a scheme for detailed URI production rules.
   *      An example URI for the metaclass UseCase in the UML2 metamodel looks like this:
   *      http://www.omg.org/spec/UML//20200901/uml.xml#UseCase
   *
   * @param idg The OTI IDGenerator, used if it is necessary to compute the element's xmi:ID to derive its xmi:uuid
   * @return The OTI xmi:uuid for the element, which is either:
   *         - the value of the OTI::Identity::xmiUUID tag property on the element, if specified, or
   *         - the generated OTI xmi:uuid
   *
   *         Note: Normally, it should be unecessary to override this method in a tool-specific OTI adapter.
   */
  def xmiUUID
  ()
  (implicit idg: IDGenerator[Uml])
  : ValidationNel[UMLError.UException, String] =
    (oti_xmiUUID.disjunction flatMap { _id: Option[String] =>
      _id
      .fold[ValidationNel[UMLError.UException, String]]{
        generatedOTI_uuid()
      }{ ouuid =>
        ouuid.success
      }
      .disjunction}).validation

  def xmiElementLabel: String = mofMetaclassName

  def metaclass_name: String = mofMetaclassName(0).toLower + mofMetaclassName.drop(1)

  def xmiOrderingKey()(implicit idg: IDGenerator[Uml])
  : ValidationNel[UMLError.UException, String] =
    element_xmiOrderingKey

  def element_xmiOrderingKey()(implicit idg: IDGenerator[Uml])
  : ValidationNel[UMLError.UException, String] =
  for {
    uuid <- xmiUUID
  } yield xmiElementLabel + uuid

  def xmiType: Iterable[String] =
    Iterable("uml:" + mofMetaclassName)

  /**
   * All the non-package elements directly or indirectly owned by a package scope.
   */
  def allOwnedElementsWithinPackageScope: Set[UMLElement[Uml]] = {

    def directlyOwnedElementFilter(owned: UMLElement[Uml]): Boolean =
      owned match {
        case _: UMLPackage[Uml] => false
        case _: UMLElementImport[Uml] => false
        case _: UMLPackageImport[Uml] => false
        case _: UMLPackageMerge[Uml] => false
        case _ => true
      }

    @annotation.tailrec def allOwnedElementsWithinPackageScopeAggregator
    ( acc: Set[UMLElement[Uml]],
      es: List[UMLElement[Uml]])
    : Set[UMLElement[Uml]] = es match {
      case Nil => acc
      case x :: xs =>
        x match {
          case p: UMLPackage[Uml] =>
            val pOwned = p.ownedElement.filter(directlyOwnedElementFilter).toList
            allOwnedElementsWithinPackageScopeAggregator(acc, pOwned ::: xs)
          case e if directlyOwnedElementFilter(e) =>
            val eOwned = e.ownedElement.filter(directlyOwnedElementFilter).toList
            allOwnedElementsWithinPackageScopeAggregator(acc + e, eOwned ::: xs)
          case _ =>
            allOwnedElementsWithinPackageScopeAggregator(acc, xs)
        }
    }

    allOwnedElementsWithinPackageScopeAggregator(Set(), List(this)) - this
  }

  /**
   * The set of Elements referenced from this Element due to values of applied stereotype tag properties
   */
  def allForwardReferencesFromStereotypeTagProperties
  : ValidationNel[UMLError.UException, Set[UMLElement[Uml]]] =
  tagValues.disjunctioned { stvs: \/[NonEmptyList[UMLError.UException], Seq[UMLStereotypeTagValue[Uml]]] =>
    stvs.flatMap[NonEmptyList[UMLError.UException], Set[UMLElement[Uml]]] { _stvs =>
      val r0: ValidationNel[UMLError.UException, Set[UMLElement[Uml]]] = Set().success
      val rn = (r0 /: _stvs) { (ri, stv) =>
        ri.map{ refs =>
          refs ++ stv.tagPropertyValueElementReferences
        }
      }
      rn.disjunction
    }
  }

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
  def allForwardReferencesToElements
  : ValidationNel[UMLError.UException, Set[UMLElement[Uml]]] =
    allForwardReferencesFromStereotypeTagProperties.map(Set(this) ++ forwardReferencesFromMetamodelAssociations ++ _)

  /**
   * Aggregates all forward references to the level of importable outer packageable elements
   */
  def allForwardReferencesToImportablePackageableElements
  : ValidationNel[UMLError.UException, Set[UMLPackageableElement[Uml]]] =
    allForwardReferencesToElements.flatMap { (frefs) =>
      val a0: ValidationNel[UMLError.UException, Set[UMLPackageableElement[Uml]]] = Set().success
      val an = (a0 /: frefs) { (ai, fref) =>
        (fref.asForwardReferencesToImportableOuterPackageableElements |@| ai) { (s1, s2) =>
          s1 ++ s2
        }
      }
      an
    }

  def asForwardReferencesToOwningElementImportableOuterPackageableElements
  : ValidationNel[UMLError.UException, Set[UMLPackageableElement[Uml]]] =
    owner
      .fold[ValidationNel[UMLError.UException, Set[UMLPackageableElement[Uml]]]](
      Set[UMLPackageableElement[Uml]]().success
      )(_.asForwardReferencesToImportableOuterPackageableElements)

  // API to be implemented

  def mofMetaclassName: String

  /**
   * The ordered set of stereotype tag property values.
   *
   * The ordering is the application of OMG Canonical XMI (ptc/13-08-28)
   * applied to properties of the MOF-equivalent class of a stereotype.
   *
   * tag values with hasProfileLifecycleSemantics=false are ordered before
   * tag values with hasProfileLifecycleSemantics=true
   *
   * UMLStereotypeTagExtendedMetaclassPropertyElementReference are ordered before
   * any other kind of UMLStereotypeTagValue
   *
   * The element is well-formed if there is at least one
   * UMLStereotypeTagExtendedMetaclassPropertyElementReference
   * (i.e., there must be at least one 'base_...' property with a value)
   *
   * @return A tuple of the tag property values according to their lifecycle semantics
   */
  def tagValues
  : ValidationNel[UMLError.UException, Seq[UMLStereotypeTagValue[Uml]]]

  def lookupTagValueByProperty(tagProperty: UMLProperty[Uml])
  : ValidationNel[UMLError.UException, Option[UMLStereotypeTagValue[Uml]]] =
   tagValues.map{ _.find(p => p.stereotypeTagProperty == tagProperty) }

  /**
   * @see OMG MOF2.5
   *
   *
   *      Section 15.9 Additional Operations
   *      [6] This returns the single Property with a slot that represents
   *      the current owner of the Object based on current instance values;
   *      may be null for top level objects.
   *      {{{
   *            (M1)Object::owningProperty(): (M2)Property modeled as (M1)ClassInstance::owningProperty(): (M2)Property
   *            result = self.classifier.allSlottableProperties()
   *            ->any(p |p.opposite <> null and p.opposite.isComposite and self.get(p)<> null)
   *      }}}
   *
   * @return The MetaPropertyEvaluator, if any, that represents the current owner of the (M1)Element object.
   */
  def getContainingMetaPropertyEvaluator
  ()
  (implicit idg: IDGenerator[Uml])
  : ValidationNel[UMLError.UException, Option[MetaPropertyEvaluator]] =
    owner
    .fold[ValidationNel[UMLError.UException, Option[MetaPropertyEvaluator]]](None.success) { o =>
      val p0: ValidationNel[UMLError.UException, Seq[MetaPropertyEvaluator]] = Seq().success
      val pN = (p0 /: o.compositeMetaProperties.reverse) { (pi, mi) =>
        pi.fold[ValidationNel[UMLError.UException, Seq[MetaPropertyEvaluator]]](
          fail = Validation.failure(_),
          succ = (mps) =>
          mi match {
            case mp: MetaReferenceEvaluator =>
              mp.evaluate(o).map {
                case Some(e) if e == self =>
                  mps :+ mp
                case _ =>
                  mps
              }
            case mp: MetaCollectionEvaluator =>
              mp.evaluate(o).map {
                case es if es.contains(self) =>
                  mps :+ mp
                case _ =>
                  mps
              }
          }
      )
      }
      pN.map(_.headOption)
    }

  /**
   * See MOF 2.5
   *
   * - Section 9.4:
   *
   * get(property: Property) : Object
   * Gets the value of the given property.
   * If the Property has multiplicity upper bound of 1, get() returns the value of the Property.
   * If Property has multiplicity upper bound >1, get() returns a ReflectiveCollection containing
   * the values of the Property.
   * If there are no values, the ReflectiveCollection returned is empty.
   * Exception: throws IllegalArgumentException if Property is not a member of the Class from class().
   *
   * - Section 15.5
   * {{{
   *      Object::get(Property p): Element
   *      modeled as ObjectInstance::get(Property p): ElementInstance
   *      -- If a foreign association end, then navigate link, else access slot or derive the value
   *      post: (p.namespace.isOclType(Association) and result = navigate(p)) or
   *      self.propertySlot(p) <> null and (
   *      (self.propertySlot(p).value <> null and result = self.propertySlot(p).value) or result = p.default) or
   *      (p.isDerivedUnion and result = unionedProperties(p)->union(s| s = self.get(s)) or
   *      (p.isDerived and result = self.extInvoke('get', p))
   * }}}
   *
   * @param f (M2)Property
   * @return A collection of (M1)Element(s) that are the value of the (M2)Property f on the element.
   */
  def getElementMetamodelPropertyValue
  (f: MetaPropertyEvaluator)
  (implicit idg: IDGenerator[Uml])
  : ValidationNel[UMLError.UException, Iterable[UMLElement[Uml]]] =
    f match {
      case rf: MetaReferenceEvaluator =>
        for {v <- rf.evaluate(self)}
          yield v
      case cf: MetaCollectionEvaluator =>
        cf.evaluate(self)
    }

  /**
   * The computed OTI xmi:id for the element
   */
  def generatedOTI_id()(implicit idg: IDGenerator[Uml])
  : ValidationNel[UMLError.UException, String] =
    idg.computeID(self)

  /**
   * The computed OTI xmi:uuid for the element
   */
  def generatedOTI_uuid
  ()
  (implicit idg: IDGenerator[Uml])
  : ValidationNel[UMLError.UException, String] =
    idg.element2mappedDocument(self) match {
      case Some(d) =>
        (d.uuidPrefix + xmiID()).success
      case None =>
        val ex = UMLError.illegalElementException[Uml, UMLElement[Uml]](
          s"Cannot generate the OTI uuid for $self because it does not belong to a document",
          Iterable[UMLElement[Uml]](self),
          None)
        ex.failureNel
    }

  /* 
   * Every UML Element must have a tool-specific "xmi:id" identifier of some kind.
   * This "xmi:id" is a local with respect to the "XMI" document in which the UML Element is serialized.
   *
   * @return the tool-specific "xmi:id" identifier for the UML Element.
   * @throws java.lang.IllegalArgumentException if there is no tool-specific "xmi:id" available.
   */
  def toolSpecific_id: Option[String] = ???

  /**
   * Every UML Element should have a tool-specific "xmi:uuid" identifier of some kind.
   * This "xmi:uuid", if supported by the specific tool, should be globally unique.
   *
   * @return the tool-specific "xmi:uuid" global identifier for the UML Element, if any.
   */
  def toolSpecific_uuid: Option[String] = ???

  def hasStereotype(s: UMLStereotype[Uml]): Boolean

  /**
   * @return A map for each applied stereotype (key) and the corresponding "base_<metaclass>" property
   */
  final def getAppliedStereotypes
  : ValidationNel[UMLError.UException, Map[UMLStereotype[Uml], UMLProperty[Uml]]] =
  tagValues
  .map { stvs =>
    (for {
      tagValue <- stvs
    } yield tagValue.appliedStereotype -> tagValue.stereotypeTagProperty) toMap
  }

  /**
   * Stereotypes applied; however, there is no applicable 'base_...' property for the element's metaclass.
   */
  def getAppliedStereotypesWithoutMetaclassProperties: Set[UMLStereotype[Uml]]

  def isAncestorOf(other: UMLElement[Uml]): Boolean

  def toWrappedObjectString: String = {

    @annotation.tailrec def describe(context: Option[UMLElement[Uml]], path: Seq[String]): String =
      context match {
        case None =>

          def prefixStream(prefix: String): Stream[String] = prefix #:: prefixStream(prefix + "  ")
          val prefixes: List[String] = prefixStream("").take(path.length).toList

          val result = new StringBuilder(500)
          for {
            (prefix, segment) <- prefixes.zip(path.reverse)
          } result.append("\n" + prefix + segment)
          result.result()

        case Some(e) =>
          describe(e.owner, path :+ (e.xmiType.head + " {tool id=" + e.toolSpecific_id.get + "}"))
      }

    describe(Some(this), Seq())
  }

  /**
   * is this element representing the root of a specification publishable artifact?
   *
   * @return True iff the <<OTI::SpecificationRoot>> stereotype is applied
   */
  def isSpecificationRoot: ValidationNel[UMLError.UException, Boolean] =
    OTI_SPECIFICATION_ROOT_S
    .map{ s =>
      hasStereotype(s)
    }

  // End of user code
} //UMLElementOps
