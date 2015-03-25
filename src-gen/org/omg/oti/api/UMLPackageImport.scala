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
package org.omg.oti.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.operations._
// End of user code

/**
 * <!-- begin-model-doc -->
 * A PackageImport is a Relationship that imports all the non-private members of a Package into the Namespace owning the PackageImport, so that those Elements may be referred to by their unqualified names in the importingNamespace.
 * <!-- end-model-doc -->
 */
trait UMLPackageImport[Uml <: UML]
	extends UMLDirectedRelationship[Uml]
	with UMLPackageImportOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the Package whose members are imported into a Namespace.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLPackage.importedPackage_packageImport
	 */
	def importedPackage: Option[UMLPackage[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the Namespace that imports the members from a Package.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLNamespace.packageImport
	 */
	def importingNamespace: Option[UMLNamespace[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the visibility of the imported PackageableElements within the importingNamespace, i.e., whether imported Elements will in turn be visible to other Namespaces. If the PackageImport is public, the imported Elements will be visible outside the importingNamespace, while, if the PackageImport is private, they will not.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def visibility: UMLVisibilityKind.Value

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProfile.metamodelReference
	 */
	def metamodelReference_profile: Option[UMLProfile[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		packageImport_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPackageImport
	 */
	def packageImport_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			directedRelationship_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		packageImport_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPackageImport
	 */
	def packageImport_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			directedRelationship_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		packageImport_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPackageImport
	 */
	def packageImport_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			directedRelationship_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLPackageImport[Uml], UMLPackage[Uml]]("importedPackage", _.importedPackage)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		packageImport_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPackageImport
	 */
	def packageImport_forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		importedPackage ++
		importingNamespace 

} //UMLPackageImport
