/**
 * Scalaプログラミング問題
 * https://gist.github.com/j5ik2o/7264785
 *
 * クイックソート
 */

object QuickSort {

  def sortList(xs: List[Int]): List[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      sortList(xs filter (pivot > _)) :::
        (xs filter (pivot == _)) :::
        sortList(xs filter (pivot < _))
    }
  }

  def main(args: Array[String]) {
    val list = List(4, 7, 1, 3, 10, 5, 6, 2, 8, 9)
    println(sortList(list).mkString("\n"))
  }
}