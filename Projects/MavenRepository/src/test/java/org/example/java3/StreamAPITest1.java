package org.example.java3;

import org.example.java2.Employee;
import org.example.java2.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @Description 测试StreamAPI的实例化
 * @Author JKevin
 * @Date 2022年10月04日 下午3:40
 * @Version 1.0
 **/
public class StreamAPITest1 {

    //1-筛选与切片
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployeeData();
        // filter 筛选，流中排除某些元素
        Stream<Employee> stream = employees.stream();
        stream.filter(e -> e.getYear()>5).forEach(System.out::println);
        System.out.println();
        // limit 截断流
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println();
        // skip 跳过，返回一个丢掉前n个元素的流
        employees.stream().skip(10).forEach(System.out::println);
        System.out.println();
        // distinct 筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        employees.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2(){
        List<String> list = Arrays.asList("aa", "bb", "cc","dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        List<Employee> employeeList = EmployeeData.getEmployeeData();
        Stream<String> namesStream = employeeList.stream().map(Employee::getName);
        namesStream.filter(name -> name.length()>2).forEach(System.out::println);

        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });

        System.out.println();
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    // 将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3(){
        ArrayList list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

//        list1.add(list2);
        list1.addAll(list2);
        System.out.println(list1);
    }

    // 3-排序
    @Test
    public void test4(){
        List<Integer> list = Arrays.asList(12, 43, 52, 322, 0, -1);
        list.stream().sorted().forEach(System.out::println);

        // 抛出异常，原因：Employee没有实现compare接口
        List<Employee> employees = EmployeeData.getEmployeeData();
        employees.stream().sorted((e1,e2)->Integer.compare(e1.getYear(),e2.getYear())).forEach(System.out::println);
    }
}
