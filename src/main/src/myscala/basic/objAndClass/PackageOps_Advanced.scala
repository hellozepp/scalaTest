package myscala.basic.objAndClass

class PackageOps_Advanced{
  import PackageOps_Advanced.power
  
  private def canMakeItTrue = power >10001
  
}

object PackageOps_Advanced{
  private def power = 10000
  
  def makeItTrue(p : PackageOps_Advanced): Boolean = {
     val result = p.canMakeItTrue 
     result
  }
}

