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
import org.omg.oti.uml.read.operations.UMLTimeConstraintOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * A TimeConstraint is a Constraint that refers to a TimeInterval.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLTimeConstraint[Uml <: UML]
	extends UMLIntervalConstraint[Uml]
	with UMLTimeConstraintOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * The value of firstEvent is related to the constrainedElement. If firstEvent is true, then the corresponding observation event is the first time instant the execution enters the constrainedElement. If firstEvent is false, then the corresponding observation event is the last time instant the execution is within the constrainedElement.
	 *
	 * <!-- Start of user code doc for firstEvent -->
   * <!-- End of user code doc for firstEvent -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def firstEvent: Option[Boolean]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		timeConstraint_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTimeConstraint
	 *
	 * <!-- Start of user code doc for timeConstraint_metaAttributes -->
   * <!-- End of user code doc for timeConstraint_metaAttributes -->
	 */
	def timeConstraint_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			intervalConstraint_metaAttributes,
			Seq (TimeConstraint_firstEvent))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		timeConstraint_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTimeConstraint
	 *
	 * <!-- Start of user code doc for timeConstraint_compositeMetaProperties -->
   * <!-- End of user code doc for timeConstraint_compositeMetaProperties -->
	 */
	def timeConstraint_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			intervalConstraint_compositeMetaProperties,
			Seq (TimeConstraint_specification))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		timeConstraint_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTimeConstraint
	 *
	 * <!-- Start of user code doc for timeConstraint_referenceMetaProperties -->
   * <!-- End of user code doc for timeConstraint_referenceMetaProperties -->
	 */
	def timeConstraint_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			intervalConstraint_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		timeConstraint_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTimeConstraint
	 *
	 * <!-- Start of user code doc for timeConstraint_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for timeConstraint_forwardReferencesFromMetamodelAssociations -->
	 */
	def timeConstraint_forwardReferencesFromMetamodelAssociations: Elements =
		intervalConstraint_forwardReferencesFromMetamodelAssociations ++
		Set ()

	// Start of user code for additional features
  // End of user code
} //UMLTimeConstraint
