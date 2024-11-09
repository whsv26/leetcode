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

    var cur = head
    var res: ListNode = null

    while (cur.next != null) {
      val tmpNext = cur.next
      cur.next = res
      res = cur
      cur = tmpNext
    }

    cur.next = res
    res = cur
    res
  }
}
