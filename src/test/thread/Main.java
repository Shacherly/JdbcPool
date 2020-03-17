package test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName());
        String name = new Thread(() -> {
            System.out.println("1");
        }).getName();
        System.out.println(name);
        // Callable<String> callable = () -> {
        //     System.out.println("小朋友，你是否有很多问号？");
        //     return "?";
        // };
        FutureTask<String> task = new FutureTask<>(() -> {
            System.out.println("小朋友，你是否有很多问号？");
            return "?";
        });
        new Thread(task).start();
        System.out.println(task.get());

    }
}

