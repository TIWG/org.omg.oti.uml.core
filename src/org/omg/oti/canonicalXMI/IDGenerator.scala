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
package org.omg.oti.canonicalXMI

import java.net.URL
import java.net.MalformedURLException
import org.eclipse.emf.ecore.xml.`type`.util.XMLTypeUtil
import org.eclipse.emf.ecore.EStructuralFeature
import scala.language.postfixOps
import scala.util.Failure
import scala.util.Success
import scala.util.Try
import org.omg.oti.api._
import org.omg.oti.operations._

trait IDGenerator[Uml <: UML] { 
  
  implicit val umlOps: UMLOps[Uml]
  import umlOps._
  
  import IDGenerator._
  
  val resolvedDocumentSet: ResolvedDocumentSet[Uml]
  
  protected val element2id: Element2IDHashMap

  protected val elementRules: List[Element2IDRule]

  protected val containmentRules: List[ContainedElement2IDRule]
  
  def getElement2IDMap: Map[UMLElement[Uml], Try[String]] = element2id.toMap

  def lookupElementXMI_ID( e: UMLElement[Uml] ): Try[Option[String]] =
    element2id.get( e ) match {
      case None                  => Success( None )
      case Some( Failure( t ) )  => Failure( t )
      case Some( Success( id ) ) => Success( Some( id ) )
    }

  /**
   * Computes the xmi:ID for each element in the domain of the element2document map of the ResolvedDocumentSet
   */
  def computePackageExtentXMI_ID( pkg: UMLPackage[Uml] ): Try[Unit] = {
    pkg.allOwnedElements filter (resolvedDocumentSet.element2document.contains(_)) foreach ( getXMI_ID( _ ) )
    Success( Unit )
  }
   protected def getXMI_IDREF_or_HREF_fragment( from: UMLElement[Uml], to: UMLElement[Uml] ): Try[String] =
    getXMI_IDREF_or_HREF_fragment_internal( from, to ) match {
    case Success( fragment ) => Success( fragment )
    case Failure( _ ) => getXMI_IDREF_or_HREF_fragment( from, getMappedOrReferencedElement( to ) )
  }
    
  protected def getXMI_IDREF_or_HREF_fragment_internal( from: UMLElement[Uml], to: UMLElement[Uml] ): Try[String] =
    ( resolvedDocumentSet.element2document.get( from ),
      resolvedDocumentSet.element2document.get( to ) ) match {
    case ( None, _ ) => 
      Failure( illegalElementException( "Unknown document for element reference from", from ) )

    case ( _, None ) => 
      Failure( illegalElementException( "Unknown document for element reference to", to) )

    case ( Some( d1 ), Some( d2: BuiltInDocument[Uml] ) ) =>
      require( d1 != d2 )
      // Based on the built-in 'to' element ID, construct the built-in URI for the 'to' element.
      val builtInURITo = d2.documentURL.resolve("#"+to.id).toString
      // use the builtInURIMapper to convert the built-in URI of the 'to' element into an OMG URI
      val mappedURITo = resolvedDocumentSet.ds.builtInURIMapper.resolve( builtInURITo ).getOrElse( builtInURITo )
      val fragmentIndex = mappedURITo.lastIndexOf('#')
      require( fragmentIndex > 0)
      
      // It's not needed to add the prefix since it's already included in the computed ID
      val fragment = xmlSafeID( /*d2.nsPrefix+"."+*/mappedURITo.substring(fragmentIndex+1) )
      Success( xmlSafeID( fragment ) )
     
    case ( Some( d1 ), Some( d2: SerializableDocument[Uml] ) ) =>
      if ( d1 == d2 ) getXMI_ID( getMappedOrReferencedElement( to ) )        
      else (for { 
        id <- getXMI_ID( getMappedOrReferencedElement( to ) ) 
        // It's not needed to add the prefix since it's already included in the computed ID
        fragment = xmlSafeID( /*d2.nsPrefix+"."+*/id )
      } yield fragment)
  }

  /**
   * @param ref A referenced element.
   * @return ref or the result of mapping ref according to a particular UML tool.
   *
   * Example: for OMG SysML 1.4, the MD model of OMG SysML 1.4 defines
   * the SYsML profile with a metamodel reference import to a fake OMG UML 2.5 metamodel.
   * This is necessary to make the diagrams for the OMG SysML 1.4 spec.
   * However, for exporting the OMG SysML 1.4 canonical XMI from the MD model,
   * it is necessary to map the fake MD OMG UML 2.5 metamodel to
   * the genuine OMG UML 2.5 metamodel.
   *
   * The default implementation is to return ref (i.e., no mapping).
   */
  def getMappedOrReferencedElement( ref: UMLElement[Uml] ): UMLElement[Uml] = ref
  
