// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/

object Solution1 {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    nums.sortInPlace()
    nums.iterator.drop(1).zip(nums.iterator).exists {
      case (curr, prev) => curr == prev
    }
  }
}

object Solution2 {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    val set = collection.mutable.HashSet.empty[Int]
    nums.exists { num =>
      val present = set(num)
      set.add(num)
      present
    }
  }
}

object Solution3 {
  def containsDuplicate(nums: Array[Int]): Boolean =
    nums.iterator
      .scanLeft(Set.empty[Int])((set, num) => set.incl(num))
      .zip(nums.iterator)
      .exists { case (set, num) => set(num) }
}

Solution3.containsDuplicate(Array(3, 1, 2, 3, 4))