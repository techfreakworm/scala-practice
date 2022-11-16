package lectures.part2oop

object Generics extends App {

  class MyList[A] {
    // Use type A inside class definition
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Generic methods

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // if Cat extends animal, does list of Cat extends list of Animals?
  // answers:
  // 1. Yes List[Cat] extends List[Animal] = COVARIANCE

  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // animalList.add(new Dog) ??? HARD QUESTION

  // 2. NO = INVARIANCE
  class InvariantList[A]

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no = CONTRAVARIANCE

  class ContravariantList[-A]
  val contravariantLis: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

//  class Car
//  val newCage = new Cage(new Car)

  class Cage2[A >: Animal](animal: A)

  val cage2 = new Cage2(new Dog)

  //  class Car
  //  val newCage = new Cage(new Car)

}
