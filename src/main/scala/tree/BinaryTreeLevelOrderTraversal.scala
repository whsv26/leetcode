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
    var res: List[List[Int]] = Nil
    var levelRes: List[Int] = Nil
    val ends = levelEnds(root)

    while (queue.nonEmpty) {
      val node = queue.dequeue()

      if (ends(node)) {
        res = (node.value :: levelRes).reverse :: res
        levelRes = Nil
      } else {
        levelRes = node.value :: levelRes
      }

      if (node.left != null)
        queue.enqueue(node.left)

      if (node.right != null)
        queue.enqueue(node.right)
    }

    res.reverse
  }

  def levelEnds(root: TreeNode): Set[TreeNode] = {
    val map = mutable.Map.empty[Int, TreeNode]

    def iter(node: TreeNode, level: Int): Unit = {
      if (node != null) {
        map.update(level, node)

        iter(node.left, level + 1)
        iter(node.right, level + 1)
      }
    }

    iter(root, 0)
    map.values.toSet
  }
}
