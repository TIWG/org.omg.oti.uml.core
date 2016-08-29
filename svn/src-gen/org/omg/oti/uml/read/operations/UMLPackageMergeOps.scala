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
  * A package merge defines how the contents of one package are extended by the contents of another package.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPackageMergeOps[Uml <: UML] { self: UMLPackageMerge[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * References the Package that is to be merged with the receiving package of the PackageMerge.
    *
    * <!-- Start of user code doc for mergedPackage -->
    * <!-- End of user code doc for mergedPackage -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackage.mergedPackage_packageMerge
    */
  def mergedPackage: Option[UMLPackage[Uml]] = target.selectByKindOf { case x: UMLPackage[Uml] => x } headOption

  /**
    * References the Package that is being extended with the contents of the merged package of the PackageMerge.
    *
    * <!-- Start of user code doc for receivingPackage -->
    * <!-- End of user code doc for receivingPackage -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackage.packageMerge
    */
  def receivingPackage: Option[UMLPackage[Uml]] = owner.selectByKindOf { case x: UMLPackage[Uml] => x }

  // Start of user code for additional features

  override def xmiOrderingKey()(implicit idg: IDGenerator[Uml])
  : Set[java.lang.Throwable] \/ String
  = for {
	key <- element_xmiOrderingKey
	i <- mergedPackage.fold[Set[java.lang.Throwable] \/ String]("_".right){ mp =>
		mp.xmiOrderingKey.map("_" + _)
	}
  } yield key + i

  // End of user code
} //UMLPackageMergeOps
