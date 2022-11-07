package org.whsv26.leetcode
package sorting

object FirstBadVersion {

  def main(args: Array[String]): Unit = {
    println(firstBadVersion(5))
  }

  def isBadVersion(version: Int): Boolean =
    version >= 4

  def firstBadVersion(n: Int): Int = {
    def iter(i: Int, j: Int): Int = {
      val mid = i + (j - i) / 2

      if (i <= j)
        if (isBadVersion(mid)) {
          val left = iter(i, mid - 1)
          if (left == 0) mid else left
        } else {
          val left = iter(i, mid - 1)
          val right = iter(mid + 1, j)
          if (left == 0) right else left
        }
      else
        0
    }

    iter(1, n)
  }
}
