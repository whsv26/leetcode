package org.whsv26.leetcode
package interview

object JavaExecutor {
  import java.util.concurrent.Executors

  // fixed (ThreadPoolExecutor)
  // shared task queue
  Executors.newSingleThreadExecutor()
  Executors.newFixedThreadPool(1)
  Executors.newFixedThreadPool(Runtime.getRuntime.availableProcessors())

  // cached and unbounded (ThreadPoolExecutor)
  Executors.newCachedThreadPool()

  // fixed and work-stealing (ForkJoinPool)
  // separated task queue for every thread
  Executors.newWorkStealingPool()
  Executors.newWorkStealingPool(Runtime.getRuntime.availableProcessors())

  // scheduled (ScheduledThreadPoolExecutor)
  Executors.newScheduledThreadPool(1)
  Executors.newSingleThreadScheduledExecutor()
}

object ExecutorAndContext {
  import scala.concurrent.ExecutionContext
  import java.util.concurrent.Executors

  val globalCtx = ExecutionContext.global
  val workStealingCtx = ExecutionContext.fromExecutor(Executors.newWorkStealingPool())
}
