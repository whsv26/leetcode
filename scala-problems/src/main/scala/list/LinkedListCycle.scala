package org.whsv26.leetcode
package list

import scala.util.control.Breaks.{break, breakable}

object LinkedListCycle {
  def main(args: Array[String]): Unit = {
    val v3 = new ListNode(3, null)
    val v2 = new ListNode(2, null)
    val v0 = new ListNode(0, null)
    val v4 = new ListNode(-4, null)

    v3.next = v2
    v2.next = v0
    v0.next = v4
    v4.next = v2

    assert(hasCycle(v3))
    ()
  }

  def hasCycle(head: ListNode): Boolean = {
    if (head == null || head.next == null) {
      return false
    }

    var res = false
    var turtle = head
    var hair = head

    breakable {
      do {
        hair = if (hair != null && hair.next != null) hair.next.next else null
        turtle = if (turtle != null) turtle.next else null

        if (hair == turtle) {
          res = true
          break
        }

      } while (turtle != null && turtle.next != null)
    }

    res
  }
}
