package org.whsv26.leetcode
package string

object ImplementStrStr {
  def main(args: Array[String]): Unit = {
    println(strStr("hello", "ll"))
    println(strStr("lhelloll", "ll"))
    println(strStr("aaa", "aaaa"))
    println(strStr("mississippi", "issipi"))
    println(strStr("a", "a"))
  }

  def strStr(haystack: String, needle: String): Int = {
    if (needle.isEmpty) {
      return 0
    } else if (needle.length > haystack.length) {
      return -1
    }

    val nh = needle(0)
    val nLen = needle.length
    val hLen = haystack.length

    var i, j = 0

    while (i < haystack.length) {
      if (haystack(i) == nh && (i - 1 + nLen < hLen)) {

        while (j < nLen && haystack(i + j) == needle(j))
          j += 1

        if (j != nLen) j = 0
        else return i
      }

      i += 1
    }

    -1
  }
}
