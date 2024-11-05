package org.whsv26.leetcode
package interview

import java.util.concurrent.atomic.AtomicReference
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

object FutureAtomicReferenceCounter extends App {
  implicit val ec = ExecutionContext.global

  case class State(counter: Int)
  val times = 100
  val atomicRef = new AtomicReference[State]()
  atomicRef.set(State(times))

  def decrement() = Future {
    val newState = atomicRef.updateAndGet(oldState => oldState.copy(counter = oldState.counter - 1))
    println(Thread.currentThread().getName + ": " + newState.counter)
  }

  val program =
    for {
      _ <- Future(println(atomicRef.get()))
      _ <- Future.traverse((0 until times).toList)(_ => decrement())
      _ <- Future(println(atomicRef.get()))
    } yield ()

  Await.ready(program, Duration.Inf)
}

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
