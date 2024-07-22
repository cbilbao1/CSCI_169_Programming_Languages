

object D4 {

def main(args:Array[String]){
        //Define a function applyrange that returns a new list whose length is the same as the input list, 
        //but values at indices start to end (inclusive) are replaced by f applied to that value
        def applyrange(xs:List[Int], start:Int, end:Int, f:Int=>Int):List[Int] = 
          if(xs.isEmpty) Nil
          else if (start<=0 && end>=0) f(xs.head)::applyrange(xs.tail, start-1, end-1, f)
          else  xs.head::applyrange(xs.tail, start-1, end-1, f)
        //recursive call:  subtract 1 from start and end 
  
  def l = List(1, 2, 5, 2, 6, 2, 8, 4, 2)
  println(applyrange(l, 2, 5, (x:Int)=>x*x))
  
 
          
  
  
          
  
  val a = new Rational(1, 2)                
  print(a.numer)
  print("/")
  println(a.denom)
  val b = new Rational(3, 4)
  //val c = a.mult(b) 
  //val c = a mult b       
  //val c = a.*(b) 
  val c = a + b 
  print(c.numer)
  print("/")
  println(c.denom)


}
}






//x and y can only be accessed inside the class
//essentially private fields
class Rational(x:Int, y:Int){//The class is the same as the primary constructor 
  //(usually the constructor that takes most params)
  def this(n:Int) = this(n, 1)
  def this() = this(0, 1)
  private val g= gcd(x, y)
  val numer = x/g //members are by default public
  val denom = y/g //other choices are private and protected
  
  def *(that:Rational) : Rational = 
      new Rational(this.numer*that.numer, this.denom*that.denom)
  
  //Define +
  def +(that:Rational): Rational = 
    new Rational(this.numer*that.denom+that.numer*this.denom, this.denom*that.denom)
  def unary_- = new Rational(-this.numer, this.denom)
  def -(that:Rational): Rational = this + (-that)
  private def gcd(a:Int, b:Int):Int = if(b==0) a else gcd(b, a%b)
  
}
















