package org.whsv26.leetcode

import tree.SerializeAndDeserializeBinaryTree.deserialize
import scala.language.implicitConversions

package object tree {
  class TreeNode(
    var value: Int = 0,
    var left: TreeNode = null,
    var right: TreeNode = null
  )

  implicit def toNode(n: Int): TreeNode =
    new TreeNode(n)

  def mkTree(nodes: TreeNode*): TreeNode = {
    val parents = nodes.filter(_ != null)
    val children = nodes.drop(1).grouped(2)

    parents.zip(children).tapEach {
      case (parent, Seq(left, right)) =>
        parent.left = left
        parent.right = right
    }

    parents.head
  }
}
