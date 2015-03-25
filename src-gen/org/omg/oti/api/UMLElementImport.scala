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
 * An ElementImport identifies a NamedElement in a Namespace other than the one that owns that NamedElement and allows the NamedElement to be referenced using an unqualified name in the Namespace owning the ElementImport.
 * <!-- end-model-doc -->
 */
trait UMLElementImport[Uml <: UML]
	extends UMLDirectedRelationship[Uml]
	with UMLElementImportOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the name that should be added to the importing Namespace in lieu of the name of the imported PackagableElement. The alias must not clash with any other member in the importing Namespace. By default, no alias is used.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def alias: Option[String]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the PackageableElement whose name is to be added to a Namespace.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLPackageableElement.importedElement_import
	 */
	def importedElement: Option[UMLPackageableElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the Namespace that imports a PackageableElement from another Namespace.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLNamespace.elementImport
	 */
	def importingNamespace: Option[UMLNamespace[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the visibility of the imported PackageableElement within the importingNamespace, i.e., whether the  importedElement will in turn be visible to other Namespaces. If the ElementImport is public, the importedElement will be visible outside the importingNamespace while, if the ElementImport is private, it will not.
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
	 * @opposite org.omg.oti.api.UMLProfile.metaclassReference
	 */
	def metaclassReference_profile: Option[UMLProfile[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		elementImport_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLElementImport
	 */
	def elementImport_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			directedRelationship_metaAttributes,
			Seq (MetaAttributeStringFunction[Uml, UMLElementImport[Uml]](None, "alias", _.alias)))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		elementImport_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLElementImport
	 */
	def elementImport_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			directedRelationship_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		elementImport_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLElementImport
	 */
	def elementImport_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			directedRelationship_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLElementImport[Uml], UMLPackageableElement[Uml]]("importedElement", _.importedElement)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		elementImport_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLElementImport
	 */
	def elementImport_forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		importedElement ++
		importingNamespace 

} //UMLElementImport
