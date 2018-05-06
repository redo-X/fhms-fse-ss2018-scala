import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._
import scala.util.Success

object FuturesSample {
  def main(args: Array[String]): Unit = {
    implicit val ec: ExecutionContext = ExecutionContext.Implicits.global

    val f: Future[Array[Int]] = Future {
      Array(1,2,3,4,5)
    }

    f onComplete {
      case Success(numbers) => for(n <- numbers) println(n)
    }

    Await.result(f, Duration.Inf)
  }
}
