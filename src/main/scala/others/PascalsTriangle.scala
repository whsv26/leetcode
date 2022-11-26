package org.whsv26.leetcode
package others

object PascalsTriangle {

  def main(args: Array[String]): Unit = {
    println(generate(5))
  }

  def generate(numRows: Int): List[List[Int]] = {
    val rows = new Array[Array[Int]](numRows)
    rows(0) = Array(1)

    for (i <- 1 until numRows) {
      val row = new Array[Int](i + 1)

      for (j <- 0 to i) {
        val lhs = if (rows(i - 1).isDefinedAt(j - 1))
          rows(i - 1)(j - 1)
        else 0

        val rhs = if (rows(i - 1).isDefinedAt(j))
          rows(i - 1)(j)
        else 0

        row(j) = lhs + rhs
      }

      rows(i) = row
    }

    rows.map(_.toList).toList
  }
}
