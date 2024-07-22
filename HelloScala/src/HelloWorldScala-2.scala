

object HelloWorldScala {
  def main(args: Array[String]) {
    //println("Hello Scala !!")
    println("Please wait for me to finish!")
    println("Problem 1:")
    println("1: " + is_prime(0))
    println("2: " + is_prime(1))
    println("3: " + is_prime(2))
    println("4: " + is_prime(4))
    println("5: " + is_prime(5))
    println("6: " + is_prime(6))
    println("7: " + is_prime(7))
    println("9: " + is_prime(9))
    println("10: " + is_prime(10))
    println("13: " + is_prime(13))
    println("20: " + is_prime(20))
    println("33: " + is_prime(33))
    println("68: " + is_prime(68))
    println("100: " + is_prime(100))
    println("419: " + is_prime(419))
    
    println("Problem 2:")
    println("Third: " + add_third(4))
    println("Fth: " + add_third(4))
    
    println("Problem 3:")
    println(apply_combine(square, 4, add))
    //println(combine(plus, 3))
    //println(apply_combine(identity, 4, mult))
    
    println("Problem 4:")
    def ls = List(1, 6, 3, 8, 2 ,6, 4, 89)
    //println(ls.head + " " + ls.tail)
    println("Original: " + ls)
    println("Update: " + my_map(ls, square))
  }
  
  //Problem 1
  def is_prime(a:Int):Boolean =
  {
    def prime_recursion(b:Int):Boolean =
    {
      //Base case, 0 and 1 are not prime
      if (b <= 1)
      {
        false
      } else if (b == 2) // Base case 2, even numbers not prime
      {
        //println("Impossible: " + b)
        true
      } else  // Recursive case
      {
        //prime_recursion(
        //Range(2, b-1).filter(b % _ == 0).length == 0
        customRange(2, b)
      }
      def customRange(y:Int, be:Int):Boolean =
      {
        if (y < be && b % y == 0)  // Base case 1
        {
          false  // It is not a prime
        } else if (y == be)  // Base case 2
        {
          //println ("Imposter")
          true  // It is not a prime
        } else  // Recursive case
        {
          customRange(y + 1, be)
        }
      }
      
//      //Base case, 0 and 1 are not prime
//      def i = divisorUp(i)
//      if (b <= 2)
//      {
//        false
//      } else if (b % divisorUp(i) == 0) // Base case 2, even numbers not prime
//      {
//        false
//      } else  // Recursive case
//      {
//        false
//      }
//    }
//    def divisorUp(d:Int):Int =
//    {
//      d + 1
//    }
      customRange(2, b)
    }
    prime_recursion(a)
  }
  
  //Problem 2
  //The f function
  def f_function(c:Int):Int =
  {
    c - 3
  }
  //Generic adaptation
  def add_fth(f:Int=>Int, x:Int):Int = {
      if(x<1) 0
      else x+add_fth(f, f(x))
  }
  //Original
  def add_third(x:Int):Int = {

      if(x<1) 0

      else
      {
        //println(x+add_third(x-3))
        x+add_third(x-3)
      }

  }
  
  //Problem 3
//  def combine(f:(Int, Int)=>Int , x:Int):Int = {
//      if(x==1) 1
//      else f(x, combine(f, x-1))
//  }
  def plus(x:Int, y:Int):Int = x+y
  def apply_combine(f: Int=>Int, x:Int, g: (Int, Int)=>Int):Int =
  {
//      def combine(f:(Int, Int)=>Int , y:Int):Int = {
//        if(y==1) 1
//        else f(y, combine(f, y-1))
//      }
      //println("x: " + x)
      if(x==1)
      {
        //println("Base")
        1
      }
      else 
      {
        //(x * x) + (x-1 * x-1) + (x-2 * x-2)
        def term = f(x);
        g(term, apply_combine(f, x - 1, g))
        
        
        
        //f(x, apply_combine(g(x, combine(f, x - 1)), x - 1, f))
        //println("Rec" + f(g(x, apply_combine(f, x - 1, g))) )
        //println("Rec" + g(x - 1, f(apply_combine(f, x - 1, g))) )
        //g(f(apply_combine(f, x - 1, g)), f(apply_combine(f, x - 1, g)))
        //g(x, f(apply_combine(f, x - 1, g)))
        //else g(x, f(apply_combine(f, x - 1, g)))
        
        //f: (Int, Int)f(apply_combine(f, x - 1, g))
        //def all = g(x, f(apply_combine(f, x - 1, g)))
//        def fonly = f(apply_combine(f, x - 1, g))
//        def apponly = apply_combine(f, x - 1, g)
//        println("All: " + all);
//        println("fonly: " + fonly);
//        println("apponly: " + apponly);
//        all
      }
      
      //Delete: appc(f, 4, g) --> g(4, f(appc(f, 3, g)))
//                      g(3, f(appc(f, 2, g)) = g(3, f(3)) = g(3, 9) = 12
//                      g(2, f(appc(f, 1, g)) = g(2, f(1)) = g(2, 1) = 3
//                      g(1,....) = 1
      
//      combine(plus, 3) --> plus, 3
//                           f(3, combine(f, 2)) = f(3, 3)
//      f(2, combine(f, 1)) = f(2, 1)
  }
  def add(x:Int, y:Int) :Int = x+y
  def square(x:Int):Int = x*x
  def mult(x:Int, y:Int) :Int = x*y
  def identity(x:Int) = x
  
  //Problem 4
  def my_map(xs:List[Int], f:Int=>Int):List[Int] =
  {
      if(xs.isEmpty) Nil
      else
      {
        //println("f head: "+ f(xs.head))
        f(xs.head)::my_map(xs.tail, f)
      }
  }  
}
//(21:44)