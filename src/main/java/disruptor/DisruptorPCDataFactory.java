package disruptor;

import com.lmax.disruptor.EventFactory;

public class DisruptorPCDataFactory implements EventFactory<DisruptorPCData> {
    @Override
    public DisruptorPCData newInstance() {
        return new DisruptorPCData();
    }
}
