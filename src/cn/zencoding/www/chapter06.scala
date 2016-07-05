package cn.zencoding.www

/**
  * Created by zen on 2016/7/4.
  */
/**
  * ����(collections)����ṩ��һЩ���ݽṹ���ռ��������͵�һ�����߶��ֵ�������飬�б�ӳ�䣬������;
  * ���Ϻ������ļ������ṩ��foreach(),map()��reduce()�ȸ߽׺���;
  */
object chapter06 {
  def main(args: Array[String]) {
    /**
      * List����:���ɱ�ĵ����� ���Ͷ��� List[type]
      * List ��head,tail�Լ��߽׺�������
      * List �ı���
      */
    val numbers: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val numbersList: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6))
    val listTuple: List[(String, Int)] = List(("zenwan", 177), ("xiaohua", 139)) //List��Ԫ����Ԫ��
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
    }) //���������� (����0:����0,����1:����1����)=> {���ʽ}
    //val sumList:Int = numbers.reduce((a:Int,b:Int)=>a+b)
    //val newList:List[Int] = numbers.map(_+1)
    val sumList: Int = numbers.reduce(_ + _) //ռλ��
    val evenList: List[Int] = numbers.filter((x: Int) => x % 2 == 0) //���˺��� filter
    colors.foreach(println(_)) //foreach()ȡһ������(��׼ȷ��˵�ǹ��̣���������ΪUnit)
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
      * Set ��һ�����ɱ�����򼯺ϣ�ֻ�������ظ���ΨһԪ�أ�Set��List�������ƣ�֧��ͬ���Ĳ���
      */
    val unique: Set[Int] = Set(1, 2, 3, 4, 5, 4, 5, 5, 5, 0, 6, 7, 8, 9)
    println(s"unique:$unique")
    println("numbers2set:" + numbers.toSet) //List ת Set

    /**
      * Map ��һ�����ɱ�ļ�ֵ�Կ⣬���������п��ܻ��Ϊɢ�й�ϣ�����ֵ�ȡ���Map�У�ֵ��һ��������Ψһ���洢
      * ����Mapʱ��ָ����-ֵ��ΪԪ�棬����ʹ�ù�ϵ������(->)��ָ����ֵ��Ԫ�顣
      */
    val telphoneMap: Map[String, Long] = Map("zhangsan" -> 18218188678L, "zenwan" -> 17717876285L, "xiaohua" -> 13966711657L)
    println(s"telphoneMap:$telphoneMap")
    println(s"telphoneMap[zenwan]:" + telphoneMap("zenwan"))
    println(telphoneMap.contains("xiaohua"))

    /**
      * Cons �����������б�
      * ʹ��Nil��Ϊ��������ʹ���ҽ�ϵ�cons������::��Ԫ�أ��Ϳ��Թ���һ���б�������ʹ�ô�ͳ��List()��ʽ
      */
    val numbersCons = 1 :: 2 :: 3 :: 4 :: 5 :: Nil //�ҽ�ϲ���
    println(s"numbersCons:${numbersCons}")
    println(5 :: numbersCons)
    /**
      * �б���޸ľ���Ҫ����һ���µ��б���ΪList ��һ�����ɱ�ļ���
      * :: Ϊ�б�ͷ׷�ӵ����µ�Ԫ��(�ҽ��) :+�б�ĩβ׷��Ԫ��(����)
      * :::���б�ǰ��׷����һ���б�
      * ++ Ϊ�б�׷����һ������
      * distinct ���ز������ظ�Ԫ�ص��б�
      * drop ���б���ɾ��ǰn��Ԫ��
      * filter ���˷�true��Ԫ��
      * flatten ���б���б�ת��Ϊ�б�
      * parttion ���б����true/false �Ľ����Ϊ������List���ɵ�Ԫ�� Set(List(),List())
      * reverse �����б�
      * slice �����б��һ���֣�����ǰ�պ�
      * sortBy() �������ĺ����ķ���ֵ���б�����
      * sorted ����Ȼֵ����
      * splitAt ����ָ�����������б��Ϊ�����б���ɵ�Ԫ��
      * take �����б�ǰn��Ԫ�� takeRight ����ĩβn��Ԫ��
      * zip �������б�ϲ�ΪԪ��ΪԪ����б�
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
      * �б�ӳ�����
      * collectʹ��һ��ƫ����ת������Ԫ�أ���������Ӧ�õ�Ԫ��
      * flatMap ʹ��һ�������ĺ�������ת������Ԫ�أ��������ƽ��������б���
      * map ʹ�ø����ĺ�������ת������Ԫ��
      */
    println(colors.collect{case "red"=> " i love the color"})
    println(List("zen.wan","xiao.hua").flatMap(_.split('.')))
    println(List("zen.wan","xiao.hua").map(_.toUpperCase))

    /**
      * ��Լ�б�:���б�����Ϊ1��ֵ
      * ������������ֵ����ͣ����ֵ���Ƿ����ĳ���ض�Ԫ�ص�
      * һ��������ѧ��Լ����
      * max �����ֵ
      * min ����Сֵ
      * product ���۳�
      * sum ���
      */
    val sumList0:Int = numbers.sum
    val maxList0:Int = numbers.max
    val minList0:Int = numbers.min
    val proList0:Int = numbers.product
    println(sumList0,maxList0,minList0,proList0)

    /**
      * ����������Լ����
      * contains ����Ƿ����ĳ������Ԫ��
      * endsWith ����б��Ƿ��Ը������б��β
      * exists ����б����Ƿ����ٴ���һ��Ԫ����������
      * forall ����б������е�Ԫ���Ƿ���������
      * startsWith ����б����Ƿ���һ���ض����б�ͷ
      */
    println(colors.contains("red"),colors.endsWith("red"),colors.exists(_.size>4),colors.forall(_.size>3))
    println(List(4,5,6).scan(0)(_+_))

    /**
      * ת�����ϣ���һ������ת��Ϊ����һ������
      * mkString ��ָ���ָ������������Ԫ��,�����ַ���
      * toBuffer �����ɱ伯��ת��Ϊ�ɱ伯��
      * toList ��һ������ת��ΪList
      * toSet ��һ������ת��ΪSet
      * toMap ��һ������ת��ΪMap
      * toString ת��ΪString ����
      */
    println(colors.mkString("|")) //getClass.getSimpleName ��ȡ����
    println(colors.toString)
    println(colors.toBuffer)
    println(numbers.toSet)
    println(colors.zip(Range(0,colors.size)).toMap)
    println(colors.zip(Range(0,colors.size)).toMap.keys) //��ȡMap��keys
    println(colors.zip(Range(0,colors.size)).toMap.values) //��ȡMap��values
    println(colors.toString)

    /**
      * ���ϵ�ģʽƥ��
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