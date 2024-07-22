

object HW8P2Bilbao {
  def main(args:Array[String]){
  
  val l=Leaf
//  val t= new Node(7, Leaf, Leaf)
//  val t2=new Node(10, t, Leaf)
  
  
  //println(l.member(9))
  //println(t2.member(7))
  //println(t2.member(9))
//  println(l member 9)
//  println(t2 member 7)
//  println(t2 member 30)
  
//  l insert 5
//  t2 insert 9
//  
//  t equals t2
//  l equals t
//  l equals l
//  t equals l
  //l.isLeaf
//  println(t2)
  
  val t1= new Node(4, Leaf, Leaf)
  val t2=new Node(5, t1, Leaf)
  val t3=new Node(2, t2, Leaf)
  val subt3=new Node(5, t1, Leaf)
  val subt4=new Node(7, t1, Leaf)
  println("Depth t2: ", t2.depth)
  println("Depth t3: ", t3.depth)
  println("Max t3: ", t3.max)
  println("Is subt3 subtree of t3?: ", subt3.exactsubtree(t3))
  println("Is subt4 subtree of t3?: ", subt4.exactsubtree(t3))
  
}

abstract class BSTree{ //Can't be instantiated - can't make an object of type BSTree.
	def member(x: Int): Boolean//Tells us if x is in the BSTree
	def insert(x: Int): BSTree 
	//creates a new tree that is the same as this one, but with x added
	//def isLeaf:Boolean
	def equals(other:BSTree):Boolean
	def depth:Int
	def max:Int
	def exactsubtree(that:BSTree):Boolean

}
//Put case in front of all child types to allow pattern matching
case object Leaf extends BSTree{
  override def toString = "."
  def member(x: Int): Boolean = false
  def insert(x: Int): BSTree = new Node(x, Leaf, Leaf)
  //def isLeaf:Boolean = true
	def equals(other:BSTree):Boolean =
	  other match{
    case Leaf => true//Case 3
    case Node(v, l, r)=>false//Case 2
  }
  //1: t.equals(t2)
  //2: l.equals(t)
  //3: l equals l
  //4: t equals l
  
  //Problem 2
  def depth:Int =
  {
      //We reached a leaf
      0
  }
  def max:Int =
  {
    //Trust in the traversal, this node should be the max
    //Not the max, but a dead end
    0
  }
  def exactsubtree(that:BSTree):Boolean =
  {
    def l = Leaf
    //A leaf is a subtree of anything, or if both are leaves
//    if (this.equals(l) || this.equals(that))
//    {
//        true
//    } else if (that equals l) //Nothing can be a leaf of a subtree
//    {
//        false
//    } else
//    {
//      true
//    }
    that match{
    //A leaf will always be a subtree of anything 
    case Leaf => true  // This is a leaf, that is a leaf
    case Node(v, l, r)=> true  // This is a leaf, that is a node
    }
  }
} 

case class Node(value:Int, left:BSTree, right:BSTree) extends BSTree{
//  val v = value
  //val l = le
//  val r = right
  override def toString = "{"+left.toString+value.toString+right.toString+"}"
  def member(x: Int): Boolean = 
    if(x==value) true
    else if(x<value) left member x//left.member(x)
    else right member x //right.member(x)
  def insert(x: Int): BSTree = 
    if(x==value) new Node(value, left, right)//this
    else if(x>value) new Node(value, left, right insert x)
    else new Node(value, left insert x, right)

  //def isLeaf:Boolean =false
	def equals(other:BSTree):Boolean =
	  other match{
    case Leaf => false//Case 4
    case Node(v, l, r)=> 
      ((value==v) && (right equals r)  && (left equals l))//recursive call - left and right must both be equal
    //Case 1
  }
  //1: t.equals(t2)
  //2: l.equals(t)
  //3: l equals l
  //4: t equals l
  
  //Problem 2
  //Beta
//  def depth:Int =
//  {
//    //val l = Leaf
//    //Counts down all on the left
//    // We are at some node somewhere
//    def inner(other: BSTree, count:Int):Int/*BSTree*/ =
//    {
////      val countLeft = new Node(value, inner(left, count+1), right)
////      val countRight = new Node(value, left, inner(right, count+1))
//      val countLeft = inner(left, count+1)
//      val countRight = inner(right, count+1)
//      //Get the count with the higher value, establishes true depth
//      if (countLeft > countRight)
//      {
//        countLeft
//      } else
//      {
//        countRight
//      }
//    }
//    inner(this, 0)
//  }
  //
  def depth:Int =
  {
    //val l = Leaf
    //Counts down all on the left
    // We are at some node somewhere
    //def inner(other: BSTree, count:Int):Int/*BSTree*/ =
    //{
//      val countLeft = new Node(value, inner(left, count+1), right)
//      val countRight = new Node(value, left, inner(right, count+1))
      val countLeft = 1 + left.depth
      val countRight = 1 + right.depth
      //Get the count with the higher value, establishes true depth
      if (countLeft > countRight)
      {
        countLeft
      } else
      {
        countRight
      }
    //}
    //inner(this, 0)
  }
  def max:Int =
  {
    val l = Leaf
    //Node base case, we reached the end
    if (left.equals(l) && right.equals(l))
    {
      value
    } else
    {
      val maxLeft = left.max
      val maxRight = right.max
      //Get the max with the higher value, establishes true max
      if (maxLeft > maxRight && maxLeft > value)
      {
        maxLeft
      } else if (maxRight > maxLeft && maxRight > value)
      {
        maxRight
      } else
      {
        value
      }
    }
  }
  def exactsubtree(that:BSTree):Boolean =
  {
//    that match{
//    case Leaf => false
//    case Node(v, l, r)=> 
//      exactsubtree(l) || exactsubtree(r)//recursive call
//    }
    that match{
    case Leaf => false  // This is a node, that is a leaf
    case Node(v, l, r)=> if (this.equals(that)) true  // The current tree passed
                         else  // The current tree failed, so check the subtrees
                         {
                            exactsubtree(l) || exactsubtree(r)//check both sides
                         }
    }
  }
  
}

