// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/

object Solution {
  def moveZeroes(nums: Array[Int]): Unit = {
    var i, j = 0

    while (j < nums.length) {
      if (0 == nums(j)) {
        j += 1
      } else {
        if (0 == nums(i)) {
          val tmp = nums(j)
          nums(j) = 0
          nums(i) = tmp
          i += 1
        } else {
          i += 1
          j += 1
        }
      }
    }
  }
}

val in = Array(0,1,0,3,12)
Solution.moveZeroes(in)
in
