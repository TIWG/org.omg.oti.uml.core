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

trait UMLNamedElementOps[Uml <: UML] { self: UMLNamedElement[Uml] =>

  import self.ops._

  def nameExpression: Option[UMLStringExpression[Uml]] = ( ownedElement.selectByKindOf { case se: UMLStringExpression[Uml] => se } ).headOption

  def namespace: Option[UMLNamespace[Uml]] = owner.selectByKindOf { case ns: UMLNamespace[Uml] => ns }

  /**
   * UML 2.5
   * 7.4 Namespaces
   * 7.8 Classifier Descriptions / NamedElement
   *
   * allNamespaces() : Namespace [0..*]{ordered}
   * The query allNamespaces() gives the sequence of Namespaces in which the NamedElement is nested, working outwards.
   * body:
   *  if owner.oclIsKindOf(TemplateParameter) and owner.oclAsType(TemplateParameter).signature.template.oclIsKindOf(Namespace) then
   *    let enclosingNamespace : Namespace = owner.oclAsType(TemplateParameter).signature.template.oclAsType(Namespace) in
   *    enclosingNamespace.allNamespaces()->prepend(enclosingNamespace)
   *  else
   *    if namespace->isEmpty()
   *    then OrderedSet{}
   *    else namespace.allNamespaces()->prepend(namespace)
   *    endif
   *  endif
   */
  def allNamespaces: Seq[UMLNamespace[Uml]] = {

    @annotation.tailrec def allNamespacesAggregator(
      acc: Seq[UMLNamespace[Uml]],
      ne: UMLNamedElement[Uml] ): Seq[UMLNamespace[Uml]] =
      ne.owner match {
        case tp: UMLTemplateParameter[Uml] =>
          tp.getTemplateSignatureNamespace match {
            case Some( tns ) => allNamespacesAggregator( acc :+ tns, tns )
            case None =>
              ne.namespace match {
                case Some( ns ) => allNamespacesAggregator( acc :+ ns, ns )
                case None       => acc
              }
          }
        case _ =>
          ne.namespace match {
            case None       => acc
            case Some( ns ) => allNamespacesAggregator( acc :+ ns, ns )
          }
      }

    allNamespacesAggregator( Seq(), self )
  }

  /**
   * UML 2.5
   * 7.4 Namespaces
   * 7.8 Classifier Descriptions / NamedElement
   *
   * allOwningPackages() : Package [0..*]
   * The query allOwningPackages() returns the set of all the enclosing Namespaces of this NamedElement,
   * working outwards, that are Packages, up to but not including the first such Namespace that is not a Package.
   * body:
   *  if namespace.oclIsKindOf(Package) then
   *    let owningPackage : Package = namespace.oclAsType(Package) in owningPackage->union(owningPackage.allOwningPackages())
   *    else null
   *    endif
   *
   * JPL:
   * Suppose we have:
   * - package P
   * - class P::A, P::A::B (i.e., B is a nested classifier of A)
   * Then P::A::B.allOwningPackages == {}
   */
  def allOwningPackages: Seq[UMLPackage[Uml]] = {

    @annotation.tailrec def allOwningPackagesAggregator(
      acc: Seq[UMLPackage[Uml]],
      ne: UMLNamedElement[Uml] ): Seq[UMLPackage[Uml]] =
      ne.namespace match {
        case Some( p: UMLPackage[Uml] ) => allOwningPackagesAggregator( acc :+ p, p )
        case _                          => acc
      }

    allOwningPackagesAggregator( Seq(), self )
  }

  /**
   * JPL:
   * To avoid the limitation of UML's NamedElement::allOwningPackages,
   * this query returns the first package, if any, from UML's NamedElement::allNamespaces
   */
  def owningPackage: Option[UMLPackage[Uml]] =
    self match {
      case p: UMLPackage[Uml] => Some( p )
      case _                  => allNamespaces.collectFirst( { case p: UMLPackage[Uml] => p } )
    }
}