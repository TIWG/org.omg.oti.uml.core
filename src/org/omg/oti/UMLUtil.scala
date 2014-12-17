package org.omg.oti

import org.eclipse.emf.ecore.xml.`type`.util.XMLTypeUtil
import scala.reflect.ClassTag
import org.eclipse.emf.ecore.EStructuralFeature
import scala.util.Failure
import scala.util.Success
import scala.util.Try
import java.net.URL
import java.net.MalformedURLException
import scala.language.postfixOps

trait UMLUtil[Uml <: UML] { umlops: UMLOps[Uml] =>

  import umlops._

  protected val element2id: Element2IDHashMap

  protected val elementRules: List[Element2IDRule]

  protected val containmentRules: List[ContainedElement2IDRule]

  def getElement2IDMap: Map[Uml#Element, Try[String]] = element2id.toMap
  
  def lookupElementXMI_ID( e: Uml#Element ): Try[Option[String]] =
    element2id.get( e ) match {
      case None                  => Success( None )
      case Some( Failure( t ) )  => Failure( t )
      case Some( Success( id ) ) => Success( Some( id ) )
    }

  def computePackageExtentXMI_ID( pkg: Uml#Package ): Try[Unit] = {
    getAllOwnedElementIterator( pkg ).toStream foreach ( getXMI_ID( _ ) )
    Success( Unit )
  }

  def getXMI_ID( self: Uml#Element ): Try[String] =
    element2id.getOrElseUpdate(
      self,
      {
        val r = elementRules.toStream.dropWhile( ( r: Element2IDRule ) => !r.isDefinedAt( self ) )
        if ( r.nonEmpty ) r.head( self )
        else getElement_owner( self ) match {
          case None => Failure( IllegalElementException( "Element without an owner is not supported", self ) )
          case Some( owner ) =>
            val cf = getContainedElement_eContainingFeature( self )
            cf.getName match {
              case null => Failure( IllegalElementException( "Element container's containing StructuralFeature must be named", self ) )
              case ""   => Failure( IllegalElementException( "Element container's containing StructuralFeature must be named", self ) )
              case _ =>
                getXMI_ID( owner ) match {
                  case Failure( t ) => Failure( t )
                  case Success( ownerID ) =>
                    val c = containmentRules.toStream.dropWhile( ( c: ContainedElement2IDRule ) => !c.isDefinedAt( owner, ownerID, cf, self ) )
                    if ( c.nonEmpty ) c.head( owner, ownerID, cf, self )
                    else Failure( IllegalElementException( "Unsupported", self ) )
                }
            }
        }
      } )

  val rule0: Element2IDRule = {
    case root: Uml#Package if ( hasStereotype( root, OTI_SPECIFICATION_ROOT_S ) ) =>
      getNamedElement_name( root ) match {
        case None      => Failure( IllegalElementException( "OTI::SpecificationRoot-stereotyped Package must be explicitly named", root ) )
        case Some( n ) => Success( n )
      }
  }

  /**
   * Rule #1 (InstanceValue)
   */
  val crule1: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, iv: Uml#InstanceValue ) => getInstanceValue_instance( iv ) match {
      case None => Failure( IllegalElementException( "InstanceValue without InstanceSpecification is not supported", iv ) )
      case Some( is ) =>
        getNamedElement_name( is ) match {
          case None      => Failure( IllegalElementException( "InstanceValue must refer to a named InstanceSpecification", is ) )
          case Some( n ) => Success( ownerID + "_" + xmlSafeID( getContainedElement_eContainingFeature( iv ).getName ) + "." + n )
        }
    }
  }

  /**
   * Rule #1 (NamedElement)
   * case (a): Feature or ValueSpecification
   */
  val crule1a: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, fv @ ( _: Uml#Feature | _: Uml#ValueSpecification ) ) =>
      val fvn = fv.asInstanceOf[Uml#NamedElement]
      val shortID: Try[String] = owner match {
        case s: Uml#Slot =>
          getSlot_definingFeature( s ) match {
            case None => Failure( IllegalElementException( "Slot must have a defining StructuralFeature", s ) )
            case Some( sf ) =>
              val slotValues = getSlot_value( s )
              if ( getStructuralFeature_upper( sf ) > 1 )
                Success( "_" + slotValues.indexOf( fvn ) + "_" + getNamedElement_name( fvn ).getOrElse( "" ) )
              else
                Success( getNamedElement_name( fvn ).getOrElse( "" ) )
          }
        case _ =>
          Success( getNamedElement_name( fvn ).getOrElse( "" ) )
      }
      val suffix1: Try[String] = shortID match {
        case Failure( t )  => Failure( t )
        case Success( "" ) => Success( "" )
        case Success( id ) => Success( "." + xmlSafeID( id ) )
      }
      val suffix2: Try[String] = fv match {
        case bf: Uml#BehavioralFeature =>
          ( suffix1 /: getBehavioralFeature_ownedParameter( bf ) )( ( s, p ) =>
            ( s, getTypedElement_type( p ) ) match {
              case ( Failure( t ), _ ) => Failure( t )
              case ( _, None )         => Failure( IllegalElementException( "Parameter must have a type", p ) )
              case ( Success( s ), Some( t ) ) =>
                getNamedElement_name( t ) match {
                  case None       => Failure( IllegalElementException( "Type must have a name", t ) )
                  case Some( tn ) => Success( s + "_" + xmlSafeID( tn ) )
                }

            } )
        case _ =>
          suffix1
      }
      val suffix3 = ( suffix2, cf.getUpperBound ) match {
        case ( Failure( t ), _ ) => Failure( t )
        case ( Success( "" ), u ) =>
          ( owner, getElement_owner( owner ) ) match {
            case ( s: Uml#Slot, Some( is: Uml#InstanceSpecification ) ) if ( cf == SLOT_VALUE ) =>
              getSlot_definingFeature( s ) match {
                case None =>
                  Failure( IllegalElementException( "Slot must have a defining StructuralFeature", s ) )
                case Some( sf ) =>
                  if ( getStructuralFeature_upper( sf ) == 1 )
                    Success( "" )
                  else {
                    val slotValues = getSlot_value( s )
                    require( slotValues.contains( fv ) )
                    Success( slotValues.indexOf( fv ).toString )
                  }
              }
            case ( _, _ ) =>
              require( u == 1 )
              Success( "" )
          }
        case ( Success( s ), _ ) =>
          Success( s )
      }
      suffix3 match {
        case Failure( t ) => Failure( t )
        case Success( s ) => Success( ownerID + "_" + xmlSafeID( cf.getName ) + s )
      }
  }

  /**
   * Rule #1 (NamedElement)
   * case (b): not Feature, not ValueSpecification
   */
  val crule1b: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, ne: Uml#NamedElement ) =>
      Success( ownerID + "." + xmlSafeID( getNamedElement_name( ne ).getOrElse( "" ) ) )
  }

  /**
   * Rule #2
   */
  val crule2: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, e ) if ( cf.isOrdered && cf.getUpperBound != 1 ) =>
      val values = getElementContainer_eFeatureValue( e, cf ).toList
      require( values.contains( e ) )
      Success( ownerID + "_" + xmlSafeID( cf.getName ) + "." + values.indexOf( e ) )
  }

