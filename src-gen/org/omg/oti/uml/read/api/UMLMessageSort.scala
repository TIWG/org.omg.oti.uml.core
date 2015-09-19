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
package org.omg.oti.uml.read.api

import scala.Enumeration

/**
 * This is an enumerated type that identifies the type of communication action that was used to generate the Message.
 *
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
object UMLMessageSort extends Enumeration {
	
	/**
	 * The enumeration type
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	type UMLMessageSort = Value

	/**
 	 * The message was generated by an asynchronous call to an operation; i.e., a CallAction with isSynchronous = false.
	 *
	 * <!-- Start of user code doc for asynchCall -->
   * <!-- End of user code doc for asynchCall -->
 	 */
	val asynchCall = Value

	/**
 	 * The message was generated by an asynchronous send action.
	 *
	 * <!-- Start of user code doc for asynchSignal -->
   * <!-- End of user code doc for asynchSignal -->
 	 */
	val asynchSignal = Value

	/**
 	 * The message designating the creation of another lifeline object.
	 *
	 * <!-- Start of user code doc for createMessage -->
   * <!-- End of user code doc for createMessage -->
 	 */
	val createMessage = Value

	/**
 	 * The message designating the termination of another lifeline.
	 *
	 * <!-- Start of user code doc for deleteMessage -->
   * <!-- End of user code doc for deleteMessage -->
 	 */
	val deleteMessage = Value

	/**
 	 * The message is a reply message to an operation call.
	 *
	 * <!-- Start of user code doc for reply -->
   * <!-- End of user code doc for reply -->
 	 */
	val reply = Value

	/**
 	 * The message was generated by a synchronous call to an operation.
	 *
	 * <!-- Start of user code doc for synchCall -->
   * <!-- End of user code doc for synchCall -->
 	 */
	val synchCall = Value
}
