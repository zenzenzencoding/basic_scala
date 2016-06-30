package cn.zencoding.www

/**
  * Created by zen on 2016/6/27.
  */
object chapter04 {
  /**
    * ������һ���������õ��������ʽ���������Բ����������Է���һ��ֵ
    */
  def main(args: Array[String]) {
    println(multiplier(2,3))
    println(safeTrim("bbb"))
    println(hi())
    /**
      * ʹ�ñ��ʽ�������ú���
      * ʹ��һ���������ú���ʱ�򣬿�������һ���ô������������ı��ʽ�������Ͳ���������С���ţ�functionName{param}
      * ������������һ������ֵʱ�򣬲����ȼ���һ��������������ھֲ�ֵ���ٴ��ݸ���������ȫ�����ڱ��ʽ������ɼ��㣬
      * ���ʽ����ڵ��ú���ǰ���㣬���ұ��ʽ���з���ֵ������Ϊ��������Ĳ���
      */
    println(formatEuro{val rate = 1.32; 0.235+0.7123+rate*5.32})
    println(power(2,3))//�ݹ麯��
    println(powerTailrec(2,3,1))
    println(max(3,2,5))
    println(greet("hello"))
    println(greet(name="zenzen",prefix="hello"))
    println(identity("hello"))
    println(identity(123))

  }
  def multiplier(x:Int,y:Int):Int={
    x*y} //���һ���Ǳ��ʽ�ķ���ֵ Ҳ������ʾ��ʹ��return ��ǰ�˳�����

  def safeTrim(s:String):String = {
    if(s=="aaa") return s+"bbbb"
    else {s+"ccc"}//ȥ���������߿ո�
  }

  /**
    * ������û�з���ֵ�ĺ�������һ������β�ĺ���Ҳ��һ������
    * ���һ������û����ʾ��ָ���������ͣ��������һ������䣬Scala���������Ƶ�����������ķ�������ΪUnit
    * @param d:double
    */
  def log(d:Double):Unit = {print(s"got a value :${d}")}

  /**
    * Ҫ����͵���һ���޲εĺ���������ʹ�ÿ����ţ���,���õ�ʱ��Ҳ���Բ��п�����,���������ʱ����û�м�С���ţ����õ�ʱ��Ҳ�ǲ��ܼ�С���ŵ�
    */
  def hi():String = "hi"

  def formatEuro(amt:Double):String = f"$amt%.2f"

  /**
    * �ݹ麯������������������,ÿ�����������Լ���ջ���洢�����Ĳ���
    * ������β�ݹ飨tail-recursion)���Ż��ݹ麯����ʹ�ĵݹ鲻��ʹ�ö����ջ�ռ䣬���ᴴ���µ�ջ�ռ䣬����ʹ�õ�ǰ������ջ�ռ�
    * ע�⣺ֻ�����һ������ǵݹ���õĺ���������ɵݹ��Ż�
    */
  def power(x:Int,n:Int):Int= {
    if (n==0) 1
    else {x*power(x,n-1)}
  }
  //�Ż��ĵݹ麯��
  @annotation.tailrec
  def powerTailrec(x:Int,n:Int,res:Int=1):Long={
    if (n==0) res
    else {powerTailrec(x,n-1,x*res)}
  }

  /**
    * �����������Ĳ������ı��ʽ�飬�����ʽ�ǿ���Ƕ�׵ģ����Ժ�������Ҳ�ǿ���Ƕ�׵�
    * ĳЩ����£���Ҫ��һ���������ظ�ĳ���߼�����ʮ������Ϊһ���ⲿ������û��̫������壬��������¾Ϳ����ں����ж�������һ���ڲ�����
    * �ڲ�����ֻ���ڸú�����ʹ�á�
    */
  def max(a:Int,b:Int,c:Int):Int = {
    def max(a:Int,b:Int):Int = {if (a>b) a else b}
    max(a,max(b,c))
  }
  def greet(prefix:String,name:String="zenwan"):String = {s"$prefix,$name"}
  //�ɱ䳤�Ȳ���
  def sum(items:Int*):Int = {
    var total = 0
    for (item <- items) {total+=item}
    return total
  }

  /**
    * ���庯�������Ͳ��� def function-name[type-name](param:type-name):type-name= {}
    * �����Ĳ������߷���ֵ���Ͳ��̶��������Ѻ����������Լ�����
    * @param a
    * @tparam A
    * @return
    */
  def identity[A](a:A):A = a

}
