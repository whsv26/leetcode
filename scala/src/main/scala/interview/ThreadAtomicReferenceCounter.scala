package org.whsv26.leetcode
package interview

import java.util.concurrent.atomic.AtomicReference

object ThreadAtomicReferenceCounter extends App {

  case class State(counter: Int)
  val times = 100
  val atomicRef = new AtomicReference[State]()
  atomicRef.set(State(times))

  def decrement() = new Thread {
    override def run() = {
      val newState = atomicRef.updateAndGet(oldState => oldState.copy(counter = oldState.counter - 1))
      println(Thread.currentThread().getName + ": " + newState.counter)
    }
  }

  println(atomicRef.get())

  List.fill(100)(decrement())
    .tapEach(_.start())
    .tapEach(_.join())

  println(atomicRef.get())
}
