package org.whsv26.leetcode
package string

import scala.collection.mutable

object ValidAnagram {
  def main(args: Array[String]): Unit = {
    println(isAnagram("anagram", "nagaram"))
    println(isAnagram("anagrcm", "nagaram"))
  }

  def isAnagram(s: String, t: String): Boolean = {
    if (s.length != t.length) {
      return false
    }

    val occrs = mutable.HashMap.empty[Char, Int]

    for (i <- 0 until s.length) {
      occrs.update(s(i), occrs.getOrElse(s(i), 0) + 1)
      occrs.update(t(i), occrs.getOrElse(t(i), 0) - 1)
    }

    occrs.forall(_._2 == 0)
  }
}
