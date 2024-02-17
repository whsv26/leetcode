// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    var sum = 0

    for {
      i <- 1 until prices.length
      if prices(i) > prices(i - 1)
    } sum += prices(i) - prices(i - 1)

    sum
  }
}

Solution.maxProfit(Array(7,1,5,3,6,4))