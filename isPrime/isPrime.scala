object isPrime {
  def prime(n: Int): Boolean = {
    var i = 2;
    for( i <- 2 until n ) {
      if(n%i == 0)
        return false;
    }
    return true;
  }

  def main(args: Array[String]) {
    print("Enter a number: "); var x = scala.io.StdIn.readInt
    println(s"Is $x prime?")
    if(prime(x)) 
      println(s"$x is a prime!");
    else
      println(s"$x is not a prime!");
  }
}
