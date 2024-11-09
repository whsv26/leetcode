package org.whsv26.leetcode

import scala.collection.mutable.ListBuffer

object FizzBuzz {

  def main(args: Array[String]): Unit = {
    println(fizzBuzz(5))
  }

  def fizzBuzz(n: Int): List[String] = {
    val res = ListBuffer.empty[String]

    for (i <- 1 to n) {
      val elem = if (i % 3 == 0 && i % 5 == 0) {
        "FizzBuzz"
      } else if (i % 3 == 0) {
        "Fizz"
      } else if (i % 5 == 0) {
        "Buzz"
      } else {
        i.toString
      }

      res.append(elem)
    }

    res.result()
  }

}
