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





