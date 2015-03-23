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
 * An ExecutionOccurrenceSpecification represents moments in time at which Actions or Behaviors start or finish.
 * <!-- end-model-doc -->
 */
trait UMLExecutionOccurrenceSpecification[Uml <: UML]
	extends UMLOccurrenceSpecification[Uml]
	with UMLExecutionOccurrenceSpecificationOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * References the execution specification describing the execution that is started or finished at this execution event.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLExecutionSpecification.execution_executionOccurrenceSpecification
	 */
	def execution: Option[UMLExecutionSpecification[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		executionOccurrenceSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExecutionOccurrenceSpecification
	 */
	def executionOccurrenceSpecification_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			occurrenceSpecification_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		executionOccurrenceSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExecutionOccurrenceSpecification
	 */
	def executionOccurrenceSpecification_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			occurrenceSpecification_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		executionOccurrenceSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExecutionOccurrenceSpecification
	 */
	def executionOccurrenceSpecification_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			occurrenceSpecification_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLExecutionOccurrenceSpecification[Uml], UMLExecutionSpecification[Uml]]("execution", _.execution)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		executionOccurrenceSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExecutionOccurrenceSpecification
	 */
	def executionOccurrenceSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		occurrenceSpecification_forwardReferencesFromMetamodelAssociations ++
		execution 

} //UMLExecutionOccurrenceSpecification
