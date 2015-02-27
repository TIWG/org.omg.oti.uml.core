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

import org.omg.oti._
import scala.language.postfixOps
import scala.util.Try
import scala.util.Success
import scala.util.Failure

/**
 * In UML, a PackageImport is a relationship between a Namespace and a Package.
 * It means that the members of the imported package can be "referred by name" from
 * the context of the importing namespace. What does "referred by name" really means in UML
 * given that UML itself does not specify anything notion of name/symbol resolution/lookup?
 * 
 * In OTI, this is clarified based on two pragmatic clarifications:
 * 
 * 1) In MOF/XMI, "referred by name" pertains to the prefix + name of an XML Element.
 * 
 * For example, "<uml:Package ..../>", means that "uml" denotes the namespace prefix for the UML
 * metamodel and "Package" is a class defined in the UML metamodel "referred by name".
 * If anything, this is the main reason why the UML 2.5 metamodel has several package import
 * relationships from the UML metamodel package to the nested packages.
 * For example, the qualified name of the "Package" metaclass in the metamodel in "UML::Packages::Package"
 * where "UML::Packages" is the qualified name of a nested package, "Packages".
 * Without the UML metamodel package importing the nested package, UML::Packages, the XMI serialization
 * of a UML Package would not be "<uml:Package .../>" but something else (TBD).
 *
 * 2) In OCL, "referred by name" pertains to the prefix + name of a metaclass.
 * 
 * For example, "x.oclIsKindOf(uml:Package)" involves a reference to the metaclass, "uml:Package",
 * according to the UML rules for referring to named elements in a namespace context.
 * Again, without the import from UML to the nexted package UML::Package, the above OCL example
 * would have to be written differently (TBD).
 * 
 * UML 2.5 is the first major metamodel at the OMG to have a nested package organization.
 * This means that there is no established precedent at the OMG for referring to elements
 * in MOF/XMI and OCL that are not direct members of a toplevel metamodel/profile/library.
 * Instead of postulating something that does not have a significant consensus,
 * the approach used in OTI is to adopt a conservative clarification on UML, preferably based
 * on an established precedent at the OMG.
 *
 * UML 2.5 itself establishes the precedent for requiring a package P1 to import its nested packages
 * explicitly (e.g., P1::P2) in order to expose the contents in a way that can be "referred by name"
 * from the context of the outer package (i.e., P1). This clarification needs to be
 * reconciled with three semantics:
 * 
 * - the semantics of Namespaces & NamedElements (7.4.3):
 * 
 * When a distinction is necessary, a simple name that is not qualified with Namespace names may be 
 * referred to as an unqualified name. Within a Namespace, unqualified names may be used to refer 
 * to the members of that Namespace and to outer names that are not hidden. An outer name is the name of 
 * a NamedElement that may be referenced using an unqualified name in an immediately enclosing Namespace. 
 * An outer name is hidden unless it is distinguishable from all members of the inner Namespace. 
 * (See the discussion on distinguishability below under “Named Elements”.)
 *
 * - the semantics of PackageableElements & Import (7.4.3):
 * 
 * -----------------
 * A PackageableElement is a NamedElement that may be owned directly by a Package (see Clause 12 on Packages).
 * Any such element may serve as a TemplateParameter (see sub clause 7.3 on Templates).
 *
 * An ElementImport is a DirectedRelationship between an importing Namespace and a PackageableElement. 
 * It adds the name of the PackageableElement to the importing Namespace. The visibility of the ElementImport
 * may be either the same or more restricted than that of the imported element.
 *
 * In case of a name clash with an outer name (an element that is defined in an enclosing Namespace that 
 * is available using its unqualified name in enclosed Namespaces) in the importing Namespace, 
 * the outer name is hidden by an ElementImport, and the unqualified name refers to the imported element. 
 * The outer name can be accessed using its qualified name. A PackageImport is a DirectedRelationship between 
 * an importing Namespace and a Package, indicating that the importing Namespace adds the names of 
 * the members of the Package to its own Namespace. Conceptually, a Package import is equivalent to 
 * having an ElementImport to each individual member of the imported Namespace, unless there is
 * a separately-defined ElementImport. If there is an ElementImport for an Element, 
 * then this takes precedence over a potential import of the same Element via a PackageImport.
 *
 * If indistinguishable Elements would be imported into a Namespace as a consequence of ElementImports 
 * or PackageImports, the Elements are not added to the importing Namespace and the names of those 
 * Elements must be qualified in order to be used in that Namespace. If the name of an imported Element 
 * is indistinguishable from an Element owned by the importing Namespace, that Element is not added to 
 * the importing Namespace and the name of that Element must be qualified in order to be used.
 * 
 * An Element that is publicly imported is a public member of the importing Namespace. 
 * This means that, if the Namespace is a Package, a PackageImport of it by another Namespace will 
 * result in the further import of those publicly imported members into the other Namespace, 
 * in addition to the public ownedMembers of the Package.
 *
 * NOTE. A Namespace may not import itself, nor may it import any of its own ownedMembers.
 * This means that it is not possible for a NamedElement to acquire an alias in its owning Namespace. 
 * ------------------
 * 
 * Although the UML 2.5 specification does not clearly specify what is the semantics
 * of an ElementImport where the imported element is a Package (instead of a non-Package PackageableElement),
 * the important clarification about the UML 2.5 specification made here is that of 
 * separating three ways in which elements can be "referred by name" in the context of a package:
 * 1) by following package import relationships
 * 2) by following package nesting (inwards)
 * 3) by following package nesting (outwards)
 *
 * The semantics of importation involves (1) per 7.4.3
 * The semantics of profile application involves both (1) and (2) per 12.3.3
 * The semantics of namespaces involves (1) and (3) per 7.4.3
 */
