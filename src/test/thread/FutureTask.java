package test.thread;

public class FutureTask<V> implements Runnable {

    private Callable<V> callable;

    public FutureTask(Callable<V> callable) {
        this.callable = callable;
    }

    private V outcome;

    @Override
    public void run() {
        outcome = callable.run();
    }

    public V get() {
        V res;
        do {
            res = outcome;
        } while (res == null);
        return res;
    }
}
