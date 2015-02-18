package org.omg.oti.validation

import org.omg.oti._

/**
 * Non-standard well-formedness rules for the accessibility of and references to packageable elements.
 *
 * At the OMG, UML itself is defined as a so-called CMOF metamodel.
 * The well-formedness rules for CMOF metamodels have been clarified for UML 2.4.1 / MOF 2.4.1;
 * however, these rules do not address implicit patterns used in the organization of CMOF metamodels, profiles and libraries.
 *
 * Examples:
 *
 * 1) the 'UML' metamodel imports the 'PrimitiveTypes' library.
 *
 * The rationale for this import is to account for references to primitive types in UML itself.
 * For example: NamedElement::name : String[0..1]
 *
 * However, nothing in UML nor in CMOF requires such import to be present.
 *
 * 2) Compared to UML 2.4.1 where all of UML metaclasses were directly owned by the UML metamodel package,
 * the UML 2.5 metamodel introduced 1 level of nested packages (e.g., UML::Classifiers, UML::CommonStructure, UML::Packages, ...)
 * Additionally, the UML 2.5 metamodel package imports all of these nested packages.
 *
 * The rationale for the toplevel UML metamodel package to import all of its nested packages stems
 * from subtleties in the rules for referencing UML's metaclasses by name. For example, 'uml:Package'
 * refers to the UML metaclass 'UML::Packages::Package' by name (i.e., 'Package') via the namespace
 * prefix of the UML metamodel itself, i.e., 'uml'. These references by name 'work' in OCL and MOF/XMI
 * precisely because the UML metamodel package imports all of its nested packages and therefore allows
 * referencing contents of these nested packages by name.
 *
 * The two examples above illustrate that there are two different useful semantics for package imports:
 * - summarizing all references to elements outside the scope a package from any element within the scope of that package -- i.e., case (1)
 * - specifying the subset of elements within the scope of a package that can be externally referenced from outside of that package "by name" -- i.e., case (2)
 *
 * OTI provides non-standard operations to facilitate using UML in conformance with the tacit well-formedness rules
 * adopted at the OMG for the organization of metamodels, profiles and libraries.
 */
trait UMLPackageableElementRules[Uml <: UML, UmlOps <: UMLOps[Uml]] {
  implicit val umlOps: UmlOps
  import umlOps._

  trait AccessibilityViolation {
    val context: UMLPackage[Uml]
  }

  /**
   * Referenced importable packabeable element is not accessible
   */
  trait ReferencedButNotAccessibleViolation extends AccessibilityViolation {
    val referencedButNotAccessible: UMLPackageableElement[Uml]
  }

  type ReferencedButNotAccessibleConstructor = Function2[UMLPackage[Uml], UMLPackageableElement[Uml], Option[ReferencedButNotAccessibleViolation]]

  def defaultReferencedButNotAccessibleConstructor(
    _context: UMLPackage[Uml],
    _referencedButNotAccessible: UMLPackageableElement[Uml] ): Option[ReferencedButNotAccessibleViolation] =
    Some( new ReferencedButNotAccessibleViolation {
      override val context = _context
      override val referencedButNotAccessible = _referencedButNotAccessible
    } )

  /**
   * Compare two sets of elements:
   * - referenced from owned element within the context
   * - accessible from direct imports and applied profiles (excluding those from nesting packages)
   * @return Violations correspond to referenced elements that are not accessible.
   */
  def findNonAccessibleButReferencedImportablePackabeableElementsExceptNestingPackagesAndAppliedProfiles(
    context: UMLPackage[Uml] )(
      implicit c: ReferencedButNotAccessibleConstructor ): Iterable[ReferencedButNotAccessibleViolation] = {

    val unaccessible = 
      context.allForwardReferencesToImportablePackageableElementsFromAllOwnedElementsTransitively --       
      context.allDirectlyVisibleMembersTransitivelyAccessibleExceptNestingPackagesAndAppliedProfiles

    unaccessible.flatMap( c( context, _ ) )
  }

  /**
   * Compare two sets of elements:
   * - referenced from owned element within the context
   * - accessible from all imports and applied profiles (including those from nesting packages)
   * @return Violations correspond to referenced elements that are not accessible.
   */
  def findNonAccessibleButReferencedImportablePackabeableElementsIncludingNestingPackagesAndAppliedProfiles(
    context: UMLPackage[Uml] )(
      implicit c: ReferencedButNotAccessibleConstructor ): Iterable[ReferencedButNotAccessibleViolation] = {

    val unaccessible = 
      context.allForwardReferencesToImportablePackageableElementsFromAllOwnedElementsTransitively --       
      context.allIndirectlyVisibleMembersTransitivelyAccessibleFromNestingPackagesAndAppliedProfiles

    unaccessible.flatMap( c( context, _ ) )
  }

}