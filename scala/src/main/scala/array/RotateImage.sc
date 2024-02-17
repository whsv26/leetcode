// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/

/**
 * x2 = (cos(-90) * x1) − (sin(-90) * y1)
 * y2 = (sin(-90) * x1) + (cos(-90) * y1)
 *
 * x2 = −y1
 * y2 = x1
 */
object Solution {
  def rotate(matrix: Array[Array[Int]]): Unit = {
    for {
      y <- 0 to (matrix.length - 1) / 2
      x <- y until (matrix.length - 1 - y)
    } rotatePoint(matrix)(x, y)
  }

  def rotatePoint(matrix: Array[Array[Int]])(
    xInit: Int,
    yInit: Int
  ): Unit = {

    var xCurr = xInit
    var yCurr = yInit
    var xNext = -yCurr + (matrix.length - 1)
    var yNext = xCurr
    var valCurr = matrix(yCurr)(xCurr)
    var valNext = matrix(yNext)(xNext)

    do {
      valNext = matrix(yNext)(xNext)
      matrix(yNext)(xNext) = valCurr
      valCurr = valNext

      xCurr = xNext
      yCurr = yNext
      xNext = -yCurr + (matrix.length - 1)
      yNext = xCurr

    } while (xCurr != xInit || yCurr != yInit)
  }
}

val in = Array(
  Array(1, 2, 3), // Array(7, 4, 1)
  Array(4, 5, 6), // Array(8, 5, 2)
  Array(7, 8, 9), // Array(9, 6, 3)
)
Solution.rotate(in)
in

val in = Array(
  Array( 5,  1,  9, 11), // Array(15, 13,  2,  5),
  Array( 2,  4,  8, 10), // Array(14,  3,  4,  1),
  Array(13,  3,  6,  7), // Array(12,  6,  8,  9),
  Array(15, 14, 12, 16)  // Array(16,  7, 10, 11)
)
Solution.rotate(in)
in
