# Java8

> Java8的一些知识点

笔记知识来源：[宋红康老师的Java8视频](【2019-尚硅谷-宋红康系列-Java8新特性】 https://www.bilibili.com/video/BV18J411x7XS?share_source=copy_web&vd_source=e4d2dda1a0a113dcff0b77095733b76e)（共29个视频）

学习时间：2022/9/29 - 2022/10/01（共3天）



学习思维：

- 逆向思维、反证法（某特性、某设计是为什么要存在）

## 一、Java8总览

1. 函数式接口
2. Lambda表达式
3. 方法引用/构造器引用
4. Stream API
   - 并行流
   - 串行流
5. 接口的增强
   - 静态方法
   - 默认方法
6. Optional类
7. 新的时间和日期API
8. 其他新特性
   - 重复注解
   - 类型注解
   - 通用目标类型推断
   - JDK的更新
     - 集合的流式操作
     - 并发
     - Arrays
     - Number和Math
     - IO/NIO的改进
     - Reflection获取形参名
     - String：join()
     - Files
   - 新编译工具：jjs、jdeps
   - JVM中Metaspace取代PermGen空间（替代永久代）



### 1、Java8简介

- 是2014年发布的，是自Java5发布以来最具革命性的版本。

- 速度更快（hashmap底层的红黑树）
- 代码更少（lambda语法）
- 强大的stream API
- 便于并行
- 最大化减少空指针异常：Optional
- Nashorm引擎， 允许在JVM上运行JS应用（jjs 可以直接运行js程序）



## 二、Lambda表达式

> 属于编程的新语法规则

### 1、为什么使用Lambda表达式

Lambda是一个匿名函数，可以理解为是一段可以传递的代码（将代码像数据一样进行传递）。

```java
	@Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare1 = com1.compare(12,21);
        System.out.println(compare1);
        System.out.println("******************************");
        // Lambda表达式的写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1,o2);
        int compare2 = com2.compare(12,21);
        System.out.println(compare2);

        System.out.println("******************************");
        // 方法引用
        Comparator<Integer> com3 = Integer :: compare;
        int compare3 = com2.compare(12,21);
        System.out.println(compare3);
    }
```

首先要会看得懂，在源码中会大量使用；

### 2、Lambda表达式的使用

详细见本地代码项目中test测试类目录底下的LambdaTest和LambdaTest1。



## 三、函数式（Functional）接口

> Lambda使用的要求是需要接口只能有一个抽象方法，可以参考runnable接口。

### 1、什么是函数式接口

- 只包含一个抽象方法的接口，称为函数式接口。
- 可以通过Lambda表达式来创建该接口的对象。
- 我们可以在一个接口上使用**@FunctionInterface**注解，这样做可以检查它是否是一个函数式接口。同时javadoc也会包含一条声明，说明这个接口是一个函数式接口。
- **在java.util.function包下定义了Java8的丰富的函数式接口**

![image-20220929234437187](.\images\Java8函数式接口1)

### 2、如何理解函数式接口

- Java不但可以支持OOP还可以支持OOF（面向函数编程）
- Java中lambda表达式是对象，而不是函数，必须依附于一类特别的对象类型——函数式接口
- 在Java8中，lambda表达式就是一个函数式接口的实例。
- 所以以前用匿名实现类表示的现在都可以用lambda表达式来写。

### 3、Java内置四大核心函数式接口

| 函数式接口                    | 参数类型 | 返回类型 | 用途                                                         |
| ----------------------------- | -------- | -------- | ------------------------------------------------------------ |
| Consumer<T><br />消费型接口   | T        | void     | 对类型为T的对象应用操作，包含方法、void accept(T t)          |
| Supplier<T><br />供给型接口   | 无       | T        | 返回类型为T的对象，包含方法：T get()                         |
| Function<T,R><br />函数式接口 | T        | R        | 对类型为T的对象应用操作，并返回结果，结果是R类型的对象。包含方法：R apply(T t) |
| Predicate<T><br />断定型接口  | T        | boolean  | 确定类型为T的对象是否满足某约束，并返回boolean值。包含方法：boolean test(T t) |

---



## 四、方法引用与构造器引用

### 1、方法引用

- 当传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用；
- 方法引用可以看作是Lambda表达式深层次的表达，换句话说，方法引用就是Lambda表达式，也就是函数式接口的一个实例，通过方法的名字来指向一个方法，可以认为是Lambda表达式的一个语法糖
- 要求：实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的方法的参数列表和返回值类型保持一致！
- 格式：使用操作符`::`将类（或对象）与方法名分割开来
- 如下三种主要使用情况：
  - 对象::实例方法名
  - 类::静态方法名
  - 类::实例方法名



11集



