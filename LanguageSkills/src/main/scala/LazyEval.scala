object LazyEval {
  def main(args: Array[String]): Unit = {
    lazy val result = add(1, 2)

    Console.println("Result: " + result)
  }

  def add(n1: Int, n2: Int): Int = {
    n1+n2
  }
}

