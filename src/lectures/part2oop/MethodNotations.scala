package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_! : String = s"$name, what the heck?"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala: String = this.learns("Scala")
  }

  val mary = new Person("Mary","Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent

  // infix notation = operator notation (only works with 1 param) --> syntactic sugar


  // "operators" in Scala

  val tom = new Person("Tom", "Fight club")
  println(mary hangOutWith tom)
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // OPERATORS ARE METHODS
  // AKKA actors have ! ?

  // prefix notation (for unary operator)
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation (only works methods without params)
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) //equivalent


  /*
    1. Overload the + operator
    mary + "the rockstar" => new parson "Mary (the rockstar)"

    2. Add an age to the Person class
    Add a unary + operator => new person with the age + 1
    +mary => mary with the age incremented

    3. Add a "learns" method in the Person class => "Mary learns Scala"
    Add a learnScala method, calls learns method with "Scala"
    Use it in postfix notation

    4. Overload the apply method
    mary.apply(2) => "Mary watched the Inception 2 times"

   */


  println((mary + "the rockstar")())
  println((+mary).age)
  println(mary learns "Scala")
  println(mary learnsScala)
  println(mary(10))

}
