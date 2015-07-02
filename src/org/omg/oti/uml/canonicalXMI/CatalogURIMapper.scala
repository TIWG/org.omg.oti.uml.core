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
package org.omg.oti.uml.canonicalXMI

import java.io.File
import java.io.IOException
import java.net.MalformedURLException
import java.net.URI
import java.net.URL
import scala.util.Failure
import scala.util.Success
import scala.util.Try
import org.apache.xml.resolver.Catalog
import org.apache.xml.resolver.CatalogManager
import org.apache.xml.resolver.tools.CatalogResolver
import java.io.FileNotFoundException

case class CatalogURIMapper( catalogManager: CatalogManager, catalogResolver: CatalogResolver, catalog: Catalog ) {

  def this( catalogManager: CatalogManager, catalogResolver: CatalogResolver ) =
    this( catalogManager, catalogResolver, catalogResolver.getCatalog )

  def this( catalogManager: CatalogManager ) =
    this( catalogManager, new CatalogResolver( catalogManager ) )

  def parseCatalog( catalogURI: URI ): Try[Unit] =
    try {
      catalog.parseCatalog( catalogURI.toURL )
      Success( Unit )
    }
    catch {
      case e: IOException => Failure( e )
    }

  def loadResolutionStrategy( resolved: String ): Option[URI] = {

    def ignore( e: Exception ) = {}

    val normalized = new URI( resolved )
    val normalizedPath = normalized.toString

    val f1 = new URL( normalizedPath )
    val f2 = if ( normalizedPath.endsWith( ".owl" ) ) f1 else new URL( normalizedPath + ".owl" )
    try {
      for {
        is <- Option.apply( f2.openStream )
        if is.available() > 0
      } {
        is.close()
        return Some( f2.toURI )
      }
    }
    catch {
      case e: IOException => ignore( e )
      // try another variant.
    }
    try {
      for {
        is <- Option.apply( f1.openStream() )
        if is.available() > 0
      } {
        is.close()
        return Some( f1.toURI )
      }
    }
    catch {
      case e: IOException => ignore( e )
      // try another variant.
    }
    None
  }

  def saveResolutionStrategy( resolved: String ): Option[URI] = {
    val normalized = new URI( resolved )
    val normalizedPath = normalized.toString
    val f1 = new URL( normalizedPath )
    val outputFile =
      if ( resolved.startsWith( "file:" ) ) new File( resolved.substring( 5 ) )
      else new File( resolved )
    outputFile.getParentFile match {
      case null => None
      case outputDir =>
        if ( !outputDir.exists )
          outputDir.mkdirs

        if ( outputDir.exists && outputDir.isDirectory && outputDir.canWrite )
          Some( f1.toURI )
        else
          None
    }
  }

  def resolve( uri: String ): Option[String] =
    catalog.resolveURI( uri ) match {
    case null => None
    case resolved => Some( resolved )
  }
  
  def resolveURI( uri: URI, resolutionStrategy: ( String ) => Option[URI] ): Try[Option[URI]] = {

    def ignore( e: Exception ) = {}

    val rawPath = uri.toString
    val iriPath = if ( rawPath.endsWith( "#" ) ) rawPath.substring( 0, rawPath.length() - 1 ) else rawPath
    try {
      resolve( iriPath ) match {
        case None =>
          Success( None )
        case Some( resolved ) =>
          resolutionStrategy( resolved ) match {
            case None                => Success( None )
            case Some( resolvedURI ) => Success( Some( resolvedURI ) )
          }
      }
    }
    catch {
      case t: MalformedURLException => Failure( t )
      case t: IOException           => Failure( t )
    }
  }
}

object CatalogURIMapper {

  /**
   *
   * @deprecated Use instead createMapperFromCatalogFiles
   * @param catalogFiles
   * @param verbosity
   * @return
   */
  @deprecated
  def createCatalogURIMapper( catalogFiles: Seq[File], verbosity: Int = 0 ): Try[CatalogURIMapper] =
    createMapperFromCatalogFiles( catalogFiles, verbosity )

    /**
   * Creates a CatalogURIMapper from Catalog files.
   *
   * @param catalogFiles
   * @param verbosity
   * @return
   */
  def createMapperFromCatalogFiles( catalogFiles: Seq[File], verbosity: Int = 0 ): Try[CatalogURIMapper] = {
    val catalog = new CatalogManager() 
    catalog.setUseStaticCatalog(false)
    catalog.setRelativeCatalogs(true)
    catalog.setVerbosity(verbosity)
    val mapper = new CatalogURIMapper( catalog )
    catalogFiles.foreach { catalogFile => 
      if ( ! catalogFile.exists ) return Failure( new FileNotFoundException( catalogFile.getAbsolutePath ))
      else mapper.parseCatalog(catalogFile.toURI) match {
        case Failure( t ) => return Failure( t )
        case Success( _ ) => ()
      }
    }
      
    Success( mapper )
  }

  /**
   * Creates a CatalogURIMapper from Catalog file URIs
   *
   * @param catalogURIs URIs of the Catalog files
   * @param verbosity
   * @return
   */
  def createMapperFromCatalogURIs( catalogURIs: Seq[URI], verbosity: Int = 0 ): Try[CatalogURIMapper] = {
    val catalog = new CatalogManager()
    catalog.setUseStaticCatalog(false)
    catalog.setRelativeCatalogs(true)
    catalog.setVerbosity(verbosity)
    val mapper = new CatalogURIMapper( catalog )
    catalogURIs.foreach { catalogURI =>
      mapper.parseCatalog(catalogURI) match {
        case Failure( t ) => return Failure( t )
        case Success( _ ) => ()
      }
    }

    Success( mapper )
  }
    
}