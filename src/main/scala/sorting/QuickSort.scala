package org.whsv26.leetcode
package sorting

import scala.annotation.tailrec

object QuickSort {

  def main(args: Array[String]): Unit = {
    assert(Array(1, 1, 3, 4, 6, 8) sameElements quickSort(Array(3, 8, 1, 4, 6, 1)))
  }

  def quickSort(arr: Array[Int]): Array[Int] = {
    def sort(s: Int, e: Int): Unit = {
      if (s < e) {
        val pivot = partitionRec(arr)(s, e)
        sort(s, pivot - 1)
        sort(pivot + 1, e)
      }
    }

    sort(0, arr.length - 1)
    arr
  }

  private def swap[T](arr: Array[T])(i: Int, j: Int): Unit = {
    val stash = arr(j)
    arr(j) = arr(i)
    arr(i) = stash
  }

  private def partitionRec[T: Ordering](arr: Array[T])(low: Int, high: Int): Int = {
    val pivot = arr(high)

    @tailrec
    def loop(i: Int, j: Int): Int = {
      if (j < high) {
        if (Ordering[T].lt(arr(j), pivot)) {
          swap(arr)(i, j)
          loop(i + 1, j + 1)
        } else {
          loop(i, j + 1)
        }
      } else {
        swap(arr)(i, j)
        i
      }
    }

    loop(low, low)
  }

  @deprecated
  private def partition(arr: Array[Int])(low: Int, high: Int): Int = {
    val pivot = high
    var i = low

    for (j <- low to high if arr(j) < arr(pivot)) {
      swap(arr)(i, j)
      i += 1
    }

    swap(arr)(i, pivot)
    i
  }
}
