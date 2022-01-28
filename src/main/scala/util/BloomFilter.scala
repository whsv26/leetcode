package org.whsv26.leetcode
package util

import scala.util.Random.nextInt

class BloomFilter(val n: Int, val p: Double) {
  private var bitMap: Int = 0

  private val m = Math.round {
    -n * Math.log(p) / (Math.pow(Math.log(2), 2))
  }

  private val k = Math.floor(Math.log(2) * m / n).toInt

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