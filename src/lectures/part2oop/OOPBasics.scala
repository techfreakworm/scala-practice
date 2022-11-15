package lectures.part2oop

object OOPBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  println(person.x)
  person.greet("Mayank")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val impostor = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(impostor))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

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

/*
  Novel and Writer classes

  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author (type: Writer)
    - authorAge (at year of release)
    - isWrittenBy(author)
    - copy (new year of release) = new Instance of novel
 */

class Writer(firstname: String, surname: String, val year: Int) {
  def fullName: String = firstname + " " + surname

}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dev to receive an amount
 */

class Counter(val count: Int = 0) {
//  def count = n
  def inc = {
    println("Incrementing")
    new Counter(count + 1)
  } // immutability
  def dec = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n<=0) this
    else inc.inc(n-1)
  }
  def dec(n: Int): Counter = {
    if (n<=0) this
    else dec.dec(n-1)
  }

  def print = println(count)
}

