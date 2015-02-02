package org.omg.oti.canonicalXMI

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

case class CatalogURIMapper( catalogManager: CatalogManager, catalogResolver: CatalogResolver, catalog: Catalog ) {

  def this( catalogManager: CatalogManager, catalogResolver: CatalogResolver ) = this( catalogManager, catalogResolver, catalogResolver.getCatalog )

  def this( catalogManager: CatalogManager ) = this( catalogManager, new CatalogResolver( catalogManager ) )

  def parseCatalog( catalogURI: URI ): Try[Unit] =
    try {
      catalog.parseCatalog( catalogURI.toURL() )
      Success( Unit )
    }
    catch {
      case e: IOException => Failure( e )
    }

  def loadResolutionStrategy( resolved: String ): Option[URI] = {

    def ignore( e: Exception ) = {}

    val normalized = new URI( resolved )
    val normalizedPath = normalized.toString()

    val f1 = new URL( normalizedPath )
    val f2 = if ( normalizedPath.endsWith( ".owl" ) ) f1 else new URL( normalizedPath + ".owl" )
    try {
      for {
        is <- Option.apply( f1.openStream )
        if ( is.available() > 0 )
      } {
        is.close()
        return Some( f1.toURI )
      }
    }
    catch {
      case e: IOException => ignore( e )
      // try another variant.
    }
    try {
      for {
        is <- Option.apply( f2.openStream() )
        if ( is.available() > 0 )
      } {
        is.close()
        return Some( f2.toURI )
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
    val outputFile = if ( resolved.startsWith( "file:" ) ) new File( resolved.substring( 5 ) ) else new File( resolved )
    outputFile.getParentFile() match {
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

  def resolveURI( uri: URI, resolutionStrategy: ( String ) => Option[URI] ): Try[URI] = {

    def ignore( e: Exception ) = {}

    val rawPath = uri.toString
    val iriPath = if ( rawPath.endsWith( "#" ) ) rawPath.substring( 0, rawPath.length() - 1 ) else rawPath
    try {
      catalog.resolveURI( iriPath ) match {
        case null =>
          Success( uri )
        case resolved =>
          resolutionStrategy( resolved ) match {
            case None                => Success( uri )
            case Some( resolvedURI ) => Success( resolvedURI )
          }
      }
    }
    catch {
      case t: MalformedURLException => Failure( t )
      case t: IOException           => Failure( t )
    }
  }
}