package test.thread;

public class TestMyMain {
    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(() -> {
            System.out.println("自定义屌不屌？？？");
            return "屌！！！！！！！！";
        });
        new Thread(task).start();
        String re = task.get();
        System.out.println(re);
    }
}
