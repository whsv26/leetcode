package org.whsv26.leetcode

object PalindromeNumber extends App {
  object Solution {
    def isPalindrome(x: Int): Boolean = {
      var rem = x
      var reversed = 0

      while (rem > 0) {
        reversed = reversed * 10 + (rem % 10)
        rem /= 10
      }

      reversed == x
    }
  }

  assert(Solution.isPalindrome(121))
  assert(Solution.isPalindrome(1352531))
  assert(Solution.isPalindrome(135531))
  assert(!Solution.isPalindrome(-121))
  assert(!Solution.isPalindrome(10))
}
