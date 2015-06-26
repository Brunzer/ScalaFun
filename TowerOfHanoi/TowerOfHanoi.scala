import scala.collection.mutable.Stack

object TowerOfHanoi {
  def MoveTower(height: Int, source: scala.collection.mutable.Stack[Int], dest: scala.collection.mutable.Stack[Int], spare: scala.collection.mutable.Stack[Int]): Unit = {
    if(height >= 1) {
      MoveTower(height-1, source, spare, dest)
      var n = source.pop
      dest.push(n)
      println("---------------------------------------")
      println(s"This is the source $source")
      println(s"This is the destination $dest")
      println(s"This is the spare $spare")
      MoveTower(height-1, spare, dest, source)
    }
  }

  def buildStack(height: Int): scala.collection.mutable.Stack[Int] = {
    val stack = new scala.collection.mutable.Stack[Int]
    var i = height
    for( i <- height to 1 by -1 ) {
      stack.push(i)
    }
    return stack
  }

  def main(args: Array[String]) {
     var disks = 5;
     val stack = buildStack(disks)
     val dest = new scala.collection.mutable.Stack[Int]
     val spare = new scala.collection.mutable.Stack[Int]
     MoveTower(disks, stack, dest, spare)
  }
}
