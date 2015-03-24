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
 * A profile defines limited extensions to a reference metamodel with the purpose of adapting the metamodel to a specific platform or domain.
 * <!-- end-model-doc -->
 */
trait UMLProfile[Uml <: UML]
	extends UMLPackage[Uml]
	with UMLProfileOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * References a metaclass that may be extended.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLElementImport.metaclassReference_profile
	 */
	def metaclassReference: Set[UMLElementImport[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * References a package containing (directly or indirectly) metaclasses that may be extended.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPackageImport.metamodelReference_profile
	 */
	def metamodelReference: Set[UMLPackageImport[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProfileApplication.appliedProfile
	 */
	def appliedProfile_profileApplication: Set[UMLProfileApplication[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLStereotype.profile
	 */
	def profile_stereotype: Set[UMLStereotype[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		profile_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLProfile
	 */
	def profile_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			package_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		profile_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLProfile
	 */
	def profile_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			package_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		profile_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLProfile
	 */
	def profile_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			package_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLProfile[Uml], UMLElementImport[Uml]]("metaclassReference", _.metaclassReference),
				MetaPropertyCollection[Uml, UMLProfile[Uml], UMLPackageImport[Uml]]("metamodelReference", _.metamodelReference)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		profile_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLProfile
	 */
	def profile_forwardReferencesFromMetamodelAssociations: Elements =
		package_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLProfile
