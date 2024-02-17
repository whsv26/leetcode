package org.whsv26.leetcode
package others

object ValidParentheses {

  def main(args: Array[String]): Unit = {
    assert(isValid("()[]{}"))
  }

  def isValid(s: String): Boolean = {
    var stack: List[Char] = Nil
    var i = 0
    var valid = true

    while (i < s.length && valid) {
      if (isOpen(s(i))) {
        stack = s(i) :: stack
      } else if (stack.nonEmpty && isClose(stack.head, s(i))) {
        stack = stack.tail
      } else {
        valid = false
      }

      i += 1
    }

    valid && stack.isEmpty
  }

  def isOpen(c: Char) = c match {
    case '(' => true
    case '[' => true
    case '{' => true
    case _ => false
  }

  def isClose(open: Char, close: Char) =
    (open, close) match {
      case ('(', ')') => true
      case ('[', ']') => true
      case ('{', '}') => true
      case _ => false
    }
}
