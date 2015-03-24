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
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * <!-- begin-model-doc -->
 * A Classifier represents a classification of instances according to their Features.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLClassifierOps[Uml <: UML] { self: UMLClassifier[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The CollaborationUses owned by the Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLCollaborationUse.collaborationUse_classifier
	 */
	def collaborationUse: Set[UMLCollaborationUse[Uml]] = ownedElement.selectByKindOf { case x: UMLCollaborationUse[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * Specifies each Feature directly defined in the classifier. Note that there may be members of the Classifier that are of the type Feature but are not included, e.g., inherited features.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLFeature.featuringClassifier
	 */
	def feature: Set[UMLFeature[Uml]] = ownedMember.selectByKindOf { case x: UMLFeature[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The generalizing Classifiers for this Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.general_classifier
	 * @body result = (parents())
	 */
	def general: Set[UMLClassifier[Uml]] = {
		// Start of user code for "general"
	    generalization flatMap ( _.general )//TBD
	    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The Generalization relationships for this Classifier. These Generalizations navigate to more general Classifiers in the generalization hierarchy.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLGeneralization.specific
	 */
	def generalization: Set[UMLGeneralization[Uml]] = ownedElement.selectByKindOf { case x: UMLGeneralization[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * All elements inherited by this Classifier from its general Classifiers.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLNamedElement.inheritedMember_inheritingClassifier
	 * @body result = (inherit(parents()->collect(inheritableMembers(self))->asSet()))
	 */
	def inheritedMember: Set[UMLNamedElement[Uml]] = {
		// Start of user code for "inheritedMember"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The optional RedefinableTemplateSignature specifying the formal template parameters.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLRedefinableTemplateSignature.classifier
	 */
	override def ownedTemplateSignature: Option[UMLRedefinableTemplateSignature[Uml]] = ownedElement.selectByKindOf { case x: UMLRedefinableTemplateSignature[Uml] => x } headOption

	/**
	 * <!-- begin-model-doc -->
	 * The UseCases owned by this classifier.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLUseCase.ownedUseCase_classifier
	 */
	def ownedUseCase: Set[UMLUseCase[Uml]] = ownedMember.selectByKindOf { case x: UMLUseCase[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The Classifiers redefined by this Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.redefinedClassifier_classifier
	 */
	def redefinedClassifier: Set[UMLClassifier[Uml]] = redefinedElement.selectByKindOf { case x: UMLClassifier[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The Substitutions owned by this Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLSubstitution.substitutingClassifier
	 */
	def substitution: Set[UMLSubstitution[Uml]] = ownedElement.selectByKindOf { case x: UMLSubstitution[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLAction.context
	 */
	def context_action: Set[UMLAction[Uml]] = {
		// Start of user code for "action"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.general
	 */
	def general_classifier: Set[UMLClassifier[Uml]] = {
		// Start of user code for "classifier"
	    general_generalization flatMap (_.specific) // TBD
	    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLGeneralization.general
	 */
	def general_generalization: Set[UMLGeneralization[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLGeneralization[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInterface.nestedClassifier
	 */
	def nestedClassifier_interface: Option[UMLInterface[Uml]] = namespace.selectByKindOf { case x: UMLInterface[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClass.nestedClassifier
	 */
	def nestedClassifier_nestingClass: Option[UMLClass[Uml]] = redefinitionContext.selectByKindOf { case x: UMLClass[Uml] => x } headOption

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.redefinedClassifier
	 */
	def redefinedClassifier_classifier: Set[UMLClassifier[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLClassifier[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRegion.redefinitionContext
	 */
	def redefinitionContext_region: Set[UMLRegion[Uml]] = redefinitionContext_redefinableElement.selectByKindOf { case x: UMLRegion[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLState.redefinitionContext
	 */
	def redefinitionContext_state: Set[UMLState[Uml]] = redefinitionContext_redefinableElement.selectByKindOf { case x: UMLState[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTransition.redefinitionContext
	 */
	def redefinitionContext_transition: Set[UMLTransition[Uml]] = redefinitionContext_redefinableElement.selectByKindOf { case x: UMLTransition[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The query allAttributes gives an ordered set of all owned and inherited attributes of the Classifier. All owned attributes appear before any inherited attributes, and the attributes inherited from any more specific parent Classifier appear before those of any more general parent Classifier. However, if the Classifier has multiple immediate parents, then the relative ordering of the sets of attributes from those parents is not defined.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="true" unique="true" multiplicity="0..*"
	 * @body result = (attribute->asSequence()->union(parents()->asSequence().allAttributes())->select(p | member->includes(p))->asOrderedSet())
	 */
	def allAttributes: Seq[UMLProperty[Uml]]  = {
		// Start of user code for "allAttributes"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query allFeatures() gives all of the Features in the namespace of the Classifier. In general, through mechanisms such as inheritance, this will be a larger set than feature.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (member->select(oclIsKindOf(Feature))->collect(oclAsType(Feature))->asSet())
	 */
	def allFeatures: Set[UMLFeature[Uml]]  = {
		// Start of user code for "allFeatures"
    	member.selectByKindOf { case f: UMLFeature[Uml] => f }
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query allParents() gives all of the direct and indirect ancestors of a generalized Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (parents()->union(parents()->collect(allParents())->asSet()))
	 */
	def allParents: Set[UMLClassifier[Uml]]  = {
		// Start of user code for "allParents"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The Interfaces realized by this Classifier and all of its generalizations
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (directlyRealizedInterfaces()->union(self.allParents()->collect(directlyRealizedInterfaces()))->asSet())
	 */
	def allRealizedInterfaces: Set[UMLInterface[Uml]]  = {
		// Start of user code for "allRealizedInterfaces"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * All StructuralFeatures related to the Classifier that may have Slots, including direct attributes, inherited attributes, private attributes in generalizations, and memberEnds of Associations, but excluding redefined StructuralFeatures.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (member->select(oclIsKindOf(StructuralFeature))->
	 *   collect(oclAsType(StructuralFeature))->
	 *    union(self.inherit(self.allParents()->collect(p | p.attribute)->asSet())->
	 *      collect(oclAsType(StructuralFeature)))->asSet())
	 */
	def allSlottableFeatures: Set[UMLStructuralFeature[Uml]]  = {
		// Start of user code for "allSlottableFeatures"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The Interfaces used by this Classifier and all of its generalizations
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (directlyUsedInterfaces()->union(self.allParents()->collect(directlyUsedInterfaces()))->asSet())
	 */
	def allUsedInterfaces: Set[UMLInterface[Uml]]  = {
		// Start of user code for "allUsedInterfaces"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query conformsTo() gives true for a Classifier that defines a type that conforms to another. This is used, for example, in the specification of signature conformance for operations.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if other.oclIsKindOf(Classifier) then
	 *   let otherClassifier : Classifier = other.oclAsType(Classifier) in
	 *     self = otherClassifier or allParents()->includes(otherClassifier)
	 * else
	 *   false
	 * endif)
	 */
	override def conformsTo(other: Option[UMLType[Uml]]): Boolean  = {
		// Start of user code for "conformsTo"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The Interfaces directly realized by this Classifier
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = ((clientDependency->
	 *   select(oclIsKindOf(Realization) and supplier->forAll(oclIsKindOf(Interface))))->
	 *       collect(supplier.oclAsType(Interface))->asSet())
	 */
	def directlyRealizedInterfaces: Set[UMLInterface[Uml]]  = {
		// Start of user code for "directlyRealizedInterfaces"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The Interfaces directly used by this Classifier
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = ((supplierDependency->
	 *   select(oclIsKindOf(Usage) and client->forAll(oclIsKindOf(Interface))))->
	 *     collect(client.oclAsType(Interface))->asSet())
	 */
	def directlyUsedInterfaces: Set[UMLInterface[Uml]]  = {
		// Start of user code for "directlyUsedInterfaces"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query hasVisibilityOf() determines whether a NamedElement is visible in the classifier. Non-private members are visible. It is only called when the argument is something owned by a parent.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (n.visibility <> VisibilityKind::private)
	 */
	def hasVisibilityOf(n: Option[UMLNamedElement[Uml]]): Boolean  = {
		// Start of user code for "hasVisibilityOf"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query inherit() defines how to inherit a set of elements passed as its argument.  It excludes redefined elements from the result.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (inhs->reject(inh |
	 *   inh.oclIsKindOf(RedefinableElement) and
	 *   ownedMember->select(oclIsKindOf(RedefinableElement))->
	 *     select(redefinedElement->includes(inh.oclAsType(RedefinableElement)))
	 *        ->notEmpty()))
	 */
	def inherit(inhs: Set[UMLNamedElement[Uml]]): Set[UMLNamedElement[Uml]]  = {
		// Start of user code for "inherit"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query inheritableMembers() gives all of the members of a Classifier that may be inherited in one of its descendants, subject to whatever visibility restrictions apply.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (member->select(m | c.hasVisibilityOf(m)))
	 */
	def inheritableMembers(c: Option[UMLClassifier[Uml]]): Set[UMLNamedElement[Uml]]  = {
		// Start of user code for "inheritableMembers"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (substitution.contract->includes(contract))
	 */
	def isSubstitutableFor(contract: Option[UMLClassifier[Uml]]): Boolean  = {
		// Start of user code for "isSubstitutableFor"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query isTemplate() returns whether this Classifier is actually a template.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (ownedTemplateSignature <> null or general->exists(g | g.isTemplate()))
	 */
	override def isTemplate: Boolean  = {
		// Start of user code for "isTemplate"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query maySpecializeType() determines whether this classifier may have a generalization relationship to classifiers of the specified type. By default a classifier may specialize classifiers of the same or a more general type. It is intended to be redefined by classifiers that have different specialization constraints.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (self.oclIsKindOf(c.oclType()))
	 */
	def maySpecializeType(c: Option[UMLClassifier[Uml]]): Boolean  = {
		// Start of user code for "maySpecializeType"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query parents() gives all of the immediate ancestors of a generalized Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (generalization.general->asSet())
	 */
	def parents: Set[UMLClassifier[Uml]]  = {
		// Start of user code for "parents"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The Classifier that maps to a GeneralizationSet may neither be a specific nor a general Classifier in any of the Generalization relationships defined for that GeneralizationSet. In other words, a power type may not be an instance of itself nor may its instances also be its subclasses.
	 * <!-- end-model-doc -->
	 *
	 * @body powertypeExtent->forAll( gs | 
	 *   gs.generalization->forAll( gen | 
	 *     not (gen.general = self) and not gen.general.allParents()->includes(self) and not (gen.specific = self) and not self.allParents()->includes(gen.specific) 
	 *   ))
	 */
	def validate_maps_to_generalization_set: Boolean  = {
		// Start of user code for "maps_to_generalization_set"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * Generalization hierarchies must be directed and acyclical. A Classifier can not be both a transitively general and transitively specific Classifier of the same Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @body not allParents()->includes(self)
	 */
	def validate_no_cycles_in_generalization: Boolean  = {
		// Start of user code for "no_cycles_in_generalization"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The parents of a Classifier must be non-final.
	 * <!-- end-model-doc -->
	 *
	 * @body parents()->forAll(not isFinalSpecialization)
	 */
	def validate_non_final_parents: Boolean  = {
		// Start of user code for "non_final_parents"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A Classifier may only specialize Classifiers of a valid type.
	 * <!-- end-model-doc -->
	 *
	 * @body parents()->forAll(c | self.maySpecializeType(c))
	 */
	def validate_specialize_type: Boolean  = {
		// Start of user code for "specialize_type"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLClassifier
