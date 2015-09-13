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
import org.omg.oti._
import org.omg.oti.uml.read.operations.UMLChangeEventOps

// End of user code

/**
 * A ChangeEvent models a change in the system configuration that makes a condition true.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLChangeEvent[Uml <: UML]
	extends UMLEvent[Uml]
	with UMLChangeEventOps[Uml] {
	
	import ops._

	/**
	 * A Boolean-valued ValueSpecification that will result in a ChangeEvent whenever its value changes from false to true.
	 *
	 * <!-- Start of user code doc for changeExpression -->
   * <!-- End of user code doc for changeExpression -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.changeExpression_changeEvent
	 */
	def changeExpression: Option[UMLValueSpecification[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		changeEvent_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLChangeEvent
	 *
	 * <!-- Start of user code doc for changeEvent_metaAttributes -->
   * <!-- End of user code doc for changeEvent_metaAttributes -->
	 */
	def changeEvent_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			event_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		changeEvent_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLChangeEvent
	 *
	 * <!-- Start of user code doc for changeEvent_compositeMetaProperties -->
   * <!-- End of user code doc for changeEvent_compositeMetaProperties -->
	 */
	def changeEvent_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			event_compositeMetaProperties,
			Seq (ChangeEvent_changeExpression))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		changeEvent_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLChangeEvent
	 *
	 * <!-- Start of user code doc for changeEvent_referenceMetaProperties -->
   * <!-- End of user code doc for changeEvent_referenceMetaProperties -->
	 */
	def changeEvent_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			event_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		changeEvent_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLChangeEvent
	 *
	 * <!-- Start of user code doc for changeEvent_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for changeEvent_forwardReferencesFromMetamodelAssociations -->
	 */
	def changeEvent_forwardReferencesFromMetamodelAssociations: Elements =
		event_forwardReferencesFromMetamodelAssociations ++
		Set ()

	// Start of user code for additional features
  // End of user code
} //UMLChangeEvent
