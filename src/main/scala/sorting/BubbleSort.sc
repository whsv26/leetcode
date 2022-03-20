val in = Array(3, 8, 1, 4, 6, 1)

def swap(lhs: Int, rhs: Int): Unit = {
  val tmp = in(lhs)
  in(lhs) = in(rhs)
  in(rhs) = tmp
}

for {
  i <- 0 until in.length
  j <- 0 until (in.length - 1 - i)
  if (in(j) > in(j + 1))
} swap(j, j + 1)

in

assert(in sameElements Array(1, 1, 3, 4, 6, 8))