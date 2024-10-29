package org.whsv26.leetcode

object HammingDistance {

  def main(args: Array[String]): Unit = {
    assert(2 == hammingDistance(1, 4))
  }

  def hammingDistance(x: Int, y: Int): Int =
    hammingWeight(x ^ y)
}
