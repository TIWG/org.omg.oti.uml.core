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
package org.omg.oti

import scala.language.postfixOps

trait UMLNamespaceOps[Uml <: UML] { self: UMLNamespace[Uml] =>

  import self.ops._

  // [protected (TIWG)]

  def importedPackages: Set[UMLPackage[Uml]] = packageImports.flatMap( _.importedPackage )

  def allImportedPackages: Set[UMLPackage[Uml]] = closure[UMLNamespace[Uml], UMLPackage[Uml]]( self, ( _.importedPackages ) )

  /**
   * @see UML 2.5, 7.8, Namespace
   *
   * importedMember() : PackageableElement [0..*]
   * The importedMember property is derived as the PackageableElements that
   * are members of this Namespace as a result of either PackageImports or ElementImports.
   *
   * body: self.importMembers(elementImport.importedElement->asSet()->union(packageImport.importedPackage- >collect(p | p.visibleMembers()))->asSet())
   */
  def importedMembers: Set[UMLPackageableElement[Uml]] = {
    val visibleMembersByImport = ( for {
      pi <- packageImports
      ip <- pi.importedPackage
    } yield ip.visibleMembers ) flatten

    val importedMembers = for {
      ei <- elementImports
      ie <- ei.importedElement
    } yield ie

    importedMembers ++ visibleMembersByImport
  }

  /**
   * @see UML 2.5 12.4, Package (moved from Package to Namespace)
   * visibleMembers() : PackageableElement [0..*]
   * The query visibleMembers() defines which members of a Namespace can be accessed outside it.
   * body: member->select( m | m.oclIsKindOf(PackageableElement) and self.makesVisible(m))- >collect(oclAsType(PackageableElement))->asSet()
   *
   * @see UMLPackage
   */
  def visibleMembers: Set[UMLPackageableElement[Uml]] =
    members.selectByKindOf { case pe: UMLPackageableElement[Uml] => pe }

  /**
   * allVisibleMembers is the union of the visibleMembers of the namespace and those of its directly and indirectly imported packages.
   */
  def allVisibleMembers: Set[UMLPackageableElement[Uml]] =
    visibleMembers ++ allImportedPackages.flatMap( _.visibleMembers )

  /**
   * accessibleMembers corresponds to the union of all visible members of the namespace and those of its outer namespace, if any.
   * 
   * @see UML 2.5, 7.4.3 Namespaces, Semantics
   * Within a Namespace, unqualified names may be used to refer to the members of that Namespace and to outer names that
   * are not hidden. An outer name is the name of a NamedElement that may be referenced using an unqualified name in an
   * immediately enclosing Namespace. An outer name is hidden unless it is distinguishable from all members of the inner Namespace.
   */
  def accessibleMembers: Set[UMLPackageableElement[Uml]] =
    namespace match {
      case None          => allVisibleMembers
      case Some( outer ) => allVisibleMembers ++ outer.allVisibleMembers
    }
  
  // [/protected]
}