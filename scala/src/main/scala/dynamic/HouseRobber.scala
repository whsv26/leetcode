package org.whsv26.leetcode
package dynamic

object HouseRobber {

  def main(args: Array[String]): Unit = {
    assert(4 == rob(Array(1,2,3,1)))
    assert(12 == rob(Array(2,7,9,3,1)))
    assert(4 == rob(Array(2,1,1,2)))
  }

  def rob(nums: Array[Int]): Int = {

    val cache = Array.fill(nums.length)(0)
    cache(0) = nums(0)

    for (i <- 1 until nums.length) {
      val b2 = if (cache.isDefinedAt(i - 2)) cache(i - 2) else 0
      val b3 = if (cache.isDefinedAt(i - 3)) cache(i - 3) else 0

      cache(i) = Math.max(b2, b3) + nums(i)
    }

    cache.max
  }
}