trait UMLNamespaceOps[Uml <: UML] { self: UMLNamespace[Uml] =>

  import self.ops._

  // [protected (TIWG)]

  def elementImport: Set[UMLElementImport[Uml]] = 
    source_directedRelationship.selectByKindOf { case ei: UMLElementImport[Uml] => ei }

  /**
   * @see UML 2.5, 7.8, Namespace
   *
   * importedMember() : PackageableElement [0..*]
   * The importedMember property is derived as the PackageableElements that
   * are members of this Namespace as a result of either PackageImports or ElementImports.
   *
   * body: self.importMembers(elementImport.importedElement->asSet()->union(packageImport.importedPackage- >collect(p | p.visibleMembers()))->asSet())
   */
  def importedMember: Set[UMLPackageableElement[Uml]] = {
    val visibleMembersByImport = ( for {
      pi <- packageImport
      ip <- pi.importedPackage
    } yield ip.visibleMembers ) flatten

    val importedMembers = for {
      ei <- elementImport
      ie <- ei.importedElement
    } yield ie

    importedMembers ++ visibleMembersByImport
  }

  // member: cannot be derived
  
  def ownedMember: Set[UMLNamedElement[Uml]] = 
    member & ( ownedElement.selectByKindOf { case ne: UMLNamedElement[Uml] => ne } )

  def ownedRule: Set[UMLConstraint[Uml]] = 
    ownedMember.selectByKindOf { case c: UMLConstraint[Uml] => c }

  def packageImport: Set[UMLPackageImport[Uml]] = 
    source_directedRelationship.selectByKindOf { case pi: UMLPackageImport[Uml] => pi }

  /** 
   * A namespace NS directly imports a package P if there is a PackageImport(NS, P)
   */
  def importedPackages: Set[UMLPackage[Uml]] = packageImport.flatMap( _.importedPackage )

  /**
   * The transitive closure of 'importedPackages', that is:
   * 
   * A namespace NS indirectly imports a package P if either
   * - NS directly imports P, or
   * - NS directly imports P' that indirectly imports P
   */
  def allImportedPackagesTransitively: Set[UMLPackage[Uml]] = closure[UMLNamespace[Uml], UMLPackage[Uml]]( self, ( _.importedPackages ) )

  /**
   * @see UML 2.5 12.4, Package (moved from Package to Namespace)
   * visibleMembers() : PackageableElement [0..*]
   * The query visibleMembers() defines which members of a Namespace can be accessed outside it.
   * body: member->select( m | m.oclIsKindOf(PackageableElement) and self.makesVisible(m))- >collect(oclAsType(PackageableElement))->asSet()
   *
   * @see UMLPackage
   */
  def visibleMembers: Set[UMLPackageableElement[Uml]] =
    member.selectByKindOf { case pe: UMLPackageableElement[Uml] => pe }

