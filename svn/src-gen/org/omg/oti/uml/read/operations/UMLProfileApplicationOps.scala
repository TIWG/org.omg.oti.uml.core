/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.operations

// Start of user code for imports

import org.omg.oti.uml.read.api._
import org.omg.oti.uml.xmi.IDGenerator
import scala.language.postfixOps
import scala.Option
import scala.Predef.String
import scala.collection.immutable.Set
import scalaz._, Scalaz._

// End of user code

/**
  * A profile application is used to show which profiles have been applied to a package.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLProfileApplicationOps[Uml <: UML] { self: UMLProfileApplication[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * References the Profiles that are applied to a Package through this ProfileApplication.
    *
    * <!-- Start of user code doc for appliedProfile -->
    * <!-- End of user code doc for appliedProfile -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProfile.appliedProfile_profileApplication
    */
  def appliedProfile: Option[UMLProfile[Uml]] = target.selectByKindOf { case x: UMLProfile[Uml] => x } headOption

  /**
    * The package that owns the profile application.
    *
    * <!-- Start of user code doc for applyingPackage -->
    * <!-- End of user code doc for applyingPackage -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackage.profileApplication
    */
  def applyingPackage: Option[UMLPackage[Uml]] = owner.selectByKindOf { case x: UMLPackage[Uml] => x }

  // Start of user code for additional features

  /**
   * TIWG: see UMLUtil, Rule #3
   */
  override def xmiOrderingKey()(implicit idg: IDGenerator[Uml])
	: Set[java.lang.Throwable] \/ String =
		for {
			key <- element_xmiOrderingKey
			i <- appliedProfile.fold[Set[java.lang.Throwable] \/ String](
				"_".right
			){ ap =>
				ap.xmiOrderingKey.map("_" + _)
    	}
		} yield key + i


  // End of user code
} //UMLProfileApplicationOps
