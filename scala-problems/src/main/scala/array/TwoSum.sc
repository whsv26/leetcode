// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/

object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = nums.indices.foldLeft(Map.empty[Int, Int]) {
      (acc, i) => acc.updated(target - nums(i), i)
    }

    nums.indices
      .find(i => map.getOrElse(nums(i), i) != i)
      .map(i => Array(i, map(nums(i))))
      .get
  }
}

Solution.twoSum(Array(2,7,11,15), 9) // [0,1]
Solution.twoSum(Array(3,2,4), 6) // [1,2]
Solution.twoSum(Array(3,3), 6) // [0,1]
Solution.twoSum(Array(-1,-2,-3,-4,-5), -8) // [2, 4]
