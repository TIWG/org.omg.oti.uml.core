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
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLPackageOps

import scala.Option
import scala.Predef.String
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * A package can have one or more profile applications to indicate which profiles have been applied. Because a profile is a package, it is possible to apply a profile not only to packages, but also to profiles.Package specializes TemplateableElement and PackageableElement specializes ParameterableElement to specify that a package can be used as a template and a PackageableElement as a template parameter.A package is used to group elements, and provides a namespace for the grouped elements.
 *
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
*/
trait UMLPackage[Uml <: UML]
	extends UMLNamespace[Uml]
	with UMLPackageableElement[Uml]
	with UMLTemplateableElement[Uml]
	with UMLPackageOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * Provides an identifier for the package that can be used for many purposes. A URI is the universally unique identification of the package following the IETF URI specification, RFC 2396 http://www.ietf.org/rfc/rfc2396.txt and it must comply with those syntax rules.
	 *
	 * <!-- Start of user code doc for URI -->
	 * <!-- End of user code doc for URI -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def URI: Option[String]

	/**
	 * References the Package that owns this Package.
	 *
	 * <!-- Start of user code doc for nestingPackage -->
	 * <!-- End of user code doc for nestingPackage -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLPackage.nestedPackage
	 */
	def nestingPackage: Option[UMLPackage[Uml]]

	/**
	 * Specifies the packageable elements that are owned by this Package.
	 *
	 * <!-- Start of user code doc for packagedElement -->
	 * <!-- End of user code doc for packagedElement -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLPackageableElement.packagedElement_owningPackage
	 */
	def packagedElement: Set[UMLPackageableElement[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		package_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPackage
	 *
	 * <!-- Start of user code doc for package_metaAttributes -->
	 * <!-- End of user code doc for package_metaAttributes -->
	 */
	def package_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			namespace_metaAttributes,
			packageableElement_metaAttributes,
			templateableElement_metaAttributes,
			Seq[MetaAttributeFunction](Package_URI))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		package_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPackage
	 *
	 * <!-- Start of user code doc for package_compositeMetaProperties -->
	 * <!-- End of user code doc for package_compositeMetaProperties -->
	 */
	def package_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namespace_compositeMetaProperties,
			packageableElement_compositeMetaProperties,
			templateableElement_compositeMetaProperties,
			Seq[MetaPropertyEvaluator](Package_packageMerge,
				Package_packagedElement,
				Package_profileApplication))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		package_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPackage
	 *
	 * <!-- Start of user code doc for package_referenceMetaProperties -->
	 * <!-- End of user code doc for package_referenceMetaProperties -->
	 */
	def package_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namespace_referenceMetaProperties,
			packageableElement_referenceMetaProperties,
			templateableElement_referenceMetaProperties,
			Seq[MetaPropertyEvaluator]())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		package_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPackage
	 *
	 * <!-- Start of user code doc for package_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for package_forwardReferencesFromMetamodelAssociations -->
	 */
	def package_forwardReferencesFromMetamodelAssociations: Elements =
		namespace_forwardReferencesFromMetamodelAssociations ++
		packageableElement_forwardReferencesFromMetamodelAssociations ++
		templateableElement_forwardReferencesFromMetamodelAssociations ++
		Set ()

	// Start of user code for additional features
	// End of user code
} //UMLPackage
