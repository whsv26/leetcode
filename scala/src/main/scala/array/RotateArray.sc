// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/

object Solution {
  def rotate(nums: Array[Int], k: Int): Unit = {
    if (nums.length < 2)
      return

    shiftK(nums, k % nums.length)
  }

  def shiftK(nums: Array[Int], k: Int): Unit = {
    for {
      i <- 0 until k
      shifted = shift(nums, i)
    } nums((k - 1) - i) = shifted
  }

  def shift(nums: Array[Int], from: Int): Int = {
    val shifted = nums(nums.length - 1)

    for {
      i <- (nums.length - 1) until from by -1
    } nums(i) = nums(i - 1)

    shifted
  }
}

val input = Array(1,2,3,4)

Solution.rotate(input, 3)

input