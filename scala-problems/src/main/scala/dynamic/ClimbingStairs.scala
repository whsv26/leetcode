package org.whsv26.leetcode
package dynamic

object ClimbingStairs {

  def main(args: Array[String]): Unit = {
    println(climbStairs(1))
    println(climbStairs(2))
    println(climbStairs(3))
    println(climbStairs(4))
    println(climbStairs(5))

  }

  def climbStairsFaster(n: Int): Int = {
    if (n == 1) {
      return 1
    }

    var oneStepBack = 2
    var twoStepsBack = 1
    var i = 3

    while (i <= n) {
      val tmp = oneStepBack + twoStepsBack
      twoStepsBack = oneStepBack
      oneStepBack = tmp

      i += 1
    }

    oneStepBack
  }

  def climbStairs(n: Int): Int = {
    val cache = Array.fill(n + 2)(0)
    cache(1) = 1
    cache(2) = 2

    var i = 3

    while (i <= n) {
      cache(i) = cache(i - 1) + cache(i - 2)

      i += 1
    }

    cache(n)
  }
}
