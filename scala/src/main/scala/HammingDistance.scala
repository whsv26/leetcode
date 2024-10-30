package org.whsv26.leetcode

object HammingDistance {

  def main(args: Array[String]): Unit = {
    assert(2 == hammingDistance(1, 4))
  }

  def hammingDistance(x: Int, y: Int): Int =
    hammingWeight(x ^ y)

  def hammingWeight(n: Int): Int = {
    var rest = n
    var weight = 0

    if (rest < 0) {
      rest ^= Int.MinValue
      weight += 1
    }

    while (rest != 0) {
      rest &= rest - 1 // remove rightmost 1 bit
      weight += 1
    }

    weight
  }
}
