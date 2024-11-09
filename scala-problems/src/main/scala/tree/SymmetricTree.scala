package org.whsv26.leetcode
package tree

import scala.collection.mutable
import scala.util.control.Breaks.{break, breakable}

object SymmetricTree {

  def main(args: Array[String]): Unit = {
    assert(isSymmetricIterative(mkTree(1,2,2,3,4,4,3)))
    assert(!isSymmetricRecursive(mkTree(1,2,2,null,3,null,3)))
  }

  def isSymmetricRecursive(root: TreeNode): Boolean = {
    def iter(lhs: TreeNode, rhs: TreeNode): Boolean =
      if (lhs == null && rhs == null) {
        true
      } else if ((lhs == null || rhs == null) || (lhs.value != rhs.value)) {
        false
      } else {
        iter(lhs.left, rhs.right) && iter(lhs.right, rhs.left)
      }

    iter(root.left, root.right)
  }

  def isSymmetricIterative(root: TreeNode): Boolean = {
    val stack = mutable.Stack((root.left, root.right))
    var symmetric = true

    breakable {
      while (stack.nonEmpty && symmetric) {
        val (lhs, rhs) = stack.pop()

        if ((lhs == null) ^ (rhs == null)) {
          symmetric = false
          break
        } else if (lhs != null) {
          if (lhs.value != rhs.value) {
            symmetric = false
            break
          }

          stack.push((lhs.right, rhs.left))
          stack.push((lhs.left, rhs.right))
        }
      }
    }

    symmetric
  }
}
