object CharacterOccurences {
  def main(args : Array[String]): Unit = {
    val text =  if (args.length > 0) args(0) else "MISSISSIPI"

    val result = text
      .toCharArray()
      .sortBy(_.charValue())
      .groupBy(_.charValue())
      .map(x => (x._1, x._2.length))

    println(result)
  }
}


