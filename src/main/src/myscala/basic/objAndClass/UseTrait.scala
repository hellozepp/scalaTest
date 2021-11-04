package myscala.basic.objAndClass

class UseTrait {

}

trait Logger {
  def log(msg: String): Unit = {}
}

class ConcreteLogger extends Logger with Cloneable {

  override def log(msg: String): Unit = println("Log: " + msg)

  def concreteLog(): Unit = {
    log("It's me !!!")
  }
}

trait TraitLogger extends Logger {
  override def log(msg: String) {
    println(" TraitLogger Log content is : " + msg)
  }
}

trait TraitLoggered {
  def loged(msg: String) {
    println("TraitLoggered Log content is : " + msg)
  }
}

trait ConsoleLogger extends TraitLogger {
  override def log(msg: String) {
    println("Log from Console :" + msg)
  }
}

class Test extends ConsoleLogger {
  def test {
    log("Here is Spark!!!")
  }

}

abstract class Account {
  def save
}

class MyAccount extends Account with ConsoleLogger {
  def save {
    log("11")
  }
}

class Human {
  println("Human")
}

trait TTeacher extends Human {
  println("TTeacher")

  def teach: Unit
}

trait PianoPlayer extends Human {
  println("PianoPlayer")

  def playPiano(): Unit = {
    println("I’m playing piano. ")
  }
}

class PianoTeacher extends Human with TTeacher with PianoPlayer {
  override def teach = {
    println("I’m training students piano. ")
  }
}


//AOP
trait Action {
  def doAction
}

trait TBeforeAfter extends Action {
  abstract override def doAction {
    println("Initialization")
    super.doAction
    println("Destroyed")
  }
}

class Work extends Action {
  override def doAction = println("Working...")
}

object UseTrait {
  def main(args: Array[String]): Unit = {
    val t1 = new PianoTeacher
    t1.playPiano
    t1.teach
    println("-------------t2-----------")
    val t2 = new Human with TTeacher with PianoPlayer {
      def teach = {
        println("I'm teaching students.")
      }
    }
    t2.playPiano()
    t2 teach

    println("-------------work----------")
    val work = new Work with TBeforeAfter
    work.doAction

    println("-------------log----------")
    val logger1 = new ConcreteLogger with TraitLogger
    //  val logger = new ConcreteLogger
    logger1.concreteLog
    val logger2 = new Test
    logger2.test;

    val account = new MyAccount with TraitLoggered
    account.save
  }


}