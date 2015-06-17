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
 * A Namespace is an Element in a model that owns and/or imports a set of NamedElements that can be identified by name.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLNamespace[Uml <: UML]
	extends UMLNamedElement[Uml]
	with UMLNamespaceOps[Uml] {
	
	import ops._

	/**
	 * A collection of NamedElements identifiable within the Namespace, either by being owned or by being introduced by importing or inheritance.
	 *
	 * <!-- Start of user code doc for member -->
	 * <!-- End of user code doc for member -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLNamedElement.member_memberNamespace
	 */
	def member: Set[UMLNamedElement[Uml]]

	/**
	 * A collection of NamedElements owned by the Namespace.
	 *
	 * <!-- Start of user code doc for ownedMember -->
	 * <!-- End of user code doc for ownedMember -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLNamedElement.namespace
	 */
	def ownedMember: Set[UMLNamedElement[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		namespace_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLNamespace
	 *
	 * <!-- Start of user code doc for namespace_metaAttributes -->
	 * <!-- End of user code doc for namespace_metaAttributes -->
	 */
	def namespace_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			namedElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		namespace_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLNamespace
	 *
	 * <!-- Start of user code doc for namespace_compositeMetaProperties -->
	 * <!-- End of user code doc for namespace_compositeMetaProperties -->
	 */
	def namespace_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_compositeMetaProperties,
			Seq (Namespace_elementImport,
				Namespace_ownedRule,
				Namespace_packageImport))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		namespace_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLNamespace
	 *
	 * <!-- Start of user code doc for namespace_referenceMetaProperties -->
	 * <!-- End of user code doc for namespace_referenceMetaProperties -->
	 */
	def namespace_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		namespace_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLNamespace
	 *
	 * <!-- Start of user code doc for namespace_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for namespace_forwardReferencesFromMetamodelAssociations -->
	 */
	def namespace_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLNamespace
