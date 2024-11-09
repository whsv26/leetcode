package org.whsv26.leetcode
package interview

import scala.collection.mutable

object ArrayExample extends App {
  val (m, n) = (2, 2)
  Array.ofDim[Boolean](m, n)
}

object ListBufferExample extends App {
  val listBuffer = mutable.ListBuffer.empty[Int] // LinkedList
  listBuffer.append(2)
  listBuffer.prepend(1)
  println(listBuffer.toList)
}

object ArrayBuilderExample extends App {
  // Builder = Growable
  val arrayBuilder = mutable.ArrayBuilder.make[Int]
  arrayBuilder.addOne(1)
  arrayBuilder.addAll(Array(1, 2))
  var resultArray = arrayBuilder.result()
  println(resultArray.mkString("Array(", ", ", ")"))
}

object ArrayBufferExample extends App {
  // Buffer = Growable & Shrinkable
  val arrayBuffer = mutable.ArrayBuffer.empty[Int]
  arrayBuffer.addOne(1)
  arrayBuffer.addAll(Array(2, 3))
  val removedElement = arrayBuffer.remove(1) // by index
  println(removedElement) // 2
}

object SetExample extends App {
  val set = mutable.Set.empty[Int] // HashSet
  val element = 2
  set.addOne(element)
  set.contains(element) // true
  val isRemoved = set.remove(element)
  println(isRemoved) // true
}

object MapExample extends App {
  val map = mutable.Map.empty[String, Int] // HashMap
  map.addOne("key" -> 1)
  map.get("key") // Some(1)
  map.getOrElse("key", 0) // 1
}

object QueueExample extends App {
  val queue = mutable.Queue.empty[Int] // ArrayDeque
  queue.enqueue(1) // addOne
  queue.enqueue(2, 3) // addOne
  val removedElement = queue.dequeue() // removeHead
  val removedElements = queue.dequeueAll(_ => true) // removeAll
  println(removedElement) // 1
  println(removedElements) // List(2, 3)
}

object StackExample extends App {
  val stack = mutable.Stack.empty[Int] // ArrayDeque
  stack.push(1) // prepend
  stack.push(2, 3) // prepend
  val poppedElement = stack.pop() // removeHead
  println(poppedElement) // 3
}

object PriorityQueueAsMaxHeapExample extends App {
  val maxHeap = mutable.PriorityQueue.empty[Int] // MaxHeap
  maxHeap.enqueue(1) // addAll
  maxHeap.enqueue(2, 3) // addAll
  val dequedElement = maxHeap.dequeue() // head
  val dequedElements = maxHeap.dequeueAll
  println(dequedElement) // 3
  println(dequedElements) // ArraySeq(2, 1)
}

object PriorityQueueAsMinHeapExample extends App {
  val minHeap = mutable.PriorityQueue.empty[Int](Ordering[Int].reverse) // MinHeap
  minHeap.enqueue(1) // addAll
  minHeap.enqueue(2, 3) // addAll
  val dequedElement = minHeap.dequeue() // head
  val dequedElements = minHeap.dequeueAll
  println(dequedElement) // 1
  println(dequedElements) // ArraySeq(2, 3)
}

object LoopExample extends App {
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
}
