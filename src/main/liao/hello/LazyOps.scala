package hello

import scala.io.Source

object LazyOps {

  def main(args: Array[String]): Unit = {
    lazy val file = Source.fromFile("filename") //相对路径
    
    println("Scala")
    
	for (line <- file.getLines) println(line)
    
  }

}