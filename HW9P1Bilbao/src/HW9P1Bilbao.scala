

object HW9P1Bilbao {
  def main(args: Array[String]) {
    forLoop(0, (cIndex: Int) => cIndex < 10, (iIndex: Int) => iIndex + 1)(println ("Hello World"))
  }
  
  //Problem 1
  def forLoop(i: => Int, fCon: => (Int => Boolean), fInc: => (Int => Int)): (=>Unit) => Unit =
  {
    def inner(expression: =>Unit): Unit =
    {
      //Base case, forLoop should stop, only way is if next i fails the requirement
      if(fCon(fInc(i)) == false)
      {
        expression
      } else  // Recursive case
      {
        expression
        forLoop(fInc(i), fCon, fInc)(expression)
      }
    }
    inner
  }
}

//Problem 1 Extra Credit
//The most important shortcoming of this style (compared to C++'s for loop) is the fact that we are using a
//function to achieve this. This means that we have to call the function to simulate the for loop, which
//eventually leads to function call overhead, which results in performance costs