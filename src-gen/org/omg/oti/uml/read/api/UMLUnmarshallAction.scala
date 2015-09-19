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
import org.omg.oti.uml.read.operations.UMLUnmarshallActionOps

import scala.Boolean
import scala.Option
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * An UnmarshallAction is an Action that retrieves the values of the StructuralFeatures of an object and places them on OutputPins. 
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLUnmarshallAction[Uml <: UML]
	extends UMLAction[Uml]
	with UMLUnmarshallActionOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * The OutputPins on which are placed the values of the StructuralFeatures of the input object.
	 *
	 * <!-- Start of user code doc for result -->
   * <!-- End of user code doc for result -->
	 *
	 * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="1..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_unmarshallAction
	 */
	def result: Seq[UMLOutputPin[Uml]]

	/**
	 * The type of the object to be unmarshalled.
	 *
	 * <!-- Start of user code doc for unmarshallType -->
   * <!-- End of user code doc for unmarshallType -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.unmarshallType_unmarshallAction
	 */
	def unmarshallType: Option[UMLClassifier[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		unmarshallAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLUnmarshallAction
	 *
	 * <!-- Start of user code doc for unmarshallAction_metaAttributes -->
   * <!-- End of user code doc for unmarshallAction_metaAttributes -->
	 */
	def unmarshallAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			action_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		unmarshallAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLUnmarshallAction
	 *
	 * <!-- Start of user code doc for unmarshallAction_compositeMetaProperties -->
   * <!-- End of user code doc for unmarshallAction_compositeMetaProperties -->
	 */
	def unmarshallAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_compositeMetaProperties,
			Seq (UnmarshallAction_object,
				UnmarshallAction_result))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		unmarshallAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLUnmarshallAction
	 *
	 * <!-- Start of user code doc for unmarshallAction_referenceMetaProperties -->
   * <!-- End of user code doc for unmarshallAction_referenceMetaProperties -->
	 */
	def unmarshallAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_referenceMetaProperties,
			Seq (UnmarshallAction_unmarshallType))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		unmarshallAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLUnmarshallAction
	 *
	 * <!-- Start of user code doc for unmarshallAction_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for unmarshallAction_forwardReferencesFromMetamodelAssociations -->
	 */
	def unmarshallAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		unmarshallType

	// Start of user code for additional features
  // End of user code
} //UMLUnmarshallAction
