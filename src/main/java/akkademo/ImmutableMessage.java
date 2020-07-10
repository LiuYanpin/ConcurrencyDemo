package akkademo;

import java.util.List;

public final class ImmutableMessage {
    private final int sequenceNumber;
    private final List<String> values;

    public ImmutableMessage(int sequenceNumber, List<String> values) {
        this.sequenceNumber = sequenceNumber;
        this.values = values;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public List<String> getValues() {
        return values;
    }
}
