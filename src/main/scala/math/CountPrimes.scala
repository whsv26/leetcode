package org.whsv26.leetcode
package math

object CountPrimes {

  def main(args: Array[String]): Unit = {
    println(countPrimes(10))
    println(countPrimes(2))
    println(countPrimes(3))

    assert(4 == countPrimes(10))
    assert(0 == countPrimes(2))
    assert(1 == countPrimes(3))
  }

  def countPrimes(n: Int): Int = {
    if (n == 0)
      return 0

    val primes = Array.fill(n)(true)
    primes(0) = false
    primes(primes.length - 1) = false

    for (i <- 2 until n) {
      if (primes(i - 1)) {
        mark(i, primes)
      }
    }

    val res = primes.count(identity)
    res
  }

  def mark(n: Int, arr: Array[Boolean]): Unit = {
    var i = n + n - 1
    while (i < arr.length) {
      arr(i) = false
      i += n
    }
  }
}
