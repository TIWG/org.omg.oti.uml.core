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

package org.omg.oti.uml.read.operations

// Start of user code for imports

import org.omg.oti.uml.read.api._
import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scalaz._, Scalaz._

// End of user code

/**
  * A PackageableElement is a NamedElement that may be owned directly by a Package. A PackageableElement is also able to serve as the parameteredElement of a TemplateParameter.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPackageableElementOps[Uml <: UML] { self: UMLPackageableElement[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for importedElement_import -->
    * <!-- End of user code doc for importedElement_import -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLElementImport.importedElement
    */
  def importedElement_import: Set[UMLElementImport[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLElementImport[Uml] => x }

  /**
    * <!-- Start of user code doc for packagedElement_component -->
    * <!-- End of user code doc for packagedElement_component -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLComponent.packagedElement
    */
  def packagedElement_component: Option[UMLComponent[Uml]] = namespace.selectByKindOf { case x: UMLComponent[Uml] => x }

  /**
    * <!-- Start of user code doc for packagedElement_owningPackage -->
    * <!-- End of user code doc for packagedElement_owningPackage -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackage.packagedElement
    */
  def packagedElement_owningPackage: Option[UMLPackage[Uml]] = namespace.selectByKindOf { case x: UMLPackage[Uml] => x }

  /**
    * A PackageableElement owned by a Namespace must have a visibility.
    *
    * <!-- Start of user code doc for validate_namespace_needs_visibility -->
    * <!-- End of user code doc for validate_namespace_needs_visibility -->
    *
    * {{{
    * OCL Body visibility = null implies namespace = null
    * }}}
    */
  def validate_namespace_needs_visibility: Boolean = {
    // Start of user code for "namespace_needs_visibility"
    if (visibility.isEmpty) {
      namespace.isEmpty 
    } else 
      true  
    // End of user code
  }

  // Start of user code for additional features

  override def asForwardReferencesToImportableOuterPackageableElements
  : Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]]
  = Set( this ).right

  override def asForwardReferencesToOwningElementImportableOuterPackageableElements
  : Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]]
  = Set( this ).right

  // End of user code
} //UMLPackageableElementOps
