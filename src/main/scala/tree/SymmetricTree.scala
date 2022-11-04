package org.whsv26.leetcode
package tree

object SymmetricTree {

  def main(args: Array[String]): Unit = {
    assert(isSymmetric(mkTree(1,2,2,3,4,4,3)))
    assert(!isSymmetric(mkTree(1,2,2,null,3,null,3)))
  }

  def isSymmetric(root: TreeNode): Boolean = {
    def iter(lhs: TreeNode, rhs: TreeNode): Boolean =
      if (lhs == null && rhs == null) {
        true
      } else if ((lhs == null || rhs == null) || (lhs.value != rhs.value)) {
        false
      } else {
        iter(lhs.left, rhs.right) && iter(lhs.right, rhs.left)
      }

    iter(root.left, root.right)
  }
}
