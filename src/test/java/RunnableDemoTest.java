import org.junit.Test;

import static org.junit.Assert.*;

public class RunnableDemoTest {
    @Test
    public void blockedTest() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
//        a.join(1000);
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？a:TIMED_WAITING
        System.out.println(b.getName() + ":" + b.getState()); // 输出？b:BLOCKED

    }
    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}