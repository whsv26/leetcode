package org.whsv26.leetcode
package string

import java.lang.Math.{max, min, pow}

object StringToInteger {
  def main(args: Array[String]): Unit = {
    println(myAtoi("2147483648"))
  }

  def myAtoi(s: String): Int = {
    val trimmed = s.trim

    val prefix = Some(trimmed.take(2).toList)
      .flatMap {
        case a :: b :: _ if a == '+' && b.isDigit => Some(1)
        case a :: b :: _ if a == '-' && b.isDigit => Some(-1)
        case a :: _ if a.isDigit => Some(1)
        case _ => None
      }

    if (prefix.isEmpty) {
      return 0
    }

    val sign = prefix.get

    val digits = trimmed.dropWhile(!_.isDigit)

    val compressedDigits = if (digits.startsWith("0"))
      digits.dropWhile(_ == '0').prepended('0')
    else digits

    compressedDigits
      .take(11)
      .takeWhile(_.isDigit)
      .reverse
      .zipWithIndex
      .foldLeft[Long](0) {
        (acc, cur) => {
          val part = sign * pow(10, cur._2).toLong * cur._1.asDigit

          if (sign > 0) {
            min(acc + part, Int.MaxValue)
          } else {
            max(acc + part, Int.MinValue)
          }
        }
      }
      .toInt
  }

  implicit class StringSyntax(s: String) {
    def at(idx: Int): Option[Char] =
      if (idx >= 0 && idx < s.length) Some(s.charAt(idx))
      else None
  }
}
