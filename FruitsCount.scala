/**
 * Scalaプログラミング問題
 * https://gist.github.com/j5ik2o/7210762
 *
 * ワードカウント問題
 */

object FruitsCount {
  def countFruitsFromLines(lines: List[String]): Map[String, Int] = {
    var m = Map[String, Int]()
    val fruits = lines.flatMap(fruit => fruit.split(" "))
    for (fruit <- fruits) {
      val count =
        if (m.contains(fruit)) m(fruit)
        else 0
      m += (fruit -> (count + 1))
    }
    m
  }

  def main(args: Array[String]) {
    val lines = List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")
    val fruitsCounts = countFruitsFromLines(lines)

    if (fruitsCounts == Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1)){
      println("正解")
    } else {
      println("不正解")
    }
  }
}