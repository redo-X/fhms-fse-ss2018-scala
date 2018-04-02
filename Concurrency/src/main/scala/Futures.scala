import scala.concurrent.{ExecutionContext, Future}

object Futures {

  class Calculator {
    def getNumber1(): Int = {
      Thread.sleep(1000)
      2
    }

    def getNumber2(): Int = {
      Thread.sleep(1000)
      5
    }

    def add(n1: Int, n2: Int): Int = {
      Thread.sleep(1000)
      n1 + n2
    }

    def sub(n1: Int, n2: Int): Int = {
      Thread.sleep(1000)
      n1 + n2
    }
  }

  def main(args: Array[String]): Unit = {

    val calculator: Calculator = new Calculator()

    implicit val ec: ExecutionContext = ExecutionContext.Implicits.global

    val future = Future {
      println("Get numbers...")

      (calculator.getNumber1(), calculator.getNumber2())
    }
    future.map { x =>
      println("Add numbers...")

      calculator.add(x._1, x._2)
    }
    future.onComplete { result =>
      println("Numbers added...")

      println(s"Result = ${result.get}")
    }

    println("Do other things 1 ...")
    println("Do other things 2 ...")
    println("Do other things 3 ...")

    while(!future.isCompleted){}
  }
}
