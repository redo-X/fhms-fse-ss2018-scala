object XmlReader {
  def main(args : Array[String]): Unit = {

    println("Read xml file:")
    println(readXmlSimple("books.xml"))

    println("Serialize xml file into generic xml object:")
    val rootXmlElem = readAsXmlElem("books.xml")
    val books = (rootXmlElem \ "book").union((rootXmlElem \ "special-book"))
    println(books)

    println("== print ids")
    val ids = books.map(book => book \@ "id")
    println(ids)

    println("== find book with id bk110")
    val book = books.filter(x => (x \@ "id") == "bk110")(0)
    println(book)

    println("== find books with natural number id")
    val booksWithNaturalNumberIds = books.filter(x => (x \@ "id").matches("\\d+"))
    println(booksWithNaturalNumberIds)

    println("== find elements by name")
    val normalBooks = rootXmlElem \ "book"
    val specialBooks = rootXmlElem \ "special-book"

    println("== find book from author O'Brien, Tim")
    val oBrienBooks = books.filter(x => (x \ "author").text == "O'Brien, Tim")
    println(oBrienBooks)

    println("== find name of books where price is greater or equals than 40 USD")
    val highPricedBooks = books.filter(x => (x \ "price").text.toFloat >= 40f).map(x => (x \ "title").text)
    println(highPricedBooks)

    println("== average price of all books")
    val avgPrice = books.map(x => (x \ "price").text.toFloat).sum / books.length.toFloat
    println(avgPrice)

    println("== find all authors names")
    val authors = (rootXmlElem \\ "author").distinct.map(x => x.text.split(",").reduce((x1, x2)=> x2.trim + " " + x1.trim))
    println(authors)
  }

  def readXmlSimple(fileName: String): String = {
    val booksXmlPath = getClass.getResource("/"+fileName).getPath
    scala.xml.XML.loadFile(booksXmlPath).text
  }

  def readAsXmlElem(fileName: String): scala.xml.Elem = {
    val booksXmlPath = getClass.getResource("/"+fileName).getPath
    scala.xml.XML.loadFile(booksXmlPath)
  }
}