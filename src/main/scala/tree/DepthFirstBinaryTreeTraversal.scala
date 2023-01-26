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
    depthFirstTraverseImmutable(mkTree(1,2,5,3,4,6,7))
      .tapEach(println)
  }

  def depthFirstTraverseImmutable(root: TreeNode): List[Int] =
    List
      .unfold(List(root)) {
        case Nil => None
        case head :: tail =>
          val stack =
            List(Option(head.right), Option(head.left))
              .flatten
              .foldLeft(tail) { case (acc, cur) => cur :: acc }

          Some(head.value, stack)
      }

  def depthFirstTraverseMutable(root: TreeNode)(f: TreeNode => Unit): Unit = {
    val stack = mutable.Stack(root)

    while (stack.nonEmpty) {
      val node = stack.pop()

      if (node.right != null) stack.push(node.right)
      if (node.left != null) stack.push(node.left)

      f(node)
    }
  }
}
