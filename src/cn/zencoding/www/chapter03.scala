package cn.zencoding.www
/**
  * Created by zen on 2016/6/25.
  */
object chapter03 {
  def main(args: Array[String]) {
    /**
      * ����ʽʹ�ô�����{}��϶�����ʽ����һ������ʽ���������һ�����ʽΪ��������ʽ�ķ���ֵ
      * ���ʽҲ����Ƕ��
      */
    val amout = {val x:Int = 20
      val y:Int = 30
      x+y} //����ֵΪx+y
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
      * if ...else ���ʽ��
      */
    //if...else ���ʽ
    val num: Int = 5
    val num0 :Int = 2
    if (num%2 == 1) println(s"${num}������!") else println(s"${num} ��ż����")
    if (num==0) println("������") else if(num==1) println("�Ϻ���") else println("������")
    val max :Int = if (num>num0) num else num0

    //ƥ����ʽ
    val max0 = (num > num0) match {
      case true => num
      case false => num0
    }
    println(max,max0)

    val status:Int = 500
    val message = status match{
      case 200 => "ok"
      case 400 => { println("Error:we called service incorrectly!")
                    "Error" //���һ�����ʽ��ֵ����Ϊƥ����ʽ�ķ���ֵ
      }
      case 500 => {
        println("Error:the service encountered an error!")
        "Error" //���һ�����ʽ��ֵ��Ϊƥ����ʽ�ķ���ֵ
      }
    }
    println(message)
     //ģʽ�滻ʽ match �Ǳ��ʽ �������,�����з���ֵ
    /**
      * ͨ��ģʽƥ����� ֵ���case other ��ͨ���ģʽ case _
      * ģʽ��λ��case pattern if <boolean expression> => <one or more expression>
      */
    val day:String = "mon"
    val kind :String = day match{
      case "mon"|"tue"|"wed"|"thu"|"fri" => "workday"
      case "sta"|"sun"=>"weekday"
      case other if other != null =>s"can't parse ${other}" //case other ģʽ�ܹ�����ʣ������ ����case _ Ҳ����
    }
    println(kind)

    /***
      * for ѭ���﷨��for��<indentifier> <- <iterator>�� [yield] [<expression>]
      * yield�ؼ��ְѵ������ת��Ϊһ�����ʽ�����ʽ���з���ֵ�ģ�����ֵ�Ǽ��ϵ���
      */
    for {x <- 1 to 10} {println(s"day:${x}")} //ѭ�����ʽ��ʵ�Ǹ���䣬û�з���ֵ����Ϊû��yield�ؼ���
    val days = for {x <- Range(1,10,2)} yield{s"day:${x}"} //yield�ؼ��ְѵ������ת��Ϊһ�����ʽ�����ʽ���з���ֵ��
    val thress = for (x <- 1 to 100 by 3 if x % 2 ==0 ) yield x //Ϊ����������һ��if Ҳ��Ϊ��������filter��
    println(days)
    val line:String = "China has reaffirmed that its construction work in the South China Sea is lawful and reasonable"
    //println(line.split(" ").toList)
    val words= for {word <- line.split(" ") if word.size > 3} yield word //split����python�е�split
    println(words.toList)

    //Ƕ��ѭ��
    val tuples = for {x <- 1 to 3
         y<- 1 until 5 by 2}
      yield (x,y)
    println(tuples)

    //ѭ��ֵ��
    /**
      * �﷨��for ѭ���е�ֵ��
      * for (indentifier <- iterator ; identifier = expression)
      */
    val powOf2 = for (i <- 1 until 10 ; pow = 1 << i) yield (i,pow)
      println(powOf2)

  }
}
