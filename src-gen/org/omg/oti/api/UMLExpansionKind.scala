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
package org.omg.oti.api

/**
 * <!-- begin-model-doc --> 
 * ExpansionKind is an enumeration type used to specify how an ExpansionRegion executes its contents.
 * <!-- end-model-doc --> 
 */
object UMLExpansionKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLExpansionKind = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The content of the ExpansionRegion is executed iteratively for the elements of the input collections, in the order of the input elements, if the collections are ordered.
 	* <!-- end-model-doc --> 
 	*/
	val iterative = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The content of the ExpansionRegion is executed concurrently for the elements of the input collections.
 	* <!-- end-model-doc --> 
 	*/
	val parallel = Value

	/**
 	* <!-- begin-model-doc --> 
 	* A stream of input collection elements flows into a single execution of the content of the ExpansionRegion, in the order of the collection elements if the input collections are ordered.
 	* <!-- end-model-doc --> 
 	*/
	val stream = Value
}
