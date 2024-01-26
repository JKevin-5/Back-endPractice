package org.example.java3;

import org.example.java2.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 3. stream的初始化
 *  3.1 stream的实例化
 *  3.2 一系列中间操作（过滤、映射...）
 *  3.3 终止操作
 *
 * 4. 说明：
 * 4.1 一个中间操作链，对数据源的数据进行处理
 * 4.2 一旦执行终止操作，就执行中间操作链，并产生结果，之后，
 *
 * @Description 测试StreamAPI的实例化
 * @Author JKevin
 * @Date 2022年10月04日 下午3:40
 * @Version 1.0
 **/
public class StreamAPITest {

    //创建stream方法一：通过集合
    @Test
    public void test1(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("zhangsan",11));
        employeeList.add(new Employee("zhangsan",12));
        employeeList.add(new Employee("zhangsan",13));

        // default Stream<E> stream():返回一个顺序流
        Stream<Employee> stream = employeeList.stream();
        // default Stream<E> parallelStream(): 返回一个并行流
        // 并行的话不是按照顺序拿的数据，是同时去拿的，所以不保证顺序
        Stream<Employee> paralleStream = employeeList.parallelStream();
    }

    // 创建stream方法二：通过数组
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        // 调用Arrays类的static<T> Stream<T>() stream(T[] array); 返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee employee1 = new Employee("zhangsan",1001);
        Employee employee2 = new Employee("lisi",1002);
        Employee[] arr1 = new Employee[]{employee1,employee2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
     }

     // 创建Stream方法三：通过Stream的of()
     @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);

     }

     // 创建Stream方法四：创建无限流，用于造数据
    @Test
    public void test4(){
        // 迭代
        // 遍历前十个偶数
        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);

        // 生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
