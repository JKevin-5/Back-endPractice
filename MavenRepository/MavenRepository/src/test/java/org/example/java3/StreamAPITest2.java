package org.example.java3;

import org.example.java2.Employee;
import org.example.java2.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

}
