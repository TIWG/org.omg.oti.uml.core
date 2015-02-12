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

import scala.language.postfixOps

trait UMLPackage[Uml <: UML] extends UMLNamespace[Uml] with UMLPackageableElement[Uml] with UMLPackageOps[Uml] {

  import ops._

  def URI: Option[String]
  def nestingPackage: Option[UMLPackage[Uml]] = owningPackage
  def packagedElements: Set[UMLPackageableElement[Uml]] = ownedMembers.selectByKindOf { case pe: UMLPackageableElement[Uml] => pe }
  
  /**
   * @see UML 2.5, 12.4, Package
   * nestedPackage() : Package [0..*] 
   * Derivation for Package::/nestedPackage
   * 
   * body: packagedElement->select(oclIsKindOf(Package))->collect(oclAsType(Package))->asSet()
   */
  def ownedTypes: Set[UMLType[Uml]] = packagedElements.selectByKindOf { case t: UMLType[Uml] => t }
  
  /**
   * @see UML 2.5, 12.4, Package
   * ownedStereotype() : Stereotype [0..*] 
   * Derivation for Package::/ownedStereotype
   * 
   * body: packagedElement->select(oclIsKindOf(Stereotype))->collect(oclAsType(Stereotype))->asSet()
   */
  def ownedStereotypes: Set[UMLStereotype[Uml]] = ownedTypes.selectByKindOf { case s: UMLStereotype[Uml] => s }
  
  /**
   * @see UML 2.5, 12.4, Package
   * nestedPackage() : Package [0..*] 
   * Derivation for Package::/nestedPackage
   * 
   * body: packagedElement->select(oclIsKindOf(Package))->collect(oclAsType(Package))->asSet()
   */
  def nestedPackages: Set[UMLPackage[Uml]] = packagedElements.selectByKindOf { case p: UMLPackage[Uml] => p }
  def packageMerges: Set[UMLPackageMerge[Uml]] = ownedElements.selectByKindOf { case pm: UMLPackageMerge[Uml] => pm }
  def profileApplications: Set[UMLProfileApplication[Uml]] = directedRelationships_source.selectByKindOf { case pa: UMLProfileApplication[Uml] => pa }

  /**
   * Fig 12.1 (incomplete)
   * - TemplateableElement
   */
  override def metaAttributes: MetaAttributeFunctions =
    package_metaAttributes

  // [protected (oti)]
  def package_metaAttributes: MetaAttributeFunctions =
    appendUnique( namespace_metaAttributes, packageableElement_metaAttributes ) ++
      Seq( MetaAttributeStringFunction[UMLPackage[Uml]]( None, "URI", _.getEffectiveURI ) )
  // [/protected]

  override def forwardReferencesFromMetamodelAssociations =
    package_forwardReferencesFromMetamodelAssociations

  def package_forwardReferencesFromMetamodelAssociations =
    namespace_forwardReferencesFromMetamodelAssociations ++
      packageableElement_forwardReferencesFromMetamodelAssociations

  override def compositeMetaProperties: MetaPropertyFunctions =
    package_compositeMetaProperties

  def package_compositeMetaProperties: MetaPropertyFunctions =
    appendUnique( namespace_compositeMetaProperties, packageableElement_compositeMetaProperties ) ++
      Seq(
        MetaPropertyCollection[UMLPackage[Uml], UMLPackageableElement[Uml]]( "packagedElement", _.packagedElements ),
        MetaPropertyCollection[UMLPackage[Uml], UMLPackageMerge[Uml]]( "packageMerge", _.packageMerges ),
        MetaPropertyCollection[UMLPackage[Uml], UMLProfileApplication[Uml]]( "profileApplication", _.profileApplications ) )

  override def referenceMetaProperties: MetaPropertyFunctions =
    package_referenceMetaProperties

  def package_referenceMetaProperties =
    appendUnique( namedElement_referenceMetaProperties, packageableElement_referenceMetaProperties )

  def applyingPackageOfProfileApplications: Set[UMLProfileApplication[Uml]] = directedRelationships_source.selectByKindOf { case pa: UMLProfileApplication[Uml] => pa }

}