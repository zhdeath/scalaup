/*
  calculate checksum of a string
*/
import scala.collection.mutable.HashMap

class ChecksumAccumulator {
  private var sum = 0
  
  def add(b: Byte) { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
  private val cache = new HashMap[String, Int]()
  
  def calculate(s: String) = {
    if(cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for(c <- s) {
        acc.add(c.toByte)
      }
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
  }
}

object App {
  def main(args: Array[String]) {
    println(ChecksumAccumulator.calculate("hello, world!"))
  }
}
