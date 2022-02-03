// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/

import scala.collection.mutable

object Solution {
  def firstUniqChar(s: String): Int = {
    val map = s.foldLeft(mutable.HashMap.empty[Char, Int]) {
      (acc, cur) => {
        acc.update(cur, acc.getOrElse(cur, 0) + 1)
        acc
      }
    }

    s.indexWhere(map(_) == 1)
  }
}

Solution.firstUniqChar("leetcode")
Solution.firstUniqChar("loveleetcode")