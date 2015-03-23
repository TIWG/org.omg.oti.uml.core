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
 * A RemoveVariableValueAction is a WriteVariableAction that removes values from a Variables.
 * <!-- end-model-doc -->
 */
trait UMLRemoveVariableValueAction[Uml <: UML]
	extends UMLWriteVariableAction[Uml]
	with UMLRemoveVariableValueActionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * Specifies whether to remove duplicates of the value in nonunique Variables.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isRemoveDuplicates: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * An InputPin that provides the position of an existing value to remove in ordered, nonunique Variables. The type of the removeAt InputPin is UnlimitedNatural, but the value cannot be zero or unlimited.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInputPin.removeAt_removeVariableValueAction
	 */
	def removeAt: Option[UMLInputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		removeVariableValueAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLRemoveVariableValueAction
	 */
	def removeVariableValueAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			writeVariableAction_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLRemoveVariableValueAction[Uml]](None, "isRemoveDuplicates", (x) => booleanToIterable(x.isRemoveDuplicates, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		removeVariableValueAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLRemoveVariableValueAction
	 */
	def removeVariableValueAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			writeVariableAction_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLRemoveVariableValueAction[Uml], UMLInputPin[Uml]]("removeAt", _.removeAt)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		removeVariableValueAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLRemoveVariableValueAction
	 */
	def removeVariableValueAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			writeVariableAction_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		removeVariableValueAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLRemoveVariableValueAction
	 */
	def removeVariableValueAction_forwardReferencesFromMetamodelAssociations: Elements =
		writeVariableAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLRemoveVariableValueAction
