package org.whsv26.leetcode
package interview

import scala.collection.mutable

object Collections {

  //--------------------------------------------------------------------------------------------------------------------
  val (m, n) = (2, 2)
  Array.ofDim[Boolean](m, n)

  // Builder = Growable
  val arrayBuilder = mutable.ArrayBuilder.make[Int]
  arrayBuilder.addOne(1)
  arrayBuilder.addAll(Array(1, 2))
  arrayBuilder.result()

  // Buffer = Growable & Shrinkable
  val arrayBuffer = mutable.ArrayBuffer.empty[Int]
  arrayBuffer.addOne(1)
  arrayBuffer.addAll(Array(1, 2))
  arrayBuffer.remove(0) // by index

  //--------------------------------------------------------------------------------------------------------------------

  val set = mutable.Set.empty[Int] // HashSet
  set.addOne(1)
  set.contains(1)
  set.remove(1) // by element

  //--------------------------------------------------------------------------------------------------------------------

  val map = mutable.Map.empty[String, Int] // HashMap
  map.addOne("key" -> 1)
  map.get("key")
  map.getOrElse("key", 0)

  //--------------------------------------------------------------------------------------------------------------------

  val queue = mutable.Queue.empty[Int] // ArrayDeque
  queue.enqueue(1) // addOne
  queue.dequeue() // removeHead
  queue.dequeueAll(_ => true) // removeAll

  //--------------------------------------------------------------------------------------------------------------------

  val stack = mutable.Stack.empty[Int] // ArrayDeque
  stack.push(1) // prepend
  stack.pop() // removeHead

  //--------------------------------------------------------------------------------------------------------------------

  val maxHeap = mutable.PriorityQueue.empty[Int] // MaxHeap
  maxHeap.enqueue(1, 2, 3) // addAll
  maxHeap.dequeue() // head (3)
  maxHeap.dequeueAll

  //--------------------------------------------------------------------------------------------------------------------

  val minHeap = mutable.PriorityQueue.empty[Int](Ordering[Int].reverse) // MinHeap
  minHeap.enqueue(1, 2, 3) // addAll
  minHeap.dequeue() // head (1)
  minHeap.dequeueAll

  //--------------------------------------------------------------------------------------------------------------------

  var res = 10
  while (false) {
    res += 1
    res -= 2
  }

  for (i <- 0 until 10) {
    println("do something")
  }

  for {
    i <- 0 until 10
    j <- 0 until 20
  } yield i + j

  for {
    i <- 0 until 10
    j <- 0 until 20
  } {
    println("do something")
  }

  //--------------------------------------------------------------------------------------------------------------------

}
