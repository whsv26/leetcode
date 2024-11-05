package org.whsv26.leetcode
package string

object LongestPalindrome extends App {

  def longestPalindrome(s: String): Int = {
    val occurencesByChar = s.groupMapReduce(identity)(_ => 1)(_ + _)

    val occurenceSum = occurencesByChar.values.collect {
      case n if n % 2 == 0 => n
      case n if n % 2 != 0 => n - 1
    }.sum

    if (occurenceSum < s.length) occurenceSum + 1
    else occurenceSum
  }

  assert(11 == longestPalindrome("aaabbbccddee"))
  assert(11 == longestPalindrome("aaabbccddee"))
  assert(7 == longestPalindrome("xqaaaddee"))
  assert(1 == longestPalindrome("abcde"))

}
