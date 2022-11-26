package org.whsv26.leetcode
package others

object ReverseBits {

  def main(args: Array[String]): Unit = {
    println(reverseBits(Integer.parseUnsignedInt("00000010100101000001111010011100", 2)).toBinaryString)
  }

  def reverseBits(x: Int): Int = {
    var res = x

    for (i <- 0 until 16) {
      res = swap1(res, i, 31 - i)
    }

    res
  }

  @inline def swap1(number: Int, i: Int, j: Int): Int =
    set1(set1(number, i, get(number, j)), j, get(number, i))

  @inline def swap2(i: Int, j: Int)(n: Int): Int = {
    val unsetted = n & ~(1 << i) & ~(1 << j)
    val swapped = ((n & (1 << i)) << (j - i)) | ((n & (1 << j)) >>> (j - i))
    unsetted | swapped
  }

  @inline def get(number: Int, pos: Int): Int =
    (number & (1 << pos)) >> pos

  @inline def set1(number: Int, pos: Int, v: Int): Int =
    number ^ (-v ^ number) & (1 << pos)

  @inline def set2(number: Int, pos: Int, v: Int): Int =
    (number & ~(1 << pos)) | (v << pos)
}
