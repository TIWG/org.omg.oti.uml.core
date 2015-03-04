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
 * A StartObjectBehaviorAction is an InvocationAction that starts the execution either of a directly instantiated Behavior or of the classifierBehavior of an object. Argument values may be supplied for the input Parameters of the Behavior. If the Behavior is invoked synchronously, then output values may be obtained for output Parameters.
 * <!-- end-model-doc --> 
 */
trait UMLStartObjectBehaviorAction[Uml <: UML]
	extends UMLCallAction[Uml]
	with UMLStartObjectBehaviorActionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * An InputPin that holds the object that is either a Behavior to be started or has a classifierBehavior to be started.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.object_startObjectBehaviorAction
	 */
	def _object: Option[UMLInputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		startObjectBehaviorAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStartObjectBehaviorAction
	 */
	def startObjectBehaviorAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			callAction_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		startObjectBehaviorAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStartObjectBehaviorAction
	 */
	def startObjectBehaviorAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			callAction_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLStartObjectBehaviorAction[Uml], UMLInputPin[Uml]]("object", _._object)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		startObjectBehaviorAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStartObjectBehaviorAction
	 */
	def startObjectBehaviorAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			callAction_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		startObjectBehaviorAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStartObjectBehaviorAction
	 */
	def startObjectBehaviorAction_forwardReferencesFromMetamodelAssociations: Elements =
		callAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLStartObjectBehaviorAction
