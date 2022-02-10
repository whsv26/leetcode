package org.whsv26.leetcode
package sorting

object MergeSortedArray {
  def main(args: Array[String]): Unit = {
    test1()
    test2()
    test3()
    test4()
  }

  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    var i, j = 0
    var cap = nums1.length - m

    while (j < n) {
      if (i == nums1.length - cap) {
        nums1(i) = nums2(j)
        j += 1
        cap -= 1
      } else if (nums1(i) >= nums2(j)) {
        shiftRight(nums1, i, cap)
        nums1(i) = nums2(j)
        j += 1
        cap -= 1
      }

      i += 1
    }
  }

  def shiftRight(nums: Array[Int], start: Int, cap: Int): Unit = {
    var j = nums.length - cap

    while (start < j) {
      nums(j) = nums(j - 1)
      j -= 1
    }
  }

  def test1(): Unit = {
    val in = Array(1,2,3,0,0,0)
    merge(in, 3, Array(2, 5, 6), 3)
    assert(in sameElements Array(1,2,2,3,5,6))
  }

  def test2(): Unit = {
    val in = Array(1)
    merge(in, 1, Array(), 0)
    assert(in sameElements Array(1))
  }

  def test3(): Unit = {
    val in = Array(0)
    merge(in, 0, Array(1), 1)
    assert(in sameElements Array(1))
  }

  def test4(): Unit = {
    val in = Array(-1,0,0,3,3,3,0,0,0)
    merge(in, 6, Array(1,2,2), 3)
    assert(in sameElements Array(-1,0,0,1,2,2,3,3,3))
  }
}
