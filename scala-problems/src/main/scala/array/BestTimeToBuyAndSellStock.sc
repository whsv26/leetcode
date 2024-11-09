// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

object Solution1 {
  def maxProfit(prices: Array[Int]): Int = {
    var sum = 0

    for {
      i <- 1 until prices.length
      if prices(i) > prices(i - 1)
    } sum += prices(i) - prices(i - 1)

    sum
  }
}

object Solution2 {
  def maxProfit(prices: Array[Int]): Int =
    prices.iterator.drop(1)
      .zip(prices.iterator)
      .foldLeft(0) {
        case (sum, (curr, prev)) if curr > prev => sum + curr - prev
        case (sum, _) => sum
      }
}

Solution2.maxProfit(Array(7,1,5,3,6,4))