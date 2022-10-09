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

![image-20220929234437187](.\images\Java8函数式接口1.jpg)

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



### 2、构造器引用（第十集）





## 五、StreamAPI

### 1、概念

- Java8中有两个最重要的改变：一个Lambda表达式，一个是StreamAPI。
- StreamAPI把真正的函数式编程风格引入Java中
- Stream是Java8中处理集合的关键抽象概念。使用StreamAPI对集合数据进行操作，就类似于使用sql执行的数据库查询。

### 2、为什么要用

- 实际开发中有太多数据来自mysql等关系型数据库，但是现在数据源更多了，类似MongDB、redis等非关系性数据库（Nosql）数据，就需要在Java层面去处理
- Stream和Collection集合的区别：
  - Collection是一种静态的内存数据结构，而Stream是有关计算的。
  - 前者主要面向内存，存储在内存中，后者主要是面向CPU，通过CPU实现计算。

### 3、什么是Stream

Stream是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。

**注意点**

1. Stream自己不会存储元素。
2. Stream不回改变源对象，相反，会返回一个持有结果的新Stream。
3. Stream的操作是延迟执行的，这意味着他们会等到需要结果的时候才执行。

### 4、Stream的操作三个步骤

1. 创建Stream

2. 中间操作

3. 终止操作（终端操作）

   只有终止操作被执行，中间操作才会执行（延迟执行）

### 5、Stream的中间操作——筛选与切片

| 方法                | 描述                                                         |
| ------------------- | ------------------------------------------------------------ |
| filter(Predicate p) | 接收Lambda，从流中排出某些元素                               |
| distinct()          | 筛选，通过流所生成元素的hashCode()和equals()去除重复元素     |
| limit(long maxSize) | 截断流，使其元素不超过给定数量                               |
| skip(long n)        | 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，<br />则返回一个空流。与limit(n)互补 |

### 6、Stream的中间操作——映射

| 方法                            | 描述                                                         |
| ------------------------------- | ------------------------------------------------------------ |
| map(Function f)                 | 接收一个函数作为参数，该函数会被应用到每个元素上，<br />并将其映射成一个新元素。 |
| mapToDouble(ToDoubleFunction f) | 接收一个函数作为参数，该函数会被应用到每个元素上，<br />产生一个新的DoubleStream。 |
| mapToInt(ToIntFunction f)       | 接收一个函数作为参数，该函数会被应用到每个元素上，<br />产生一个新的IntStream。 |
| mapToLong(ToIntFunction f)      | 接收一个函数作为参数，该函数会被应用到每个元素上，<br />产生一个新的LongStream。 |
| flatMap(Function f)             | 接收一个函数作为参数，将流中的每个值都换成另一个流，<br />然后把所有流连接成一个流。 |

### 7、Stream的中间操作——排序

| 方法                   | 描述                               |
| ---------------------- | ---------------------------------- |
| sorted()               | 产生一个新流，其中按自然顺序排序   |
| sorted(Comparator com) | 产生一个新流，其中按比较器顺序排序 |

### 8、Stream的终止操作——匹配与查找

- 终端操作会从流的流水线生产结果，其结果可以是任何不适流的值，例如：list、Integre、甚至void。
- 流进行了终止操作后，不能再次使用。  

| 方法                   | 描述                     |
| ---------------------- | ------------------------ |
| allMatch(Predicate p)  | 检查是否匹配所有元素     |
| anyMatch(Predicate p)  | 检查是否至少匹配一个元素 |
| noneMatch(Predicate p) | 检查是否没有匹配所有元素 |
| findFirst()            | 返回第一个元素           |
| findAny()              | 返回当前流中的任意元素   |
| count()                | 返回流中元素的总个数     |
| max(Comparator c)      | 返回流中最大值           |
| foreach()              | 内部迭代                 |

### 9、Stream的终止操作——规约

| 方法                            | 描述                                                    |
| ------------------------------- | ------------------------------------------------------- |
| reduce(T iden,BinaryOperator b) | 可以将流中元素反复结合起来，得到一个值。返回T。         |
| reduce(BinaryOperator b)        | 可以将流中元素反复结合起来，得到一个值。返回Optional<T> |

### 10、Stream的终止操作——收集

| 方法                 | 描述                                                         |
| -------------------- | ------------------------------------------------------------ |
| collect(Collector c) | 将流转换为其他方式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法。 |







## 六、Optional类

### 1、介绍

- 为了解决空指针异常的问题，google公司Guava引入Optional类，通过使用检查空值的方式来防止代码污染，受到启发后，Optional类已经成为Java8类库的一部分。
- Optional<T> 类(java.util.Optional)是一个容器类，它可以保存类型T的值，代表这个值存在。或者仅仅保存null，表示这个值不存在。原来用null表示一个值不存在，现在Optional可以更好的表达这个概念，并且可以避免空指针异常。
- Optionnal类的javadoc描述如下：这是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。

### 2、初始化

| 方法                     | 描述                                                         |
| ------------------------ | ------------------------------------------------------------ |
| Optional.of(T t)         | 创建一个Optional 实例，t必须非空                             |
| Optional.empty()         | 创建一个空的Optional 实例                                    |
| Optional.ofNullable(T t) | t可以为null                                                  |
| Optional.orElse(T t)     | 如果当前的Optional内部封装的t是非空的，则返回内部t<br />如果内部的t是空的，则返回orElse方法中的参数t1 |



```java
// orElse不一定只能放异常抛错，还可以返回一个默认的错误对象
Girl girl1 = girlOptional.orElse(new Girl("Medus2"));
```



## 七、接口的增强

Java8的接口可以定义一个默认方法和一个
