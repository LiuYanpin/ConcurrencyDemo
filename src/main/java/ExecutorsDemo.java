import java.util.concurrent.*;

public class ExecutorsDemo {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        service.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 2, TimeUnit.SECONDS);
    }

    private static void cache() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            service.submit(() -> System.out.println("Thread ID: "
                    + Thread.currentThread().getId()));
        }
    }

    private static void single() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 6; i++) {
            service.submit(() -> System.out.println("Thread ID: " +
                    Thread.currentThread().getName()));
        }
    }

    static CountDownLatch countDownLatch = new CountDownLatch(10);
    private static void stealing() throws InterruptedException {
        ExecutorService service = Executors.newWorkStealingPool(3);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
    }

    private static void fix() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            service.submit(() -> System.out.println("Thread ID: " +
                    Thread.currentThread().getId()));
        }
    }



}
