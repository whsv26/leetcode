package org.whsv26.leetcode
package backtracking

object Subsets extends App {
  assert {
    Solution.subsets(Array(1, 2, 3)) == List(
      List(1, 2, 3),
      List(2, 3),
      List(1, 3),
      List(3),
      List(1, 2),
      List(2),
      List(1),
      List(),
    )
  }

  object Solution {
    def subsets(nums: Array[Int]): List[List[Int]] =
      nums match {
        case Array() => List(Nil)
        case Array(num, _*) =>
          subsets(nums.tail)
            .flatMap(subset => Array(num :: subset, subset))
      }
  }
}
