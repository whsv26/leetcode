package org.whsv26.leetcode
package graph

import scala.collection.mutable

object FindCenterOfStarGraph extends App {
  object FastSolution {
    def findCenter(edges: Array[Array[Int]]): Int = {
      val visited = mutable.Set.empty[Int]
      edges.iterator.flatten.find {
        case n if visited.contains(n) => true
        case n => visited.addOne(n); false
      }.get
    }
  }

  object Solution {
    def findCenter(edges: Array[Array[Int]]): Int = {
      val graph = edges.foldLeft(Map.empty[Int, List[Int]]) {
        case (map, Array(n1, n2)) =>
          map
            .updatedWith(n1) {
              case Some(list) => Some(n2 :: list)
              case None => Some(n2 :: Nil)
            }
            .updatedWith(n2) {
              case Some(list) => Some(n1 :: list)
              case None => Some(n1 :: Nil)
            }
      }

      graph.collectFirst { case (v, ns) if ns.size == graph.size - 1 => v }.head
    }
  }

  assert(2 == Solution.findCenter(Array(Array(1,2), Array(2,3), Array(4,2))))
}
