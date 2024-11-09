package org.whsv26.leetcode

import java.lang.Math.min

object MinStack {

  def main(args: Array[String]): Unit = ???

  class Solution() {
    private var list: List[(Int, Int)] = Nil

    def push(`val`: Int) {
      list = list match {
        case Nil => (`val`, `val`) :: list
        case (_, bot) :: _ => (`val`, min(`val`, bot)) :: list
      }
    }

    def pop() {
      list = list.tail
    }

    def top(): Int = {
      list.head._1
    }

    def getMin(): Int = {
      list.head._2
    }

  }
}
