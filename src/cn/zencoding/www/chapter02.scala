package cn.zencoding.www

/**
  * Created by zen on 2016/6/24.
  */

//引用 scala 工具包
import scala.util.matching.Regex
object chapter02 {
  def  main(args: Array[String]) {
    //用反引号括起来的可以是scala的保留字
    //三重引号可以创建多行字符串
    val `zen.wan` =
      """the true
        |name is
        |zen.wan""".stripMargin
    println(`zen.wan`)

    //内插字符串 第一个双引号前加前缀’s‘ 然后使用${}引用外部数据
    val name : String = "zenwan"
    val birth : Int = 1991
    var school :String = null //变量不会指向内存中任何字符串实例
    var line : String  = s"hello my name is ${name} and i was born in ${birth}!"
    println(line)

    //正则表达式
    val pattern0 = """.*\w++ ([\d]+).*""".r //字符串后面有.r 等价于下面一句
    //调用r操作将字符串转化为正则表达式类型。返回一个Regex类型
    val pattern1 = new Regex(""".*name is (\w+) and .*""")
    val pattern0(year) = line
    val pattern1(nicheng) = line
    println(year.toDouble,nicheng)  //to<type> 类型操作

    //元组是一个包含两个或者多个值得有序容器，所有这些值可以有不同的类型。
    //元组的索引从1开始
    val info1  = ("zenwan",25,true)
    println(info1._1)

    //对于2元元组，可以使用关系操作符(->) 类似python中 创建key-value的形式
    val info2 = "zenwan" -> "ecnu"
    val info3 = info2._2 -> info2._1 //反转key-value
    print(info2,info3)

  }
}
