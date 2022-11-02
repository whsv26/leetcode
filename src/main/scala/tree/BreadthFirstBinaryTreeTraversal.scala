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
    val n1 = new TreeNode(1, null, null)
    val n2 = new TreeNode(2, null, null)
    val n3 = new TreeNode(3, null, null)
    val n4 = new TreeNode(4, null, null)
    val n5 = new TreeNode(5, null, null)
    val n6 = new TreeNode(6, null, null)
    val n7 = new TreeNode(7, null, null)

    n1.left = n2
    n1.right = n3
    n2.left = n4
    n4.left = n6
    n3.right = n5
    n5.right = n7

    breadthFirstTraverse(n1)(n => println(n.value))
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
