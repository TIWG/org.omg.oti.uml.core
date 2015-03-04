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
 * An Actor specifies a role played by a user or any other system that interacts with the subject.
 * <!-- end-model-doc --> 
 */
trait UMLActor[Uml <: UML]
	extends UMLBehavioredClassifier[Uml]
	with UMLActorOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		actor_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActor
	 */
	def actor_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			behavioredClassifier_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		actor_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActor
	 */
	def actor_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavioredClassifier_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		actor_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActor
	 */
	def actor_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavioredClassifier_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		actor_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActor
	 */
	def actor_forwardReferencesFromMetamodelAssociations: Elements =
		behavioredClassifier_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLActor
