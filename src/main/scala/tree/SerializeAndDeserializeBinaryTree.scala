package org.whsv26.leetcode
package tree

import tree.BreadthFirstBinaryTreeTraversal.breadthFirstTraverse
import scala.collection.mutable

object SerializeAndDeserializeBinaryTree {
  def main(args: Array[String]): Unit = {
    println(serialize(mkTree(1,2,3,4,null,null,5,6,null,null,7)))
    breadthFirstTraverse(deserialize("[1,2,3,4,null,null,5,6,null,null,7]"))(n => println(n.value))

    println

    println(serialize(mkTree(1,2,3,null,null,4,5)))
    breadthFirstTraverse(deserialize("[1,2,3,null,null,4,5]"))(n => println(n.value))
  }

  def deserialize(data: String): TreeNode = {
    if (data == "[]")
      return null

    val nodes = data
      .substring(1, data.length - 1)
      .split(',')
      .map(n => if (n == "null") null else new TreeNode(n.toInt))

    val parents = nodes.filter(_ != null)
    val children = nodes.drop(1).grouped(2)

    parents.zip(children).tapEach { case (parent, cs) =>
      parent.left = if (cs.length > 0) cs(0) else null
      parent.right = if (cs.length > 1) cs(1) else null
    }

    parents.head
  }

  def serialize(root: TreeNode): String = {
    if (root == null)
      return "[]"

    val buffer = new mutable.StringBuilder("[")
    val queue = mutable.Queue(root)
    var currentValue = root.value

    while (queue.nonEmpty) {
      val node = queue.dequeue()

      if (node != null) {
        currentValue = node.value
        queue.enqueue(node.left)
        queue.enqueue(node.right)
        buffer.appendAll(node.value.toString)
      } else {
        buffer.appendAll("null")
      }

      buffer.append(',')
    }

    buffer
      .substring(0, buffer.lastIndexOf(currentValue.toString) + currentValue.toString.length)
      .appended(']')
  }
}
