/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
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
import org.omg.oti.uml.read.operations.UMLMessageOccurrenceSpecificationOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * A MessageOccurrenceSpecification specifies the occurrence of Message events, such as sending and receiving of Signals or invoking or receiving of Operation calls. A MessageOccurrenceSpecification is a kind of MessageEnd. Messages are generated either by synchronous Operation calls or asynchronous Signal sends. They are received by the execution of corresponding AcceptEventActions.
 *
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
*/
trait UMLMessageOccurrenceSpecification[Uml <: UML]
	extends UMLMessageEnd[Uml]
	with UMLOccurrenceSpecification[Uml]
	with UMLMessageOccurrenceSpecificationOps[Uml] {
	
  // Start of user code for class imports
  // End of user code

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		messageOccurrenceSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLMessageOccurrenceSpecification
	 *
	 * <!-- Start of user code doc for messageOccurrenceSpecification_metaAttributes -->
	 * <!-- End of user code doc for messageOccurrenceSpecification_metaAttributes -->
	 */
	def messageOccurrenceSpecification_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			messageEnd_metaAttributes,
			occurrenceSpecification_metaAttributes,
			Seq[MetaAttributeFunction]())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		messageOccurrenceSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLMessageOccurrenceSpecification
	 *
	 * <!-- Start of user code doc for messageOccurrenceSpecification_compositeMetaProperties -->
	 * <!-- End of user code doc for messageOccurrenceSpecification_compositeMetaProperties -->
	 */
	def messageOccurrenceSpecification_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			messageEnd_compositeMetaProperties,
			occurrenceSpecification_compositeMetaProperties,
			Seq[MetaPropertyEvaluator]())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		messageOccurrenceSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLMessageOccurrenceSpecification
	 *
	 * <!-- Start of user code doc for messageOccurrenceSpecification_referenceMetaProperties -->
	 * <!-- End of user code doc for messageOccurrenceSpecification_referenceMetaProperties -->
	 */
	def messageOccurrenceSpecification_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			messageEnd_referenceMetaProperties,
			occurrenceSpecification_referenceMetaProperties,
			Seq[MetaPropertyEvaluator]())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		messageOccurrenceSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLMessageOccurrenceSpecification
	 *
	 * <!-- Start of user code doc for messageOccurrenceSpecification_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for messageOccurrenceSpecification_forwardReferencesFromMetamodelAssociations -->
	 */
	def messageOccurrenceSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		messageEnd_forwardReferencesFromMetamodelAssociations ++
		occurrenceSpecification_forwardReferencesFromMetamodelAssociations ++
		Set ()

	// Start of user code for additional features
	// End of user code
} //UMLMessageOccurrenceSpecification
