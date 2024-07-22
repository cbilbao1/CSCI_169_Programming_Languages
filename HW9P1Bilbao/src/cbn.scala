

object cbn {
  def main(args: Array[String]) { 

    
    
  def mostlyfirst(x:Int, y: =>Int) = 
    //Does it make sense to make either of these CBN?
    if(x!=0) x else y*y
    //It makes no sense for x to be CBN because it's always used
  mostlyfirst(8+9, 3+1*3+2-1)//CBN
  mostlyfirst(4, 3+1)//CBN
  mostlyfirst(0, 3+1)//CBV
  //Which will be more efficient:  having y CBN or CBV
  
  def square(x:Int) = x*x
  def mostlyfirst2(x:Int, y: =>Int) = 
    //Does it make sense to make either of these CBN?
    if(x!=0) x else square(y)
  
  def mostlyfirst3(x:Int, y: =>Int) = 
    if(x!=0) x 
    else {
      val used = y//Now y will only be evaulated once in the case that it is used
      used*used
    }
      
  
  println("Next def arg")
  def arg = {println("Hello world"); 3+1+2+3}
  println("Next val arg2")
  val arg2 = {println("Hello world"); 3+1+2+3}
  println("Next mostlyfirst(0, arg)")
  mostlyfirst(0, arg)
  println("Next mostlyfirst(0, arg2)")
  mostlyfirst(0, arg2)
 
  
  def loop:Int = loop
  
  def first(x:Int, y: =>Int):Int = x
  
  println(first(5, loop))
  
  
  def fact(i:Int):Int = if(i==0) 1 else i*fact(i-1)
  
  def evaluate(x:Int, expr: =>Int):Int = if(x>=0) expr else -1
  
  println(evaluate(-5, fact(-5)))
  
  def evaluate2(x:Int, cond:Int=>Boolean, expr: =>Int, default:Int):Int = 
    if(cond(x)) expr else default
  
  println(evaluate2(-5, x=> x>=0, fact(-5), -1))
  
  
  
  
  def plus(x:Int, y:Int) = x+y
  def plus2(x:Int):Int=>Int =y=> x+y
  plus(2, 3)
  plus2(5)(7)
  def plus7 = plus2(7)
  plus2(5)({println("Hello world"); 3+1+2+3})
  
  plus2(5){//Scala lets us leave off the () if we're using {} on a parameter
    println("Hello world"); //:Unit
    3+1+2+3
    }
  
  //Unit is the type of a print statement or other side effect
  def doTimes(i:Int): (=>Unit)=>Unit ={
    def inner(body: =>Unit): Unit ={
      if(i>0){
        body
        doTimes(i-1)(body)
      }
    }
    inner 
  }
//Print "Hello World" 10 times
  println()
  doTimes(10)(println("Hello World"))
  
  doTimes(10){
    println("Hello World")
  }
  doTimes(10){//A function call that looks like a control structure
    def f(x:Int) = x*x*x
    println(f(3))
    println("Hello World")
  }

  }
}




