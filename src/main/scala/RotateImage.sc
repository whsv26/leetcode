// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/

/**
 * [1, 2, 3]    [7, 4, 1]
 * [4, 5, 6] -> [8, 5, 2]
 * [7, 8, 9]    [9, 6, 3]
 *
 * Rotate via diagonal [7, 5, 3]
 * Mirror result
 */
object Solution {
  def rotate(matrix: Array[Array[Int]]): Unit = {
    diagonalRotation(matrix)

    for {
      row <- (matrix.length / 2) until matrix.length
      col <- matrix.indices
    } {
      swapPoints(matrix)(
        col,
        row,
        col,
        matrix.length - 1 - row,
      )
    }
  }

  def diagonalRotation(matrix: Array[Array[Int]]): Unit = {
    val swap: (Int, Int, Int, Int) => Unit = swapPoints(matrix)

    def rotateY(x: Int, y: Int): Unit = {
      for (yy <- 0 until y) {
        swap(
          x,
          yy,
          matrix.length - 1 - yy,
          matrix.length - 1 - x
        )
      }
    }

    for (i <- matrix.indices) {
      rotateY(matrix.length - 1 - i, i)
    }
  }

  def swapPoints(matrix: Array[Array[Int]])(x1: Int, y1: Int, x2: Int, y2: Int): Unit = {
    val tmp = matrix(y1)(x1)
    matrix(y1)(x1) = matrix(y2)(x2)
    matrix(y2)(x2) = tmp
  }
}

/**
 * TODO
 * x2 = (cos(-90) * x1) − (sin(-90) * y1)
 * y2 = (sin(-90) * x1) + (cos(-90) * y1)
 *
 * x2 = −y1
 * y2 = x1
 *
 * (2, 0) -> (0, 2)
 */
object Solution1 {
  def rotate(matrix: Array[Array[Int]]): Unit = {
    val swap: (Int, Int, Int, Int) => Unit = swapPoints(matrix)

    for {
      x <- matrix.indices
      y <- matrix.indices
    } {
      matrix(x)(-y + (matrix.length - 1)) = matrix(y)(x)
    }
  }


  def swapPoints(matrix: Array[Array[Int]])(x1: Int, y1: Int, x2: Int, y2: Int): Unit = {
    val tmp = matrix(y1)(x1)
    matrix(y1)(x1) = matrix(y2)(x2)
    matrix(y2)(x2) = tmp
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

