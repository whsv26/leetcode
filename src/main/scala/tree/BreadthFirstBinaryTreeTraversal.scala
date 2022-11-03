package org.whsv26.leetcode
package tree

import scala.collection.mutable

/**
 * [1,2,3,4,null,null,5,6,null,null,7]
 *
 *         1
 *        / \
 *       2   3
 *      /     \
 *     4       5
 *    /         \
 *   6           7
 */
object BreadthFirstBinaryTreeTraversal {

  def main(args: Array[String]): Unit = {
    breadthFirstTraverse(mkTree(1,2,3,4,null,null,5,6,null,null,7))(n => println(n.value))
  }

  def breadthFirstTraverse(root: TreeNode)(f: TreeNode => Unit): Unit = {

    val queue = mutable.Queue(root)

    while (queue.nonEmpty) {
      val node = queue.dequeue()

      if (node.left != null) queue.enqueue(node.left)
      if (node.right != null) queue.enqueue(node.right)

      f(node)
    }
  }
}
