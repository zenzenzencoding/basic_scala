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
    //ռλ����λ��˳��
    val res:Int = combination(2,3,_*_)
    println(res)
    /**
      * ͨ���������ﻯʹ�ú���factorof �ĺ���������(Int,Int)=>Bolean ���(Int)=>Boolean��
      */
    val isEven:(Int)=>Boolean = factorof(2) _
    val z:Boolean = isEven(32)
    println(z)
    /**
      * �ú��������������ø߽׺���
      */
    //val uperString :String = uper("zenwan"){_.toString.toUpperCase}
    val upperString :String = upper("zenwan"){(s:String)=>s.toUpperCase}
    println(upperString)
  }

  /**
    * �������ͺͺ���ֵ(�������͵�ֵ�ͽк���ֵ)
    * �������������������ͺͷ���ֵ���͵ļ���ϣ���һ����ͷ����������ָ���������
    * �﷨��(type,����)=> type ���()��ʾ����û�в�������
    * ���� ����def double(x:Int):Int = x*2 �ĺ������;���Int => Int.���ʾ��һ��Int������������һ��Int��ֵ��
    */
  def double(x:Int):Int = {x*2}
  val myDouble:(Int)=>Int = double //myDouble ��һ������ֵ������һ���������ã����Ա�����ʾ����������

  /**
    * �߽׺������߽׺���Ҳ�Ǻ�����������һ���������͵�ֵ(����ֵ)��Ϊ����������߷���ֵ
    */
  def safeStringOp(s:String,f:String=>String):String = {
    if (s!=null) f(s)
    else s
  }
  def reverse(s:String):String = {s.reverse}

  /**
    * ����������(��������)
    * �������������Դ洢�ں���ֵ�ͱ�����
    * �﷨ (���������ͣ�����)=>{���ʽ}
    */
  //�ȿ�һ��������ֵ������
  def max(a:Int,b:Int):Int = if (a>b) a else b
  val maxmize:(Int,Int) => Int = max

  //�ٿ�����������(��������)
  val maxmizee:(Int,Int)=>Int = (a:Int,b:Int)=> if(a>b) a else b //val ����ֵ:�������� = ����������
  //val maxmizee = (a:Int,b:Int)=> if(a>b) a else b //�����Ƶ�
  /**
    * ռλ���﷨
    * ռλ���﷨�Ǻ�����������һ����д��ʽ�������������滻��ͨ���(_)
    */
  val double2 :Int => Int = _*2
  def combination(x:Int,y:Int,f:(Int,Int)=>Int)=f(x,y)

  /**
    * ����Ӧ�ú����ͺ���
    * ����ʹ�ö��������ĺ���������һ����ʹ�ò��������ּ�����Ϊ�������ﻯ
    */
  def factorof(x:Int)(y:Int):Boolean = y%x==0

  /**
    * ȫ����������f(x)û�в��ܴ���Ĳ���x
    * ƫ���������������������͵����п��ܵ�ֵ����һ�����������ķ�ĸΪ0���������޷������������ƫ����
    */
  val statusHandler:(Int)=>String = {
    case 200 => "OKAY"
    case 400 => "Your error"
    case 500 => "Our error"
    case other if other != null => "ʲô��"
  }
  /**
    * �ú���������(��������)�����ø߽׺���
    */
  def upper(s:String)(f:(String)=>String):String= {
    if (s!= null) f(s) else s
  }
}
