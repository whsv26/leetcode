// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/

object Solution {
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.isEmpty) return ""

    val sb = new StringBuilder
    val h = strs.head

    for (i <- 0 until h.length) {
      val p = strs.exists { s =>
        i >= s.length || s(i) != h(i)
      }

      if (p) return sb.toString
      else sb.addOne(h(i))
    }

    sb.toString
  }
}

Solution.longestCommonPrefix(Array("flower","flow","flight")) // "fl"
Solution.longestCommonPrefix(Array("dog","racecar","car")) // ""