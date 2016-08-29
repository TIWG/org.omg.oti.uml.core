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
 * = OTI-based OMG XMI 2.5.1 Document & OMG MOF 2.5 Extent Support =
 *
 * == Key abstractions: ==
 *
 *   - [[xmi.Document]]: Corresponds to the OMG XMI 2.5.1 concept of Document and OMG MOF 2.5 Extent
 *
 *     OTI's Document API provides the basis for OMG XMI 2.5.1-based document export/import and inter-document linking.
 *     This API combines the concept of OMG XMI2.5.1 Document (a locatable resource that can be referenced),
 *     and that of OMG MOF 2.5 Extent (exporting/importing a document involves all elements transitively contained
 *     in the context of the document root element).
 *
 *   - [[xmi.IDGenerator]]: Corresponds to the OMG XMI 2.5.1 B.4 Identification
 */
package object xmi