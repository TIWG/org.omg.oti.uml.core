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
package org.omg.oti.operations

// Start of user code for imports
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * <!-- begin-model-doc -->
 * A PackageImport is a Relationship that imports all the non-private members of a Package into the Namespace owning the PackageImport, so that those Elements may be referred to by their unqualified names in the importingNamespace.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLPackageImportOps[Uml <: UML] { self: UMLPackageImport[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the Package whose members are imported into a Namespace.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLPackage.importedPackage_packageImport
	 */
	def importedPackage: Option[UMLPackage[Uml]] = target.selectByKindOf { case x: UMLPackage[Uml] => x } headOption

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the Namespace that imports the members from a Package.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLNamespace.packageImport
	 */
	def importingNamespace: Option[UMLNamespace[Uml]] = owner.selectByKindOf { case x: UMLNamespace[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProfile.metamodelReference
	 */
	def metamodelReference_profile: Option[UMLProfile[Uml]] = importingNamespace.selectByKindOf { case x: UMLProfile[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The visibility of a PackageImport is either public or private.
	 * <!-- end-model-doc -->
	 *
	 * @body visibility = VisibilityKind::public or visibility = VisibilityKind::private
	 */
	def validate_public_or_private: Boolean  = {
		// Start of user code for "public_or_private"
    	???
    	// End of user code
	}

	// Start of user code for additional features

  /**
   * TIWG: see UMLUtil, Rule #3
   */
  override def xmiOrderingKey: String = element_xmiOrderingKey + (importedPackage match {
    case None => "_"
    case Some( ip ) => "_" + ip.xmiOrderingKey
  })

	// End of user code

} //UMLPackageImport
