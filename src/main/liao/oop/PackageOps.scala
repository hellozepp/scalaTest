package com.dt.scala.oop

package com.scala.spark

package object people {
  val defaultName = "Scala"
}

package people {
  class people {
    var name = defaultName
  }
}

import scala.{StringBuilder => _}


class PackageOps {}


package spark.navigation {
  abstract class Navigator {
    def act = {}
  }
  package tests {

    // 在spark.navigation.tests包里
    class NavigatorSuite
  }

}

package NavigatorSuiteImpls {

  import spark.navigation._

  class Action extends Navigator {
    override def act = println("Action")
  }
}

package hadoop {
  package navigation {
    class Navigator
  }

  package launch {
    class Booster {

      import spark.navigation._

      val nav = new Navigator {
        override def act: Unit = {
        }
      }
    }
  }

}

package spark {
  package navigation {
    private[spark] class Navigator1 {
      private[this] var speed = 200

      protected[navigation] def useStarChart(): Unit = {}

      class LegOfJourney {
        private[Navigator1] val distance = 100
      }
    }
  }

  package launch {

    object Vehicle {
      import spark.navigation._
      private[launch] val guide = new Navigator {
        override def act: Unit = {}
      }
    }
  }

}


object PackageOps {

  def main(args: Array[String]): Unit = {

  }

}