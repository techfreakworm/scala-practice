package lectures.part1basics

object ValuesVariablesTypes extends App{

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

}
