/**
 * @author mid2098
 * @version 1.0
 * @description: 直接使用Thread类
 * @date 2024/5/7 13:58
 */
public class MyAnonymousInnerClass {
    public static void main(String[] args) {
        // 匿名内部类
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread is running...");
//            }
//        });
        // Lambda表达式
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running...");
        });
        thread.start();
    }
}
