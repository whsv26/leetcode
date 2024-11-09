package org.whsv26.leetcode
package array

import scala.collection.mutable

object IntersectionOfTwoArrays {

  def main(args: Array[String]): Unit = {
    assert(Array(2) sameElements  SolutionMutable.intersection(Array(1, 2, 2), Array(2, 2, 3)))
    assert(Array(2) sameElements  SolutionImmutable.intersection(Array(1, 2, 2), Array(2, 2, 3)))
  }

  object SolutionMutable {
    def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
      val set1 = mutable.Set.empty[Int]
      val set2 = mutable.Set.empty[Int]

      nums1.foreach(set1.addOne)
      nums2.foreach(set2.addOne)

      set1.filter(set2).toArray
    }
  }

  object SolutionImmutable {
    def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] =
      nums1.toSet.intersect(nums2.toSet).toArray
  }
}
