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
 * <!-- begin-model-doc --> 
 * An InteractionUse refers to an Interaction. The InteractionUse is a shorthand for copying the contents of the referenced Interaction where the InteractionUse is. To be accurate the copying must take into account substituting parameters with arguments and connect the formal Gates with the actual ones.
 * <!-- end-model-doc --> 
 */
trait UMLInteractionUse[Uml <: UML]
	extends UMLInteractionFragment[Uml]
	with UMLInteractionUseOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The actual gates of the InteractionUse.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLGate.actualGate_interactionUse
	 */
	def actualGate: Set[UMLGate[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The actual arguments of the Interaction.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLValueSpecification.argument_interactionUse
	 */
	def argument: Seq[UMLValueSpecification[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Refers to the Interaction that defines its meaning.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInteraction.refersTo_interactionUse
	 */
	def refersTo: Option[UMLInteraction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The value of the executed Interaction.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecification.returnValue_interactionUse
	 */
	def returnValue: Option[UMLValueSpecification[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The recipient of the return value.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProperty.returnValueRecipient_interactionUse
	 */
	def returnValueRecipient: Option[UMLProperty[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interactionUse_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInteractionUse
	 */
	def interactionUse_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			interactionFragment_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interactionUse_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInteractionUse
	 */
	def interactionUse_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			interactionFragment_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLInteractionUse[Uml], UMLGate[Uml]]("actualGate", _.actualGate),
				MetaPropertyCollection[Uml, UMLInteractionUse[Uml], UMLValueSpecification[Uml]]("argument", _.argument),
				MetaPropertyReference[Uml, UMLInteractionUse[Uml], UMLValueSpecification[Uml]]("returnValue", _.returnValue)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interactionUse_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInteractionUse
	 */
	def interactionUse_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			interactionFragment_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLInteractionUse[Uml], UMLInteraction[Uml]]("refersTo", _.refersTo),
				MetaPropertyReference[Uml, UMLInteractionUse[Uml], UMLProperty[Uml]]("returnValueRecipient", _.returnValueRecipient)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interactionUse_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInteractionUse
	 */
	def interactionUse_forwardReferencesFromMetamodelAssociations: Elements =
		interactionFragment_forwardReferencesFromMetamodelAssociations ++
		refersTo ++
		returnValueRecipient 

} //UMLInteractionUse
