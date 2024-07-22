

object Scala_Final_Practice {
  def main(args: Array[String]) {
    //println(prob1(List(1), List(2), (x,y)=>x+y))
    //println(prob2(List(1, 2, 3, 4, 5), x=>x%2==0))
    //println(prob3(x=>x%2==0)(List(1, 2, 3, 4, 5)))
    println(swap_pairs(List(1, 2, 3, 4)))
  }
  def prob1(xs: List[Int], ys:List[Int], f: (Int, Int)=>Int):List[Int] =
  {
    //Base case
    if (xs.tail.isEmpty || ys.tail.isEmpty)
    {
      List(f(xs.head, ys.head))
    } else
    {
      f(xs.head, ys.head)::prob1(xs.tail, ys.tail, f)
    }
  }
  def prob2(xs:List[Int], f: Int=>Boolean):List[Int] =
  {
    if (xs.tail.isEmpty)
    {
      Nil
    } else if (f(xs.head))
    {
      xs.head::prob2(xs.tail, f)
    } else
    {
      prob2(xs.tail, f)
    }
  }
  def prob3(f: Int=>Boolean):List[Int]=>List[Int] =
  {
    (xs:List[Int]) =>
      if (xs.tail.isEmpty)
      {
        Nil
      } else if (f(xs.head))
      {
        xs.head::prob3(f)(xs.tail)
      } else
      {
        prob3(f)(xs.tail)
      }
  }
//  def swap_pairs(xs:List[Int]):List[Int] =
//  {
//    if (xs.tail.isEmpty)
//    {
//      Nil
//    } else
//    {
//      xs.tail.head::xs.head::swap_pairs(xs.tail.tail)
//    }
//  }
  def swap_pairs(xs:List[Int]):List[Int] =
  {
    xs match {
      case Nil =>
        Nil
      case y::ys =>
        ys.head::y::swap_pairs(ys.tail)
    }
  }
}

//Problem 1
//CBV --
//foo(1+3, 2+2, 5)
//1. foo(4, 4, 5)
//2. if (4 == 4) 4*4 else 5
//3. if (true) 4*4 else 5
//4. 4*4
//5. 16
//CBN --
//1. if (1+3 == 2+2) (1+3)(1+3) else 5
//2. if (4 == 2+2) (1+3)(1+3) else 5
//3. if (4 == 4) (1+3)(1+3) else 5
//4. if (true) (1+3)(1+3) else 5
//5. (1+3)(1+3)
//6. 4(1+3)
//7. 4*4
//8. 16
//CBV wins