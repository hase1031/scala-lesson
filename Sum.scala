/**
 * Scalaプログラミング問題
 * https://gist.github.com/j5ik2o/7210762
 *
 * ワードカウント問題
 */

object Sum {
  def getSum(numbers: List[Int]): Long = {
    var sum = 0
    for (i <- numbers) {
      sum += i
    }
    sum
  }

  def main(args: Array[String]) {
    val numbers = (1 to args(0).toInt).toList
    println(getSum(numbers))
  }
}