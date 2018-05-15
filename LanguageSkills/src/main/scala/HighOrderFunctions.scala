object HighOrderFunctions {
  def main(args: Array[String]): Unit = {

    val unless = (condition: Boolean, func: () => Unit) => {
      if (!condition) {
        func()
      }
    }

    for (x <- Range.apply(1, 50)) {
      unless(x % 2 != 0, () => println(s"${x} is even!"))
    }
  }
}
