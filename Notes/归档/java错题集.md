> 牛客上做的基础练习题目重点的和错题都可以进行收集。

1. 链接：https://www.nowcoder.com/questionTerminal/7e0efd0f3a1c447aa0823c8f27e05eeb
   来源：牛客网

   观察下列代码，分析结果()   

   ```java
   String s1 = "coder";     
   String s2 = "coder";     
   String s3 = "coder" + s2;     
   String s4 = "coder" + "coder";     
   String s5 = s1 + s2;            
   System.out.println(s3 == s4); 
   System.out.println(s3 == s5);    
   System.out.println(s4 == "codercoder");
   ```

   - ```
     false；false； true；
     ```

   - ```
     false；true； true；
     ```

   - ```
     false；false； false；
     ```

   - ```
     true；false； true；
     ```

​	解析：

​	s1，s2,s4,s5都是保存在字符串常量池中的对象，s3是新创建的对象，在堆中。

2. 下面哪个Set类是按元素排好序的？

   - ```
     LinkedHashSet
     ```

   - ```
     TreeSet
     ```

   - ```
     HashSet
     ```

   - ```
     AbstractSet
     ```

​	解析：TreeSet使用二叉树对元素进行排序。

3. 链接：https://www.nowcoder.com/questionTerminal/9dfb7470f3014166947cba07a69133c3
   来源：牛客网

   

   下面代码运行结果是？ 

   ```java
   public class Test{
   static{
      int x=5;
   }
   static int x,y;
   public static void main(String args[]){
      x--;
      myMethod( );
      System.out.println(x+y+ ++x);
   }
   public static void myMethod( ){
     y=x++ + ++x;
    }
   }
   ```

   - ```
     compiletime error
     ```

   - ```
     prints:1
     ```

   - ```
     prints:2
     ```

   - ```
     prints:3
     ```

   - ```
     prints:7
     ```

   - ```
     prints:8
     ```

​	解析：D 

	1. 静态语句块中x为局部变量，不影响静态变量x的值 
	1. x和y为静态变量，默认初始值为0，属于当前类，其值得改变会影响整个类运行。 
	1. java中自增操作非原子性的 

  main方法中：

- 执行x--后 x=-1    

- 调用myMethod方法，x执行x++结果为-1(后++)，但x=0，++x结果1，x=1 ，则y=0    
- x+y+ ++x,先执行x+y，结果为1，执行++x结果为2，得到最终结果为3





