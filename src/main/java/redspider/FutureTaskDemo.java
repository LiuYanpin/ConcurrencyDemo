package redspider;

import java.util.concurrent.*;

public class FutureTaskDemo {
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(2000);
            return 2;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(new Task());
        service.submit(futureTask);
        System.out.println(futureTask.get());
    }
}
