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

  def mkTree(nodes: TreeNode*): TreeNode =
    deserialize {
      nodes
        .map(n => if (n == null) "null" else n.value.toString)
        .mkString("[", ",", "]")
    }
}
