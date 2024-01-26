# 如何运行最简单的java单文件
前提：java编译器将java编译为class文件，也就是字节码；然后将字节码交给虚拟机解释执行。
> 网上大神们大多认同java是一门“半编译 半解释执行”的语言。

参考廖雪峰老师的博文[第一个java程序](https://www.liaoxuefeng.com/wiki/1252599548343744/1255878730977024)。

HelloWorld.java
```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
```

传统执行方式：
```bash
# 第一步 javac编译器 编译 java文件 => class文件
javac HelloWorld.java
# 第二步 虚拟机执行class文件
java HelloWorld
``` 

jdk11新增执行方式（没有依赖其他库的情况）
```shell
java HelloWorld.java
```

## 要点
1. 只能定义一个public的class，并且名称要和文件名完全一致；
2. javac可以将java文件编译为class文件；
3. java可以直接执行一个java编译后文件（class），参数是类名。