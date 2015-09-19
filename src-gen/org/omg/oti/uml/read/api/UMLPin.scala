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
import org.omg.oti.uml.read.operations.UMLPinOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * A Pin is an ObjectNode and MultiplicityElement that provides input values to an Action or accepts output values from an Action.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLPin[Uml <: UML]
	extends UMLMultiplicityElement[Uml]
	with UMLObjectNode[Uml]
	with UMLPinOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * Indicates whether the Pin provides data to the Action or just controls how the Action executes.
	 *
	 * <!-- Start of user code doc for isControl -->
   * <!-- End of user code doc for isControl -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isControl: Boolean

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		pin_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPin
	 *
	 * <!-- Start of user code doc for pin_metaAttributes -->
   * <!-- End of user code doc for pin_metaAttributes -->
	 */
	def pin_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			multiplicityElement_metaAttributes,
			objectNode_metaAttributes,
			Seq[MetaAttributeFunction](Pin_isControl))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		pin_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPin
	 *
	 * <!-- Start of user code doc for pin_compositeMetaProperties -->
   * <!-- End of user code doc for pin_compositeMetaProperties -->
	 */
	def pin_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			multiplicityElement_compositeMetaProperties,
			objectNode_compositeMetaProperties,
			Seq[MetaPropertyEvaluator]())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		pin_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPin
	 *
	 * <!-- Start of user code doc for pin_referenceMetaProperties -->
   * <!-- End of user code doc for pin_referenceMetaProperties -->
	 */
	def pin_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			multiplicityElement_referenceMetaProperties,
			objectNode_referenceMetaProperties,
			Seq[MetaPropertyEvaluator]())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		pin_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPin
	 *
	 * <!-- Start of user code doc for pin_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for pin_forwardReferencesFromMetamodelAssociations -->
	 */
	def pin_forwardReferencesFromMetamodelAssociations: Elements =
		multiplicityElement_forwardReferencesFromMetamodelAssociations ++
		objectNode_forwardReferencesFromMetamodelAssociations ++
		Set ()

	// Start of user code for additional features
  // End of user code
} //UMLPin
