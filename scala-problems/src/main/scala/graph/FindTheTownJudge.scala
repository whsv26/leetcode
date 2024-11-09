package org.whsv26.leetcode
package graph

object FindTheTownJudge extends App {
  object SolutionAdjacencyMatrix {
    def findJudge(n: Int, trust: Array[Array[Int]]): Int = {
      val graph = Array.ofDim[Boolean](n, n)
      trust.foreach { case Array(from, to) => graph(from - 1)(to - 1) = true }

      val maybeJudgeIdx = (0 until n).find { i =>
        val trustsNobody = graph(i).forall(_ == false)
        val trustedByEveryone = (0 until n)
          .filterNot(_ == i)
          .map(graph(_)(i))
          .forall(_ == true)

        trustsNobody && trustedByEveryone
      }

      maybeJudgeIdx.map(_ + 1).getOrElse(-1)
    }
  }

  assert(3 == SolutionAdjacencyMatrix.findJudge(3, Array(Array(1,3), Array(2,3))))
}
