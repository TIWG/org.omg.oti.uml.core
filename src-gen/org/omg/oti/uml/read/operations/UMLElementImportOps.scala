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
import org.omg.oti.uml.xmi.IDGenerator
import scala.language.postfixOps
import scala.Boolean
import scala.{Option,None,Some}
import scala.Predef.String
import scala.collection.immutable.Set
import scalaz._, Scalaz._

// End of user code

/**
  * An ElementImport identifies a NamedElement in a Namespace other than the one that owns that NamedElement and allows the NamedElement to be referenced using an unqualified name in the Namespace owning the ElementImport.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLElementImportOps[Uml <: UML] { self: UMLElementImport[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Specifies the PackageableElement whose name is to be added to a Namespace.
    *
    * <!-- Start of user code doc for importedElement -->
    * <!-- End of user code doc for importedElement -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackageableElement.importedElement_import
    */
  def importedElement: Option[UMLPackageableElement[Uml]] = target.selectByKindOf { case x: UMLPackageableElement[Uml] => x } headOption

  /**
    * Specifies the Namespace that imports a PackageableElement from another Namespace.
    *
    * <!-- Start of user code doc for importingNamespace -->
    * <!-- End of user code doc for importingNamespace -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamespace.elementImport
    */
  def importingNamespace: Option[UMLNamespace[Uml]] = owner.selectByKindOf { case x: UMLNamespace[Uml] => x }

  /**
    * The query getName() returns the name under which the imported PackageableElement will be known in the importing namespace.
    *
    * <!-- Start of user code doc for getName -->
    * <!-- End of user code doc for getName -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (if alias->notEmpty() then
    *   alias
    * else
    *   importedElement.name
    * endif)
    * }}}
    */
  def getName: Option[String] = {
    // Start of user code for "getName"
    if (alias.isDefined)
      alias
    else importedElement match {
      case Some(ie) => ie.name
      case None     => None
    }
    // End of user code
  }

  /**
    * An importedElement has either public visibility or no visibility at all.
    *
    * <!-- Start of user code doc for validate_imported_element_is_public -->
    * <!-- End of user code doc for validate_imported_element_is_public -->
    *
    * {{{
    * OCL Body importedElement.visibility <> null implies importedElement.visibility = VisibilityKind::public
    * }}}
    */
  def validate_imported_element_is_public: Boolean = {
    // Start of user code for "imported_element_is_public"
    importedElement match {
      case Some(ie) => ie.visibility match {
        case Some(v) => v == UMLVisibilityKind.public
        case None    => false
      }
      case None     => true
    }
    // End of user code
  }

  /**
    * The visibility of an ElementImport is either public or private.
    *
    * <!-- Start of user code doc for validate_visibility_public_or_private -->
    * <!-- End of user code doc for validate_visibility_public_or_private -->
    *
    * {{{
    * OCL Body visibility = VisibilityKind::public or visibility = VisibilityKind::private
    * }}}
    */
  def validate_visibility_public_or_private: Boolean = {
    // Start of user code for "visibility_public_or_private"
    visibility.contains(UMLVisibilityKind.public) || visibility.contains(UMLVisibilityKind._private)
    // End of user code
  }

  // Start of user code for additional features

  /**
   * TIWG: see UMLUtil, Rule #3
   */
  override def xmiOrderingKey()(implicit idg: IDGenerator[Uml])
  : Set[java.lang.Throwable] \/ String =
	for {
		key <- element_xmiOrderingKey
		i <- importedElement.fold[Set[java.lang.Throwable] \/ String](
			"_".right
		){ ie =>
			ie.xmiOrderingKey.map("_" + _)
		}
	} yield key + i


  // End of user code
} //UMLElementImportOps
