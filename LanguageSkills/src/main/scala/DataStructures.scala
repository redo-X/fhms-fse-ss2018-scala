object DataStructures {
  def main(args: Array[String]): Unit = {
    // Listen
    var names1: List[String] = List("Peter", "Hans")
    var names2: List[String] = List("Max", "Simon")

    var names3 = names1 :: names2

    var names4 = names1.head :: names2.tail


    // Sets
    var numbers1 = Set(1, 2, 3)
    var numbers2 = Set(4, 5, 6)

    var numbers3 = numbers1 ++ numbers2

    var min = numbers3.min
    var max = numbers3.max
    var sum = numbers3.sum

    // Maps
    var colors = Map("red" -> "#FF0000", "black" -> "#000000", "white" -> "#FFFFFF")

    colors.keys
    colors.values

    // Options
    val number:Option[Int] = None
    val safeNumberWithDefault = number.getOrElse(10)

    // Tuples
    val person1 = (1, "Max Mustermann", 1.75)
    val person2 = (2, "Peter Petersen", 1.90)

    val t1 = person1._1
    val t2 = person1._2
    val t3 = person1._3
  }
}
