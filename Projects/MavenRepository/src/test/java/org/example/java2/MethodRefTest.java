package org.example.java2;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Locale;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * 1. 使用情景：当要传递给lambda体的操作，已经有实现的方法了，可以使用方法引用！
 * 2. 方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例，所以方法引用，也是函数式接口的实例
 * 3. 使用格式：类（或对象）:: 方法名
 * 4. 具体分为如下的三种情景
 *  对象::非静态方法
 *  类:: 静态方法
 *  类:: 非静态方法
 *  5. 方法引用的使用要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回类型相同！（适用于情况1和2）
 * @author Jkevin
 * @date 2022年09月30日 0:24
 */
public class MethodRefTest {

    // consumer中的void accept(T t)
    // printStream中的void println(T t)
    @Test
    public void test1(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("BeiJing");
        System.out.println("*****************");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("con2");
    }

    // Supplier中的T get()
    // Employee中的String getName()
    @Test
    public void test2(){
        Employee employee = new Employee("张三",18);

        Supplier<String> sup1 = () -> employee.getName();
        System.out.println(sup1.get());

        System.out.println("****************************");
        Supplier<String> sup2 = employee::getName;
        System.out.println(sup2.get());
    }

    // 情况二： 类：：静态方法
    // Comparator中的int compare(T t1,T t2)
    // Integer中的int compare(T t1,T t2)
    @Test
    public void test3(){
        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);

        System.out.println(com1.compare(12,21));
        System.out.println("****************************");
        Comparator<Integer> com2 = Integer::compare;// 形参列表一致
        System.out.println(com2.compare(21,12));
    }

    // Function中的R apply(T t)
    // Math中的Long round（Double d)
    @Test
    public void test4(){
        Function<Double, Long> func = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println("****************************");

        Function<Double,Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(12.3));

        System.out.println("****************************");

        Function<Double,Long> func2 = Math::round;
        System.out.println(func2.apply(12.6));
    }

    // 情况三：类：：实例方法（有难度）
    // Comparator 中的int compare(T t1,T t2)
    // String中的int t1.compareTo(t2)
    @Test
    public void test5(){
        Comparator<String> com1 = (s1,s2)-> s1.compareTo(s2);
        System.out.println(com1.compare("abc","abd"));

        System.out.println("****************************");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abd","abm"));
    }

    // Bipredice中的boolean test(T t1,T t2)
    // String中的boolean t1.equals(t2)
    @Test
    public void test6(){
        BiPredicate<String,String> pre1 = (s1,s2) -> s1.equals(s2);
        System.out.println(pre1.test("as","ass"));

        System.out.println("****************************");

        BiPredicate<String,String> pre2 = String :: equals;
        System.out.println(pre2.test("ass","ass"));
    }

    // Function中的R apply(T,t)
    // Employee中的String getName();
    @Test
    public void test7(){
        Employee employee = new Employee("张三",18);
        Function<Employee,String> func1 = e -> e.getName();
        System.out.println(func1.apply(employee));

        System.out.println("****************************");

        Function<Employee,String> func2 = Employee::getName;
        System.out.println(func2.apply(employee));
    }
}
