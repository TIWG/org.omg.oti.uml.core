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
 * An InteractionUse refers to an Interaction. The InteractionUse is a shorthand for copying the contents of the referenced Interaction where the InteractionUse is. To be accurate the copying must take into account substituting parameters with arguments and connect the formal Gates with the actual ones.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLInteractionUse[Uml <: UML]
	extends UMLInteractionFragment[Uml]
	with UMLInteractionUseOps[Uml] {
	
	import ops._

	/**
	 * The actual gates of the InteractionUse.
	 *
	 * <!-- Start of user code doc for actualGate -->
	 * <!-- End of user code doc for actualGate -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLGate.actualGate_interactionUse
	 */
	def actualGate: Set[UMLGate[Uml]]

	/**
	 * The actual arguments of the Interaction.
	 *
	 * <!-- Start of user code doc for argument -->
	 * <!-- End of user code doc for argument -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLValueSpecification.argument_interactionUse
	 */
	def argument: Seq[UMLValueSpecification[Uml]]

	/**
	 * Refers to the Interaction that defines its meaning.
	 *
	 * <!-- Start of user code doc for refersTo -->
	 * <!-- End of user code doc for refersTo -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInteraction.refersTo_interactionUse
	 */
	def refersTo: Option[UMLInteraction[Uml]]

	/**
	 * The value of the executed Interaction.
	 *
	 * <!-- Start of user code doc for returnValue -->
	 * <!-- End of user code doc for returnValue -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecification.returnValue_interactionUse
	 */
	def returnValue: Option[UMLValueSpecification[Uml]]

	/**
	 * The recipient of the return value.
	 *
	 * <!-- Start of user code doc for returnValueRecipient -->
	 * <!-- End of user code doc for returnValueRecipient -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProperty.returnValueRecipient_interactionUse
	 */
	def returnValueRecipient: Option[UMLProperty[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interactionUse_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInteractionUse
	 *
	 * <!-- Start of user code doc for interactionUse_metaAttributes -->
	 * <!-- End of user code doc for interactionUse_metaAttributes -->
	 */
	def interactionUse_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			interactionFragment_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interactionUse_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInteractionUse
	 *
	 * <!-- Start of user code doc for interactionUse_compositeMetaProperties -->
	 * <!-- End of user code doc for interactionUse_compositeMetaProperties -->
	 */
	def interactionUse_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			interactionFragment_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLInteractionUse[Uml], UMLGate[Uml]]("actualGate", _.actualGate),
				MetaPropertyCollection[Uml, UMLInteractionUse[Uml], UMLValueSpecification[Uml]]("argument", _.argument),
				MetaPropertyReference[Uml, UMLInteractionUse[Uml], UMLValueSpecification[Uml]]("returnValue", _.returnValue)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interactionUse_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInteractionUse
	 *
	 * <!-- Start of user code doc for interactionUse_referenceMetaProperties -->
	 * <!-- End of user code doc for interactionUse_referenceMetaProperties -->
	 */
	def interactionUse_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			interactionFragment_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLInteractionUse[Uml], UMLInteraction[Uml]]("refersTo", _.refersTo),
				MetaPropertyReference[Uml, UMLInteractionUse[Uml], UMLProperty[Uml]]("returnValueRecipient", _.returnValueRecipient)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interactionUse_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInteractionUse
	 *
	 * <!-- Start of user code doc for interactionUse_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for interactionUse_forwardReferencesFromMetamodelAssociations -->
	 */
	def interactionUse_forwardReferencesFromMetamodelAssociations: Elements =
		interactionFragment_forwardReferencesFromMetamodelAssociations ++
		refersTo ++
		returnValueRecipient 

	// Start of user code for additional features
	// End of user code
} //UMLInteractionUse
