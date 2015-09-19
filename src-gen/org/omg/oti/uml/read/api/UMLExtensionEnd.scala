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
import org.omg.oti.uml.read.operations.UMLExtensionEndOps

import scala.Boolean
import scala.Option
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * An extension end is used to tie an extension to a stereotype when extending a metaclass.The default multiplicity of an extension end is 0..1.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLExtensionEnd[Uml <: UML]
	extends UMLProperty[Uml]
	with UMLExtensionEndOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * References the type of the ExtensionEnd. Note that this association restricts the possible types of an ExtensionEnd to only be Stereotypes.
	 *
	 * <!-- Start of user code doc for _type -->
   * <!-- End of user code doc for _type -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLStereotype.type_extensionEnd
	 */
	override def _type: Option[UMLStereotype[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		extensionEnd_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExtensionEnd
	 *
	 * <!-- Start of user code doc for extensionEnd_metaAttributes -->
   * <!-- End of user code doc for extensionEnd_metaAttributes -->
	 */
	def extensionEnd_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			property_metaAttributes,
			Seq[MetaAttributeFunction]())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		extensionEnd_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExtensionEnd
	 *
	 * <!-- Start of user code doc for extensionEnd_compositeMetaProperties -->
   * <!-- End of user code doc for extensionEnd_compositeMetaProperties -->
	 */
	def extensionEnd_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			property_compositeMetaProperties,
			Seq[MetaPropertyEvaluator]())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		extensionEnd_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExtensionEnd
	 *
	 * <!-- Start of user code doc for extensionEnd_referenceMetaProperties -->
   * <!-- End of user code doc for extensionEnd_referenceMetaProperties -->
	 */
	def extensionEnd_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			property_referenceMetaProperties,
			Seq[MetaPropertyEvaluator](ExtensionEnd_type))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		extensionEnd_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExtensionEnd
	 *
	 * <!-- Start of user code doc for extensionEnd_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for extensionEnd_forwardReferencesFromMetamodelAssociations -->
	 */
	def extensionEnd_forwardReferencesFromMetamodelAssociations: Elements =
		property_forwardReferencesFromMetamodelAssociations ++
		_type

	// Start of user code for additional features
  // End of user code
} //UMLExtensionEnd
