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
package org.omg.oti.uml.read.operations

// Start of user code for imports

import org.omg.oti.uml.UMLError
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.xmi.IDGenerator
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.None
import scala.Some
import scala.Predef.String
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
import scalaz._, Scalaz._

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
	: NonEmptyList[java.lang.Throwable] \/ String =
	for {
		key <- element_xmiOrderingKey
		i <- importedPackage.fold[NonEmptyList[java.lang.Throwable] \/ String]("_".right){ ip =>
			ip.xmiOrderingKey.map("_" + _)
    }
	} yield key + i

  // End of user code
} //UMLPackageImportOps
