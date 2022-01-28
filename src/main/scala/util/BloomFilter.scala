package org.whsv26.leetcode
package util

import java.lang.Math.{floor, log, pow, round}
import scala.util.Random.nextInt

class BloomFilter(val n: Int, val p: Double) {
  private var bitMap: Int = 0

  private val m = round {
    -n * log(p) / (pow(log(2), 2))
  }

  private val k = floor(log(2) * m / n).toInt

  private val salts = LazyList.continually(nextInt).take(k).toList

  private def hash(elem: Int, salt: Int) = {
    ((elem + salt) & 0x7fffffff) % m
  }

  def put(elem: Int): Unit =
    salts.tapEach { salt =>
      bitMap |= 1 << hash(elem, salt)
    }

  def apply(elem: Int): Boolean =
    salts.forall { salt: Int =>
      ((bitMap >> hash(elem, salt)) & 1) == 1
    }
}