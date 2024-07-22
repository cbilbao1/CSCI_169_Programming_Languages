

object HW8P1Bilbao {
  def main (args:Array[String]) {
    //Create array
    def arr1 = List(1, 2, 3, 4, 5)
    println("Original arr1: ", arr1)
    def square(x:Int):Int =
    {
      x * x
    }
    //println("Generic my_map with square: ", my_map_Gen(arr1, square))
    println("Generic my_map with square: ")
    def arrCopy = my_map_Gen2(arr1, square)
    println(arrCopy)
    println(my_map_Gen2[Int](arr1, square))
    //println("Generic my_map with square: ", my_map_Gen(arr1, x=>x*x))
    //my_map_Gen(arr1, x=>x*x)
    //def modArr = my_map_Gen(arr1, x=>x*x)
    //def foreach("Generic my_map with square: ", my_map_Gen(arr1, x=>x*x))
  }
  
  //Problem 1
  //Original
  def my_map(xs:List[Int], f:Int=>Int):List[Int] =
  {
      if(xs.isEmpty) Nil
      else
      {
        //println("f head: "+ f(xs.head))
        f(xs.head)::my_map(xs.tail, f)
      }
  }
  //Generic
//  def my_map_Gen[T<:AnyRef](xs:List[T], f:T=>T):List[T] =
//  {
//      if(xs.isEmpty) Nil
//      else
//      {
//        //println("f head: "+ f(xs.head))
//        f(xs.head)::my_map_Gen(xs.tail, f)
//      }
//  }
  //Second Generic Version (Printable)
  def my_map_Gen2[T](xs:List[T], f:T=>T):List[T] =
  {
      if(xs.isEmpty) Nil
      else
      {
        //println("f head: "+ f(xs.head))
        f(xs.head)::my_map_Gen2(xs.tail, f)
      }
  }
  //Third Generic Version
//  def my_map_Gen3(xs:List[AnyRef], f:AnyRef=>AnyRef):List[AnyRef] =
//  {
//      if(xs.isEmpty) Nil
//      else
//      {
//        //println("f head: "+ f(xs.head))
//        f(xs.head)::my_map_Gen2(xs.tail, f)
//      }
//  }
  def printArr[T<:AnyRef](xs:List[T]):Unit =
  {
    xs match {
      case Nil => println()
      case y::ys => println(y.toString()); printArr(ys)
    }
  }
}