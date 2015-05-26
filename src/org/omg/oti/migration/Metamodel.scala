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
// TODO: Move to a different project to avoid adding a dependency on org.eclipse.emf.ecore in OTI.
// This dependency would unecessarily create confusion about the tool-neutrality of OTI,
// particularly w.r.t. Eclipse EMF-based UML implementations.

///*
// *
// *  License Terms
// *
// *  Copyright (c) 2015, California Institute of Technology ("Caltech").
// *  U.S. Government sponsorship acknowledged.
// *
// *  All rights reserved.
// *
// *  Redistribution and use in source and binary forms, with or without
// *  modification, are permitted provided that the following conditions are
// *  met:
// *
// *
// *   *   Redistributions of source code must retain the above copyright
// *       notice, this list of conditions and the following disclaimer.
// *
// *   *   Redistributions in binary form must reproduce the above copyright
// *       notice, this list of conditions and the following disclaimer in the
// *       documentation and/or other materials provided with the
// *       distribution.
// *
// *   *   Neither the name of Caltech nor its operating division, the Jet
// *       Propulsion Laboratory, nor the names of its contributors may be
// *       used to endorse or promote products derived from this software
// *       without specific prior written permission.
// *
// *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
// *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
// *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
// *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
// *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
// *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
// *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
// *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
// *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
// *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
// *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
// */
//package org.omg.oti.migration
//
//import java.io.File
//import org.eclipse.emf.ecore.resource.ResourceSet
//import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
//import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
//import org.eclipse.emf.common.util.URI
//import org.eclipse.emf.ecore.EPackage
//import org.eclipse.emf.ecore.EClass
//import org.eclipse.emf.ecore.EObject
//import org.eclipse.emf.ecore.EReference
//import org.eclipse.emf.ecore.EAttribute
//import org.eclipse.emf.common.util.EList
//import scala.collection.JavaConversions._
//import scala.language.postfixOps
//import scala.reflect.ClassTag
//import scala.util.Try
//import scala.util.Failure
//import scala.util.Success
//
//case class Metamodel( val otiDir: File, val rs: ResourceSet = new ResourceSetImpl() ) {
//
//  val migrationMMFile = new File( otiDir, "models/Migration.ecore" )
//  require( migrationMMFile.exists && migrationMMFile.canRead )
//
//  if ( !rs.getResourceFactoryRegistry.getExtensionToFactoryMap.containsKey( "ecore" ) )
//    rs.getResourceFactoryRegistry.getExtensionToFactoryMap.put( "ecore", new XMIResourceFactoryImpl() )
//
//  val migrationMMURI = URI.createFileURI( migrationMMFile.getAbsolutePath )
//  val migrationMMR = rs.createResource( migrationMMURI )
//  migrationMMR.load( null )
//
//  val migrationMMPkg = migrationMMR.getContents.get( 0 ).asInstanceOf[EPackage]
//  val migrationMMPkgURI = migrationMMPkg.getNsURI
//
//  if ( !rs.getPackageRegistry.containsKey( migrationMMPkgURI ) )
//    rs.getPackageRegistry.put( migrationMMPkgURI, migrationMMPkg )
//
//  val migrationMMFactory = migrationMMPkg.getEFactoryInstance
//
//  val Old2NewIDMappingClass = migrationMMPkg.getEClassifier( "Old2NewIDMapping" ).asInstanceOf[EClass]
//  val Old2NewIDMapping_entries = Old2NewIDMappingClass.getEStructuralFeature( "entries" ).asInstanceOf[EReference]
//  val Old2NewIDMapping_modelIdentifier = Old2NewIDMappingClass.getEStructuralFeature( "modelIdentifier" ).asInstanceOf[EAttribute]
//
//  val Old2NewIDEntryClass = migrationMMPkg.getEClassifier( "Old2NewIDEntry" ).asInstanceOf[EClass]
//  val Old2NewIDEntry_old = Old2NewIDEntryClass.getEStructuralFeature( "old" ).asInstanceOf[EAttribute]
//  val Old2NewIDEntry_new = Old2NewIDEntryClass.getEStructuralFeature( "new" ).asInstanceOf[EAttribute]
//
//  def loadOld2NewIDMappingResource( uri: URI ): Try[Old2NewIDMapping] =
//    try {
//      val r = rs.getResource( uri, true )
//      val contents = r.getContents
//      if ( contents.isEmpty() )
//        Failure( new IllegalArgumentException( s"Empty model: '${uri}'" ) )
//      val top = contents.get( 0 )
//      if ( top.eClass != Old2NewIDMappingClass )
//        Failure( new IllegalArgumentException( s"Not a Migration model: '${uri}'" ) )
//
//      Success( new Old2NewIDMapping( top )( this ) )
//    }
//    catch {
//      case t: Throwable => Failure( t )
//    }
//
//  def makeOld2NewIDMapping( modelIdentifier: String ): Old2NewIDMapping = {
//    val mapping = new Old2NewIDMapping( migrationMMFactory.create( Old2NewIDMappingClass ) )( this )
//    mapping.setModelIdentifier( modelIdentifier )
//    mapping
//  }
//
//  def makeOld2NewIDEntry: Old2NewIDEntry =
//    new Old2NewIDEntry( migrationMMFactory.create( Old2NewIDEntryClass ) )( this )
//
//}
//
//class Old2NewIDMapping( val eObject: EObject )( implicit migrationMM: Metamodel ) {
//
//  import migrationMM._
//
//  def getModelIdentifier: Option[String] =
//    eObject.eGet( Old2NewIDMapping_modelIdentifier ) match {
//      case id: String => Some( id )
//      case _          => None
//    }
//
//  def setModelIdentifier( modelIdentifier: String ) =
//    eObject.eSet( Old2NewIDMapping_modelIdentifier, modelIdentifier )
//
//  def getEntries: List[Old2NewIDEntry] = eObject.eGet( Old2NewIDMapping_entries ) match {
//    case xs: EList[_] => xs flatMap {
//      case x: EObject if ( x.eClass == Old2NewIDEntryClass ) => Some( new Old2NewIDEntry( x ) )
//      case _ => None
//    } toList
//
//    case _ => List()
//  }
//
//  def addEntry( entry: Old2NewIDEntry ) = eObject.eGet( Old2NewIDMapping_entries ) match {
//    case l: EList[_] => l.asInstanceOf[EList[EObject]].add( entry.eObject )
//    case null        => eObject.eSet( Old2NewIDMapping_entries, entry.eObject )
//  }
//}
//
//class Old2NewIDEntry( val eObject: EObject )( implicit migrationMM: Metamodel ) {
//
//  import migrationMM._
//
//  def getOldID: Option[String] = eObject.eGet( Old2NewIDEntry_old ) match {
//    case s: String => Some( s )
//    case _         => None
//  }
//
//  def setOldID( id: String ) = eObject.eSet( Old2NewIDEntry_old, id )
//
//  def getNewID: Option[String] = eObject.eGet( Old2NewIDEntry_new ) match {
//    case s: String => Some( s )
//    case _         => None
//  }
//
//  def setNewID( id: String ) = eObject.eSet( Old2NewIDEntry_new, id )
//
//}