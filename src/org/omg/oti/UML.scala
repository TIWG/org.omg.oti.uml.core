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

trait UML {

  // Figure 7.1
  
  type Element
  type Comment <: Element
  type Relationship <: Element
  type DirectedRelationship <: Relationship
  
  // Figure 7.5
  
  type NamedElement <: Element
  type Namespace <: NamedElement
  
  type ElementImport <: DirectedRelationship
  type PackageImport <: DirectedRelationship
  type PackageableElement <: NamedElement
  
  // Figure 7.10
  
  type Type <: PackageableElement
  type TypedElement <: NamedElement
  type MultiplicityElement <: Element
  
  // Figure 7.13
  
  type Constraint <: PackageableElement
  
  // Figure 7.17
  
  type Dependency <: DirectedRelationship with PackageableElement
  
  // Figure 8.1
  
  type ValueSpecification <: PackageableElement with TypedElement
  type LiteralSpecification <: ValueSpecification
  type LiteralNull <: LiteralSpecification
  type LiteralBoolean <: LiteralSpecification
  type LiteralInteger <: LiteralSpecification
  type LiteralReal <: LiteralSpecification
  type LiteralString <: LiteralSpecification
  type LiteralUnlimitedNatural <: LiteralSpecification
  
  // Figure 8.2
  
  type Expression <: ValueSpecification
  type StringExpression <: Expression
  type OpaqueExpression <: ValueSpecification
  
  // FIgure 8.4
  
  type Interval <: ValueSpecification
  
  // Figure 9.1
    
  type Classifier <: Namespace with Type
  type Generalization <: DirectedRelationship
  type RedefinableElement <: NamedElement
  
  // Figure 9.9
  
  type Feature <: RedefinableElement
  type StructuralFeature <: Feature with TypedElement with MultiplicityElement
  type BehavioralFeature <: Feature with Namespace
  
  type ConnectableElement <: TypedElement
  type Parameter <: ConnectableElement with MultiplicityElement
  
  // Figure 9.10
  
  type Property <: StructuralFeature with ConnectableElement
  
  // Figure 9.13
  
  type Operation <: BehavioralFeature
  
  // Figure 9.27
   
  type InstanceSpecification <: PackageableElement
  type Slot <: Element
  type InstanceValue <: ValueSpecification
  
  // Figure 10.1
  
  type DataType <: Classifier
  type PrimitiveType <: DataType
  type Enumeration <: DataType
  type EnumerationLiteral <: InstanceSpecification
  
  // Figure 10.7
  
  type BehavioredClassifier <: Classifier
  
  // Figure 11.1
  
  type StructuredClassifier <: Classifier
  type Connector <: Feature
  type ConnectorEnd <: MultiplicityElement
  
  // Figure 11.10
  
  type EncapsulatedClassifier <: StructuredClassifier
  type Port <: Property
  
  // Figure 11.15
  
  type Class <: EncapsulatedClassifier with BehavioredClassifier
  
  // Figure 11.25
  
  type Association <: Classifier with Relationship
  type AssociationClass <: Class with Association
  
  // Figure 12.1
  
  type Package <: Namespace with PackageableElement  
  type PackageMerge <: DirectedRelationship
  
  // Figure 12.12
  
  type Profile <: Package
  type ProfileApplication <: DirectedRelationship
  type Stereotype <: Class
  type Extension <: Association
  type ExtensionEnd <: Property
  type Image <: Element
  
  // Figure 18.1
  
  type Actor <: BehavioredClassifier
  type UseCase <: BehavioredClassifier
  
}