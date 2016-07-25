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
import org.omg.oti.uml.read.operations.UMLTimeObservationOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A TimeObservation is a reference to a time instant during an execution. It points out the NamedElement in the model to observe and whether the observation is when this NamedElement is entered or when it is exited.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTimeObservation[Uml <: UML]
  extends UMLObservation[Uml]
  with UMLTimeObservationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The TimeObservation is determined by the entering or exiting of the event Element during execution.
    *
    * <!-- Start of user code doc for event -->
    * <!-- End of user code doc for event -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamedElement.event_timeObservation
    */
  def event: Option[UMLNamedElement[Uml]]

  /**
    * The value of firstEvent is related to the event. If firstEvent is true, then the corresponding observation event is the first time instant the execution enters the event Element. If firstEvent is false, then the corresponding observation event is the time instant the execution exits the event Element.
    *
    * <!-- Start of user code doc for firstEvent -->
    * <!-- End of user code doc for firstEvent -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def firstEvent: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      timeObservation_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLTimeObservation
    *
    * <!-- Start of user code doc for timeObservation_metaAttributes -->
    * <!-- End of user code doc for timeObservation_metaAttributes -->
    */
  def timeObservation_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     observation_metaAttributes,
     Seq[MetaAttributeFunction](TimeObservation_firstEvent))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    timeObservation_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLTimeObservation
    *
    * <!-- Start of user code doc for timeObservation_compositeMetaProperties -->
    * <!-- End of user code doc for timeObservation_compositeMetaProperties -->
    */
  def timeObservation_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      observation_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    timeObservation_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLTimeObservation
    *
    * <!-- Start of user code doc for timeObservation_referenceMetaProperties -->
    * <!-- End of user code doc for timeObservation_referenceMetaProperties -->
    */
  def timeObservation_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      observation_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](TimeObservation_event))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    timeObservation_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLTimeObservation
    *
    * <!-- Start of user code doc for timeObservation_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for timeObservation_forwardReferencesFromMetamodelAssociations -->
    */
  def timeObservation_forwardReferencesFromMetamodelAssociations: Elements =
    observation_forwardReferencesFromMetamodelAssociations ++
    event

  // Start of user code for additional features
  // End of user code
} //UMLTimeObservation
