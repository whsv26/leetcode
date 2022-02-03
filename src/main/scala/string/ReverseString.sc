// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/

/**
 * Runtime: 1132 ms
 * Memory Usage: 92.2 MB
 */
object Solution1 {
  def reverseString(s: Array[Char]): Unit = {
    for (i <- 0 until s.length / 2) {
      val tmp = s(i)
      s(i) = s(s.length - i - 1)
      s(s.length - i - 1) = tmp
    }
  }
}

/**
 * Runtime: 1319 ms
 * Memory Usage: 95 MB
 */
object Solution2 {
  def reverseString(s: Array[Char]): Unit = {
    var i = 0
    var tmp: Char = 0

    while (i < s.length / 2) {
      tmp = s(i)
      s(i) = s(s.length - i - 1)
      s(s.length - i - 1) = tmp
      i += 1
    }
  }
}

/**
 * Runtime: 1042 ms
 * Memory Usage: 85.3 MB
 */
object Solution3 {
  def reverseString(s: Array[Char]): Unit = {
    var i = 0

    while (i < s.length / 2) {
      val tmp = s(i)
      s(i) = s(s.length - i - 1)
      s(s.length - i - 1) = tmp
      i += 1
    }
  }
}

val in = Array('a', 'b', 'c', 'd')
Solution2.reverseString(in)
in

