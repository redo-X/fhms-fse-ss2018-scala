import scala.util.Random

object MapReduce {
  def main(args: Array[String]): Unit = {
    val random = new Random()
    new Array[Int](10)
      .map(x => random.nextInt(10))
      .filter(x => x % 2 == 0)
      .groupBy(x => x)
      .foreach(x => println(s"${x._1}: ${x._2.length} mal vorhanden."))
  }
}

