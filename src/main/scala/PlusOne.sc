// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/

object Solution {
  def plusOne(digits: Array[Int]): Array[Int] = {
    var i = digits.length - 1
    var over = 1

    do {
      if (digits(i) + over > 9) {
        over = (digits(i) + over) % 9
        digits(i) = 0
      } else {
        digits(i) += over
        over = 0
      }

      i -= 1

    } while (over > 0 && i >= 0)

    if (over > 0)
      digits.prepended(1)
    else digits
  }
}

Solution.plusOne(Array(2, 9, 9, 9))
Solution.plusOne(Array(9))