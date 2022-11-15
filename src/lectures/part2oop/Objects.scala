package lectures.part2oop

object Objects {

  // SCALA DOESN'T HAVE CLASS LEVEL FUNCTIONALITY ("static")
  object Person {
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory-method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality
  }

  // COMPANIONS
  def main(args: Array[String]): Unit = {


    println(Person.N_EYES)
    println(Person.canFly)

    // SCala object = SINGLETON INSTANCE

    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    val bobbie = Person(mary, john)

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit

  }

}
