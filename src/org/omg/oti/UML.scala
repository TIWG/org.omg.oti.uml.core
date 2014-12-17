package org.omg.oti

import scala.util.Try

trait UML {

  type Element
  type NamedElement <: Element
  type Comment <: Element
  type Relationship <: Element
  type DirectedRelationship <: Relationship
  
  type ElementImport <: DirectedRelationship
  type PackageImport <: DirectedRelationship
  type PackageMerge <: DirectedRelationship
  type Generalization <: DirectedRelationship
  type ProfileApplication <: DirectedRelationship
  
  type TypedElement <: NamedElement
  type Feature <: NamedElement
  type BehavioralFeature <: Feature
  type StructuralFeature <: Feature with TypedElement
  type PackageableElement <: NamedElement
  type InstanceSpecification <: PackageableElement  
  type Type <: NamedElement
  type Parameter <: TypedElement
  type ValueSpecification <: TypedElement
  type InstanceValue <: ValueSpecification
  type Package <: PackageableElement
  type Slot <: Element
  
  type Stereotype <: Type
  type Image <: Element
  
}