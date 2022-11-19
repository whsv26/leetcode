package org.whsv26.leetcode
package design

import java.util.Random

object ShuffleAnArray {

  def main(args: Array[String]): Unit = {
    val solution = new Solution(Array(1, 2, 3))

    (1 to 100).foreach { _ =>
      println(solution.shuffle().toList)
      solution.reset()
    }
  }


  class Solution(_nums: Array[Int]) {
    private var seed = 0

    def reset(): Array[Int] = {
      seed += 1
      _nums
    }

    def shuffle(): Array[Int] = {
      val random = new Random(seed)
      val res = Array.copyOf(_nums, _nums.length)
      var i = 0
      var len = res.length

      while (i < _nums.length) {
        excl(res, len, random.nextInt(len))
        len -= 1
        i += 1
      }

      res
    }

    private def excl(arr: Array[Int], len: Int, idx: Int): Unit = {
      var i = idx
      while (i < (len - 1)) {
        val tmp = arr(i + 1)
        arr(i + 1) = arr(i)
        arr(i) = tmp
        i += 1
      }
    }
  }
}
