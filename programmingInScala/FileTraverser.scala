/*
  traverse all the files in given a directory
*/
import java.io.File

object FileTraverser {
  def traverse(path: String) {
    val pathFile = new File(path)
    if(pathFile.isDirectory) {
      println("Dir:  " + pathFile.getCanonicalPath)
      for(file <- pathFile.listFiles)
        traverse(file.getCanonicalPath)
    }
    else {
      println("File: " + pathFile.getCanonicalPath)
    }
  }

  def main(args: Array[String]) = {
    if(args.length != 0)
      traverse(args(0))
    else
      traverse(".")
  }
}
