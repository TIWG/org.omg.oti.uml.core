/*
 *
 * License Terms
 *
 * Copyright (c) 2014-2016, California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * *   Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * *   Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the
 *    distribution.
 *
 * *   Neither the name of Caltech nor its operating division, the Jet
 *    Propulsion Laboratory, nor the names of its contributors may be
 *    used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.uml

/**
 * <a href="../../../../../index.html" target="_top">Top</a>
 *
 * = OCL/MOF-like queries about UML elements =
 *
 * == MOF-like reflection for stereotypes applied to UML elements ==
 *
 *   - [[read.UMLStereotypeTagValue]]: An abstraction for the value of a stereotype "tag property".
 *   - [[read.TagPropertyClassifierValue]]: An abstraction for an individual value in
 *   a collection of values for a stereotype tag property or a Profile-defined Classifier attribute property.
 *
 * == OCL/MOF-like queries ==
 *
 *   - [[read.api]]: OCL/QVT-like Query of UML models
 *
 *     The OTI UML Query API covers all the metaclasses, attributes, properties and query operations
 *     specified in the normative OMG UML 2.5 abstract syntax metamodel.
 *
 *   - [[read.operations]]: Generic OTI-based Implementation of normative
 *     OMG UML2.5 derived properties and query operations
 *
 *     Where the OMG UML 2.5 specification includes OCL constraints for
 *     specifying derived properties or query operations, the OTI UML API
 *     provides corresponding tool-neutral implementations in Scala.
 */
package object read