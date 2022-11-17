package org.whsv26.leetcode
package dynamic

import java.lang.Math.max

/**
[1,-2,3,4]
[1,0,0,0] = [1]
[1,-1,0,0] = [1,-2], [-2]
[1,-1,3,0] = [-1, 3], [3]
[1,-1,3,7] = [3, 4], [4]
*/
object MaximumSubarray {

  def main(args: Array[String]): Unit = {
    assert(maxSubArray(Array(-1)) == -1)
    assert(maxSubArray(Array(5,4,-1,7,8)) == 23)
    assert(maxSubArray(Array(-2,1,-3,4,-1,2,1,-5,4)) == 6)
  }

  def maxSubArray(nums: Array[Int]): Int = {
    var prev = nums(0)
    var res = nums(0)

    for (i <- 1 until nums.length) {
      prev = max(nums(i), prev + nums(i))
      res = max(res, prev)
    }

    res
  }

  def maxSubArrayHighMemory(nums: Array[Int]): Int = {
    val cache = Array.fill(nums.length)(0)
    cache(0) = nums(0)

    for (i <- 1 until nums.length) {
      cache(i) = max(nums(i), cache(i - 1) + nums(i))
    }

    cache.max
  }

  def maxSubArrayBruteForce(nums: Array[Int]): Int = {
    if (nums.length == 0)
      return 0

    def loop(s: Int, e: Int): (Int, Int) = {
      if (s == e) {
        nums(s) -> nums(s)
      } else {
        val (max, sum) = loop(s, e - 1)
        (Math.max(max, sum + nums(e)), sum + nums(e))
      }
    }

    nums.indices.foldLeft(nums(0)) {
      case (acc, i) =>
        max(acc, loop(i, nums.length - 1)._1)
    }
  }
}
