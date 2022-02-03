// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/

object Solution {
  def reverse(x: Int): Int = {
    val reversed = x.abs
      .toString
      .reverse
      .toIntOption
      .getOrElse(0)

    if (x > 0)
      reversed
    else -reversed
  }
}

Solution.reverse(-321) // -123
Solution.reverse(120) // 21
Solution.reverse(1534236469)