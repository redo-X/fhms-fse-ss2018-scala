import scala.util.Random

object Threads {

  class GenerateRunnable(index: Int, buffer: Array[Int]) extends Runnable {
    override def run(): Unit = {
      var result = Random.nextInt()
      result = if (result < 0) result * -1 else result
      Thread.sleep(1000)
      buffer(index) = result
    }
  }

  def main(args: Array[String]): Unit = {

    val buffer = new Array[Int](5)

    val threads = new Array[Thread](buffer.length)

    for(x <- 0 to buffer.length-1) {
      val threadRunnable = new GenerateRunnable(x, buffer)

      threads(x) = new Thread(threadRunnable, s"Thread #${x}")
    }

    // Start all threads
    println("Starting threads....")
    threads.foreach(th => th.start())

    // Join all threads
    println("Wating for threads to complete....")
    threads.foreach(th => th.join())

    buffer.foreach(println)
  }

}
