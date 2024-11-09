package org.whsv26.leetcode

object RomanToInteger {

  def main(args: Array[String]): Unit = {
    println(romanToInt("III")) // 3
    println(romanToInt("LVIII")) // 58
    println(romanToInt("MCMXCIV")) // 1994
  }

  def romanToInt(s: String): Int = {
    var i = 0
    var sum = 0

    while (i < s.length) {
      val a = s(i)
      val b = if (s.isDefinedAt(i + 1)) s(i + 1) else ' '
      val ab = a -> b

      if (complex.isDefinedAt(ab)) {
        sum += complex(ab)
        i += 2
      } else {
        sum += simple(a)
        i += 1
      }
    }

    sum
  }

  def complex: PartialFunction[(Char, Char), Int] =
    {
      case ('I', 'V') => 4
      case ('I', 'X') => 9
      case ('X', 'L') => 40
      case ('X', 'C') => 90
      case ('C', 'D') => 400
      case ('C', 'M') => 900
    }

  def simple(char: Char) =
    char match {
      case 'I' => 1
      case 'V' => 5
      case 'X' => 10
      case 'L' => 50
      case 'C' => 100
      case 'D' => 500
      case 'M' => 1000
      case _ => 0
    }
}
