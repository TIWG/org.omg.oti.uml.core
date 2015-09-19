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
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLNamedElementOps

import scala.Predef.String
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
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
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * The name of the NamedElement.
	 *
	 * <!-- Start of user code doc for name -->
   * <!-- End of user code doc for name -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def name: Option[String]

	/**
	 * Determines whether and how the NamedElement is visible outside its owning Namespace.
	 *
	 * <!-- Start of user code doc for visibility -->
   * <!-- End of user code doc for visibility -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def visibility: Option[UMLVisibilityKind.Value]

	/**
	 * <!-- Start of user code doc for event_durationObservation -->
   * <!-- End of user code doc for event_durationObservation -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLDurationObservation.event
	 */
	def event_durationObservation: Set[UMLDurationObservation[Uml]]

	/**
	 * <!-- Start of user code doc for event_timeObservation -->
   * <!-- End of user code doc for event_timeObservation -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLTimeObservation.event
	 */
	def event_timeObservation: Set[UMLTimeObservation[Uml]]

	/**
	 * <!-- Start of user code doc for member_memberNamespace -->
   * <!-- End of user code doc for member_memberNamespace -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLNamespace.member
	 */
	def member_memberNamespace: Set[UMLNamespace[Uml]]

	/**
	 * <!-- Start of user code doc for message_considerIgnoreFragment -->
   * <!-- End of user code doc for message_considerIgnoreFragment -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLConsiderIgnoreFragment.message
	 */
	def message_considerIgnoreFragment: Set[UMLConsiderIgnoreFragment[Uml]]

	/**
	 * <!-- Start of user code doc for signature_message -->
   * <!-- End of user code doc for signature_message -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLMessage.signature
	 */
	def signature_message: Set[UMLMessage[Uml]]

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
