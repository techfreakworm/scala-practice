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

//  throw exception

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
// OOM
//  val array = Array.ofDim[Int](Int.MaxValue)

  // SO
//  def infinite: Int = 1 + infinite
//  val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x*y
      if(x>0 && y>0 && result <0) throw new OverflowException
      else if(x<0 && y<0 && result <0) throw new OverflowException
      else if(x>0 && y<0 && result >0) throw new UnderflowException
      else if(x<0 && y<0 && result >0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }

  }

//  println(PocketCalculator.add(Int.MaxValue, 2))
  println(PocketCalculator.divide(2,0))

}
