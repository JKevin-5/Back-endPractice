package org.example.java5;

public interface interfaceTest {
    static void print(){
        System.out.println("Test");
    }

    default void defaultMethod(){
        System.out.println("default");
    }
}
