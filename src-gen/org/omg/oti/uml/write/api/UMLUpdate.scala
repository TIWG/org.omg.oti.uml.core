package org.omg.oti.uml.write.api

import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.util.Try

/**
 *
 * There are 5 kinds of update methods:
 * 1) creating a link instance of a composite association
 * 2) deleting a link instance of a composite association
 * 3) creating a link instance of a reference association
 * 4) deleting a link instance of a reference association
 * 5) setting the value of a DataType metaclass property
 *
 * Unfortunately, the names of UML associations is not necessarily consistent with that of the association ends.
 * Differences include:
 * - ordering (e.g., an association from end1 to end2 is sometimes named A_end1_end2 or A_end2_end1)
 * - redefinitions (e.g., there would be name conflicts if the association were to be named according to
 *   the names of its member ends so the association name is different)
 *
 * To avoid these problems and make the API more "litterate", the naming scheme is:
 *
 * For (1)
 * link_<metaclass1>_<end1>_composes_<end2>_<metaclass2>
 *   (from: <metaclass1>,
 *    to: <metaclass2>): Try[Unit]
 *
 * For (2)
 * unlink_<metaclass1>_<end1>_composes_<end2>_<metaclass2>
 *   (from: <metaclass1>,
 *    to: <metaclass2>): Try[Unit]
 *
 * For (3)
 * link_<metaclass1>_<end1>_references_<end2>_<metaclass2>
 *   (from: <metaclass1>,
 *    to: <metaclass2>): Try[Unit]
 *
 * For (4)
 * unlink_<metaclass1>_<end1>_references_<end2>_<metaclass2>
 *   (from: <metaclass1>,
 *    to: <metaclass2>): Try[Unit]
 *
 * This is done for all non-derived, non-abstract associations whose member ends have each an upper bound > 0
 *
 * The pattern for (5) is:
 *
 * set_<metaclass>_<dataProperty>
 *   (e: <metaclass>, value: <dataPropertyTypeOrCollection>): Try[Unit]
 *
 */
trait UMLUpdate[Uml <: UML] {
  implicit val ops: UMLOps[Uml]

  // Element

  def link_Element_owningElement_composes_ownedComment_Comment
  (from: UMLElement[Uml], to: UMLElement[Uml]): Try[Unit]

  def unlink_Element_owningElement_composes_ownedComment_Comment
  (from: UMLElement[Uml], to: UMLElement[Uml]): Try[Unit]

  // Comment

  def link_Comment_comment_references_annotatedElement_Element
  (from: UMLComment[Uml], to: UMLElement[Uml]): Try[Unit]

  def unlink_Comment_comment_references_annotatedElement_Element
  (from: UMLComment[Uml], to: UMLElement[Uml]): Try[Unit]

  def set_Comment_body
  (e: UMLComment[Uml], body: Option[String]): Try[Unit]

  // Relationship

  // DirectedRelationship

  // TemplateableElement

  def link_TemplateableElement_template_composes_ownedTemplateSignature_TemplateSignature
  (from: UMLTemplateableElement[Uml], to: UMLTemplateSignature[Uml]): Try[Unit]

  def unlink_TemplateableElement_template_composes_ownedTemplateSignature_TemplateSignature
  (from: UMLTemplateableElement[Uml], to: UMLTemplateSignature[Uml]): Try[Unit]

  // TemplateSignature

  def link_TemplateSignature_signature_composes_ownedParameter_TemplateParameter
  (from: UMLTemplateSignature[Uml], to: UMLTemplateParameter[Uml]): Try[Unit]

  def unlink_TemplateSignature_signature_composes_ownedParameter_TemplateParameter
  (from: UMLTemplateSignature[Uml], to: UMLTemplateParameter[Uml]): Try[Unit]

  def link_TemplateSignature_signature_references_parameter_TemplateParameter
  (from: UMLTemplateSignature[Uml], to: UMLTemplateParameter[Uml]): Try[Unit]

  def unlink_TemplateSignature_signature_references_parameter_TemplateParameter
  (from: UMLTemplateSignature[Uml], to: UMLTemplateParameter[Uml]): Try[Unit]

  // ParameterableElement

  // TemplateParameter

