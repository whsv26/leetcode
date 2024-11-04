package org.whsv26.leetcode
package interview

import java.util.concurrent.atomic.{AtomicBoolean, AtomicReference}

object Atomics {
  object Reference {
    case class State(counter: Int)

    val atomicRef = new AtomicReference[State](State(0))

    atomicRef.set(State(100))
    atomicRef.getAndSet(State(0)) // return old state: State(100)

    atomicRef.updateAndGet { currentState =>
      val updatedState = currentState.copy(currentState.counter - 1)
      updatedState
    } // return new state

    atomicRef.getAndUpdate { currentState =>
      val updatedState = currentState.copy(currentState.counter - 1)
      updatedState
    } // return old state
  }

  object Boolean {
    val isInitialized = new AtomicBoolean(false)
    if (isInitialized.compareAndSet(false, true)) {
      println("initializing")
    }

  }

}
