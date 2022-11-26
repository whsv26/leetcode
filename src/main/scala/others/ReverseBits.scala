package org.whsv26.leetcode
package others

object ReverseBits {

  def main(args: Array[String]): Unit = {
    println(reverseBits(Integer.parseUnsignedInt("00000010100101000001111010011100", 2)).toBinaryString)
  }

  def reverseBitsInlined(x: Int): Int = {
    var res = x

    for (i <- 0 until 16) {
      res = set(set(res, i, (res & (1 << 31 - i)) >> 31 - i), 31 - i, (res & (1 << i)) >> i)
    }

    res
  }

  def reverseBits(x: Int): Int = {
    var res = x

    for (i <- 0 until 16) {
      res = swap(res, i, 31 - i)
    }

    res
  }

  @inline def swap(number: Int, i: Int, j: Int): Int =
    set(set(number, i, get(number, j)), j, get(number, i))

  @inline def get(number: Int, pos: Int): Int =
    (number & (1 << pos)) >> pos

  @inline def set(number: Int, pos: Int, v: Int): Int =
    number ^ (-v ^ number) & (1 << pos)

  /**
   * shift range is 0-31
   * ~(1 << i) trick is not working if i == 31
   */
  def swapUnsafe(i: Int, j: Int)(n: Int): Int = {
    val unsetted = n & ~(1 << i) & ~(1 << j)
    val swapLeft = (n & (1 << i)) << (j - i)
    val swapRight = (n & (1 << j)) >> (j - i)
    val swapped = swapLeft | swapRight
    unsetted | swapped
  }
}
