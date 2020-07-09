package disruptor;

import com.lmax.disruptor.WorkHandler;

public class DisruptorConsumer implements WorkHandler<DisruptorPCData> {
    @Override
    public void onEvent(DisruptorPCData event) throws Exception {
        System.out.println(Thread.currentThread().getId() + ":Event: --" + event.get() * event.get() + "---");
    }
}
