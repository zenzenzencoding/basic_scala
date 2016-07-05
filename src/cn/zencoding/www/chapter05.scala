package cn.zencoding.www

/**
  * Created by zen on 2016/6/30.
  */
object chapter05 {
  def main(args: Array[String]) {
    println(safeStringOp("zenwan",reverse))
    println("the max number is " + maxmize(2,3))
    println("the max number is " + maxmizee(2,3))
    println(double2(2))
    //占位符的位置顺序
    val res:Int = combination(2,3,_*_)
    println(res)
    /**
      * 通过函数柯里化使得函数factorof 的函数类型由(Int,Int)=>Bolean 变成(Int)=>Boolean型
      */
    val isEven:(Int)=>Boolean = factorof(2) _
    val z:Boolean = isEven(32)
    println(z)
    /**
      * 用函数字面量来调用高阶函数
      */
    //val uperString :String = uper("zenwan"){_.toString.toUpperCase}
    val upperString :String = upper("zenwan"){(s:String)=>s.toUpperCase}
    println(upperString)
  }

  /**
    * 函数类型和函数值(函数类型的值就叫函数值)
    * 函数类型是其输入类型和返回值类型的简单组合，由一个箭头从输入类型指向输出类型
    * 语法：(type,……)=> type 如果()表示函数没有参数输入
    * 例如 函数def double(x:Int):Int = x*2 的函数类型就是Int => Int.这表示有一个Int参数，并返回一个Int型值。
    */
  def double(x:Int):Int = {x*2}
  val myDouble:(Int)=>Int = double //myDouble 是一个函数值而不是一个函数调用，所以必须显示的声明类型

  /**
    * 高阶函数：高阶函数也是函数，塔包含一个函数类型的值(函数值)作为输入参数或者返回值
    */
  def safeStringOp(s:String,f:String=>String):String = {
    if (s!=null) f(s)
    else s
  }
  def reverse(s:String):String = {s.reverse}

  /**
    * 函数字面量(匿名函数)
    * 函数字面量可以存储在函数值和变量中
    * 语法 (参数：类型，……)=>{表达式}
    */
  //先看一个函数赋值的例子
  def max(a:Int,b:Int):Int = if (a>b) a else b
  val maxmize:(Int,Int) => Int = max

  //再看函数字面量(匿名函数)
  val maxmizee:(Int,Int)=>Int = (a:Int,b:Int)=> if(a>b) a else b //val 函数值:函数类型 = 函数字面量
  //val maxmizee = (a:Int,b:Int)=> if(a>b) a else b //类型推导
  /**
    * 占位符语法
    * 占位符语法是函数字面量的一种缩写形式，将命名参数替换成通配符(_)
    */
  val double2 :Int => Int = _*2
  def combination(x:Int,y:Int,f:(Int,Int)=>Int)=f(x,y)

  /**
    * 部分应用函数和函数
    * 可以使用多个参数表的函数，另外一个不使用参数表，这种技术称为函数柯里化
    */
  def factorof(x:Int)(y:Int):Boolean = y%x==0

  /**
    * 全函数：函数f(x)没有不能处理的参数x
    * 偏函数：不能满足输入类型的所有可能的值，如一个除法函数的分母为0，函数就无法工作，这就是偏函数
    */
  val statusHandler:(Int)=>String = {
    case 200 => "OKAY"
    case 400 => "Your error"
    case 500 => "Our error"
    case other if other != null => "什么鬼！"
  }
  /**
    * 用函数字面量(匿名函数)来调用高阶函数
    */
  def upper(s:String)(f:(String)=>String):String= {
    if (s!= null) f(s) else s
  }
}
