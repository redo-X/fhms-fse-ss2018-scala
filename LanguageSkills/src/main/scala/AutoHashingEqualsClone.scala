case class Rectangle(_width: Int, _height: Int) { }

object AutoHashingEqualsClone {
  def main(args: Array[String]): Unit = {
    val rectangle1 = new Rectangle(100, 200)
    val rectangle2 = new Rectangle(50, 75)
    val rectangle3 = new Rectangle(100, 200)

    val rectangle1Clone = rectangle1.copy()

    // Equality
    println(s"rectangle1 == rectangle2: ${rectangle1 == rectangle2}")
    println(s"rectangle1 equals rectangle3: ${rectangle1.equals(rectangle3)}")

    // Copy
    println(s"rectangle1 equals rectangle1Clone: ${rectangle1.equals(rectangle1Clone)}")

    // Hashing
    println(s"rectangle1.hashCode: ${rectangle1.hashCode()}")
    println(s"rectangle2.hashCode: ${rectangle2.hashCode()}")
    println(s"rectangle3.hashCode: ${rectangle3.hashCode()}")
  }
}
