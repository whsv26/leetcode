package org.whsv26.leetcode
package dynamic

object HouseRobber {

  def main(args: Array[String]): Unit = {
    assert(4 == rob(Array(1,2,3,1)))
    assert(12 == rob(Array(2,7,9,3,1)))
    assert(4 == rob(Array(2,1,1,2)))
  }

//  def rob(nums: Array[Int]): Int = {
//
//    val cache = Array.fill(3)(0)
//    var max = 0
//    cache(2) = nums(0)
//
//    for (i <- 1 until nums.length) {
//      val tmp = cache(0)
//      cache(0) = cache(1)
//      cache(1) = cache(2)
//      cache(2) = tmp + nums(i)
//      max = Math.max(max, cache(2))
//    }
//
//    cache.max
//  }

  def rob(nums: Array[Int]): Int = {

    val cache1 = Array.fill(nums.length)(0)
    val cache2 = Array.fill(nums.length)(0)
    cache1(0) = nums(0)
    cache1(nums.length - 1) = nums(nums.length - 1)

    for (i <- 0 until nums.length) {
      val j = nums.length - 1 - i
      cache1(i) = if (cache1.isDefinedAt(i - 2)) cache1(i - 2) else 0 + nums(i)
      cache2(j) = if (cache2.isDefinedAt(j + 2)) cache2(j + 2) else 0 + nums(j)
    }

    cache1.zip(cache2).map(x => x._1 + x._2).max
  }
}
