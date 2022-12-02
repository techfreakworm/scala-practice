package lectures.part2oop

import playground.{Cinderalla => Princess, PrinceCharming}
//import playground._ // equivalent to import playground.{Cinderalla, PrinceCharming}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Mayank", "Rock the JVM", 2018)

  val princess = new Princess // playground.Cinderalla = fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object

  sayHello

  // imports
  val prince = new PrinceCharming

  // 1. FQ names
//  val date = new Date(2,12,2009)
  val sqlDate = new java.sql.Date(2018,5,4)

//2. Using aliasing
  val sqlDateNew = new SqlDate(2018,5,4)

// default imports
// java.lang - String, Object, Exception
// scala - Int, Nothing, Function
// scala.Predef -  println, ???



}
