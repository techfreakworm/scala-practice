package lectures.part2oop

object InheritenceAndTraits extends App{

  // single class inheritence
  class Animal {
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
    override def eat = println("crunch, crunch")
  }
  val dog =  new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // OVERRIDING vs OVERLOADING

  // super

}
