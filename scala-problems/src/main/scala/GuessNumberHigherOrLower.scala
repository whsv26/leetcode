package org.whsv26.leetcode

import scala.annotation.tailrec

object GuessNumberHigherOrLower {

  class RecursiveSolution {
    def guessNumber(n: Int): Int = {
      @tailrec
      def loop(l: Int, r: Int): Int = {
        val mid = (r - l) / 2 + l
        guess(mid) match {
          case -1 => loop(l, mid - 1)
          case 1 => loop(mid + 1, r)
          case 0 => mid
        }
      }
      loop(1, n)
    }
  }

  class Solution {
    def guessNumber(n: Int): Int = {
      var (l, r) = (1, n)

      while (l < r) {
        val mid = (r - l) / 2 + l
        guess(mid) match {
          case -1 => r = mid - 1
          case 1 => l = mid + 1
          case 0 => l = mid; r = mid
        }
      }

      l
    }
  }

  /**
   * The API guess is defined in the parent class.
   * @param  num your guess
   * @return -1 if num is higher than the picked number
   *          1 if num is lower than the picked number
   *          otherwise return 0
   */
  def guess(num: Int): Int = ???
}