  def getXMI_ID( self: UMLElement[Uml] ): Try[String] =
    element2id.getOrElseUpdate(
      self,
      {
        resolvedDocumentSet.element2document.get( self ) match {
          case None => 
            Failure( illegalElementException( "Unknown document for element reference ", self ) )
            
          case Some(d: BuiltInDocument[Uml]) => builtInID(self)
           
          case Some(d: SerializableDocument[Uml]) => 
            /* Implement a temporary workaround to deal with ID duplication in UML2.5
             * 
             */
            computeID(self) match {
              case Success(s) =>
                self match {
                  case pi: UMLPackageImport[Uml] =>
                    if (s.endsWith("._0"))
                      Success(s +"-"+pi.importedPackage.get.name.get)
                    else
                      Success(s)
                      
                  case _ => Success(s)
                }
                
              case Failure(t) =>
                Failure(t)
            } 
          
          case Some(d) =>
            Failure( illegalElementException( "Unknown document kind for element reference ", self ))
        }
      } )

  def computeID( self: UMLElement[Uml] ): Try[String] = {
    val r = elementRules.toStream.dropWhile( ( r: Element2IDRule ) => !r.isDefinedAt( self ) )
    if ( r.nonEmpty ) r.head( self )
    else self.owner match {
      case None => Failure( illegalElementException( "Element without an owner is not supported", self ) )
      case Some( owner ) =>
        val cf = self.getContainedElement_eContainingFeature
        cf.getName match {
          case null => Failure( illegalElementException( "Element container's containing StructuralFeature must be named", self ) )
          case ""   => Failure( illegalElementException( "Element container's containing StructuralFeature must be named", self ) )
          case _ =>
            getXMI_ID( owner ) match {
              case Failure( t ) => Failure( t )
              case Success( ownerID ) =>
                val c = containmentRules.toStream.dropWhile( ( c: ContainedElement2IDRule ) => !c.isDefinedAt( owner, ownerID, cf, self ) )
                if ( c.nonEmpty ) c.head( owner, ownerID, cf, self )
                else Failure( illegalElementException( "Unsupported", self ) )
            }
        }
    }
  }
  
  /* the builtInID method is intended to provide the xmi:id as serialized in the file,
  * as opposed to as computed by the IDGenerator.computeID
  * Implementation is tool specific  
  */
  def builtInID( self: UMLElement[Uml] ): Try[String] = ???


  val rule0: Element2IDRule = {
    case root: UMLPackage[Uml] if ( resolvedDocumentSet.lookupDocumentByScope(root).isDefined
        // Adding condition for stopping the ID computation algorithm when a specification root is reached
        || root.isSpecificationRoot) =>
      root.name match {
        case None      => Failure( illegalElementException( "Document package scope must be explicitly named", root ) )
        case Some( n ) => Success( xmlSafeID(n) )
      }
  }

