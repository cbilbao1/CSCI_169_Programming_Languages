

object caselist {
def main(args:Array[String]){
val l1 = 6::5::4::3::2::1::Nil;
val l2 = List(1, 2, 3, 4)//factory, NOT a constructor
//1::2::3::4::Nil
val l3 = List()
//Nil

  
def remove(xs: List[Int], x: Int): List[Int] = {
    if (xs.isEmpty) Nil
    else if (xs.head == x) remove(xs.tail, x)
    else xs.head :: remove(xs.tail, x)
  }
println(remove(l1, 4))


//With pattern matching:
 def remove2(xs: List[Int], x: Int): List[Int] = {
    xs match {
      case Nil => Nil
      case y::ys => if (y == x) remove(ys, x)// y is xs.head
                    else y :: remove(ys, x)//ys is xs.tail
    }                                  
  }
println(remove2(l1, 4))

//Write a function count that takes in a list of Ints and an Int value
//and tells you how many times that value occurs in the list.  
//Use pattern matching.
//https://docs.google.com/document/d/12696KNToIbPTreGE8nBj7dsy3IaWmebkSzlV9Y4ejbc/edit?usp=sharing

def count(xs:List[Int], x:Int):Int = {
  xs match {
    case Nil =>0
    case y::ys => if(y==x) 1+count(ys, x)
                  else count(ys, x)
  }
}





















}
  



/*
 * 
 * 
 * 
 * 
//With pattern matching:
 def remove2(xs: List[Int], x: Int): List[Int] = {
    xs match {
      case Nil => Nil
      case y::ys => if(y==x) remove2(ys, x)//y is xs.head, ys is xs.tail        
                    else y :: remove2(ys, x)
    }                                  
  }
println(remove2(l1, 4))


  def removeFives(xs: List[Int]): List[Int] = {
    xs match {
      case Nil => Nil
      case 5::ys => removeFives(ys)
      case y::ys =>  y :: removeFives(ys)//If we switched the last two cases, the 5::ys case would never be reached
    }                                  
  }                                
  
 println(removeFives(l1))

/*
   //you can't use x in the case to match the head automatically.  You CAN 
   //do this with literal values like 5, but NOT with variables
  def remove3(xs: List[Int], x: Int): List[Int] = {
    xs match {
      case Nil => Nil
      case x::ys => remove2(ys, x)//Happens for all cons cases, not just the ones whose head is the same as the function parameter x
      case y::ys => y::remove2(ys, x)//You will never reach this case  
    }                                  
  }
  println(remove3(l1, 4))
  * 
  */
 * Note:  You CAN do
  def remove5(xs: List[Int]): List[Int] = {
    xs match {
      case Nil => Nil
      case 5::ys => remove5(ys) 
      case y::ys => y::remove5(ys)  
    }                                  
  }
  * /
  */
}