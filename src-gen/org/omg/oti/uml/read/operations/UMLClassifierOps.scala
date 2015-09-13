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

import org.omg.oti.uml.read.api._

import scala.language.postfixOps

// End of user code

/**
 * A Classifier represents a classification of instances according to their Features.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLClassifierOps[Uml <: UML] { self: UMLClassifier[Uml] =>

	import self.ops._

	/**
	 * The CollaborationUses owned by the Classifier.
	 *
	 * <!-- Start of user code doc for collaborationUse -->
   * <!-- End of user code doc for collaborationUse -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLCollaborationUse.collaborationUse_classifier
	 */
	def collaborationUse: Set[UMLCollaborationUse[Uml]] = ownedElement.selectByKindOf { case x: UMLCollaborationUse[Uml] => x }

	/**
	 * Specifies each Feature directly defined in the classifier. Note that there may be members of the Classifier that are of the type Feature but are not included, e.g., inherited features.
	 *
	 * <!-- Start of user code doc for feature -->
   * <!-- End of user code doc for feature -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLFeature.featuringClassifier
	 */
	def feature: Set[UMLFeature[Uml]] = member.selectByKindOf { case x: UMLFeature[Uml] => x }

	/**
	 * The generalizing Classifiers for this Classifier.
	 *
	 * <!-- Start of user code doc for general -->
   * <!-- End of user code doc for general -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.general_classifier
	 * {{{
	 * OCL Body result = (parents())
	 * }}}
	 */
	def general: Set[UMLClassifier[Uml]] = {
		// Start of user code for "general"
    generalization flatMap (_.general)
    // End of user code
	}

	/**
	 * The Generalization relationships for this Classifier. These Generalizations navigate to more general Classifiers in the generalization hierarchy.
	 *
	 * <!-- Start of user code doc for generalization -->
   * <!-- End of user code doc for generalization -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLGeneralization.specific
	 */
	def generalization: Set[UMLGeneralization[Uml]] = ownedElement.selectByKindOf { case x: UMLGeneralization[Uml] => x }

	/**
	 * All elements inherited by this Classifier from its general Classifiers.
	 *
	 * <!-- Start of user code doc for inheritedMember -->
   * <!-- End of user code doc for inheritedMember -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLNamedElement.inheritedMember_inheritingClassifier
	 * {{{
	 * OCL Body result = (inherit(parents()->collect(inheritableMembers(self))->asSet()))
	 * }}}
	 */
	def inheritedMember: Set[UMLNamedElement[Uml]] = {
		// Start of user code for "inheritedMember"
    inherit(parents.flatMap(_.inheritableMembers(Some(self))))
    // End of user code
	}

	/**
	 * The optional RedefinableTemplateSignature specifying the formal template parameters.
	 *
	 * <!-- Start of user code doc for ownedTemplateSignature -->
   * <!-- End of user code doc for ownedTemplateSignature -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLRedefinableTemplateSignature.classifier
	 */
	override def ownedTemplateSignature: Option[UMLRedefinableTemplateSignature[Uml]] = ownedElement.selectByKindOf { case x: UMLRedefinableTemplateSignature[Uml] => x } headOption

	/**
	 * The UseCases owned by this classifier.
	 *
	 * <!-- Start of user code doc for ownedUseCase -->
   * <!-- End of user code doc for ownedUseCase -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLUseCase.ownedUseCase_classifier
	 */
	def ownedUseCase: Set[UMLUseCase[Uml]] = ownedMember.selectByKindOf { case x: UMLUseCase[Uml] => x }

	/**
	 * The Classifiers redefined by this Classifier.
	 *
	 * <!-- Start of user code doc for redefinedClassifier -->
   * <!-- End of user code doc for redefinedClassifier -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.redefinedClassifier_classifier
	 */
	def redefinedClassifier: Set[UMLClassifier[Uml]] = redefinedElement.selectByKindOf { case x: UMLClassifier[Uml] => x }

	/**
	 * A CollaborationUse which indicates the Collaboration that represents this Classifier.
	 *
	 * <!-- Start of user code doc for representation -->
   * <!-- End of user code doc for representation -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLCollaborationUse.representation_classifier
	 */
	def representation: Option[UMLCollaborationUse[Uml]] = collaborationUse headOption

	/**
	 * The Substitutions owned by this Classifier.
	 *
	 * <!-- Start of user code doc for substitution -->
   * <!-- End of user code doc for substitution -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLSubstitution.substitutingClassifier
	 */
	def substitution: Set[UMLSubstitution[Uml]] = ownedElement.selectByKindOf { case x: UMLSubstitution[Uml] => x }

	/**
	 * <!-- Start of user code doc for general_generalization -->
   * <!-- End of user code doc for general_generalization -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLGeneralization.general
	 */
	def general_generalization: Set[UMLGeneralization[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLGeneralization[Uml] => x }

	/**
	 * <!-- Start of user code doc for nestedClassifier_interface -->
   * <!-- End of user code doc for nestedClassifier_interface -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLInterface.nestedClassifier
	 */
	def nestedClassifier_interface: Option[UMLInterface[Uml]] = namespace.selectByKindOf { case x: UMLInterface[Uml] => x }

	/**
	 * <!-- Start of user code doc for nestedClassifier_nestingClass -->
   * <!-- End of user code doc for nestedClassifier_nestingClass -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLClass.nestedClassifier
	 */
	def nestedClassifier_nestingClass: Option[UMLClass[Uml]] = redefinitionContext.selectByKindOf { case x: UMLClass[Uml] => x } headOption

	/**
	 * <!-- Start of user code doc for redefinedClassifier_classifier -->
   * <!-- End of user code doc for redefinedClassifier_classifier -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.redefinedClassifier
	 */
	def redefinedClassifier_classifier: Set[UMLClassifier[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLClassifier[Uml] => x }

	/**
	 * <!-- Start of user code doc for redefinitionContext_region -->
   * <!-- End of user code doc for redefinitionContext_region -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLRegion.redefinitionContext
	 */
	def redefinitionContext_region: Set[UMLRegion[Uml]] = redefinitionContext_redefinableElement.selectByKindOf { case x: UMLRegion[Uml] => x }

	/**
	 * <!-- Start of user code doc for redefinitionContext_state -->
   * <!-- End of user code doc for redefinitionContext_state -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLState.redefinitionContext
	 */
	def redefinitionContext_state: Set[UMLState[Uml]] = redefinitionContext_redefinableElement.selectByKindOf { case x: UMLState[Uml] => x }

	/**
	 * <!-- Start of user code doc for redefinitionContext_transition -->
   * <!-- End of user code doc for redefinitionContext_transition -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLTransition.redefinitionContext
	 */
	def redefinitionContext_transition: Set[UMLTransition[Uml]] = redefinitionContext_redefinableElement.selectByKindOf { case x: UMLTransition[Uml] => x }

	/**
	 * The query allAttributes gives an ordered set of all owned and inherited attributes of the Classifier. All owned attributes appear before any inherited attributes, and the attributes inherited from any more specific parent Classifier appear before those of any more general parent Classifier. However, if the Classifier has multiple immediate parents, then the relative ordering of the sets of attributes from those parents is not defined.
	 *
	 * <!-- Start of user code doc for allAttributes -->
   * <!-- End of user code doc for allAttributes -->
	 *
	 * UML Operation ordered="true" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (attribute->asSequence()->union(parents()->asSequence().allAttributes())->select(p | member->includes(p))->asOrderedSet())
	 * }}}
	 */
	def allAttributes: Seq[UMLProperty[Uml]] = {
		// Start of user code for "allAttributes"
    attribute ++ parents.flatMap(_.allAttributes)
    // End of user code
	}

	/**
	 * The query allFeatures() gives all of the Features in the namespace of the Classifier. In general, through mechanisms such as inheritance, this will be a larger set than feature.
	 *
	 * <!-- Start of user code doc for allFeatures -->
   * <!-- End of user code doc for allFeatures -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (member->select(oclIsKindOf(Feature))->collect(oclAsType(Feature))->asSet())
	 * }}}
	 */
	def allFeatures: Set[UMLFeature[Uml]] = {
		// Start of user code for "allFeatures"
    member
    .selectByKindOf { case f: UMLFeature[Uml] => f }
    // End of user code
	}

	/**
	 * The query allParents() gives all of the direct and indirect ancestors of a generalized Classifier.
	 *
	 * <!-- Start of user code doc for allParents -->
   * <!-- End of user code doc for allParents -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (parents()->union(parents()->collect(allParents())->asSet()))
	 * }}}
	 */
	def allParents: Set[UMLClassifier[Uml]] = {
		// Start of user code for "allParents"
    closure[UMLClassifier[Uml], UMLClassifier[Uml]](self, _.parents)
    // End of user code
	}

	/**
	 * The Interfaces realized by this Classifier and all of its generalizations
	 *
	 * <!-- Start of user code doc for allRealizedInterfaces -->
   * <!-- End of user code doc for allRealizedInterfaces -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (directlyRealizedInterfaces()->union(self.allParents()->collect(directlyRealizedInterfaces()))->asSet())
	 * }}}
	 */
	def allRealizedInterfaces: Set[UMLInterface[Uml]] = {
		// Start of user code for "allRealizedInterfaces"
    directlyRealizedInterfaces ++ allParents.flatMap(_.directlyRealizedInterfaces)
    // End of user code
	}

	/**
	 * All StructuralFeatures related to the Classifier that may have Slots, including direct attributes, inherited attributes, private attributes in generalizations, and memberEnds of Associations, but excluding redefined StructuralFeatures.
	 *
	 * <!-- Start of user code doc for allSlottableFeatures -->
   * <!-- End of user code doc for allSlottableFeatures -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (member->select(oclIsKindOf(StructuralFeature))->
	 *   collect(oclAsType(StructuralFeature))->
	 *    union(self.inherit(self.allParents()->collect(p | p.attribute)->asSet())->
	 *      collect(oclAsType(StructuralFeature)))->asSet())
	 * }}}
	 */
	def allSlottableFeatures: Set[UMLStructuralFeature[Uml]] = {
		// Start of user code for "allSlottableFeatures"

    def filterStructuralFeatures[T <: UMLNamedElement[Uml]]
    (s: Set[T])
    : Set[UMLStructuralFeature[Uml]] =
      s.selectByKindOf { case sf: UMLStructuralFeature[Uml] => sf }

    val allStructuralFeatures =
      filterStructuralFeatures(member) ++
        filterStructuralFeatures(inherit(allParents.flatMap(_.attribute)))

    val allRedefinedStructuralFeatures =
      allStructuralFeatures
      .flatMap(sf => filterStructuralFeatures(sf.redefinedElement))

    allStructuralFeatures -- allRedefinedStructuralFeatures
    // End of user code
	}

	/**
	 * The Interfaces used by this Classifier and all of its generalizations
	 *
	 * <!-- Start of user code doc for allUsedInterfaces -->
   * <!-- End of user code doc for allUsedInterfaces -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (directlyUsedInterfaces()->union(self.allParents()->collect(directlyUsedInterfaces()))->asSet())
	 * }}}
	 */
	def allUsedInterfaces: Set[UMLInterface[Uml]] = {
		// Start of user code for "allUsedInterfaces"
    directlyUsedInterfaces ++ allParents.flatMap(_.directlyUsedInterfaces)
    // End of user code
	}

	/**
	 * The query conformsTo() gives true for a Classifier that defines a type that conforms to another. This is used, for example, in the specification of signature conformance for operations.
	 *
	 * <!-- Start of user code doc for conformsTo -->
   * <!-- End of user code doc for conformsTo -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (if other.oclIsKindOf(Classifier) then
	 *   let otherClassifier : Classifier = other.oclAsType(Classifier) in
	 *     self = otherClassifier or allParents()->includes(otherClassifier)
	 * else
	 *   false
	 * endif)
	 * }}}
	 */
	override def conformsTo(other: Option[UMLType[Uml]]): Boolean = {
		// Start of user code for "conformsTo"
    other match {
      case Some(otherClassifier: UMLClassifier[Uml]) =>
        self == otherClassifier || allParents.contains(otherClassifier)
      case _                                         =>
        false
    }
    // End of user code
	}

	/**
	 * The Interfaces directly realized by this Classifier
	 *
	 * <!-- Start of user code doc for directlyRealizedInterfaces -->
   * <!-- End of user code doc for directlyRealizedInterfaces -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = ((clientDependency->
	 *   select(oclIsKindOf(Realization) and supplier->forAll(oclIsKindOf(Interface))))->
	 *       collect(supplier.oclAsType(Interface))->asSet())
	 * }}}
	 */
	def directlyRealizedInterfaces: Set[UMLInterface[Uml]] = {
		// Start of user code for "directlyRealizedInterfaces"

    def realizedInterfaces
    (r: UMLRealization[Uml])
    : Set[UMLInterface[Uml]] = {
      val acc0: Option[Set[UMLInterface[Uml]]] = Some(Set())
      ( acc0 /: r.supplier ) {
      case (Some(is), i: UMLInterface[Uml]) => Some(is + i)
      case _ => None
      } getOrElse (Set())
    }

    clientDependency
    .selectByKindOf { case r: UMLRealization[Uml] => r }
    .flatMap(realizedInterfaces)
    // End of user code
	}

	/**
	 * The Interfaces directly used by this Classifier
	 *
	 * <!-- Start of user code doc for directlyUsedInterfaces -->
   * <!-- End of user code doc for directlyUsedInterfaces -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = ((supplierDependency->
	 *   select(oclIsKindOf(Usage) and client->forAll(oclIsKindOf(Interface))))->
	 *     collect(client.oclAsType(Interface))->asSet())
	 * }}}
	 */
	def directlyUsedInterfaces: Set[UMLInterface[Uml]] = {
		// Start of user code for "directlyUsedInterfaces"
    def usedInterfaces
    (r: UMLRealization[Uml])
    : Set[UMLInterface[Uml]] = {
      val acc0: Option[Set[UMLInterface[Uml]]] = Some(Set())
      ( acc0 /: r.client ) {
      case (Some(is), i: UMLInterface[Uml]) => Some(is + i)
      case _ => None
      } getOrElse (Set())
    }

    supplier_supplierDependency
    .selectByKindOf { case r: UMLRealization[Uml] => r }
    .flatMap(usedInterfaces)
    // End of user code
	}

	/**
	 * The query hasVisibilityOf() determines whether a NamedElement is visible in the classifier. Non-private members are visible. It is only called when the argument is something owned by a parent.
	 *
	 * <!-- Start of user code doc for hasVisibilityOf -->
   * <!-- End of user code doc for hasVisibilityOf -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (n.visibility <> VisibilityKind::private)
	 * }}}
	 */
	def hasVisibilityOf(n: Option[UMLNamedElement[Uml]]): Boolean = {
		// Start of user code for "hasVisibilityOf"
    n match {
      case None     => true
      case Some(ne) => ne.visibility != UMLVisibilityKind._private
    }
    // End of user code
	}

	/**
	 * The query inherit() defines how to inherit a set of elements passed as its argument.  It excludes redefined elements from the result.
	 *
	 * <!-- Start of user code doc for inherit -->
   * <!-- End of user code doc for inherit -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (inhs->reject(inh |
	 *   inh.oclIsKindOf(RedefinableElement) and
	 *   ownedMember->select(oclIsKindOf(RedefinableElement))->
	 *     select(redefinedElement->includes(inh.oclAsType(RedefinableElement)))
	 *        ->notEmpty()))
	 * }}}
	 */
	def inherit(inhs: Set[UMLNamedElement[Uml]]): Set[UMLNamedElement[Uml]] = {
		// Start of user code for "inherit"
    inhs
    .filterNot {
                 case inh: UMLRedefinableElement[Uml] =>
                   ownedMember.exists {
                                        case re: UMLRedefinableElement[Uml] =>
                                          re.redefinedElement.contains(inh)
                                        case _                              =>
                                          false
                                      }
                 case _                               =>
                   false

               }
    // End of user code
	}

	/**
	 * The query inheritableMembers() gives all of the members of a Classifier that may be inherited in one of its descendants, subject to whatever visibility restrictions apply.
	 *
	 * <!-- Start of user code doc for inheritableMembers -->
   * <!-- End of user code doc for inheritableMembers -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (member->select(m | c.hasVisibilityOf(m)))
	 * }}}
	 */
	def inheritableMembers(c: Option[UMLClassifier[Uml]]): Set[UMLNamedElement[Uml]] = {
		// Start of user code for "inheritableMembers"
    c match {
      case None     => Set()
      case Some(cl) => member.filter(m => cl.hasVisibilityOf(Some(m)))
    }
    // End of user code
	}

	/**
	 * <!-- Start of user code doc for isSubstitutableFor -->
   * <!-- End of user code doc for isSubstitutableFor -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (substitution.contract->includes(contract))
	 * }}}
	 */
	def isSubstitutableFor(contract: Option[UMLClassifier[Uml]]): Boolean = {
		// Start of user code for "isSubstitutableFor"
    contract match {
      case Some(c) => substitution.flatMap(_.contract).contains(c)
      case None    => false
    }
    // End of user code
	}

	/**
	 * The query isTemplate() returns whether this Classifier is actually a template.
	 *
	 * <!-- Start of user code doc for isTemplate -->
   * <!-- End of user code doc for isTemplate -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (ownedTemplateSignature <> null or general->exists(g | g.isTemplate()))
	 * }}}
	 */
	override def isTemplate: Boolean = {
		// Start of user code for "isTemplate"
    ownedTemplateSignature match {
      case Some(_) => true
      case None    => general.exists(g => g.isTemplate)
    }
    // End of user code
	}

	/**
	 * The query maySpecializeType() determines whether this classifier may have a generalization relationship to classifiers of the specified type. By default a classifier may specialize classifiers of the same or a more general type. It is intended to be redefined by classifiers that have different specialization constraints.
	 *
	 * <!-- Start of user code doc for maySpecializeType -->
   * <!-- End of user code doc for maySpecializeType -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (self.oclIsKindOf(c.oclType()))
	 * }}}
	 */
	def maySpecializeType(c: Option[UMLClassifier[Uml]]): Boolean = {
		// Start of user code for "maySpecializeType"
    c match {
      case Some(cl) => self.mofMetaclassName == cl.mofMetaclassName
      case None     => false
    }
    // End of user code
	}

	/**
	 * The query parents() gives all of the immediate ancestors of a generalized Classifier.
	 *
	 * <!-- Start of user code doc for parents -->
   * <!-- End of user code doc for parents -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (generalization.general->asSet())
	 * }}}
	 */
	def parents: Set[UMLClassifier[Uml]] = {
		// Start of user code for "parents"
    general
    // End of user code
	}

	/**
	 * The Classifier that maps to a GeneralizationSet may neither be a specific nor a general Classifier in any of the Generalization relationships defined for that GeneralizationSet. In other words, a power type may not be an instance of itself nor may its instances also be its subclasses.
	 *
	 * <!-- Start of user code doc for validate_maps_to_generalization_set -->
   * <!-- End of user code doc for validate_maps_to_generalization_set -->
	 *
	 * {{{
	 * OCL Body powertypeExtent->forAll( gs | 
	 * }}}
	 * {{{
	 *   gs.generalization->forAll( gen | 
	 * }}}
	 * {{{
	 *     not (gen.general = self) and not gen.general.allParents()->includes(self) and not (gen.specific = self) and not self.allParents()->includes(gen.specific) 
	 * }}}
	 * {{{
	 *   ))
	 * }}}
	 */
	def validate_maps_to_generalization_set: Boolean = {
		// Start of user code for "maps_to_generalization_set"
    powertypeExtent.forall {
                             gs =>
                               gs.generalization.forall {
                                                          gen =>
                                                            (gen.general match {
                                                              case Some(g) =>
                                                                g != self &&
                                                                  !g.allParents.contains(self)
                                                              case None    =>
                                                                false
                                                            }) &&
                                                              (gen.specific match {
                                                                case Some(s) =>
                                                                  s != self &&
                                                                    !self.allParents.contains(s)
                                                                case None    =>
                                                                  false
                                                              })
                                                        }
                           }
    // End of user code
	}

	/**
	 * Generalization hierarchies must be directed and acyclical. A Classifier can not be both a transitively general and transitively specific Classifier of the same Classifier.
	 *
	 * <!-- Start of user code doc for validate_no_cycles_in_generalization -->
   * <!-- End of user code doc for validate_no_cycles_in_generalization -->
	 *
	 * {{{
	 * OCL Body not allParents()->includes(self)
	 * }}}
	 */
	def validate_no_cycles_in_generalization: Boolean = {
		// Start of user code for "no_cycles_in_generalization"
    !allParents.contains(self)
    // End of user code
	}

	/**
	 * The parents of a Classifier must be non-final.
	 *
	 * <!-- Start of user code doc for validate_non_final_parents -->
   * <!-- End of user code doc for validate_non_final_parents -->
	 *
	 * {{{
	 * OCL Body parents()->forAll(not isFinalSpecialization)
	 * }}}
	 */
	def validate_non_final_parents: Boolean = {
		// Start of user code for "non_final_parents"
    parents.forall(c => !c.isFinalSpecialization)
    // End of user code
	}

	/**
	 * A Classifier may only specialize Classifiers of a valid type.
	 *
	 * <!-- Start of user code doc for validate_specialize_type -->
   * <!-- End of user code doc for validate_specialize_type -->
	 *
	 * {{{
	 * OCL Body parents()->forAll(c | self.maySpecializeType(c))
	 * }}}
	 */
	def validate_specialize_type: Boolean = {
		// Start of user code for "specialize_type"
    parents.forall(c => self.maySpecializeType(Some(c)))
    // End of user code
	}

	// Start of user code for additional features

  def allAttributesExceptRedefined: Seq[UMLProperty[Uml]] = {
    val redefinedroperties = allAttributes flatMap (_.redefinedProperty)
    allAttributes.filterNot(redefinedroperties.contains(_))
  }

  // End of user code
} //UMLClassifierOps
