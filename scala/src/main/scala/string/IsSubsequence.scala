package org.whsv26.leetcode
package string

object IsSubsequence {
  object Solution {
    def isSubsequence(s: String, t: String): Boolean = {
      var (i, j) = (0, 0)

      while (i < s.length && j < t.length) {
        if (t(j) == s(i)) {
          i += 1
        }
        j += 1
      }

      i == s.length
    }
  }
}
