

object HW9P2Bilbao {
  def main(args: Array[String]) { 
    //We will represent a set of integers using a function
    //Characteristic function - takes in an integer, returns true if that integer
    //is in the set, false if it's not.
    
    def negs = (x:Int)=>x<0//This is a set; the set of negative integers
    //The type of a set Int=>Boolean
    //This representation works well if you want to determine membership in a set
    
    //{1}
    def oneset = (x:Int)=>x==1
    //Is 5 in negs?
    println(negs(5))
    
    //Makes our code easier to read
    def contains(s:Int=>Boolean, x:Int):Boolean = s(x)
    
    //Is 5 in negs?
    println(contains(negs, 5))
    println(contains(negs, -1))
    println(contains(oneset, 1))
    println(contains(oneset, 5))
      
    //Singleton set:  Set with one element
    //NOT a set; function that generates sets 
   
    def singletonSet(elem:Int):Int=>Boolean = 
      x=>x==elem
      
    def set7 = singletonSet(7)
    def setneg142 = singletonSet(-142)
    println(contains(set7, 9))
    println(contains(set7, 7))
    
    def intersection(s1:Int=>Boolean, s2:Int=>Boolean):Int=>Boolean=
      x=>contains(s1, x) && contains(s2, x)
      
    def inter = intersection(negs, setneg142)
    println(contains(inter, -142))
    println(contains(inter, -1))
    
   def union(s1:Int=>Boolean, s2:Int=>Boolean):Int=>Boolean=
      x=>contains(s1, x) || contains(s2, x)  
      
   def un = union(negs, set7)
   println(contains(un, 7))
   println(contains(un, -12))
   
   def diff(s1:Int=>Boolean, s2:Int=>Boolean):Int=>Boolean=
      x=>contains(s1, x) && !contains(s2, x)    
    
    
    def d = diff(negs, setneg142)
    println(contains(d, -142))
    println(contains(d, -555))
    
    //Problem 2
    def setlist(arr: List[Int]):Int=>Boolean =
    {
      //Base case, we are the last element of list
      if(arr.tail.isEmpty)
      {
        x=>x==arr.head
      } else  // Recursive case
      {
        //x=>/*x==arr.head &&*/ contains(setlist(arr.tail), arr.head)
        union(setlist(arr.tail), singletonSet(arr.head))
      }
    }
    //Filter Beta
//    def filter(s: Int=>Boolean, p: Int=>Boolean):Int=>Boolean =
//    {
//      (x: Int) =>
//        //Base case
//        if(p(x))
//        {
//            s(x)
//        } else  // Recursive case
//        {
//          filter(intersection(s, p), p)(x - 1)
//        }
//    }
    //Filter Gamma
//    def filter(s: Int=>Boolean, p: Int=>Boolean):Int=>Boolean =
//    {
//      (x: Int) =>
//          p(x) && s(x) && filter(intersection(s, p), p)(x - 1)
//    }
    def filter(s: Int=>Boolean, p: Int=>Boolean):Int=>Boolean =
    {
      (x: Int) =>
          contains(intersection(s, p), x)
    }
    def forall(s:Int=>Boolean, p:Int=>Boolean):Boolean =
    {
        //contains(diff(s, p), negs)
        //Taking difference of same set is empty set, should have nothing
        //!contains(union(diff(s, p),diff(p, s)), 1)
        //!contains(intersection(diff(s, p),diff(p, s)), 1)
        !contains(diff(p, s), 1) && !contains(diff(s, p), 1)
    }
    
    def a = List(1, 2, 3)
    println("SetList 5: ", contains(setlist(a), 5))
    println("SetList 3: ", contains(setlist(a), 3))
    
    def pos = (x:Int)=>x>0
    println("Filter Pos Oneset: ", contains(filter(pos, oneset), 1))
    println("Filter Neg Oneset: ", contains(filter(negs, oneset), 1))
    println("Filter Exclusive: ", contains(filter(negs, pos), 0))
    
    println("Forall: ", forall(negs, pos))
    println("Forall: ", forall(negs, negs))
    println("Forall: ", forall(pos, pos))
    println("Forall: ", forall(pos, oneset))
    println("Forall: ", forall(negs, oneset))
    println("Forall: ", forall(oneset, oneset))
  }
}