object Solution {
  def compact(nums: Array[Int]): Array[(Int, Int)] =
    nums
      .foldLeft(List.empty[(Int, Int)]) {
        case ((prev, times) :: tail, curr) if prev == curr => (prev, times + 1) :: tail
        case (acc, cur) => cur -> 1 :: acc
      }
      .view
      .reverse
      .toArray
}

val actual = Solution.compact(Array(1, 2, 2, 2, 3, 4, 4, 5, 6, 7, 7))
val expected = Array((1, 1), (2, 3), (3, 1), (4, 2), (5, 1), (6, 1), (7, 2))
assert(actual sameElements expected)