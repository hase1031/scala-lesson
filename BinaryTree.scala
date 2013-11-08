/**
 * Scalaプログラミング問題
 * https://gist.github.com/j5ik2o/7264785
 *
 * 2分探索問題
 */

object BinaryTree extends App {

  trait Node {
    def size: Int

    def max: Int

    def min: Int

    def sum: Int

    def avg: Int

    def find(number: Int): Node
  }

  case class Branch[T <: Node, S <: Node](left: T, value: Int, right: S) extends Node {
    def size: Int = left.size + 1 + right.size

    def max: Int = right.max

    def min: Int = left.min

    def sum: Int = left.sum + value + right.sum

    def avg: Int = sum / size

    def find(number: Int): Node = {
      if (number == value) this
      else if (number < value) left.find(number)
      else right.find(number)
    }
  }

  case class Leaf(value: Int) extends Node {
    def size = 1

    def max = value

    def min = value

    def sum = value

    def avg = value

    def find(number: Int): Leaf = {
      if (number == value) this
      else Leaf(-1)
    }
  }

  case class BTree[T <: Node](tree: T) {
    def size: Int = tree.size

    def max: Int = tree.max

    def min: Int = tree.min

    def sum: Int = tree.sum

    def avg: Int = tree.avg

    def find(value: Int): Node = tree.find(value)
  }

  // 0) ノードの値を組み合わせてデータを作成できるようにせよ
  val bTree1 = BTree(Leaf(1))
  val bTree2 = BTree(Branch(Leaf(1), 2, Leaf(3)))
  val bTree3 = BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))

  // 1) すべてのノードの数を計算せよ
  val bTree4 = BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))
  val size = bTree4.size

  // 2) すべてのノードが保持する値から、最大値/最小値/合計値/平均値を計算せよ
  val bTree5 = BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))
  val max = bTree5.max
  val min = bTree5.min
  val sum = bTree5.sum
  val avg = bTree5.avg

  // 3) すべてのノードが保持する値から、特定の値を持つノードを検索できるようにせよ(二分木の構造を生かした検索を行うこと)。
  val bTree6 = BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))
  val node: Node = bTree6.find(1)

  // test
  def printResult[T](result: T, answer: T, desc: String) {
    if (result == answer) println(desc + ") Success")
    else println(desc + ") Failed")
  }

  printResult(size, 7, "1")
  printResult(max, 7, "2:max")
  printResult(min, 1, "2:min")
  printResult(sum, 28, "2:sum")
  printResult(avg, 4, "2:avg")
  printResult(node, Leaf(1), "3")
}