  def asPackageableElement: Option[UMLPackageableElement[Uml]] = this match {
    case pe: UMLPackageableElement[Uml] => Some( pe )
    case _ => None
  }
  
  /**
   * allVisibleMembers is the union of the visibleMembers of the namespace and those of its directly and indirectly imported packages.
   */
  def allVisibleMembersTransitively: Set[UMLPackageableElement[Uml]] =
    visibleMembers ++ 
    this.asPackageableElement.toSet ++ 
    allImportedPackagesTransitively.flatMap( (p) => p.visibleMembers + p )

  /**
   * allVisibleMembersAccessibleTransitively corresponds to the union of all visible members of the namespace and those of its outer namespace, if any.
   * 
   * @see UML 2.5, 7.4.3 Namespaces, Semantics
   * Within a Namespace, unqualified names may be used to refer to the members of that Namespace and to outer names that
   * are not hidden. An outer name is the name of a NamedElement that may be referenced using an unqualified name in an
   * immediately enclosing Namespace. An outer name is hidden unless it is distinguishable from all members of the inner Namespace.
   */
  def allVisibleMembersAccessibleTransitively: Set[UMLPackageableElement[Uml]] =
    namespace match {
      case None          => allVisibleMembersTransitively
      case Some( outer ) => allVisibleMembersTransitively ++ outer.allVisibleMembersAccessibleTransitively
    }

  /**
   * All namespaces that are owned within the reflexive transitive closure of ownership from this namespace
   */
  def allNamespacesWithinScope: Set[UMLNamespace[Uml]] =
    (allOwnedElements selectByKindOf { case ns: UMLNamespace[Uml] => ns } toSet) + self
    
  /**
   * Find the packages or profiles that own the elements referenced from the packaged elements of this package.
   * This does not include references from elements in nested packages.
   */
  def forwardReferencesToNamespaces: Try[Set[UMLNamespace[Uml]]] =
    forwardReferencesBeyondNamespaceScope match {
    case Failure( t ) => Failure( t )
    case Success( triples ) =>
      val ns = triples map 
      (_.obj) flatMap
      (_.owningNamespace)
      Success( ns )
  }

  /**
    * The RelationTriples characterizing the namespace boundary.
    * The subject of each relation triple is an element inside the ownership scope of the namespace.
    * The object of each relation triple is an element outside the ownership scope of the namespace.
    * The property of each relation triple is either a metamodel association or a stereotype property.
    */
  def forwardReferencesBeyondNamespaceScope: Try[Set[RelationTriple[Uml]]] = {

    val scope = self.ownedElement
    
    val visited = scala.collection.mutable.HashSet[UMLElement[Uml]]( self )

    @annotation.tailrec def followReferencesUntilNamespaceScopeBoundary(
      acc: Set[RelationTriple[Uml]],
      triples: Try[Set[RelationTriple[Uml]]] ): Try[Set[RelationTriple[Uml]]] =
      triples match {
        case Failure( t ) => Failure( t )
        case Success( ts ) =>
          if ( ts.isEmpty ) Success( acc )
          else {
            val ( th, tr: Set[RelationTriple[Uml]] ) = ( ts.head, ts.tail )
            if ( visited.contains( th.obj ) )
              followReferencesUntilNamespaceScopeBoundary(
                acc,
                Success( tr ) )
            else {
              visited += th.sub
              if ( scope.contains( th.obj ) )
                th.obj.forwardRelationTriples match {
                  case Failure( t ) => Failure( t )
                  case Success( nextTriples: Set[RelationTriple[Uml]] ) =>
                    followReferencesUntilNamespaceScopeBoundary(
                      acc,
                      Success( nextTriples ++ tr ) )
                }
              else
                followReferencesUntilNamespaceScopeBoundary(
                  acc + th,
                  Success( tr ) )
            }
          }
      }

    val triples0: Try[Set[RelationTriple[Uml]]] = Success( Set() )
    val triplesN: Try[Set[RelationTriple[Uml]]] = ( triples0 /: scope ) {
      case ( Failure( t ), _ )   => Failure( t )
      case ( Success( acc ), e ) => followReferencesUntilNamespaceScopeBoundary( acc, e.forwardRelationTriples )
    }
    triplesN
  }
  // [/protected]
}