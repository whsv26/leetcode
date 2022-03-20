val in = Array(3, 8, 1, 4, 6, 1)

def quickSort(arr: Array[Int]): Unit = {

  def swap(x: Int, y: Int): Unit = {
    val stash = arr(y)
    arr.update(y, arr(x))
    arr.update(x, stash)
  }

  def partition(low: Int, high: Int): Int = {
    val pivot = high
    var i = low

    for (j <- low to high if arr(j) < arr(pivot)) {
      swap(i, j)
      i += 1
    }

    swap(i, pivot)
    i
  }

  def quickSortIter(lo: Int, hi: Int): Unit = {
    if (lo < hi) {
      val p = partition(lo, hi)
      quickSortIter(lo, p - 1)
      quickSortIter(p + 1, hi)
    }
  }

  quickSortIter(0, arr.length - 1)
}

quickSort(in)

in

assert(in sameElements Array(1, 1, 3, 4, 6, 8))