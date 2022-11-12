package org.whsv26.leetcode
package tree

import scala.collection.mutable

object BinaryTreeLevelOrderTraversal {

  def main(args: Array[String]): Unit = {
    println(levelOrder(mkTree(3,9,20,null,null,15,7))) // [[3],[9,20],[15,7]]
    println(levelOrder(mkTree(1,2,null,3,null,4,null,5))) // [[1],[2],[3],[4],[5]]
    println(levelOrder(mkTree(1,2,3,4,5))) // [[1],[2,3],[4,5]]
  }

  def levelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null)
      return Nil

    val queue = mutable.Queue(root)
    var levels: List[List[Int]] = Nil

    while (queue.nonEmpty) {
      val nodes = queue.dequeueAll(_ => true)
      val level =
        nodes.foldLeft(List.empty[Int]) { (acc, node) =>
          if (node.left != null)
            queue.enqueue(node.left)

          if (node.right != null)
            queue.enqueue(node.right)

          node.value :: acc
        }

      levels = level.reverse :: levels
    }

    levels.reverse
  }
}