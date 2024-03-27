import scala.annotation.tailrec
import scala.collection.immutable.{AbstractSeq, LinearSeq}
import scala.collection.mutable

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
object Solution1 {
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val Array(hNums, nums) = Array(nums1, nums2).sortBy(_.length)

    val occurrences = hNums.foldLeft(Map.empty[Int, Int]) {
      case (acc, cur) => acc.updatedWith(cur) {
        case None => Some(1)
        case Some(n) => Some(n + 1)
      }
    }

    val (intersection, _) = nums.foldLeft(List.empty[Int], occurrences) {
      case ((res, rem), cur) if rem.getOrElse(cur, 0) == 0 => (res, rem)
      case ((res, rem), cur) =>
        (cur :: res) -> rem.updatedWith(cur) {
          case Some(n) if n > 1 => Some(n - 1)
          case _ => None
        }
    }

    intersection.toArray
  }
}

object Solution2 {
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    nums1.sortInPlace()
    nums2.sortInPlace()

    def loop(i: Int, j: Int): List[Int] = {
      if (i == nums1.length || j == nums2.length) {
        return Nil
      }

      if (nums1(i) < nums2(j)) {
        loop(i + 1, j)
      } else if (nums1(i) > nums2(j)) {
        loop(i, j + 1)
      } else {
        nums1(i) :: loop(i + 1, j + 1)
      }
    }

    loop(0, 0).toArray
  }
}

object Solution3 {
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val builder = mutable.ArrayBuilder.make[Int]
    nums1.sortInPlace()
    nums2.sortInPlace()

    @tailrec
    def loop(i: Int, j: Int): Unit = {
      if (i >= nums1.length || j >= nums2.length) {
        return
      }

      if (nums1(i) < nums2(j)) {
        loop(i + 1, j)
      } else if (nums1(i) > nums2(j)) {
        loop(i, j + 1)
      } else {
        builder.addOne(nums1(i))
        loop(i + 1, j + 1)
      }
    }

    loop(0, 0)
    builder.result()
  }
}

Solution3.intersect(Array(1,2,2,1,4,3), Array(3,2,2))
