object ForComprehension {
  // From: https://docs.scala-lang.org/tour/for-comprehensions.html
  def main(args: Array[String]): Unit = {
    case class Employee(val firstName: String, val lastName: String, val height: Double) {}

    val employees = List(
      new Employee("Max", "Mustermann", 1.86),
      new Employee("Peter", "Petersen", 1.92),
      new Employee("Fiete", "Fietersen", 1.77)
    )

    val tallEmployees = for (emp <- employees if (emp.height >= 1.85))
      yield s"${emp.firstName} ${emp.lastName}"

    tallEmployees.foreach(println)


    // Example 1
    val numbers1 = List(1, 2, 3, 4, 5)
    val numbers2 = List(6, 7, 8, 9, 10)
    val characters = List('a', 'b', 'c', 'd')

    for (x <- numbers1; y <- numbers2; z <- characters) {
      println(s"${x}\t${y}\t${z}")
    }

    numbers1.foreach(x => numbers2.foreach(y => characters.foreach(z => {
      println(s"${x}\t${y}\t${z}")
    })))


    // Example 2
    for (x <- numbers1; y <- numbers2; z <- characters) yield {
      println(s"${x}\t${y}\t${z}")
    }

    numbers1.flatMap(x => numbers2.flatMap(y => characters.map(z => {
      println(s"${x}\t${y}\t${z}")
    })))
  }
}
