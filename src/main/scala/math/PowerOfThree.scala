package org.whsv26.leetcode
package math

import java.lang.Math.log

object PowerOfThree {

  def main(args: Array[String]): Unit = {
    println(isPowerOfThree(27))
    println(isPowerOfThree(0))
    println(isPowerOfThree(-1))
    println(isPowerOfThree(243))
  }

  def isPowerOfThree(n: Int): Boolean = {
    if (n == 0)
      return false

    val pow = (log(n) / log(3)).ceil

    Math.pow(3, pow) == n
  }
}
