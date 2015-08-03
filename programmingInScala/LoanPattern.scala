/*
  using higher function(function takes function value as argument) to create control structures
  a more native way through curried function
*/

import java.io.{File, PrintWriter}
def withPrintWriter(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
        op(writer)
    } finally {
        writer.close()
    }
}

withPrintWriter(new File("test.txt")) {
    writer => writer.println(new java.util.Date)
}
