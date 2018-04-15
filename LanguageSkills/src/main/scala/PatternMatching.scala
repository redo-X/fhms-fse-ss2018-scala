abstract class Human {
  private var _firstName: String = ""

  def firstName = _firstName
  def firstName_= (newValue: String): Unit = {
    _firstName = newValue
  }
}
class Female extends Human {}
class Male extends Human {}

object PatternMatching {
  def main(args: Array[String]): Unit = {
    Console.println(getDynamicType(new Female())) // Female
    Console.println(getDynamicType(new Male()))   // Male
  }
  def getDynamicType(human: Human) = human match {
    case f: Female => "Female"
    case m: Male => "Male"
  }
}