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
 * TransitionKind is an Enumeration type used to differentiate the various kinds of Transitions.
 *
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
object UMLTransitionKind extends Enumeration {
	
	/**
	 * The enumeration type
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	type UMLTransitionKind = Value

	/**
 	 * Implies that the Transition, if triggered, will exit the composite (source) State.
	 *
	 * <!-- Start of user code doc for external -->
	 * <!-- End of user code doc for external -->
 	 */
	val external = Value

	/**
 	 * Implies that the Transition, if triggered, occurs without exiting or entering the source State (i.e., it does not cause a state change). This means that the entry or exit condition of the source State will not be invoked. An internal Transition can be taken even if the SateMachine is in one or more Regions nested within the associated State.
	 *
	 * <!-- Start of user code doc for internal -->
	 * <!-- End of user code doc for internal -->
 	 */
	val internal = Value

	/**
 	 * Implies that the Transition, if triggered, will not exit the composite (source) State, but it will exit and re-enter any state within the composite State that is in the current state configuration.
	 *
	 * <!-- Start of user code doc for local -->
	 * <!-- End of user code doc for local -->
 	 */
	val local = Value
}
