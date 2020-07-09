import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<PCDate> queue;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCDate> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id=" + Thread.currentThread().getId());
        Random r = new Random();
        try {
            while (true) {
                PCDate data = queue.take();
                if (data != null) {
                    int re = data.getDate() * data.getDate();
                    System.out.println(MessageFormat.format("{0} * {1} = {2}", data.getDate(), data.getDate(), re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
