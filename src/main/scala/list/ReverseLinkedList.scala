package org.whsv26.leetcode
package list

import scala.annotation.tailrec

object ReverseLinkedList {
  def main(args: Array[String]): Unit = {

    @tailrec def iter(head: ListNode): Unit = {
      println(head.x)

      if (head.next != null)
        iter(head.next)
    }

    val list = new ListNode(1, new ListNode(2, new ListNode(3)))

    iter(reverseList(list))
  }

  def reverseList(head: ListNode): ListNode = {
    if (head == null) {
      return null
    }

    var tmp = head
    var res = new ListNode(head.x)

    while (tmp.next != null) {
      val oldTmp = tmp
      tmp = tmp.next
      oldTmp.next = null

      res = new ListNode(tmp.x, res)
    }

    res
  }

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }
}
