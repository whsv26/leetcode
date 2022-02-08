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

    @tailrec def iter(cur: ListNode, res: ListNode): ListNode = {
      if (cur.next == null) {
        cur.next = res
        cur
      } else {
        val next = cur.next
        cur.next = res
        iter(next, cur)
      }
    }

    iter(head, null)
  }

  def reverseList1(head: ListNode): ListNode = {
    if (head == null) {
      return null
    }

    var tmp = head
    var res: ListNode = null

    while (tmp.next != null) {
      val oldNext = tmp.next
      tmp.next = res
      res = tmp
      tmp = oldNext
    }

    tmp.next = res
    res = tmp
    res
  }

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }
}
