package dataset


object List_FirstOrder_Ops {

  def main(args: Array[String]) {
    println(List(1, 2, 3, 4) ::: List(4, 5, 6, 7, 8) ::: List(10, 11)) //List(1, 2, 3, 4, 4, 5, 6, 7, 8, 10, 11)
    println(List(1, 2, 3, 4).length)

    val bigData = List("Hadoop", "Spark", "Kaffka")
    println(bigData.last) //Kaffka
    println(bigData.init) //List(Hadoop, Spark)
    println(bigData.reverse) //List(Kaffka, Spark, Hadoop)
    println(bigData) //List(Hadoop, Spark, Kaffka)
    println(bigData take 2) //List(Hadoop, Spark)
    println(bigData drop 1) //List(Spark, Kaffka)
    println(bigData) //List(Hadoop, Spark, Kaffka)
    println(bigData splitAt 2) //(List(Hadoop, Spark),List(Kaffka))
    println(bigData apply 2) //Kaffka
    println(bigData(2)) //Kaffka

    val data = List('a', 'b', 'c', 'd', 'e', 'f')
    println(data.indices) //Range(0, 1, 2, 3, 4, 5)
    println(data.indices zip data) //Vector((0,a), (1,b), (2,c), (3,d), (4,e), (5,f))
    println(data.zipWithIndex)
    println(data toString)
    println(data.mkString("[", ",,", "]"))
    println(data.mkString("******"))
    println(data mkString)

    val buffer = new StringBuilder
    data addString(buffer, "(", ";;", ")")
    println(buffer)
    println(data)

    val array = data.toArray
    println(array.toList)

    val new_Array = new Array[Char](10)
    data.copyToArray(new_Array, 3)
    new_Array.foreach(print)
    println

    val iterator = data.toIterator
    println(iterator.next)
    println(iterator.next)

    println("==============slice==============")
    //    问题： 把 文本字符串"[1, 2, 3, 4, 5]" 转换成一个数组。 slice相当于substr
    val x = "[1, 2, 3, 4, 5]"
    var y1 = x slice(1, x.length - 1) replace(",", "") split (" ") map (_.toInt)
    //    y1: Array[Int] = Array(1, 2, 3, 4, 5)

    // Declaring a iterator
    val iter = Iterator(1, 2, 3, 4, 5)

    // Applying slice method 索引1直到第四个索引，所以为下标123=》234，简单理解第一个表示起始下标，第二个表示直到某个下标（或者取到第几个值）
    val iter1 = iter.slice(1, 4)

    // Using while loop to print the
    // elements of new iterator
    while(iter1.hasNext)
    {

      // Displays output
      println(iter1.next())

    }
  }

}