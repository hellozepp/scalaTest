package dataset


object List_HighOrder_Funciton_Ops {

  def main(args: Array[String]) {
    println(List(1, 2, 3, 4, 6) map (_ + 1))
    val data = List("Scala", "Hadoop", "Spark")
    println(data map (_.length))
    println(data map (_.toList.reverse.mkString))

    println(data.map(_.toList))
    println(data.flatMap(_.toList))
    println(List.range(1, 10) flatMap (i => List.range(1, i) map (j => (i, j))))

    var sum = 0
    List(1, 2, 3, 4, 5) foreach (sum += _)
    println("sum : " + sum)

    println(List(1, 2, 3, 4, 6, 7, 8, 9, 10) filter (_ % 2 == 0))
    println(data filter (_.length == 5))

    println("===============partition=====================")
    println(List(1, 2, 3, 4, 5) partition (_ % 2 == 0)) //对被2整除的分一个区，不符合的分一个  (List(2, 4),List(1, 3, 5))
    println("===============find=====================")
    println(List(1, 2, 3, 4, 5) find (_ % 2 == 0)) //Some(2) 只匹配首个
    println(List(1, 2, 3, 4, 5) find (_ <= 0)) //None
    println("===============takeWhile=====================")
    println(List(1, 2, 3, 4, 5) takeWhile (_ < 4)) //List(1, 2, 3)
    println(List(1, 2, 3, 4, 5) dropWhile (_ < 4)) // List(4, 5)
    println("===============span=====================")
    println(List(1, 2, 3, 4, 5) span (_ < 4)) // (List(1, 2, 3),List(4, 5))
    println("===============hastotallyZeroRow=====================")

    def hasTotallyZeroRow(m: List[List[Int]]) = m exists (row => row forall (_ == 0))

    val m = List(List(1, 0, 0), List(0, 0, 0), List(0, 0, 1))
    println(hasTotallyZeroRow(m))

  }

}