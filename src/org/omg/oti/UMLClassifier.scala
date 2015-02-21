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
package org.omg.oti

trait UMLClassifier[Uml <: UML] extends UMLNamespace[Uml] with UMLType[Uml] with UMLRedefinableElement[Uml] {

  import ops._

  def isAbstract: Boolean = false
  def isFinalSpecialization: Boolean = false

  def attributes: Seq[UMLProperty[Uml]]

  def features: Set[UMLFeature[Uml]] = members.selectByKindOf { case f: UMLFeature[Uml] => f }

  def generalizations: Set[UMLGeneralization[Uml]] = ownedElements.selectByKindOf { case g: UMLGeneralization[Uml] => g }

  def general: Set[UMLClassifier[Uml]] = generalizations flatMap ( _.general )

  def instanceSpecifications: Set[UMLInstanceSpecification[Uml]]

  def redefinedClassifiers: Iterable[UMLClassifier[Uml]] = redefinedElements.selectByKindOf { case cls: UMLClassifier[Uml] => cls }

  /**
   * Corresponds to 'classifier' in:
   * Classifier classifier --> redefinedClassifier Classifier
   */
  def redefiningClassifiers: Iterable[UMLClassifier[Uml]] = redefiningElements.selectByKindOf { case cls: UMLClassifier[Uml] => cls }

  /**
   * Fig 9.1 (incomplete)
   * - powertypeExtent
   * - useCase
   * - representation
   */
  def classifier_metaAttributes: MetaAttributeFunctions =
    ( ( namespace_metaAttributes /: List( redefinableElement_metaAttributes, type_metaAttributes ) ) ( appendUnique _ ) ) ++
      Seq(
        MetaAttributeBooleanFunction[UMLClassifier[Uml]]( None, "isAbstract", ( c ) => booleanToIterable( c.isAbstract, false ) ),
        MetaAttributeBooleanFunction[UMLClassifier[Uml]]( None, "isFinalSpecialization", ( c ) => booleanToIterable( c.isFinalSpecialization, false ) ) )

  def classifier_forwardReferencesFromMetamodelAssociations: Set[UMLElement[Uml]] =
    namespace_forwardReferencesFromMetamodelAssociations ++
      redefinableElement_forwardReferencesFromMetamodelAssociations ++
      type_forwardReferencesFromMetamodelAssociations ++
      redefinedClassifiers

  def classifier_compositeMetaProperties: MetaPropertyFunctions =
    ( namespace_compositeMetaProperties /: List( redefinableElement_compositeMetaProperties, type_compositeMetaProperties ) ) ( appendUnique _ ) ++
      Seq( MetaPropertyCollection[UMLClassifier[Uml], UMLGeneralization[Uml]]( "generalization", _.generalizations ) )

  def classifier_referenceMetaProperties: MetaPropertyFunctions =
    (( namespace_referenceMetaProperties /: List( redefinableElement_referenceMetaProperties, type_referenceMetaProperties ) ) ( appendUnique _ )) ++
      Seq( MetaPropertyCollection[UMLClassifier[Uml], UMLClassifier[Uml]]( "redefinedClassifier", _.redefinedClassifiers ) )

}