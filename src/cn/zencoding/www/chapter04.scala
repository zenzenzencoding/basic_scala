package cn.zencoding.www

/**
  * Created by zen on 2016/6/27.
  */
object chapter04 {
  /**
    * 函数是一个可以重用的命名表达式，函数可以参数化，可以返回一个值
    */
  def main(args: Array[String]) {
    println(multiplier(2,3))
    println(safeTrim("bbb"))
    println(hi())
    /**
      * 使用表达式块来调用函数
      * 使用一个参数调用函数时候，可以利用一个用大括号括起来的表达式块来发送参数而不是小括号：functionName{param}
      * 例如向函数发送一个计算值时候，不必先计算一个量后把它保存在局部值中再传递给函数，完全可以在表达式块中完成计算，
      * 表达式块会在调用函数前计算，而且表达式块中返回值将作作为这个函数的参数
      */
    println(formatEuro{val rate = 1.32; 0.235+0.7123+rate*5.32})
    println(power(2,3))//递归函数
    println(powerTailrec(2,3,1))
    println(max(3,2,5))
    println(greet("hello"))
    println(greet(name="zenzen",prefix="hello"))
    println(identity("hello"))
    println(identity(123))

  }
  def multiplier(x:Int,y:Int):Int={
    x*y} //最后一行是表达式的返回值 也可以显示的使用return 提前退出函数

  def safeTrim(s:String):String = {
    if(s=="aaa") return s+"bbbb"
    else {s+"ccc"}//去掉左右两边空格
  }

  /**
    * 过程是没有返回值的函数，以一个语句结尾的函数也是一个过程
    * 如果一个函数没有显示的指定返回类型，而且最后一个是语句，Scala编译器会推导出这个函数的返回类型为Unit
    * @param d:double
    */
  def log(d:Double):Unit = {print(s"got a value :${d}")}

  /**
    * 要定义和调用一个无参的函数，可以使用空括号（）,调用的时候也可以不叫空括号,但如果定义时候函数没有加小括号，调用的时候也是不能加小括号的
    */
  def hi():String = "hi"

  def formatEuro(amt:Double):String = f"$amt%.2f"

  /**
    * 递归函数：函数调用自身函数,每个函数调用自己的栈来存储函数的参数
    * 可以用尾递归（tail-recursion)来优化递归函数，使的递归不再使用额外的栈空间，不会创建新的栈空间，而是使用当前函数的栈空间
    * 注意：只有最后一个语句是递归调用的函数才能完成递归优化
    */
  def power(x:Int,n:Int):Int= {
    if (n==0) 1
    else {x*power(x,n-1)}
  }
  //优化的递归函数
  @annotation.tailrec
  def powerTailrec(x:Int,n:Int,res:Int=1):Long={
    if (n==0) res
    else {powerTailrec(x,n-1,x*res)}
  }

  /**
    * 函数是命名的参数化的表达式块，而表达式是可以嵌套的，所以函数本身也是可以嵌套的
    * 某些情况下，需要在一个方法中重复某个逻辑，三十把它作为一个外部方法又没有太大的意义，这种情况下就可以在函数中定义另外一个内部函数
    * 内部函数只能在该函数中使用。
    */
  def max(a:Int,b:Int,c:Int):Int = {
    def max(a:Int,b:Int):Int = {if (a>b) a else b}
    max(a,max(b,c))
  }
  def greet(prefix:String,name:String="zenwan"):String = {s"$prefix,$name"}
  //可变长度参数
  def sum(items:Int*):Int = {
    var total = 0
    for (item <- items) {total+=item}
    return total
  }

  /**
    * 定义函数的类型参数 def function-name[type-name](param:type-name):type-name= {}
    * 函数的参数或者返回值类型不固定，而是友函数调用者自己设置
    * @param a
    * @tparam A
    * @return
    */
  def identity[A](a:A):A = a

}
