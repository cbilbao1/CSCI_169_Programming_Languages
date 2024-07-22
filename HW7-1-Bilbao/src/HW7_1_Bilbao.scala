

object HW7_1_Bilbao {
  def main (args:Array[String]) {
    def xs1 = List(1, 2, 3, 5, 6)  // 123
    def xs2 = List(3, 4, 6, 7, 8)  // 3410
//    def xs1 = List(1, 2, 3, 5, 1)  // 123
//    def xs2 = List(3, 4, 6, 7, 2)  // 3410
    def xs3 = List(112, 211, 14)
    def xs4 = List(333, 421, 1020)
    def xs5 = List(9, 113151719, 3)
    def xs6 = List(33, 121416181, 1210)
    //Create two Biguint of size 3
    def int1 = new Biguint(xs1)
    def int2 = new Biguint(xs2)
    def int3 = new Biguint(xs3)
    def int4 = new Biguint(xs4)
    def int5 = new Biguint(xs5)
    def int6 = new Biguint(xs6)
    //Print result
    println("Arr1: ", int1.myArr)
    println("Arr2: ", int2.myArr)
    println("Add: ", add(int1, int2/*, 0*/).myArr)
    println()
    println("Arr3: ", int3.myArr)
    println("Arr3: ", int4.myArr)
    println("Add: ", add(int3, int4/*, 0*/).myArr)
    println()
    println("Arr5: ", int5.myArr)
    println("Arr6: ", int6.myArr)
    println("Add: ", add(int5, int6/*, 0*/).myArr)
  }
  
  class Biguint(arr:List[Int]) {
    //Initialize the member integer array using parameter
    val myArr = arr
    
    //Constructor that takes no arguments and initializes list
    def this() {
    this(0::Nil);
    println("\nNo Argument Constructor.")
    }
    
    //Represents integers with an arbitrary number of digits
    def this(s:String) = this({def convert(s:String):List[Int] = {if(s.isEmpty) Nil else convert(s.tail):::List((s.head-'0'))}; convert(s)})
    def convert(s:String):List[Int] = {

      if(s.isEmpty) Nil

      else {

        convert(s.tail):::List((s.head-'0'))

      }

    }
  }
  
  //Adds two Biguints
  def add(x:Biguint, y:Biguint/*, carry:Int*/):Biguint =
    {
      //Base case, we are at ones digit
      if (x.myArr.tail == Nil && y.myArr.tail == Nil)
      {
        //print("Test: ", new Biguint().myArr)
//        println("Base Carry: ", carry)
//        println("Base Temp: ", x.myArr.head + y.myArr.head)
        //new Biguint
        def tempArr:List[Int] = List(x.myArr.head + y.myArr.head)
        new Biguint(tempArr)
        //add(x, y, 0) + 1
        
      } else  // Recursive case
      {
//        println("Carry Before: ", carry)
//        println("Rec Carry: ", x.myArr.head + y.myArr.head)
        def tempArr2:List[Int] = x.myArr.head + y.myArr.head::(add(new Biguint(x.myArr.tail), new Biguint(y.myArr.tail)/*, (x.myArr.head - carry) + (y.myArr.head - carry)*/).myArr)
//        println("Carry After: ", carry)
        new Biguint(tempArr2)
        //new Biguint(add(new Biguint(x.myArr.tail), new Biguint(y.myArr.tail), carry + x.myArr.head + y.myArr.head).myArr)
      }
    }
  //Beta
//    def add(x:Biguint, y:Biguint, carry:Int):Biguint =
//    {
//      //Base case, we are at ones digit
//      if (x.myArr.tail == Nil && y.myArr.tail == Nil)
//      {
//        new Biguint
//      } else  // Recursive case
//      {
//        new Biguint(add(new Biguint(x.myArr.tail), new Biguint(y.myArr.tail), x.myArr.head + y.myArr.head).myArr)
//      }
//    }
}