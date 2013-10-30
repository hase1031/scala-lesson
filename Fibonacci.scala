/**
 * Scalaプログラミング問題
 * https://gist.github.com/j5ik2o/7210762
 *
 * フィボナッチ数列計算
 */

object Fibonacci {
  def fib(n: Long): Long = {
    if (n < 2) n
    else fib(n-1) + fib(n-2)
  }

  def main(args: Array[String]) {
    println(fib(args(0).toLong))
  }
}