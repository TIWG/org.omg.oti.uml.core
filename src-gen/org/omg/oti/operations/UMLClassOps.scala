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
 * A Class classifies a set of objects and specifies the features that characterize the structure and behavior of those objects.  A Class may have an internal structure and Ports.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLClassOps[Uml <: UML] { self: UMLClass[Uml] =>	

	import self.ops._

	/**
	 * This property is used when the Class is acting as a metaclass. It references the Extensions that specify additional properties of the metaclass. The property is derived from the Extensions whose memberEnds are typed by the Class.
	 *
	 * <!-- Start of user code doc for extension -->
	 * <!-- End of user code doc for extension -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExtension.metaclass
	 * @body result = (Extension.allInstances()->select(ext | 
	 *   let endTypes : Sequence(Classifier) = ext.memberEnd->collect(type.oclAsType(Classifier)) in
	 *   endTypes->includes(self) or endTypes.allParents()->includes(self) ))
	 */
	def extension: Set[UMLExtension[Uml]] = {
		// Start of user code for "extension"
	    ???
	    // End of user code
	}

	/**
	 * The Receptions owned by the Class.
	 *
	 * <!-- Start of user code doc for ownedReception -->
	 * <!-- End of user code doc for ownedReception -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLReception.ownedReception_class
	 */
	def ownedReception: Set[UMLReception[Uml]] = feature.selectByKindOf { case x: UMLReception[Uml] => x }

	/**
	 * The superclasses of a Class, derived from its Generalizations.
	 *
	 * <!-- Start of user code doc for superClass -->
	 * <!-- End of user code doc for superClass -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClass.superClass_class
	 * @body result = (self.general()->select(oclIsKindOf(Class))->collect(oclAsType(Class))->asSet())
	 */
	def superClass: Set[UMLClass[Uml]] = general.selectByKindOf { case x: UMLClass[Uml] => x }

	/**
	 * <!-- Start of user code doc for superClass_class -->
	 * <!-- End of user code doc for superClass_class -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClass.superClass
	 */
	def superClass_class: Set[UMLClass[Uml]] = general_classifier.selectByKindOf { case x: UMLClass[Uml] => x }

	/**
	 * Only an active Class may own Receptions and have a classifierBehavior.
	 *
	 * <!-- Start of user code doc for validate_passive_class -->
	 * <!-- End of user code doc for validate_passive_class -->
	 *
	 * @body not isActive implies (ownedReception->isEmpty() and classifierBehavior = null)
	 */
	def validate_passive_class: Boolean = {
		// Start of user code for "passive_class"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLClassOps
