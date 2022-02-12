package org.whsv26.leetcode
package list

import scala.annotation.tailrec

object MergeTwoSortedLists {
  def main(args: Array[String]): Unit = {
    test1()
    test2()
    test3()
    test4()
    test5()
  }

  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    if (list1 == null) {
      return list2
    } else if (list2 == null) {
      return list1
    }

    var n1 = list1
    var n2 = list2

    mergeOne(n1, n2) match {
      case (lhs, rhs) => {
        n1 = lhs
        n2 = rhs
      }
    }

    while (n2 != null && n2.next != null) {
      mergeOne(n1, n2) match {
        case (lhs, rhs) => {
          n1 = lhs
          n2 = rhs
        }
      }
    }

    mergeOne(n1, n2) match {
      case (lhs, rhs) => {
        n1 = lhs
        n2 = rhs
      }
    }

    list1
  }

  /**
   * Find node to append and append to this node
   * If no node to append found then prepend to first node
   */
  def mergeOne(ln1: ListNode, ln2: ListNode): (ListNode, ListNode) = {
    if (ln2 == null) {
      return (ln1, ln2)
    }

    var i = ln1
    var j = ln1.next

    while (j != null && j.x < ln2.x) {
      i = j
      j = j.next
    }

    if (i == ln1 && ln1.x > ln2.x) {
      val ln1Copy = new ListNode(ln1.x, ln1.next)
      ln1.x = ln2.x
      ln1.next = ln1Copy
      (ln1, ln2.next)
    } else {
      val ln1Next = i.next
      val ln2Next = ln2.next

      i.next = ln2
      ln2.next = ln1Next

      (ln1Next, ln2Next)
    }
  }

  def test1(): Unit = {
    val listA = new ListNode(1, new ListNode(2, new ListNode(4)))
    val listB = new ListNode(1, new ListNode(3, new ListNode(4)))
    val actual = listToVector(mergeTwoLists(listA, listB))
    println(actual)
    assert(Vector(1,1,2,3,4,4) == actual)
  }

  def test2(): Unit = {
    val listA = null
    val listB = null
    val actual = listToVector(mergeTwoLists(listA, listB))
    println(actual)
    assert(Vector() == actual)
  }

  def test3(): Unit = {
    val listA = null
    val listB = new ListNode(0)
    val actual = listToVector(mergeTwoLists(listA, listB))
    println(actual)
    assert(Vector(0) == actual)
  }

  def test4(): Unit = {
    val listA = new ListNode(2)
    val listB = new ListNode(1)
    val actual = listToVector(mergeTwoLists(listA, listB))
    println(actual)
    assert(Vector(1, 2) == actual)
  }

  def test5(): Unit = {
    val listA = new ListNode(-9, new ListNode(3))
    val listB = new ListNode(5, new ListNode(7))
    val actual = listToVector(mergeTwoLists(listA, listB))
    println(actual)
    assert(Vector(-9,3,5,7) == actual)
  }

  @tailrec def listToVector(head: ListNode, acc: Vector[Int] = Vector.empty): Vector[Int] = {
    if (head == null) {
      acc
    } else if (head.next != null) {
      listToVector(head.next, acc.appended(head.x))
    } else {
      acc.appended(head.x)
    }
  }

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }
}
