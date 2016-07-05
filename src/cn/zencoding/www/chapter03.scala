package cn.zencoding.www
/**
  * Created by zen on 2016/6/25.
  */
object chapter03 {
  def main(args: Array[String]) {
    /**
      * 块表达式使用大括号{}结合多个表达式创建一个块表达式，块中最后一个表达式为争个块表达式的返回值
      * 表达式也可以嵌套
      */
    val amout = {val x:Int = 20
      val y:Int = 30
      x+y} //返回值为x+y
    val res = {
      val a:Int = 1;
      {val b:Int = 2 ;
        {
          val c:Int = a+b;
          c
        }}
    }
    println(amout)
    println(res)

    /**
      * if ...else 表达式块
      */
    //if...else 表达式
    val num: Int = 5
    val num0 :Int = 2
    if (num%2 == 1) println(s"${num}是奇数!") else println(s"${num} 是偶数！")
    if (num==0) println("安徽人") else if(num==1) println("上海人") else println("其它人")
    val max :Int = if (num>num0) num else num0

    //匹配表达式
    val max0 = (num > num0) match {
      case true => num
      case false => num0
    }
    println(max,max0)

    val status:Int = 500
    val message = status match{
      case 200 => "ok"
      case 400 => { println("Error:we called service incorrectly!")
                    "Error" //最后一个表达式的值会作为匹配表达式的返回值
      }
      case 500 => {
        println("Error:the service encountered an error!")
        "Error" //最后一个表达式的值作为匹配表达式的返回值
      }
    }
    println(message)
     //模式替换式 match 是表达式 不是语句,所以有返回值
    /**
      * 通配模式匹配包括 值邦定：case other 和通配符模式 case _
      * 模式哨位：case pattern if <boolean expression> => <one or more expression>
      */
    val day:String = "mon"
    val kind :String = day match{
      case "mon"|"tue"|"wed"|"thu"|"fri" => "workday"
      case "sta"|"sun"=>"weekday"
      case other if other != null =>s"can't parse ${other}" //case other 模式能够捕获剩余的情况 利用case _ 也可以
    }
    println(kind)

    /***
      * for 循环语法：for（<indentifier> <- <iterator>） [yield] [<expression>]
      * yield关键字把迭代语句转换为一个表达式，表达式是有返回值的，返回值是集合的形
      */
    for {x <- 1 to 10} {println(s"day:${x}")} //循环表达式其实是个语句，没有返回值，因为没有yield关键字
    val days = for {x <- Range(1,10,2)} yield{s"day:${x}"} //yield关键字把迭代语句转换为一个表达式，表达式是有返回值的
    val thress = for (x <- 1 to 100 by 3 if x % 2 ==0 ) yield x //为迭代器增加一个if 也称为过滤器（filter）
    println(days)
    val line:String = "China has reaffirmed that its construction work in the South China Sea is lawful and reasonable"
    //println(line.split(" ").toList)
    val words= for {word <- line.split(" ") if word.size > 3} yield word //split类似python中的split
    println(words.toList)

    //嵌套循环
    val tuples = for {x <- 1 to 3
         y<- 1 until 5 by 2}
      yield (x,y)
    println(tuples)

    //循环值绑定
    /**
      * 语法：for 循环中的值绑定
      * for (indentifier <- iterator ; identifier = expression)
      */
    val powOf2 = for (i <- 1 until 10 ; pow = 1 << i) yield (i,pow)
      println(powOf2)

  }
}
