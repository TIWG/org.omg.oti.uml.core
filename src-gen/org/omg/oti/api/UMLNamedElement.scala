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
package org.omg.oti.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.operations._
// End of user code

/**
 * A NamedElement is an Element in a model that may have a name. The name may be given directly and/or via the use of a StringExpression.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLNamedElement[Uml <: UML]
	extends UMLElement[Uml]
	with UMLNamedElementOps[Uml] {
	
	import ops._

	/**
	 * Indicates the Dependencies that reference this NamedElement as a client.
	 *
	 * <!-- Start of user code doc for clientDependency -->
	 * <!-- End of user code doc for clientDependency -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLDependency.client
	 * @body result = (Dependency.allInstances()->select(d | d.client->includes(self)))
	 */
	def clientDependency: Set[UMLDependency[Uml]]

	/**
	 * The name of the NamedElement.
	 *
	 * <!-- Start of user code doc for name -->
	 * <!-- End of user code doc for name -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def name: Option[String]

	/**
	 * The StringExpression used to define the name of this NamedElement.
	 *
	 * <!-- Start of user code doc for nameExpression -->
	 * <!-- End of user code doc for nameExpression -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStringExpression.nameExpression_namedElement
	 */
	def nameExpression: Option[UMLStringExpression[Uml]]

	/**
	 * Specifies the Namespace that owns the NamedElement.
	 *
	 * <!-- Start of user code doc for namespace -->
	 * <!-- End of user code doc for namespace -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLNamespace.ownedMember
	 */
	def namespace: Option[UMLNamespace[Uml]]

	/**
	 * A name that allows the NamedElement to be identified within a hierarchy of nested Namespaces. It is constructed from the names of the containing Namespaces starting at the root of the hierarchy and ending with the name of the NamedElement itself.
	 *
	 * <!-- Start of user code doc for qualifiedName -->
	 * <!-- End of user code doc for qualifiedName -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @body result = (if self.name <> null and self.allNamespaces()->select( ns | ns.name=null )->isEmpty()
	 * then 
	 *     self.allNamespaces()->iterate( ns : Namespace; agg: String = self.name | ns.name.concat(self.separator()).concat(agg))
	 * else
	 *    null
	 * endif)
	 */
	def qualifiedName: Option[String]

	/**
	 * Determines whether and how the NamedElement is visible outside its owning Namespace.
	 *
	 * <!-- Start of user code doc for visibility -->
	 * <!-- End of user code doc for visibility -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def visibility: Option[UMLVisibilityKind.Value]

	/**
	 * <!-- Start of user code doc for event_durationObservation -->
	 * <!-- End of user code doc for event_durationObservation -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLDurationObservation.event
	 */
	def event_durationObservation: Set[UMLDurationObservation[Uml]]

	/**
	 * <!-- Start of user code doc for event_timeObservation -->
	 * <!-- End of user code doc for event_timeObservation -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTimeObservation.event
	 */
	def event_timeObservation: Set[UMLTimeObservation[Uml]]

	/**
	 * <!-- Start of user code doc for informationSource_informationFlow -->
	 * <!-- End of user code doc for informationSource_informationFlow -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInformationFlow.informationSource
	 */
	def informationSource_informationFlow: Set[UMLInformationFlow[Uml]]

	/**
	 * <!-- Start of user code doc for informationTarget_informationFlow -->
	 * <!-- End of user code doc for informationTarget_informationFlow -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInformationFlow.informationTarget
	 */
	def informationTarget_informationFlow: Set[UMLInformationFlow[Uml]]

	/**
	 * <!-- Start of user code doc for inheritedMember_inheritingClassifier -->
	 * <!-- End of user code doc for inheritedMember_inheritingClassifier -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.inheritedMember
	 */
	def inheritedMember_inheritingClassifier: Set[UMLClassifier[Uml]]

	/**
	 * <!-- Start of user code doc for member_memberNamespace -->
	 * <!-- End of user code doc for member_memberNamespace -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLNamespace.member
	 */
	def member_memberNamespace: Set[UMLNamespace[Uml]]

	/**
	 * <!-- Start of user code doc for message_considerIgnoreFragment -->
	 * <!-- End of user code doc for message_considerIgnoreFragment -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConsiderIgnoreFragment.message
	 */
	def message_considerIgnoreFragment: Set[UMLConsiderIgnoreFragment[Uml]]

	/**
	 * <!-- Start of user code doc for signature_message -->
	 * <!-- End of user code doc for signature_message -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLMessage.signature
	 */
	def signature_message: Set[UMLMessage[Uml]]

	/**
	 * Indicates the dependencies that reference the supplier.
	 *
	 * <!-- Start of user code doc for supplier_supplierDependency -->
	 * <!-- End of user code doc for supplier_supplierDependency -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLDependency.supplier
	 */
	def supplier_supplierDependency: Set[UMLDependency[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		namedElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLNamedElement
	 *
	 * <!-- Start of user code doc for namedElement_metaAttributes -->
	 * <!-- End of user code doc for namedElement_metaAttributes -->
	 */
	def namedElement_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			element_metaAttributes,
			Seq (NamedElement_name))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		namedElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLNamedElement
	 *
	 * <!-- Start of user code doc for namedElement_compositeMetaProperties -->
	 * <!-- End of user code doc for namedElement_compositeMetaProperties -->
	 */
	def namedElement_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_compositeMetaProperties,
			Seq (NamedElement_nameExpression))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		namedElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLNamedElement
	 *
	 * <!-- Start of user code doc for namedElement_referenceMetaProperties -->
	 * <!-- End of user code doc for namedElement_referenceMetaProperties -->
	 */
	def namedElement_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLNamedElement
	 *
	 * <!-- Start of user code doc for namedElement_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for namedElement_forwardReferencesFromMetamodelAssociations -->
	 */
	def namedElement_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLNamedElement
