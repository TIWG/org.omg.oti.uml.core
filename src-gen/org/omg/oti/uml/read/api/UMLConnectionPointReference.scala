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
import org.omg.oti.uml.read.operations.UMLConnectionPointReferenceOps

// End of user code

/**
 * A ConnectionPointReference represents a usage (as part of a submachine State) of an entry/exit point Pseudostate defined in the StateMachine referenced by the submachine State.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLConnectionPointReference[Uml <: UML]
	extends UMLVertex[Uml]
	with UMLConnectionPointReferenceOps[Uml] {
	
	import ops._

	/**
	 * The entryPoint Pseudostates corresponding to this connection point.
	 *
	 * <!-- Start of user code doc for entry -->
   * <!-- End of user code doc for entry -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLPseudostate.entry_connectionPointReference
	 */
	def entry: Set[UMLPseudostate[Uml]]

	/**
	 * The exitPoints kind Pseudostates corresponding to this connection point.
	 *
	 * <!-- Start of user code doc for exit -->
   * <!-- End of user code doc for exit -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLPseudostate.exit_connectionPointReference
	 */
	def exit: Set[UMLPseudostate[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		connectionPointReference_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConnectionPointReference
	 *
	 * <!-- Start of user code doc for connectionPointReference_metaAttributes -->
   * <!-- End of user code doc for connectionPointReference_metaAttributes -->
	 */
	def connectionPointReference_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			vertex_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		connectionPointReference_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConnectionPointReference
	 *
	 * <!-- Start of user code doc for connectionPointReference_compositeMetaProperties -->
   * <!-- End of user code doc for connectionPointReference_compositeMetaProperties -->
	 */
	def connectionPointReference_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			vertex_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		connectionPointReference_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConnectionPointReference
	 *
	 * <!-- Start of user code doc for connectionPointReference_referenceMetaProperties -->
   * <!-- End of user code doc for connectionPointReference_referenceMetaProperties -->
	 */
	def connectionPointReference_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			vertex_referenceMetaProperties,
			Seq (ConnectionPointReference_entry,
				ConnectionPointReference_exit))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		connectionPointReference_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConnectionPointReference
	 *
	 * <!-- Start of user code doc for connectionPointReference_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for connectionPointReference_forwardReferencesFromMetamodelAssociations -->
	 */
	def connectionPointReference_forwardReferencesFromMetamodelAssociations: Elements =
		vertex_forwardReferencesFromMetamodelAssociations ++
		entry ++
		exit

	// Start of user code for additional features
  // End of user code
} //UMLConnectionPointReference
