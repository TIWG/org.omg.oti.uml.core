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
import org.omg.oti.uml.read.operations.UMLInitialNodeOps

// End of user code

/**
 * An InitialNode is a ControlNode that offers a single control token when initially enabled.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLInitialNode[Uml <: UML]
	extends UMLControlNode[Uml]
	with UMLInitialNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		initialNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInitialNode
	 *
	 * <!-- Start of user code doc for initialNode_metaAttributes -->
	 * <!-- End of user code doc for initialNode_metaAttributes -->
	 */
	def initialNode_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			controlNode_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		initialNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInitialNode
	 *
	 * <!-- Start of user code doc for initialNode_compositeMetaProperties -->
	 * <!-- End of user code doc for initialNode_compositeMetaProperties -->
	 */
	def initialNode_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			controlNode_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		initialNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInitialNode
	 *
	 * <!-- Start of user code doc for initialNode_referenceMetaProperties -->
	 * <!-- End of user code doc for initialNode_referenceMetaProperties -->
	 */
	def initialNode_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			controlNode_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		initialNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInitialNode
	 *
	 * <!-- Start of user code doc for initialNode_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for initialNode_forwardReferencesFromMetamodelAssociations -->
	 */
	def initialNode_forwardReferencesFromMetamodelAssociations: Elements =
		controlNode_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLInitialNode
