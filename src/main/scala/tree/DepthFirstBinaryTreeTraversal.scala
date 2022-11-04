package org.whsv26.leetcode
package tree

import scala.collection.mutable

/**
 *       1
 *     /   \
 *   2       5
 *  / \     / \
 * 3   4   6   7
 */
object DepthFirstBinaryTreeTraversal {

  def main(args: Array[String]): Unit = {
    depthFirstTraverse(mkTree(1,2,5,3,4,6,7))(n => println(n.value))
  }

  def depthFirstTraverse(root: TreeNode)(f: TreeNode => Unit): Unit = {
    val stack = mutable.Stack(root)

    while (stack.nonEmpty) {
      val node = stack.pop()

      if (node.right != null) stack.push(node.right)
      if (node.left != null) stack.push(node.left)

      f(node)
    }
  }
}
