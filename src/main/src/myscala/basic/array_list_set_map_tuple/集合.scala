package myscala.basic.array_list_set_map_tuple

import scala.collection.mutable.ArrayBuffer

/**
  * @Author: zhanglin
  * @Date: 2021/7/27
  * @Time: 10:52 AM
  */
object 集合 {
  println("---------Array-----------")
  val b = ArrayBuffer[Int]()
  b += 1
  b += (1, 2, 3, 5)
  b ++= Array(8, 13, 21)
  Console println b.mkString("<", ",", ">") // <1,1,2,3,5,8,13,21>
  b.trimEnd(5)
  Console println b.mkString("<", ",", ">") //<1,1,2>
  b.insert(2, 6)
  b.insert(2, 7, 8, 9) // 角标2上增加7、8、9
  Console println b.mkString("<", ",", ">") //<1,1,7,8,9,6,2>
  b.remove(2) // 删除角标2
  Console println "remove(2):" + b.mkString("<", ",", ">") // <1,1,8,9,6,2>
  b.remove(2, 3)
  b.toArray
  Console println b.mkString("<", ",", ">") //<1,1,2>
  for (i <- b.indices)
    println(i + ": " + b(i))

  println(Array(1, 7, 2, 9).sum)
  println(ArrayBuffer("Mary", "had", "a", "little", "lamb").max)

  val d = ArrayBuffer(1, 7, 2, 9)//如果是any类型，要自定义Ordering， Error:(34, 19) No implicit Ordering defined for Any.
  val bSorted = d.sorted
  println("bSorted:" + bSorted.mkString(","))

  val e = Array(1, 7, 2, 9)
  scala.util.Sorting.quickSort(e)
  println(e.mkString(" and "))

  // 创建矩阵，Array.ofDim[Double](3) 等价于 new Array[Double](3)
  val matrix = Array.ofDim[Double](3, 4)
  matrix(2)(1) = 42
  val triangle = new Array[Array[Int]](10)
  for (i <- 0 until triangle.length)
    triangle(i) = new Array[Int](i + 1)
  //  Array
  var arr = new Array[Int](10)
  var arr1 = Array(1, 2, 3, 4, 5, 6)
  //创建长度为1的array
  var arr2 = Array[Int](10)
  arr2(0) = 1
  println("arr2:" + arr2.mkString(""))

  import scala.collection.mutable.ArrayBuffer

  var ab = ArrayBuffer(1, 2, 3)
  ab += 1
  println(ab)
  ab ++= ArrayBuffer(2, 2, 3, 1)
  println(ab)
  ab.insert(0, 0, 0, 0)
  println(ab)
  ab.remove(1, 2) //角标为1干掉两个
  println(ab)
  println("翻转range")
  for (i <- (0 until (ab.length)).reverse) {
    println(ab(i))
  }
  ab.foreach(println(_))
  ab.filter(x => x % 2 == 0)
  ab.filter(_ % 2 == 0)
  ab.sum
  ab.sorted.reverse
  ab.sortBy(x => x)
  ab.sortWith(_ > _) //从大到小
  ab.sortWith(_ < _)
  ab.sortWith((x, y) => x < y)
  // (String, String) 等价于Tuple2[String, String]
  var pairs: Array[(String, String)] = new Array[(String, String)](10)
  pairs(0) = "key1" -> "value"
  pairs(1) = "key2" -> "value"
  pairs(1) = "key3" -> "value"
  println(pairs.mkString(sep = ","))

  println("---------Map-----------")
  //是一个对偶元祖
  val m = Map("1" -> "a", 2 -> "b", 3 -> "c")
  println(m("1"))
  //  m("1")=3 //不能修改

  import scala.collection.mutable.{Map => mutableMap} // 不起别名可以直接使用Map

  var m2 = mutableMap("1" -> "a", 2 -> "b", (3, "c"))
  m2("1") = "3" //修改
  m2.put("1", "b") //key不重复，无序
  println(m2)
  println(m2.get("c"))
  println(m2.getOrElse("c", "none"))
  val yuanzu = "t" -> 6
  //m2 += (("t" , 6)) //mutable map 不支持

  import java.lang.{String => JString}
  import java.util.{HashMap => JHashMap}

  val mm = new JHashMap[Int, JString]()
  private val str = new JString("1")
  mm.put(1, str)

  import scala.collection.mutable.HashMap

  val map11 = new HashMap[String, Int]()
  map11("spark") = 1
  map11 += (("hadoop", 2))
  map11.put("storm", 3)
  println(map11)

  //从map中移除元素
  map11 -= "spark"
  map11.remove("hadoop")
  println(map11)


  def flatMap1(): Unit = {
    println("---------flatMap1-----------")
    val li = List(1, 2, 3, Nil)
    val res = li.flatMap(x => x match {
      case 3 => List('a', 'b')
      case _ => List(x)
    })
    println(res)
  }

  def map1(): Unit = {
    // functor 原类型输出 eg. flatMap
    // monad 封装类型输出 eg. map
    println("---------map1-----------")
    val li = List(1, 2, 3, Nil)
    // map.flatten 等价于 flatMap
    val res = li.map(x => x match {
      case 3 => List('a', 'b')
      case _ => List(x)
    }).flatten
    println(res)
  }

  def main(args: Array[String]) {
    flatMap1()
    map1()
    val a1 = 1
    val foo =
      s"""
      多行文本 " ' "" ` | % ￥  $a1
      """

    println("---------tuple-----------")
    var tup = (1, "1", 2.0)
    //    tup._3 = 1 // 不可修改
    //角标从1开始
    println(tup._3)

    val t, (x, y, z) = ("1", "2", "3") //直接去tuple的值
    println("t:", t)
    println("x:", x)
    //对偶元组转换成map
    val a = Array(1 -> 1, (2, 3))
    println(a.toMap)
    println("//拉链")
    val aa = Array(x, y, z)
    val bb = Array("1", "2", "3") //没匹配到的不要了
    aa.zip(bb).foreach(println(_)) //变成一个对偶元祖的array

    println("===测试集合===")
    //集合对象都有foreach和map两个方法
    //    函数式编程的重要标志之一就是map,reduce,foreach。
    //    map和reduce
    //Vector中每个元素都加1的例子：
    val v = Vector(1, 2, 3, 4)
    Console println v.map(n => n + 1).map(_ + 1).map(_ * 2)
    // is Vector(6, 8, 10, 12)
    //序列中所有值加起来
    val v1 = Vector(1, 10, 100, 1000)
    var sum = 0
    v1.foreach(x => sum += x)
    println("foreach(x => sum += x):" + v1 + " sum:" + sum)


    val list = List(1, 2, 3, 4, 5)
    var increase1 = (x: Int) => x + 1
    list.foreach(increase1)

    //使用reudce
    val v2 = Vector(1, 10, 100, 1000)

    v2.reduce((sum1, n) => sum1 + n) //is 1111

    println("foreach场景：只操作不需要返回结果---------------------")
    println(v2.map(println(_)))
    //  返回值：   Vector((), (), (), ())
    v2.foreach(println) //println做了隐式转换
    println("--------------按照特定顺序reduce=0---------")
    println(v2.reduceRight(_ + _))
  }
}
