package disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DisruptorMain {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();
        DisruptorPCDataFactory factory = new DisruptorPCDataFactory();
        int bufferSize = 2;
        Disruptor<DisruptorPCData> disruptor = new Disruptor<DisruptorPCData>(factory, bufferSize, executor, ProducerType.MULTI, new BlockingWaitStrategy());
        disruptor.handleEventsWithWorkerPool(new DisruptorConsumer(), new DisruptorConsumer(), new DisruptorConsumer(), new DisruptorConsumer());
        disruptor.start();

        RingBuffer<DisruptorPCData> ringBuffer = disruptor.getRingBuffer();
        DisruptorProducer producer = new DisruptorProducer(ringBuffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (int i = 0; i < 10; i++) {
            byteBuffer.putLong(0, 1);
            producer.pushData(byteBuffer);
            Thread.sleep(100);
            System.out.println("add data " + i);
        }
    }
}
