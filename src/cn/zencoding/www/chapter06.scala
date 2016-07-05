package cn.zencoding.www

/**
  * Created by zen on 2016/7/4.
  */
/**
  * 集合(collections)框架提供了一些数据结构来收集给定类型的一个或者多个值，如数组，列表，映射，集和树;
  * 集合和其它的集合中提供的foreach(),map()和reduce()等高阶函数;
  */
object chapter06 {
  def main(args: Array[String]) {
    /**
      * List类型:不可变的单链表 类型定义 List[type]
      * List 的head,tail以及高阶函数方法
      * List 的遍历
      */
    val numbers: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val numbersList: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6))
    val listTuple: List[(String, Int)] = List(("zenwan", 177), ("xiaohua", 139)) //List的元素是元组
    val colors: List[String] = List("red", "green", "blue")
    println(numbers.head)
    println(numbers.tail)
    var total = 0;
    var count: Int = 0;
    for (item <- numbers) {
      total += item
    }
    println(s"the total = $total")
    val newList: List[Int] = numbers.map((s: Int) => {
      s + 1
    }) //函数字面量 (参数0:类型0,参数1:类型1……)=> {表达式}
    //val sumList:Int = numbers.reduce((a:Int,b:Int)=>a+b)
    //val newList:List[Int] = numbers.map(_+1)
    val sumList: Int = numbers.reduce(_ + _) //占位符
    val evenList: List[Int] = numbers.filter((x: Int) => x % 2 == 0) //过滤函数 filter
    colors.foreach(println(_)) //foreach()取一个函数(更准确的说是过程，返回类型为Unit)
    println(s"newList:$newList")
    println(s"sumList:$sumList")
    println(s"evenList:$evenList")
    println(listTuple)
    //for (item <- numbersList){println(item)}
    numbersList.foreach(println(_))
    var colorsTmp: List[String] = colors
    while (!colorsTmp.isEmpty) {
      println(colorsTmp.head);
      colorsTmp = colorsTmp.tail
    }


    /**
      * Set 是一个不可变的无序集合，只包含不重复的唯一元素，Set与List类型类似，支持同样的操作
      */
    val unique: Set[Int] = Set(1, 2, 3, 4, 5, 4, 5, 5, 5, 0, 6, 7, 8, 9)
    println(s"unique:$unique")
    println("numbers2set:" + numbers.toSet) //List 转 Set

    /**
      * Map 是一个不可变的键值对库，其它语言中可能会称为散列哈希或者字典等。在Map中，值按一个给定的唯一建存储
      * 创建Map时，指定键-值对为元祖，可以使用关系操作符(->)来指定键值对元组。
      */
    val telphoneMap: Map[String, Long] = Map("zhangsan" -> 18218188678L, "zenwan" -> 17717876285L, "xiaohua" -> 13966711657L)
    println(s"telphoneMap:$telphoneMap")
    println(s"telphoneMap[zenwan]:" + telphoneMap("zenwan"))
    println(telphoneMap.contains("xiaohua"))

    /**
      * Cons 操作符构建列表
      * 使用Nil作为基础，并使用右结合的cons操作符::绑定元素，就可以构建一个列表，而不必使用传统的List()格式
      */
    val numbersCons = 1 :: 2 :: 3 :: 4 :: 5 :: Nil //右结合操作
    println(s"numbersCons:${numbersCons}")
    println(5 :: numbersCons)
    /**
      * 列表的修改均需要返回一个新的列表，因为List 是一个不可变的集合
      * :: 为列表开头追加单个新的元素(右结合) :+列表末尾追加元素(左结合)
      * :::在列表前面追加另一个列表
      * ++ 为列表追加另一个集合
      * distinct 返回不包含重复元素的列表
      * drop 从列表中删除前n个元素
      * filter 过滤非true的元素
      * flatten 将列表的列表转化为列表
      * parttion 将列表根据true/false 的结果分为由两个List构成的元组 Set(List(),List())
      * reverse 逆置列表
      * slice 返回列表的一部分，索引前闭后开
      * sortBy() 按给定的函数的返回值对列表排序
      * sorted 按自然值排序
      * splitAt 根据指定的索引将列表分为两个列表组成的元组
      * take 返回列表前n个元素 takeRight 返回末尾n个元素
      * zip 将两个列表合并为元素为元组的列表
      */
    val newnumbersCons0 = List(5, 6, 7) ::: numbersCons
    val newnumbersCons1 = numbersCons ++ Set(5, 2, 3)
    println(newnumbersCons1.distinct)
    println(newnumbersCons1.toSet)
    println(newnumbersCons1.splitAt(2))
    println(newnumbersCons1.reverse)
    println(colors.sortBy(_.size))
    println(colors.sorted)
    println(colors.zip(Range(0,colors.size)))
    println(newnumbersCons1.slice(1,3))
    println(newnumbersCons1.filter(_%2==0))
    println(newnumbersCons1.drop(2))
    println(newnumbersCons1.take(3))
    println(newnumbersCons1:+8)

    /**
      * 列表映射操作
      * collect使用一个偏函数转换各个元素，保留可以应用的元素
      * flatMap 使用一个给定的函数进行转换各个元素，将结果扁平化到这个列表中
      * map 使用给定的函数进行转换各个元素
      */
    println(colors.collect{case "red"=> " i love the color"})
    println(List("zen.wan","xiao.hua").flatMap(_.split('.')))
    println(List("zen.wan","xiao.hua").map(_.toUpperCase))

    /**
      * 规约列表:把列表收缩为1个值
      * 常见操作：求极值，求和，求均值，是否包含某个特定元素等
      * 一、常见数学规约操作
      * max 求最大值
      * min 求最小值
      * product 求累乘
      * sum 求和
      */
    val sumList0:Int = numbers.sum
    val maxList0:Int = numbers.max
    val minList0:Int = numbers.min
    val proList0:Int = numbers.product
    println(sumList0,maxList0,minList0,proList0)

    /**
      * 二、布尔规约操作
      * contains 检查是否包含某个特殊元素
      * endsWith 检查列表是否以给定的列表结尾
      * exists 检查列表中是否至少存在一个元素满足条件
      * forall 检查列表中所有的元素是否都满足条件
      * startsWith 检查列表中是否以一个特定的列表开头
      */
    println(colors.contains("red"),colors.endsWith("red"),colors.exists(_.size>4),colors.forall(_.size>3))
    println(List(4,5,6).scan(0)(_+_))

    /**
      * 转换集合：从一个集合转换为另外一个集合
      * mkString 用指定分割符号连接所有元素,返回字符串
      * toBuffer 将不可变集合转化为可变集合
      * toList 将一个集合转化为List
      * toSet 将一个集合转化为Set
      * toMap 将一个集合转化为Map
      * toString 转化为String 类型
      */
    println(colors.mkString("|")) //getClass.getSimpleName 获取类型
    println(colors.toString)
    println(colors.toBuffer)
    println(numbers.toSet)
    println(colors.zip(Range(0,colors.size)).toMap)
    println(colors.zip(Range(0,colors.size)).toMap.keys) //获取Map的keys
    println(colors.zip(Range(0,colors.size)).toMap.values) //获取Map的values
    println(colors.toString)

    /**
      * 集合的模式匹配
      */
    val status:List[Int] = List(404,500)
    val msg0:String = status.head match{
      case x if (x<500) => "okay"
      case _ => "whoah,an error"
    }
    println(msg0)

    val msg1:String = status match{
      case List(404,500) => "NOT Found& ERROR"
      case List(500,404) => "Error & Not Found"
      case List(200,200) => "Okay"
      case _ => "Not Sure what Happened"
    }
    println(msg1)

    val info = ("zenwan",24,true) match {
      case (_,_,false) => "NOT SHANGHAI"
      case ("xiaohua",_,true) => "AGE IS NULL"
      case ("zenwan",_,true) => "zenwan'age is 24"
    }
    println(info)
  }
}