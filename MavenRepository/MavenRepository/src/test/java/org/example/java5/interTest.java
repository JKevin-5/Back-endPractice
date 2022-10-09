package org.example.java5;

import org.junit.jupiter.api.Test;

/**
 * @author Jkevin
 * @date 2022年10月09日 18:33
 */
public class interTest implements interfaceTest{

    /**
     * 可以直接使用接口类中的静态方法
     * @author Jkevin
     * @date 2022/10/9 18:34
     */
    @Test
    public void test1(){
        // 静态方法 可以使用类、对象进行调用
        interfaceTest.print();
    }

    /**
     * 想要调用自己
     * @author Jkevin
     * @date 2022/10/9 18:43
     */
    public void defaultMethod1(){
        interfaceTest.super.defaultMethod();
    }

    /**
     * 实现
     * @author Jkevin
     * @date 2022/10/9 18:41
     */
    @Test
    public void test2(){
        this.defaultMethod1();
    }
}
