// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/

/**
 * Runtime: 1605 ms
 * Memory Usage: 92.6 MB
 */
object Solution1 {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    if (nums.length < 2) {
      return false
    }

    nums.sortInPlace()

    (1 until nums.length).iterator.exists { i =>
      nums(i - 1) == nums(i)
    }
  }
}

/**
 * Runtime: 1242 ms
 * Memory Usage: 90.9 MB
 */
object Solution2 {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    if (nums.length < 2) {
      return false
    }

    val set = collection.mutable.HashSet.empty[Int]

    nums.exists { num =>
      val present = set(num)
      set.add(num)
      present
    }
  }
}

Solution2.containsDuplicate(Array(3, 1, 2, 3, 4))