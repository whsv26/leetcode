package org.whsv26.leetcode
package tree

import scala.collection.immutable.Queue
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
    breadthFirstTraverseImmutable(mkTree(1, 2, 3, 4, null, null, 5, 6, null, null, 7))
      .tapEach(println)
  }

  def breadthFirstTraverseImmutable(root: TreeNode): List[Int] =
    List
      .unfold(Queue(root)) {
        case queue if queue.isEmpty => None
        case oldQueue =>
          val (head, tail) = oldQueue.dequeue
          val newQueue =
            List(Option(head.left), Option(head.right))
              .flatten
              .foldLeft(tail) { case (acc, cur) => acc.enqueue(cur) }

          Some(head.value, newQueue)
      }

  def breadthFirstTraverseMutable(root: TreeNode)(f: TreeNode => Unit): Unit = {

    val queue = mutable.Queue(root)

    while (queue.nonEmpty) {
      val node = queue.dequeue()

      if (node.left != null) queue.enqueue(node.left)
      if (node.right != null) queue.enqueue(node.right)

      f(node)
    }
  }
}
