package org.whsv26.leetcode
package others

object NumberOfOneBits {

  def main(args: Array[String]): Unit = {
    println(hammingWeight(Integer.parseUnsignedInt("11111111111111111111111111111101", 2)))
  }

  def hammingWeight(n: Int): Int = {
    var rest = n
    var weight = 0

    if (rest < 0) {
      rest ^= Int.MinValue
      weight += 1
    }

    while (rest != 0) {
      weight += rest & 1
      rest >>= 1
    }

    weight
  }
}
