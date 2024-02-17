package org.whsv26.leetcode
package others

object MissingNumber {

  def main(args: Array[String]): Unit = {
    assert(2 == missingNumber(Array(3,0,1)))
    assert(8 == missingNumber(Array(9,6,4,2,3,5,7,0,1)))
  }

  def missingNumber(nums: Array[Int]): Int =
    nums.foldLeft(arithmeticProgressionSum(0, nums.length, nums.length + 1))(_ - _)

  def arithmeticProgressionSum(a1: Int, aN: Int, n: Int) =
    n * (a1 + aN) / 2
}
