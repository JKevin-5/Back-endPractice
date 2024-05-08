/**
 * @author mid2098
 * @version 1.0
 * @description: TODO
 * @date 2024/5/7 13:47
 */
public class MyThread extends Thread{
    public void run(){
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
