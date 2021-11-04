package myscala.basic.array_list_set_map_tuple

import scala.collection.mutable.ListBuffer

/**
  * 列表为链接表结构，不可变
  * 构造列表的两个基本单位是 Nil 和 ::
  *
  * Nil 也可以表示为一个空列表。
  *
  * val list1: List[Any] = List(1, 2, 3, "a", true)
  *
  * val stringses: List[Array[String]] = list2.map(str => {
  *       str.split(" ")
  * })
  *
  * val strings: List[String] = list2.flatMap(s => {
  *       s.split(" ")
  * })
  *
  * filter
  * count
  *
  * ListBuffer[T](1,2,3)
  *
  * @author liuqiang
  * @since 2020/4/28 14:10
  */
object List01 {

  def main(args: Array[String]): Unit = {

    // 字符串列表 冒号运算符，在链表开始添加一个元素
    val site = "Runoob" :: ("Google" :: ("Baidu" :: Nil))
    println(site)
    println(List(2, 3).::(1)) // 在前面添加 List(1, 2, 3)
    println(List(1).::(2, 3)) // List((2,3), 1)
    println("----------整型列表------------")
    val nums = 1 :: (2 :: (3 :: (4 :: 5 :: Nil)))
    println(nums)
    println("----------空列表------------")
    val empty = Nil
    println(empty)
    println("----------二维列表------------")
    val dim = (1 :: (0 :: (0 :: Nil))) ::
      (0 :: (1 :: (0 :: Nil))) ::
      (0 :: (0 :: (1 :: Nil))) :: Nil
    println(dim)
    println("----------列表基本操作------------")
    val list0 = List
    println(list0) // immutable
    // Any 为基类，AnyRef 和 AnyVal 为引用类型和值类型
    val list1: List[Any] = List(3, 2, 1, "a", true)
    println(list1)
    // create list
    val list = list1
    list.foreach(println)

    println()
    val list2: List[String] = List("hello scala", "hello java", "hello world", "a", "bc")
    println(list2)
    println(site.head)
    println(site.tail)
    println(site.isEmpty)
    val str: String = list2.+("aaa") // list2会当成字符串，和aaa进行拼接
    println(str)

    /**
      * map
      */
    println("----------map------------")
    println()
    val stringses: List[Array[String]] = list2.map(str => {
      str.split(" ")
    })
    stringses.foreach(e => {
      e.foreach(e1 => print(e1 + " "));
      println()
    })

    println("============flatMap=======")
    /**
      * flatMap。是在map的基础上，进行了偏平化
      */
    val strings: List[String] = list2.flatMap(s => {
      s.split(" ")
    })
    strings.foreach(e => {
      print(e + "|");
    })

    /**
      * filter
      */
    println("\n=========filter=========")
    val strings1: List[String] = list2.filter(s => {
      "hello scala".equals(s) // 保留的内容
    })
    strings1.foreach(println)


    /**
      * count 满足条件的条数
      */
    println("\n=count==")
    val i: Int = list2.count(s => {
      s.length < 4
    })
    println(i)

    /**
      * mutable list
      *
      */
    println("\n=mutable list==")
    val ints: ListBuffer[Int] = ListBuffer[Int](1, 2, 33)
    ints.append(4, 55, 6)
    ints.+=:(100)
    println(ints)


  }

}
