class Car {
  protected val _horsePower:Int = 75

  def horsePower = _horsePower
}

class SportsCar  extends Car {
  override protected val _horsePower: Int = 250
}

object InstanceVariablesOverride {
  def main(args: Array[String]): Unit = {
    val normalCar = new Car
    val sportsCar = new SportsCar

    Console.println("HP of normal car: " + normalCar.horsePower)  // 75
    Console.println("HP of sports car: " + sportsCar.horsePower)  // 250
  }
}

