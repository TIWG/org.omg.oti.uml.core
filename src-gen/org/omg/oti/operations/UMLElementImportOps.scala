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
 * An ElementImport identifies a NamedElement in a Namespace other than the one that owns that NamedElement and allows the NamedElement to be referenced using an unqualified name in the Namespace owning the ElementImport.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLElementImportOps[Uml <: UML] { self: UMLElementImport[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the PackageableElement whose name is to be added to a Namespace.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLPackageableElement.importedElement_import
	 */
	def importedElement: Option[UMLPackageableElement[Uml]] = target.selectByKindOf { case x: UMLPackageableElement[Uml] => x } headOption

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the Namespace that imports a PackageableElement from another Namespace.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLNamespace.elementImport
	 */
	def importingNamespace: Option[UMLNamespace[Uml]] = owner.selectByKindOf { case x: UMLNamespace[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The query getName() returns the name under which the imported PackageableElement will be known in the importing namespace.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if alias->notEmpty() then
	 *   alias
	 * else
	 *   importedElement.name
	 * endif)
	 */
	def getName: Option[String]  = {
		// Start of user code for "getName"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * An importedElement has either public visibility or no visibility at all.
	 * <!-- end-model-doc -->
	 *
	 * @body importedElement.visibility <> null implies importedElement.visibility = VisibilityKind::public
	 */
	def validate_imported_element_is_public: Boolean  = {
		// Start of user code for "imported_element_is_public"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The visibility of an ElementImport is either public or private.
	 * <!-- end-model-doc -->
	 *
	 * @body visibility = VisibilityKind::public or visibility = VisibilityKind::private
	 */
	def validate_visibility_public_or_private: Boolean  = {
		// Start of user code for "visibility_public_or_private"
    	???
    	// End of user code
	}

	// Start of user code for additional features

  /**
   * TIWG: see UMLUtil, Rule #3
   */
  override def xmiOrderingKey: String = element_xmiOrderingKey + (importedElement match {
    case None => "_"
    case Some( ie ) => "_" + ie.xmiOrderingKey
  })

	// End of user code

} //UMLElementImport
