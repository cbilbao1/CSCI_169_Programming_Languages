

object Practice {
  def main (args:Array[String]) {
    //Problem 1
    def xs = List(59, 21, 3, 12, 100)  // 3 element list
    //Print result
    println("Problem 1 Array: ", xs)
    println("Range(2, 4): ", range(xs, 2, 4))
    
    //Problem 2, incom
    def xs2 = List(1, 2, 3, 4, 5)  // 3 element list
    //Print result
    println("\nProblem 2 Array: ", xs2)
    println("Average xs2: ", average(xs2))
    
    //Problem 3
    def xs3 = List(1, 2, 3, 4, 5)  // 3 element list
    //Print result
    println("\nProblem 3 Array: ", xs3)
    println("Apply square xs3: ", applyrange(xs3, 1, 3, x=>x*x))
    println("Apply double xs3: ", applyrange(xs3, 1, 3, x=>x+x))
    println("Apply one xs3: ", applyrange(xs3, 1, 3, x=>x/x))
    
    //Problem 4
    def xs4 = List(1, 3, 5, 2, 4, 10, 15)  // 3 element list
    //Print result
    println("\nProblem 4 Array: ", xs4)
    println("ApplyN square xs4: ", applyrangeNCurr(x=>x*x)(xs4, 1, 3))
    println("ApplyN double xs4: ", applyrangeNCurr(x=>x+x)(xs4, 1, 3))
    println("ApplyN one xs4: ", applyrangeNCurr(x=>x/x)(xs4, 1, 3))
    println("Apply square xs4: ", applyrangeCurr(x=>x*x)(xs4, 1, 3))
    println("Apply double xs4: ", applyrangeCurr(x=>x+x)(xs4, 1, 3))
    println("Apply one xs4: ", applyrangeCurr(x=>x/x)(xs4, 1, 3))
    
    //Problem 5
    def xs5 = List(1, 3, 5, 2, 4)  // 3 element list
    //Print result
    println("\nProblem 5 Array: ", xs5)
    println("Double inc 5: ", double(x=>x+1)(5))
    println("Double square 2: ", double(x=>x+x)(2))
    
    //Problem 6
    //Print result
    println("\nProblem 6")
    //println("ApplyN square xs4: ", double(x=>x+1))
    println(compose(x=>x*x,x=>x+1)(6))
    
    //Problem 7
    //Print result
    println("\nProblem 7")
    //println("ApplyN square xs4: ", double(x=>x+1))
    println(composeCurr(x=>x*x)(x=>x+1, 6))
    
    println("\nPractice 1")
    //println("ApplyN square xs4: ", double(x=>x+1))
    //apply_combine(square, 4, add)
    println(apply_combine(x=>x*x, 4, (x,y)=>x+y))
    
    println("\nPractice 2")
    def xs6 = List(1, 2, 3, 5, 6)  // 123
    def xs7 = List(3, 4, 6, 7, 8)  // 3410
//    def xs1 = List(1, 2, 3, 5, 1)  // 123
//    def xs2 = List(3, 4, 6, 7, 2)  // 3410
    //Create two Biguint of size 3
    def int1 = new Biguint(xs6)
    def int2 = new Biguint(xs7)
    //Print result
    println()
    println("Arr3: ", int1.arr)
    println("Arr3: ", int2.arr)
    println("Add: ", int1.add(int1, int2).arr)
    println()
  }
  //println(add_f(x=>x=3, 9))
  
  //println(add_sometimes((x, y)=>if((x+y)%2==0) x + y else y), 9)
  
  def filter(xs:List[Int], f:Int=>Boolean):List[Int] =
  {
    if (xs.isEmpty) Nil
    else if (xs.tail.isEmpty) xs.head::filter(xs.tail, f)
    else filter(xs.tail, f)
  }
  
  //Curried
  def filterCurr(f:Int=>Boolean):List[Int]=>List[Int] =
  {
    (xs:List[Int]) =>
      if (xs.isEmpty) Nil
      else if (f(xs.head)) xs.head::filterCurr(f)(xs.tail)
      else filterCurr(f)(xs.tail)
  }
  
//  def applyrange(xs:List[Int], start:Int, end:Int, f:Int=>Int):List[Int] =
//  {
//    //Base case
//    if (xs.isEmpty == true)
//    {
//      Nil
//    } else if (/*xs.tail.isEmpty == true &&*/ start<=0 && end>=0)
//    {
//      f(xs.head)::applyrange(xs.tail, start-1, end-1, f)
//    } else
//    {
//      xs.head::applyrange(xs.tail, start-1, end-1, f)
//    }
//  }
  
  //Named
//  def applyrangeNCurr(f:Int=>Int):(List[Int], Int, Int)=>List[Int] =
//  {
//    def inner(xs:List[Int], start:Int, end:Int):List[Int] =
//    {
//      //Base case
//      if (xs.isEmpty == true)
//      {
//        Nil
//      } else if (/*xs.tail.isEmpty == true &&*/ start<=0 && end>=0)
//      {
//        f(xs.head)::inner(xs.tail, start-1, end-1)
//      } else
//      {
//        xs.head::inner(xs.tail, start-1, end-1)
//      }
//    }
//    inner
//  }
  
