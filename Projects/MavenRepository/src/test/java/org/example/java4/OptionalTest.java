package org.example.java4;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @Description TODO
 * @Author JKevin
 * @Date 2022年10月06日 下午11:34
 * @Version 1.0
 **/
public class OptionalTest {

    /**
     * Optional.of(T t)：创建一个Optional 实例，t必须非空
     * Optional.empty()：创建一个空的Optional 实例
     * Optional.ofNullable(T t)：t可以为null
     * @author JKevin
     * @date 2022/10/6 下午11:36
     */
    @Test
    public void test1(){
        Girl girl = new Girl();
        girl = null;
        //of(T t):保证t是非空的
        Optional<Girl> optionalGirl = Optional.of(girl);
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;
        // ofNullable(T t): t可以是null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        // orElse(T t)：如果当前的Optional内部封装的t是非空的，则返回内部t
        // 如果内部的t是空的，则返回orElse方法中的参数t1
        Girl girl1 = optionalGirl.orElse(new Girl("medus"));
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    public String getGirlName1(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("Medus1")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("Medus2"));
        return girl1.getName();
    }

    @Test
    public void test3(){
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    @Test
    public void test5(){
        Boy boy = null;
        boy = new Boy();
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }
}
