package org.example.java1;

import com.beust.ah.A;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用<br/>
 *
 * 1.举例：(o1,o2) -> Integer.compare(o1,o2);<br/>
 * 2.格式：<br/>
 *      -> :lambda操作符 或 箭头操作符<br/>
 *      -> 左边： lambda形参列表（其实就是接口中的抽象方法的形参列表）<br/>
 *      -> 右边：lambda体（其实就是重写的抽象方法的方法体）<br/>
 * 3.Lambda表达式的使用：（分6种情况介绍）<br/>
 *      总结：<br/>
 *      -> 左边：lambda形参列表的参数类型可以省略（类型推断）；如果lambda形参列表只有一个参数，其一对()也可以省略<br/>
 *      -> 右边：lambda体应该使用一堆{}包裹；如果lambda体只有一条执行语句（可能是return语句），省略这一对{}和return<br/>
 * 4.Lambda表达式的本质：作为函数式接口的实例（实现类的对象）<br/>
 * 5.如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口<br/>
 *
 * @author Jkevin
 * @date 2022年09月29日 1:18
 */
public class LambdaTest1 {
    // 语法格式一：无参，无返回值
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("hello world!");
            }
        };
        r1.run();
        System.out.println("******************************");

        Runnable r2 = () -> {
            System.out.println("hello world!");
        };

        r2.run();
    }

    // 语法格式二：Lambda 需要一个参数，但是没有返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("hello world!");
        System.out.println("******************************");

        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("hello world!");
    }

    // 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test3(){
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("hello world!");
        System.out.println("******************************");
        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("hello world!");
    }

    @Test
    public void test4(){
        ArrayList<String> list = new ArrayList<>();// 类型推断
        int[] arr = {1,2,3};// 类型推断
    }

    // 语法类型四：Lambda 若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test5(){
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("hello world!");
        System.out.println("******************************");
        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("hello world!");
    }

    // 语法类型五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test6(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12,21));
        System.out.println("******************************");
        Comparator<Integer> com2 = (o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12,6));
    }

    // 语法类型六：当Lambda体只有一条语句时，return 与大括号若有，都可以省略
    @Test
    public void test7(){
        Comparator<Integer> com1 = (o1,o2)->{
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(12,6));

        System.out.println("******************************");

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(12,21));
    }

    @Test
    public void test8(){
        Consumer<String> con1 = s -> {
            System.out.println(s);
        };
        con1.accept("hello world!");
        System.out.println("******************************");
        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("hello world!");

    }
}
