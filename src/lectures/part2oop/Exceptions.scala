package lectures.part2oop

object Exceptions extends App {

  val x: String = null
//  println(x.length)
  // this will crash with NPE (null pointer exception)
  // throwing and catching exceptions

  // 1. Throwing exceptions
//  val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes

  // 2. How to catch exceptions
  def getInt(withException: Boolean): Int =
    if (withException) throw new RuntimeException("No int for you")
    else 42

  val potentialFail = try {
    // code that might fail
    getInt(true)
  } catch {
    case e: RuntimeException => {
      println("Caught a runtime exception")
      43
    }
  } finally {
    // code that will get executed no matter what
    //optional
    println("finally")
  }

  println(potentialFail)

  // 3. How to define your own exception

  class MyException extends Exception
  val exception = new MyException

  throw exception

  /*
    1. Crash your program with OutOfMemoryError
    2. Crash with SOError
    3. Pocket Calculator
        - add(x,y)
        - subtract(x,y)
        - multiple(x,y)
        - divide(x,y)

    Throw
      - OverflowException if add(x,y) exceeds Int.MAX_VALUE
      - UnderflowException if subtract(x,y) exceeds INT.MIN_VALUE
      - MathCalculationException for division by 0

  */
}
