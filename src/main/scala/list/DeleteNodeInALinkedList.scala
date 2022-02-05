package org.whsv26.leetcode
package list

object DeleteNodeInALinkedList {
  def main(args: Array[String]): Unit = {
   val x0 = new ListNode(0)
   val x1 = new ListNode(1)
   val x2 = new ListNode(2)

    x0.next = x1
    x1.next = x2

    deleteNode(x1)
  }

  def deleteNode(node: ListNode): Unit = {
    node.x = node.next.x
    node.next = node.next.next
  }


  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }
}
