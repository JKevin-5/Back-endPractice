# Menu
1. JVM虚拟机（内存管理、分配、调度）
2. 多线程
3. java集合类型（list、map
4. jdk源代码解析


# 多线程

# java集合类型
参考廖雪峰[博文](https://www.liaoxuefeng.com/wiki/1252599548343744/1265109905179456)
- java标准库`java.util`中`Collection`是除`Map`之外所有其他集合类的**根接口**；
- List、Set、Map
- Java访问集合统一使用迭代器Iterator

Java为什么需要集合类？<br>
1. 数组初始化大小后不可变；
2. 数组只能按索引顺序存取。

Java集合设计的两个特点：<br>
1. 实现了接口与实现类相分离，例如`List`接口类与`ArrayList`实现类;
2. 支持泛型，可以限制在一个集合中只能放入同一种数据类型的元素;
    ```java
    List<String> list = new ArrayList<>(); // 只能放入String类型
    ```

Java遗留集合类【了解】
- Hashtable：一种线程安全的Map实现；
- Vector：一种线程安全的List实现；
- Stack：基于Vector实现的LIFO的栈。