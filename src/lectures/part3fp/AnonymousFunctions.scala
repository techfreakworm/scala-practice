package lectures.part3fp

object AnonymousFunctions extends App {

//  val doubler = new Function[Int, Int] {
//    override def apply(v1: Int): Int = v1 * 2
//  }

  // anonymous function (LAMBDA)
  val doubler: Int => Int = x => x * 2 // equivalent to above
  val doubler2 = (x: Int) => x * 2 // equivalent to above

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a*b

  // no params
  val justDoSomething: () => Int = () => 3

  // careful
  println(justDoSomething) // function itself
  println(justDoSomething()) // actual call

  // curly braces
  val stringToInt = { (str: String) => {
    str.toInt
  }
  }

  // MOAR Syntactic sygar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x+1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a+b

  /*
    1. MyList: replae all FunctionX cals with lambdas
    2. Rewrite the "special" adder as an anonymoous function
  */

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(4)(4))


}
