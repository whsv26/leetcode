// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/

object Solution {
  def moveZeroes(nums: Array[Int]): Unit = {
    var i = 0

    while (i < nums.length) {
      if (nums(i) == 0) {
        val j = expandZeroes(nums, i)
        shift(nums, i, j)
      }

      i += 1
    }
  }

  def expandZeroes(nums: Array[Int], start: Int): Int = {
    var end = start

    while (end + 1 < nums.length && 0 == nums(end + 1)) {
      end += 1
    }

    end
  }

  def shift(nums: Array[Int], start: Int, end: Int): Unit = {
    if (end + 1 >= nums.length)
      return

    val tmp = nums(end + 1)

    (start to end).foreach { i =>
      nums(i + 1) = 0
    }

    nums(start) = tmp
  }
}

val in = Array(0,1,0,3,12)

Solution.moveZeroes(in)

in
