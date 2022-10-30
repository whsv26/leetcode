package org.whsv26.leetcode
package list

import list.ReverseLinkedList.reverseList
import scala.util.control.Breaks.{break, breakable}

object PalindromeLinkedList {
  def main(args: Array[String]): Unit = {
    assert(isPalindrome(mkList(1,2,3,3,4,3,3,4,3,3,2,1)))
    assert(isPalindrome(mkList(1,2,3,2,1)))
    assert(isPalindrome(mkList(1,2,2,1)))
    assert(!isPalindrome(mkList(1,2)))
    assert(!isPalindrome(mkList(1,1,2,1)))

    ()
  }

  def isPalindrome(head: ListNode): Boolean = {
    if (head == null || head.next == null) {
      return true
    }

    if (head.next.next == null) {
      return head.x == head.next.x
    }

    val mid = middle(head)
    val reversed = reverseList(mid)
    compare(reversed, head)
  }

  def middle(head: ListNode): ListNode = {
    var slow = head
    var fast = head

    while (fast != null && fast.next != null) {
      fast = fast.next.next
      slow = slow.next
    }

    slow
  }

  def compare(lhs: ListNode, rhs: ListNode): Boolean = {
    var i = lhs
    var j = rhs
    var isSame = i.x == j.x

    breakable {
      while (i.next != null) {
        i = i.next
        j = j.next

        if (i.x != j.x) {
          isSame = false
          break
        }
      }
    }

    isSame
  }
}
