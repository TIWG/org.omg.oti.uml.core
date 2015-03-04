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
 * ParameterEffectKind is an Enumeration that indicates the effect of a Behavior on values passed in or out of its parameters.
 * <!-- end-model-doc --> 
 */
object UMLParameterEffectKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLParameterEffectKind = Value

	/**
 	* <!-- begin-model-doc --> 
 	* Indicates that the behavior creates values.
 	* <!-- end-model-doc --> 
 	*/
	val create = Value

	/**
 	* <!-- begin-model-doc --> 
 	* Indicates objects that are values of the parameter do not exist after executions of the behavior are finished.
 	* <!-- end-model-doc --> 
 	*/
	val delete = Value

	/**
 	* <!-- begin-model-doc --> 
 	* Indicates objects that are values of the parameter have values of their properties, or links in which they participate, or their classifiers retrieved during executions of the behavior.
 	* <!-- end-model-doc --> 
 	*/
	val read = Value

	/**
 	* <!-- begin-model-doc --> 
 	* Indicates objects that are values of the parameter have values of their properties, or links in which they participate, or their classification changed during executions of the behavior.
 	* <!-- end-model-doc --> 
 	*/
	val update = Value
}