  /**
   * Rule #1 (InstanceValue)
   */
  val crule1: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, iv: UMLInstanceValue[Uml] ) => iv.instance match {
      case None => Failure( illegalElementException( "InstanceValue without InstanceSpecification is not supported", iv ) )
      case Some( is ) =>
        is.name match {
          case None      => Failure( illegalElementException( "InstanceValue must refer to a named InstanceSpecification", is ) )
          case Some( n ) => Success( ownerID + "_" + xmlSafeID( iv.getContainedElement_eContainingFeature.getName + "." + n ) )
        }
    }
  }

  /**
   * Rule #1 (NamedElement)
   * case (a): Feature or ValueSpecification
   */
  val crule1a: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, fv @ ( _: UMLFeature[Uml] | _: UMLValueSpecification[Uml] ) ) =>
      val fvn = fv.asInstanceOf[UMLNamedElement[Uml]]
      val shortID: Try[String] = owner match {
        case s: UMLSlot[Uml] =>
          s.definingFeature match {
            case None => Failure( illegalElementException( "Slot must have a defining StructuralFeature", s ) )
            case Some( sf ) =>
              val slotValues = s.value.toList
              if ( sf.upper > 1 )
                Success( "_" + slotValues.indexOf( fvn ) + "_" + fvn.name.getOrElse( "" ) )
              else
                Success( fvn.name.getOrElse( "" ) )
          }
        case _ =>
          Success( fvn.name.getOrElse( "" ) )
      }
      val suffix1: Try[String] = shortID match {
        case Failure( t )  => Failure( t )
        case Success( "" ) => Success( "" )
        case Success( id ) => Success( "." + xmlSafeID( id ) )
      }
      val suffix2: Try[String] = fv match {
        case bf: UMLBehavioralFeature[Uml] =>
          ( suffix1 /: bf.ownedParameter )( ( s, p ) =>
            ( s, p._type ) match {
              case ( Failure( t ), _ ) => Failure( t )
              case ( _, None )         => Failure( illegalElementException( "Parameter must have a type", p ) )
              case ( Success( s ), Some( t ) ) =>
                t.name match {
                  case None       => Failure( illegalElementException( "Type must have a name", t ) )
                  case Some( tn ) => Success( s + "_" + xmlSafeID( tn ) )
                }

            } )
        case _ =>
          suffix1
      }
      val suffix3 = ( suffix2, cf.getUpperBound ) match {
        case ( Failure( t ), _ ) => Failure( t )
        case ( Success( "" ), u ) =>
          ( owner, owner.owner ) match {
            case ( s: UMLSlot[Uml], Some( is: UMLInstanceSpecification[Uml] ) ) if ( cf == SLOT_VALUE ) =>
              s.definingFeature match {
                case None =>
                  Failure( illegalElementException( "Slot must have a defining StructuralFeature", s ) )
                case Some( sf ) =>
                  if ( sf.upper == 1 )
                    Success( "" )
                  else {
                    val slotValues = s.value.toList
                    require( slotValues.contains( fv ) )
                    Success( slotValues.indexOf( fv ).toString )
                  }
              }
            case ( o1, o2 ) =>
              require( u == 1, s" o1=${o1.id}, o2=${o2.get.id} / o1=${getXMI_ID(o1).get}, o2=${getXMI_ID(o2.get).get}" )
              Success( "" )
          }
        case ( Success( s ), _ ) =>
          Success( s )
      }
      suffix3 match {
        case Failure( t ) => Failure( t )
        case Success( s ) => Success( ownerID + "_" + xmlSafeID( cf.getName + s ) )
      }
  }

  /**
   * Rule #1 (NamedElement)
   * case (b): not Feature, not ValueSpecification
   */
  val crule1b: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, ne: UMLNamedElement[Uml] ) =>
      Success( ownerID + "." + xmlSafeID( ne.metaclass_name ) + "_" + xmlSafeID( ne.name.getOrElse( "" ) ) )
  }

  /**
   * Rule #2:  any Element on which Rule#1 does not apply and which is owned as an ordered set
   */
  val crule2: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, e ) if ( cf.isOrdered && cf.getUpperBound != 1 ) =>
      val values = e.getElementContainer_eFeatureValue( cf ).toList
      require( values.contains( e ) )
      Success( ownerID + "_" + xmlSafeID( cf.getName ) + "." + values.indexOf( e ) )
  }

  /**
   * Rule #3: any Element on which Rule#2 does not apply and which is a DirectedRelationship
   */
  val crule3: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, dr: UMLDirectedRelationship[Uml] ) =>
      dr.target.toList match {
        case List( t ) => getXMI_IDREF_or_HREF_fragment( owner, t ) match {
          case Failure( t )   => Failure( illegalElementException( s"Binary DirectedRelationship must have a target - ${t}", dr ) )
          case Success( tid ) => Success( ownerID + "._" + xmlSafeID( cf.getName ) + "." + tid )
        }
        case _ => Failure( illegalElementException( "Binary DirectedRelationship must have a target", dr ) )
      }
  }

  /**
   * Rule #4: any Element on which Rule#3 does not apply and which is a uml::Slot
   */
  val crule4: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, s: UMLSlot[Uml] ) =>
      s.definingFeature match {
        case None => Failure( illegalElementException( "Slot must have a defining StructuralFeature", s ) )
        case Some( sf ) => sf.name match {
          case None        => Failure( illegalElementException( "Slot's defining StructuralFeature must be named", sf ) )
          case Some( sfn ) => Success( ownerID + "." + xmlSafeID( sfn ) )
        }
      }
  }

  /**
   * Rule #5: any Element on which Rule#4 does not apply and which is uml::Comment
   */
  val crule5: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, c: UMLComment[Uml] ) =>
      Success( ownerID + "._" + xmlSafeID( cf.getName ) + "." + c.getCommentOwnerIndex )
  }

  /**
   * Rule #6: any Element on which Rule#5 does not apply and which is uml::Image
   */
  val crule6: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, i: UMLImage[Uml] ) =>
      getImageLocationURL( i ) match {
        case Failure( t )           => Failure( t )
        case Success( locationURL ) => Success( ownerID + "._" + xmlSafeID( cf.getName ) + "." + xmlSafeID( locationURL ) )
      }
  }

  def getImageLocationURL( i: UMLImage[Uml] ): Try[String] =
    i.location match {
      case None =>
        Failure( new IllegalArgumentException( "An Image must have a non-null location URL" ) )
      case Some( loc ) =>
        try {
          val url = new URL( loc ) toString;
          Success( getValidNCName( url ) )
        }
        catch {
          case t: MalformedURLException =>
            Failure( t )
          case t: Throwable =>
            Failure( t )
        }
    }
  
  def checkIDs(): Boolean = {
    val id2Element = scala.collection.mutable.HashMap[String, UMLElement[Uml]]()
    var res : Boolean = true

    println("\n>>> IDs Checking...")
      
    getElement2IDMap foreach { case (e1,id) => id match {    
      case Failure(t) => 
        println(s"***ID computation failed for ${e1.toWrappedObjectString}")
        println("\tCause: "+t.getCause)
        println("---------------------------")
        res = false
        
        case Success(x) =>  id2Element.get(x) match {
          case None => id2Element.update(x, e1)
            
          case Some (e2) => 
            println(s"*** Duplicate ID: $x")
            println(s"\t-> ${e1.toWrappedObjectString}")           
            println(s"\t-> ${e2.toWrappedObjectString}")
            println("---------------------------")
            res = false
        } // duplicate id check
      } // Failure check
    } // foreach    
    println("<<<... IDs Checked\n")
    res
  } // end CheckIds
  
  def listIDs(): Unit = {
    println(s"element2id size=${element2id.size}")
    for ((x, id) <- element2id) {
      val idStr = id match {
         case Success(s) => id.get
           
         case Failure(t) => 
           println("***Fail!***")
           t.toString()
      } 
      x match {
        case ne: UMLNamedElement[Uml] => 
          val nameStr = ne.name match {
            case Some(n) => n
            case None => "(unamed)"
          }
          println("<" + ne.mofMetaclassName + ">" + nameStr + "\t=> ID: " + idStr)

        case e: UMLElement[Uml] => println("<" + e.mofMetaclassName + ">\t=> ID: " + idStr)
}
    }
  }

}

