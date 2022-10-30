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

    @tailrec def iter(n1: ListNode, n2: ListNode): Unit = {
      if (n2.next != null) {
        mergeOne(n1, n2) match {
          case (lhs, rhs) => iter(lhs, rhs)
        }
      } else if (n2.next == null) {
        mergeOne(n1, n2)
      }
    }

    iter(list1, list2)

    list1
  }

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
    } else if (i.next == null) {
      val ln2Next = ln2.next
      ln2.next = null
      i.next = ln2
      (i, ln2Next)
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
}
