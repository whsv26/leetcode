// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/

object Solution {
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val (hNums, nums) = if (nums1.length < nums2.length)
      (nums1, nums2) else (nums2, nums1)

    val map = collection.mutable.HashMap.empty[Int, Int]

    hNums.foreach { num =>
      map.update(num, map.getOrElse(num, 0) + 1)
    }

    nums.foldLeft[List[Int]](Nil) {
      (acc, cur) => if (map.getOrElse(cur, 0) > 0) {
        map.update(cur, map(cur) - 1)
        cur :: acc
      } else acc
    }.toArray
  }
}

Solution.intersect(Array(1,2,2,1), Array(2, 2)) // Array(2, 2)
