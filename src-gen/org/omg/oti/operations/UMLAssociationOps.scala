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

// Start of user code for imports
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * <!-- begin-model-doc -->
 * A link is a tuple of values that refer to typed objects.  An Association classifies a set of links, each of which is an instance of the Association.  Each value in the link refers to an instance of the type of the corresponding end of the Association.

 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLAssociationOps[Uml <: UML] { self: UMLAssociation[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Classifiers that are used as types of the ends of the Association.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLType.endType_association
	 * @body result = (memberEnd->collect(type)->asSet())
	 */
	def endType: Set[UMLType[Uml]] = relatedElement.selectByKindOf { case x: UMLType[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * Ends of Associations with more than two ends must be owned by the Association itself.
	 * <!-- end-model-doc -->
	 *
	 * @body memberEnd->size() > 2 implies ownedEnd->includesAll(memberEnd)
	 */
	def validate_association_ends: Boolean  = {
		// Start of user code for "association_ends"
    	if (memberEnd.size > 2) 
        ownedEnd.containsAll(memberEnd)
      else true
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * Only binary Associations can be aggregations.
	 * <!-- end-model-doc -->
	 *
	 * @body memberEnd->exists(aggregation <> AggregationKind::none) implies (memberEnd->size() = 2 and memberEnd->exists(aggregation = AggregationKind::none))
	 */
	def validate_binary_associations: Boolean  = {
		// Start of user code for "binary_associations"
    ??? //needs to be verified
  	if ( memberEnd.exists { me => me.aggregation != UMLAggregationKind.none } ) {
      memberEnd.size == 2 && memberEnd.exists { me => me.aggregation == UMLAggregationKind.none } 
    } else true
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @body memberEnd->forAll(type->notEmpty())
	 */
	def validate_ends_must_be_typed: Boolean  = {
		// Start of user code for "ends_must_be_typed"
  	memberEnd.forall { prop => prop._type match {
      case Some(_) => true
      case None => false
      }
    }
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * An Association specializing another Association has the same number of ends as the other Association.
	 * <!-- end-model-doc -->
	 *
	 * @body parents()->select(oclIsKindOf(Association)).oclAsType(Association)->forAll(p | p.memberEnd->size() = self.memberEnd->size())
	 */
	def validate_specialized_end_number: Boolean  = { 
		// Start of user code for "specialized_end_number"
    ??? //verify which is better
    parents.filter { c => c match {
      case a: UMLAssociation[Uml] => true
      case _ => false
    }}.forall { 
      case a: UMLAssociation[Uml] => a.memberEnd.size == self.memberEnd.size
      case _ => false 
    }
    
    parents.forall {
      case a: UMLAssociation[Uml] => a.memberEnd.size == self.memberEnd.size
      case _ => false
    }
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * When an Association specializes another Association, every end of the specific Association corresponds to an end of the general Association, and the specific end reaches the same type or a subtype of the corresponding general end.
	 * <!-- end-model-doc -->
	 *
	 * @body Sequence{1..memberEnd->size()}->
	 * 	forAll(i | general->select(oclIsKindOf(Association)).oclAsType(Association)->
	 * 		forAll(ga | self.memberEnd->at(i).type.conformsTo(ga.memberEnd->at(i).type)))
	 */
	def validate_specialized_end_types: Boolean  = { ??? //need Assosiation translation and is Seq zero-based?
		// Start of user code for "specialized_end_types"
  	??? //custom conformsTo in UMLOps could not be called for some reason
    (0 until memberEnd.size).forall { i => 
      general.forall { 
        case a: UMLAssociation[Uml] => self.memberEnd(i)._type match {
          case Some(t) => t.conformsTo(a.memberEnd(i)._type)
          case None => false
        }
        case _ => false 
      }
    }
    	// End of user code
	}

	// Start of user code for additional features
  
  def getDirectedAssociationEnd: Option[( UMLProperty[Uml], UMLProperty[Uml] )] =
    memberEnd.toList match {
      case end1 :: end2 :: Nil =>
        ( end1.isLogicallyNavigable, end2.isLogicallyNavigable ) match {
          case ( true, false ) => Some( ( end2, end1 ) )
          case ( false, true ) => Some( ( end1, end2 ) )
          case ( _, _ ) =>
            ( end1.isSemanticallyNavigable, end2.isSemanticallyNavigable ) match {
              case ( true, false ) => Some( ( end2, end1 ) )
              case ( false, true ) => Some( ( end1, end2 ) )
              case ( _, _ )        => None
            }
        }
      case _ => None
    }
  
	// End of user code

} //UMLAssociation
