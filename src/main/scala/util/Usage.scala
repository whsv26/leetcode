package org.whsv26.leetcode
package util

object Usage {
  def printDiff(f: => Unit): Unit = {
    val startTime = System.currentTimeMillis()
    val start = Runtime.getRuntime.freeMemory
    f
    val endTime = System.currentTimeMillis()
    val end = Runtime.getRuntime.freeMemory

    println { "Memory: %d kb".format ((start - end) / 1024) }
    println { "Runtime: %d millis".format (endTime - startTime) }
  }
}
