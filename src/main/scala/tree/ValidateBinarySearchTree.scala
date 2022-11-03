package org.whsv26.leetcode
package tree

object ValidateBinarySearchTree {

  def main(args: Array[String]): Unit = {
    assert(!isValidBST(mkTree(5,1,4,null,null,3,6)))
    assert(isValidBST(mkTree(2,1,3)))
  }

  def isValidBST(root: TreeNode): Boolean = {
    def iter(node: TreeNode, min: Int, max: Int): Boolean =
      node match {
        case null => true
        case n if n.value < min || n.value > max => false
        case n if n.left != null && n.left.value >= n.value => false
        case n if n.right != null && n.right.value <= n.value => false
        case n => iter(n.left, min, n.value - 1) && iter(n.right, n.value + 1, max)
      }

    iter(root, Int.MinValue, Int.MaxValue)
  }
}
