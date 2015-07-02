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

import org.omg.oti.uml.read.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * A PackageableElement is a NamedElement that may be owned directly by a Package. A PackageableElement is also able to serve as the parameteredElement of a TemplateParameter.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLPackageableElementOps[Uml <: UML] { self: UMLPackageableElement[Uml] =>	

	import self.ops._

	/**
	 * <!-- Start of user code doc for importedElement_import -->
	 * <!-- End of user code doc for importedElement_import -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLElementImport.importedElement
	 */
	def importedElement_import: Set[UMLElementImport[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLElementImport[Uml] => x }

	/**
	 * <!-- Start of user code doc for packagedElement_component -->
	 * <!-- End of user code doc for packagedElement_component -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLComponent.packagedElement
	 */
	def packagedElement_component: Option[UMLComponent[Uml]] = namespace.selectByKindOf { case x: UMLComponent[Uml] => x }

	/**
	 * <!-- Start of user code doc for packagedElement_owningPackage -->
	 * <!-- End of user code doc for packagedElement_owningPackage -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLPackage.packagedElement
	 */
	def packagedElement_owningPackage: Option[UMLPackage[Uml]] = namespace.selectByKindOf { case x: UMLPackage[Uml] => x }

	/**
	 * A PackageableElement owned by a Namespace must have a visibility.
	 *
	 * <!-- Start of user code doc for validate_namespace_needs_visibility -->
	 * <!-- End of user code doc for validate_namespace_needs_visibility -->
	 *
	 * @body visibility = null implies namespace = null
	 */
	def validate_namespace_needs_visibility: Boolean = {
		// Start of user code for "namespace_needs_visibility"
  	if (visibility.isEmpty) {
      namespace.isEmpty 
    } else true     
  	// End of user code
	}

	// Start of user code for additional features

  override def asForwardReferencesToImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] = Set( this )

  override def asForwardReferencesToOwningElementImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] = Set( this ) 

	// End of user code
} //UMLPackageableElementOps
