package org.whsv26.leetcode
package sorting

import cats.Eval
import cats.syntax.apply._

object MergeSort {

  def main(args: Array[String]): Unit = {
    assert(List(1, 1, 3, 4, 6, 8) == mergeSort(List(3, 8, 1, 4, 6, 1)))
  }

  def mergeSort(in: List[Int]): List[Int] = {
    def loop(list: List[Int]): Eval[List[Int]] =
      list match {
        case Nil => Eval.now(Nil)
        case head :: Nil => Eval.now(List(head))
        case _ =>
          val (xs, ys) = list.splitAt(list.length / 2)
          (loop(xs), loop(ys)).flatMapN(mergeT)
      }

    loop(in).value
  }

  // stack safe
  private def mergeT(lhs: List[Int], rhs: List[Int]): Eval[List[Int]] = {
    (lhs, rhs) match {
      case (Nil, Nil) => Eval.now(Nil)
      case (Nil, ys) => Eval.now(ys)
      case (xs, Nil) => Eval.now(xs)
      case (x :: xs, y :: ys) if x <= y =>
        Eval.defer(mergeT(xs, y :: ys)).map(x :: _)
      case (x :: xs, y :: ys) if x > y =>
        Eval.defer(mergeT(x :: xs, ys)).map(y :: _)
    }
  }

  // stack unsafe
  private def merge(lhs: List[Int], rhs: List[Int]): List[Int] = {
    (lhs, rhs) match {
      case (Nil, Nil) => Nil
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs, y :: ys) if x <= y =>
        x :: merge(xs, y :: ys)
      case (x :: xs, y :: ys) if x > y =>
        y :: merge(x :: xs, ys)
    }
  }
}
