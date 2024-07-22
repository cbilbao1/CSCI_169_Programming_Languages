



object bs {
  
  
def main(args:Array[String]){
  
  val l=Leaf
  val t= new Node(7, Leaf, Leaf)
  val t2=new Node(10, t, Leaf)
  
  
  //println(l.member(9))
  //println(t2.member(7))
  //println(t2.member(9))
  println(l member 9)
  println(t2 member 7)
  println(t2 member 30)
  
  l insert 5
  t2 insert 9
  
  t equals t2
  l equals t
  l equals l
  t equals l
  //l.isLeaf
  println(t2)
}

abstract class BSTree{ //Can't be instantiated - can't make an object of type BSTree.
	def member(x: Int): Boolean//Tells us if x is in the BSTree
	def insert(x: Int): BSTree 
	//creates a new tree that is the same as this one, but with x added
	//def isLeaf:Boolean
	def equals(other:BSTree):Boolean

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
} 

case class Node(value:Int, left:BSTree, right:BSTree) extends BSTree{
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
  
}
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

  
 
 */








