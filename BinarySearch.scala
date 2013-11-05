/**
 * Scalaプログラミング問題
 * https://gist.github.com/j5ik2o/7264785
 *
 * 2分探索問題
 */

import scala.util._

object BinarySearch {

  def binarySearch(number: Int, numbers: List[Int]): Try[Int] = {
    def search(left: Int, right: Int): Try[Int] = {
      val mid = ((left + right) / 2).toInt
      if (left >= right) Failure(new NoSuchElementException)
      else if (numbers(mid) == number) Success(mid)
      else if (numbers(mid) < number) search(mid+1, right)
      else search(left, mid)
    }
    search(0, numbers.length)
  }

  def main(args: Array[String]) {
    println(binarySearch(args(0).toInt, (1 to 100 by 2).toList))
  }
}