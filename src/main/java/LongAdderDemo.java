import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderDemo {
    private static final int MAX_THREADS = 3;
    private static final int TASK_COUNT = 3;
    private static final int TARGET_COUNT = 10000000;

    private AtomicLong acount = new AtomicLong(0L);
    private LongAdder lacount = new LongAdder();
    private long count = 0;

    static CountDownLatch cdlsync = new CountDownLatch(TASK_COUNT);
    static CountDownLatch cdlatomic = new CountDownLatch(TASK_COUNT);
    static CountDownLatch cdladdr = new CountDownLatch(TASK_COUNT);

    protected synchronized long inc() {
        return ++count;
    }
    protected synchronized long getCount() {
        return count;
    }
    public static class SyncThread implements Runnable {
        protected String name;
        protected long startTime;
        LongAdderDemo out;

        public SyncThread(long startTime, LongAdderDemo out) {
            this.startTime = startTime;
            this.out = out;
        }

        @Override
        public void run() {

        }
    }
}
