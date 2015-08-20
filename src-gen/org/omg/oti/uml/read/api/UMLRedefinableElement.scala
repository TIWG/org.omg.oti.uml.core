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
import org.omg.oti.uml.read.operations.UMLRedefinableElementOps

// End of user code

/**
 * A RedefinableElement is an element that, when defined in the context of a Classifier, can be redefined more specifically or differently in the context of another Classifier that specializes (directly or indirectly) the context Classifier.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLRedefinableElement[Uml <: UML]
	extends UMLNamedElement[Uml]
	with UMLRedefinableElementOps[Uml] {
	
	import ops._

	/**
	 * Indicates whether it is possible to further redefine a RedefinableElement. If the value is true, then it is not possible to further redefine the RedefinableElement.
	 *
	 * <!-- Start of user code doc for isLeaf -->
   * <!-- End of user code doc for isLeaf -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isLeaf: Boolean

	/**
	 * The RedefinableElement that is being redefined by this element.
	 *
	 * <!-- Start of user code doc for redefinedElement -->
   * <!-- End of user code doc for redefinedElement -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.uml.read.api.UMLRedefinableElement.redefinedElement_redefinableElement
	 */
	def redefinedElement: Set[UMLRedefinableElement[Uml]]

	/**
	 * The contexts that this element may be redefined from.
	 *
	 * <!-- Start of user code doc for redefinitionContext -->
   * <!-- End of user code doc for redefinitionContext -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.uml.read.api.UMLClassifier.redefinitionContext_redefinableElement
	 */
	def redefinitionContext: Iterable[UMLClassifier[Uml]]

	/**
	 * <!-- Start of user code doc for redefinedElement_redefinableElement -->
   * <!-- End of user code doc for redefinedElement_redefinableElement -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.uml.read.api.UMLRedefinableElement.redefinedElement
	 */
	def redefinedElement_redefinableElement: Set[UMLRedefinableElement[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		redefinableElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLRedefinableElement
	 *
	 * <!-- Start of user code doc for redefinableElement_metaAttributes -->
   * <!-- End of user code doc for redefinableElement_metaAttributes -->
	 */
	def redefinableElement_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			namedElement_metaAttributes,
			Seq (RedefinableElement_isLeaf))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		redefinableElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLRedefinableElement
	 *
	 * <!-- Start of user code doc for redefinableElement_compositeMetaProperties -->
   * <!-- End of user code doc for redefinableElement_compositeMetaProperties -->
	 */
	def redefinableElement_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		redefinableElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLRedefinableElement
	 *
	 * <!-- Start of user code doc for redefinableElement_referenceMetaProperties -->
   * <!-- End of user code doc for redefinableElement_referenceMetaProperties -->
	 */
	def redefinableElement_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		redefinableElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLRedefinableElement
	 *
	 * <!-- Start of user code doc for redefinableElement_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for redefinableElement_forwardReferencesFromMetamodelAssociations -->
	 */
	def redefinableElement_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		Set ()

	// Start of user code for additional features
  // End of user code
} //UMLRedefinableElement
