

object HW6_2_5_Bilbao {
  def main (args: Array[String]) {
    //Problem 2
    def arr1 = List(3, 8, 1, 5)
    def arr2 = List(12, 6, 23, 1, 8, 4)
    println("Problem 2: ")
    //println("Add: ", combineArr(arr1, arr2, add))
    println("Arr1:", arr1)
    println("Arr2:", arr2)
    println("Add:", combineArr(arr1, arr2, (x: Int, y: Int) => x+y))
    println("Operate:", combineArr(arr1, arr2, (x: Int, y: Int) => x*x+y))
    
    //Problem 3
    println("\nProblem 3: ")
    println("Arr1:", arr1)
    println("Arr2:", arr2)
    println("Curried Add:", curriedCombineArr((x: Int, y: Int) => x+y)(arr1, arr2))
    println("Curried Operate:", curriedCombineArr((x: Int, y: Int) => x*x+y)(arr1, arr2))
    
    //Problem 4
    println("\nProblem 4: ")
    println("Arr1:", arr1)
    println("Curried my_map with Square:", my_map_Curried((x:Int) => x*x)(arr1))
    
    //Problem 5
    println("\nProblem 5: ")
    def apply_square = apply_combine2(x=>x*x)
    def apply_square_then_mult = apply_square((x, y)=>x*y)
    println("Long Way: ", apply_square_then_mult(5))
    println("Apply_Combine_2: ", apply_combine2(x=>x*x)((x, y)=>x*y)(5))
  }
  
  //Problem 2
  def combineArr(xs: List[Int], ys: List[Int], f: (Int, Int)=> Int): List[Int] =
  {
    //Base case: If either are empty, we ran out of corresponding elements
    if (xs.isEmpty || ys.isEmpty)
    {
      //Return the empty list and do nothing
      Nil
    } else // Recursive case
    {
      //println(f(xs.head, ys.head))
      //Do the operation and then cons that at the front of recursion
      f(xs.head, ys.head)::combineArr(xs.tail, ys.tail, f)
    }
  }
  //def add(x: Int, y: Int): Int = x+y
  //def operate(x: Int, y: Int): Int = x*x+y
  
  //Problem 3
  def curriedCombineArr(f: (Int, Int)=> Int): (List[Int], List[Int])=> List[Int] =
  {
    (xs: List[Int], ys: List[Int]) =>
      //Base case: If either are empty, we ran out of corresponding elements
      if (xs.isEmpty || ys.isEmpty)
      {
        //Return the empty list and do nothing
        Nil
      } else // Recursive case
      {
        //Do the operation and then cons that at the front of recursion
        f(xs.head, ys.head)::curriedCombineArr(f)(xs.tail, ys.tail)
      }
  }
  
  //Problem 4
  //Original my_map
//  def my_map(xs:List[Int], f:Int=>Int):List[Int] =
//  {
//      if(xs.isEmpty) Nil
//      else
//      {
//        f(xs.head)::my_map(xs.tail, f)
//      }
//  }
  
  //Curried my_map
  def my_map_Curried(f:Int=> Int):List[Int]=> List[Int] =
  {
    (xs: List[Int]) =>
      if(xs.isEmpty) Nil
      else
      {
        f(xs.head)::my_map_Curried(f)(xs.tail)
      }
  }
  //def square(x:Int):Int = x*x
  
  //Problem 5
  //Original apply_combine
//  def apply_combine(f: Int=>Int, x:Int, g: (Int, Int)=>Int):Int =
//  {
//      if(x==1)
//      {
//        1
//      }
//      else 
//      {
//        def term = f(x);
//        g(term, apply_combine(f, x - 1, g))
//      }
//  }
  
  //Curried apply_combine
  //Anonymous Version
  def apply_combine2(f: Int=>Int): ((Int, Int)=> Int)=> (Int=> Int) =
  {
    (g: (Int, Int)=> Int) =>
    def apply_combine_curried_once(fun: Int=> Int): ((Int, Int)=> Int, Int)=> Int =
    {
     (g_once: (Int, Int)=> Int, x: Int) =>
      if(x==1)
      {
        1
      }
      else 
      {
        def term = fun(x);
        g_once(term, apply_combine_curried_once(fun)(g_once, x - 1))
      }
    }
    f
  }
  
  //Non-Anomymous Version
  def apply_combine2_1(f: Int=>Int): ((Int, Int)=> Int)=> (Int=> Int) =
  {
    def temp1 (g: (Int, Int)=> Int) : Int =
    {
      def apply_combine_curried_once(fun: Int=> Int): ((Int, Int)=> Int, Int)=> Int =
      {
       def temp2(g_once: (Int, Int)=> Int, x: Int): Int = {
        if(x==1)
        {
          1
        }
        else 
        {
          def term = fun(x);
          g_once(term, temp2(g_once, x - 1))
        }
       }
       temp2
      }
      apply_combine_curried_once(f)(g, 5)
    }
    f
  }
  
  //                                                   apply_combine integer (x) => integer
//  def apply_combine2(f: Int=>Int): ((Int, Int)=> Int)=> (Int=> Int) =
//  {
//    (f_once: Int => Int, g: (Int, Int)=> Int, x: Int) =>
//      {
//      def apply_combine_curried_once(fun: Int=> Int): ((Int, Int)=> Int, Int)=> Int =
//      {
//       (g_once: (Int, Int)=> Int, x: Int) =>
//        if(x==1)
//        {
//          1
//        }
//        else 
//        {
//          def term = fun(x);
//          g_once(term, apply_combine_curried_once(fun)(g_once, x - 1))
//        }
//      }
//      f_once(apply_combine_curried_once(f)(g, x))
//      }
//  }
  
  
  //Beta
//  def apply_combine2(f: Int=>Int): ((Int, Int)=> Int)=> (Int=> Int) =
//  {
//    def apply_combine_curried_once(fun: Int=> Int): ((Int, Int)=> Int, Int)=> Int =
//    {
//     (g_once: (Int, Int)=> Int, x: Int) =>
//      if(x==1)
//      {
//        1
//      }
//      else 
//      {
//        def term = fun(x);
//        g_once(term, apply_combine_curried_once(fun)(g_once, x - 1))
//      }
//    }
//  }
  
//  def apply_combine2(f: Int=>Int): ((Int, Int)=> Int)=> (Int=> Int) =
//  {
//    def apply_combine_curried_once(fun: Int=> Int): ((Int, Int)=> Int, Int)=> Int =
//    {
//     (g_once: (Int, Int)=> Int, x: Int) =>
//      if(x==1)
//      {
//        1
//      }
//      else 
//      {
//        def term = fun(x);
//        g_once(term, apply_combine_curried_once(fun)(g_once, x - 1))
//      }
//    }
//    (g: (Int, Int)=> Int, ef: Int => Int) =>
//      apply_combine_curried_once(f)(g, 0)
//  }
  
  //Case
//  def apply_combine2(f: Int=>Int): ((Int, Int)=> Int)=> Int =
//  {
//    def apply_combine_curried_once(fun: Int=> Int): ((Int, Int)=> Int, Int)=> Int =
//    {
//     (g_once: (Int, Int)=> Int, x: Int) =>
//      if(x==1)
//      {
//        1
//      }
//      else 
//      {
//        def term = fun(x);
//        g_once(term, apply_combine_curried_once(fun)(g_once, x - 1))
//      }
//    }
//    (g: (Int, Int)=> Int) =>
//      apply_combine_curried_once(f)(g, 9)
//  }
}