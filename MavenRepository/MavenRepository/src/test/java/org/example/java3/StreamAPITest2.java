package org.example.java3;

import org.example.java2.Employee;
import org.example.java2.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @Description 测试StreamAPI的实例化
 * @Author JKevin
 * @Date 2022年10月04日 下午3:40
 * @Version 1.0
 **/
public class StreamAPITest2 {

    //1-匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployeeData();

        // 检查是否匹配所有元素
        boolean b = employees.stream().allMatch(employee -> employee.getYear() > 6);
        System.out.println(b);

        // 检查是否没有匹配的元素
        boolean noneMatch = employees.stream().noneMatch(employee -> employee.getYear() > 60);
        System.out.println(noneMatch);

        // 返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        // 返回任意一个元素
//        Optional<Employee> any = employees.stream().findAny();
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);

    }

    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployeeData();
        // 求个数
        long count = employees.stream().count();
        System.out.println(count);
        // 求最大值
        Stream<Integer> stream = employees.stream().map(Employee::getYear);
        Optional<Integer> max = stream.max(Integer::compareTo);
        System.out.println(max);
        // 求最小值
        Stream<Integer> stream1 = employees.stream().map(Employee::getYear);
        Optional<Integer> min = stream1.min(Integer::compareTo);
        System.out.println(min);
    }

    //2-归约
    @Test
    public void test3(){
        // 计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // identity 是初始值，后一个是bifunction 用来处理参数，T T T 三个数值，最后称为一个T
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        // 计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployeeData();
        Stream<Integer> yearStream = employees.stream().map(Employee::getYear);
//        Optional<Integer> sumOptional = yearStream.reduce(Integer::sum);
        Optional<Integer> sumOptional = yearStream.reduce((d1,d2) -> d1+d2);
        System.out.println(sumOptional);


    }

    // 3-收集
    @Test
    public void test4(){
        // 查找一个工资大于6000的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployeeData();
        List<Employee> collect = employees.stream().filter(e -> e.getYear() > 5).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println();

        Set<Employee> collect1 = employees.stream().filter(e -> e.getYear() > 5).collect(Collectors.toSet());
        collect1.forEach(System.out::println);
    }
}
