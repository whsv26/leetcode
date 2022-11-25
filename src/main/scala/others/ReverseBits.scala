package org.whsv26.leetcode
package others

import java.lang.Math.pow

object ReverseBits {

  def main(args: Array[String]): Unit = {
    println("NUM = " + Integer.parseUnsignedInt("1010101010101010", 2).toBinaryString)
    println("1010101010101010 -> " + reverseBits(Integer.parseUnsignedInt("1010101010101010", 2)).toBinaryString)
  }

  def reverseBits(x: Int): Int = {
    var res = x

    for (i <- 0 until 16) {
      val j = 30 - i
      val unsetted = res & ~(1 << i) & ~(1 << j)
      val swappedA = (x & (1 << i)) << j
      val swappedB = (x & (1 << j)) >> j
      val swapped = swappedA | swappedB

      val swappedABinaryString = swappedA.toBinaryString

      res = unsetted | swapped
      println(s"swapped = swappedA(${swappedABinaryString}) | swappedB(${swappedB.toBinaryString})")
      println(s"unsetted(${unsetted.toBinaryString}) | swapped(${swapped.toBinaryString}) = ${res.toBinaryString}")
      println
    }

    res
  }

}
