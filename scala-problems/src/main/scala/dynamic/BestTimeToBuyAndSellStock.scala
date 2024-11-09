package org.whsv26.leetcode
package dynamic

// not dynamic programming
object BestTimeToBuyAndSellStock {

  def main(args: Array[String]): Unit = {
    println(maxProfit(Array(7,1,5,3,6,4)))
  }

  def maxProfit(prices: Array[Int]): Int = {
    if (prices.length < 1)
      return 0

    var i = 1
    var minPrice = prices(0)
    var maxProfit = 0

    while (i < prices.length) {
      maxProfit = Math.max(prices(i) - minPrice, maxProfit)
      minPrice = Math.min(prices(i), minPrice)

      i += 1
    }

    maxProfit
  }
}
