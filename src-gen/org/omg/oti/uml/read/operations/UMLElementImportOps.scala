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
package org.omg.oti.uml.read.operations

// Start of user code for imports

import org.omg.oti.uml.UMLError
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.xmi.IDGenerator
import scala.language.postfixOps
import scala.Boolean
import scala.{Option,None,Some}
import scala.Predef.String
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
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
  : NonEmptyList[java.lang.Throwable] \/ String =
	for {
		key <- element_xmiOrderingKey
		i <- importedElement.fold[NonEmptyList[java.lang.Throwable] \/ String](
			"_".right
		){ ie =>
			ie.xmiOrderingKey.map("_" + _)
		}
	} yield key + i


  // End of user code
} //UMLElementImportOps
