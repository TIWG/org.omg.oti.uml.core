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
import org.omg.oti.uml.read.operations.UMLActionExecutionSpecificationOps

import scala.Boolean
import scala.Option
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * An ActionExecutionSpecification is a kind of ExecutionSpecification representing the execution of an Action.
 *
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
*/
trait UMLActionExecutionSpecification[Uml <: UML]
	extends UMLExecutionSpecification[Uml]
	with UMLActionExecutionSpecificationOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * Action whose execution is occurring.
	 *
	 * <!-- Start of user code doc for action -->
	 * <!-- End of user code doc for action -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLAction.action_actionExecutionSpecification
	 */
	def action: Option[UMLAction[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		actionExecutionSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActionExecutionSpecification
	 *
	 * <!-- Start of user code doc for actionExecutionSpecification_metaAttributes -->
	 * <!-- End of user code doc for actionExecutionSpecification_metaAttributes -->
	 */
	def actionExecutionSpecification_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			executionSpecification_metaAttributes,
			Seq[MetaAttributeFunction]())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		actionExecutionSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActionExecutionSpecification
	 *
	 * <!-- Start of user code doc for actionExecutionSpecification_compositeMetaProperties -->
	 * <!-- End of user code doc for actionExecutionSpecification_compositeMetaProperties -->
	 */
	def actionExecutionSpecification_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			executionSpecification_compositeMetaProperties,
			Seq[MetaPropertyEvaluator]())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		actionExecutionSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActionExecutionSpecification
	 *
	 * <!-- Start of user code doc for actionExecutionSpecification_referenceMetaProperties -->
	 * <!-- End of user code doc for actionExecutionSpecification_referenceMetaProperties -->
	 */
	def actionExecutionSpecification_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			executionSpecification_referenceMetaProperties,
			Seq[MetaPropertyEvaluator](ActionExecutionSpecification_action))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		actionExecutionSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActionExecutionSpecification
	 *
	 * <!-- Start of user code doc for actionExecutionSpecification_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for actionExecutionSpecification_forwardReferencesFromMetamodelAssociations -->
	 */
	def actionExecutionSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		executionSpecification_forwardReferencesFromMetamodelAssociations ++
		action

	// Start of user code for additional features
	// End of user code
} //UMLActionExecutionSpecification