object IDGenerator {
  
  def xmlSafeID( self: String ): String = self match {
    case null => ""
    case s    => getValidNCName( s )
  }

  /**
   * @see org.eclipse.uml2.common.util.UML2Util.isNCNamePart(char)
   */
  def isNCNameStart( c: Char ): Boolean = XMLTypeUtil.isNCNameStart( c )

  /**
   * @see org.eclipse.uml2.common.util.UML2Util.isNCNamePart(char)
   */
  def isNCNamePart( c: Char ): Boolean = XMLTypeUtil.isNCNamePart( c )

  /**
   * @see org.eclipse.uml2.common.util.UML2Util.getValidNCName(String)
   */
  def getValidNCName( name: String ): String = {
    val buff = new StringBuffer()
    getValidNCName( name, buff )
    buff.toString()
  }

  /**
   * @see org.eclipse.uml2.common.util.UML2Util.getValidNCName(String, StringBuffer)
   * @see org.eclipse.uml2.uml.util.UMLUtil.Ecore2UMLConverter.escapeString(String, String)
   */
  def getValidNCName( name: String, validNCName: StringBuffer ): Unit = {

    def escapeChar( char: Char ) = {
      val charCode = char.toInt.toHexString.toUpperCase
      val charCodeLength = charCode.length
      if ( charCodeLength == 1 ) "_u000" + charCode
      else if ( charCodeLength == 2 ) "_u00" + charCode
      else if ( charCodeLength == 3 ) "_u0" + charCode
      else "_u" + charCode
    }

    if ( null == name || "" == name ) validNCName.insert( 0, '_' )
    else {
      for {
        i <- name.length - 1 until 0 by -1
        char_i = name.charAt( i )
      } {
        if ( char_i == ' ') validNCName.insert( 0, '_' )
        else if ( isNCNamePart( char_i ) ) validNCName.insert( 0, char_i )
        else validNCName.insert( 0, escapeChar( char_i ) )
      }
      val char_0 = name.charAt( 0 )
      if ( isNCNameStart( char_0 ) ) validNCName.insert( 0, char_0 )
      else {
        if ( isNCNamePart( char_0 ) ) validNCName.insert( 0, char_0 )
        else validNCName.insert( 0, escapeChar( char_0 ) )
        validNCName.insert( 0, '_' )
      }
    }
  }
  
  def computeStereotypeApplicationID (eID: String, stID: String) = eID+".stereotypeApplication_"+stID
  
  def uuidFromId (id: Option[String]): Option[String] = id match {
    case Some(s) => Some(uuidFromId(s))
    case None => None
  } 
  
  def uuidFromId (id: String): String = "omg.org."+id

}