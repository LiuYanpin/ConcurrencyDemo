public class PCDate {
    private final int intData;

    public PCDate(int intData) {
        this.intData = intData;
    }

    public PCDate(String intData) {
        this.intData = Integer.valueOf(intData);
    }
    public int getDate() {
        return intData;
    }

    @Override
    public String toString() {
        return "data:" + intData;
    }
}

