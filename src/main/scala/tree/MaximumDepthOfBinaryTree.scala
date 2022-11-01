package org.whsv26.leetcode
package tree

object MaximumDepthOfBinaryTree {
  def maxDepth(root: TreeNode): Int = {
    def iter(n: TreeNode, depth: Int): Int =
      Math.max(
        Option(n.left).map(iter(_, depth + 1)).getOrElse(depth),
        Option(n.right).map(iter(_, depth + 1)).getOrElse(depth)
      )

    Option(root).map(iter(_, 1)).getOrElse(0)
  }
}
