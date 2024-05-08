import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<String> {
    public String call(){
        return "Thread is running...";
    }

    public static void main(String[] args) {
        // 创建callable实现类的实例
        Callable<String> callable = new MyCallable();
        // 创建FutureTask对象，用于包装Callable对象
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        // 创建线程并启动
        Thread thread = new Thread(futureTask);
        thread.start();

        try{
            // 获取线程执行结果
            String result = futureTask.get();
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}