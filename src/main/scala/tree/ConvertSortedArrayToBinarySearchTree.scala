package org.whsv26.leetcode
package tree

object ConvertSortedArrayToBinarySearchTree {

  def main(args: Array[String]): Unit = {
    sortedArrayToBST(Array(-10,-3,0,5,9))
  }

  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    def iter(i: Int, j: Int): TreeNode = {
      val mid = i + (j - i) / 2

      if (i <= j)
        new TreeNode(
          nums(mid),
          iter(i, mid - 1),
          iter(mid + 1, j),
        )
      else null
    }

    iter(0, nums.length - 1)
  }

}
