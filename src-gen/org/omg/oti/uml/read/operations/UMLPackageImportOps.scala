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
import scala.{Boolean,Option}
import scala.Predef.String
import scala.collection.immutable.Set
import scalaz._
import scalaz.Scalaz._
// End of user code

/**
  * A PackageImport is a Relationship that imports all the non-private members of a Package into the Namespace owning the PackageImport, so that those Elements may be referred to by their unqualified names in the importingNamespace.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPackageImportOps[Uml <: UML] { self: UMLPackageImport[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Specifies the Package whose members are imported into a Namespace.
    *
    * <!-- Start of user code doc for importedPackage -->
    * <!-- End of user code doc for importedPackage -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackage.importedPackage_packageImport
    */
  def importedPackage: Option[UMLPackage[Uml]] = target.selectByKindOf { case x: UMLPackage[Uml] => x } headOption

  /**
    * Specifies the Namespace that imports the members from a Package.
    *
    * <!-- Start of user code doc for importingNamespace -->
    * <!-- End of user code doc for importingNamespace -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamespace.packageImport
    */
  def importingNamespace: Option[UMLNamespace[Uml]] = owner.selectByKindOf { case x: UMLNamespace[Uml] => x }

  /**
    * The visibility of a PackageImport is either public or private.
    *
    * <!-- Start of user code doc for validate_public_or_private -->
    * <!-- End of user code doc for validate_public_or_private -->
    *
    * {{{
    * OCL Body visibility = VisibilityKind::public or visibility = VisibilityKind::private
    * }}}
    */
  def validate_public_or_private: Boolean = {
    // Start of user code for "public_or_private"
    visibility.contains(UMLVisibilityKind.public) || visibility.contains(UMLVisibilityKind._private)
    // End of user code
  }

  // Start of user code for additional features

  /**
    * TIWG: see UMLUtil, Rule #3
    */
  override def xmiOrderingKey()(implicit idg: IDGenerator[Uml])
  : Set[java.lang.Throwable] \/ String
  = for {
		key <- element_xmiOrderingKey
		i <- importedPackage.fold[Set[java.lang.Throwable] \/ String]("_".right){ ip =>
			ip.xmiOrderingKey.map("_" + _)
    }
  } yield key + i

  // End of user code
} //UMLPackageImportOps
