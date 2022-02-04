package org.whsv26.leetcode
package string

object ValidPalindrome {
  def main(args: Array[String]): Unit = {
    println(isPalindrome2("amanaplanacanalpanama"))
    println(isPalindrome2("A man, a plan, a canal: Panama"))
    println(isPalindrome2(" "))
    println(isPalindrome2(".,"))
  }

  /**
   * Runtime: 484 ms
   * Memory Usage: 53 MB
   */
  def isPalindrome1(s: String): Boolean = {
    val ss = s.filter(_.isLetterOrDigit)
    val len = ss.length

    var i = 0

    while (i < len / 2) {
      if (ss(i).toLower == ss(len - 1 - i).toLower) {
        i += 1
      } else {
        return false
      }
    }

    true
  }

  /**
   * Runtime: 834 ms
   * Memory Usage: 68.6 MB
   */
  def isPalindrome2(s: String): Boolean = {
    val len = s.length

    var i = 0
    var j = len - 1

    while (i < j && !s(i).isLetterOrDigit) i += 1
    while (i < j && !s(j).isLetterOrDigit) j -= 1

    while (i < j) {
      if (s(i).toLower == s(j).toLower) {
        i += 1
        j -= 1
      } else {
        return false
      }

      while (!s(i).isLetterOrDigit) i += 1
      while (!s(j).isLetterOrDigit) j -= 1
    }

    true
  }
}
