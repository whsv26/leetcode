package org.whsv26.leetcode
package string

object FindTheDifference extends App {

  object Solution {
    def findTheDifference(s: String, t: String): Char =
      (s.foldLeft(0)(_ ^ _) ^ t.foldLeft(0)(_ ^ _)).asInstanceOf[Char]
  }

  assert('e' == Solution.findTheDifference("abcd", "abcde"))
}
