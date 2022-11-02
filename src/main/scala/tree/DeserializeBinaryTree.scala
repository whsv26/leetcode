package org.whsv26.leetcode
package tree

import tree.BreadthFirstBinaryTreeTraversal.breadthFirstTraverse

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
object DeserializeBinaryTree {
  val nil = -1

  def main(args: Array[String]): Unit = {
    breadthFirstTraverse(deserialize(Array(1,2,3,4,nil,nil,5,6,nil,nil,7)))(n => println(n.value))
    breadthFirstTraverse(deserialize(Array(1,2,nil,3,nil,4,nil,nil,5,nil,6)))(n => println(n.value))
  }

  def deserialize(arr: Array[Int]): TreeNode = {
    val nodes = arr.map(v => if (v != nil) new TreeNode(v) else null)
    val parents = nodes.filter(_ != null)
    val children = nodes.drop(1).grouped(2)

    parents.zip(children).tapEach {
      case (parent, Array(left, right)) =>
        parent.left = left
        parent.right = right
    }

    parents(0)
  }
}
