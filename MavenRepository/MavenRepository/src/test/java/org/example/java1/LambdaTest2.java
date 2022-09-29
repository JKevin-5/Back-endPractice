package org.example.java1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置的4大核心函数式接口
 * @author Jkevin
 * @date 2022年09月30日 0:01
 */
public class LambdaTest2 {

    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("Hello world!" + aDouble);
            }
        });

        System.out.println("*****************************");

        happyTime(400,money -> System.out.println("Hello world!"+ money));
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("1","2","3","4","5");
        List<String> filterString = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("1");
            }
        });
        System.out.println(filterString);

        // 需要对抽象方法有些了解
        List<String> filterString1 = filterString(list,s -> s.contains("1"));
        System.out.println(filterString1);
    }

    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();

        for(String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
