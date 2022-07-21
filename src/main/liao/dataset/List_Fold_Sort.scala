package dataset

import scala.collection.mutable


object List_Fold_Sort {

  def main(args: Array[String]): Unit = {
    val a = mutable.LinkedList(1,2,3,4)

    /**
      * 5-1的结果(4)
      * -2的结果(2)
      * -3的结果(-1)
      * -4的结果等于最终值(-5)
      */
    val b = (5 /: a)(_-_)
    println(b)

    /**
      * 5加1的和(6)
      * 加2的和(8)
      * 加3的和(11)
      * 加4的和等于最终结果(15)
      */
    val c = (5 /: a)(_+_)
    println(c)

    /**
      * 5*1的值(5)
      * *2的值(10)
      * *3的值(30)
      * *4的值=最终结果(120)
      */
    val d = (5 /: a)(_*_)
    println(d)

    /**
      * 30/1的值(30)
      * /2的值(15)
      * /3的值(5)
      * /4的值(1)
      */
    val e = (30 /: a)(_/_)
    println(e)

    println("----------------")

    /**
      * 4加5的值(9)
      * 3加9的值(12)
      * 2加12的值(14)
      * 1加14的值结果为(15)
      */
    val f = (a :\ 5)(_+_)
    println(f)

    /**
      *  1,2,3,4
      *  4-5的值(-1)
      *  3--1的值(4)
      *  2-4的值(-2)
      *  1--2(3)
      */
    val g = (a :\ 5)(_-_)
    println(g)

    /**
      * 4*5的值(20)
      * 3*20的值(60)
      * 2*60的值(120)
      * 60*1的值结果为(120)
      */
    val h = (a :\ 5)(_*_)
    println(h)

    /**
      * 4/2的值(2)
      * 3/2的值(1.5)
      * 2/1.5(1.333....)
      * 1.333..../1的最终结果为(1)
      */
    val i = (a :\ 2)(_/_)
    println(i)

    println((1 to 100).foldLeft(0)(_+_) )
    println((0 /: (1 to 100))(_+_))
    
    println((1 to 5).foldRight(100)(_-_))
    println(((1 to 5):\100)(_-_))
    
    
    println(List(1, -3, 4, 2, 6) sortWith (_ < _))
    println(List(1, -3, 4, 2, 6) sortWith (_ > _))
    
  }

}