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

import org.omg.oti.uml.read.api.{UML, UMLComponent, UMLComponentRealization, UMLInterface}

import scala.language.postfixOps
// End of user code

/**
 * A Component represents a modular part of a system that encapsulates its contents and whose manifestation is replaceable within its environment.  
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLComponentOps[Uml <: UML] { self: UMLComponent[Uml] =>

	import self.ops._

	/**
	 * The Interfaces that the Component exposes to its environment. These Interfaces may be Realized by the Component or any of its realizingClassifiers, or they may be the Interfaces that are provided by its public Ports.
	 *
	 * <!-- Start of user code doc for provided -->
   * <!-- End of user code doc for provided -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLInterface.provided_component
	 * {{{
	 * OCL Body result = (let 	ris : Set(Interface) = allRealizedInterfaces(),
	 *         realizingClassifiers : Set(Classifier) =  self.realization.realizingClassifier->union(self.allParents()->collect(realization.realizingClassifier))->asSet(),
	 *         allRealizingClassifiers : Set(Classifier) = realizingClassifiers->union(realizingClassifiers.allParents())->asSet(),
	 *         realizingClassifierInterfaces : Set(Interface) = allRealizingClassifiers->iterate(c; rci : Set(Interface) = Set{} | rci->union(c.allRealizedInterfaces())),
	 *         ports : Set(Port) = self.ownedPort->union(allParents()->collect(ownedPort))->asSet(),
	 *         providedByPorts : Set(Interface) = ports.provided->asSet()
	 * in     ris->union(realizingClassifierInterfaces) ->union(providedByPorts)->asSet())
	 * }}}
	 */
	def provided: Set[UMLInterface[Uml]] = {
		// Start of user code for "provided"
      ???
      // End of user code
	}

	/**
	 * The set of Realizations owned by the Component. Realizations reference the Classifiers of which the Component is an abstraction; i.e., that realize its behavior.
	 *
	 * <!-- Start of user code doc for realization -->
   * <!-- End of user code doc for realization -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLComponentRealization.abstraction
	 */
	def realization: Set[UMLComponentRealization[Uml]] = ownedElement.selectByKindOf { case x: UMLComponentRealization[Uml] => x }

	/**
	 * The Interfaces that the Component requires from other Components in its environment in order to be able to offer its full set of provided functionality. These Interfaces may be used by the Component or any of its realizingClassifiers, or they may be the Interfaces that are required by its public Ports.
	 *
	 * <!-- Start of user code doc for required -->
   * <!-- End of user code doc for required -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLInterface.required_component
	 * {{{
	 * OCL Body result = (let 	uis : Set(Interface) = allUsedInterfaces(),
	 *         realizingClassifiers : Set(Classifier) = self.realization.realizingClassifier->union(self.allParents()->collect(realization.realizingClassifier))->asSet(),
	 *         allRealizingClassifiers : Set(Classifier) = realizingClassifiers->union(realizingClassifiers.allParents())->asSet(),
	 *         realizingClassifierInterfaces : Set(Interface) = allRealizingClassifiers->iterate(c; rci : Set(Interface) = Set{} | rci->union(c.allUsedInterfaces())),
	 *         ports : Set(Port) = self.ownedPort->union(allParents()->collect(ownedPort))->asSet(),
	 *         usedByPorts : Set(Interface) = ports.required->asSet()
	 * in	    uis->union(realizingClassifierInterfaces)->union(usedByPorts)->asSet()
	 * )
	 * }}}
	 */
	def required: Set[UMLInterface[Uml]] = {
		// Start of user code for "required"
      ???
      // End of user code
	}

	/**
	 * A Component cannot nest Classifiers.
	 *
	 * <!-- Start of user code doc for validate_no_nested_classifiers -->
   * <!-- End of user code doc for validate_no_nested_classifiers -->
	 *
	 * {{{
	 * OCL Body nestedClassifier->isEmpty()
	 * }}}
	 */
	def validate_no_nested_classifiers: Boolean = {
		// Start of user code for "no_nested_classifiers"
      ???
      // End of user code
	}

	/**
	 * A Component nested in a Class cannot have any packaged elements.
	 *
	 * <!-- Start of user code doc for validate_no_packaged_elements -->
   * <!-- End of user code doc for validate_no_packaged_elements -->
	 *
	 * {{{
	 * OCL Body nestingClass <> null implies packagedElement->isEmpty()
	 * }}}
	 */
	def validate_no_packaged_elements: Boolean = {
		// Start of user code for "no_packaged_elements"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLComponentOps
