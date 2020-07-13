package redspider;

public class Signal {
    private static volatile int signal = 0;//这里相当与一个信号量Semaphore
    static class ThreadA implements Runnable {

        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 0) {
                    System.out.println("Thread A: " + signal);
                    signal++;//注意这里需要使用原子操作，使用AtomicInteger代替
                }
            }
        }
    }
    static class ThreadB implements Runnable {

        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 1) {
                    System.out.println("Thread B: " + signal);
                    signal++;//注意这里需要使用原子操作，使用AtomicInteger代替
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }

}
