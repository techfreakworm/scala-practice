package lectures.part2oop

object Inheritence extends App{

  // single class inheritence
  sealed class Animal {
    val creatureType = "Wild"
    def eat = println("nomnomnom")
  }

  class Cat extends Animal  {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch


  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name) // or Person(name, age)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }
  val dog =  new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // OVERRIDING vs OVERLOADING

  // super

  // preventing overrides
  // 1 - use final keyword on member
  // 2 - use final keyword on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent EXTENSION IN OTHER FILES


}
