package org.whsv26.leetcode
package list

import scala.annotation.tailrec

object RemoveNthNodeFromEndOfList {
  def main(args: Array[String]): Unit = {

    @tailrec def iter(head: ListNode): Unit = {
      println(head.x)

      if (head.next != null)
        iter(head.next)
    }

    val y1 = new ListNode(1)
    val res = removeNthFromEnd(y1, 1)

    iter(res)
  }

  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {

    var tmp, tmpDelayed = head
    var len = 1

    while (tmp.next != null) {
      if (len > n) {
        tmpDelayed = tmpDelayed.next
      }

      tmp = tmp.next
      len += 1
    }

    if (n < len) {
      tmpDelayed.next.x = tmpDelayed.x
      tmpDelayed.next = tmpDelayed.next.next
      head
    } else if (n == len && len == 1) {
      null
    } else if (n == len) {
      head.next
    } else {
      head
    }
  }

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }
}
