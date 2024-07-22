

object Sets {
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
    
  }
}
    
    
    