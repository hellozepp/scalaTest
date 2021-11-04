package myscala.basic.array_list_set_map_tuple

/**
  * @Author: zhanglin
  * @Date: 2021/7/27
  * @Time: 10:51 AM
  *
  *        4种操作符的区别和联系
  *        :: 该方法被称为cons，意为构造，向队列的头部追加数据，创造新的列表。用法为 x::list,其中x为加入到头部的元素，无论x是列表与否，它都只将成为新生成列表的第一个元素，也就是说新生成的列表长度为list的长度＋1(btw, x::list等价于list.::(x))
  *        :+和+: 两者的区别在于:+方法用于在尾部追加元素，+:方法用于在头部追加元素，和::很类似，但是::可以用于pattern match ，而+:则不行. 关于+:和:+,只要记住冒号永远靠近集合类型就OK了。
  *        ::: 该方法只能用于连接两个List类型的集合。
  *        ++ 该方法用于连接两个集合，list1++list2 。++:等价
  */
object ListDemo {
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

  def main(args: Array[String]) {
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