  def link_TemplateParameter_owningTemplateParameter_composes_ownedParameteredElement_ParameterableElement
  (from: UMLTemplateSignature[Uml], to: UMLTemplateParameter[Uml]): Try[Unit]

  def unlink_TemplateParameter_owningTemplateParameter_composes_ownedParameteredElement_ParameterableElement
  (from: UMLTemplateSignature[Uml], to: UMLTemplateParameter[Uml]): Try[Unit]

  def link_TemplateParameter_templateParameter_composes_ownedDefault_ParameterableElement
  (from: UMLTemplateSignature[Uml], to: UMLTemplateParameter[Uml]): Try[Unit]

  def unlink_TemplateParameter_templateParameter_composes_ownedDefault_ParameterableElement
  (from: UMLTemplateSignature[Uml], to: UMLTemplateParameter[Uml]): Try[Unit]

  def link_TemplateParameter_templateParameter_references_parameteredElement_ParameterableElement
  (from: UMLTemplateSignature[Uml], to: UMLTemplateParameter[Uml]): Try[Unit]

  def unlink_TemplateParameter_templateParameter_references_parameteredElement_ParameterableElement
  (from: UMLTemplateSignature[Uml], to: UMLTemplateParameter[Uml]): Try[Unit]

  def link_TemplateParameter_templateParameter_references_default_ParameterableElement
  (from: UMLTemplateSignature[Uml], to: UMLTemplateParameter[Uml]): Try[Unit]

  def unlink_TemplateParameter_templateParameter_references_default_ParameterableElement
  (from: UMLTemplateSignature[Uml], to: UMLTemplateParameter[Uml]): Try[Unit]

  // Namespace

  def link_Namespace_importingNamespace_composes_packageImport_PackageImport
  (from: UMLNamespace[Uml], to: UMLPackageImport[Uml]): Try[Unit]

  def unlink_Namespace_importingNamespace_composes_packageImport_PackageImport
  (from: UMLNamespace[Uml], to: UMLPackageImport[Uml]): Try[Unit]

  def link_Namespace_importingNamespace_composes_elementImport_ElementImport
  (from: UMLNamespace[Uml], to: UMLElementImport[Uml]): Try[Unit]

  def unlink_Namespace_importingNamespace_composes_elementImport_ElementImport
  (from: UMLNamespace[Uml], to: UMLElementImport[Uml]): Try[Unit]

  def link_Namespace_context_composes_ownedRule_Constraint
  (from: UMLNamespace[Uml], to: UMLConstraint[Uml]): Try[Unit]

  def unlink_Namespace_context_composes_ownedRule_Constraint
  (from: UMLNamespace[Uml], to: UMLConstraint[Uml]): Try[Unit]

  // NamedElement

  def link_NamedElement_namedElement_composes_nameExpression_StringExpression
  (from: UMLNamedElement[Uml],
    to: UMLStringExpression[Uml]): Try[Unit]

  def unlink_NamedElement_namedElement_composes_nameExpression_StringExpression
  (from: UMLNamedElement[Uml],
   to: UMLStringExpression[Uml]): Try[Unit]

  def set_NamedElement_name
  (e: UMLNamedElement[Uml], name: Option[String]): Try[Unit]

  def set_NamedElement_visibility
  (e: UMLNamedElement[Uml], visibility: Option[Option[UMLVisibilityKind.Value]]): Try[Unit]

  // OpaqueExpression

  def link_OpaqueExpression_references_behavior_Behavior
  (from: UMLOpaqueExpression[Uml], to: UMLBehavior[Uml]): Try[Unit]

  def unlink_OpaqueExpression_references_behavior_Behavior
  (from: UMLOpaqueExpression[Uml], to: UMLBehavior[Uml]): Try[Unit]

  def set_OpaqueExpression_body
  (e: UMLOpaqueExpression[Uml], body: Seq[String]): Try[Unit]

  def set_OpaqueExpression_language
  (e: UMLOpaqueExpression[Uml], language: Seq[String]): Try[Unit]

  // Profile

  def link_Profile_profile_composes_metamodelReference_PackageImport
  (from: UMLProfile[Uml], to: UMLPackageImport[Uml]): Try[Unit]

  def unlink_Profile_profile_composes_metamodelReference_PackageImport
  (from: UMLProfile[Uml], to: UMLPackageImport[Uml]): Try[Unit]


}
