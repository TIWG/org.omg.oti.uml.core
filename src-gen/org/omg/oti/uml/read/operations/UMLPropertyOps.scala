/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.Boolean
import scala.{Option,None,Some}
import scala.Predef._
import scala.collection.immutable.Set
// End of user code

/**
  * A Property is a StructuralFeature. A Property related by ownedAttribute to a Classifier (other than an association) represents an attribute and might also represent an association end. It relates an instance of the Classifier to a value or set of values of the type of the attribute. A Property related by memberEnd to an Association represents an end of the Association. The type of the Property is the type of the end of the Association. A Property has the capability of being a DeploymentTarget in a Deployment relationship. This enables modeling the deployment to hierarchical nodes that have Properties functioning as internal parts.  Property specializes ParameterableElement to specify that a Property can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPropertyOps[Uml <: UML] { self: UMLProperty[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Class that owns this Property, if any.
    *
    * <!-- Start of user code doc for _class -->
    * <!-- End of user code doc for _class -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClass.ownedAttribute
    */
  def _class: Option[UMLClass[Uml]] = namespace.selectByKindOf { case x: UMLClass[Uml] => x }

  /**
    * The Association of which this Property is a member, if any.
    *
    * <!-- Start of user code doc for association -->
    * <!-- End of user code doc for association -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAssociation.memberEnd
    */
  def association: Option[UMLAssociation[Uml]] = member_memberNamespace.selectByKindOf { case x: UMLAssociation[Uml] => x } headOption

  /**
    * Designates the optional association end that owns a qualifier attribute.
    *
    * <!-- Start of user code doc for associationEnd -->
    * <!-- End of user code doc for associationEnd -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.qualifier
    */
  def associationEnd: Option[UMLProperty[Uml]] = owner.selectByKindOf { case x: UMLProperty[Uml] => x }

  /**
    * The DataType that owns this Property, if any.
    *
    * <!-- Start of user code doc for datatype -->
    * <!-- End of user code doc for datatype -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDataType.ownedAttribute
    */
  def datatype: Option[UMLDataType[Uml]] = namespace.selectByKindOf { case x: UMLDataType[Uml] => x }

  /**
    * The Interface that owns this Property, if any.
    *
    * <!-- Start of user code doc for interface -->
    * <!-- End of user code doc for interface -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterface.ownedAttribute
    */
  def interface: Option[UMLInterface[Uml]] = namespace.selectByKindOf { case x: UMLInterface[Uml] => x }

  /**
    * If isComposite is true, the object containing the attribute is a container for the object or value contained in the attribute. This is a derived value, indicating whether the aggregation of the Property is composite or not.
    *
    * <!-- Start of user code doc for isComposite -->
    * <!-- End of user code doc for isComposite -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * {{{
    * OCL Body result = (aggregation = AggregationKind::composite)
    * }}}
    */
  def isComposite: Boolean = {
    // Start of user code for "isComposite"
    aggregation == UMLAggregationKind.composite
    // End of user code
  }

  /**
    * In the case where the Property is one end of a binary association this gives the other end.
    *
    * <!-- Start of user code doc for opposite -->
    * <!-- End of user code doc for opposite -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.opposite_property
    * {{{
    * OCL Body result = (if association <> null and association.memberEnd->size() = 2
    * then
    *     association.memberEnd->any(e | e <> self)
    * else
    *     null
    * endif)
    * }}}
    */
  def opposite: Option[UMLProperty[Uml]] = {
    // Start of user code for "opposite"
    association match {
      case Some(a) if 2 == a.memberEnd.size =>
        a.memberEnd.find(_ != self)
      case _                                =>
        None
    }
    // End of user code
  }

  /**
    * The owning association of this property, if any.
    *
    * <!-- Start of user code doc for owningAssociation -->
    * <!-- End of user code doc for owningAssociation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAssociation.ownedEnd
    */
  def owningAssociation: Option[UMLAssociation[Uml]] = featuringClassifier.selectByKindOf { case x: UMLAssociation[Uml] => x }

  /**
    * The properties that are redefined by this property, if any.
    *
    * <!-- Start of user code doc for redefinedProperty -->
    * <!-- End of user code doc for redefinedProperty -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.redefinedProperty_property
    */
  def redefinedProperty: Set[UMLProperty[Uml]] = redefinedElement.selectByKindOf { case x: UMLProperty[Uml] => x }

  /**
    * <!-- Start of user code doc for ownedAttribute_artifact -->
    * <!-- End of user code doc for ownedAttribute_artifact -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLArtifact.ownedAttribute
    */
  def ownedAttribute_artifact: Option[UMLArtifact[Uml]] = namespace.selectByKindOf { case x: UMLArtifact[Uml] => x }

  /**
    * <!-- Start of user code doc for ownedAttribute_owningSignal -->
    * <!-- End of user code doc for ownedAttribute_owningSignal -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSignal.ownedAttribute
    */
  def ownedAttribute_owningSignal: Option[UMLSignal[Uml]] = namespace.selectByKindOf { case x: UMLSignal[Uml] => x }

  /**
    * <!-- Start of user code doc for ownedAttribute_structuredClassifier -->
    * <!-- End of user code doc for ownedAttribute_structuredClassifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuredClassifier.ownedAttribute
    */
  def ownedAttribute_structuredClassifier: Option[UMLStructuredClassifier[Uml]] = namespace.selectByKindOf { case x: UMLStructuredClassifier[Uml] => x }

  /**
    * <!-- Start of user code doc for redefinedProperty_property -->
    * <!-- End of user code doc for redefinedProperty_property -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.redefinedProperty
    */
  def redefinedProperty_property: Set[UMLProperty[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLProperty[Uml] => x }

  /**
    * The query isAttribute() is true if the Property is defined as an attribute of some Classifier.
    *
    * <!-- Start of user code doc for isAttribute -->
    * <!-- End of user code doc for isAttribute -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (not classifier->isEmpty())
    * }}}
    */
  def isAttribute: Boolean = {
    // Start of user code for "isAttribute"
    classifier.nonEmpty
    // End of user code
  }

  /**
    * The query isCompatibleWith() determines if this Property is compatible with the specified ParameterableElement. This Property is compatible with ParameterableElement p if the kind of this Property is thesame as or a subtype of the kind of p. Further, if p is a TypedElement, then the type of this Property must be conformant with the type of p.
    *
    * <!-- Start of user code doc for isCompatibleWith -->
    * <!-- End of user code doc for isCompatibleWith -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (self.oclIsKindOf(p.oclType()) and (p.oclIsKindOf(TypeElement) implies
    * self.type.conformsTo(p.oclAsType(TypedElement).type)))
    * }}}
    */
  override def isCompatibleWith(p: Option[UMLParameterableElement[Uml]]): Boolean = {
    // Start of user code for "isCompatibleWith"
    ???
    // End of user code
  }

  /**
    * The query isConsistentWith() specifies, for any two Properties in a context in which redefinition is possible, whether redefinition would be logically consistent. A redefining Property is consistent with a redefined Property if the type of the redefining Property conforms to the type of the redefined Property, and the multiplicity of the redefining Property (if specified) is contained in the multiplicity of the redefined Property.
    *
    * <!-- Start of user code doc for isConsistentWith -->
    * <!-- End of user code doc for isConsistentWith -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (redefiningElement.oclIsKindOf(Property) and 
    *   let prop : Property = redefiningElement.oclAsType(Property) in 
    *   (prop.type.conformsTo(self.type) and 
    *   ((prop.lower()->notEmpty() and self.lower()->notEmpty()) implies prop.lower() >= self.lower()) and 
    *   ((prop.upper()->notEmpty() and self.upper()->notEmpty()) implies prop.lower() <= self.lower()) and 
    *   (self.isComposite implies prop.isComposite)))
    * }}}
    */
  override def isConsistentWith(redefiningElement: Option[UMLRedefinableElement[Uml]]): Boolean = {
    // Start of user code for "isConsistentWith"
    redefiningElement.fold[Boolean](false) {
      case p: UMLProperty[Uml] =>
        p._type.fold[Boolean](false) {
          pt =>
            pt.conformsTo(self._type)
        } &&
          (p.lowerValue.isEmpty || self.lowerValue.isEmpty || p.lower >= self.lower) &&
          (p.upperValue.isEmpty || self.upperValue.isEmpty || p.upper >= self.upper) &&
          !self.isComposite || p.isComposite
      case _ =>
        false
    }
    // End of user code
  }

  /**
    * The query isNavigable() indicates whether it is possible to navigate across the property.
    *
    * <!-- Start of user code doc for isNavigable -->
    * <!-- End of user code doc for isNavigable -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (not classifier->isEmpty() or association.navigableOwnedEnd->includes(self))
    * }}}
    */
  def isNavigable: Boolean = {
    // Start of user code for "isNavigable"
    isAttribute || (association match {
      case Some(a) =>
        a.navigableOwnedEnd.contains(self)
      case _       =>
        false
    })
    // End of user code
  }

  /**
    * The query subsettingContext() gives the context for subsetting a Property. It consists, in the case of an attribute, of the corresponding Classifier, and in the case of an association end, all of the Classifiers at the other ends.
    *
    * <!-- Start of user code doc for subsettingContext -->
    * <!-- End of user code doc for subsettingContext -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (if association <> null
    * then association.memberEnd->excluding(self)->collect(type)->asSet()
    * else 
    *   if classifier<>null
    *   then classifier->asSet()
    *   else Set{} 
    *   endif
    * endif)
    * }}}
    */
  def subsettingContext: Set[UMLType[Uml]] = {
    // Start of user code for "subsettingContext"
    association match {
      case Some(a) =>
        a.memberEnd
        .filter(_ != self)
        .flatMap(_._type)
        .toSet
      case None    =>
        classifier
        .toSet
    }
    // End of user code
  }

  /**
    * A binding of a PropertyTemplateParameter representing an attribute must be to an attribute.
    *
    * <!-- Start of user code doc for validate_binding_to_attribute -->
    * <!-- End of user code doc for validate_binding_to_attribute -->
    *
    * {{{
    * OCL Body (self.isAttribute()
    * and (templateParameterSubstitution->notEmpty())
    * implies (templateParameterSubstitution->forAll(ts |
    *     ts.formal.oclIsKindOf(Property)
    *     and ts.formal.oclAsType(Property).isAttribute())))
    * }}}
    */
  def validate_binding_to_attribute: Boolean = {
    // Start of user code for "binding_to_attribute"
    ???
    // End of user code
  }

  /**
    * A Property can be a DeploymentTarget if it is a kind of Node and functions as a part in the internal structure of an encompassing Node.
    *
    * <!-- Start of user code doc for validate_deployment_target -->
    * <!-- End of user code doc for validate_deployment_target -->
    *
    * {{{
    * OCL Body deployment->notEmpty() implies owner.oclIsKindOf(Node) and Node.allInstances()->exists(n | n.part->exists(p | p = self))
    * }}}
    */
  def validate_deployment_target: Boolean = {
    // Start of user code for "deployment_target"
    ???
    // End of user code
  }

  /**
    * A derived union is derived.
    *
    * <!-- Start of user code doc for validate_derived_union_is_derived -->
    * <!-- End of user code doc for validate_derived_union_is_derived -->
    *
    * {{{
    * OCL Body isDerivedUnion implies isDerived
    * }}}
    */
  def validate_derived_union_is_derived: Boolean = {
    // Start of user code for "derived_union_is_derived"
    !isDerivedUnion || isDerived
    // End of user code
  }

  /**
    * A derived union is read only.
    *
    * <!-- Start of user code doc for validate_derived_union_is_read_only -->
    * <!-- End of user code doc for validate_derived_union_is_read_only -->
    *
    * {{{
    * OCL Body isDerivedUnion implies isReadOnly
    * }}}
    */
  def validate_derived_union_is_read_only: Boolean = {
    // Start of user code for "derived_union_is_read_only"
    ???
    // End of user code
  }

  /**
    * A multiplicity on the composing end of a composite aggregation must not have an upper bound greater than 1.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_composite -->
    * <!-- End of user code doc for validate_multiplicity_of_composite -->
    *
    * {{{
    * OCL Body isComposite and association <> null implies opposite.upper() <= 1
    * }}}
    */
  def validate_multiplicity_of_composite: Boolean = {
    // Start of user code for "multiplicity_of_composite"
    !isComposite ||
      association.isEmpty ||
      (opposite match {
        case Some(p) =>
          p.upper <= 1
        case None    =>
          false
      })
    // End of user code
  }

  /**
    * All qualified Properties must be Association ends
    *
    * <!-- Start of user code doc for validate_qualified_is_association_end -->
    * <!-- End of user code doc for validate_qualified_is_association_end -->
    *
    * {{{
    * OCL Body qualifier->notEmpty() implies association->notEmpty()
    * }}}
    */
  def validate_qualified_is_association_end: Boolean = {
    // Start of user code for "qualified_is_association_end"
    ???
    // End of user code
  }

  /**
    * A redefined Property must be inherited from a more general Classifier.
    *
    * <!-- Start of user code doc for validate_redefined_property_inherited -->
    * <!-- End of user code doc for validate_redefined_property_inherited -->
    *
    * {{{
    * OCL Body (redefinedProperty->notEmpty()) implies
    *   (redefinitionContext->notEmpty() and
    *       redefinedProperty->forAll(rp|
    *         ((redefinitionContext->collect(fc|
    *           fc.allParents()))->asSet())->collect(c| c.allFeatures())->asSet()->includes(rp)))
    * }}}
    */
  def validate_redefined_property_inherited: Boolean = {
    // Start of user code for "redefined_property_inherited"
    ???
    // End of user code
  }

  /**
    * A Property may not subset a Property with the same name.
    *
    * <!-- Start of user code doc for validate_subsetted_property_names -->
    * <!-- End of user code doc for validate_subsetted_property_names -->
    *
    * {{{
    * OCL Body subsettedProperty->forAll(sp | sp.name <> name)
    * }}}
    */
  def validate_subsetted_property_names: Boolean = {
    // Start of user code for "subsetted_property_names"
    ???
    // End of user code
  }

  /**
    * Subsetting may only occur when the context of the subsetting property conforms to the context of the subsetted property.
    *
    * <!-- Start of user code doc for validate_subsetting_context_conforms -->
    * <!-- End of user code doc for validate_subsetting_context_conforms -->
    *
    * {{{
    * OCL Body subsettedProperty->notEmpty() implies
    *   (subsettingContext()->notEmpty() and subsettingContext()->forAll (sc |
    *     subsettedProperty->forAll(sp |
    *       sp.subsettingContext()->exists(c | sc.conformsTo(c)))))
    * }}}
    */
  def validate_subsetting_context_conforms: Boolean = {
    // Start of user code for "subsetting_context_conforms"
    ???
    // End of user code
  }

  /**
    * A subsetting Property may strengthen the type of the subsetted Property, and its upper bound may be less.
    *
    * <!-- Start of user code doc for validate_subsetting_rules -->
    * <!-- End of user code doc for validate_subsetting_rules -->
    *
    * {{{
    * OCL Body subsettedProperty->forAll(sp |
    *   self.type.conformsTo(sp.type) and
    *     ((self.upper()->notEmpty() and sp.upper()->notEmpty()) implies
    *       self.upper() <= sp.upper() ))
    * }}}
    */
  def validate_subsetting_rules: Boolean = {
    // Start of user code for "subsetting_rules"
    ???
    // End of user code
  }

  /**
    * If a Property is a classifier-owned end of a binary Association, its owner must be the type of the opposite end.
    *
    * <!-- Start of user code doc for validate_type_of_opposite_end -->
    * <!-- End of user code doc for validate_type_of_opposite_end -->
    *
    * {{{
    * OCL Body (opposite->notEmpty() and owningAssociation->isEmpty()) implies classifier = opposite.type
    * }}}
    */
  def validate_type_of_opposite_end: Boolean = {
    // Start of user code for "type_of_opposite_end"
    ???
    // End of user code
  }

  // Start of user code for additional features

  def classifier: Option[UMLClassifier[Uml]] =
    namespace match {
      case Some(c: UMLClassifier[Uml]) if c.attribute.contains(self) =>
        Some(c)
      case _                                                         =>
        None
    }

  def extension: Option[UMLExtension[Uml]] =
    member_memberNamespace.selectByKindOf { case x: UMLExtension[Uml] => x } headOption

  def owningStereotype: Option[UMLStereotype[Uml]] =
    namespace
    .selectByKindOf { case x: UMLStereotype[Uml] => x }

  /**
    * For a binary association, the logical navigability of an end property
    * is a function of the characteristics of the member ends.
    *
    * 1) this property is owned by a class; the opposite is owned by the association
    * 2) both ends have the same kind of ownership and this property is composite, the opposite is not
    * 3) both ends are owned by the association and this property is a navigable owned end, the opposite is not
    * 4) neither end is composite and this property is unbounded, the opposite has an upper bound of 1
    *
    * @return true if the property is a logically navigable association end
    */
  def isLogicallyNavigable
  : Boolean
  = association match {
      case None    =>
        false
      case Some(a) =>
        opposite match {
          case None       =>
            false
          case Some(that) =>
            val thisAssociationOwned = self.owningAssociation.isDefined
            val thisComposite = self.isComposite
            val thisNavigableOwnedEnd = self.navigableOwnedEnd_association.isDefined
            val thisUnbounded = -1 == self.upper
            val thisScalar = 1 == self.upper

            val thatAssociationOwned = that.owningAssociation.isDefined
            val thatComposite = that.isComposite
            val thatNavigableOwnedEnd = that.navigableOwnedEnd_association.isDefined
            val thatUnbounded = -1 == that.upper
            val thatScalar = 1 == that.upper

            val case1 = !thisAssociationOwned && thatAssociationOwned
            val case2 = thisAssociationOwned == thatAssociationOwned && thisComposite && !thatComposite
            val case3 = thisAssociationOwned && thatAssociationOwned && thisNavigableOwnedEnd && !thatNavigableOwnedEnd
            val case4 = !thisComposite && !thatComposite && thisUnbounded && !thatUnbounded && thatScalar
            case1 || case2 || case3 || case4
        }
    }

  /**
    * For a binary association, the semantic navigability of an end property
    * is a function of the subsetting and/or redefinition of the association ends.
    *
    * @return
    */
  def isSemanticallyNavigable
  : Boolean
  = isLogicallyNavigable ||
      closure(this, (x: UMLProperty[Uml]) => x.subsettedProperty).exists(_.isLogicallyNavigable) ||
      closure(this, (x: UMLProperty[Uml]) => x.redefinedProperty).exists(_.isLogicallyNavigable)

  /**
   * PSCS 2015-02-18, 8.5.1.2.4 CS_DefaultConstructStrategy
   * [2] public canInstantiate(p:Property) : Boolean
   * // Instantiate is possible if:
   * // - p is composite
   * // - p is typed
   * // - This type is a Class and it is not abstract
   * // - Or p is a Port and the type is an Interface
   * if (p.isComposite) {
   * if (p.typedElement.type != null) {
   * if (p.typedElement.type instanceof Class_) {
   * return ! ((Class_)p.typedElement.type).isAbstract ;
   * }
   * }
   * else if (p.typedElement.type instanceof Interface) {
   * return p instanceof Port ;
   * }
   * }
   * return false ;
   */
  def pscs_canInstantiate: Boolean =
    if (!isComposite) false
    else _type match {
      case Some(t: UMLClass[Uml])     => !t.isAbstract
      case Some(t: UMLInterface[Uml]) => this match {
        case _: UMLPort[Uml] => true
        case _               => false
      }
      case _                          => false
    }

  // End of user code
} //UMLPropertyOps
