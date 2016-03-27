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
package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.annotation
import scala.Boolean
import scala.{Option,None,Some}
import scala.Predef.{???,String}
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code

/**
  * A NamedElement is an Element in a model that may have a name. The name may be given directly and/or via the use of a StringExpression.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLNamedElementOps[Uml <: UML] { self: UMLNamedElement[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Indicates the Dependencies that reference this NamedElement as a client.
    *
    * <!-- Start of user code doc for clientDependency -->
    * <!-- End of user code doc for clientDependency -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDependency.client
    * {{{
    * OCL Body result = (Dependency.allInstances()->select(d | d.client->includes(self)))
    * }}}
    */
  def clientDependency: Set[UMLDependency[Uml]] = source_directedRelationship.selectByKindOf { case x: UMLDependency[Uml] => x }

  /**
    * The StringExpression used to define the name of this NamedElement.
    *
    * <!-- Start of user code doc for nameExpression -->
    * <!-- End of user code doc for nameExpression -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStringExpression.nameExpression_namedElement
    */
  def nameExpression: Option[UMLStringExpression[Uml]] = ownedElement.selectByKindOf { case x: UMLStringExpression[Uml] => x } headOption

  /**
    * Specifies the Namespace that owns the NamedElement.
    *
    * <!-- Start of user code doc for namespace -->
    * <!-- End of user code doc for namespace -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamespace.ownedMember
    */
  def namespace: Option[UMLNamespace[Uml]] = owner.selectByKindOf { case x: UMLNamespace[Uml] => x }

  /**
    * A name that allows the NamedElement to be identified within a hierarchy of nested Namespaces. It is constructed from the names of the containing Namespaces starting at the root of the hierarchy and ending with the name of the NamedElement itself.
    *
    * <!-- Start of user code doc for qualifiedName -->
    * <!-- End of user code doc for qualifiedName -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * {{{
    * OCL Body result = (if self.name <> null and self.allNamespaces()->select( ns | ns.name=null )->isEmpty()
    * then 
    *     self.allNamespaces()->iterate( ns : Namespace; agg: String = self.name | ns.name.concat(self.separator()).concat(agg))
    * else
    *    null
    * endif)
    * }}}
    */
  def qualifiedName: Option[String] = {
    // Start of user code for "qualifiedName"
    ( name /: allNamespaces ){
      case (None, _) => None
      case (Some(n1), ns) =>
        ns.name match {
          case None => None
          case Some(n2) => Some( n1+separator.get+n2 )
        }
    }
    // End of user code
  }

  /**
    * <!-- Start of user code doc for informationSource_informationFlow -->
    * <!-- End of user code doc for informationSource_informationFlow -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInformationFlow.informationSource
    */
  def informationSource_informationFlow: Set[UMLInformationFlow[Uml]] = source_directedRelationship.selectByKindOf { case x: UMLInformationFlow[Uml] => x }

  /**
    * <!-- Start of user code doc for informationTarget_informationFlow -->
    * <!-- End of user code doc for informationTarget_informationFlow -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInformationFlow.informationTarget
    */
  def informationTarget_informationFlow: Set[UMLInformationFlow[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLInformationFlow[Uml] => x }

  /**
    * <!-- Start of user code doc for inheritedMember_inheritingClassifier -->
    * <!-- End of user code doc for inheritedMember_inheritingClassifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.inheritedMember
    */
  def inheritedMember_inheritingClassifier: Set[UMLClassifier[Uml]] = member_memberNamespace.selectByKindOf { case x: UMLClassifier[Uml] => x }

  /**
    * Indicates the dependencies that reference the supplier.
    *
    * <!-- Start of user code doc for supplier_supplierDependency -->
    * <!-- End of user code doc for supplier_supplierDependency -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDependency.supplier
    */
  def supplier_supplierDependency: Set[UMLDependency[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLDependency[Uml] => x }

  /**
    * The query allNamespaces() gives the sequence of Namespaces in which the NamedElement is nested, working outwards.
    *
    * <!-- Start of user code doc for allNamespaces -->
    * <!-- End of user code doc for allNamespaces -->
    *
    * UML Operation ordered="true" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (if owner.oclIsKindOf(TemplateParameter) and
    *   owner.oclAsType(TemplateParameter).signature.template.oclIsKindOf(Namespace) then
    *     let enclosingNamespace : Namespace =
    *       owner.oclAsType(TemplateParameter).signature.template.oclAsType(Namespace) in
    *         enclosingNamespace.allNamespaces()->prepend(enclosingNamespace)
    * else
    *   if namespace->isEmpty()
    *     then OrderedSet{}
    *   else
    *     namespace.allNamespaces()->prepend(namespace)
    *   endif
    * endif)
    * }}}
    */
  def allNamespaces: Seq[UMLNamespace[Uml]] = {
    // Start of user code for "allNamespaces"
      @annotation.tailrec def allNamespacesAggregator( //TBD
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
    // End of user code
  }

  /**
    * The query allOwningPackages() returns the set of all the enclosing Namespaces of this NamedElement, working outwards, that are Packages, up to but not including the first such Namespace that is not a Package.
    *
    * <!-- Start of user code doc for allOwningPackages -->
    * <!-- End of user code doc for allOwningPackages -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (if namespace.oclIsKindOf(Package)
    * then
    *   let owningPackage : Package = namespace.oclAsType(Package) in
    *     owningPackage->union(owningPackage.allOwningPackages())
    * else
    *   null
    * endif)
    * }}}
    */
  def allOwningPackages: Set[UMLPackage[Uml]] = {
    // Start of user code for "allOwningPackages"
    @annotation.tailrec def allOwningPackagesAggregator(
      acc: Set[UMLPackage[Uml]],
      ne: UMLNamedElement[Uml] ): Set[UMLPackage[Uml]] =
      ne.namespace match {
        case Some( p: UMLPackage[Uml] ) => allOwningPackagesAggregator( acc + p, p )
        case _                          => acc
      }

    allOwningPackagesAggregator( Set(), self )
    // End of user code
  }

  /**
    * The query isDistinguishableFrom() determines whether two NamedElements may logically co-exist within a Namespace. By default, two named elements are distinguishable if (a) they have types neither of which is a kind of the other or (b) they have different names.
    *
    * <!-- Start of user code doc for isDistinguishableFrom -->
    * <!-- End of user code doc for isDistinguishableFrom -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = ((self.oclIsKindOf(n.oclType()) or n.oclIsKindOf(self.oclType())) implies
    *     ns.getNamesOfMember(self)->intersection(ns.getNamesOfMember(n))->isEmpty()
    * )
    * }}}
    */
  def isDistinguishableFrom(n: Option[UMLNamedElement[Uml]], ns: Option[UMLNamespace[Uml]]): Boolean = {
    // Start of user code for "isDistinguishableFrom"
    ???
    // End of user code
  }

  /**
    * The query separator() gives the string that is used to separate names when constructing a qualifiedName.
    *
    * <!-- Start of user code doc for separator -->
    * <!-- End of user code doc for separator -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = ('::')
    * }}}
    */
  def separator: Option[String] = {
    // Start of user code for "separator"
    Some("::")
    // End of user code
  }

  /**
    * If there is no name, or one of the containing Namespaces has no name, there is no qualifiedName.
    *
    * <!-- Start of user code doc for validate_has_no_qualified_name -->
    * <!-- End of user code doc for validate_has_no_qualified_name -->
    *
    * {{{
    * OCL Body name=null or allNamespaces()->select( ns | ns.name=null )->notEmpty() implies qualifiedName = null
    * }}}
    */
  def validate_has_no_qualified_name: Boolean = {
    // Start of user code for "has_no_qualified_name"
    if ( name.isEmpty || allNamespaces.exists { _.name.isEmpty } ) {
      qualifiedName.isEmpty
    } else true
    // End of user code
  }

  /**
    * When there is a name, and all of the containing Namespaces have a name, the qualifiedName is constructed from the name of the NamedElement and the names of the containing Namespaces.
    *
    * <!-- Start of user code doc for validate_has_qualified_name -->
    * <!-- End of user code doc for validate_has_qualified_name -->
    *
    * {{{
    * OCL Body (name <> null and allNamespaces()->select(ns | ns.name = null)->isEmpty()) implies
    *   qualifiedName = allNamespaces()->iterate( ns : Namespace; agg: String = name | ns.name.concat(self.separator()).concat(agg))
    * }}}
    */
  def validate_has_qualified_name: Boolean = {
    // Start of user code for "has_qualified_name"
    if ( name.isDefined && allNamespaces.forall { _.name.isDefined } ) {
      qualifiedName.isDefined
    } else true
    // End of user code
  }

  /**
    * If a NamedElement is owned by something other than a Namespace, it does not have a visibility. One that is not owned by anything (and hence must be a Package, as this is the only kind of NamedElement that overrides mustBeOwned()) may have a visibility.
    *
    * <!-- Start of user code doc for validate_visibility_needs_ownership -->
    * <!-- End of user code doc for validate_visibility_needs_ownership -->
    *
    * {{{
    * OCL Body (namespace = null and owner <> null) implies visibility = null
    * }}}
    */
  def validate_visibility_needs_ownership: Boolean = {
    // Start of user code for "visibility_needs_ownership"
    if (namespace.isEmpty && owner.isDefined) {
      visibility.isEmpty 
    } else true
    // End of user code
  }

  // Start of user code for additional features

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

  // End of user code
} //UMLNamedElementOps
