# Menu
1. JVM虚拟机（内存管理、分配、调度）
2. 多线程
3. java集合类型（list、map
4. jdk源代码解析


# 多线程

1. 线程之间的通信
    - 使用同步锁
    ```java
    public class ObjectLock {
        private static Object lock = new Object();

        static class ThreadA implements Runnable {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 100; i++) {
                        System.out.println("Thread A " + i);
                    }
                }
            }
        }

        static class ThreadB implements Runnable {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 100; i++) {
                        System.out.println("Thread B " + i);
                    }
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            new Thread(new ThreadA()).start();
            Thread.sleep(10);
            new Thread(new ThreadB()).start();
        }
    }
    ```
    - 等待通知机制
    ```java
    public class WaitAndNotify {
        private static Object lock = new Object();

        static class ThreadA implements Runnable {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        try {
                            System.out.println("ThreadA: " + i);
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notify();
                }
            }
        }

        static class ThreadB implements Runnable {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        try {
                            System.out.println("ThreadB: " + i);
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notify();
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            new Thread(new ThreadA()).start();
            Thread.sleep(1000);
            new Thread(new ThreadB()).start();
        }
    }

    // 输出：
    ThreadA: 0
    ThreadB: 0
    ThreadA: 1
    ThreadB: 1
    ThreadA: 2
    ThreadB: 2
    ThreadA: 3
    ThreadB: 3
    ThreadA: 4
    ThreadB: 4
    ```
    - 信号量
    ```java

    ```
    - 管道
2. 如何创建多线程
    - Thread类和Runnable接口
    - Callable、Future与FutureTask

# java集合类型
参考廖雪峰[博文](https://www.liaoxuefeng.com/wiki/1252599548343744/1265109905179456)
- java标准库`java.util`中`Collection`是除`Map`之外所有其他集合类的**根接口**；
- List、Set、Map
- Java访问集合统一使用迭代器Iterator

Java为什么需要集合类？<br>
1. 数组初始化大小后不可变；
2. 数组只能按索引顺序存取。

Java集合设计的两个特点：<br>
1. 实现了接口与实现类相分离，例如`List`接口类与`ArrayList`实现类;
2. 支持泛型，可以限制在一个集合中只能放入同一种数据类型的元素;
    ```java
    List<String> list = new ArrayList<>(); // 只能放入String类型
    ```

Java遗留集合类【了解】
- Hashtable：一种线程安全的Map实现；
- Vector：一种线程安全的List实现；
- Stack：基于Vector实现的LIFO的栈。

## List

数组扩容机制
1. 有参构造函数的时候，会根据传入的参数大小开辟空间；
2. 无参构造函数的时候，会根据默认大小开辟空间；

