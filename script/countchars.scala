/*
  simple script for counting chars per line from a file
  Usage: scala countcharts.scala filename
*/

import scala.io.Source

def widthOfLength(line: String) = line.length.toString.length

if(args.length > 0) {
  val lines = Source.fromFile(args(0)).getLines().toList
  val longestLine = lines.reduceLeft(
    (a, b) => if(a.length > b.length) a else b
  )
  
  val maxWidth = widthOfLength(longestLine)
  for(line <- lines) {
    val numberSpace = maxWidth - widthOfLength(line)
    val padding = " " * numberSpace
    println(padding + line.length + " | " + line)
  }
}
else {
  Console.err.println("Please enter filename")
}
