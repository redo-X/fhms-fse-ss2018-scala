import collection.JavaConverters._
import collection.mutable._

object Main {

  def main(args: Array[String]): Unit = {
    val calculator = new Calculator()

    println("-----Add 2.3 to 2.7-----")
    println(calculator.add(2.3, 2.7))

    println("-----Adding with List: 1, 3, 7, 9-----")
    println(calculator.addAllFromList(ArrayBuffer(1.0, 3.0, 7.0, 9.0).asJava.asInstanceOf[java.util.List[java.lang.Double]]))

    println("-----List primnumbers from 1 to 50-----")
    val primenumbers = asScalaBuffer(calculator.getPrimenumbers(50))
    primenumbers.foreach(println)
  }
}
