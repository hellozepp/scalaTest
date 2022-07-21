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
  * @author hellozepp
  * @since 2020/4/28 14:10
  */
object List01 {
  //   val a = "1"
  //    val b = s"${a}\\$"
  //  println(b)
  //mutable
  println("=====创建一个可变的集合=======")

  import scala.collection.mutable.ListBuffer

  //构建一个可变列表，初始有3个元素1,2,3
  val lst0 = ListBuffer[Int](1, 2, 3)
  //创建一个空的可变列表
  val lst1 = new ListBuffer[Int]
  //向lst1中追加元素，注意：没有生成新的集合
  lst1 += 4
  lst1.append(5, 6, 7, 8, 9)
  println(lst1) //ListBuffer(4, 5, 6, 7, 8, 9)
  //将lst1中的元素追加到lst0中， 注意：没有生成新的集合
  lst0 ++= lst1
  lst1(0) = 11
  println(lst0) //ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9)
  //将lst0和lst1合并成一个新的ListBuffer 注意：生成了一个集合
  val lst2 = lst0 ++ lst1 // ++ 等价于 ++=,为值赋值
  println("=========list2 is :" + lst2) //ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 5, 6, 7, 8, 9)
  //将元素追加到lst0的后面生成一个新的集合
  val lst3 = lst0 :+ 5
  lst0(0) = 11 // 修改下标
  //lst0:ListBuffer(11, 2, 3, 4, 5, 6, 7, 8, 9),lst3:ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 5)
  println(s":+操作，lst0:$lst0,lst3:$lst3") //:+为值赋值
  val lst5 = 5 +: lst1
  println(s"+：操作，lst5:$lst5") //ListBuffer(5, 11, 5, 6, 7, 8, 9)

  println("=======grouped==========")
  val list1 = List(1, 2, 3, 1)
  list1.sorted
  println(list1)
  var gr = list1.grouped(3) //3个分一组
  println(gr.next()) //List(1, 2, 3)
  println(gr.next()) //List(1)
  //  println(gr.next())//java.lang.ExceptionInInitializerError
  //转成list并展开,grouped为iterator，toList会遍历成集合    List(1, 2, 3, 1)
  println(list1.grouped(3).toList.flatten)

  val list2 = List("hello zepp  hello zepp hello zepp hello zepp ", "hello zepphello zepphello zepphello zepp")
  val list = list2.flatMap(_.split(" ")) //按一个空格split
  println(list)

  def main(args: Array[String]): Unit = {

    // 字符串列表 冒号运算符，在链表后添加一个元素
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
      (0 :: (0 :: (1 :: Nil)))
    //:: Nil // 可加可不加
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
    val list2: List[String] = List("hello scala", "hello scala", "hello java", "hello world", "a", "bc")
    println(list2) //List(hello scala, hello java, hello world, a, bc)

    println(site.head) //Runoob
    println(site.tail) //List(Google, Baidu)
    println(site.isEmpty) //false
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
      "hello scala".equals(s) // true =》保留的内容
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
    //immutable
    println("=====创建一个不可变的集合========")
    val lst1 = List(1, 2, 3)

    //将0插入到lst1的前面生成一个新的List
    //元素操作
    val lst2 = 0 :: lst1
    // val  lst10 = lst1 :: 1 // 报错不支持
    //0123
    val lst3 = lst1.::(0)
    //0123
    var lst4 = 0 +: lst1 //0123
    val lst5 = lst1.+:(0) //0123

    //将一个元素添加到lst1的后面产生一个新的集合
    val lst6 = lst1 :+ 3 //1233
    val lst0 = List(4, 5, 6)
    //将2个list合并成一个新的List

    //集合操作
    val lst7 = lst1 ++ lst0 //123456
    println("lst7：" + lst7)
    //将lst1插入到lst0前面生成一个新的集合
    val lst8 = lst1 ++: lst0 //123456，++:代表后面是元素或集合，而++只能追加集合
    println("lst8：" + lst8)

    //将lst0插入到lst1前面生成一个新的集合
    val lst9 = lst1.:::(lst0) //456123
    println(lst9)

    val lst10 = lst0 ::: lst1 //456123
    println(lst10)

    println(List.fill(scala.util.Random.nextInt(10))(1))


  }

}
