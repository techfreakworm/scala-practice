package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("Crunch Crunch")
  }

  // traits

  trait Carnivore {
    def eat(animal: Animal) : Unit
    val prefferedMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "croc"
    def eat: Unit = println("nomnombom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc =  new Crocodile
  croc eat dog


  // traits vs Abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits maybe be inheritied by the same class
  // 3 - traits = behavior

}
