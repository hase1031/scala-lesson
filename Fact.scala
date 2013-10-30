/**
 * Scalaプログラミング問題
 * https://gist.github.com/j5ik2o/7210762
 *
 * 階乗計算
 */

object Fact {
  def fact(n: Int): Long = {
    var sum: Long = 1
    for (i <- 1 to n) {
      sum *= i
    }
    sum
  }

  def main(args: Array[String]) {
    println(fact(args(0).toInt))
  }
}