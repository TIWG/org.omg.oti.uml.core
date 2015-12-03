package org.omg.oti.uml.util

import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations._
import scala.collection.immutable._
/**
 * An abstraction for managing stereotype application.
 *
 * The UML specification avoids defining an abstract syntax for
 * instances of stereotypes and values of stereotype "tag properties".
 * The motivation is to avoid over-committing the specification and provide
 * flexibility for implementing the UML specification.
 *
 * Note: there are several concerns about this new API.
 *
 * - is it safe?
 *   Errors will throw exceptions; OTI uses instead a fail-safe/fail-lazy pattern so that OTI functions should never throw (unless there is a bug)
 *   and instead functions return either a successful value or an abnormal error (which can wrap zero or more exceptions)
 *
 * - is it necessary?
 *   Most of the functionality is available in the OTI/Core API already; see below for details
 * 
 * - is it appropriate? 
 *   getExtendedElements is the least appropriate because the signatures incompletely reflects the essential aspects of
 *   the semantics of stereotypes defined in OMG UML 2.5, section 12.3.3:
 *
 *   Any metaclass referenced by a metaclassReference or contained in a Package referenced by metamodelReference 
 *   of the closest Profile directly or indirectly containing a Stereotype can be extended by the Stereotype.
 *   A Stereotype may be contained in a Package in which case the metaclasses available for extension are those referenced 
 *   by the closest parent Profile containing the Package.
 *
 *   The OMG UML 2.5 specification is silent about applying a Stereotype that does not have a containing Profile nor about 
 *   applying a Stereotype to an Element without a ProfileApplication relationship from the Stereotype's Profile.
 */
trait UMLStereotypeUtil [Uml <: UML] {

  implicit val ops: UMLOps[Uml]
 
  /**
   * The the set of all the elements on which on which the stereotype is applied.
   *
   * @note To better reflect the intented semantics of OMG UML Stereotypes,
   * suggest instead a query scoped to a Package to ensure that the results
   * reflect the OMG UML semantics of the Profiles explicitly applied to that Package.
   * @see [[org.omg.oti.uml.read.operations.UMLPackageOps.allAppliedStereotypesByProfile]]
   */
  def getExtendedElements(stereotype: UMLStereotype[Uml]): Set[UMLElement[Uml]]
 
   /**
   * Find stereotype property by name 
   * 
   * @note This query is not unique to Stereotypes; it can be useful for any kind of Classifier.
   * In fact, it can be defined in terms of additional operations defined on Classifier
   * @see [[org.omg.oti.uml.read.operations.UMLClassifierOps.allAttributesExceptRedefined]]
   */
  def getProperty(stereotype: UMLStereotype[Uml], propertyName: String): Option[UMLProperty[Uml]] =
    stereotype.allAttributesExceptRedefined.find(_.name == propertyName)
  
  /**
   * Find stereotype by name inside a profile 
   *
   * @note This query can be formulated in terms of existing OCL Queries defined in the OMG UML 2.5 spec
   * @see [[org.omg.oti.uml.read.operations.UMLPackageOps.allApplicableStereotypes]]
   */
  def getStereotype(stereotypeName: String, profile: UMLProfile[Uml]): Option[UMLStereotype[Uml]] =
    profile.allApplicableStereotypes.find(_.name == stereotypeName)
  
  /**
   * get the value of a stereotype property according to its name.
   *
   * @note This query assumes that stereotype properties are typed by either a PrimitiveType or an Enumeration.
   * The OTI provides a general mechanism for accessing stereotype property values that reflects the OMG UML 2.5 profile semantics.
   * @see [[org.omg.oti.uml.read.TagPropertyClassifierValue]]
   */
  def getValue (element: UMLElement[Uml], stereotype: UMLStereotype[Uml], propertyName: String): Seq[UMLValueSpecification[Uml]]

  /**
   * get the value of a stereotype property.
   *
   * @note This query assumes that stereotype properties are typed by either a PrimitiveType or an Enumeration.
   * The OTI provides a general mechanism for accessing stereotype property values that reflects the OMG UML 2.5 profile semantics.
   * @see [[org.omg.oti.uml.read.TagPropertyClassifierValue]]
   */
  def getValue (element: UMLElement[Uml], stereotype: UMLStereotype[Uml], property: UMLProperty[Uml]): Seq[UMLValueSpecification[Uml]]

  /**
   * Check whether stereotype is applied to element
   *
   * @note suggest using the safe OTI API
   * [[org.omg.oti.uml.read.operations.UMLElementOps.hasStereotype]]
   */
  def hasStereotype(element: UMLElement[Uml], stereotype: UMLStereotype[Uml]) : Boolean
   
}