// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/

object Solution1 {
  def singleNumber(nums: Array[Int]): Int = {
    val set = collection.mutable.HashSet.empty[Int]

    nums.foldLeft(0) {
      (acc: Int, cur: Int) =>
        if (set(cur)) {
          set.remove(cur)
          acc - cur
        } else {
          set.add(cur)
          acc + cur
        }
    }
  }
}

/**
 * a XOR 0 = 0
 * a XOR a = 0
 */
object Solution2 {
  def singleNumber(nums: Array[Int]): Int = {
    nums.foldLeft(0) {
      (acc: Int, cur: Int) => acc ^ cur
    }
  }
}

Solution2.singleNumber(Array(4,1,2,1,2)) // 4
Solution2.singleNumber(Array(4,1,2,3,1,2,3)) // 4
Solution2.singleNumber(Array(5,1,5,3,1,2,2)) // 3
