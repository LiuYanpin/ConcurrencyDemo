package disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public class DisruptorProducer {
    private final RingBuffer<DisruptorPCData> ringBuffer;

    public DisruptorProducer(RingBuffer<DisruptorPCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer byteBuffer) {
        long sequence = ringBuffer.next();
        try {
            DisruptorPCData event = ringBuffer.get(sequence);
            event.set(byteBuffer.getLong(0));
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
