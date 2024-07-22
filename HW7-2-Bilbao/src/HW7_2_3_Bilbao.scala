

object HW7_2_3_Bilbao {
  def main (args:Array[String]) {
    //Problem 2
    def xs = List(59, 21, 3, 12, 100)  // 3 element list
    //Print result
    println("Problem 2: ")
    println("findlast: 21; Index: ", findlast(xs, 21))
    println("findlast: 0; Index: ", findlast(xs, 0))
    
    //Problem 3
    //Define a second array
    def ys = List(60, 22, 4, 13, 101)  // 3 element list
    println("\nProblem 3: ")
    println("xs: ", xs)
    println("ys: ", ys)
    println("altMerge: ", altMerge(xs, ys))
  }
  
  def findlast(xs:List[Int], x:Int):Int =
  {
    def helper(arr:List[Int], ex:Int, counter:Int):Int = {
      arr match {
        case Nil => -1
        //y represents the head, while ys is the tail
        case y::ys => if (y == ex) counter
                   else helper(ys, ex, counter + 1)
      }
    }
    helper(xs, x, 0)
  }
  
  //Takes in two lists of Ints and returns list of Ints
  def altMerge(xs:List[Int], ys:List[Int]):List[Int] =
  {
    //We will be comparing on the basis of xs, the first array
    xs match {
        case Nil => ys  // If xs is empty, then return the rest of ys
        //z represents the head, while zs is the tail of xs
        case z::zs => z::altMerge(ys, zs)
      }
  }
  //Beta
//  def altMerge(xs:List[Int], ys:List[Int]):List[Int] =
//  {
//    //We will be comparing on the basis of xs, the first array
//    xs match {
//        case Nil => ys  // If xs is empty, then return the rest of ys
//        //y represents the head, while ys is the tail
//        case z::zs => z::y::altMerge(zs, ys)
//      }
//  }
}