package myscala.basic.array_list_set_map_tuple

import scala.collection.mutable

/**
  * @author zhanglin
  * @since 2020/4/28 15:06
  */
object Set01 {

  def main(args: Array[String]): Unit = {
    // create
    val set = Set[Int](1, 2, 22, 3, 33, 4, 4, 4) //Set(1, 33, 2, 22, 3, 4)
    println(set)
    println("--intercept--") //交集
    val set1 = Set[Int](3, 4, 5, 6)
    val inter: Set[Int] = set.intersect(set1) // 3,4 交集
    val inter2 = set & set1 // intercept
    println(inter2)

    println("--diff--")
    val dif: Set[Int] = set.diff(set1) // 在set中，但不在set1中
    val dif2 = set &~ set1
    dif2.foreach(println)

    /**
      * 可变长的set
      */
    println("---mutable set ---")
    val ints: mutable.Set[Int] = mutable.Set[Int](11, 22, 33)
    ints.+=(44, 55, 22, 11, 11, 1)
    ints.foreach(println)


  }

}
