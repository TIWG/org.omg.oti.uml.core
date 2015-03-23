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
 * LinkEndDestructionData is LinkEndData used to provide values for one end of a link to be destroyed by a DestroyLinkAction.
 * <!-- end-model-doc -->
 */
trait UMLLinkEndDestructionData[Uml <: UML]
	extends UMLLinkEndData[Uml]
	with UMLLinkEndDestructionDataOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The InputPin that provides the position of an existing link to be destroyed in an ordered, nonunique Association end. The type of the destroyAt InputPin is UnlimitedNatural, but the value cannot be zero or unlimited.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInputPin.destroyAt_linkEndDestructionData
	 */
	def destroyAt: Option[UMLInputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies whether to destroy duplicates of the value in nonunique Association ends.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isDestroyDuplicates: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLDestroyLinkAction.endData
	 */
	def endData_destroyLinkAction: Option[UMLDestroyLinkAction[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		linkEndDestructionData_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLinkEndDestructionData
	 */
	def linkEndDestructionData_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			linkEndData_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLLinkEndDestructionData[Uml]](None, "isDestroyDuplicates", (x) => booleanToIterable(x.isDestroyDuplicates, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		linkEndDestructionData_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLinkEndDestructionData
	 */
	def linkEndDestructionData_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			linkEndData_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		linkEndDestructionData_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLinkEndDestructionData
	 */
	def linkEndDestructionData_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			linkEndData_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLLinkEndDestructionData[Uml], UMLInputPin[Uml]]("destroyAt", _.destroyAt)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		linkEndDestructionData_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLinkEndDestructionData
	 */
	def linkEndDestructionData_forwardReferencesFromMetamodelAssociations: Elements =
		linkEndData_forwardReferencesFromMetamodelAssociations ++
		destroyAt 

} //UMLLinkEndDestructionData
