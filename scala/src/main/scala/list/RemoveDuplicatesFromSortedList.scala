package org.whsv26.leetcode
package list

object RemoveDuplicatesFromSortedList extends App {
  object Solution {
    def deleteDuplicates(head: ListNode): ListNode = {
      var node = head

      while (node != null && node.next != null) {
        if (node.x == node.next.x) {
          node.next = node.next.next
        } else {
          node = node.next
        }
      }

      head
    }
  }
}
