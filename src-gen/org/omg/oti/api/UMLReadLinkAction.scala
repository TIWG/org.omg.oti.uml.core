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
 * A ReadLinkAction is a LinkAction that navigates across an Association to retrieve the objects on one end.
 * <!-- end-model-doc --> 
 */
trait UMLReadLinkAction[Uml <: UML]
	extends UMLLinkAction[Uml]
	with UMLReadLinkActionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The OutputPin on which the objects retrieved from the "open" end of those links whose values on other ends are given by the endData.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOutputPin.result_readLinkAction
	 */
	def result: Option[UMLOutputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		readLinkAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReadLinkAction
	 */
	def readLinkAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			linkAction_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		readLinkAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReadLinkAction
	 */
	def readLinkAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			linkAction_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLReadLinkAction[Uml], UMLOutputPin[Uml]]("result", _.result)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		readLinkAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReadLinkAction
	 */
	def readLinkAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			linkAction_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		readLinkAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReadLinkAction
	 */
	def readLinkAction_forwardReferencesFromMetamodelAssociations: Elements =
		linkAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLReadLinkAction
