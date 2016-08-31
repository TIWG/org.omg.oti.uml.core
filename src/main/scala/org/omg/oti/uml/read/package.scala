/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
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