  //Anonymous
//  def applyrangeCurr(f:Int=>Int):(List[Int], Int, Int)=>List[Int] =
//  {
//    (xs:List[Int], start:Int, end:Int) =>
//      //Base case
//      if (xs.isEmpty == true)
//      {
//        Nil
//      } else if (/*xs.tail.isEmpty == true &&*/ start<=0 && end>=0)
//      {
//        f(xs.head)::applyrangeCurr(f)(xs.tail, start-1, end-1)
//      } else
//      {
//        xs.head::applyrangeCurr(f)(xs.tail, start-1, end-1)
//      }
//  }
  
  //Define + For Class Rational
//  def +(that:Rational):Rational =
//  {
//    new Rational((this.enum*that.denom)+(that.enum*this.denom), (this.denom*that.denom))
//  }
  def gcd(a:Int, b:Int):Int = if(b == 0) a else gcd(b, a%b)
  
  //Practice 1
  def range(xs:List[Int], start:Int, end:Int):List[Int] =
  {
    if (xs.isEmpty == true)
    {
      Nil
    } else if (start <= 0 && end >= 0)
    {
      //The element is in range
      xs.head::range(xs.tail, start - 1, end - 1)
    } else
    {
      //Recurse on the rest of the list, omit the current
      range(xs.tail, start - 1, end - 1)
    }
  }
  
  //Practice 2
  def average(xs:List[Int]):Double =
  {
    def inner(x:List[Int], avg:Double, count:Double):Double =
    {
      if (x.isEmpty)
      {
//        0
        avg / count
      } /*else if (x.tail.isEmpty)
      {
        x.head
      }*/ else
      {
        //Recurse on rest, update average with current
//        avg + x.head + inner(x.tail, avg, count + 1)
//        def tempAvg = avg / count
        inner(x.tail, avg+x.head, count+1)
        
        
        //def tempAvg = ((avg + x.head) + inner(x.tail, avg, count + 1))/count
//        def realAvg = tempAvg / count
//        print(tempAvg)
//        print("/")
//        println(count)
//        realAvg
//        tempAvg
      }
    }
    inner(xs, 0, 0)
  }
  
  //Practice 3
  def applyrange(xs:List[Int], start:Int, end:Int, f:Int=>Int):List[Int] =
  {
    if (xs.isEmpty)
    {
      Nil
    } else if (start <= 0 && end >= 0)
    {
      f(xs.head)::applyrange(xs.tail, start - 1, end - 1, f)
    } else
    {
      xs.head::applyrange(xs.tail, start - 1, end - 1, f)
    }
  }
  
  //Practice 4
  def applyrangeNCurr(f:Int=>Int):(List[Int], Int, Int)=>List[Int] =
  {
    def inner(xs:List[Int], start:Int, end:Int):List[Int] =
    {
      if (xs.isEmpty)
      {
        Nil
      } else if (start <= 0 && end >= 0)
      {
        f(xs.head)::inner(xs.tail, start - 1, end - 1)
      } else
      {
        xs.head::inner(xs.tail, start - 1, end - 1)
      }
    }
    inner
  }
  
  def applyrangeCurr(f:Int=>Int):(List[Int], Int, Int)=>List[Int] =
  {
    (xs:List[Int], start:Int, end:Int) =>
      if (xs.isEmpty)
      {
        Nil
      } else if (start <= 0 && end >= 0)
      {
        f(xs.head)::applyrangeNCurr(f)(xs.tail, start - 1, end - 1)
      } else
      {
        xs.head::applyrangeNCurr(f)(xs.tail, start - 1, end - 1)
      }
  }
  
  //Practice 5
  def double(f:Int=>Int):Int=>Int =
  {
    def inner(x:Int):Int =
    {
      val xOnce = f(x)
      val xTwice = f(xOnce)
      xTwice
    }
    inner
  }
  
  //Practice 6
  def compose(f:Int=>Int, g:Int=>Int):Int=>Int =
  {
    def inner(x:Int):Int =
    {
      f(g(x))
    }
    inner
  }
  
  //Practice 7
  def composeCurr(f:Int=>Int):(Int=>Int, Int)=>Int =
  {
    def inner(g:Int=>Int, x:Int):Int =
    {
      f(g(x))
    }
    inner
  }
  
  def apply_combine(f:Int=>Int, x:Int, g:(Int,Int)=>Int):Int =
  {
    if (x == 1)
    {
      1
    } else
    {
      g(f(x), apply_combine(f, x - 1, g))
    }
  }
  
  class Biguint(xs:List[Int])
  {
    def arr = xs
    def this(s:String) = this({def convert(s:String):List[Int] = {if(s.isEmpty) Nil else convert(s.tail):::List((s.head-'0'))}; convert(s)})
    def this() = this(0::Nil)
    def convert(s:String):List[Int] = {
      if(s.isEmpty) Nil

      else {

        convert(s.tail):::List((s.head-'0'))
      }
   }
    def add(x:Biguint, y:Biguint):Biguint =
    {
      def inner(x2:Biguint, y2:Biguint):Biguint =
      {
        if (x2.arr.isEmpty && y2.arr.isEmpty)
        {
          new Biguint()
        } else if (x2.arr.tail.isEmpty && y2.arr.tail.isEmpty)
        {
          new Biguint(x2.arr.head+y2.arr.head::Nil)
        } else
        {
          new Biguint((x2.arr.head+y2.arr.head)::inner(x2.arr.tail, y2.arr.tail).arr)
        }
      }
      inner(x, y)
    }
  }
}