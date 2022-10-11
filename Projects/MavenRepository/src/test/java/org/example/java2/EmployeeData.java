package org.example.java2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author JKevin
 * @Date 2022年10月07日 下午11:44
 * @Version 1.0
 **/
public class EmployeeData {

    public static List<Employee> getEmployeeData(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("刘一",1));
        list.add(new Employee("陈二",2));
        list.add(new Employee("张三",3));
        list.add(new Employee("李四",4));
        list.add(new Employee("王五",5));
        list.add(new Employee("赵六",6));
        list.add(new Employee("孙七",7));
        list.add(new Employee("周八",8));
        list.add(new Employee("吴九",9));
        list.add(new Employee("郑十",10));
        list.add(new Employee("郑十一",11));
        list.add(new Employee("郑十二",12));
        list.add(new Employee("郑十三",13));
        return list;
    }
}
