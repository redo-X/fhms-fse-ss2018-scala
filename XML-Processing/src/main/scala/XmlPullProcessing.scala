import scala.collection.mutable.ListBuffer
import scala.xml.pull.{EvElemStart, EvText, XMLEventReader}

/**
  * Zeigt die XML-Verarbeitung nach dem Pull-Prinzip.
  *
  * Showcase: XMLEventReader zum Auslesen der Informationen
  */
object XmlPullProcessing {
  def main(args: Array[String]): Unit = {
    var reader = new XMLEventReader(scala.io.Source.fromInputStream(getClass.getResourceAsStream("/books.xml")))

    println("== print events")
    reader.foreach(println)

    reader = new XMLEventReader(scala.io.Source.fromInputStream(getClass.getResourceAsStream("/books.xml")))
    println("== print all authors")

    val authors = ListBuffer[String]()
    var isAuthorTag = false
    reader.foreach(event => {
      if (event.isInstanceOf[EvElemStart]) {
        val evElemStart = event.asInstanceOf[EvElemStart]
        if (evElemStart.label == "author") {
          isAuthorTag = true
        }
      }

      if (isAuthorTag) {
        if (event.isInstanceOf[EvText]) {
          isAuthorTag = false
          val evText = event.asInstanceOf[EvText]
          if (evText != null) {
            val firstAndLastName = evText.text.split(",").reduce((x1, x2) => x2 + " " + x1);
            if (!authors.contains(firstAndLastName)) {
              authors += firstAndLastName
            }
          }
        }
      }
    })

    println(authors)
  }
}