  /**
   * Rule #3
   */
  val crule3: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, dr: Uml#DirectedRelationship ) =>
      getBinaryDirectedRelationship_target( dr ) match {
        case None => Failure( IllegalElementException( "Binary DirectedRelationship must have a target", dr ) )
        case Some( t ) => getXMI_ID( t ) match {
          case Failure( t )   => Failure( IllegalElementException( s"Binary DirectedRelationship must have a target - ${t}", dr ) )
          case Success( tid ) => Success( ownerID + "._" + xmlSafeID( cf.getName ) + "." + tid )
        }
      }
  }

  /**
   * Rule #4
   */
  val crule4: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, s: Uml#Slot ) =>
      getSlot_definingFeature( s ) match {
        case None => Failure( IllegalElementException( "Slot must have a defining StructuralFeature", s ) )
        case Some( sf ) => getNamedElement_name( sf ) match {
          case None =>
            val sfe: Uml#Element = sf
            Failure( IllegalElementException( "Slot's defining StructuralFeature must be named", sfe ) )
          case Some( sfn ) => Success( ownerID + "." + xmlSafeID( sfn ) )
        }
      }
  }

  /**
   * Rule #5
   */
  val crule5: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, c: Uml#Comment ) =>
      Success( ownerID + "._" + xmlSafeID( cf.getName ) + "." + getCommentOwnerIndex( c ) )
  }

  /**
   * Rule #6
   */
  val crule6: ContainedElement2IDRule = {
    case ( owner, ownerID, cf, i: Uml#Image ) =>
      getImageLocationURL( i ) match {
        case Failure( t )           => Failure( t )
        case Success( locationURL ) => Success( ownerID + "._" + xmlSafeID( cf.getName ) + "." + xmlSafeID( locationURL ) )
      }
  }

  def getImageLocationURL( i: Uml#Image ): Try[String] =
    getImage_location( i ) match {
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

  def xmlSafeID( self: String ): String = self match {
    case null => ""
    case s    => getValidNCName( s ) // xmlSafe( s ).replaceAll( " ", "_" )
  }

  val ESCAPE = Array(
    "%00",
    "%01",
    "%02",
    "%03",
    "%04",
    "%05",
    "%06",
    "%07",
    "%08",
    "%09",
    "%0A",
    "%0B",
    "%0C",
    "%0D",
    "%0E",
    "%0F",
    "%10",
    "%11",
    "%12",
    "%13",
    "%14",
    "%15",
    "%16",
    "%17",
    "%18",
    "%19",
    "%1A",
    "%1B",
    "%1C",
    "%1D",
    "%1E",
    "%1F",
    "%20",
    null,
    "%22",
    "%23",
    null,
    "%25",
    "%26",
    "%27",
    null,
    null,
    null,
    null,
    "%2C",
    null,
    null,
    "%2F",
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    "%3A",
    null,
    "%3C",
    null,
    "%3E",
    null )

  def isNCNameStart( c: Char ): Boolean = XMLTypeUtil.isNCNameStart( c )

  def isNCNamePart( c: Char ): Boolean = XMLTypeUtil.isNCNamePart( c )

  def getValidNCName( name: String ): String = {
    val buff = new StringBuffer()
    getValidNCName( name, buff )
    buff.toString()
  }

  def getValidNCName( name: String, validNCName: StringBuffer ): Unit = {
    if ( null == name || "" == name ) {
      validNCName.insert( 0, '_' )
    }
    else {
      for {
        i <- name.length - 1 until 0 by -1
        char_i = name.charAt( i )
      } {
        if ( isNCNamePart( char_i ) ) {
          validNCName.insert( 0, char_i )
        }
        else if ( char_i < ESCAPE.length ) {
          //val index = char_i
          val escape = ESCAPE( char_i )
          if ( escape != null ) {
            validNCName.insert( 0, escape )
          }
        }
      }
      val char_0 = name.charAt( 0 )
      if ( isNCNameStart( char_0 ) ) {
        validNCName.insert( 0, char_0 )
      }
      else {
        if ( isNCNamePart( char_0 ) ) {
          validNCName.insert( 0, char_0 )
        }
        validNCName.insert( 0, '_' )
      }
    }
  }
}