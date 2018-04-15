object LambdaExpression {
  def main(args: Array[String]): Unit = {
    val func = (x: Int, y: Int) => x+y

    val result = func(1, 2)
    Console.println("Result: " + result)
  }
}

