object Closures {
  // From: https://gleichmann.wordpress.com/2010/11/15/functional-scala-closures/
  def main(args: Array[String]): Unit = {
    var minAge = 18
    val isAdult = (age: Int) => age >= minAge

    val isGermanAdult = isAdult(20)

    minAge = 21

    val isUsAdult = isAdult(20)
  }
}