  //Problem 2
  //Takes in no parameters
//  def depth:Int =
//  {
//    val l = Leaf
//    //Counts down all on the left
//    def innerCount(node:BSTree, count:Int):Int =
//    {
//      //If we reached a leaf
//      if (node equals l)
//      {
//        0
//      } else  // We are at some node somewhere
//      {
//        val countRight = 1 + innerCount(
//      }
//    }
//  }
}
























/*
 * 
  def printy(level:Int):Unit = {
    def loop(x:Int):Unit = if(x==0) print("  ")else {print("  "); loop(x-1)} 
    loop(level) 
    println("Leaf")}
    
    def printy(level:Int):Unit = {
	  right.printy(level+1);
    def loop(x:Int):Unit = if(x==0) print("  ")else {print("  "); loop(x-1)} 
    loop(level) 
    println(value); left.printy(level+1)}
    
 */















/*
 * 
 object bs {
  
  
def main(args:Array[String]){
  val t = new Node(5, Leaf, Leaf)
  val t2 = t.insert(3).insert(7).insert(6).insert(2).insert(1)
  println(t2.toString)//toString included to help with debugging.
  val t3 = t.insert(2).insert( 8).insert( 1).insert( 10)
  println(t2 merge t3)
  println(t2 both t3)
}

abstract class BSTree{ //Can't be instantiated - can't make an object of type BSTree.
  //CAN have variable whose type is BSTree, but the object it references will be a Leaf or Node
	def member(x: Int): Boolean//Tells us if x is in the BSTree
	def insert(x: Int): BSTree//creates a new tree that is the same as this one, but with x added
	def equal(other:BSTree):Boolean//Returns true if the two trees have identical values and structure, false o/w
	def merge(other:BSTree): BSTree//Creates a new tree which contains all elements of this and of other
	def both(other:BSTree): BSTree
}


case object Leaf extends BSTree{//"object" means we only create one Leaf object - but this is OK because we can have as many references to it as we like.
	def member(x: Int): Boolean = false//Nothing is in the empty tree
	def insert(x: Int): BSTree = new Node(x, Leaf, Leaf)
	def equal(other:BSTree):Boolean = {
	  this match {
	    case Leaf => 
	  }
	  this==other
	}
	/*
	def equal(other:BSTree):Boolean = {
	 other match{
       case Leaf => true
       case Node(_, _, _) => false//_ don't care
     }
	}
	*/
	override def toString = "."
		def merge(other:BSTree): BSTree = other//Creates a new tree which contains all elements of this and of other
	def both(other:BSTree): BSTree = Leaf
}

case class Node(value: Int, left: BSTree, right: BSTree) extends BSTree{
  def member(x: Int): Boolean = {
    if(value == x) true
    else if(x<value) left.member(x)
         else right member x
  }
    

   def insert(x:Int):BSTree = {//creates a new tree that is the same as this one, but with x added
     //No duplicates
     if(x<value)new Node(value, left.insert(x), right)       //Return type is boolean.  Recursion - recurse down both left and right or just one?
     else if (x>value)new Node(value, left, right insert x) 
     else this//new Node(left, right)
   }
   def equal(other:BSTree):Boolean = {
     other match{
       case Leaf => false
       case Node(v, l, r) =>  (value==v) && (left equal l) &&  (right equal r) 
     }
     
   }
   /*
   def insert(x:Int):BSTree = {//creates a new tree that is the same as this one, but with x added
     //No duplicates
     if(this member x) this
     else if(x<value)new Node(value, left.insert(x), right)       //recurse left//Recursion - recurse down both left and right or just one?
     else new Node(value, left, right insert x) 
   
   }
    */
    override def toString = "{"+left.toString+value.toString+right.toString+"}"
	def merge(other:BSTree): BSTree = {
      other match{
        //Creates a new tree which contains all elements of this and of other
        case Leaf=> this
        case Node(v, l, r) => this merge l merge r insert v
      }
    }
	def both(other:BSTree): BSTree = {//FInal exam problem!!!!!
	        other match{
	          case Leaf=> Leaf
        case Node(v, l, r) => if(this member v)
          (this both l) merge (this both r) insert v
        else (this both l) merge (this both r) 
      }
	}
}
}
*/