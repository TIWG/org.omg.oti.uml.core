package org.omg.oti

import scala.reflect.ClassTag
import org.eclipse.emf.ecore.EStructuralFeature
import scala.util.Try

trait UMLOps[Uml <: UML] {

  implicit val tag0: ClassTag[Uml#Element]
  implicit val tag1: ClassTag[Uml#NamedElement]
  implicit val tag2: ClassTag[Uml#Comment]
  implicit val tag3: ClassTag[Uml#Relationship]
  implicit val tag4: ClassTag[Uml#DirectedRelationship]
  implicit val tag5: ClassTag[Uml#ElementImport]
  implicit val tag6: ClassTag[Uml#PackageImport]
  implicit val tag7: ClassTag[Uml#PackageMerge]
  implicit val tag8: ClassTag[Uml#Generalization]
  implicit val tag9: ClassTag[Uml#ProfileApplication]
  implicit val tag10: ClassTag[Uml#Feature]
  implicit val tag11: ClassTag[Uml#BehavioralFeature]
  implicit val tag12: ClassTag[Uml#StructuralFeature]
  implicit val tag13: ClassTag[Uml#PackageableElement]
  implicit val tag14: ClassTag[Uml#InstanceSpecification]
  implicit val tag15: ClassTag[Uml#TypedElement]
  implicit val tag16: ClassTag[Uml#Type]
  implicit val tag17: ClassTag[Uml#Parameter]
  implicit val tag18: ClassTag[Uml#ValueSpecification]
  implicit val tag19: ClassTag[Uml#InstanceValue]
  implicit val tag20: ClassTag[Uml#Package]
  implicit val tag21: ClassTag[Uml#Slot]
  implicit val tag22: ClassTag[Uml#Stereotype]
  implicit val tag23: ClassTag[Uml#Image]
    
  type Element2IDHashMap = scala.collection.mutable.HashMap[Uml#Element, Try[String]]
  
  type Element2IDRule = PartialFunction[Uml#Element, Try[String]]
  type ContainedElement2IDRule = PartialFunction[(Uml#Element, String, EStructuralFeature, Uml#Element), Try[String]]
  
  val OTI_SPECIFICATION_ROOT_S: Uml#Stereotype
  
  def getElementID( e: Uml#Element ): String
  def hasStereotype( e: Uml#Element, s: Uml#Stereotype ): Boolean

  def getAllOwnedElementIterator( e: Uml#Element ): Iterator[Uml#Element]
  
  def getContainedElement_eContainingFeature( e: Uml#Element ): EStructuralFeature
  val SLOT_VALUE: EStructuralFeature
  
  def getElement_owner( e: Uml#Element ): Option[Uml#Element]
  def getElementContainer_eFeatureValue( e: Uml#Element, f: EStructuralFeature ): Iterable[Uml#Element]
  
  def getCommentOwnerIndex( c: Uml#Comment ): Int
  
  def getNamedElement_name( ne: Uml#NamedElement ): Option[String]
  def isNamedElement_named( ne: Uml#NamedElement ): Boolean = getNamedElement_name( ne ).isDefined
  
  def getBinaryDirectedRelationship_target( dr: Uml#DirectedRelationship ): Option[Uml#Element]
  
  def getImage_location( i: Uml#Image ): Option[String]
  
  def getSlot_value( s: Uml#Slot ): List[Uml#ValueSpecification]
  def getSlot_definingFeature( s: Uml#Slot ): Option[Uml#StructuralFeature]
  def getStructuralFeature_upper( sf: Uml#StructuralFeature ): Int
  
  def getInstanceValue_instance( iv: Uml#InstanceValue ): Option[Uml#InstanceSpecification]
  
  def getBehavioralFeature_ownedParameter( bf: Uml#BehavioralFeature ): List[Uml#Parameter]
  def getTypedElement_type( te: Uml#TypedElement ): Option[Uml#Type]
  
}