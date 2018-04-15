case class Rectangle(_width: Int, _height: Int) { }

object AutoHashingEqualsClone {
  def main(args: Array[String]): Unit = {
    val rectangle1 = new Rectangle(100, 200)
    val rectangle2 = new Rectangle(50, 75)
    val rectangle3 = new Rectangle(100, 200)

    val rectangle1Clone = rectangle1.copy()

    // Equality
    Console.println("rectangle1 == rectangle2: " + rectangle1 == rectangle2)
    Console.println("rectangle1 equals rectangle3: " + rectangle1.equals(rectangle3))

    // Copy
    Console.println("rectangle1 equals rectangle1Clone: " + rectangle1.equals(rectangle1Clone))

    // Hashing
    Console.println("rectangle1.hashCode: " + rectangle1.hashCode())
    Console.println("rectangle2.hashCode: " + rectangle2.hashCode())
    Console.println("rectangle3.hashCode: " + rectangle3.hashCode())
  }
}


