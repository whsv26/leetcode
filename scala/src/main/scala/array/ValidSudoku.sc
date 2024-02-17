// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/

import scala.collection.mutable.{BitSet => MBitSet}
import scala.collection.mutable.{HashMap => MHashMap}

object Solution {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    val squares = MHashMap.empty[Int, MBitSet]
    val rows = MHashMap.empty[Int, MBitSet]
    val cols = MHashMap.empty[Int, MBitSet]
    var res: Boolean = true

    for {
      i <- 0 until 9
      j <- 0 until 9
      if board(i)(j) != '.'
    } {
      val iSet = rows.getOrElseUpdate(i, MBitSet.empty)
      val jSet = cols.getOrElseUpdate(j, MBitSet.empty)
      val sqSet = squares.getOrElseUpdate(
        (i / 3) * 3 + (j / 3),
        MBitSet.empty
      )

      if (!iSet(board(i)(j))) iSet.addOne(board(i)(j))
      else return false

      if (!jSet(board(i)(j))) jSet.addOne(board(i)(j))
      else return false

      if (!sqSet(board(i)(j))) sqSet.addOne(board(i)(j))
      else return false
    }

    res
  }
}

Solution.isValidSudoku(Array(
  Array('5','3','.','.','7','.','.','.','.'),
  Array('6','.','.','1','9','5','.','.','.'),
  Array('.','9','8','.','.','.','.','6','.'),
  Array('8','.','.','.','6','.','.','.','3'),
  Array('4','.','.','8','.','3','.','.','1'),
  Array('7','.','.','.','2','.','.','.','6'),
  Array('.','6','.','.','.','.','2','8','.'),
  Array('.','.','.','4','1','9','.','.','5'),
  Array('.','.','.','.','8','.','.','7','9'),
))

Solution.isValidSudoku(Array(
  Array('8','3','.','.','7','.','.','.','.'),
  Array('6','.','.','1','9','5','.','.','.'),
  Array('.','9','8','.','.','.','.','6','.'),
  Array('8','.','.','.','6','.','.','.','3'),
  Array('4','.','.','8','.','3','.','.','1'),
  Array('7','.','.','.','2','.','.','.','6'),
  Array('.','6','.','.','.','.','2','8','.'),
  Array('.','.','.','4','1','9','.','.','5'),
  Array('.','.','.','.','8','.','.','7','9'),
))
