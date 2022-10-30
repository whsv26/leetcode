package org.whsv26.leetcode

package object list {
  class ListNode(var x: Int = 0, var next: ListNode = null)

  def mkList(head: Int, tail: Int*): ListNode = {
    val elems = head +: tail
    elems.dropRight(1).foldRight(new ListNode(elems.last)) {
      case (cur, acc) => new ListNode(cur, acc)
    }
  }

  def toList(head: ListNode): List[Int] =
    if (head.next != null)
      head.x :: toList(head.next)
    else head.x :: Nil
}
