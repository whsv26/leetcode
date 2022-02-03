// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/

object Solution {
  case class Extremum(minOdd: Int, minEven: Int, maxOdd: Int, maxEven: Int)

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = collection.mutable.HashMap.empty[Int, Int]

    for (i <- nums.indices) {
      map.update(target - nums(i), i)
    }

    val idx = nums.indices.find { i =>
      map.getOrElse(nums(i), i) != i
    }.get

    Array(idx, map(nums(idx)))
  }
}

Solution.twoSum(Array(2,7,11,15), 9) // [0,1]
Solution.twoSum(Array(3,2,4), 6) // [1,2]
Solution.twoSum(Array(3,3), 6) // [0,1]
Solution.twoSum(Array(-1,-2,-3,-4,-5), -8) // [2, 4]
