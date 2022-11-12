package org.whsv26.leetcode
package sorting

object FirstBadVersion {

  def main(args: Array[String]): Unit = {
    println(firstBadVersion(2_000_000_000))
  }

  def isBadVersion(version: Int): Boolean =
    version >= 1_000_000_000

  def firstBadVersion(n: Int): Int = {
    def iter(i: Int, j: Int, prevBad: Option[Int]): Int = {
      val mid = i + (j - i) / 2

      if (i <= j) {
        if (isBadVersion(mid)) {
          val bad = iter(i, mid - 1, Some(mid))
          if (bad > 0) bad else mid
        } else if (prevBad.isDefined) {
          val bad = iter(mid + 1, j, prevBad)
          if (bad > 0) bad else prevBad.get
        } else {
          val bad = iter(mid + 1, j, prevBad)
          if (bad > 0) bad else iter(i, mid - 1, prevBad)
        }
      } else {
        0
      }
    }

    iter(1, n, None)
  }
}
