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
 * A ReduceAction is an Action that reduces a collection to a single value by repeatedly combining the elements of the collection using a reducer Behavior.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLReduceAction[Uml <: UML]
	extends UMLAction[Uml]
	with UMLReduceActionOps[Uml] {
	
	import ops._

	/**
	 * The InputPin that provides the collection to be reduced.
	 *
	 * <!-- Start of user code doc for collection -->
	 * <!-- End of user code doc for collection -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.collection_reduceAction
	 */
	def collection: Option[UMLInputPin[Uml]]

	/**
	 * Indicates whether the order of the input collection should determine the order in which the reducer Behavior is applied to its elements.
	 *
	 * <!-- Start of user code doc for isOrdered -->
	 * <!-- End of user code doc for isOrdered -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isOrdered: Boolean

	/**
	 * A Behavior that is repreatedly applied to two elements of the input collection to produce a value that is of the same type as elements of the collection.
	 *
	 * <!-- Start of user code doc for reducer -->
	 * <!-- End of user code doc for reducer -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLBehavior.reducer_reduceAction
	 */
	def reducer: Option[UMLBehavior[Uml]]

	/**
	 * The output pin on which the result value is placed.
	 *
	 * <!-- Start of user code doc for result -->
	 * <!-- End of user code doc for result -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOutputPin.result_reduceAction
	 */
	def result: Option[UMLOutputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		reduceAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReduceAction
	 *
	 * <!-- Start of user code doc for reduceAction_metaAttributes -->
	 * <!-- End of user code doc for reduceAction_metaAttributes -->
	 */
	def reduceAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			action_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLReduceAction[Uml]](None, "isOrdered", (x) => booleanToIterable(x.isOrdered, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		reduceAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReduceAction
	 *
	 * <!-- Start of user code doc for reduceAction_compositeMetaProperties -->
	 * <!-- End of user code doc for reduceAction_compositeMetaProperties -->
	 */
	def reduceAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLReduceAction[Uml], UMLInputPin[Uml]]("collection", _.collection),
				MetaPropertyReference[Uml, UMLReduceAction[Uml], UMLOutputPin[Uml]]("result", _.result)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		reduceAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReduceAction
	 *
	 * <!-- Start of user code doc for reduceAction_referenceMetaProperties -->
	 * <!-- End of user code doc for reduceAction_referenceMetaProperties -->
	 */
	def reduceAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLReduceAction[Uml], UMLBehavior[Uml]]("reducer", _.reducer)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		reduceAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReduceAction
	 *
	 * <!-- Start of user code doc for reduceAction_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for reduceAction_forwardReferencesFromMetamodelAssociations -->
	 */
	def reduceAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		reducer 

	// Start of user code for additional features
	// End of user code
} //UMLReduceAction
