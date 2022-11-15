package lectures.part2oop

object OOPBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  println(person.x)
  person.greet("Mayank")
  person.greet()

}

// constructor
// class Parameters are NOT FIELDS (CLASS MEMBERS), need to add keyword val/var to make a param a field
class Person(name: String, val age: Int)  {
  // body

  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors

  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

