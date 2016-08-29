/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLAssociationClassOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A model element that has both Association and Class properties. An AssociationClass can be seen as an Association that also has Class properties, or as a Class that also has Association properties. It not only connects a set of Classifiers but also defines a set of Features that belong to the Association itself and not to any of the associated Classifiers.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLAssociationClass[Uml <: UML]
  extends UMLAssociation[Uml]
	with UMLClass[Uml]
  with UMLAssociationClassOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      associationClass_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLAssociationClass
    *
    * <!-- Start of user code doc for associationClass_metaAttributes -->
    * <!-- End of user code doc for associationClass_metaAttributes -->
    */
  def associationClass_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     association_metaAttributes,
     class_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    associationClass_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLAssociationClass
    *
    * <!-- Start of user code doc for associationClass_compositeMetaProperties -->
    * <!-- End of user code doc for associationClass_compositeMetaProperties -->
    */
  def associationClass_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      association_compositeMetaProperties,
      class_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    associationClass_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLAssociationClass
    *
    * <!-- Start of user code doc for associationClass_referenceMetaProperties -->
    * <!-- End of user code doc for associationClass_referenceMetaProperties -->
    */
  def associationClass_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      association_referenceMetaProperties,
      class_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    associationClass_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLAssociationClass
    *
    * <!-- Start of user code doc for associationClass_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for associationClass_forwardReferencesFromMetamodelAssociations -->
    */
  def associationClass_forwardReferencesFromMetamodelAssociations: Elements =
    association_forwardReferencesFromMetamodelAssociations ++
    class_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLAssociationClass
