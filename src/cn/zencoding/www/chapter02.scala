package cn.zencoding.www

/**
  * Created by zen on 2016/6/24.
  */

//���� scala ���߰�
import scala.util.matching.Regex
object chapter02 {
  def  main(args: Array[String]) {
    //�÷������������Ŀ�����scala�ı�����
    //�������ſ��Դ��������ַ���
    val `zen.wan` =
      """the true
        |name is
        |zen.wan""".stripMargin
    println(`zen.wan`)

    //�ڲ��ַ��� ��һ��˫����ǰ��ǰ׺��s�� Ȼ��ʹ��${}�����ⲿ����
    val name : String = "zenwan"
    val birth : Int = 1991
    var school :String = null //��������ָ���ڴ����κ��ַ���ʵ��
    var line : String  = s"hello my name is ${name} and i was born in ${birth}!"
    println(line)

    //������ʽ
    val pattern0 = """.*\w++ ([\d]+).*""".r //�ַ���������.r �ȼ�������һ��
    //����r�������ַ���ת��Ϊ������ʽ���͡�����һ��Regex����
    val pattern1 = new Regex(""".*name is (\w+) and .*""")
    val pattern0(year) = line
    val pattern1(nicheng) = line
    println(year.toDouble,nicheng)  //to<type> ���Ͳ���

    //Ԫ����һ�������������߶��ֵ������������������Щֵ�����в�ͬ�����͡�
    //Ԫ���������1��ʼ
    val info1  = ("zenwan",25,true)
    println(info1._1)

    //����2ԪԪ�飬����ʹ�ù�ϵ������(->) ����python�� ����key-value����ʽ
    val info2 = "zenwan" -> "ecnu"
    val info3 = info2._2 -> info2._1 //��תkey-value
    print(info2,info3)

  }
}
